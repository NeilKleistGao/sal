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
		ANY_KW=8, TRUE_LIT=9, FALSE_LIT=10, NIX_LIT=11, STRING_LIT=12, LEFT_BRACES=13, 
		RIGHT_BRACES=14, LEFT_PARENTHESE=15, RIGHT_PARENTHESE=16, WS=17, NUMBER=18, 
		COLON_OP=19, ASSIGN_OP=20, COMMA_OP=21, ARROW_OP=22, ID=23;
	public static final int
		RULE_lit = 0, RULE_program = 1, RULE_statement = 2, RULE_blockInner = 3, 
		RULE_block = 4, RULE_typeName = 5, RULE_allTypes = 6, RULE_value = 7, 
		RULE_expression = 8, RULE_functionBody = 9, RULE_param = 10, RULE_params = 11, 
		RULE_function = 12, RULE_application = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"lit", "program", "statement", "blockInner", "block", "typeName", "allTypes", 
			"value", "expression", "functionBody", "param", "params", "function", 
			"application"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'val'", "'int'", "'float'", "'bool'", "'string'", "'fun'", "'void'", 
			"'anything'", "'true'", "'false'", "'nix'", null, "'{'", "'}'", "'('", 
			"')'", null, null, "':'", "'='", "','", "'->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAL_KW", "INT_KW", "FLOAT_KW", "BOOL_KW", "STRING_KW", "FUN_KW", 
			"VOID_KW", "ANY_KW", "TRUE_LIT", "FALSE_LIT", "NIX_LIT", "STRING_LIT", 
			"LEFT_BRACES", "RIGHT_BRACES", "LEFT_PARENTHESE", "RIGHT_PARENTHESE", 
			"WS", "NUMBER", "COLON_OP", "ASSIGN_OP", "COMMA_OP", "ARROW_OP", "ID"
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
		public TerminalNode NIX_LIT() { return getToken(SalParser.NIX_LIT, 0); }
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
			setState(28);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE_LIT) | (1L << FALSE_LIT) | (1L << NIX_LIT) | (1L << STRING_LIT) | (1L << NUMBER))) != 0)) ) {
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAL_KW) | (1L << FUN_KW) | (1L << ID))) != 0)) {
				{
				{
				setState(30);
				statement();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
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
		public ApplicationContext application() {
			return getRuleContext(ApplicationContext.class,0);
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
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAL_KW:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				value();
				}
				break;
			case FUN_KW:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				function();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				application();
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
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				expression();
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
			setState(47);
			match(LEFT_BRACES);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAL_KW) | (1L << FUN_KW) | (1L << TRUE_LIT) | (1L << FALSE_LIT) | (1L << NIX_LIT) | (1L << STRING_LIT) | (1L << NUMBER) | (1L << ID))) != 0)) {
				{
				{
				setState(48);
				blockInner();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
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
		public TerminalNode VOID_KW() { return getToken(SalParser.VOID_KW, 0); }
		public TerminalNode ANY_KW() { return getToken(SalParser.ANY_KW, 0); }
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
			setState(56);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_KW) | (1L << FLOAT_KW) | (1L << BOOL_KW) | (1L << STRING_KW) | (1L << VOID_KW) | (1L << ANY_KW))) != 0)) ) {
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

	public static class AllTypesContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode ARROW_OP() { return getToken(SalParser.ARROW_OP, 0); }
		public List<AllTypesContext> allTypes() {
			return getRuleContexts(AllTypesContext.class);
		}
		public AllTypesContext allTypes(int i) {
			return getRuleContext(AllTypesContext.class,i);
		}
		public TerminalNode LEFT_PARENTHESE() { return getToken(SalParser.LEFT_PARENTHESE, 0); }
		public TerminalNode RIGHT_PARENTHESE() { return getToken(SalParser.RIGHT_PARENTHESE, 0); }
		public AllTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterAllTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitAllTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitAllTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllTypesContext allTypes() throws RecognitionException {
		AllTypesContext _localctx = new AllTypesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_allTypes);
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				typeName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				typeName();
				setState(60);
				match(ARROW_OP);
				setState(61);
				allTypes();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				match(LEFT_PARENTHESE);
				setState(64);
				allTypes();
				setState(65);
				match(RIGHT_PARENTHESE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				match(LEFT_PARENTHESE);
				setState(68);
				allTypes();
				setState(69);
				match(RIGHT_PARENTHESE);
				setState(70);
				match(ARROW_OP);
				setState(71);
				allTypes();
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode VAL_KW() { return getToken(SalParser.VAL_KW, 0); }
		public TerminalNode ID() { return getToken(SalParser.ID, 0); }
		public TerminalNode COLON_OP() { return getToken(SalParser.COLON_OP, 0); }
		public AllTypesContext allTypes() {
			return getRuleContext(AllTypesContext.class,0);
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
		enterRule(_localctx, 14, RULE_value);
		try {
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				match(VAL_KW);
				setState(76);
				match(ID);
				setState(77);
				match(COLON_OP);
				setState(78);
				allTypes();
				setState(79);
				match(ASSIGN_OP);
				setState(80);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				match(VAL_KW);
				setState(83);
				match(ID);
				setState(84);
				match(ASSIGN_OP);
				setState(85);
				expression();
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

	public static class ExpressionContext extends ParserRuleContext {
		public LitContext lit() {
			return getRuleContext(LitContext.class,0);
		}
		public TerminalNode ID() { return getToken(SalParser.ID, 0); }
		public ApplicationContext application() {
			return getRuleContext(ApplicationContext.class,0);
		}
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
		enterRule(_localctx, 16, RULE_expression);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				lit();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				application();
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
		enterRule(_localctx, 18, RULE_functionBody);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_BRACES:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				block();
				}
				break;
			case TRUE_LIT:
			case FALSE_LIT:
			case NIX_LIT:
			case STRING_LIT:
			case NUMBER:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
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
		public AllTypesContext allTypes() {
			return getRuleContext(AllTypesContext.class,0);
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
		enterRule(_localctx, 20, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(ID);
			setState(98);
			match(COLON_OP);
			setState(99);
			allTypes();
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
		enterRule(_localctx, 22, RULE_params);
		int _la;
		try {
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(101);
				match(LEFT_PARENTHESE);
				setState(102);
				match(RIGHT_PARENTHESE);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(103);
				match(LEFT_PARENTHESE);
				setState(104);
				param();
				setState(105);
				match(RIGHT_PARENTHESE);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(107);
				match(LEFT_PARENTHESE);
				setState(108);
				param();
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA_OP) {
					{
					{
					setState(109);
					match(COMMA_OP);
					setState(110);
					param();
					}
					}
					setState(115);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(116);
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
		public AllTypesContext allTypes() {
			return getRuleContext(AllTypesContext.class,0);
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
		enterRule(_localctx, 24, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(FUN_KW);
			setState(121);
			match(ID);
			setState(122);
			params();
			setState(123);
			match(COLON_OP);
			setState(124);
			allTypes();
			setState(125);
			match(ASSIGN_OP);
			setState(126);
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

	public static class ApplicationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SalParser.ID, 0); }
		public TerminalNode LEFT_PARENTHESE() { return getToken(SalParser.LEFT_PARENTHESE, 0); }
		public TerminalNode RIGHT_PARENTHESE() { return getToken(SalParser.RIGHT_PARENTHESE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA_OP() { return getTokens(SalParser.COMMA_OP); }
		public TerminalNode COMMA_OP(int i) {
			return getToken(SalParser.COMMA_OP, i);
		}
		public ApplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_application; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitApplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitApplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApplicationContext application() throws RecognitionException {
		ApplicationContext _localctx = new ApplicationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_application);
		int _la;
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				match(ID);
				setState(129);
				match(LEFT_PARENTHESE);
				setState(130);
				match(RIGHT_PARENTHESE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(ID);
				setState(132);
				match(LEFT_PARENTHESE);
				setState(133);
				expression();
				setState(134);
				match(RIGHT_PARENTHESE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				match(ID);
				setState(137);
				match(LEFT_PARENTHESE);
				setState(138);
				expression();
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA_OP) {
					{
					{
					setState(139);
					match(COMMA_OP);
					setState(140);
					expression();
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(146);
				match(RIGHT_PARENTHESE);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0017\u0097\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0001\u0005"+
		"\u0001 \b\u0001\n\u0001\f\u0001#\t\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002*\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0003\u0003.\b\u0003\u0001\u0004\u0001\u0004\u0005\u00042\b\u0004"+
		"\n\u0004\f\u00045\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006J\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007W\b\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0003\b\\\b\b\u0001\t\u0001\t\u0003\t`\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000bp\b\u000b\n\u000b\f\u000bs\t\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000bw\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u008e\b\r\n"+
		"\r\f\r\u0091\t\r\u0001\r\u0001\r\u0003\r\u0095\b\r\u0001\r\u0000\u0000"+
		"\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u0000\u0002\u0002\u0000\t\f\u0012\u0012\u0002\u0000\u0002\u0005"+
		"\u0007\b\u009a\u0000\u001c\u0001\u0000\u0000\u0000\u0002!\u0001\u0000"+
		"\u0000\u0000\u0004)\u0001\u0000\u0000\u0000\u0006-\u0001\u0000\u0000\u0000"+
		"\b/\u0001\u0000\u0000\u0000\n8\u0001\u0000\u0000\u0000\fI\u0001\u0000"+
		"\u0000\u0000\u000eV\u0001\u0000\u0000\u0000\u0010[\u0001\u0000\u0000\u0000"+
		"\u0012_\u0001\u0000\u0000\u0000\u0014a\u0001\u0000\u0000\u0000\u0016v"+
		"\u0001\u0000\u0000\u0000\u0018x\u0001\u0000\u0000\u0000\u001a\u0094\u0001"+
		"\u0000\u0000\u0000\u001c\u001d\u0007\u0000\u0000\u0000\u001d\u0001\u0001"+
		"\u0000\u0000\u0000\u001e \u0003\u0004\u0002\u0000\u001f\u001e\u0001\u0000"+
		"\u0000\u0000 #\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000"+
		"!\"\u0001\u0000\u0000\u0000\"$\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000"+
		"\u0000$%\u0005\u0000\u0000\u0001%\u0003\u0001\u0000\u0000\u0000&*\u0003"+
		"\u000e\u0007\u0000\'*\u0003\u0018\f\u0000(*\u0003\u001a\r\u0000)&\u0001"+
		"\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000)(\u0001\u0000\u0000\u0000"+
		"*\u0005\u0001\u0000\u0000\u0000+.\u0003\u0004\u0002\u0000,.\u0003\u0010"+
		"\b\u0000-+\u0001\u0000\u0000\u0000-,\u0001\u0000\u0000\u0000.\u0007\u0001"+
		"\u0000\u0000\u0000/3\u0005\r\u0000\u000002\u0003\u0006\u0003\u000010\u0001"+
		"\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u0000"+
		"34\u0001\u0000\u0000\u000046\u0001\u0000\u0000\u000053\u0001\u0000\u0000"+
		"\u000067\u0005\u000e\u0000\u00007\t\u0001\u0000\u0000\u000089\u0007\u0001"+
		"\u0000\u00009\u000b\u0001\u0000\u0000\u0000:J\u0003\n\u0005\u0000;<\u0003"+
		"\n\u0005\u0000<=\u0005\u0016\u0000\u0000=>\u0003\f\u0006\u0000>J\u0001"+
		"\u0000\u0000\u0000?@\u0005\u000f\u0000\u0000@A\u0003\f\u0006\u0000AB\u0005"+
		"\u0010\u0000\u0000BJ\u0001\u0000\u0000\u0000CD\u0005\u000f\u0000\u0000"+
		"DE\u0003\f\u0006\u0000EF\u0005\u0010\u0000\u0000FG\u0005\u0016\u0000\u0000"+
		"GH\u0003\f\u0006\u0000HJ\u0001\u0000\u0000\u0000I:\u0001\u0000\u0000\u0000"+
		"I;\u0001\u0000\u0000\u0000I?\u0001\u0000\u0000\u0000IC\u0001\u0000\u0000"+
		"\u0000J\r\u0001\u0000\u0000\u0000KL\u0005\u0001\u0000\u0000LM\u0005\u0017"+
		"\u0000\u0000MN\u0005\u0013\u0000\u0000NO\u0003\f\u0006\u0000OP\u0005\u0014"+
		"\u0000\u0000PQ\u0003\u0010\b\u0000QW\u0001\u0000\u0000\u0000RS\u0005\u0001"+
		"\u0000\u0000ST\u0005\u0017\u0000\u0000TU\u0005\u0014\u0000\u0000UW\u0003"+
		"\u0010\b\u0000VK\u0001\u0000\u0000\u0000VR\u0001\u0000\u0000\u0000W\u000f"+
		"\u0001\u0000\u0000\u0000X\\\u0003\u0000\u0000\u0000Y\\\u0005\u0017\u0000"+
		"\u0000Z\\\u0003\u001a\r\u0000[X\u0001\u0000\u0000\u0000[Y\u0001\u0000"+
		"\u0000\u0000[Z\u0001\u0000\u0000\u0000\\\u0011\u0001\u0000\u0000\u0000"+
		"]`\u0003\b\u0004\u0000^`\u0003\u0010\b\u0000_]\u0001\u0000\u0000\u0000"+
		"_^\u0001\u0000\u0000\u0000`\u0013\u0001\u0000\u0000\u0000ab\u0005\u0017"+
		"\u0000\u0000bc\u0005\u0013\u0000\u0000cd\u0003\f\u0006\u0000d\u0015\u0001"+
		"\u0000\u0000\u0000ef\u0005\u000f\u0000\u0000fw\u0005\u0010\u0000\u0000"+
		"gh\u0005\u000f\u0000\u0000hi\u0003\u0014\n\u0000ij\u0005\u0010\u0000\u0000"+
		"jw\u0001\u0000\u0000\u0000kl\u0005\u000f\u0000\u0000lq\u0003\u0014\n\u0000"+
		"mn\u0005\u0015\u0000\u0000np\u0003\u0014\n\u0000om\u0001\u0000\u0000\u0000"+
		"ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000"+
		"\u0000rt\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tu\u0005\u0010"+
		"\u0000\u0000uw\u0001\u0000\u0000\u0000ve\u0001\u0000\u0000\u0000vg\u0001"+
		"\u0000\u0000\u0000vk\u0001\u0000\u0000\u0000w\u0017\u0001\u0000\u0000"+
		"\u0000xy\u0005\u0006\u0000\u0000yz\u0005\u0017\u0000\u0000z{\u0003\u0016"+
		"\u000b\u0000{|\u0005\u0013\u0000\u0000|}\u0003\f\u0006\u0000}~\u0005\u0014"+
		"\u0000\u0000~\u007f\u0003\u0012\t\u0000\u007f\u0019\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u0005\u0017\u0000\u0000\u0081\u0082\u0005\u000f\u0000"+
		"\u0000\u0082\u0095\u0005\u0010\u0000\u0000\u0083\u0084\u0005\u0017\u0000"+
		"\u0000\u0084\u0085\u0005\u000f\u0000\u0000\u0085\u0086\u0003\u0010\b\u0000"+
		"\u0086\u0087\u0005\u0010\u0000\u0000\u0087\u0095\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0005\u0017\u0000\u0000\u0089\u008a\u0005\u000f\u0000\u0000"+
		"\u008a\u008f\u0003\u0010\b\u0000\u008b\u008c\u0005\u0015\u0000\u0000\u008c"+
		"\u008e\u0003\u0010\b\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u0091"+
		"\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090"+
		"\u0001\u0000\u0000\u0000\u0090\u0092\u0001\u0000\u0000\u0000\u0091\u008f"+
		"\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u0010\u0000\u0000\u0093\u0095"+
		"\u0001\u0000\u0000\u0000\u0094\u0080\u0001\u0000\u0000\u0000\u0094\u0083"+
		"\u0001\u0000\u0000\u0000\u0094\u0088\u0001\u0000\u0000\u0000\u0095\u001b"+
		"\u0001\u0000\u0000\u0000\f!)-3IV[_qv\u008f\u0094";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}