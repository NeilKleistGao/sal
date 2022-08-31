package sal

object Operator extends Enumeration {
  type Operator = Value
  val Pow, LogicNot, BitwiseNot, Mul, FMul, Div, FDiv, Mod, Add, FAdd, SAdd, Sub, FSub,
      LeftShift, RightShift, BitwiseAnd, BitwiseXor, BitwiseOr, LogicAnd, LogicOr = Value
}

object OperatorParser {
  import sal.parser.SalParser
  import Operator._

  def apply(ctx: SalParser.ExpressionContext): Operator =
    if (ctx.POW_OP() != null) Pow
    else if (ctx.LOGIC_NOT_OP() != null) LogicNot
    else if (ctx.BIT_NOT_OP() != null) BitwiseNot
    else if (ctx.MUL_OP() != null) Mul
    else if (ctx.DIV_OP() != null) Div
    else if (ctx.MOD_OP() != null) Mod
    else if (ctx.ADD_OP() != null) Add
    else if (ctx.SUB_OP() != null) Sub
    else if (ctx.LEFT_SHIFT_OP() != null) LeftShift
    else if (ctx.RIGHT_SHIFT_OP() != null) RightShift
    else if (ctx.BIT_AND_OP() != null) BitwiseAnd
    else if (ctx.BIT_XOR_OP() != null) BitwiseXor
    else if (ctx.BIT_OR_OP() != null) BitwiseOr
    else if (ctx.LOGIC_AND_OP() != null) LogicAnd
    else LogicOr



}

object OperatorTranslator {
  import Operator._

  def apply(op: Operator): String = op match {
    case LogicNot => "not"
    case BitwiseNot => "~"
    case LeftShift => "<<"
    case RightShift => ">>"
    case BitwiseAnd => "&"
    case BitwiseXor => "~"
    case BitwiseOr => "|"
    case LogicAnd => "and"
    case LogicOr => "or"
  }
}