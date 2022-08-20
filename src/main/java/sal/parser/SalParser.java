// Generated from SalParser.g4 by ANTLR 4.10.1

  package sal.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VAL_KW=1, INT_KW=2, FLOAT_KW=3, BOOL_KW=4, STRING_KW=5, FUN_KW=6, VOID_KW=7, 
		ANY_KW=8, TRUE_LIT=9, FALSE_LIT=10, STRING_LIT=11, LEFT_BRACES=12, RIGHT_BRACES=13, 
		LEFT_PARENTHESE=14, RIGHT_PARENTHESE=15, WS=16, NUMBER=17, COLON_OP=18, 
		ASSIGN_OP=19, COMMA_OP=20, ID=21;
	public static final int
		RULE_lit = 0, RULE_program = 1, RULE_statement = 2, RULE_blockInner = 3, 
		RULE_block = 4, RULE_typeName = 5, RULE_value = 6, RULE_expression = 7, 
		RULE_functionBody = 8, RULE_param = 9, RULE_params = 10, RULE_function = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"lit", "program", "statement", "blockInner", "block", "typeName", "value", 
			"expression", "functionBody", "param", "params", "function"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'val'", "'int'", "'float'", "'bool'", "'string'", "'fun'", "'void'", 
			"'anything'", "'true'", "'false'", null, "'{'", "'}'", "'('", "')'", 
			null, null, "':'", "'='", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAL_KW", "INT_KW", "FLOAT_KW", "BOOL_KW", "STRING_KW", "FUN_KW", 
			"VOID_KW", "ANY_KW", "TRUE_LIT", "FALSE_LIT", "STRING_LIT", "LEFT_BRACES", 
			"RIGHT_BRACES", "LEFT_PARENTHESE", "RIGHT_PARENTHESE", "WS", "NUMBER", 
			"COLON_OP", "ASSIGN_OP", "COMMA_OP", "ID"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SalParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class LitContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(SalParser.NUMBER, 0); }
		public TerminalNode TRUE_LIT() { return getToken(SalParser.TRUE_LIT, 0); }
		public TerminalNode FALSE_LIT() { return getToken(SalParser.FALSE_LIT, 0); }
		public TerminalNode STRING_LIT() { return getToken(SalParser.STRING_LIT, 0); }
		public TerminalNode VOID_KW() { return getToken(SalParser.VOID_KW, 0); }
		public TerminalNode ANY_KW() { return getToken(SalParser.ANY_KW, 0); }
		public LitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LitContext lit() throws RecognitionException {
		LitContext _localctx = new LitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_lit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID_KW) | (1L << ANY_KW) | (1L << TRUE_LIT) | (1L << FALSE_LIT) | (1L << STRING_LIT) | (1L << NUMBER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SalParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAL_KW || _la==FUN_KW) {
				{
				{
				setState(26);
				statement();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(36);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAL_KW:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				value();
				}
				break;
			case FUN_KW:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				function();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockInnerContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockInnerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockInner; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterBlockInner(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitBlockInner(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitBlockInner(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockInnerContext blockInner() throws RecognitionException {
		BlockInnerContext _localctx = new BlockInnerContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_blockInner);
		try {
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAL_KW:
			case FUN_KW:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				statement();
				}
				break;
			case VOID_KW:
			case ANY_KW:
			case TRUE_LIT:
			case FALSE_LIT:
			case STRING_LIT:
			case NUMBER:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACES() { return getToken(SalParser.LEFT_BRACES, 0); }
		public TerminalNode RIGHT_BRACES() { return getToken(SalParser.RIGHT_BRACES, 0); }
		public List<BlockInnerContext> blockInner() {
			return getRuleContexts(BlockInnerContext.class);
		}
		public BlockInnerContext blockInner(int i) {
			return getRuleContext(BlockInnerContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(LEFT_BRACES);
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAL_KW) | (1L << FUN_KW) | (1L << VOID_KW) | (1L << ANY_KW) | (1L << TRUE_LIT) | (1L << FALSE_LIT) | (1L << STRING_LIT) | (1L << NUMBER) | (1L << ID))) != 0)) {
				{
				{
				setState(43);
				blockInner();
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
			match(RIGHT_BRACES);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeNameContext extends ParserRuleContext {
		public TerminalNode INT_KW() { return getToken(SalParser.INT_KW, 0); }
		public TerminalNode FLOAT_KW() { return getToken(SalParser.FLOAT_KW, 0); }
		public TerminalNode BOOL_KW() { return getToken(SalParser.BOOL_KW, 0); }
		public TerminalNode STRING_KW() { return getToken(SalParser.STRING_KW, 0); }
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_KW) | (1L << FLOAT_KW) | (1L << BOOL_KW) | (1L << STRING_KW))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode VAL_KW() { return getToken(SalParser.VAL_KW, 0); }
		public TerminalNode ID() { return getToken(SalParser.ID, 0); }
		public TerminalNode COLON_OP() { return getToken(SalParser.COLON_OP, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode ASSIGN_OP() { return getToken(SalParser.ASSIGN_OP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(VAL_KW);
			setState(54);
			match(ID);
			setState(55);
			match(COLON_OP);
			setState(56);
			typeName();
			setState(57);
			match(ASSIGN_OP);
			setState(58);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public LitContext lit() {
			return getRuleContext(LitContext.class,0);
		}
		public TerminalNode ID() { return getToken(SalParser.ID, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expression);
		try {
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID_KW:
			case ANY_KW:
			case TRUE_LIT:
			case FALSE_LIT:
			case STRING_LIT:
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				lit();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterFunctionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitFunctionBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitFunctionBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionBodyContext functionBody() throws RecognitionException {
		FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionBody);
		try {
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_BRACES:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				block();
				}
				break;
			case VOID_KW:
			case ANY_KW:
			case TRUE_LIT:
			case FALSE_LIT:
			case STRING_LIT:
			case NUMBER:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SalParser.ID, 0); }
		public TerminalNode COLON_OP() { return getToken(SalParser.COLON_OP, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(ID);
			setState(69);
			match(COLON_OP);
			setState(70);
			typeName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public TerminalNode LEFT_PARENTHESE() { return getToken(SalParser.LEFT_PARENTHESE, 0); }
		public TerminalNode RIGHT_PARENTHESE() { return getToken(SalParser.RIGHT_PARENTHESE, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA_OP() { return getTokens(SalParser.COMMA_OP); }
		public TerminalNode COMMA_OP(int i) {
			return getToken(SalParser.COMMA_OP, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_params);
		int _la;
		try {
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(72);
				match(LEFT_PARENTHESE);
				setState(73);
				match(RIGHT_PARENTHESE);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(74);
				match(LEFT_PARENTHESE);
				setState(75);
				param();
				setState(76);
				match(RIGHT_PARENTHESE);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(78);
				match(LEFT_PARENTHESE);
				setState(79);
				param();
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA_OP) {
					{
					{
					setState(80);
					match(COMMA_OP);
					setState(81);
					param();
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(87);
				match(RIGHT_PARENTHESE);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode FUN_KW() { return getToken(SalParser.FUN_KW, 0); }
		public TerminalNode ID() { return getToken(SalParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode COLON_OP() { return getToken(SalParser.COLON_OP, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode ASSIGN_OP() { return getToken(SalParser.ASSIGN_OP, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(FUN_KW);
			setState(92);
			match(ID);
			setState(93);
			params();
			setState(94);
			match(COLON_OP);
			setState(95);
			typeName();
			setState(96);
			match(ASSIGN_OP);
			setState(97);
			functionBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0015d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0005\u0001\u001c\b\u0001\n\u0001\f\u0001"+
		"\u001f\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0003\u0002"+
		"%\b\u0002\u0001\u0003\u0001\u0003\u0003\u0003)\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0005\u0004-\b\u0004\n\u0004\f\u00040\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003"+
		"\u0007?\b\u0007\u0001\b\u0001\b\u0003\bC\b\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0005\nS\b\n\n\n\f\nV\t\n\u0001\n\u0001\n\u0003\nZ\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0000\u0000\f\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0002\u0002\u0000\u0007\u000b"+
		"\u0011\u0011\u0001\u0000\u0002\u0005`\u0000\u0018\u0001\u0000\u0000\u0000"+
		"\u0002\u001d\u0001\u0000\u0000\u0000\u0004$\u0001\u0000\u0000\u0000\u0006"+
		"(\u0001\u0000\u0000\u0000\b*\u0001\u0000\u0000\u0000\n3\u0001\u0000\u0000"+
		"\u0000\f5\u0001\u0000\u0000\u0000\u000e>\u0001\u0000\u0000\u0000\u0010"+
		"B\u0001\u0000\u0000\u0000\u0012D\u0001\u0000\u0000\u0000\u0014Y\u0001"+
		"\u0000\u0000\u0000\u0016[\u0001\u0000\u0000\u0000\u0018\u0019\u0007\u0000"+
		"\u0000\u0000\u0019\u0001\u0001\u0000\u0000\u0000\u001a\u001c\u0003\u0004"+
		"\u0002\u0000\u001b\u001a\u0001\u0000\u0000\u0000\u001c\u001f\u0001\u0000"+
		"\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000"+
		"\u0000\u0000\u001e \u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000"+
		"\u0000 !\u0005\u0000\u0000\u0001!\u0003\u0001\u0000\u0000\u0000\"%\u0003"+
		"\f\u0006\u0000#%\u0003\u0016\u000b\u0000$\"\u0001\u0000\u0000\u0000$#"+
		"\u0001\u0000\u0000\u0000%\u0005\u0001\u0000\u0000\u0000&)\u0003\u0004"+
		"\u0002\u0000\')\u0003\u000e\u0007\u0000(&\u0001\u0000\u0000\u0000(\'\u0001"+
		"\u0000\u0000\u0000)\u0007\u0001\u0000\u0000\u0000*.\u0005\f\u0000\u0000"+
		"+-\u0003\u0006\u0003\u0000,+\u0001\u0000\u0000\u0000-0\u0001\u0000\u0000"+
		"\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/1\u0001\u0000"+
		"\u0000\u00000.\u0001\u0000\u0000\u000012\u0005\r\u0000\u00002\t\u0001"+
		"\u0000\u0000\u000034\u0007\u0001\u0000\u00004\u000b\u0001\u0000\u0000"+
		"\u000056\u0005\u0001\u0000\u000067\u0005\u0015\u0000\u000078\u0005\u0012"+
		"\u0000\u000089\u0003\n\u0005\u00009:\u0005\u0013\u0000\u0000:;\u0003\u000e"+
		"\u0007\u0000;\r\u0001\u0000\u0000\u0000<?\u0003\u0000\u0000\u0000=?\u0005"+
		"\u0015\u0000\u0000><\u0001\u0000\u0000\u0000>=\u0001\u0000\u0000\u0000"+
		"?\u000f\u0001\u0000\u0000\u0000@C\u0003\b\u0004\u0000AC\u0003\u000e\u0007"+
		"\u0000B@\u0001\u0000\u0000\u0000BA\u0001\u0000\u0000\u0000C\u0011\u0001"+
		"\u0000\u0000\u0000DE\u0005\u0015\u0000\u0000EF\u0005\u0012\u0000\u0000"+
		"FG\u0003\n\u0005\u0000G\u0013\u0001\u0000\u0000\u0000HI\u0005\u000e\u0000"+
		"\u0000IZ\u0005\u000f\u0000\u0000JK\u0005\u000e\u0000\u0000KL\u0003\u0012"+
		"\t\u0000LM\u0005\u000f\u0000\u0000MZ\u0001\u0000\u0000\u0000NO\u0005\u000e"+
		"\u0000\u0000OT\u0003\u0012\t\u0000PQ\u0005\u0014\u0000\u0000QS\u0003\u0012"+
		"\t\u0000RP\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000"+
		"\u0000\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000VT\u0001"+
		"\u0000\u0000\u0000WX\u0005\u000f\u0000\u0000XZ\u0001\u0000\u0000\u0000"+
		"YH\u0001\u0000\u0000\u0000YJ\u0001\u0000\u0000\u0000YN\u0001\u0000\u0000"+
		"\u0000Z\u0015\u0001\u0000\u0000\u0000[\\\u0005\u0006\u0000\u0000\\]\u0005"+
		"\u0015\u0000\u0000]^\u0003\u0014\n\u0000^_\u0005\u0012\u0000\u0000_`\u0003"+
		"\n\u0005\u0000`a\u0005\u0013\u0000\u0000ab\u0003\u0010\b\u0000b\u0017"+
		"\u0001\u0000\u0000\u0000\b\u001d$(.>BTY";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}