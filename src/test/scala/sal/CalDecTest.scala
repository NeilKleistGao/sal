package sal

import CalDecTest._

class CalDecTest extends DiffTest {
  test("Calculation Test") {
    generate(input, output)
  }
}

object CalDecTest {
  val input = "cal_dec_test.sal"
  val output = "cal_dec_test.lua"
}