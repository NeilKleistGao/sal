package sal

import org.scalatest.funsuite.AnyFunSuite

class DiffTest extends AnyFunSuite {
  import DiffTest._

  def generate(from: String, to: String): Unit = {
    val compiler = Compiler(s"$salPath/$from")
    compiler.toLua(s"$luaPath/$to")
  }

  testList.foreach((name) => test(name) {
    generate(s"$name.sal", s"$name.lua")
  })
}

object DiffTest {
  private val testPath = "src/test"
  private val salPath = s"$testPath/sal"
  private val luaPath = s"$testPath/lua"

  private val testList = List(
    "cal_dec_test",
    "cal_err_test",
    "fun_app_test",
    "app_err_test",
    "fun_dec_test",
    "fun_err_test",
    "fun_inf_test",
    "rec_dec_test",
    "rec_err_test",
    "val_dec_test",
    "val_err_test",
    "val_inf_test",
    "con_dec_test",
    "con_err_test",
    "ass_dec_test",
    "ass_err_test",
    "lam_dec_test"
  )
}