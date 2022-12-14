package sal

import org.antlr.v4.runtime.{CharStreams, ParserRuleContext}
import scala.util.Try
import scala.jdk.CollectionConverters._
import java.lang.StringBuilder
import scala.collection.mutable.Stack

class STVisitor extends sal.parser.SalParserBaseVisitor[STNode] {
  import sal.parser.SalParser
  import types._
  import scala.language.postfixOps

  implicit private var typeCtx = Context()
  private val stack = Stack[Context]()
  private val errors = new StringBuilder("\n")
  private val typer = Typer()

  private def report(s: String) = errors.append(s)
  private def report(s: String, line: Int) = errors.append(SalException.format(s, line))
  private def at(ctx: ParserRuleContext) = ctx.getStart().getLine()

  override def visitLit(ctx: SalParser.LitContext) = LitNode(ctx.getText())

  override def visitProgram(ctx: SalParser.ProgramContext) = {
    val list = ctx.statement.asScala.toList.map((s) => visitStatement(s))
    typer.checkImplementation()
    typer.getErrorMessage() match {
      case Some(err) => throw SalException(err.toString())
      case _ => ProgramNode(list)
    }
  }

  override def visitStatement(ctx: SalParser.StatementContext): StatementNode =
    if (ctx.value != null) StatementNode(visitValue(ctx.value))
    else if (ctx.application != null) StatementNode(visitApplication(ctx.application))
    else if (ctx.record != null) StatementNode(visitRecord(ctx.record))
    else if (ctx.ifCondition != null) StatementNode(visitIfCondition(ctx.ifCondition))
    else if (ctx.forwardDec != null) StatementNode(visitForwardDec(ctx.forwardDec))
    else StatementNode(visitFunction(ctx.function))

  override def visitTypeName(ctx: SalParser.TypeNameContext): TypeNameNode =
    TypeNameNode(BuiltInType(ctx.getText()))

  override def visitAllTypes(ctx: SalParser.AllTypesContext): TypeNameNode =
    if (ctx.LEFT_PARENTHESE() != null) visitAllTypes(ctx.allTypes(0))
    else if (ctx.LEFT_SQUARE() != null)
      TypeNameNode(TupleType(ctx.allTypes.asScala.toList.map(f => visitAllTypes(f).salType)))
    else if (ctx.ARROW_OP() != null)
      TypeNameNode(FunctionType(visitAllTypes(ctx.allTypes(0)).salType, visitAllTypes(ctx.allTypes(1)).salType))
    else if (ctx.BIT_OR_OP() != null)
      TypeNameNode(UnionType(visitAllTypes(ctx.allTypes(0)).salType, visitAllTypes(ctx.allTypes(1)).salType))
    else if (ctx.ID() != null) {
      val typeName = ctx.ID().getText()
      TypeNameNode(typer.getTypeName(ctx, typeName))
    }
    else visitTypeName(ctx.typeName)

  override def visitValue(ctx: SalParser.ValueContext) = {
    val name = ctx.ID().getText()
    val exp = visitExpression(ctx.expression)
    val tp = if (ctx.allTypes != null) visitAllTypes(ctx.allTypes) else TypeNameNode(exp.salType)
    typer.addType(ctx, name, tp.salType, exp.salType)
    ValueNode(name, tp, exp)
  }

