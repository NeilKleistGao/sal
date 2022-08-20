package sal.types

sealed trait Type {
  def ==(other: Type): Boolean = ???
  def !=(other: Type): Boolean = ! ==(other)
}

case class BuiltInType(name: String) extends Type {
  override def ==(other: Type): Boolean = other match {
    case BuiltInType(nm) if (nm.equals("anything")) => true
    case BuiltInType(nm) if (!name.equals("anything")) => nm.equals(name)
    case _ if (name.equals("anything")) => true
    case _ => false
  }

  override def toString(): String = name
}


case class FunctionType(param: Type, res: Type) extends Type {
  override def ==(other: Type): Boolean = other match {
    case FunctionType(p, r) => p == param && r == res
    case BuiltInType(nm) if (nm.equals("anything")) => true
    case _ => false
  }

  override def toString(): String = s"$param -> $res"
}