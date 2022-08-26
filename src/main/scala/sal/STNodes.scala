package sal

import Operator._;

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
sealed trait ExpressionType
sealed trait FieldType

case class LitNode(value: String) extends STNode with ExpressionType {
  override def toLua(indent: Int): String =
    if (value.equals("nix")) s"${super.toLua(indent)}nil"
    else s"${super.toLua(indent)}$value"

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

case class ExpressionNode(exp: STNode with ExpressionType) extends STNode with FunctionBodyType with BlockInnerType {
  override def toLua(indent: Int): String = exp.toLua(indent)

  override lazy val salType = exp.salType
}

case class ValueNode(id: String, tp: TypeNameNode, expr: ExpressionNode) extends STNode with StatementType {
  override def toLua(indent: Int): String = s"${super.toLua(indent)}local $id = ${expr.toLua(0)} --[[type: ${tp.salType}]]"

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

  private def translateBlock(lst: List[STNode with BlockInnerType], indent: Int): String =
    lst.foldLeft("")((r, s) => s match {
        case e: ExpressionNode => s"$r\n${super.toLua(indent)}local _ = ${s.toLua(0)}"
        case _ => s"$r\n${s.toLua(indent)}"
      })

  override def toLua(indent: Int): String =
    if (stats.isEmpty) ""
    else salType match {
      case types.BuiltInType(name) if (name.equals("void")) =>
        translateBlock(stats, indent)
      case _ => {
        val body = translateBlock(stats.dropRight(1), indent)
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

case class FunctionNode(val id: String, params: ParamsNode, res: TypeNameNode, body: FunctionBodyNode)
  extends STNode with StatementType with FieldType {
  override lazy val salType = types.voidType
    
  override def toLua(indent: Int): String = {
    val prefix = super.toLua(indent)
    s"${prefix}function $id(${params.toLua(0)}) --[[type: $functionType]]\n${body.toLua(indent + 1)}\n${prefix}end"
  }

  val functionType =
    if (params.params.isEmpty) types.FunctionType(types.voidType, res.salType)
    else params.params.foldRight(res.salType)((p, t) => types.FunctionType(p.salType, t))
}

case class ApplicationNode(func: String, params: List[ExpressionNode], retType: types.Type, rest: List[String]) 
  extends STNode with ExpressionType with StatementType {
  override lazy val salType = retType

  override def toLua(indent: Int): String = {
    val luaParams = params.foldLeft("")((r, p) => s"$r, ${p.toLua(0)}")
    val prefix = super.toLua(indent)

    if (rest.isEmpty)
      if (luaParams.isEmpty()) s"$prefix$func()"
      else s"$prefix$func(${luaParams.substring(2)})"
    else {
      val newList = rest.foldLeft("")((r, p) => s"$r, $p").substring(2)
      if (luaParams.isEmpty()) s"${prefix}function($newList) return $func($newList) end"
      else s"${prefix}function($newList) return $func(${luaParams.substring(2)}, $newList) end"
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
      case Some(v) => s"${super.toLua(indent)}$id = ${v.toLua(0)}"
      case _ => s"${super.toLua(indent)}$id = nil"
    }
    case FunctionNode(id, params, res, body) =>
      s"${super.toLua(indent)}$id =\n${FunctionNode("", params, res, body).toLua(indent + 1)}"
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

  override def toLua(indent: Int): String = {
    val prefix = super.toLua(indent)
    s"$prefix$id = {\n${fields.toLua(indent + 1)}\n$prefix}"
  }
}

case class AccessNode(rec: String, field: String, res: types.Type) extends STNode with ExpressionType {
  override lazy val salType = res

  override def toLua(indent: Int): String = s"$rec.$field"
}

case class InitializerNode(val param: (Option[String], ExpressionNode)) extends STNode {
  override lazy val salType = param._2.salType

  override def toLua(indent: Int): String = ???
}

case class CreateNode(rec: types.RecordType, initializers: List[InitializerNode]) extends STNode with ExpressionType {
  override lazy val salType = rec

  override def toLua(indent: Int): String = {
    val prefix = super.toLua(indent)
    if (rec.fields.isEmpty) s"$prefix{}"
    else {
      val namedInit = initializers.filter((i) => i.param._1 match {
        case Some(_) => true
        case _ => false
      }).map((i) => (i.param._1.get, i.param._2)).toMap

      val defaultInit = initializers.filter((i) => i.param._1 match {
        case Some(_) => false
        case _ => true
      }).map((i) => i.param._2).iterator

      val body = rec.fields.map((f) =>
        if (namedInit.contains(f._1)) s"$prefix  ${f._1} = ${namedInit(f._1).toLua(0)}"
        else if (defaultInit.hasNext) s"$prefix  ${f._1} = ${defaultInit.next().toLua(0)}"
        else s"$prefix  ${f._1} = ${rec.name}.${f._1}"
      )

      s"$prefix{\n${body.reduceLeft((r, f) => s"$r,\n$f")}\n$prefix}"
    }
  }
}

case class BiOpExpression(lhs: ExpressionNode, rhs: ExpressionNode, op: Operator) extends STNode with ExpressionType {
  override lazy val salType = lhs.salType

  override def toLua(indent: Int): String = s"(${lhs.toLua(0)}) ${OperatorTranslator(op)} (${rhs.toLua(0)})"
}

case class UnOpExpression(v: ExpressionNode, op: Operator) extends STNode with ExpressionType {
  override lazy val salType = v.salType

  override def toLua(indent: Int): String = s"${OperatorTranslator(op)} (${v.toLua(0)})"
}