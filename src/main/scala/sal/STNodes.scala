package sal

sealed trait STNode {
  lazy val salType: types.Type = ???
}

case class LitNode(value: String) extends STNode {
  override def toString(): String = value

  override lazy val salType = LitNode.getLitType(value)
}

object LitNode {
  private def getLitType(value: String): types.Type =
    if (value.contains("\"")) types.BuiltInType("string")
    else if (value.equals("true") || value.equals("false")) types.BuiltInType("bool")
    else if (value.contains(".")) types.BuiltInType("float")
    else types.BuiltInType("int")
}

case class TypeNameNode(tp: types.Type) extends STNode {
  override lazy val salType = tp
}

// so far only lit is supported
case class ExpressionNode(lit: LitNode) extends STNode {
  override def toString(): String = lit.toString

  override lazy val salType = lit.salType
}

case class ValueNode(id: String, tp: TypeNameNode, expr: ExpressionNode) extends STNode {
  override def toString(): String = s"local $id = $expr"

  override lazy val salType = types.BuiltInType("void") // TODO: add true void type
}

// so far only value is supported
case class StatementNode(v: ValueNode) extends STNode {
  override def toString(): String = v.toString

  override lazy val salType = v.salType
}

case class ProgramNode(states: List[StatementNode]) extends STNode {
  override def toString(): String =
    states.foldLeft("")((res, s) => s"$res$s\n")

  override lazy val salType = states.tail(0).salType
}