package sal.types

sealed trait Type

case class BuiltInType(name: String) extends Type