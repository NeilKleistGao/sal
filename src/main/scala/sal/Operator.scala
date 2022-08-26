package sal

object Operator extends Enumeration {
  type Operator = Value
  val LogicNot, BitwiseNot, LeftShift, RightShift, BitwiseAnd,
      BitwiseXor, BitwiseOr, LogicAnd, LogicOr = Value
}

object OperatorParser {
  import sal.parser.SalParser
  import Operator._

  def apply(ctx: SalParser.ExpressionContext): Operator =
    if (ctx.LOGIC_NOT_OP() != null) LogicNot
    else if (ctx.BIT_NOT_OP() != null) BitwiseNot
    else if (ctx.LEFT_SHIFT_OP() != null) LeftShift
    else if (ctx.RIGHT_SHIFT_OP() != null) RightShift
    else if (ctx.BIT_AND_OP() != null) BitwiseAnd
    else if (ctx.BIT_XOR_OP() != null) BitwiseXor
    else if (ctx.BIT_OR_OP() != null) BitwiseOr
    else if (ctx.LOGIC_AND_OP() != null) LogicAnd
    else LogicOr
}