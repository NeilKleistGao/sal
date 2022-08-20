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
sealed trait BlockInnerType

case class LitNode(value: String) extends STNode {
  override def toLua(indent: Int): String = s"${super.toLua(indent)}$value"

  override lazy val salType = LitNode.getLitType(value)
}

object LitNode {
  private def getLitType(value: String): types.Type =
    if (value.contains("\"")) types.stringType
    else if (value.equals("true") || value.equals("false")) types.boolType
    else if (value.contains(".")) types.floatType
    else types.intType
}

case class TypeNameNode(tp: types.Type) extends STNode {
  override lazy val salType = tp
}

case class VariableNode(name: String, tp: types.Type) extends STNode {
  override lazy val salType = tp
  override def toLua(indent: Int): String = name
}

case class ExpressionNode(exp: Either[LitNode, VariableNode]) extends STNode with FunctionBodyType with BlockInnerType {
  override def toLua(indent: Int): String = exp match {
    case Left(lit) => lit.toLua(indent)
    case Right(v) => v.toLua(indent)
  }

  override lazy val salType = exp match {
    case Left(lit) => lit.salType
    case Right(v) => v.salType
  }
}

case class ValueNode(id: String, tp: TypeNameNode, expr: ExpressionNode) extends STNode with StatementType {
  override def toLua(indent: Int): String = s"${super.toLua(indent)}local $id = ${expr.toLua(0)}"

  override lazy val salType = types.voidType
}

case class StatementNode(s: STNode with StatementType) extends STNode with BlockInnerType {
  override def toLua(indent: Int): String = s.toLua(indent)

  override lazy val salType = s.salType
}

case class ProgramNode(states: List[StatementNode]) extends STNode with ResultNode {
  override def toLua(indent: Int): String =
    states.foldLeft("")((res, s) => s"$res${s.toLua(0)}\n")

  override lazy val salType = types.voidType
}

case class ErrorNode(errInfo: String) extends ResultNode {
  override def toString(): String = s"--[[$errInfo]]"
}

case class ParamNode(name: String, tp: TypeNameNode) extends STNode {
  override lazy val salType = tp.salType
  override def toLua(indent: Int): String = name
}

case class ParamsNode(val params: List[ParamNode]) extends STNode {
  override def toLua(indent: Int): String = {
    val lua = params.foldLeft("")((r, p) => s"$r, ${p.toLua(0)}")
    if (lua.isEmpty()) lua
    else lua.substring(2)
  }
}

case class BlockNode(stats: List[STNode with BlockInnerType], res: String) extends STNode with FunctionBodyType {
  override lazy val salType =
    if (stats.isEmpty) types.voidType
    else stats.last.salType

  override def toLua(indent: Int): String =
    if (stats.isEmpty) ""
    else salType match {
      case types.BuiltInType(name) if (name.equals("void")) =>
        stats.foldLeft("")((r, s) => s"$r\n${s.toLua(indent)}")
      case _ => {
        val body = stats.dropRight(1).foldLeft("")((r, s) => s"$r\n${s.toLua(indent)}")
        s"$body\n${super.toLua(indent)}$res = ${stats.last.toLua(0)}"
      }
    }
}

case class FunctionBodyNode(body: STNode with FunctionBodyType) extends STNode {
  override lazy val salType = body.salType

  override def toLua(indent: Int): String = {
    val prefix = super.toLua(indent)
    body match {
      case e: ExpressionNode => s"${prefix}return ${e.toLua(0)}"
      case BlockNode(_, res) => s"${prefix}local $res = nil${body.toLua(indent)}\n${prefix}return $res"
    }
  }
}

case class FunctionNode(id: String, params: ParamsNode, res: TypeNameNode, body: FunctionBodyNode) extends STNode with StatementType {
  override lazy val salType = types.voidType
    
  override def toLua(indent: Int): String = {
    val prefix = super.toLua(indent)
    s"${prefix}function $id(${params.toLua(0)})\n${body.toLua(indent + 1)}\n${prefix}end"
  }

  val functionType = params.params.foldRight(res.salType)((p, t) => types.FunctionType(p.salType, t))
}