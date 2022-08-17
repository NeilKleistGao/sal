package sal.types

import scala.collection.mutable.HashMap

class Context(parent: Option[Context]) {
  private val map = HashMap[String, Type]()

  def derive() = new Context(Some(this))

  def +=(info: (String, Type)) = map.put(info._1, info._2)

  def require(name: String, req: Type) =
    if (!map.contains(name)) false
    else map(name) == req
}

object Context {
  def apply() = new Context(None)
}