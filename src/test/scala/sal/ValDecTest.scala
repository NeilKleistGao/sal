package sal

import ValDecTest.{input, output}

class ValDecTest extends DiffTest(input, output) {
  test("Value Declaration Test") {
    generate()
  }
}

object ValDecTest {
  val input = "val_dec_test.sal"
  val output = "val_dec_test.lua"
}