package sal

import FunDecTest._

class FunDecTest extends DiffTest {
  test("Function Declaration Test") {
    generate(input, output)
  }

  test("Function Declaration Error Test") {
    generate(err_input, err_output)
  }

  test("Function Declaration Inference Test") {
    generate(inf_input, inf_output)
  }
}

object FunDecTest {
  val input = "fun_dec_test.sal"
  val output = "fun_dec_test.lua"
  val err_input = "fun_err_test.sal"
  val err_output = "fun_err_test.lua"
  val inf_input = "fun_inf_test.sal"
  val inf_output = "fun_inf_test.lua"
}