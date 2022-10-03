package sal

case class SalException(info: String) extends Exception(info) {
}

object SalException {
  def apply(info: String, line: Int): SalException = SalException(format(info, line))

  def format(info: String, line: Int) = s"  line $line: $info\n"
}
