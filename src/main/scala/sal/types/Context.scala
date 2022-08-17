package sal.types

import scala.collection.mutable.HashMap

class Context(parent: Option[Context]) {
  private val map = HashMap[String, Type]()

  def derive() = new Context(Some(this))

  def +=(name: String, tp: Type) = map.put(name, tp)

  def require(name: String, req: Type) =
    if (!map.contains(name)) false
    else map(name) == req
}

object Context {
  def apply() = new Context(None)
}