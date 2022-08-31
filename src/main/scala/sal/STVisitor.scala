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

  private var typeCtx = Context()
  private val stack = Stack[Context]()
  private val errors = new StringBuilder("\n")

  private def report(s: String) = errors.append(s)
  private def report(s: String, line: Int) = errors.append(SalException.format(s, line))
  private def at(ctx: ParserRuleContext) = ctx.getStart().getLine()

  override def visitLit(ctx: SalParser.LitContext) = LitNode(ctx.getText())

  override def visitProgram(ctx: SalParser.ProgramContext) = {
    val list = ctx.statement.asScala.toList.map((s) => visitStatement(s))
    if (errors.length() <= 1)
      ProgramNode(list)
    else throw SalException(errors.toString())
  }

  override def visitStatement(ctx: SalParser.StatementContext): StatementNode =
    if (ctx.value != null) StatementNode(visitValue(ctx.value))
    else if (ctx.application != null) StatementNode(visitApplication(ctx.application))
    else if (ctx.record != null) StatementNode(visitRecord(ctx.record))
    else StatementNode(visitFunction(ctx.function))

  override def visitTypeName(ctx: SalParser.TypeNameContext): TypeNameNode =
    TypeNameNode(BuiltInType(ctx.getText()))

  override def visitAllTypes(ctx: SalParser.AllTypesContext): TypeNameNode =
    if (ctx.LEFT_PARENTHESE() != null) visitAllTypes(ctx.allTypes(0))
    else if (ctx.ARROW_OP() != null)
      TypeNameNode(FunctionType(visitAllTypes(ctx.allTypes(0)).salType, visitAllTypes(ctx.allTypes(1)).salType))
    else if (ctx.BIT_OR_OP() != null)
      TypeNameNode(UnionType(visitAllTypes(ctx.allTypes(0)).salType, visitAllTypes(ctx.allTypes(1)).salType))
    else if (ctx.ID() != null) {
      val typeName = ctx.ID().getText()
      val tp: Type = try typeCtx?typeName // it doesn't format automatically.
      catch {
        case SalException(info) => {
          report(info, at(ctx))
          anythingType  // shield other type checking.
        }
      }
      TypeNameNode(tp)
    }
    else visitTypeName(ctx.typeName)

  override def visitValue(ctx: SalParser.ValueContext) = {
    val name = ctx.ID().getText()
    val exp = visitExpression(ctx.expression)
    val tp = if (ctx.allTypes != null) visitAllTypes(ctx.allTypes) else TypeNameNode(exp.salType)

    try
      typeCtx += (name, tp.salType) // it doesn't format automatically.
    catch {
      case SalException(info) => report(info, at(ctx))
      case _: Throwable => report("unknown error.", at(ctx))
    }

    if (!typeCtx.require(name, exp.salType))
      report(s"$name got ${exp.salType}, but ${tp.salType} is required.", at(ctx))

    ValueNode(name, tp, exp)
  }

  override def visitExpression(ctx: SalParser.ExpressionContext): ExpressionNode =
    if (ctx.lit != null) ExpressionNode(visitLit(ctx.lit))
    else if (ctx.LEFT_PARENTHESE() != null) {
      val firstExpIndex = ctx.expression(0).getStart().getTokenIndex()
      val parentheseIndex = ctx.LEFT_PARENTHESE().getSymbol().getTokenIndex()
      if (parentheseIndex < firstExpIndex) // still an expression
        visitExpression(ctx.expression(0))
      else
        ExpressionNode(visitApplicationInExpression(ctx))
    }
    else if (ctx.DOT_OP() != null) ExpressionNode(visitAccess(ctx))
    else if (ctx.create != null) ExpressionNode(visitCreate(ctx.create))
    else if (ctx.ID() != null) {
      val name = ctx.ID().getText()
      ExpressionNode(VariableNode(name, typeCtx.query(name)))
    }
    else {
      import Operator._;

      val op = OperatorParser(ctx)
      val opType = (try typeCtx.query(op)
        catch {
          case SalException(info) =>
            report(info, at(ctx)); FunctionType(anythingType, anythingType) // shield other type checking.
        }).asInstanceOf[FunctionType]

      if (op == Operator.BitwiseNot || op == Operator.LogicNot) {
        val v = visitExpression(ctx.expression(0))
        if (opType !== FunctionType(v.salType, anythingType))
          report(s"operator $op is $opType, but the parameter is ${v.salType}", at(ctx))
        ExpressionNode(UnOpExpression(v, op, opType.resType))
      }
      else {
        val lhs = visitExpression(ctx.expression(0))
        val rhs = visitExpression(ctx.expression(1))
        val trueOpType = typeCtx.query(OperatorParser.convert(op, lhs.salType, rhs.salType)).asInstanceOf[FunctionType]
        if (trueOpType !== FunctionType(lhs.salType, FunctionType(rhs.salType, anythingType)))
          report(s"operator $op is $trueOpType, but parameters are ${lhs.salType} and ${rhs.salType}", at(ctx))
        ExpressionNode(BiOpExpression(lhs, rhs, op, trueOpType.resType))
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
    try typeCtx += (name, tp.salType)
    catch {
      case SalException(info) => report(info, at(ctx))
    }
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
    if (retType.salType !== body.salType)
      report(s"return value of $name got ${body.salType}, but ${retType.salType} is required.", at(ctx))

    val res = FunctionNode(name, params, retType, body)
    typeCtx = stack.pop()
    try typeCtx += (name, res.functionType)
    catch {
      case SalException(info) => report(info, at(ctx))
    }
    res
  }

  private def parseApplication(func: ExpressionNode, params: List[ExpressionNode], line: Int): ApplicationNode = {
    val funcType = func.salType

    def matchType(fun: Type, index: Int): Type = fun match {
      case FunctionType(p, r, _) =>
        if (p === voidType && params.isEmpty) r
        else if (index == params.length - 1)
          if (p === params(index).salType) r
          else throw SalException(s"${func.toLua(0)}'s parameters[$index] requires $p, but got ${params(index).salType}.", line)
        else
          if (p === params(index).salType) matchType(r, index + 1)
          else throw SalException(s"${func.toLua(0)}'s parameters[$index] requires $p, but got ${params(index).salType}.", line)
      case _ => throw SalException(s"${func.toLua(0)} is not a function.", line)
    }

    val retType =
      try matchType(funcType, 0)
      catch {
        case SalException(info) => report(info); anythingType // shield other type checking.
      }

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
    parseApplication(visitExpression(ctx.expression(0)),
      ctx.expression.asScala.toList.drop(1).map((e) => visitExpression(e)), at(ctx))

  private def visitApplicationInExpression(ctx: SalParser.ExpressionContext) =
    parseApplication(visitExpression(ctx.expression(0)),
      ctx.expression.asScala.toList.drop(1).map((e) => visitExpression(e)), at(ctx))

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
      if (tp.salType !== init.salType)
        report(s"field $name requires ${tp.salType}, but got ${init.salType}", at(ctx))
      
      FieldNode(name, tp, Some(init))
    }

  override def visitFields(ctx: SalParser.FieldsContext) = {
    val list = ctx.field.asScala.toList.map((f) => visitField(f))
    stack.push(typeCtx)
    typeCtx = typeCtx.derive()

    try
      list.foreach((n) => typeCtx += (n.id, n.salType))
    catch {
      case SalException(info) => report(info, at(ctx))
    }

    typeCtx = stack.pop()
    FieldsNode(list)
  }

  override def visitRecord(ctx: SalParser.RecordContext) = {
    val newType: RecordNode = 
      if (ctx.fields != null) RecordNode(ctx.ID().getText(), visitFields(ctx.fields))
      else RecordNode(ctx.ID().getText(), FieldsNode(List()))

    typeCtx := newType.salType
    newType
  }
    
  def visitAccess(ctx: SalParser.ExpressionContext): AccessNode = {
    val rec = visitExpression(ctx.expression(0))
    val fieldName = ctx.ID().getText()

    try
      rec.salType match {
        case rt: RecordType => AccessNode(rec, fieldName, rt.get(fieldName))
        case _ => throw SalException(s"${rec.toLua(0)} is not a record.") // format later
      }
    catch {
      case SalException(info) => {
        report(info, at(ctx))
        AccessNode(rec, fieldName, anythingType) // shield other type checking.
      }
    }
  }

  override def visitInitializer(ctx: SalParser.InitializerContext): InitializerNode =
    if (ctx.ID() == null) InitializerNode((None, visitExpression(ctx.expression)))
    else InitializerNode((Some(ctx.ID().getText()), visitExpression(ctx.expression)))

  override def visitCreate(ctx: SalParser.CreateContext): CreateNode = {
    val id = ctx.ID().getText()
    try typeCtx?id match {
      case rt @ RecordType(_, fields) => {
        val inits = ctx.initializer.asScala.toList.map((i) => visitInitializer(i))
        if (inits.length > rt.fields.length)
          throw SalException(s"too many arguments when creating $id") // format later

        val namedInit = inits.filter((i) => !i.param._1.isEmpty).map((i) => (i.param._1.get, i.param._2)).toMap
        val defaultInit = inits.filter((i) => i.param._1.isEmpty).map((i) => i.param._2).iterator

        fields.foreach((f) =>
          if (namedInit.contains(f._1)) {
            if (namedInit(f._1).salType !== f._2)
              throw SalException(s"${f._1} requires ${f._2}, but got ${namedInit(f._1).salType}") // format later
          }
          else if (defaultInit.hasNext) {
            val node = defaultInit.next()
            if (node.salType !== f._2)
              throw SalException(s"${f._1} requires ${f._2}, but got ${node.salType}") // format later
          }
        )

        CreateNode(rt, inits)
      }
        
      case _ => throw SalException(s"$id is not a record.") // format later
    }
    catch {
      case SalException(info) => {
        report(info, at(ctx))
        CreateNode(RecordType("", List()), List()) // shield other type checking.
      }
    }
  } 
}

object STVisitor {
  def apply() = new STVisitor()
}