  override def visitExpression(ctx: SalParser.ExpressionContext): ExpressionNode =
    if (ctx.lit != null && ctx.LEFT_SQUARE() == null) ExpressionNode(visitLit(ctx.lit))
    else if (ctx.LEFT_PARENTHESE() != null) {
      val firstExpIndex = ctx.expression(0).getStart().getTokenIndex()
      val parentheseIndex = ctx.LEFT_PARENTHESE().getSymbol().getTokenIndex()
      if (parentheseIndex < firstExpIndex) // still an expression
        visitExpression(ctx.expression(0))
      else
        ExpressionNode(visitApplicationInExpression(ctx))
    }
    else if (ctx.allTypes != null) {
      val exp = visitExpression(ctx.expression(0))
      val target = visitAllTypes(ctx.allTypes).salType
      ExpressionNode(exp.exp, Some(typer.assertType(ctx, exp.salType, target)))
    }
    else if (ctx.LEFT_SQUARE() != null) {
      val firstExpIndex = ctx.expression(0).getStart().getTokenIndex()
      val squareIndex = ctx.LEFT_SQUARE().getSymbol().getTokenIndex()
      if (firstExpIndex > squareIndex)
        ExpressionNode(TupleNode(ctx.expression.asScala.toList.map(e => visitExpression(e))))
      else {
        val tup = visitExpression(ctx.expression(0))
        val index = visitLit(ctx.lit)
        if (typer.checkIndex(ctx, tup.salType, index))
          ExpressionNode(IndexedNode(tup, index.toInt))
        else tup
      }
    }
    else if (ctx.lambda != null) ExpressionNode(visitLambda(ctx.lambda))
    else if (ctx.DOT_OP() != null) ExpressionNode(visitSelection(ctx))
    else if (ctx.create != null) ExpressionNode(visitCreate(ctx.create))
    else if (ctx.ifCondition != null) ExpressionNode(visitIfCondition(ctx.ifCondition))
    else if (ctx.ID() != null) {
      val name = ctx.ID().getText()
      ExpressionNode(VariableNode(name, typeCtx.query(name)))
    }
    else {
      import Operator._;

      val op = OperatorParser(ctx)
      val opType = typer.getOperatorType(ctx, op)

      if (op == Operator.BitwiseNot || op == Operator.LogicNot) {
        val v = visitExpression(ctx.expression(0))
        typer.checkOperatorParameters(ctx, op, v.salType, opType)
        typer.excludeNix(ctx, v)
        ExpressionNode(UnOpExpression(v, op, opType.resType))
      }
      else {
        val lhs = visitExpression(ctx.expression(0))
        val rhs = visitExpression(ctx.expression(1))
        val trueOp = OperatorParser.convert(op, lhs.salType, rhs.salType)
        val trueOpType = typeCtx.query(trueOp).asInstanceOf[FunctionType]
        typer.checkOperatorParameters(ctx, trueOp, lhs.salType, rhs.salType, trueOpType)
        typer.excludeNix(ctx, lhs)
        typer.excludeNix(ctx, rhs)
        ExpressionNode(BiOpExpression(lhs, rhs, trueOp, trueOpType.resType))
      }
    }

  override def visitBlockInner(ctx: SalParser.BlockInnerContext): STNode with BlockInnerType =
    if (ctx.statement != null) visitStatement(ctx.statement)
    else visitExpression(ctx.expression)

  override def visitBlock(ctx: SalParser.BlockContext) = {
    val states: List[STNode with BlockInnerType] = ctx.blockInner.asScala.toList.map((s) => visitBlockInner(s))
    BlockNode(states, typeCtx.alloc("res", if (states.isEmpty) voidType else states.last.salType))
  }

  override def visitFunctionBody(ctx: SalParser.FunctionBodyContext): FunctionBodyNode =
    if (ctx.block != null) FunctionBodyNode(visitBlock(ctx.block))
    else FunctionBodyNode(visitExpression(ctx.expression))

  override def visitParam(ctx: SalParser.ParamContext) = {
    val name = ctx.ID().getText()
    val tp = if(ctx.allTypes != null) visitAllTypes(ctx.allTypes) else TypeNameNode(anythingType)
    typer.addType(ctx, name, tp.salType, anythingType)
    ParamNode(name, tp)
  }

  override def visitParams(ctx: SalParser.ParamsContext) =
    ParamsNode(ctx.param.asScala.toList.map((p) => visitParam(p)))

