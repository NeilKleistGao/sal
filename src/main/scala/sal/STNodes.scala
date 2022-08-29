package sal

import Operator._;
import types._;

sealed trait STNode {
  lazy val salType: types.Type = ???
  def toLua(indent: Int): String = ???
}

object Prefix {
  def apply(indent: Int): String = {
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
sealed trait ExpressionType
sealed trait FieldType

case class LitNode(value: String) extends STNode with ExpressionType {
  override def toLua(indent: Int): String =
    if (value.equals("nix")) s"${Prefix(indent)}nil"
    else s"${Prefix(indent)}$value"

  override lazy val salType = LitNode.getLitType(value)
}

object LitNode {
  private def getLitType(value: String): types.Type =
    if (value.contains("\"")) types.stringType
    else if (value.equals("true") || value.equals("false")) types.boolType
    else if (value.contains(".")) types.floatType
    else if (value.equals("nix")) types.anythingType
    else types.intType
}

case class TypeNameNode(tp: types.Type) extends STNode with FieldType {
  override lazy val salType = tp
}

case class VariableNode(name: String, tp: types.Type) extends STNode with ExpressionType {
  override lazy val salType = tp
  override def toLua(indent: Int): String = name
}

case class ExpressionNode(val exp: STNode with ExpressionType) extends STNode with FunctionBodyType with BlockInnerType {
  override def toLua(indent: Int): String = exp.toLua(indent)

  override lazy val salType = exp.salType
}

case class ValueNode(id: String, tp: TypeNameNode, expr: ExpressionNode) extends STNode with StatementType {
  override def toLua(indent: Int): String = s"${Prefix(indent)}local $id = ${expr.toLua(0)} ${PrettyTypePrinter(tp.salType)}"

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
  override def toLua(indent: Int): String =
    if (params.isEmpty) ""
    else params.map((p) => p.toLua(0)).reduceLeft((r, p) => s"$r, $p")
}

case class BlockNode(stats: List[STNode with BlockInnerType], res: String) extends STNode with FunctionBodyType {
  override lazy val salType =
    if (stats.isEmpty) types.voidType
    else stats.last.salType

  private def translateBlock(lst: List[STNode with BlockInnerType], indent: Int): String =
    lst.foldLeft("")((r, s) => s match {
        case e: ExpressionNode => s"$r\n${Prefix(indent)}local _ = ${s.toLua(0)}"
        case _ => s"$r\n${s.toLua(indent)}"
      })

  override def toLua(indent: Int): String =
    if (stats.isEmpty) ""
    else salType match {
      case types.BuiltInType(name) if (name.equals("void")) =>
        translateBlock(stats, indent)
      case _ => {
        val body = translateBlock(stats.dropRight(1), indent)
        s"$body\n${Prefix(indent)}$res = ${stats.last.toLua(0)}"
      }
    }
}

case class FunctionBodyNode(body: STNode with FunctionBodyType) extends STNode {
  override lazy val salType = body.salType

  override def toLua(indent: Int): String =
    body match {
      case e: ExpressionNode => s"${Prefix(indent)}return ${e.toLua(0)}"
      case BlockNode(_, res) => s"${Prefix(indent)}local $res = nil${body.toLua(indent)}\n${Prefix(indent)}return $res"
    }
}

case class FunctionNode(val id: String, params: ParamsNode, res: TypeNameNode, body: FunctionBodyNode)
  extends STNode with StatementType with FieldType {
  override lazy val salType = types.voidType
    
  override def toLua(indent: Int): String =
    s"${Prefix(indent)}function $id(${params.toLua(0)}) ${PrettyTypePrinter(functionType)}\n${body.toLua(indent + 1)}\n${Prefix(indent)}end"

  val functionType =
    if (params.params.isEmpty) types.FunctionType(types.voidType, res.salType, 0)
    else params.params.foldRight(res.salType)((p, t) => types.FunctionType(p.salType, t, params.params.length))
}

case class ApplicationNode(func: ExpressionNode, params: List[ExpressionNode], retType: types.Type, rest: List[String]) 
  extends STNode with ExpressionType with StatementType {
  override lazy val salType = retType

  override def toLua(indent: Int): String = {
    val luaParams =
      if (params.isEmpty) ""
      else params.map((p) => p.toLua(0)).reduceLeft((r, p) => s"$r, $p")
    val funcName = func.toLua(0)

    if (rest.isEmpty) s"${Prefix(indent)}($funcName)(${luaParams})"
    else {
      val newList = rest.reduceLeft((r, p) => s"$r, $p")
      s"${Prefix(indent)}function($newList) return ($funcName)(${luaParams}, $newList) end"
    }
  }
}

case class FieldNode(val id: String, field: STNode with FieldType, default: Option[ExpressionNode] = None) extends STNode {
  override lazy val salType = field match {
    case f: FunctionNode => f.functionType
    case _ => field.salType
  }
  override def toLua(indent: Int): String = field match {
    case t: TypeNameNode => default match {
      case Some(v) => s"${Prefix(indent)}$id = ${v.toLua(0)}"
      case _ => s"${Prefix(indent)}$id = nil"
    }
    case FunctionNode(id, params, res, body) =>
      s"${Prefix(indent)}$id =\n${FunctionNode("", params, res, body).toLua(indent + 1)}"
  }
}

case class FieldsNode(fields: List[FieldNode]) extends STNode {
  override def toLua(indent: Int): String =
    if (fields.isEmpty) ""
    else fields.map((f) => f.toLua(indent)).reduceLeft((res, f) => s"$res,\n$f")

  lazy val toList = fields.map((f) => f.field match {
    case FunctionNode(name, _, _, _) => (name, f.salType)
    case _ => (f.id, f.salType)
  })
}

case class RecordNode(id: String, fields: FieldsNode) extends STNode with StatementType {
  override lazy val salType = types.RecordType(id, fields.toList)

  override def toLua(indent: Int): String =
    s"${Prefix(indent)}$id = {\n${fields.toLua(indent + 1)}\n${Prefix(indent)}}"
}

case class AccessNode(rec: ExpressionNode, field: String, res: types.Type) extends STNode with ExpressionType {
  override lazy val salType = res

  override def toLua(indent: Int): String = s"(${rec.toLua(indent)}).$field"
}

case class InitializerNode(val param: (Option[String], ExpressionNode)) extends STNode {
  override lazy val salType = param._2.salType
}

case class CreateNode(rec: types.RecordType, initializers: List[InitializerNode]) extends STNode with ExpressionType {
  override lazy val salType = rec

  override def toLua(indent: Int): String =
    if (rec.fields.isEmpty) s"${Prefix(indent)}{}"
    else {
      val namedInit = initializers.filter((i) => !i.param._1.isEmpty).map((i) => (i.param._1.get, i.param._2)).toMap
      val defaultInit = initializers.filter((i) => i.param._1.isEmpty).map((i) => i.param._2).iterator

      val body = rec.fields.map((f) =>
        if (namedInit.contains(f._1)) s"${Prefix(indent)}  ${f._1} = ${namedInit(f._1).toLua(0)}"
        else if (defaultInit.hasNext) s"${Prefix(indent)}  ${f._1} = ${defaultInit.next().toLua(0)}"
        else s"${Prefix(indent)}  ${f._1} = ${rec.name}.${f._1}"
      )

      s"${Prefix(indent)}{\n${body.reduceLeft((r, f) => s"$r,\n$f")}\n${Prefix(indent)}}"
    }
}

case class BiOpExpression(lhs: ExpressionNode, rhs: ExpressionNode, op: Operator, res: types.Type) extends STNode with ExpressionType {
  override lazy val salType = res

  override def toLua(indent: Int): String = s"(${lhs.toLua(0)}) ${OperatorTranslator(op)} (${rhs.toLua(0)})"
}

case class UnOpExpression(v: ExpressionNode, op: Operator, res: types.Type) extends STNode with ExpressionType {
  override lazy val salType = res

  override def toLua(indent: Int): String = s"${OperatorTranslator(op)} (${v.toLua(0)})"
}