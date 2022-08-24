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
		ANY_KW=8, REC_KW=9, NEW_KW=10, TRUE_LIT=11, FALSE_LIT=12, NIX_LIT=13, 
		STRING_LIT=14, LEFT_BRACES=15, RIGHT_BRACES=16, LEFT_PARENTHESE=17, RIGHT_PARENTHESE=18, 
		WS=19, NUMBER=20, COLON_OP=21, ASSIGN_OP=22, COMMA_OP=23, ARROW_OP=24, 
		DOT_OP=25, ID=26;
	public static final int
		RULE_lit = 0, RULE_program = 1, RULE_statement = 2, RULE_blockInner = 3, 
		RULE_block = 4, RULE_typeName = 5, RULE_allTypes = 6, RULE_value = 7, 
		RULE_expression = 8, RULE_functionBody = 9, RULE_param = 10, RULE_params = 11, 
		RULE_field = 12, RULE_fields = 13, RULE_function = 14, RULE_application = 15, 
		RULE_record = 16, RULE_access = 17, RULE_initializer = 18, RULE_create = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"lit", "program", "statement", "blockInner", "block", "typeName", "allTypes", 
			"value", "expression", "functionBody", "param", "params", "field", "fields", 
			"function", "application", "record", "access", "initializer", "create"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'val'", "'int'", "'float'", "'bool'", "'string'", "'fun'", "'void'", 
			"'anything'", "'rec'", "'new'", "'true'", "'false'", "'nix'", null, "'{'", 
			"'}'", "'('", "')'", null, null, "':'", "'='", "','", "'->'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAL_KW", "INT_KW", "FLOAT_KW", "BOOL_KW", "STRING_KW", "FUN_KW", 
			"VOID_KW", "ANY_KW", "REC_KW", "NEW_KW", "TRUE_LIT", "FALSE_LIT", "NIX_LIT", 
			"STRING_LIT", "LEFT_BRACES", "RIGHT_BRACES", "LEFT_PARENTHESE", "RIGHT_PARENTHESE", 
			"WS", "NUMBER", "COLON_OP", "ASSIGN_OP", "COMMA_OP", "ARROW_OP", "DOT_OP", 
			"ID"
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
			setState(40);
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
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAL_KW) | (1L << FUN_KW) | (1L << REC_KW) | (1L << ID))) != 0)) {
				{
				{
				setState(42);
				statement();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
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
		public RecordContext record() {
			return getRuleContext(RecordContext.class,0);
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
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAL_KW:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				value();
				}
				break;
			case FUN_KW:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				function();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				application();
				}
				break;
			case REC_KW:
				enterOuterAlt(_localctx, 4);
				{
				setState(53);
				record();
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
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
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
			setState(60);
			match(LEFT_BRACES);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAL_KW) | (1L << FUN_KW) | (1L << REC_KW) | (1L << NEW_KW) | (1L << TRUE_LIT) | (1L << FALSE_LIT) | (1L << NIX_LIT) | (1L << STRING_LIT) | (1L << NUMBER) | (1L << ID))) != 0)) {
				{
				{
				setState(61);
				blockInner();
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
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
			setState(69);
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
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				typeName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				typeName();
				setState(73);
				match(ARROW_OP);
				setState(74);
				allTypes();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				match(LEFT_PARENTHESE);
				setState(77);
				allTypes();
				setState(78);
				match(RIGHT_PARENTHESE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				match(LEFT_PARENTHESE);
				setState(81);
				allTypes();
				setState(82);
				match(RIGHT_PARENTHESE);
				setState(83);
				match(ARROW_OP);
				setState(84);
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
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				match(VAL_KW);
				setState(89);
				match(ID);
				setState(90);
				match(COLON_OP);
				setState(91);
				allTypes();
				setState(92);
				match(ASSIGN_OP);
				setState(93);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				match(VAL_KW);
				setState(96);
				match(ID);
				setState(97);
				match(ASSIGN_OP);
				setState(98);
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
		public AccessContext access() {
			return getRuleContext(AccessContext.class,0);
		}
		public CreateContext create() {
			return getRuleContext(CreateContext.class,0);
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
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				lit();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				application();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(104);
				access();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(105);
				create();
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
			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_BRACES:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				block();
				}
				break;
			case NEW_KW:
			case TRUE_LIT:
			case FALSE_LIT:
			case NIX_LIT:
			case STRING_LIT:
			case NUMBER:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
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
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(ID);
				setState(113);
				match(COLON_OP);
				setState(114);
				allTypes();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				match(ID);
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
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(118);
				match(LEFT_PARENTHESE);
				setState(119);
				match(RIGHT_PARENTHESE);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(120);
				match(LEFT_PARENTHESE);
				setState(121);
				param();
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA_OP) {
					{
					{
					setState(122);
					match(COMMA_OP);
					setState(123);
					param();
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(129);
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

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SalParser.ID, 0); }
		public TerminalNode COLON_OP() { return getToken(SalParser.COLON_OP, 0); }
		public AllTypesContext allTypes() {
			return getRuleContext(AllTypesContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_field);
		try {
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				match(ID);
				setState(134);
				match(COLON_OP);
				setState(135);
				allTypes();
				}
				break;
			case FUN_KW:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
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

	public static class FieldsContext extends ParserRuleContext {
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<TerminalNode> COMMA_OP() { return getTokens(SalParser.COMMA_OP); }
		public TerminalNode COMMA_OP(int i) {
			return getToken(SalParser.COMMA_OP, i);
		}
		public FieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fields; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterFields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitFields(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitFields(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldsContext fields() throws RecognitionException {
		FieldsContext _localctx = new FieldsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			field();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_OP) {
				{
				{
				setState(140);
				match(COMMA_OP);
				setState(141);
				field();
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
		enterRule(_localctx, 28, RULE_function);
		try {
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(FUN_KW);
				setState(148);
				match(ID);
				setState(149);
				params();
				setState(150);
				match(COLON_OP);
				setState(151);
				allTypes();
				setState(152);
				match(ASSIGN_OP);
				setState(153);
				functionBody();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				match(FUN_KW);
				setState(156);
				match(ID);
				setState(157);
				params();
				setState(158);
				match(ASSIGN_OP);
				setState(159);
				functionBody();
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
		enterRule(_localctx, 30, RULE_application);
		int _la;
		try {
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(ID);
				setState(164);
				match(LEFT_PARENTHESE);
				setState(165);
				match(RIGHT_PARENTHESE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				match(ID);
				setState(167);
				match(LEFT_PARENTHESE);
				setState(168);
				expression();
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA_OP) {
					{
					{
					setState(169);
					match(COMMA_OP);
					setState(170);
					expression();
					}
					}
					setState(175);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(176);
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

	public static class RecordContext extends ParserRuleContext {
		public TerminalNode REC_KW() { return getToken(SalParser.REC_KW, 0); }
		public TerminalNode ID() { return getToken(SalParser.ID, 0); }
		public TerminalNode LEFT_BRACES() { return getToken(SalParser.LEFT_BRACES, 0); }
		public TerminalNode RIGHT_BRACES() { return getToken(SalParser.RIGHT_BRACES, 0); }
		public FieldsContext fields() {
			return getRuleContext(FieldsContext.class,0);
		}
		public RecordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_record; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterRecord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitRecord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitRecord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordContext record() throws RecognitionException {
		RecordContext _localctx = new RecordContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_record);
		try {
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				match(REC_KW);
				setState(181);
				match(ID);
				setState(182);
				match(LEFT_BRACES);
				setState(183);
				match(RIGHT_BRACES);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				match(REC_KW);
				setState(185);
				match(ID);
				setState(186);
				match(LEFT_BRACES);
				setState(187);
				fields();
				setState(188);
				match(RIGHT_BRACES);
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

	public static class AccessContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SalParser.ID, i);
		}
		public TerminalNode DOT_OP() { return getToken(SalParser.DOT_OP, 0); }
		public AccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessContext access() throws RecognitionException {
		AccessContext _localctx = new AccessContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(ID);
			setState(193);
			match(DOT_OP);
			setState(194);
			match(ID);
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

	public static class InitializerContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SalParser.ID, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(SalParser.ASSIGN_OP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_initializer);
		try {
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				match(ID);
				setState(197);
				match(ASSIGN_OP);
				setState(198);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
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

	public static class CreateContext extends ParserRuleContext {
		public TerminalNode NEW_KW() { return getToken(SalParser.NEW_KW, 0); }
		public TerminalNode ID() { return getToken(SalParser.ID, 0); }
		public TerminalNode LEFT_BRACES() { return getToken(SalParser.LEFT_BRACES, 0); }
		public TerminalNode RIGHT_BRACES() { return getToken(SalParser.RIGHT_BRACES, 0); }
		public List<InitializerContext> initializer() {
			return getRuleContexts(InitializerContext.class);
		}
		public InitializerContext initializer(int i) {
			return getRuleContext(InitializerContext.class,i);
		}
		public List<TerminalNode> COMMA_OP() { return getTokens(SalParser.COMMA_OP); }
		public TerminalNode COMMA_OP(int i) {
			return getToken(SalParser.COMMA_OP, i);
		}
		public CreateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterCreate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitCreate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitCreate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateContext create() throws RecognitionException {
		CreateContext _localctx = new CreateContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_create);
		int _la;
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				match(NEW_KW);
				setState(203);
				match(ID);
				setState(204);
				match(LEFT_BRACES);
				setState(205);
				match(RIGHT_BRACES);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				match(NEW_KW);
				setState(207);
				match(ID);
				setState(208);
				match(LEFT_BRACES);
				setState(209);
				initializer();
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA_OP) {
					{
					{
					setState(210);
					match(COMMA_OP);
					setState(211);
					initializer();
					}
					}
					setState(216);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(217);
				match(RIGHT_BRACES);
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
		"\u0004\u0001\u001a\u00de\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0001\u0005"+
		"\u0001,\b\u0001\n\u0001\f\u0001/\t\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00027\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0003\u0003;\b\u0003\u0001\u0004\u0001\u0004\u0005"+
		"\u0004?\b\u0004\n\u0004\f\u0004B\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006W\b"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007d\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bk\b\b\u0001"+
		"\t\u0001\t\u0003\to\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0003\nu\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b}\b\u000b\n\u000b\f\u000b\u0080\t\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u0084\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u008a"+
		"\b\f\u0001\r\u0001\r\u0001\r\u0005\r\u008f\b\r\n\r\f\r\u0092\t\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u00a2\b\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005"+
		"\u000f\u00ac\b\u000f\n\u000f\f\u000f\u00af\t\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u00b3\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0003\u0010\u00bf\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00c9\b\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u00d5\b\u0013"+
		"\n\u0013\f\u0013\u00d8\t\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00dc"+
		"\b\u0013\u0001\u0013\u0000\u0000\u0014\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000\u0002\u0002"+
		"\u0000\u000b\u000e\u0014\u0014\u0002\u0000\u0002\u0005\u0007\b\u00e4\u0000"+
		"(\u0001\u0000\u0000\u0000\u0002-\u0001\u0000\u0000\u0000\u00046\u0001"+
		"\u0000\u0000\u0000\u0006:\u0001\u0000\u0000\u0000\b<\u0001\u0000\u0000"+
		"\u0000\nE\u0001\u0000\u0000\u0000\fV\u0001\u0000\u0000\u0000\u000ec\u0001"+
		"\u0000\u0000\u0000\u0010j\u0001\u0000\u0000\u0000\u0012n\u0001\u0000\u0000"+
		"\u0000\u0014t\u0001\u0000\u0000\u0000\u0016\u0083\u0001\u0000\u0000\u0000"+
		"\u0018\u0089\u0001\u0000\u0000\u0000\u001a\u008b\u0001\u0000\u0000\u0000"+
		"\u001c\u00a1\u0001\u0000\u0000\u0000\u001e\u00b2\u0001\u0000\u0000\u0000"+
		" \u00be\u0001\u0000\u0000\u0000\"\u00c0\u0001\u0000\u0000\u0000$\u00c8"+
		"\u0001\u0000\u0000\u0000&\u00db\u0001\u0000\u0000\u0000()\u0007\u0000"+
		"\u0000\u0000)\u0001\u0001\u0000\u0000\u0000*,\u0003\u0004\u0002\u0000"+
		"+*\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000"+
		"\u0000-.\u0001\u0000\u0000\u0000.0\u0001\u0000\u0000\u0000/-\u0001\u0000"+
		"\u0000\u000001\u0005\u0000\u0000\u00011\u0003\u0001\u0000\u0000\u0000"+
		"27\u0003\u000e\u0007\u000037\u0003\u001c\u000e\u000047\u0003\u001e\u000f"+
		"\u000057\u0003 \u0010\u000062\u0001\u0000\u0000\u000063\u0001\u0000\u0000"+
		"\u000064\u0001\u0000\u0000\u000065\u0001\u0000\u0000\u00007\u0005\u0001"+
		"\u0000\u0000\u00008;\u0003\u0004\u0002\u00009;\u0003\u0010\b\u0000:8\u0001"+
		"\u0000\u0000\u0000:9\u0001\u0000\u0000\u0000;\u0007\u0001\u0000\u0000"+
		"\u0000<@\u0005\u000f\u0000\u0000=?\u0003\u0006\u0003\u0000>=\u0001\u0000"+
		"\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001"+
		"\u0000\u0000\u0000AC\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000"+
		"CD\u0005\u0010\u0000\u0000D\t\u0001\u0000\u0000\u0000EF\u0007\u0001\u0000"+
		"\u0000F\u000b\u0001\u0000\u0000\u0000GW\u0003\n\u0005\u0000HI\u0003\n"+
		"\u0005\u0000IJ\u0005\u0018\u0000\u0000JK\u0003\f\u0006\u0000KW\u0001\u0000"+
		"\u0000\u0000LM\u0005\u0011\u0000\u0000MN\u0003\f\u0006\u0000NO\u0005\u0012"+
		"\u0000\u0000OW\u0001\u0000\u0000\u0000PQ\u0005\u0011\u0000\u0000QR\u0003"+
		"\f\u0006\u0000RS\u0005\u0012\u0000\u0000ST\u0005\u0018\u0000\u0000TU\u0003"+
		"\f\u0006\u0000UW\u0001\u0000\u0000\u0000VG\u0001\u0000\u0000\u0000VH\u0001"+
		"\u0000\u0000\u0000VL\u0001\u0000\u0000\u0000VP\u0001\u0000\u0000\u0000"+
		"W\r\u0001\u0000\u0000\u0000XY\u0005\u0001\u0000\u0000YZ\u0005\u001a\u0000"+
		"\u0000Z[\u0005\u0015\u0000\u0000[\\\u0003\f\u0006\u0000\\]\u0005\u0016"+
		"\u0000\u0000]^\u0003\u0010\b\u0000^d\u0001\u0000\u0000\u0000_`\u0005\u0001"+
		"\u0000\u0000`a\u0005\u001a\u0000\u0000ab\u0005\u0016\u0000\u0000bd\u0003"+
		"\u0010\b\u0000cX\u0001\u0000\u0000\u0000c_\u0001\u0000\u0000\u0000d\u000f"+
		"\u0001\u0000\u0000\u0000ek\u0003\u0000\u0000\u0000fk\u0005\u001a\u0000"+
		"\u0000gk\u0003\u001e\u000f\u0000hk\u0003\"\u0011\u0000ik\u0003&\u0013"+
		"\u0000je\u0001\u0000\u0000\u0000jf\u0001\u0000\u0000\u0000jg\u0001\u0000"+
		"\u0000\u0000jh\u0001\u0000\u0000\u0000ji\u0001\u0000\u0000\u0000k\u0011"+
		"\u0001\u0000\u0000\u0000lo\u0003\b\u0004\u0000mo\u0003\u0010\b\u0000n"+
		"l\u0001\u0000\u0000\u0000nm\u0001\u0000\u0000\u0000o\u0013\u0001\u0000"+
		"\u0000\u0000pq\u0005\u001a\u0000\u0000qr\u0005\u0015\u0000\u0000ru\u0003"+
		"\f\u0006\u0000su\u0005\u001a\u0000\u0000tp\u0001\u0000\u0000\u0000ts\u0001"+
		"\u0000\u0000\u0000u\u0015\u0001\u0000\u0000\u0000vw\u0005\u0011\u0000"+
		"\u0000w\u0084\u0005\u0012\u0000\u0000xy\u0005\u0011\u0000\u0000y~\u0003"+
		"\u0014\n\u0000z{\u0005\u0017\u0000\u0000{}\u0003\u0014\n\u0000|z\u0001"+
		"\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000"+
		"\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0081\u0001\u0000\u0000\u0000"+
		"\u0080~\u0001\u0000\u0000\u0000\u0081\u0082\u0005\u0012\u0000\u0000\u0082"+
		"\u0084\u0001\u0000\u0000\u0000\u0083v\u0001\u0000\u0000\u0000\u0083x\u0001"+
		"\u0000\u0000\u0000\u0084\u0017\u0001\u0000\u0000\u0000\u0085\u0086\u0005"+
		"\u001a\u0000\u0000\u0086\u0087\u0005\u0015\u0000\u0000\u0087\u008a\u0003"+
		"\f\u0006\u0000\u0088\u008a\u0003\u001c\u000e\u0000\u0089\u0085\u0001\u0000"+
		"\u0000\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a\u0019\u0001\u0000"+
		"\u0000\u0000\u008b\u0090\u0003\u0018\f\u0000\u008c\u008d\u0005\u0017\u0000"+
		"\u0000\u008d\u008f\u0003\u0018\f\u0000\u008e\u008c\u0001\u0000\u0000\u0000"+
		"\u008f\u0092\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u001b\u0001\u0000\u0000\u0000"+
		"\u0092\u0090\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u0006\u0000\u0000"+
		"\u0094\u0095\u0005\u001a\u0000\u0000\u0095\u0096\u0003\u0016\u000b\u0000"+
		"\u0096\u0097\u0005\u0015\u0000\u0000\u0097\u0098\u0003\f\u0006\u0000\u0098"+
		"\u0099\u0005\u0016\u0000\u0000\u0099\u009a\u0003\u0012\t\u0000\u009a\u00a2"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u0005\u0006\u0000\u0000\u009c\u009d"+
		"\u0005\u001a\u0000\u0000\u009d\u009e\u0003\u0016\u000b\u0000\u009e\u009f"+
		"\u0005\u0016\u0000\u0000\u009f\u00a0\u0003\u0012\t\u0000\u00a0\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a1\u0093\u0001\u0000\u0000\u0000\u00a1\u009b\u0001"+
		"\u0000\u0000\u0000\u00a2\u001d\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005"+
		"\u001a\u0000\u0000\u00a4\u00a5\u0005\u0011\u0000\u0000\u00a5\u00b3\u0005"+
		"\u0012\u0000\u0000\u00a6\u00a7\u0005\u001a\u0000\u0000\u00a7\u00a8\u0005"+
		"\u0011\u0000\u0000\u00a8\u00ad\u0003\u0010\b\u0000\u00a9\u00aa\u0005\u0017"+
		"\u0000\u0000\u00aa\u00ac\u0003\u0010\b\u0000\u00ab\u00a9\u0001\u0000\u0000"+
		"\u0000\u00ac\u00af\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00b0\u0001\u0000\u0000"+
		"\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u0012\u0000"+
		"\u0000\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u00a3\u0001\u0000\u0000"+
		"\u0000\u00b2\u00a6\u0001\u0000\u0000\u0000\u00b3\u001f\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b5\u0005\t\u0000\u0000\u00b5\u00b6\u0005\u001a\u0000\u0000"+
		"\u00b6\u00b7\u0005\u000f\u0000\u0000\u00b7\u00bf\u0005\u0010\u0000\u0000"+
		"\u00b8\u00b9\u0005\t\u0000\u0000\u00b9\u00ba\u0005\u001a\u0000\u0000\u00ba"+
		"\u00bb\u0005\u000f\u0000\u0000\u00bb\u00bc\u0003\u001a\r\u0000\u00bc\u00bd"+
		"\u0005\u0010\u0000\u0000\u00bd\u00bf\u0001\u0000\u0000\u0000\u00be\u00b4"+
		"\u0001\u0000\u0000\u0000\u00be\u00b8\u0001\u0000\u0000\u0000\u00bf!\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c1\u0005\u001a\u0000\u0000\u00c1\u00c2\u0005"+
		"\u0019\u0000\u0000\u00c2\u00c3\u0005\u001a\u0000\u0000\u00c3#\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c5\u0005\u001a\u0000\u0000\u00c5\u00c6\u0005\u0016"+
		"\u0000\u0000\u00c6\u00c9\u0003\u0010\b\u0000\u00c7\u00c9\u0003\u0010\b"+
		"\u0000\u00c8\u00c4\u0001\u0000\u0000\u0000\u00c8\u00c7\u0001\u0000\u0000"+
		"\u0000\u00c9%\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005\n\u0000\u0000"+
		"\u00cb\u00cc\u0005\u001a\u0000\u0000\u00cc\u00cd\u0005\u000f\u0000\u0000"+
		"\u00cd\u00dc\u0005\u0010\u0000\u0000\u00ce\u00cf\u0005\n\u0000\u0000\u00cf"+
		"\u00d0\u0005\u001a\u0000\u0000\u00d0\u00d1\u0005\u000f\u0000\u0000\u00d1"+
		"\u00d6\u0003$\u0012\u0000\u00d2\u00d3\u0005\u0017\u0000\u0000\u00d3\u00d5"+
		"\u0003$\u0012\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d5\u00d8\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d7\u00d9\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001"+
		"\u0000\u0000\u0000\u00d9\u00da\u0005\u0010\u0000\u0000\u00da\u00dc\u0001"+
		"\u0000\u0000\u0000\u00db\u00ca\u0001\u0000\u0000\u0000\u00db\u00ce\u0001"+
		"\u0000\u0000\u0000\u00dc\'\u0001\u0000\u0000\u0000\u0014-6:@Vcjnt~\u0083"+
		"\u0089\u0090\u00a1\u00ad\u00b2\u00be\u00c8\u00d6\u00db";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}