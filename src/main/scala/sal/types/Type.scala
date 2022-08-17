package sal.types

sealed trait Type {
  def ==(other: Type): Boolean = ???
}

case class BuiltInType(name: String) extends Type {
  override def ==(other: Type): Boolean = other match {
    case BuiltInType(nm) => nm.equals(name)
    case _ => false // TODO: support other types
  }
}
