package sal

import FunDecTest._

class FunDecTest extends DiffTest {
  test("Function Declaration Test") {
    generate(input, output)
  }
}

object FunDecTest {
  val input = "fun_dec_test.sal"
  val output = "fun_dec_test.lua"
}