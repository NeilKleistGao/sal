package sal

sealed trait STNode {
  lazy val salType: types.Type = ???
  def toLua(indent: Int): String = {
    def prefix(s: String, num: Int): String =
      if (num == 0) s
      else prefix(s"$s  ", num - 1)

    prefix("", indent)
  }
}

sealed trait ResultNode

case class LitNode(value: String) extends STNode {
  override def toLua(indent: Int): String = s"${super.toLua(indent)}$value"

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
  override def toLua(indent: Int): String = lit.toLua(indent)

  override lazy val salType = lit.salType
}

case class ValueNode(id: String, tp: TypeNameNode, expr: ExpressionNode) extends STNode {
  override def toLua(indent: Int): String = s"${super.toLua(indent)}local $id = ${expr.toLua(0)}"

  override lazy val salType = types.BuiltInType("void") // TODO: add true void type
}

// so far only value is supported
case class StatementNode(v: ValueNode) extends STNode {
  override def toLua(indent: Int): String = v.toLua(indent)

  override lazy val salType = v.salType
}

case class ProgramNode(states: List[StatementNode]) extends STNode with ResultNode {
  override def toLua(indent: Int): String =
    states.foldLeft("")((res, s) => s"$res${s.toLua(0)}\n")

  override lazy val salType = states.tail(0).salType
}

case class ErrorNode(errInfo: String) extends ResultNode {
  override def toString(): String = s"--[[$errInfo]]"
}

case class ParamNode(name: String, tp: TypeNameNode) extends STNode {
}

case class ParamsNode(params: List[ParamNode]) extends STNode {
}

case class BlockNode(stats: List[StatementNode]) extends STNode {
  override lazy val salType = stats.tail(0).salType
}

case class FunctionBodyNode(body: Either[StatementNode, BlockNode]) extends STNode {
  override lazy val salType = body match {
    case Left(l) => l.salType
    case Right(r) => r.salType
  }
}

case class FunctionNode(id: String, params: ParamsNode, res: TypeNameNode, body: FunctionBodyNode) extends STNode {
  override lazy val salType = res.salType
}