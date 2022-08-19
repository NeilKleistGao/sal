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
sealed trait FunctionBodyType
sealed trait StatementType

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
case class ExpressionNode(lit: LitNode) extends STNode with FunctionBodyType {
  override def toLua(indent: Int): String = lit.toLua(indent)

  override lazy val salType = lit.salType
}

case class ValueNode(id: String, tp: TypeNameNode, expr: ExpressionNode) extends STNode with StatementType {
  override def toLua(indent: Int): String = s"${super.toLua(indent)}local $id = ${expr.toLua(0)}"

  override lazy val salType = types.BuiltInType("void") // TODO: add true void type
}

case class StatementNode(s: STNode with StatementType) extends STNode {
  override def toLua(indent: Int): String = s.toLua(indent)

  override lazy val salType = s.salType
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
  override lazy val salType = tp.salType
  override def toLua(indent: Int): String = name
}

case class ParamsNode(val params: List[ParamNode]) extends STNode {
  override def toLua(indent: Int): String =
    params.foldLeft("")((r, p) => s"$r, ${p.toLua(0)}").substring(2)
}

case class BlockNode(stats: List[StatementNode], res: String) extends STNode with FunctionBodyType {
  override lazy val salType = stats.tail(0).salType

  override def toLua(indent: Int): String = {
    salType match {
      case types.BuiltInType(name) if (name.equals("void")) =>
        stats.foldLeft("")((r, s) => s"$r\n${s.toLua(indent)}")
      case _ => {
        val body = stats.dropRight(0).foldLeft("")((r, s) => s"$r\n${s.toLua(indent)}")
        s"${super.toLua(indent)}$res = ${stats.tail(0).toLua(0)}"
      }
    }
  }
}

case class FunctionBodyNode(body: STNode with FunctionBodyType) extends STNode {
  override lazy val salType = body.salType

  override def toLua(indent: Int): String = body match {
    case e: ExpressionNode => s"${super.toLua(indent)}return ${e.toLua(0)}"
    case BlockNode(_, res) => s"${body.toLua(indent)}\n${super.toLua(indent)}return $res"
  }
}

case class FunctionNode(id: String, params: ParamsNode, res: TypeNameNode, body: FunctionBodyNode) extends STNode with StatementType {
  //params.params.foldRight(res.salType)((p, t) => types.FunctionType(p.salType, t))
  override lazy val salType = types.BuiltInType("void") // TODO: add true void type
    
  override def toLua(indent: Int): String = {
    val prefix = super.toLua(indent)
    s"${prefix}function $id(${params.toLua(0)})\n${body.toLua(indent + 1)}\n${prefix}"
  }
}