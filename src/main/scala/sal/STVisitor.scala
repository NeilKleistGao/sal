package sal

import org.antlr.v4.runtime.{CharStreams}
import scala.util.Try
import scala.collection.JavaConverters._

class STVisitor extends sal.parser.SalParserBaseVisitor[STNode] {
  import sal.parser.SalParser
  import STVisitor._

  private val typeCtx = types.Context()

  override def visitLit(ctx: SalParser.LitContext) = LitNode(ctx.getText)

  override def visitProgram(ctx: SalParser.ProgramContext) =
    ProgramNode(ctx.statement.asScala.toList.map((s) => visitStatement(s)))

  override def visitStatement(ctx: SalParser.StatementContext) = StatementNode(visitValue(ctx.value))

  override def visitTypeName(ctx: SalParser.TypeNameContext): TypeNameNode =
    TypeNameNode(types.BuiltInType(ctx.getText))

  override def visitValue(ctx: SalParser.ValueContext) = {
    val name = ctx.ID().getText
    val tp = visitTypeName(ctx.typeName)
    val exp = visitExpression(ctx.expression)
    typeCtx += (name, tp.salType)
    if (!typeCtx.require(name, exp.salType))
      throw new java.lang.Exception(s"$name got ${exp.salType}, but ${tp.salType} is requireed.")

    ValueNode(name, tp, exp)
  }
    

  override def visitExpression(ctx: SalParser.ExpressionContext) = ExpressionNode(visitLit(ctx.lit))
}

object STVisitor {
  def apply() = new STVisitor()
}