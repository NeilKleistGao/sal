package sal

object Operator extends Enumeration {
  type Operator = Value
  val Pow, LogicNot, BitwiseNot, Mul, FMul, Div, FDiv, Mod, Add, FAdd, SAdd, Sub, FSub,
      LeftShift, RightShift, Less, Greater, LessEqual, GreaterEqual,
      FLess, FGreater, FLessEqual, FGreaterEqual, SLess, SGreater, SLessEqual, SGreaterEqual,
      BitwiseAnd, BitwiseXor, BitwiseOr, LogicAnd, LogicOr = Value
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
    else if (ctx.LESS_OP() != null) Less
    else if (ctx.GREATER_OP() != null) Greater
    else if (ctx.LE_OP() != null) LessEqual
    else if (ctx.GE_OP() != null) GreaterEqual
    else if (ctx.BIT_AND_OP() != null) BitwiseAnd
    else if (ctx.BIT_XOR_OP() != null) BitwiseXor
    else if (ctx.BIT_OR_OP() != null) BitwiseOr
    else if (ctx.LOGIC_AND_OP() != null) LogicAnd
    else LogicOr


  def convert(op: Operator, lhs: types.Type, rhs: types.Type): Operator = op match {
    case Mul =>
      if ((lhs === types.floatType) || (rhs === types.floatType)) FMul
      else Mul
    case Div =>
      if ((lhs === types.floatType) || (rhs === types.floatType)) FDiv
      else Div
    case Add =>
      if ((lhs === types.floatType) || (rhs === types.floatType)) FAdd
      else if ((lhs === types.stringType) && (rhs === types.stringType)) SAdd
      else Add
    case Sub =>
      if ((lhs === types.floatType) || (rhs === types.floatType)) FSub
      else Sub
    case Less =>
      if ((lhs === types.floatType) || (rhs === types.floatType)) FLess
      else if ((lhs === types.stringType) && (rhs === types.stringType)) SLess
      else Less
    case Greater =>
      if ((lhs === types.floatType) || (rhs === types.floatType)) FGreater
      else if ((lhs === types.stringType) && (rhs === types.stringType)) SGreater
      else Greater
    case LessEqual =>
      if ((lhs === types.floatType) || (rhs === types.floatType)) FLessEqual
      else if ((lhs === types.stringType) && (rhs === types.stringType)) SLessEqual
      else LessEqual
    case GreaterEqual =>
      if ((lhs === types.floatType) || (rhs === types.floatType)) FGreaterEqual
      else if ((lhs === types.stringType) && (rhs === types.stringType)) SGreaterEqual
      else GreaterEqual
    case _ => op
  }
}

object OperatorTranslator {
  import Operator._

  def apply(op: Operator): String = op match {
    case Pow => "^"
    case LogicNot => "not"
    case BitwiseNot => "~"
    case Mul => "*"
    case FMul => "*"
    case Div => "//"
    case FDiv => "/"
    case Mod => "%"
    case Add => "+"
    case FAdd => "+"
    case SAdd => ".."
    case Sub => "-"
    case FSub => "-"
    case LeftShift => "<<"
    case RightShift => ">>"
    case Less => "<"
    case FLess => "<"
    case SLess => "<"
    case Greater => ">"
    case FGreater => ">"
    case SGreater => ">"
    case LessEqual => "<="
    case FLessEqual => "<="
    case SLessEqual => "<="
    case GreaterEqual => ">="
    case FGreaterEqual => ">="
    case SGreaterEqual => ">="
    case BitwiseAnd => "&"
    case BitwiseXor => "~"
    case BitwiseOr => "|"
    case LogicAnd => "and"
    case LogicOr => "or"
  }
}
