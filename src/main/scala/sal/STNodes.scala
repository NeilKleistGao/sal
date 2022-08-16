package sal

sealed trait STNode


case class LitNode(value: String) extends STNode {
  override def toString(): String = value
}

case class TypeNameNode(tp: types.Type) extends STNode {
}

// so far only lit is supported
case class ExpressionNode(lit: LitNode) extends STNode {
  override def toString(): String = lit.toString
}

case class ValueNode(id: String, tp: TypeNameNode, expr: ExpressionNode) extends STNode {
  override def toString(): String = s"local $id = $expr"
}

// so far only value is supported
case class StatementNode(v: ValueNode) extends STNode {
  override def toString(): String = v.toString
}

case class ProgramNode(states: List[StatementNode]) extends STNode {
  override def toString(): String =
    states.foldLeft("")((res, s) => s"$res$s\n")
}