package sal

import java.io.{BufferedReader, FileReader, BufferedWriter, FileWriter}
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import java.io.BufferedWriter

class Compiler(filename: String) {
  private lazy val program = init

  private def init(): ProgramNode = {
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
      STVisitor().visit(parser.program).asInstanceOf[ProgramNode]
    }
  }

  private def readFromFile(reader: BufferedReader, prev: String = ""): String = {
    val line = reader.readLine()
    if (line == null) prev
    else readFromFile(reader, s"$prev$line\n")
  }

  // TODO: add more test parameters
  def toLua(outputname: String): Unit = {
    try {
      val writer = new BufferedWriter(new FileWriter(outputname))
      writer.write(Compiler.compile(program))
      writer.close()
    }
    catch {
      case e: java.io.IOException => {
        System.err.println(s"Error: Can't Write File $outputname")
      }
    }
  }
}

object Compiler {
  def apply(filename: String) = new Compiler(filename)

  private def compile(program: ProgramNode): String = "" // TODO: generate lua code
}