package sal

import java.io.{BufferedReader, FileReader}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

class Compiler(filename: String) {
  import grammar._

  lazy val visitor = init

  private def init(): ASTVisitor = {
   val reader =
    try { new BufferedReader(new FileReader(filename)) }
    catch {
      case e: java.io.IOException => {
        System.err.println(s"Error: Can't Open File $filename")
        null
      }
    }

    if (reader == null) null
    else {
      val content = readFromFile(reader)
      val stream = CharStreams.fromString(content)
      val lexer = new sal.parser.SalLexer(stream)
      val tokens = new CommonTokenStream(lexer)
      val parser = new sal.parser.SalParser(tokens)
      ASTVisitor(parser)
    }
  }

  private def readFromFile(reader: BufferedReader, prev: String = ""): String = {
    val line = reader.readLine()
    if (line == null) prev
    else readFromFile(reader, s"$prev$line\n")
  }
}

object Compiler {
  def apply(filename: String) = new Compiler(filename)
}