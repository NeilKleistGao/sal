package sal

import ValDecTest._

class ValDecTest extends DiffTest {
  test("Value Declaration Test") {
    generate(input, output)
  }

  test("Value Declaration Error Test") {
    generate(err_input, err_output)
  }

  test("Value Declaration Inference Test") {
    generate(inf_input, inf_output)
  }
}

object ValDecTest {
  val input = "val_dec_test.sal"
  val output = "val_dec_test.lua"

  val err_input = "val_err_test.sal"
  val err_output = "val_err_test.lua"

  val inf_input = "val_inf_test.sal"
  val inf_output = "val_inf_test.lua"
}