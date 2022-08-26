package sal

import CalDecTest._

class CalDecTest extends DiffTest {
  test("Calculation Test") {
    generate(input, output)
  }

  test("Calculation Error Test") {
    generate(err_input, err_output)
  }
}

object CalDecTest {
  val input = "cal_dec_test.sal"
  val output = "cal_dec_test.lua"

  val err_input = "cal_err_test.sal"
  val err_output = "cal_err_test.lua"
}