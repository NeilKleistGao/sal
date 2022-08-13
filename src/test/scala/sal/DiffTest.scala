package sal

import org.scalatest.funsuite.AnyFunSuite

class DiffTest(from: String, to: String) extends AnyFunSuite {
  // TODO: add more test parameters
  def generate(): Unit = {
    import DiffTest._
    val compiler = Compiler(s"$salPath/$from")
    compiler.toLua(s"$luaPath/$to")
  }
}

object DiffTest {
  private val testPath = "src/test"
  private val salPath = s"$testPath/sal"
  private val luaPath = s"$testPath/lua"
}