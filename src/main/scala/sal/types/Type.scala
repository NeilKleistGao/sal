package sal.types

sealed trait Type {
  def ==(other: Type): Boolean = ???
  def !=(other: Type): Boolean = ! ==(other)
}

case class BuiltInType(name: String) extends Type {
  override def ==(other: Type): Boolean = other match {
    case BuiltInType(nm) => nm.equals(name)
    case _ => false // TODO: support other types
  }

  override def toString(): String = name
}


case class FunctionType(param: Type, res: Type) extends Type {
  override def ==(other: Type): Boolean = other match {
    case FunctionType(p, r) => p == param && r == res
    case _ => false
  }

  override def toString(): String = "" // TODO: translate to Lua
}