// Generated from src/main/antlr4/SalParser.g4 by ANTLR 4.10.1
package sal.parser;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link SalParserVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class SalParserBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements SalParserVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitLit(SalParser.LitContext ctx) { return visitChildren(ctx); }
}