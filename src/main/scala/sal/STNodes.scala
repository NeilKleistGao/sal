package sal

import Operator._;
import types._;
import lua._;

sealed trait STNode {
  lazy val salType: Type = ???
  def toLua(): LuaCode = ???
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
sealed trait FieldDefaultType

case object EmptyNode extends STNode with StatementType // for some non-lua-generating semantics

case class LitNode(value: String) extends STNode with ExpressionType {
  override def toLua(): LuaCode =
    if (value.equals("nix")) LuaLit("nil")
    else LuaLit(value)

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
  override def toLua(): LuaCode = LuaVariable(name)
}

case class ExpressionNode(val exp: STNode with ExpressionType, tp: Option[Type] = None)
  extends STNode with FunctionBodyType with BlockInnerType with ElseBlockType with FieldDefaultType {
  override def toLua(): LuaCode = exp match {
    case c @ IfConditionNode(_, _, _, res) =>
      LuaApplication(LuaSequence(List(
        LuaFunction("", List()),
        LuaBlock(List(c.toLua(), LuaReturn(LuaVariable(res)))),
        LuaEnd
      )), List())
    case _ => exp.toLua()
  }

  override lazy val salType = tp match {
    case Some(t) => t
    case _ => exp.salType
  }
}

case class ValueNode(id: String, tp: TypeNameNode, expr: ExpressionNode) extends STNode with StatementType {
  override def toLua(): LuaCode = LuaSequence(List(
    LuaAssign(id, expr.toLua(), true), LuaComments(PrettyTypePrinter(tp.salType))
  ))

  override lazy val salType = voidType
}

case class StatementNode(val s: STNode with StatementType) extends STNode with BlockInnerType {
  override def toLua(): LuaCode = s.toLua()

  override lazy val salType = s.salType
}

case class ProgramNode(states: List[StatementNode]) extends STNode with ResultNode {
  override def toLua(): LuaCode =
    LuaProgram(states.foldLeft(List[LuaCode]())((res, s) => s.s match {
      case EmptyNode => res
      case _ => res :+ s.toLua()
    }))

  override lazy val salType = voidType
}

case class ErrorNode(errInfo: String) extends ResultNode {
  override def toString(): String = s"--[[$errInfo]]"
}

case class ParamNode(name: String, tp: TypeNameNode) extends STNode {
  override lazy val salType = tp.salType
  override def toString(): String = name
}

case class ParamsNode(val params: List[ParamNode]) extends STNode {
  lazy val paramsList = params.map(p => p.toString())
}

case class BlockNode(stats: List[STNode with BlockInnerType], val res: String) extends STNode with FunctionBodyType with ElseBlockType {
  override lazy val salType =
    if (stats.isEmpty) voidType
    else stats.last.salType

  private def translateBlock(lst: List[STNode with BlockInnerType]): List[LuaCode] =
    lst.map(s => s match {
        case e: ExpressionNode => LuaAssign("_", s.toLua(), true)
        case _ => s.toLua()
      })

  override def toLua(): LuaCode =
    if (stats.isEmpty) LuaBlock(List())
    else salType match {
      case BuiltInType(name) if (name.equals("void")) =>
        LuaBlock(translateBlock(stats))
      case _ =>
        LuaSequence(List(
          LuaBlock(translateBlock(stats.dropRight(1))), LuaAssign(res, stats.last.toLua(), false)
        ))
    }

  def rename(newName: String) = BlockNode(stats, newName)
}

case class FunctionBodyNode(body: STNode with FunctionBodyType) extends STNode {
  override lazy val salType = body.salType

  override def toLua(): LuaCode =
    body match {
      case e: ExpressionNode => LuaBlock(List(LuaReturn(e.toLua())))
      case BlockNode(_, res) =>
        LuaSequence(List(
          LuaAssign(res, LuaLit("nil"), true),
          body.toLua(),
          LuaReturn(LuaVariable(res))
        ))
    }
}

case class FunctionNode(val id: String, params: ParamsNode, res: TypeNameNode, body: FunctionBodyNode)
  extends STNode with StatementType with FieldType {
  override lazy val salType = voidType
    
  override def toLua(): LuaCode =
    LuaSequence(List(
      LuaFunction(id, params.paramsList),
      body.toLua(),
      LuaEnd,
      LuaComments(PrettyTypePrinter(functionType))
    ))

  val functionType =
    if (params.params.isEmpty) FunctionType(voidType, res.salType, 0)
    else params.params.foldRight(res.salType)((p, t) => FunctionType(p.salType, t, params.params.length))
}

case class ApplicationNode(func: ExpressionNode, params: List[ExpressionNode], retType: Type, rest: List[String]) 
  extends STNode with ExpressionType with StatementType {
  override lazy val salType = retType

  override def toLua(): LuaCode =
    if (rest.isEmpty) LuaApplication(func.exp.toLua(), params.map((p) => p.toLua()))
    else
      LuaInlineFunction(rest,
        LuaReturn(LuaApplication(func.exp.toLua(), (params.map((p) => p.toLua())) ::: rest.map(r => LuaVariable(r)))))
}

case class ReferenceNode(parent: String, member: String) extends STNode with FieldDefaultType
case class FieldNode(val id: String, field: STNode with FieldType, default: Option[STNode with FieldDefaultType] = None) extends STNode {
  override lazy val salType = field match {
    case f: FunctionNode => f.functionType
    case _ => field.salType
  }

  lazy val luaField: LuaFieldType = field match {
    case t: TypeNameNode => default match {
      case Some(v) => v match {
        case exp: ExpressionNode => (id, exp.toLua())
        case ReferenceNode(parent, member) => (id, LuaSelection(LuaVariable(parent), member))
      }
      case _ => (id, LuaLit("nil"))
    }
    case FunctionNode(id, params, res, body) => (id, FunctionNode("", params, res, body).toLua())
  }
}

case class FieldsNode(fields: List[FieldNode]) extends STNode {
  override def toLua(): LuaCode = LuaTable(fields.map(f => f.luaField), false)

  lazy val toList = fields.map((f) => f.field match {
    case FunctionNode(name, _, _, _) => (name, f.salType)
    case _ => (f.id, f.salType)
  })
}

case class RecordNode(id: String, fields: FieldsNode) extends STNode with StatementType {
  override lazy val salType = RecordType(id, fields.toList)

  override def toLua(): LuaCode = LuaAssign(id, fields.toLua(), false)
}

case class SelectionNode(rec: ExpressionNode, field: String, res: Type) extends STNode with ExpressionType {
  override lazy val salType = res

  override def toLua(): LuaCode = LuaSelection(rec.toLua(), field)
}

case class InitializerNode(val param: (Option[String], ExpressionNode)) extends STNode {
  override lazy val salType = param._2.salType
}

case class CreateNode(rec: RecordType, initializers: List[InitializerNode]) extends STNode with ExpressionType {
  override lazy val salType = rec

  override def toLua(): LuaCode = {
    val namedInit = initializers.filter((i) => !i.param._1.isEmpty).map((i) => (i.param._1.get, i.param._2)).toMap
    val defaultInit = initializers.filter((i) => i.param._1.isEmpty).map((i) => i.param._2).iterator

    LuaTable(rec.fields.map((f) =>
      if (namedInit.contains(f._1)) (f._1, namedInit(f._1).toLua())
      else if (defaultInit.hasNext) (f._1, defaultInit.next().toLua())
      else (f._1, LuaSelection(LuaVariable(rec.name), f._1))
    ), false)
  }
}

case class BiOpExpression(lhs: ExpressionNode, rhs: ExpressionNode, op: Operator, res: Type) extends STNode with ExpressionType {
  override lazy val salType = res

  override def toLua(): LuaCode = LuaBinaryOperator(OperatorTranslator(op), lhs.toLua(), rhs.toLua())
}

case class UnOpExpression(v: ExpressionNode, op: Operator, res: Type) extends STNode with ExpressionType {
  override lazy val salType = res

  override def toLua(): LuaCode = LuaUnaryOperator(OperatorTranslator(op), v.toLua())
}

case class IfConditionNode(condition: ExpressionNode, body: STNode with FunctionBodyType, elseList: List[STNode with ElseBlockType], res: String)
  extends STNode with ElseBlockType with ExpressionType with StatementType {
  override lazy val salType =
    elseList.foldLeft(body.salType)((res, e) => if (res !== e.salType) anythingType else res)

  override def toLua(): LuaCode =
    LuaSequence(List(
      LuaAssign(res, LuaLit("nil"), true),
      LuaSequence(List(LuaIf(condition.toLua(), false), translateBody(body))),
      LuaSequence(
        elseList.map(e => e match {
          case IfConditionNode(c, b, _, _) => LuaSequence(List(LuaIf(c.toLua(), true), translateBody(b)))
          case elseBlock: STNode with FunctionBodyType => LuaSequence(List(LuaElse, translateBody(elseBlock)))
        })),
      LuaEnd
    ))

  private def translateBody(body: STNode with FunctionBodyType) = body match {
    case block: BlockNode => block.toLua()
    case exp: ExpressionNode => LuaBlock(List(LuaAssign(res, exp.toLua(), false)))
  }
}

case class LambdaNode(params: ParamsNode, res: TypeNameNode, exp: ExpressionNode) extends STNode with ExpressionType {
  override lazy val salType =
    if (params.params.isEmpty) FunctionType(voidType, res.salType, 0)
    else params.params.foldRight(res.salType)((p, t) => FunctionType(p.salType, t, params.params.length))
    
  override def toLua(): LuaCode = res.salType match {
    case BuiltInType(typename) if (typename.equals("void")) =>
      LuaInlineFunction(params.paramsList, exp.toLua())
    case _ => LuaInlineFunction(params.paramsList, LuaReturn(exp.toLua()))
  }
    
}

case class TupleNode(fields: List[ExpressionNode]) extends STNode with ExpressionType {
  override lazy val salType = TupleType(fields.map(f => f.salType))

  override def toLua(): LuaCode = LuaTable(fields.map(f => ("", f.toLua())), true)
}

case class IndexedNode(parent: ExpressionNode, index: Int) extends STNode with ExpressionType {
  override lazy val salType = parent.salType.at(index)

  override def toLua(): LuaCode =
    LuaIndex(parent.toLua(), LuaLit((index + 1).toString()))
}
