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
    else StatementNode(visitFunction(ctx.function))

  override def visitTypeName(ctx: SalParser.TypeNameContext): TypeNameNode =
    TypeNameNode(types.BuiltInType(ctx.getText))

  override def visitValue(ctx: SalParser.ValueContext) = {
    val name = ctx.ID().getText
    val tp = visitTypeName(ctx.typeName)
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
    if (ctx.lit != null) ExpressionNode(Left(visitLit(ctx.lit)))
    else {
      val name = ctx.ID().getText
      ExpressionNode(Right(VariableNode(name, typeCtx.query(name))))
    } 

  override def visitBlockInner(ctx: SalParser.BlockInnerContext): STNode with BlockInnerType =
    if (ctx.statement != null) visitStatement(ctx.statement)
    else visitExpression(ctx.expression)

  override def visitBlock(ctx: SalParser.BlockContext) = {
    val states: List[STNode with BlockInnerType] = ctx.blockInner.asScala.toList.map((s) => visitBlockInner(s))
    BlockNode(states, typeCtx.alloc("res", states.last.salType))
  }

  override def visitFunctionBody(ctx: SalParser.FunctionBodyContext): FunctionBodyNode =
    if (ctx.block != null) FunctionBodyNode(visitBlock(ctx.block))
    else FunctionBodyNode(visitExpression(ctx.expression))

  override def visitParam(ctx: SalParser.ParamContext) =
    ParamNode(ctx.ID().getText, visitTypeName(ctx.typeName))

  override def visitParams(ctx: SalParser.ParamsContext) =
    ParamsNode(ctx.param.asScala.toList.map((p) => visitParam(p)))

  override def visitFunction(ctx: SalParser.FunctionContext) =
    FunctionNode(ctx.ID().getText, visitParams(ctx.params),
     visitTypeName(ctx.typeName), visitFunctionBody(ctx.functionBody))
}

object STVisitor {
  def apply() = new STVisitor()
}