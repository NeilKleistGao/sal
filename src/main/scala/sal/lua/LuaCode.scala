package sal.lua

sealed trait LuaCode {
  def show(implicit indent: String) = ???
}

case class LuaProgram(statements: List[LuaCode]) extends LuaCode
case class LuaAssign(name: String, value: LuaCode, isLocal: Boolean) extends LuaCode
case class LuaBlock(codes: LuaCode) extends LuaCode
case class LuaFunction(name: String, params: List[String], body: LuaBlock) extends LuaCode
case class LuaLit(value: String) extends LuaCode
case class LuaApplication(fun: LuaCode, params: List[LuaCode]) extends LuaCode
case class LuaReturn(res: LuaCode) extends LuaCode
case class LuaIf(cond: LuaCode, body: LuaBlock, isElseIf: Boolean) extends LuaCode
case class LuaElse(body: LuaBlock) extends LuaCode
case class LuaVariable(name: String) extends LuaCode
case class LuaIndex(obj: LuaCode, index: LuaCode) extends LuaCode
case class LuaUnaryOperator(op: String, exp: LuaCode) extends LuaCode
case class LuaBinaryOperator(op: String, lhs: LuaCode, rhs: LuaCode) extends LuaCode

case object LuaEnd extends LuaCode