  override def visitFunction(ctx: SalParser.FunctionContext) = {
    stack.push(typeCtx)
    typeCtx = typeCtx.derive()

    val name = ctx.ID().getText()
    val params = visitParams(ctx.params)
    val body = visitFunctionBody(ctx.functionBody)
    val retType = if (ctx.allTypes != null) visitAllTypes(ctx.allTypes) else TypeNameNode(body.salType)
    val res = FunctionNode(name, params, retType, body)
    typeCtx = stack.pop()
    typer.addFunction(ctx, name, retType.salType, body.salType, res.functionType)
    res
  }

  private def parseApplication(ctx: ParserRuleContext, func: ExpressionNode, params: List[ExpressionNode]): ApplicationNode = {
    val funcType = func.salType
    val retType = typer.getApplicationType(ctx, func, funcType, params)

    funcType match {
      case f: FunctionType => {
        def generateRestParams(fun: Type, index: Int): List[String] = fun match {
          case FunctionType(p, r, _) if (index < f.paramsCount) => List(typeCtx.alloc("p", p)) ::: generateRestParams(r, index + 1)
          case _ => List()
        }
      
        val rest = generateRestParams(retType, params.length)
        rest.foreach((nm) => typeCtx -= nm)
        ApplicationNode(func, params, retType, rest)
      }
      case _ => ApplicationNode(func, params, retType, List())
    }
  }

  override def visitApplication(ctx: SalParser.ApplicationContext) =
    parseApplication(ctx, visitExpression(ctx.expression(0)),
      ctx.expression.asScala.toList.drop(1).map((e) => visitExpression(e)))

  private def visitApplicationInExpression(ctx: SalParser.ExpressionContext) =
    parseApplication(ctx, visitExpression(ctx.expression(0)),
      ctx.expression.asScala.toList.drop(1).map((e) => visitExpression(e)))

  override def visitField(ctx: SalParser.FieldContext): FieldNode =
    if (ctx.function != null) {
      val func = visitFunction(ctx.function)
      typeCtx -= func.id // no need to create an variable here
      FieldNode("", func)
    }
    else if (ctx.expression == null) FieldNode(ctx.ID().getText(), visitAllTypes(ctx.allTypes))
    else {
      val name = ctx.ID().getText()
      val tp = visitAllTypes(ctx.allTypes)
      val init = visitExpression(ctx.expression)
      typer.checkField(ctx, name, tp.salType, init.salType)
      
      FieldNode(name, tp, Some(init))
    }

  private def visitRecFields(ctx: SalParser.FieldsContext) = {
    val list = ctx.field.asScala.toList.map((f) => visitField(f))
    stack.push(typeCtx)
    typeCtx = typeCtx.derive()
    typer.addFields(ctx, list)
    typeCtx = stack.pop()
    list
  }

  override def visitRecord(ctx: SalParser.RecordContext) = {
    val names = ctx.ID().asScala.toList.map(id => id.getText())
    val mixin = visitWith(ctx)
    val fields =
      if (ctx.fields != null) visitRecFields(ctx.fields)
      else List()
    val newType = RecordNode(names(0), FieldsNode(typer.mixRecords(ctx, fields, mixin)))

    typeCtx := newType.salType
    newType
  }

  private def visitWith(ctx: SalParser.RecordContext) =
    ctx.ID().asScala.toList.drop(1).map(id => id.getText())
    
  private def visitSelection(ctx: SalParser.ExpressionContext): SelectionNode = {
    val rec = visitExpression(ctx.expression(0))
    val fieldName = ctx.ID().getText()

    SelectionNode(rec, fieldName, typer.getFieldType(ctx, rec, fieldName, rec.salType))
  }

  override def visitInitializer(ctx: SalParser.InitializerContext): InitializerNode =
    if (ctx.ID() == null) InitializerNode((None, visitExpression(ctx.expression)))
    else InitializerNode((Some(ctx.ID().getText()), visitExpression(ctx.expression)))

