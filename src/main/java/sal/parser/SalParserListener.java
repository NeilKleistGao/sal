// Generated from SalParser.g4 by ANTLR 4.10.1

  package sal.parser;

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
	/**
	 * Enter a parse tree produced by {@link SalParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SalParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SalParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SalParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SalParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SalParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SalParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SalParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SalParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(SalParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SalParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(SalParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SalParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(SalParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SalParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(SalParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SalParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SalParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SalParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SalParser.ExpressionContext ctx);
}