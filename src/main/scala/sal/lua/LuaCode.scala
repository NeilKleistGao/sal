package sal.lua

sealed trait LuaCode

case class LuaProgram(statements: List[LuaCode]) extends LuaCode
