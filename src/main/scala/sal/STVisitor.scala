package sal

import org.antlr.v4.runtime.{CharStreams}
import scala.util.Try
import scala.collection.JavaConverters._
import java.lang.StringBuilder
import scala.collection.mutable.Stack

class STVisitor extends sal.parser.SalParserBaseVisitor[STNode] {
  import sal.parser.SalParser
  import STVisitor._

  private var typeCtx = types.Context()
  private val stack = Stack[types.Context]()
  private val errors = new StringBuilder("\n")

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
    TypeNameNode(types.BuiltInType(ctx.getText()))

  override def visitAllTypes(ctx: SalParser.AllTypesContext): TypeNameNode =
    if (ctx.ARROW_OP() != null)
      if (ctx.typeName != null)
        TypeNameNode(types.FunctionType(visitTypeName(ctx.typeName).salType, visitAllTypes(ctx.allTypes(0)).salType))
      else
        TypeNameNode(types.FunctionType(visitAllTypes(ctx.allTypes(0)).salType, visitAllTypes(ctx.allTypes(1)).salType))
    else
      if (ctx.LEFT_PARENTHESE() != null) visitAllTypes(ctx.allTypes(0))
      else visitTypeName(ctx.typeName)

  override def visitValue(ctx: SalParser.ValueContext) = {
    val name = ctx.ID().getText()
    val exp = visitExpression(ctx.expression)
    val tp = if (ctx.allTypes != null) visitAllTypes(ctx.allTypes) else TypeNameNode(exp.salType)

    try
      typeCtx += (name, tp.salType) // it doesn't format automatically.
    catch {
      case SalException(info) => errors.append(SalException.format(info, ctx.getStart().getLine()))
      case _: Throwable => errors.append(SalException.format("unknown error.", ctx.getStart().getLine()))
    }

    if (!typeCtx.require(name, exp.salType))
      errors.append(SalException.format(
        s"$name got ${exp.salType}, but ${tp.salType} is required.",
        ctx.getStart().getLine()
      ))

    ValueNode(name, tp, exp)
  }

  override def visitExpression(ctx: SalParser.ExpressionContext): ExpressionNode =
    if (ctx.lit != null) ExpressionNode(visitLit(ctx.lit))
    else if (ctx.application != null) ExpressionNode(visitApplication(ctx.application))
    else if (ctx.access != null) ExpressionNode(visitAccess(ctx.access))
    else if (ctx.create != null) ExpressionNode(visitCreate(ctx.create))
    else {
      val name = ctx.ID().getText()
      ExpressionNode(VariableNode(name, typeCtx.query(name)))
    } 

  override def visitBlockInner(ctx: SalParser.BlockInnerContext): STNode with BlockInnerType =
    if (ctx.statement != null) visitStatement(ctx.statement)
    else visitExpression(ctx.expression)

  override def visitBlock(ctx: SalParser.BlockContext) = {
    val states: List[STNode with BlockInnerType] = ctx.blockInner.asScala.toList.map((s) => visitBlockInner(s))
    BlockNode(states, typeCtx.alloc("res", if (states.isEmpty) types.voidType else states.last.salType))
  }

  override def visitFunctionBody(ctx: SalParser.FunctionBodyContext): FunctionBodyNode =
    if (ctx.block != null) FunctionBodyNode(visitBlock(ctx.block))
    else FunctionBodyNode(visitExpression(ctx.expression))

