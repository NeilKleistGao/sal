package sal

sealed trait STNode

// so far only int is supported
case class LitNode(value: Int) extends STNode

case class TypeNameNode(tp: types.Type) extends STNode

// so far only lit is supported
case class ExpressionNode(lit: LitNode) extends STNode
case class ValueNode(id: String, tp: TypeNameNode, expr: ExpressionNode) extends STNode

// so far only value is supported
case class StatementNode(v: ValueNode) extends STNode

case class ProgramNode(states: List[StatementNode]) extends STNode