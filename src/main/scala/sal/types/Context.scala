package sal.types

import scala.collection.mutable.HashMap

class Context(parent: Option[Context]) {
  private val map = HashMap[String, Type]()

  def derive() = new Context(Some(this))

  def +=(info: (String, Type)) =
    if (map.contains(info._1)) throw sal.SalException(s"duplicate variable ${info._1}.")
    else map.put(info._1, info._2)

  def require(name: String, req: Type) =
    if (!map.contains(name)) false
    else map(name) == req

  def alloc(name: String, tp: Type): String = {
    if (map.contains(name)) alloc(name + "_", tp)
    else {
      map.put(name, tp)
      name
    }
  }
}

object Context {
  def apply() = new Context(None)
}