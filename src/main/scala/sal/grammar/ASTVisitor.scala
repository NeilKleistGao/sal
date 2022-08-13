package sal.grammar

import org.antlr.v4.runtime.{CharStreams}

class ASTVisitor(parser: sal.parser.SalParser) extends sal.parser.SalParserBaseVisitor[AnyRef] {
  
}

object ASTVisitor {
  def apply(parser: sal.parser.SalParser) = new ASTVisitor(parser)
}