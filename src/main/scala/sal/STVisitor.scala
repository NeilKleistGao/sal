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

  override def visitLit(ctx: SalParser.LitContext) = LitNode(ctx.getText)

  override def visitProgram(ctx: SalParser.ProgramContext) = {
    val list = ctx.statement.asScala.toList.map((s) => visitStatement(s))
    if (errors.length() <= 1)
      ProgramNode(list)
    else throw SalException(errors.toString())
  }

  override def visitStatement(ctx: SalParser.StatementContext): StatementNode =
    if (ctx.value != null) StatementNode(visitValue(ctx.value))
    else if (ctx.application != null) StatementNode(visitApplication(ctx.application))
    else StatementNode(visitFunction(ctx.function))

  override def visitTypeName(ctx: SalParser.TypeNameContext): TypeNameNode =
    TypeNameNode(types.BuiltInType(ctx.getText))

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
    val name = ctx.ID().getText
    val tp = visitAllTypes(ctx.allTypes)
    val exp = visitExpression(ctx.expression)

    try
      typeCtx += (name, tp.salType)
    catch {
      case SalException(info) => errors.append(s"  $info\n")
      case _: Throwable => errors.append("  unknown error.\n")
    }

    if (!typeCtx.require(name, exp.salType))
      errors.append(s"  $name got ${exp.salType}, but ${tp.salType} is required.\n")

    ValueNode(name, tp, exp)
  }

  override def visitExpression(ctx: SalParser.ExpressionContext): ExpressionNode =
    if (ctx.lit != null) ExpressionNode(visitLit(ctx.lit))
    else if (ctx.application != null) ExpressionNode(visitApplication(ctx.application))
    else {
      val name = ctx.ID().getText
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
    val name = ctx.ID().getText
    val tp = visitAllTypes(ctx.allTypes)
    typeCtx += (name, tp.salType)
    ParamNode(name, tp)
  }

  override def visitParams(ctx: SalParser.ParamsContext) =
    ParamsNode(ctx.param.asScala.toList.map((p) => visitParam(p)))

  override def visitFunction(ctx: SalParser.FunctionContext) = {
    stack.push(typeCtx)
    typeCtx = typeCtx.derive()

    val name = ctx.ID().getText
    val params = visitParams(ctx.params)
    val retType = visitAllTypes(ctx.allTypes)
    val body = visitFunctionBody(ctx.functionBody)
    if (retType.salType !== body.salType)
      errors.append(s"  return value of $name got ${body.salType}, but ${retType.salType} is required.\n")

    val res = FunctionNode(name, params, retType, body)
    typeCtx = stack.pop()
    typeCtx += (name, res.functionType)
    res
  }

  override def visitApplication(ctx: SalParser.ApplicationContext): ApplicationNode = {
    val name = ctx.ID().getText
    val params = ctx.expression.asScala.toList.map((e) => visitExpression(e))
    val funcType = typeCtx.query(name)

    def matchType(fun: types.Type, index: Int): types.Type = fun match {
      case types.FunctionType(p, r) =>
        if (p === types.voidType && params.isEmpty) r
        else if (index == params.length - 1)
          if (p === params(index).salType) r
          else throw SalException(s"$name's parameters[$index] requires $p, but got ${params(index).salType}.")
        else
          if (p === params(index).salType) matchType(r, index + 1)
          else throw SalException(s"$name's parameters[$index] requires $p, but got ${params(index).salType}.")
      case _ => throw SalException(s"$name is not a function.")
    }

    val retType =
      try { matchType(funcType, 0) }
      catch {
        case SalException(info) => errors.append(s"  $info\n"); types.anythingType // shield other type checking.
      }
    def generateRestParams(fun: types.Type): List[String] = fun match {
      case types.FunctionType(p, r) => List(typeCtx.alloc("p", p)) ::: generateRestParams(r)
      case _ => List()
    }

    val rest = generateRestParams(retType)
    rest.foreach((nm) => typeCtx -= nm)
    ApplicationNode(name, params, retType, rest)
  }
}

object STVisitor {
  def apply() = new STVisitor()
}