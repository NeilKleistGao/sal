// Generated from SalParser.g4 by ANTLR 4.10.1

  package sal.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SalParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SalParser#lit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLit(SalParser.LitContext ctx);
	/**
	 * Visit a parse tree produced by {@link SalParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SalParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SalParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SalParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SalParser#blockInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockInner(SalParser.BlockInnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link SalParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SalParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SalParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(SalParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SalParser#allTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllTypes(SalParser.AllTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link SalParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(SalParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SalParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SalParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(SalParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SalParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(SalParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link SalParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(SalParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SalParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(SalParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SalParser#application}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplication(SalParser.ApplicationContext ctx);
}