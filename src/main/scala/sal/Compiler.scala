package sal

import java.io.{BufferedReader, FileReader, BufferedWriter, FileWriter}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import java.io.BufferedWriter

class Compiler(filename: String) {
  private lazy val result = compile()

  private def compile(): ResultNode = {
   val reader =
    try { new BufferedReader(new FileReader(filename)) }
    catch {
      case e: java.io.IOException => null
    }

    if (reader == null) ErrorNode(s"\n  Error: Can't Open File $filename.\n")
    else {
      val content = Compiler.readFromFile(reader)
      val stream = CharStreams.fromString(content)
      val lexer = new sal.parser.SalLexer(stream)
      val tokens = new CommonTokenStream(lexer)
      val parser = new sal.parser.SalParser(tokens)
      try
        STVisitor().visit(parser.program).asInstanceOf[ProgramNode]
      catch {
        case SalException(info) => ErrorNode(info)
        case _: Throwable => ErrorNode("\n  grammar error.\n")
      }
    }
  }

  // TODO: add more test parameters
  def toLua(outputname: String): Unit = {
    try {
      val writer = new BufferedWriter(new FileWriter(outputname))
      result match {
        case e: ErrorNode => writer.write(e.toString)
        case p: ProgramNode => writer.write(p.toLua().show(""))
      }
      writer.close()
    }
    catch {
      case e: java.io.IOException =>
        System.err.println(s"Error: Can't Write File $outputname.")
    }
  }
}

object Compiler {
  def apply(filename: String) = new Compiler(filename)

  private def readFromFile(reader: BufferedReader, prev: String = ""): String = {
    val line = reader.readLine()
    if (line == null) prev
    else readFromFile(reader, s"$prev$line\n")
  }
}
