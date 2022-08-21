package sal

import FunAppTest._

class FunAppTest extends DiffTest {
  test("Function Application Test") {
    generate(input, output)
  }

  test("Wrong Application Test") {
    generate(err_input, err_output)
  }
}

object FunAppTest {
  val input = "fun_app_test.sal"
  val output = "fun_app_test.lua"
  val err_input = "app_err_test.sal"
  val err_output = "app_err_test.lua"
}