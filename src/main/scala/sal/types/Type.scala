package sal.types

sealed trait Type {
  def ===(other: Type): Boolean = ???
  def !==(other: Type): Boolean = ! ===(other)

  def -->(res: Type) = FunctionType(this, res)
  def \/(other: Type) = UnionType(this, other)

  def as(target: Type): Boolean = ===(target)
  def at(index: Int): Type = ???
}

object PrettyTypePrinter {
  def apply(tp: Type): String = s"type: ${tp}."
}

case object PreservedKeyword extends Type

case class BuiltInType(name: String) extends Type {
  override def ===(other: Type): Boolean = other match {
    case BuiltInType(nm) if (nm.equals("anything")) => true
    case BuiltInType(nm) if (!name.equals("anything")) => nm.equals(name)
    case u: UnionType => u :> this
    case _ if (name.equals("anything")) => true
    case _ => false
  }

  override def toString(): String = name

  override def as(target: Type): Boolean =
    if (name == "anyting") true
    else super.as(target)
}


case class FunctionType(param: Type, res: Type, val paramsCount: Int = -1) extends Type {
  override def ===(other: Type): Boolean = other match {
    case FunctionType(p, r, _) => p === param && r === res
    case BuiltInType(nm) if (nm.equals("anything")) => true
    case u: UnionType => u :> this
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
    case u: UnionType => u :> this
    case _ => false
  }

  override def toString(): String = s"rec $name"

  private lazy val map = fields.map((f) => (f._1, f._2)).toMap

  def get(field: String) = map.getOrElse(field, throw sal.SalException(s"$name doesn't have $field."))
  def contains(name: String) = map.contains(name)
}

case class UnionType(lhs: Type, rhs: Type) extends Type {
  override def ===(other: Type): Boolean = other match {
    case UnionType(l, r) => ((l === lhs) && (r === rhs)) || ((r === lhs) && (l === rhs))
    case BuiltInType(nm) if (nm.equals("anything")) => true
    case _ => :>(other)
  }

  override def toString(): String = s"$lhs | $rhs"

  def :>(other: Type) = (other === lhs) || (other === rhs)

  override def as(target: Type): Boolean =
    if (:>(target)) true
    else super.as(target)
}

case class TupleType(fields: List[Type]) extends Type {
  override def ===(other: Type): Boolean = other match {
    case TupleType(fs) if (fields.length == fs.length) =>
      fields.zip(fs).foldLeft(true)((r, p) => r && (p._1 === p._2))
    case BuiltInType(nm) if (nm.equals("anything")) => true
    case _ => false
  }

  override def toString(): String =
    s"[${fields.map(f => f.toString()).reduceLeft((s, f) => s"$s, $f")}]"

  override def at(index: Int) = fields(index)
}
