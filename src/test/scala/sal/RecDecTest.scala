package sal

import RecDecTest._

class RecDecTest extends DiffTest {
  test("Record Declaration Test") {
    generate(input, output)
  }

  test("Record Error Test") {
    generate(err_input, err_output)
  }
}

object RecDecTest {
  val input = "rec_dec_test.sal"
  val output = "rec_dec_test.lua"

  val err_input = "rec_err_test.sal"
  val err_output = "rec_err_test.lua"
}