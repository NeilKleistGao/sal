package sal.types
import sal.types._

import scala.collection.mutable.HashMap

class Context(parent: Option[Context]) {
  private val map = HashMap[String, Type](
    "print" -> (anythingType --> voidType),
    "tostring" -> (anythingType --> stringType),
    "tonumber" -> (anythingType --> (intType \/ floatType)),
    "type" -> (anythingType --> stringType),

    "and" -> PreservedKeyword,
    "or" -> PreservedKeyword,
    "not" -> PreservedKeyword,
    "nil" -> PreservedKeyword,
  )

  private val newTypes = HashMap[String, RecordType]()

  def derive() = new Context(Some(this))

  def +=(info: (String, Type)) =
    if (map.contains(info._1)) map(info._1) match {
      case PreservedKeyword => throw sal.SalException(s"${info._1} is a preserved keyword in lua.")
      case _ => throw sal.SalException(s"duplicate variable ${info._1}.")
    }
    else map.put(info._1, info._2)

  def require(name: String, req: Type): Boolean =
    if (!map.contains(name)) parent match {
      case Some(p) => p.require(name, req)
      case _ => false
    }
    else map(name) === req

  def alloc(name: String, tp: Type): String =
    if (map.contains(name)) alloc(name + "_", tp)
    else {
      map.put(name, tp)
      name
    }

  def -=(name: String): Unit = map.remove(name); {}

  def query(name: String): Type =
    map.getOrElse(name, parent match {
      case Some(p) => p.query(name)
      case _ => throw sal.SalException(s"unknown variable $name.")
    })

  def query(op: sal.Operator.Operator): Type =
    Context.operatos.getOrElse(op, throw sal.SalException(s"unknown operator $op."))

  def :=(rec: RecordType): Unit = newTypes.put(rec.name, rec)
  def ?(typeName: String): Type =
    newTypes.getOrElse(typeName, parent match {
      case Some(p) => p?typeName
      case _ => throw sal.SalException(s"unknown type $typeName.")
    })
}

object Context {
  def apply() = new Context(None)

  import sal.Operator._
  private val operatos = HashMap[Operator, Type](
    Pow -> (numberType --> (numberType --> floatType)),
    LogicNot -> (boolType --> boolType),
    BitwiseNot -> (intType --> intType),
    Mul -> (intType --> (intType --> intType)),
    FMul -> (numberType --> (numberType --> floatType)),
    Div -> (intType --> (intType --> intType)),
    FDiv -> (numberType --> (numberType --> floatType)),
    Mod -> (intType --> (intType --> intType)),
    Add -> (intType --> (intType --> intType)),
    FAdd -> (numberType --> (numberType --> floatType)),
    SAdd -> (stringType --> (stringType --> stringType)),
    Sub -> (intType --> (intType --> intType)),
    FSub -> (numberType --> (numberType --> floatType)),
    LeftShift -> (intType --> (intType --> intType)),
    RightShift -> (intType --> (intType --> intType)),
    BitwiseAnd -> (intType --> (intType --> intType)),
    BitwiseXor -> (intType --> (intType --> intType)),
    BitwiseOr -> (intType --> (intType --> intType)),
    LogicAnd -> (boolType --> (boolType --> boolType)),
    LogicOr -> (boolType --> (boolType --> boolType)),
  )
}