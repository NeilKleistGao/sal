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
		ANY_KW=8, REC_KW=9, NEW_KW=10, IF_KW=11, ELSE_KW=12, AS_KW=13, TRUE_LIT=14, 
		FALSE_LIT=15, NIX_LIT=16, STRING_LIT=17, LEFT_BRACES=18, RIGHT_BRACES=19, 
		LEFT_PARENTHESE=20, RIGHT_PARENTHESE=21, LEFT_SQUARE=22, RIGHT_SQUARE=23, 
		WS=24, NUMBER=25, COLON_OP=26, ASSIGN_OP=27, COMMA_OP=28, ARROW_OP=29, 
		DOT_OP=30, BIT_AND_OP=31, BIT_OR_OP=32, BIT_NOT_OP=33, BIT_XOR_OP=34, 
		LEFT_SHIFT_OP=35, RIGHT_SHIFT_OP=36, LOGIC_AND_OP=37, LOGIC_OR_OP=38, 
		LOGIC_NOT_OP=39, ADD_OP=40, SUB_OP=41, MUL_OP=42, DIV_OP=43, MOD_OP=44, 
		POW_OP=45, ID=46;
	public static final int
		RULE_lit = 0, RULE_program = 1, RULE_statement = 2, RULE_blockInner = 3, 
		RULE_block = 4, RULE_typeName = 5, RULE_allTypes = 6, RULE_value = 7, 
		RULE_expression = 8, RULE_functionBody = 9, RULE_param = 10, RULE_params = 11, 
		RULE_field = 12, RULE_fields = 13, RULE_function = 14, RULE_application = 15, 
		RULE_record = 16, RULE_initializer = 17, RULE_create = 18, RULE_ifCondition = 19, 
		RULE_elseIfCondition = 20, RULE_elseBlock = 21, RULE_lambda = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"lit", "program", "statement", "blockInner", "block", "typeName", "allTypes", 
			"value", "expression", "functionBody", "param", "params", "field", "fields", 
			"function", "application", "record", "initializer", "create", "ifCondition", 
			"elseIfCondition", "elseBlock", "lambda"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'val'", "'int'", "'float'", "'bool'", "'string'", "'fun'", "'void'", 
			"'anything'", "'rec'", "'new'", "'if'", "'else'", "'as'", "'true'", "'false'", 
			"'nix'", null, "'{'", "'}'", "'('", "')'", "'['", "']'", null, null, 
			"':'", "'='", "','", "'->'", "'.'", "'&'", "'|'", "'~'", "'^'", "'<<'", 
			"'>>'", "'&&'", "'||'", "'!'", "'+'", "'-'", "'*'", "'/'", "'%'", "'^^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAL_KW", "INT_KW", "FLOAT_KW", "BOOL_KW", "STRING_KW", "FUN_KW", 
			"VOID_KW", "ANY_KW", "REC_KW", "NEW_KW", "IF_KW", "ELSE_KW", "AS_KW", 
			"TRUE_LIT", "FALSE_LIT", "NIX_LIT", "STRING_LIT", "LEFT_BRACES", "RIGHT_BRACES", 
			"LEFT_PARENTHESE", "RIGHT_PARENTHESE", "LEFT_SQUARE", "RIGHT_SQUARE", 
			"WS", "NUMBER", "COLON_OP", "ASSIGN_OP", "COMMA_OP", "ARROW_OP", "DOT_OP", 
			"BIT_AND_OP", "BIT_OR_OP", "BIT_NOT_OP", "BIT_XOR_OP", "LEFT_SHIFT_OP", 
			"RIGHT_SHIFT_OP", "LOGIC_AND_OP", "LOGIC_OR_OP", "LOGIC_NOT_OP", "ADD_OP", 
			"SUB_OP", "MUL_OP", "DIV_OP", "MOD_OP", "POW_OP", "ID"
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
			setState(46);
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
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAL_KW) | (1L << FUN_KW) | (1L << REC_KW) | (1L << NEW_KW) | (1L << IF_KW) | (1L << TRUE_LIT) | (1L << FALSE_LIT) | (1L << NIX_LIT) | (1L << STRING_LIT) | (1L << LEFT_PARENTHESE) | (1L << LEFT_SQUARE) | (1L << NUMBER) | (1L << BIT_NOT_OP) | (1L << LOGIC_NOT_OP) | (1L << ID))) != 0)) {
				{
				{
				setState(48);
				statement();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
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
		public IfConditionContext ifCondition() {
			return getRuleContext(IfConditionContext.class,0);
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
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				value();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				function();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				application();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(59);
				record();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(60);
				ifCondition();
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
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				expression(0);
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
			setState(67);
			match(LEFT_BRACES);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAL_KW) | (1L << FUN_KW) | (1L << REC_KW) | (1L << NEW_KW) | (1L << IF_KW) | (1L << TRUE_LIT) | (1L << FALSE_LIT) | (1L << NIX_LIT) | (1L << STRING_LIT) | (1L << LEFT_PARENTHESE) | (1L << LEFT_SQUARE) | (1L << NUMBER) | (1L << BIT_NOT_OP) | (1L << LOGIC_NOT_OP) | (1L << ID))) != 0)) {
				{
				{
				setState(68);
				blockInner();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
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
			setState(76);
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
		public TerminalNode LEFT_PARENTHESE() { return getToken(SalParser.LEFT_PARENTHESE, 0); }
		public List<AllTypesContext> allTypes() {
			return getRuleContexts(AllTypesContext.class);
		}
		public AllTypesContext allTypes(int i) {
			return getRuleContext(AllTypesContext.class,i);
		}
		public TerminalNode RIGHT_PARENTHESE() { return getToken(SalParser.RIGHT_PARENTHESE, 0); }
		public TerminalNode LEFT_SQUARE() { return getToken(SalParser.LEFT_SQUARE, 0); }
		public TerminalNode RIGHT_SQUARE() { return getToken(SalParser.RIGHT_SQUARE, 0); }
		public List<TerminalNode> COMMA_OP() { return getTokens(SalParser.COMMA_OP); }
		public TerminalNode COMMA_OP(int i) {
			return getToken(SalParser.COMMA_OP, i);
		}
		public TerminalNode ID() { return getToken(SalParser.ID, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode BIT_OR_OP() { return getToken(SalParser.BIT_OR_OP, 0); }
		public TerminalNode ARROW_OP() { return getToken(SalParser.ARROW_OP, 0); }
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
		return allTypes(0);
	}

	private AllTypesContext allTypes(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AllTypesContext _localctx = new AllTypesContext(_ctx, _parentState);
		AllTypesContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_allTypes, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_PARENTHESE:
				{
				setState(79);
				match(LEFT_PARENTHESE);
				setState(80);
				allTypes(0);
				setState(81);
				match(RIGHT_PARENTHESE);
				}
				break;
			case LEFT_SQUARE:
				{
				setState(83);
				match(LEFT_SQUARE);
				setState(84);
				allTypes(0);
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(85);
					match(COMMA_OP);
					setState(86);
					allTypes(0);
					}
					}
					setState(89); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA_OP );
				setState(91);
				match(RIGHT_SQUARE);
				}
				break;
			case ID:
				{
				setState(93);
				match(ID);
				}
				break;
			case INT_KW:
			case FLOAT_KW:
			case BOOL_KW:
			case STRING_KW:
			case VOID_KW:
			case ANY_KW:
				{
				setState(94);
				typeName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(105);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(103);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new AllTypesContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_allTypes);
						setState(97);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(98);
						match(BIT_OR_OP);
						setState(99);
						allTypes(6);
						}
						break;
					case 2:
						{
						_localctx = new AllTypesContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_allTypes);
						setState(100);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(101);
						match(ARROW_OP);
						setState(102);
						allTypes(4);
						}
						break;
					}
					} 
				}
				setState(107);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
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
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(VAL_KW);
				setState(109);
				match(ID);
				setState(110);
				match(COLON_OP);
				setState(111);
				allTypes(0);
				setState(112);
				match(ASSIGN_OP);
				setState(113);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				match(VAL_KW);
				setState(116);
				match(ID);
				setState(117);
				match(ASSIGN_OP);
				setState(118);
				expression(0);
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
		public CreateContext create() {
			return getRuleContext(CreateContext.class,0);
		}
		public IfConditionContext ifCondition() {
			return getRuleContext(IfConditionContext.class,0);
		}
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public TerminalNode LEFT_SQUARE() { return getToken(SalParser.LEFT_SQUARE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RIGHT_SQUARE() { return getToken(SalParser.RIGHT_SQUARE, 0); }
		public List<TerminalNode> COMMA_OP() { return getTokens(SalParser.COMMA_OP); }
		public TerminalNode COMMA_OP(int i) {
			return getToken(SalParser.COMMA_OP, i);
		}
		public TerminalNode LEFT_PARENTHESE() { return getToken(SalParser.LEFT_PARENTHESE, 0); }
		public TerminalNode RIGHT_PARENTHESE() { return getToken(SalParser.RIGHT_PARENTHESE, 0); }
		public TerminalNode LOGIC_NOT_OP() { return getToken(SalParser.LOGIC_NOT_OP, 0); }
		public TerminalNode BIT_NOT_OP() { return getToken(SalParser.BIT_NOT_OP, 0); }
		public TerminalNode POW_OP() { return getToken(SalParser.POW_OP, 0); }
		public TerminalNode MUL_OP() { return getToken(SalParser.MUL_OP, 0); }
		public TerminalNode DIV_OP() { return getToken(SalParser.DIV_OP, 0); }
		public TerminalNode MOD_OP() { return getToken(SalParser.MOD_OP, 0); }
		public TerminalNode ADD_OP() { return getToken(SalParser.ADD_OP, 0); }
		public TerminalNode SUB_OP() { return getToken(SalParser.SUB_OP, 0); }
		public TerminalNode LEFT_SHIFT_OP() { return getToken(SalParser.LEFT_SHIFT_OP, 0); }
		public TerminalNode RIGHT_SHIFT_OP() { return getToken(SalParser.RIGHT_SHIFT_OP, 0); }
		public TerminalNode BIT_AND_OP() { return getToken(SalParser.BIT_AND_OP, 0); }
		public TerminalNode BIT_XOR_OP() { return getToken(SalParser.BIT_XOR_OP, 0); }
		public TerminalNode BIT_OR_OP() { return getToken(SalParser.BIT_OR_OP, 0); }
		public TerminalNode LOGIC_AND_OP() { return getToken(SalParser.LOGIC_AND_OP, 0); }
		public TerminalNode LOGIC_OR_OP() { return getToken(SalParser.LOGIC_OR_OP, 0); }
		public TerminalNode AS_KW() { return getToken(SalParser.AS_KW, 0); }
		public AllTypesContext allTypes() {
			return getRuleContext(AllTypesContext.class,0);
		}
		public TerminalNode DOT_OP() { return getToken(SalParser.DOT_OP, 0); }
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
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE_LIT:
			case FALSE_LIT:
			case NIX_LIT:
			case STRING_LIT:
			case NUMBER:
				{
				setState(122);
				lit();
				}
				break;
			case ID:
				{
				setState(123);
				match(ID);
				}
				break;
			case NEW_KW:
				{
				setState(124);
				create();
				}
				break;
			case IF_KW:
				{
				setState(125);
				ifCondition();
				}
				break;
			case FUN_KW:
				{
				setState(126);
				lambda();
				}
				break;
			case LEFT_SQUARE:
				{
				setState(127);
				match(LEFT_SQUARE);
				setState(128);
				expression(0);
				setState(131); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(129);
					match(COMMA_OP);
					setState(130);
					expression(0);
					}
					}
					setState(133); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA_OP );
				setState(135);
				match(RIGHT_SQUARE);
				}
				break;
			case LEFT_PARENTHESE:
				{
				setState(137);
				match(LEFT_PARENTHESE);
				setState(138);
				expression(0);
				setState(139);
				match(RIGHT_PARENTHESE);
				}
				break;
			case BIT_NOT_OP:
			case LOGIC_NOT_OP:
				{
				setState(141);
				_la = _input.LA(1);
				if ( !(_la==BIT_NOT_OP || _la==LOGIC_NOT_OP) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(142);
				expression(9);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(200);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(198);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(145);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(146);
						match(POW_OP);
						setState(147);
						expression(11);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(148);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(149);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL_OP) | (1L << DIV_OP) | (1L << MOD_OP))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(150);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(151);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(152);
						_la = _input.LA(1);
						if ( !(_la==ADD_OP || _la==SUB_OP) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(153);
						expression(8);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(154);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(155);
						_la = _input.LA(1);
						if ( !(_la==LEFT_SHIFT_OP || _la==RIGHT_SHIFT_OP) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(156);
						expression(7);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(157);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(158);
						match(BIT_AND_OP);
						setState(159);
						expression(6);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(160);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(161);
						match(BIT_XOR_OP);
						setState(162);
						expression(5);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(163);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(164);
						match(BIT_OR_OP);
						setState(165);
						expression(4);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(166);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(167);
						match(LOGIC_AND_OP);
						setState(168);
						expression(3);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(169);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(170);
						match(LOGIC_OR_OP);
						setState(171);
						expression(2);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(172);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(173);
						match(AS_KW);
						setState(174);
						allTypes(0);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(175);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(176);
						match(LEFT_SQUARE);
						setState(177);
						lit();
						setState(178);
						match(RIGHT_SQUARE);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(180);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(181);
						match(LEFT_PARENTHESE);
						setState(182);
						match(RIGHT_PARENTHESE);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(183);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(184);
						match(LEFT_PARENTHESE);
						setState(185);
						expression(0);
						setState(190);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA_OP) {
							{
							{
							setState(186);
							match(COMMA_OP);
							setState(187);
							expression(0);
							}
							}
							setState(192);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(193);
						match(RIGHT_PARENTHESE);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(195);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(196);
						match(DOT_OP);
						setState(197);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(202);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
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
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_BRACES:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				block();
				}
				break;
			case FUN_KW:
			case NEW_KW:
			case IF_KW:
			case TRUE_LIT:
			case FALSE_LIT:
			case NIX_LIT:
			case STRING_LIT:
			case LEFT_PARENTHESE:
			case LEFT_SQUARE:
			case NUMBER:
			case BIT_NOT_OP:
			case LOGIC_NOT_OP:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				expression(0);
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
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				match(ID);
				setState(208);
				match(COLON_OP);
				setState(209);
				allTypes(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
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
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(213);
				match(LEFT_PARENTHESE);
				setState(214);
				match(RIGHT_PARENTHESE);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(215);
				match(LEFT_PARENTHESE);
				setState(216);
				param();
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA_OP) {
					{
					{
					setState(217);
					match(COMMA_OP);
					setState(218);
					param();
					}
					}
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(224);
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
		public TerminalNode ASSIGN_OP() { return getToken(SalParser.ASSIGN_OP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				match(ID);
				setState(229);
				match(COLON_OP);
				setState(230);
				allTypes(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				function();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(232);
				match(ID);
				setState(233);
				match(COLON_OP);
				setState(234);
				allTypes(0);
				setState(235);
				match(ASSIGN_OP);
				setState(236);
				expression(0);
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
			setState(240);
			field();
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA_OP) {
				{
				{
				setState(241);
				match(COMMA_OP);
				setState(242);
				field();
				}
				}
				setState(247);
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
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				match(FUN_KW);
				setState(249);
				match(ID);
				setState(250);
				params();
				setState(251);
				match(COLON_OP);
				setState(252);
				allTypes(0);
				setState(253);
				match(ASSIGN_OP);
				setState(254);
				functionBody();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				match(FUN_KW);
				setState(257);
				match(ID);
				setState(258);
				params();
				setState(259);
				match(ASSIGN_OP);
				setState(260);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LEFT_PARENTHESE() { return getToken(SalParser.LEFT_PARENTHESE, 0); }
		public TerminalNode RIGHT_PARENTHESE() { return getToken(SalParser.RIGHT_PARENTHESE, 0); }
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
			setState(280);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				expression(0);
				setState(265);
				match(LEFT_PARENTHESE);
				setState(266);
				match(RIGHT_PARENTHESE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				expression(0);
				setState(269);
				match(LEFT_PARENTHESE);
				setState(270);
				expression(0);
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA_OP) {
					{
					{
					setState(271);
					match(COMMA_OP);
					setState(272);
					expression(0);
					}
					}
					setState(277);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(278);
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
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(282);
				match(REC_KW);
				setState(283);
				match(ID);
				setState(284);
				match(LEFT_BRACES);
				setState(285);
				match(RIGHT_BRACES);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				match(REC_KW);
				setState(287);
				match(ID);
				setState(288);
				match(LEFT_BRACES);
				setState(289);
				fields();
				setState(290);
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
		enterRule(_localctx, 34, RULE_initializer);
		try {
			setState(298);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				match(ID);
				setState(295);
				match(ASSIGN_OP);
				setState(296);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				expression(0);
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
		enterRule(_localctx, 36, RULE_create);
		int _la;
		try {
			setState(317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(300);
				match(NEW_KW);
				setState(301);
				match(ID);
				setState(302);
				match(LEFT_BRACES);
				setState(303);
				match(RIGHT_BRACES);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				match(NEW_KW);
				setState(305);
				match(ID);
				setState(306);
				match(LEFT_BRACES);
				setState(307);
				initializer();
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA_OP) {
					{
					{
					setState(308);
					match(COMMA_OP);
					setState(309);
					initializer();
					}
					}
					setState(314);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(315);
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

	public static class IfConditionContext extends ParserRuleContext {
		public TerminalNode IF_KW() { return getToken(SalParser.IF_KW, 0); }
		public TerminalNode LEFT_PARENTHESE() { return getToken(SalParser.LEFT_PARENTHESE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RIGHT_PARENTHESE() { return getToken(SalParser.RIGHT_PARENTHESE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ElseIfConditionContext> elseIfCondition() {
			return getRuleContexts(ElseIfConditionContext.class);
		}
		public ElseIfConditionContext elseIfCondition(int i) {
			return getRuleContext(ElseIfConditionContext.class,i);
		}
		public ElseBlockContext elseBlock() {
			return getRuleContext(ElseBlockContext.class,0);
		}
		public IfConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterIfCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitIfCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitIfCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfConditionContext ifCondition() throws RecognitionException {
		IfConditionContext _localctx = new IfConditionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_ifCondition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			match(IF_KW);
			setState(320);
			match(LEFT_PARENTHESE);
			setState(321);
			expression(0);
			setState(322);
			match(RIGHT_PARENTHESE);
			setState(325);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_BRACES:
				{
				setState(323);
				block();
				}
				break;
			case FUN_KW:
			case NEW_KW:
			case IF_KW:
			case TRUE_LIT:
			case FALSE_LIT:
			case NIX_LIT:
			case STRING_LIT:
			case LEFT_PARENTHESE:
			case LEFT_SQUARE:
			case NUMBER:
			case BIT_NOT_OP:
			case LOGIC_NOT_OP:
			case ID:
				{
				setState(324);
				expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(330);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(327);
					elseIfCondition();
					}
					} 
				}
				setState(332);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			setState(334);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(333);
				elseBlock();
				}
				break;
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

	public static class ElseIfConditionContext extends ParserRuleContext {
		public TerminalNode ELSE_KW() { return getToken(SalParser.ELSE_KW, 0); }
		public TerminalNode IF_KW() { return getToken(SalParser.IF_KW, 0); }
		public TerminalNode LEFT_PARENTHESE() { return getToken(SalParser.LEFT_PARENTHESE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RIGHT_PARENTHESE() { return getToken(SalParser.RIGHT_PARENTHESE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseIfConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterElseIfCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitElseIfCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitElseIfCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfConditionContext elseIfCondition() throws RecognitionException {
		ElseIfConditionContext _localctx = new ElseIfConditionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_elseIfCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(ELSE_KW);
			setState(337);
			match(IF_KW);
			setState(338);
			match(LEFT_PARENTHESE);
			setState(339);
			expression(0);
			setState(340);
			match(RIGHT_PARENTHESE);
			setState(343);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_BRACES:
				{
				setState(341);
				block();
				}
				break;
			case FUN_KW:
			case NEW_KW:
			case IF_KW:
			case TRUE_LIT:
			case FALSE_LIT:
			case NIX_LIT:
			case STRING_LIT:
			case LEFT_PARENTHESE:
			case LEFT_SQUARE:
			case NUMBER:
			case BIT_NOT_OP:
			case LOGIC_NOT_OP:
			case ID:
				{
				setState(342);
				expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ElseBlockContext extends ParserRuleContext {
		public TerminalNode ELSE_KW() { return getToken(SalParser.ELSE_KW, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ElseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterElseBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitElseBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitElseBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseBlockContext elseBlock() throws RecognitionException {
		ElseBlockContext _localctx = new ElseBlockContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_elseBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(ELSE_KW);
			setState(348);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_BRACES:
				{
				setState(346);
				block();
				}
				break;
			case FUN_KW:
			case NEW_KW:
			case IF_KW:
			case TRUE_LIT:
			case FALSE_LIT:
			case NIX_LIT:
			case STRING_LIT:
			case LEFT_PARENTHESE:
			case LEFT_SQUARE:
			case NUMBER:
			case BIT_NOT_OP:
			case LOGIC_NOT_OP:
			case ID:
				{
				setState(347);
				expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class LambdaContext extends ParserRuleContext {
		public TerminalNode FUN_KW() { return getToken(SalParser.FUN_KW, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode COLON_OP() { return getToken(SalParser.COLON_OP, 0); }
		public AllTypesContext allTypes() {
			return getRuleContext(AllTypesContext.class,0);
		}
		public TerminalNode ASSIGN_OP() { return getToken(SalParser.ASSIGN_OP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).enterLambda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SalParserListener ) ((SalParserListener)listener).exitLambda(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SalParserVisitor ) return ((SalParserVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_lambda);
		try {
			setState(362);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(350);
				match(FUN_KW);
				setState(351);
				params();
				setState(352);
				match(COLON_OP);
				setState(353);
				allTypes(0);
				setState(354);
				match(ASSIGN_OP);
				setState(355);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(357);
				match(FUN_KW);
				setState(358);
				params();
				setState(359);
				match(ASSIGN_OP);
				setState(360);
				expression(0);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return allTypes_sempred((AllTypesContext)_localctx, predIndex);
		case 8:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean allTypes_sempred(AllTypesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		case 11:
			return precpred(_ctx, 18);
		case 12:
			return precpred(_ctx, 15);
		case 13:
			return precpred(_ctx, 14);
		case 14:
			return precpred(_ctx, 13);
		case 15:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001.\u016d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001"+
		"2\b\u0001\n\u0001\f\u00015\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002>\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0003\u0003B\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0005\u0004F\b\u0004\n\u0004\f\u0004I\t\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006"+
		"X\b\u0006\u000b\u0006\f\u0006Y\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006`\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006h\b\u0006\n\u0006\f\u0006k\t"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007x\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0004\b\u0084\b\b\u000b\b\f\b\u0085\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0090"+
		"\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00bd"+
		"\b\b\n\b\f\b\u00c0\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b"+
		"\u00c7\b\b\n\b\f\b\u00ca\t\b\u0001\t\u0001\t\u0003\t\u00ce\b\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0003\n\u00d4\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00dc\b\u000b\n"+
		"\u000b\f\u000b\u00df\t\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00e3"+
		"\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u00ef\b\f\u0001\r\u0001\r\u0001\r\u0005\r\u00f4"+
		"\b\r\n\r\f\r\u00f7\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0107\b\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0112\b\u000f\n\u000f"+
		"\f\u000f\u0115\t\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0119\b\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0125\b\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u012b\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0137\b\u0012"+
		"\n\u0012\f\u0012\u013a\t\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u013e"+
		"\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u0146\b\u0013\u0001\u0013\u0005\u0013\u0149\b\u0013"+
		"\n\u0013\f\u0013\u014c\t\u0013\u0001\u0013\u0003\u0013\u014f\b\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0003\u0014\u0158\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u015d\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0003\u0016\u016b\b\u0016\u0001\u0016\u0000\u0002\f"+
		"\u0010\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,\u0000\u0006\u0002\u0000\u000e\u0011\u0019"+
		"\u0019\u0002\u0000\u0002\u0005\u0007\b\u0002\u0000!!\'\'\u0001\u0000*"+
		",\u0001\u0000()\u0001\u0000#$\u018e\u0000.\u0001\u0000\u0000\u0000\u0002"+
		"3\u0001\u0000\u0000\u0000\u0004=\u0001\u0000\u0000\u0000\u0006A\u0001"+
		"\u0000\u0000\u0000\bC\u0001\u0000\u0000\u0000\nL\u0001\u0000\u0000\u0000"+
		"\f_\u0001\u0000\u0000\u0000\u000ew\u0001\u0000\u0000\u0000\u0010\u008f"+
		"\u0001\u0000\u0000\u0000\u0012\u00cd\u0001\u0000\u0000\u0000\u0014\u00d3"+
		"\u0001\u0000\u0000\u0000\u0016\u00e2\u0001\u0000\u0000\u0000\u0018\u00ee"+
		"\u0001\u0000\u0000\u0000\u001a\u00f0\u0001\u0000\u0000\u0000\u001c\u0106"+
		"\u0001\u0000\u0000\u0000\u001e\u0118\u0001\u0000\u0000\u0000 \u0124\u0001"+
		"\u0000\u0000\u0000\"\u012a\u0001\u0000\u0000\u0000$\u013d\u0001\u0000"+
		"\u0000\u0000&\u013f\u0001\u0000\u0000\u0000(\u0150\u0001\u0000\u0000\u0000"+
		"*\u0159\u0001\u0000\u0000\u0000,\u016a\u0001\u0000\u0000\u0000./\u0007"+
		"\u0000\u0000\u0000/\u0001\u0001\u0000\u0000\u000002\u0003\u0004\u0002"+
		"\u000010\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001\u0000"+
		"\u0000\u000034\u0001\u0000\u0000\u000046\u0001\u0000\u0000\u000053\u0001"+
		"\u0000\u0000\u000067\u0005\u0000\u0000\u00017\u0003\u0001\u0000\u0000"+
		"\u00008>\u0003\u000e\u0007\u00009>\u0003\u001c\u000e\u0000:>\u0003\u001e"+
		"\u000f\u0000;>\u0003 \u0010\u0000<>\u0003&\u0013\u0000=8\u0001\u0000\u0000"+
		"\u0000=9\u0001\u0000\u0000\u0000=:\u0001\u0000\u0000\u0000=;\u0001\u0000"+
		"\u0000\u0000=<\u0001\u0000\u0000\u0000>\u0005\u0001\u0000\u0000\u0000"+
		"?B\u0003\u0004\u0002\u0000@B\u0003\u0010\b\u0000A?\u0001\u0000\u0000\u0000"+
		"A@\u0001\u0000\u0000\u0000B\u0007\u0001\u0000\u0000\u0000CG\u0005\u0012"+
		"\u0000\u0000DF\u0003\u0006\u0003\u0000ED\u0001\u0000\u0000\u0000FI\u0001"+
		"\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000"+
		"HJ\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000JK\u0005\u0013\u0000"+
		"\u0000K\t\u0001\u0000\u0000\u0000LM\u0007\u0001\u0000\u0000M\u000b\u0001"+
		"\u0000\u0000\u0000NO\u0006\u0006\uffff\uffff\u0000OP\u0005\u0014\u0000"+
		"\u0000PQ\u0003\f\u0006\u0000QR\u0005\u0015\u0000\u0000R`\u0001\u0000\u0000"+
		"\u0000ST\u0005\u0016\u0000\u0000TW\u0003\f\u0006\u0000UV\u0005\u001c\u0000"+
		"\u0000VX\u0003\f\u0006\u0000WU\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000"+
		"\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0001\u0000"+
		"\u0000\u0000[\\\u0005\u0017\u0000\u0000\\`\u0001\u0000\u0000\u0000]`\u0005"+
		".\u0000\u0000^`\u0003\n\u0005\u0000_N\u0001\u0000\u0000\u0000_S\u0001"+
		"\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_^\u0001\u0000\u0000\u0000"+
		"`i\u0001\u0000\u0000\u0000ab\n\u0005\u0000\u0000bc\u0005 \u0000\u0000"+
		"ch\u0003\f\u0006\u0006de\n\u0004\u0000\u0000ef\u0005\u001d\u0000\u0000"+
		"fh\u0003\f\u0006\u0004ga\u0001\u0000\u0000\u0000gd\u0001\u0000\u0000\u0000"+
		"hk\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000"+
		"\u0000j\r\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000lm\u0005\u0001"+
		"\u0000\u0000mn\u0005.\u0000\u0000no\u0005\u001a\u0000\u0000op\u0003\f"+
		"\u0006\u0000pq\u0005\u001b\u0000\u0000qr\u0003\u0010\b\u0000rx\u0001\u0000"+
		"\u0000\u0000st\u0005\u0001\u0000\u0000tu\u0005.\u0000\u0000uv\u0005\u001b"+
		"\u0000\u0000vx\u0003\u0010\b\u0000wl\u0001\u0000\u0000\u0000ws\u0001\u0000"+
		"\u0000\u0000x\u000f\u0001\u0000\u0000\u0000yz\u0006\b\uffff\uffff\u0000"+
		"z\u0090\u0003\u0000\u0000\u0000{\u0090\u0005.\u0000\u0000|\u0090\u0003"+
		"$\u0012\u0000}\u0090\u0003&\u0013\u0000~\u0090\u0003,\u0016\u0000\u007f"+
		"\u0080\u0005\u0016\u0000\u0000\u0080\u0083\u0003\u0010\b\u0000\u0081\u0082"+
		"\u0005\u001c\u0000\u0000\u0082\u0084\u0003\u0010\b\u0000\u0083\u0081\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0083\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0005\u0017\u0000\u0000\u0088\u0090\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0005\u0014\u0000\u0000\u008a\u008b\u0003"+
		"\u0010\b\u0000\u008b\u008c\u0005\u0015\u0000\u0000\u008c\u0090\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0007\u0002\u0000\u0000\u008e\u0090\u0003\u0010"+
		"\b\t\u008fy\u0001\u0000\u0000\u0000\u008f{\u0001\u0000\u0000\u0000\u008f"+
		"|\u0001\u0000\u0000\u0000\u008f}\u0001\u0000\u0000\u0000\u008f~\u0001"+
		"\u0000\u0000\u0000\u008f\u007f\u0001\u0000\u0000\u0000\u008f\u0089\u0001"+
		"\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u00c8\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\n\n\u0000\u0000\u0092\u0093\u0005-\u0000"+
		"\u0000\u0093\u00c7\u0003\u0010\b\u000b\u0094\u0095\n\b\u0000\u0000\u0095"+
		"\u0096\u0007\u0003\u0000\u0000\u0096\u00c7\u0003\u0010\b\t\u0097\u0098"+
		"\n\u0007\u0000\u0000\u0098\u0099\u0007\u0004\u0000\u0000\u0099\u00c7\u0003"+
		"\u0010\b\b\u009a\u009b\n\u0006\u0000\u0000\u009b\u009c\u0007\u0005\u0000"+
		"\u0000\u009c\u00c7\u0003\u0010\b\u0007\u009d\u009e\n\u0005\u0000\u0000"+
		"\u009e\u009f\u0005\u001f\u0000\u0000\u009f\u00c7\u0003\u0010\b\u0006\u00a0"+
		"\u00a1\n\u0004\u0000\u0000\u00a1\u00a2\u0005\"\u0000\u0000\u00a2\u00c7"+
		"\u0003\u0010\b\u0005\u00a3\u00a4\n\u0003\u0000\u0000\u00a4\u00a5\u0005"+
		" \u0000\u0000\u00a5\u00c7\u0003\u0010\b\u0004\u00a6\u00a7\n\u0002\u0000"+
		"\u0000\u00a7\u00a8\u0005%\u0000\u0000\u00a8\u00c7\u0003\u0010\b\u0003"+
		"\u00a9\u00aa\n\u0001\u0000\u0000\u00aa\u00ab\u0005&\u0000\u0000\u00ab"+
		"\u00c7\u0003\u0010\b\u0002\u00ac\u00ad\n\u0012\u0000\u0000\u00ad\u00ae"+
		"\u0005\r\u0000\u0000\u00ae\u00c7\u0003\f\u0006\u0000\u00af\u00b0\n\u000f"+
		"\u0000\u0000\u00b0\u00b1\u0005\u0016\u0000\u0000\u00b1\u00b2\u0003\u0000"+
		"\u0000\u0000\u00b2\u00b3\u0005\u0017\u0000\u0000\u00b3\u00c7\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b5\n\u000e\u0000\u0000\u00b5\u00b6\u0005\u0014\u0000"+
		"\u0000\u00b6\u00c7\u0005\u0015\u0000\u0000\u00b7\u00b8\n\r\u0000\u0000"+
		"\u00b8\u00b9\u0005\u0014\u0000\u0000\u00b9\u00be\u0003\u0010\b\u0000\u00ba"+
		"\u00bb\u0005\u001c\u0000\u0000\u00bb\u00bd\u0003\u0010\b\u0000\u00bc\u00ba"+
		"\u0001\u0000\u0000\u0000\u00bd\u00c0\u0001\u0000\u0000\u0000\u00be\u00bc"+
		"\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c1\u00c2"+
		"\u0005\u0015\u0000\u0000\u00c2\u00c7\u0001\u0000\u0000\u0000\u00c3\u00c4"+
		"\n\f\u0000\u0000\u00c4\u00c5\u0005\u001e\u0000\u0000\u00c5\u00c7\u0005"+
		".\u0000\u0000\u00c6\u0091\u0001\u0000\u0000\u0000\u00c6\u0094\u0001\u0000"+
		"\u0000\u0000\u00c6\u0097\u0001\u0000\u0000\u0000\u00c6\u009a\u0001\u0000"+
		"\u0000\u0000\u00c6\u009d\u0001\u0000\u0000\u0000\u00c6\u00a0\u0001\u0000"+
		"\u0000\u0000\u00c6\u00a3\u0001\u0000\u0000\u0000\u00c6\u00a6\u0001\u0000"+
		"\u0000\u0000\u00c6\u00a9\u0001\u0000\u0000\u0000\u00c6\u00ac\u0001\u0000"+
		"\u0000\u0000\u00c6\u00af\u0001\u0000\u0000\u0000\u00c6\u00b4\u0001\u0000"+
		"\u0000\u0000\u00c6\u00b7\u0001\u0000\u0000\u0000\u00c6\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c7\u00ca\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u0011\u0001\u0000"+
		"\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00cb\u00ce\u0003\b\u0004"+
		"\u0000\u00cc\u00ce\u0003\u0010\b\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000"+
		"\u00cd\u00cc\u0001\u0000\u0000\u0000\u00ce\u0013\u0001\u0000\u0000\u0000"+
		"\u00cf\u00d0\u0005.\u0000\u0000\u00d0\u00d1\u0005\u001a\u0000\u0000\u00d1"+
		"\u00d4\u0003\f\u0006\u0000\u00d2\u00d4\u0005.\u0000\u0000\u00d3\u00cf"+
		"\u0001\u0000\u0000\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d4\u0015"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005\u0014\u0000\u0000\u00d6\u00e3"+
		"\u0005\u0015\u0000\u0000\u00d7\u00d8\u0005\u0014\u0000\u0000\u00d8\u00dd"+
		"\u0003\u0014\n\u0000\u00d9\u00da\u0005\u001c\u0000\u0000\u00da\u00dc\u0003"+
		"\u0014\n\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc\u00df\u0001\u0000"+
		"\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000"+
		"\u0000\u0000\u00de\u00e0\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000"+
		"\u0000\u0000\u00e0\u00e1\u0005\u0015\u0000\u0000\u00e1\u00e3\u0001\u0000"+
		"\u0000\u0000\u00e2\u00d5\u0001\u0000\u0000\u0000\u00e2\u00d7\u0001\u0000"+
		"\u0000\u0000\u00e3\u0017\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005.\u0000"+
		"\u0000\u00e5\u00e6\u0005\u001a\u0000\u0000\u00e6\u00ef\u0003\f\u0006\u0000"+
		"\u00e7\u00ef\u0003\u001c\u000e\u0000\u00e8\u00e9\u0005.\u0000\u0000\u00e9"+
		"\u00ea\u0005\u001a\u0000\u0000\u00ea\u00eb\u0003\f\u0006\u0000\u00eb\u00ec"+
		"\u0005\u001b\u0000\u0000\u00ec\u00ed\u0003\u0010\b\u0000\u00ed\u00ef\u0001"+
		"\u0000\u0000\u0000\u00ee\u00e4\u0001\u0000\u0000\u0000\u00ee\u00e7\u0001"+
		"\u0000\u0000\u0000\u00ee\u00e8\u0001\u0000\u0000\u0000\u00ef\u0019\u0001"+
		"\u0000\u0000\u0000\u00f0\u00f5\u0003\u0018\f\u0000\u00f1\u00f2\u0005\u001c"+
		"\u0000\u0000\u00f2\u00f4\u0003\u0018\f\u0000\u00f3\u00f1\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f7\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u001b\u0001\u0000\u0000"+
		"\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005\u0006\u0000"+
		"\u0000\u00f9\u00fa\u0005.\u0000\u0000\u00fa\u00fb\u0003\u0016\u000b\u0000"+
		"\u00fb\u00fc\u0005\u001a\u0000\u0000\u00fc\u00fd\u0003\f\u0006\u0000\u00fd"+
		"\u00fe\u0005\u001b\u0000\u0000\u00fe\u00ff\u0003\u0012\t\u0000\u00ff\u0107"+
		"\u0001\u0000\u0000\u0000\u0100\u0101\u0005\u0006\u0000\u0000\u0101\u0102"+
		"\u0005.\u0000\u0000\u0102\u0103\u0003\u0016\u000b\u0000\u0103\u0104\u0005"+
		"\u001b\u0000\u0000\u0104\u0105\u0003\u0012\t\u0000\u0105\u0107\u0001\u0000"+
		"\u0000\u0000\u0106\u00f8\u0001\u0000\u0000\u0000\u0106\u0100\u0001\u0000"+
		"\u0000\u0000\u0107\u001d\u0001\u0000\u0000\u0000\u0108\u0109\u0003\u0010"+
		"\b\u0000\u0109\u010a\u0005\u0014\u0000\u0000\u010a\u010b\u0005\u0015\u0000"+
		"\u0000\u010b\u0119\u0001\u0000\u0000\u0000\u010c\u010d\u0003\u0010\b\u0000"+
		"\u010d\u010e\u0005\u0014\u0000\u0000\u010e\u0113\u0003\u0010\b\u0000\u010f"+
		"\u0110\u0005\u001c\u0000\u0000\u0110\u0112\u0003\u0010\b\u0000\u0111\u010f"+
		"\u0001\u0000\u0000\u0000\u0112\u0115\u0001\u0000\u0000\u0000\u0113\u0111"+
		"\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0116"+
		"\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0116\u0117"+
		"\u0005\u0015\u0000\u0000\u0117\u0119\u0001\u0000\u0000\u0000\u0118\u0108"+
		"\u0001\u0000\u0000\u0000\u0118\u010c\u0001\u0000\u0000\u0000\u0119\u001f"+
		"\u0001\u0000\u0000\u0000\u011a\u011b\u0005\t\u0000\u0000\u011b\u011c\u0005"+
		".\u0000\u0000\u011c\u011d\u0005\u0012\u0000\u0000\u011d\u0125\u0005\u0013"+
		"\u0000\u0000\u011e\u011f\u0005\t\u0000\u0000\u011f\u0120\u0005.\u0000"+
		"\u0000\u0120\u0121\u0005\u0012\u0000\u0000\u0121\u0122\u0003\u001a\r\u0000"+
		"\u0122\u0123\u0005\u0013\u0000\u0000\u0123\u0125\u0001\u0000\u0000\u0000"+
		"\u0124\u011a\u0001\u0000\u0000\u0000\u0124\u011e\u0001\u0000\u0000\u0000"+
		"\u0125!\u0001\u0000\u0000\u0000\u0126\u0127\u0005.\u0000\u0000\u0127\u0128"+
		"\u0005\u001b\u0000\u0000\u0128\u012b\u0003\u0010\b\u0000\u0129\u012b\u0003"+
		"\u0010\b\u0000\u012a\u0126\u0001\u0000\u0000\u0000\u012a\u0129\u0001\u0000"+
		"\u0000\u0000\u012b#\u0001\u0000\u0000\u0000\u012c\u012d\u0005\n\u0000"+
		"\u0000\u012d\u012e\u0005.\u0000\u0000\u012e\u012f\u0005\u0012\u0000\u0000"+
		"\u012f\u013e\u0005\u0013\u0000\u0000\u0130\u0131\u0005\n\u0000\u0000\u0131"+
		"\u0132\u0005.\u0000\u0000\u0132\u0133\u0005\u0012\u0000\u0000\u0133\u0138"+
		"\u0003\"\u0011\u0000\u0134\u0135\u0005\u001c\u0000\u0000\u0135\u0137\u0003"+
		"\"\u0011\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0137\u013a\u0001\u0000"+
		"\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000"+
		"\u0000\u0000\u0139\u013b\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000"+
		"\u0000\u0000\u013b\u013c\u0005\u0013\u0000\u0000\u013c\u013e\u0001\u0000"+
		"\u0000\u0000\u013d\u012c\u0001\u0000\u0000\u0000\u013d\u0130\u0001\u0000"+
		"\u0000\u0000\u013e%\u0001\u0000\u0000\u0000\u013f\u0140\u0005\u000b\u0000"+
		"\u0000\u0140\u0141\u0005\u0014\u0000\u0000\u0141\u0142\u0003\u0010\b\u0000"+
		"\u0142\u0145\u0005\u0015\u0000\u0000\u0143\u0146\u0003\b\u0004\u0000\u0144"+
		"\u0146\u0003\u0010\b\u0000\u0145\u0143\u0001\u0000\u0000\u0000\u0145\u0144"+
		"\u0001\u0000\u0000\u0000\u0146\u014a\u0001\u0000\u0000\u0000\u0147\u0149"+
		"\u0003(\u0014\u0000\u0148\u0147\u0001\u0000\u0000\u0000\u0149\u014c\u0001"+
		"\u0000\u0000\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014a\u014b\u0001"+
		"\u0000\u0000\u0000\u014b\u014e\u0001\u0000\u0000\u0000\u014c\u014a\u0001"+
		"\u0000\u0000\u0000\u014d\u014f\u0003*\u0015\u0000\u014e\u014d\u0001\u0000"+
		"\u0000\u0000\u014e\u014f\u0001\u0000\u0000\u0000\u014f\'\u0001\u0000\u0000"+
		"\u0000\u0150\u0151\u0005\f\u0000\u0000\u0151\u0152\u0005\u000b\u0000\u0000"+
		"\u0152\u0153\u0005\u0014\u0000\u0000\u0153\u0154\u0003\u0010\b\u0000\u0154"+
		"\u0157\u0005\u0015\u0000\u0000\u0155\u0158\u0003\b\u0004\u0000\u0156\u0158"+
		"\u0003\u0010\b\u0000\u0157\u0155\u0001\u0000\u0000\u0000\u0157\u0156\u0001"+
		"\u0000\u0000\u0000\u0158)\u0001\u0000\u0000\u0000\u0159\u015c\u0005\f"+
		"\u0000\u0000\u015a\u015d\u0003\b\u0004\u0000\u015b\u015d\u0003\u0010\b"+
		"\u0000\u015c\u015a\u0001\u0000\u0000\u0000\u015c\u015b\u0001\u0000\u0000"+
		"\u0000\u015d+\u0001\u0000\u0000\u0000\u015e\u015f\u0005\u0006\u0000\u0000"+
		"\u015f\u0160\u0003\u0016\u000b\u0000\u0160\u0161\u0005\u001a\u0000\u0000"+
		"\u0161\u0162\u0003\f\u0006\u0000\u0162\u0163\u0005\u001b\u0000\u0000\u0163"+
		"\u0164\u0003\u0010\b\u0000\u0164\u016b\u0001\u0000\u0000\u0000\u0165\u0166"+
		"\u0005\u0006\u0000\u0000\u0166\u0167\u0003\u0016\u000b\u0000\u0167\u0168"+
		"\u0005\u001b\u0000\u0000\u0168\u0169\u0003\u0010\b\u0000\u0169\u016b\u0001"+
		"\u0000\u0000\u0000\u016a\u015e\u0001\u0000\u0000\u0000\u016a\u0165\u0001"+
		"\u0000\u0000\u0000\u016b-\u0001\u0000\u0000\u0000!3=AGY_giw\u0085\u008f"+
		"\u00be\u00c6\u00c8\u00cd\u00d3\u00dd\u00e2\u00ee\u00f5\u0106\u0113\u0118"+
		"\u0124\u012a\u0138\u013d\u0145\u014a\u014e\u0157\u015c\u016a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}