  override def visitCreate(ctx: SalParser.CreateContext): CreateNode = {
    val id = ctx.ID().getText()
    val initList = ctx.initializer.asScala.toList.map((i) => visitInitializer(i))
    val initializer = typer.getInitializer(ctx, id, initList)
    CreateNode(initializer._1, initializer._2)
  }

  override def visitIfCondition(ctx: SalParser.IfConditionContext) = {
    val condition = visitExpression(ctx.expression(0))
    typer.checkIfElse(ctx, condition.salType)

    stack.push(typeCtx)
    typeCtx = typeCtx.derive()
    val body: STNode with FunctionBodyType =
      if (ctx.block != null) visitBlock(ctx.block) else visitExpression(ctx.expression(1))
    typeCtx = stack.pop()
    
    val elseIfList: List[STNode with ElseBlockType] =
      if (ctx.elseIfCondition == null) List()
      else ctx.elseIfCondition.asScala.toList.map((b) => visitElseIfCondition(b))
    
    val elseList: List[STNode with ElseBlockType] =
      if (ctx.elseBlock == null) elseIfList else elseIfList :+ visitElseBlock(ctx.elseBlock)
    val resType = IfConditionNode(condition, body, elseList, "").salType
    val resName = typeCtx.alloc("if_res", resType)

    val finalBody = body match {
      case b: BlockNode => b.rename(resName)
      case _ => body
    }

    IfConditionNode(condition, finalBody, elseList.map((i) => i match {
      case IfConditionNode(cond, body, _, _) => body match {
        case b: BlockNode => IfConditionNode(cond, b.rename(resName), List(), "")
        case _ => IfConditionNode(cond, body, List(), "")
      }
      case b: BlockNode => b.rename(resName)
      case _ => i
    }), resName)
  }

	override def visitElseIfCondition(ctx: SalParser.ElseIfConditionContext) = {
    val condition = visitExpression(ctx.expression(0))
    typer.checkIfElse(ctx, condition.salType)

    stack.push(typeCtx)
    typeCtx = typeCtx.derive()
    val res =
      if (ctx.block != null) IfConditionNode(condition, visitBlock(ctx.block), List(), "")
      else IfConditionNode(condition, visitExpression(ctx.expression(1)), List(), "")
    typeCtx = stack.pop()
    res
  }

	override def visitElseBlock(ctx: SalParser.ElseBlockContext) = {
    stack.push(typeCtx)
    typeCtx = typeCtx.derive()
    val res =
      if (ctx.block != null) visitBlock(ctx.block)
      else visitExpression(ctx.expression)
    typeCtx = stack.pop()
    res
  }

  override def visitLambda(ctx: SalParser.LambdaContext) = {
    stack.push(typeCtx)
    typeCtx = typeCtx.derive()

    val params = visitParams(ctx.params)
    val exp = visitExpression(ctx.expression)
    val retType = if (ctx.allTypes != null) visitAllTypes(ctx.allTypes) else TypeNameNode(exp.salType)
    typer.checkLambda(ctx, exp.salType, retType.salType)

    typeCtx = stack.pop()
    LambdaNode(params, retType, exp)
  }

  override def visitForwardDec(ctx: SalParser.ForwardDecContext): STNode with StatementType =
    if (ctx.FUN_KW() != null) {
      stack.push(typeCtx)
      typeCtx = typeCtx.derive()

      val name = ctx.ID().getText()
      val params = visitParams(ctx.params)
      val retType = visitAllTypes(ctx.allTypes)
      val res =
        if (params.params.isEmpty) FunctionType(voidType, retType.salType, 0)
        else params.params.foldRight(retType.salType)((p, t) => FunctionType(p.salType, t, params.params.length))
      typeCtx = stack.pop()
      typer.addFunctionDeclaration(ctx, name, res)
      EmptyNode
    }
    else {
      typer.addRecordDeclaration(ctx, ctx.ID().getText())
      EmptyNode
    }
}

object STVisitor {
  def apply() = new STVisitor()
}