  override def visitParam(ctx: SalParser.ParamContext) = {
    val name = ctx.ID().getText()
    val tp = if(ctx.allTypes != null) visitAllTypes(ctx.allTypes) else TypeNameNode(types.anythingType)
    try { typeCtx += (name, tp.salType) }
    catch {
      case SalException(info) => throw SalException(info, ctx.getStart().getLine())
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
      errors.append(SalException.format(
        s"return value of $name got ${body.salType}, but ${retType.salType} is required.",
        ctx.getStart().getLine()
      ))

    val res = FunctionNode(name, params, retType, body)
    typeCtx = stack.pop()
    try { typeCtx += (name, res.functionType) }
    catch {
      case SalException(info) => throw SalException(info, ctx.getStart().getLine())
    }
    res
  }

  override def visitApplication(ctx: SalParser.ApplicationContext): ApplicationNode = {
    val name = ctx.ID().getText()
    val params = ctx.expression.asScala.toList.map((e) => visitExpression(e))
    val funcType = typeCtx.query(name)

    def matchType(fun: types.Type, index: Int): types.Type = fun match {
      case types.FunctionType(p, r) =>
        if (p === types.voidType && params.isEmpty) r
        else if (index == params.length - 1)
          if (p === params(index).salType) r
          else throw SalException(s"$name's parameters[$index] requires $p, but got ${params(index).salType}.", ctx.getStart().getLine())
        else
          if (p === params(index).salType) matchType(r, index + 1)
          else throw SalException(s"$name's parameters[$index] requires $p, but got ${params(index).salType}.", ctx.getStart().getLine())
      case _ => throw SalException(s"$name is not a function.", ctx.getStart().getLine())
    }

    val retType =
      try { matchType(funcType, 0) }
      catch {
        case SalException(info) => errors.append(info); types.anythingType // shield other type checking.
      }
    def generateRestParams(fun: types.Type): List[String] = fun match {
      case types.FunctionType(p, r) => List(typeCtx.alloc("p", p)) ::: generateRestParams(r)
      case _ => List()
    }

    val rest = generateRestParams(retType)
    rest.foreach((nm) => typeCtx -= nm)
    ApplicationNode(name, params, retType, rest)
  }

  override def visitField(ctx: SalParser.FieldContext): FieldNode =
    if (ctx.function != null) FieldNode(ctx.ID().getText(), visitFunction(ctx.function))
    else if (ctx.expression == null) FieldNode(ctx.ID().getText(), visitAllTypes(ctx.allTypes))
    else FieldNode(ctx.ID().getText(), visitAllTypes(ctx.allTypes), Some(visitExpression(ctx.expression)))

  override def visitFields(ctx: SalParser.FieldsContext) =
    FieldsNode(ctx.field.asScala.toList.map((f) => visitField(f)))

  override def visitRecord(ctx: SalParser.RecordContext): RecordNode =
    if (ctx.fields != null) RecordNode(ctx.ID().getText(), visitFields(ctx.fields))
    else RecordNode(ctx.ID().getText(), FieldsNode(List()))
    

  override def visitAccess(ctx: SalParser.AccessContext): AccessNode = {
    val recName = ctx.ID(0).getText()
    val fieldName = ctx.ID(1).getText()

    try {
      typeCtx.query(recName) match {
        case rt: types.RecordType => AccessNode(recName, fieldName, rt.get(fieldName))
        case _ => throw SalException(s"$recName is not a record.") // format later
      }
    }
    catch {
      case SalException(info) => {
        errors.append(SalException.format(info, ctx.getStart().getLine()))
        AccessNode(recName, fieldName, types.anythingType) // shield other type checking.
      }
    }
  }

  override def visitInitializer(ctx: SalParser.InitializerContext): InitializerNode =
    if (ctx.ID() == null) InitializerNode((None, visitExpression(ctx.expression)))
    else InitializerNode((Some(ctx.ID().getText()), visitExpression(ctx.expression)))

  override def visitCreate(ctx: SalParser.CreateContext): CreateNode = {
    val id = ctx.ID().getText()
    try {
      typeCtx.query(id) match {
        case rt: types.RecordType =>
          CreateNode(rt, ctx.initializer.asScala.toList.map((i) => visitInitializer(i)))
        case _ => throw SalException(s"$id is not a record.") // format later
      }
    }
    catch {
      case SalException(info) => {
        errors.append(SalException.format(info, ctx.getStart().getLine()))
        CreateNode(types.RecordType("", List()), ctx.initializer.asScala.toList.map((i) => visitInitializer(i))) // shield other type checking.
      }
    }
  } 
}

object STVisitor {
  def apply() = new STVisitor()
}