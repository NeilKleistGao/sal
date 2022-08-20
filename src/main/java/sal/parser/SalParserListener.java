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
	 * Enter a parse tree produced by {@link SalParser#blockInner}.
	 * @param ctx the parse tree
	 */
	void enterBlockInner(SalParser.BlockInnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SalParser#blockInner}.
	 * @param ctx the parse tree
	 */
	void exitBlockInner(SalParser.BlockInnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SalParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SalParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SalParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SalParser.BlockContext ctx);
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
	 * Enter a parse tree produced by {@link SalParser#allTypes}.
	 * @param ctx the parse tree
	 */
	void enterAllTypes(SalParser.AllTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SalParser#allTypes}.
	 * @param ctx the parse tree
	 */
	void exitAllTypes(SalParser.AllTypesContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link SalParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(SalParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SalParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(SalParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SalParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(SalParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link SalParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(SalParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link SalParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(SalParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SalParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(SalParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SalParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(SalParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SalParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(SalParser.FunctionContext ctx);
}