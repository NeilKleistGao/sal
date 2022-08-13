// Generated from SalParser.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SalParser}.
 */
public interface SalParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SalParser#lit}.
	 * @param ctx the parse tree
	 */
	void enterLit(SalParser.LitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SalParser#lit}.
	 * @param ctx the parse tree
	 */
	void exitLit(SalParser.LitContext ctx);
}