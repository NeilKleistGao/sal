package sal

import Operator._;
import types._;

sealed trait STNode {
  lazy val salType: Type = ???
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
sealed trait ElseBlockType

case class LitNode(value: String) extends STNode with ExpressionType {
  override def toLua(indent: Int): String =
    if (value.equals("nix")) s"${Prefix(indent)}nil"
    else s"${Prefix(indent)}$value"

  override lazy val salType = LitNode.getLitType(value)

  lazy val toInt = value.toInt
}

object LitNode {
  private def getLitType(value: String): Type =
    if (value.contains("\"")) stringType
    else if (value.equals("true") || value.equals("false")) boolType
    else if (value.contains(".")) floatType
    else if (value.equals("nix")) anythingType
    else intType
}

case class TypeNameNode(tp: Type) extends STNode with FieldType {
  override lazy val salType = tp
}

case class VariableNode(name: String, tp: Type) extends STNode with ExpressionType {
  override lazy val salType = tp
  override def toLua(indent: Int): String = name
}

case class ExpressionNode(val exp: STNode with ExpressionType, tp: Option[Type] = None) extends STNode with FunctionBodyType with BlockInnerType with ElseBlockType {
  override def toLua(indent: Int): String = exp match {
    case c @ IfConditionNode(_, _, _, res) =>
      s"${Prefix(indent)}(function()\n${c.toLua(indent + 1)}\n${Prefix(indent + 1)}return $res\n${Prefix(indent)}end)()"
    case _ => exp.toLua(indent)
  }

  override lazy val salType = tp match {
    case Some(t) => t
    case _ => exp.salType
  }
}

case class ValueNode(id: String, tp: TypeNameNode, expr: ExpressionNode) extends STNode with StatementType {
  override def toLua(indent: Int): String = s"${Prefix(indent)}local $id = ${expr.toLua(0)} ${PrettyTypePrinter(tp.salType)}"

  override lazy val salType = voidType
}

case class StatementNode(s: STNode with StatementType) extends STNode with BlockInnerType {
  override def toLua(indent: Int): String = s.toLua(indent)

  override lazy val salType = s.salType
}

case class ProgramNode(states: List[StatementNode]) extends STNode with ResultNode {
  override def toLua(indent: Int): String =
    states.foldLeft("")((res, s) => s"$res${s.toLua(0)}\n")

  override lazy val salType = voidType
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

case class BlockNode(stats: List[STNode with BlockInnerType], val res: String) extends STNode with FunctionBodyType with ElseBlockType {
  override lazy val salType =
    if (stats.isEmpty) voidType
    else stats.last.salType

  private def translateBlock(lst: List[STNode with BlockInnerType], indent: Int): String =
    lst.foldLeft("")((r, s) => s match {
        case e: ExpressionNode => s"$r\n${Prefix(indent)}local _ = ${s.toLua(0)}"
        case _ => s"$r\n${s.toLua(indent)}"
      })

  override def toLua(indent: Int): String =
    if (stats.isEmpty) ""
    else salType match {
      case BuiltInType(name) if (name.equals("void")) =>
        translateBlock(stats, indent)
      case _ => {
        val body = translateBlock(stats.dropRight(1), indent)
        s"$body\n${Prefix(indent)}$res = ${stats.last.toLua(0)}"
      }
    }

  def rename(newName: String) = BlockNode(stats, newName)
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
  override lazy val salType = voidType
    
  override def toLua(indent: Int): String =
    s"${Prefix(indent)}function $id(${params.toLua(0)}) ${PrettyTypePrinter(functionType)}\n${body.toLua(indent + 1)}\n${Prefix(indent)}end"

  val functionType =
    if (params.params.isEmpty) FunctionType(voidType, res.salType, 0)
    else params.params.foldRight(res.salType)((p, t) => FunctionType(p.salType, t, params.params.length))
}

case class ApplicationNode(func: ExpressionNode, params: List[ExpressionNode], retType: Type, rest: List[String]) 
  extends STNode with ExpressionType with StatementType {
  override lazy val salType = retType

  override def toLua(indent: Int): String = {
    val luaParams =
      if (params.isEmpty) ""
      else params.map((p) => p.toLua(0)).reduceLeft((r, p) => s"$r, $p")
    val funcName = func.exp match {
      case v: VariableNode => v.toLua(0)
      case _ => s"(${func.toLua(0)})"
    }

    if (rest.isEmpty) s"${Prefix(indent)}$funcName(${luaParams})"
    else {
      val newList = rest.reduceLeft((r, p) => s"$r, $p")
      s"${Prefix(indent)}function($newList) return $funcName(${luaParams}, $newList) end"
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
  override lazy val salType = RecordType(id, fields.toList)

  override def toLua(indent: Int): String =
    s"${Prefix(indent)}$id = {\n${fields.toLua(indent + 1)}\n${Prefix(indent)}}"
}

case class AccessNode(rec: ExpressionNode, field: String, res: Type) extends STNode with ExpressionType {
  override lazy val salType = res

  override def toLua(indent: Int): String = s"(${rec.toLua(indent)}).$field"
}

case class InitializerNode(val param: (Option[String], ExpressionNode)) extends STNode {
  override lazy val salType = param._2.salType
}

case class CreateNode(rec: RecordType, initializers: List[InitializerNode]) extends STNode with ExpressionType {
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

case class BiOpExpression(lhs: ExpressionNode, rhs: ExpressionNode, op: Operator, res: Type) extends STNode with ExpressionType {
  override lazy val salType = res

  override def toLua(indent: Int): String = s"(${lhs.toLua(0)}) ${OperatorTranslator(op)} (${rhs.toLua(0)})"
}

case class UnOpExpression(v: ExpressionNode, op: Operator, res: Type) extends STNode with ExpressionType {
  override lazy val salType = res

  override def toLua(indent: Int): String = s"${OperatorTranslator(op)} (${v.toLua(0)})"
}

case class IfConditionNode(condition: ExpressionNode, body: STNode with FunctionBodyType, elseList: List[STNode with ElseBlockType], res: String)
  extends STNode with ElseBlockType with ExpressionType with StatementType {
  override lazy val salType =
    elseList.foldLeft(body.salType)((res, e) => if (res !== e.salType) anythingType else res)

  override def toLua(indent: Int): String = {
    val ifLua = s"${Prefix(indent)}if (${condition.toLua(0)}) then${translateBody(body, indent + 1)}\n"
    val elseLua = elseList.foldLeft("")((els, e) => e match {
      case IfConditionNode(c, b, _, _) => s"$els${Prefix(indent)}elseif (${c.toLua(0)}) then${translateBody(b, indent + 1)}\n"
      case elseBlock: STNode with FunctionBodyType => s"$els${Prefix(indent)}else${translateBody(elseBlock, indent + 1)}\n"
    })

    s"${Prefix(indent)}local $res = nil\n$ifLua$elseLua${Prefix(indent)}end"
  }

  private def translateBody(body: STNode with FunctionBodyType, indent: Int) = body match {
    case block: BlockNode => block.toLua(indent)
    case exp: ExpressionNode => s"\n${Prefix(indent)}$res = ${exp.toLua(0)}"
  }
}

case class LambdaNode(params: ParamsNode, res: TypeNameNode, exp: ExpressionNode) extends STNode with ExpressionType {
  override lazy val salType =
    if (params.params.isEmpty) FunctionType(voidType, res.salType, 0)
    else params.params.foldRight(res.salType)((p, t) => FunctionType(p.salType, t, params.params.length))
    
  override def toLua(indent: Int): String = res.salType match {
    case BuiltInType(typename) if (typename.equals("void")) =>
      s"${Prefix(indent)}(function (${params.toLua(0)}) ${exp.toLua(0)} end)"
    case _ => s"${Prefix(indent)}(function (${params.toLua(0)}) return ${exp.toLua(0)} end)"
  }
    
}

case class TupleNode(fields: List[ExpressionNode]) extends STNode with ExpressionType {
  override lazy val salType = TupleType(fields.map(f => f.salType))

  override def toLua(indent: Int): String =
    s"${Prefix(indent)}{${fields.map(f => f.toLua(0)).reduceLeft((r, s) => s"$r, $s")}}"
}

case class IndexedNode(parent: ExpressionNode, index: Int) extends STNode with ExpressionType {
  override lazy val salType = parent.salType.at(index)

  override def toLua(indent: Int): String =
    s"${Prefix(indent)}${parent.toLua(0)}[${index + 1}]"
}
