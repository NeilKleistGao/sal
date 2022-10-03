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
  private val forwardDec = HashMap[String, Type]()

  def derive() = new Context(Some(this))

  def +=(info: (String, Type)) =
    if (map.contains(info._1)) map(info._1) match {
      case PreservedKeyword => throw sal.SalException(s"${info._1} is a preserved keyword in lua.")
      case _ => throw sal.SalException(s"duplicate variable ${info._1}.")
    }
    else if (forwardDec.contains(info._1)) {
      if (forwardDec(info._1) !== info._2) {
        forwardDec.remove(info._1)
        throw sal.SalException(s"implementation of ${info._1} does not correspond to the forward declaration.")
      }
      else {
        map.put(info._1, info._2)
        forwardDec.remove(info._1)
      }
    }
    else map.put(info._1, info._2)

  def require(name: String, req: Type): Boolean =
    if (!map.contains(name)) parent match {
      case Some(p) => p.require(name, req)
      case _ => false
    }
    else map(name) === req

  def alloc(name: String, tp: Type): String =
    if (map.contains(name) || forwardDec.contains(name)) alloc(name + "_", tp)
    else {
      map.put(name, tp)
      name
    }

  def -=(name: String): Unit = map.remove(name); {}

  def query(name: String): Type =
    map.getOrElse(name, forwardDec.getOrElse(name, parent match {
      case Some(p) => p.query(name)
      case _ => throw sal.SalException(s"unknown variable $name.")
    }))

  def query(op: sal.Operator.Operator): Type =
    Context.operatos.getOrElse(op, throw sal.SalException(s"unknown operator $op."))

  def :=(rec: RecordType): Unit =
    if (newTypes.contains(rec.name))
      throw sal.SalException(s"duplicate record type ${rec.name}.")
    else if (forwardDec.contains(rec.name)) {
      if (forwardDec(rec.name) !== rec) {
        forwardDec.remove(rec.name)
        throw sal.SalException(s"implementation of ${rec.name} does not correspond to the forward declaration.")
      }
      else {
        newTypes.put(rec.name, rec)
        forwardDec.remove(rec.name)
      }
    }
    else newTypes.put(rec.name, rec)
  
  def ?(typeName: String): Type =
    newTypes.getOrElse(typeName, forwardDec.getOrElse(typeName, parent match {
      case Some(p) => p?typeName
      case _ => throw sal.SalException(s"unknown type $typeName.")
    }))

  def +=!(info: (String, Type)) =
    if (forwardDec.contains(info._1) || map.contains(info._1))
      throw sal.SalException(s"duplicate forward declaration ${info._1}.")
    else forwardDec.put(info._1, info._2)

  def getNotImplementedTypes = forwardDec
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
    Less -> (intType --> (intType --> boolType)),
    FLess -> (numberType --> (numberType --> boolType)),
    SLess -> (stringType --> (stringType --> boolType)),
    Greater -> (intType --> (intType --> boolType)),
    FGreater -> (numberType --> (numberType --> boolType)),
    SGreater -> (stringType --> (stringType --> boolType)),
    LessEqual -> (intType --> (intType --> boolType)),
    FLessEqual -> (numberType --> (numberType --> boolType)),
    SLessEqual -> (stringType --> (stringType --> boolType)),
    GreaterEqual -> (intType --> (intType --> boolType)),
    FGreaterEqual -> (numberType --> (numberType --> boolType)),
    SGreaterEqual -> (stringType --> (stringType --> boolType)),
    LeftShift -> (intType --> (intType --> intType)),
    RightShift -> (intType --> (intType --> intType)),
    BitwiseAnd -> (intType --> (intType --> intType)),
    BitwiseXor -> (intType --> (intType --> intType)),
    BitwiseOr -> (intType --> (intType --> intType)),
    LogicAnd -> (boolType --> (boolType --> boolType)),
    LogicOr -> (boolType --> (boolType --> boolType)),
  )
}
