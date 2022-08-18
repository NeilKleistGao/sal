package sal

import org.antlr.v4.runtime.{CharStreams}
import scala.util.Try
import scala.collection.JavaConverters._
import java.lang.StringBuilder

class STVisitor extends sal.parser.SalParserBaseVisitor[STNode] {
  import sal.parser.SalParser
  import STVisitor._

  private val typeCtx = types.Context()
  private val errors = new StringBuilder("\n")

  override def visitLit(ctx: SalParser.LitContext) = LitNode(ctx.getText)

  override def visitProgram(ctx: SalParser.ProgramContext) = {
    val list = ctx.statement.asScala.toList.map((s) => visitStatement(s))
    if (errors.length() <= 1)
      ProgramNode(list)
    else throw SalException(errors.toString())
  }

  override def visitStatement(ctx: SalParser.StatementContext) = StatementNode(visitValue(ctx.value))

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
    

  override def visitExpression(ctx: SalParser.ExpressionContext) = ExpressionNode(visitLit(ctx.lit))
}

object STVisitor {
  def apply() = new STVisitor()
}