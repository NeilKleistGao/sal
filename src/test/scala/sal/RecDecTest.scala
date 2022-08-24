package sal

import RecDecTest._

class RecDecTest extends DiffTest {
  test("Record Declaration Test") {
    generate(input, output)
  }
}

object RecDecTest {
  val input = "rec_dec_test.sal"
  val output = "rec_dec_test.lua"
}