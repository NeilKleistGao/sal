package sal.types

sealed trait Type {
  def ===(other: Type): Boolean = ???
  def !==(other: Type): Boolean = ! ===(other)
}

object PrettyTypePrinter {
  def apply(tp: Type): String = s"--[[type: ${tp}]]"
}

case object PreservedKeyword extends Type

case class BuiltInType(name: String) extends Type {
  override def ===(other: Type): Boolean = other match {
    case BuiltInType(nm) if (nm.equals("anything")) => true
    case BuiltInType(nm) if (!name.equals("anything")) => nm.equals(name)
    case _ if (name.equals("anything")) => true
    case _ => false
  }

  override def toString(): String = name
}


case class FunctionType(param: Type, res: Type, val paramsCount: Int = -1) extends Type {
  override def ===(other: Type): Boolean = other match {
    case FunctionType(p, r, _) => p === param && r === res
    case BuiltInType(nm) if (nm.equals("anything")) => true
    case _ => false
  }

  override def toString(): String = param match {
    case f: FunctionType => s"($param) -> $res"
    case _ => s"$param -> $res"
  }

  lazy val resType: Type = res match {
    case f: FunctionType => f.resType
    case _ => res
  }
}

case class RecordType(val name: String, val fields: List[(String, Type)]) extends Type {
  override def ===(other: Type): Boolean = other match {
    case RecordType(nm, _) => name.equals(nm)
    case BuiltInType(nm) if (nm.equals("anything")) => true
    case _ => false
  }

  override def toString(): String = s"rec $name"

  private lazy val map = fields.map((f) => (f._1, f._2)).toMap

  def get(field: String) = map.getOrElse(field, throw sal.SalException(s"$name doesn't have $field."))
}

case class UnionType(lhs: Type, rhs: Type) extends Type {
    override def ===(other: Type): Boolean = other match {
    case UnionType(l, r) => ((l === lhs) && (r === rhs)) || ((r === lhs) && (l === rhs))
    case BuiltInType(nm) if (nm.equals("anything")) => true
    case _ => false
  }

  override def toString(): String = s"$lhs | $rhs"

  def :>(other: Type) = (other === lhs) || (other === rhs)
} 