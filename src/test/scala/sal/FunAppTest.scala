package sal

import FunAppTest._

class FunAppTest extends DiffTest {
  test("Function Application Test") {
    generate(input, output)
  }
}

object FunAppTest {
  val input = "fun_app_test.sal"
  val output = "fun_app_test.lua"
}