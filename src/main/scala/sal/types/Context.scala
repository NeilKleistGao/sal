package sal.types
import sal.types._

import scala.collection.mutable.HashMap

class Context(parent: Option[Context]) {
  private val map = HashMap[String, Type](
    "print" -> FunctionType(anythingType, voidType)
  )

  import sal.Operator._
  private val operatos = HashMap[Operator, Type](
    LogicNot -> FunctionType(boolType, boolType),
    BitwiseNot -> FunctionType(intType, intType),
    LeftShift -> FunctionType(intType, FunctionType(intType, intType)),
    RightShift -> FunctionType(intType, FunctionType(intType, intType)),
    BitwiseAnd -> FunctionType(intType, FunctionType(intType, intType)),
    BitwiseXor -> FunctionType(intType, FunctionType(intType, intType)),
    BitwiseOr -> FunctionType(intType, FunctionType(intType, intType)),
    LogicAnd -> FunctionType(boolType, FunctionType(boolType, boolType)),
    LogicOr -> FunctionType(boolType, FunctionType(boolType, boolType)),
  )

  private val newTypes = HashMap[String, RecordType]()

  def derive() = new Context(Some(this))

  def +=(info: (String, Type)) =
    if (map.contains(info._1)) throw sal.SalException(s"duplicate variable ${info._1}.")
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

  def query(op: Operator): Type =
    operatos.getOrElse(op, parent match {
      case Some(p) => p.query(op)
      case _ => throw sal.SalException(s"unknown operator $op.")
    })

  def :=(rec: RecordType): Unit = newTypes.put(rec.name, rec)
  def ?(typeName: String): Type =
    newTypes.getOrElse(typeName, parent match {
      case Some(p) => p?typeName
      case _ => throw sal.SalException(s"unknown type $typeName.")
    })
}

object Context {
  def apply() = new Context(None)
}