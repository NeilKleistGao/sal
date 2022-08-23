// Generated from SalLexer.g4 by ANTLR 4.10.1

  package sal.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SalLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VAL_KW=1, INT_KW=2, FLOAT_KW=3, BOOL_KW=4, STRING_KW=5, FUN_KW=6, VOID_KW=7, 
		ANY_KW=8, REC_KW=9, TRUE_LIT=10, FALSE_LIT=11, NIX_LIT=12, STRING_LIT=13, 
		LEFT_BRACES=14, RIGHT_BRACES=15, LEFT_PARENTHESE=16, RIGHT_PARENTHESE=17, 
		WS=18, NUMBER=19, COLON_OP=20, ASSIGN_OP=21, COMMA_OP=22, ARROW_OP=23, 
		DOT_OP=24, ID=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VAL_KW", "INT_KW", "FLOAT_KW", "BOOL_KW", "STRING_KW", "FUN_KW", "VOID_KW", 
			"ANY_KW", "REC_KW", "TRUE_LIT", "FALSE_LIT", "NIX_LIT", "STRING_LIT", 
			"LEFT_BRACES", "RIGHT_BRACES", "LEFT_PARENTHESE", "RIGHT_PARENTHESE", 
			"WS", "NUMBER", "COLON_OP", "ASSIGN_OP", "COMMA_OP", "ARROW_OP", "DOT_OP", 
			"ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'val'", "'int'", "'float'", "'bool'", "'string'", "'fun'", "'void'", 
			"'anything'", "'rec'", "'true'", "'false'", "'nix'", null, "'{'", "'}'", 
			"'('", "')'", null, null, "':'", "'='", "','", "'->'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAL_KW", "INT_KW", "FLOAT_KW", "BOOL_KW", "STRING_KW", "FUN_KW", 
			"VOID_KW", "ANY_KW", "REC_KW", "TRUE_LIT", "FALSE_LIT", "NIX_LIT", "STRING_LIT", 
			"LEFT_BRACES", "RIGHT_BRACES", "LEFT_PARENTHESE", "RIGHT_PARENTHESE", 
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


	public SalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SalLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0019\u00ab\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0005\fw\b\f\n\f\f\fz\t\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0004\u0011\u0087\b\u0011\u000b\u0011\f"+
		"\u0011\u0088\u0001\u0011\u0001\u0011\u0001\u0012\u0004\u0012\u008e\b\u0012"+
		"\u000b\u0012\f\u0012\u008f\u0001\u0012\u0001\u0012\u0004\u0012\u0094\b"+
		"\u0012\u000b\u0012\f\u0012\u0095\u0003\u0012\u0098\b\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0005\u0018\u00a7\b\u0018\n\u0018\f\u0018\u00aa\t\u0018\u0000\u0000\u0019"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u00181\u0019\u0001\u0000\u0004\u0001\u0000\"\"\u0002\u0000\t\n  \u0003"+
		"\u0000AZ__az\u0004\u000009AZ__az\u00b1\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000"+
		"-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001"+
		"\u0000\u0000\u0000\u00013\u0001\u0000\u0000\u0000\u00037\u0001\u0000\u0000"+
		"\u0000\u0005;\u0001\u0000\u0000\u0000\u0007A\u0001\u0000\u0000\u0000\t"+
		"F\u0001\u0000\u0000\u0000\u000bM\u0001\u0000\u0000\u0000\rQ\u0001\u0000"+
		"\u0000\u0000\u000fV\u0001\u0000\u0000\u0000\u0011_\u0001\u0000\u0000\u0000"+
		"\u0013c\u0001\u0000\u0000\u0000\u0015h\u0001\u0000\u0000\u0000\u0017n"+
		"\u0001\u0000\u0000\u0000\u0019r\u0001\u0000\u0000\u0000\u001b}\u0001\u0000"+
		"\u0000\u0000\u001d\u007f\u0001\u0000\u0000\u0000\u001f\u0081\u0001\u0000"+
		"\u0000\u0000!\u0083\u0001\u0000\u0000\u0000#\u0086\u0001\u0000\u0000\u0000"+
		"%\u008d\u0001\u0000\u0000\u0000\'\u0099\u0001\u0000\u0000\u0000)\u009b"+
		"\u0001\u0000\u0000\u0000+\u009d\u0001\u0000\u0000\u0000-\u009f\u0001\u0000"+
		"\u0000\u0000/\u00a2\u0001\u0000\u0000\u00001\u00a4\u0001\u0000\u0000\u0000"+
		"34\u0005v\u0000\u000045\u0005a\u0000\u000056\u0005l\u0000\u00006\u0002"+
		"\u0001\u0000\u0000\u000078\u0005i\u0000\u000089\u0005n\u0000\u00009:\u0005"+
		"t\u0000\u0000:\u0004\u0001\u0000\u0000\u0000;<\u0005f\u0000\u0000<=\u0005"+
		"l\u0000\u0000=>\u0005o\u0000\u0000>?\u0005a\u0000\u0000?@\u0005t\u0000"+
		"\u0000@\u0006\u0001\u0000\u0000\u0000AB\u0005b\u0000\u0000BC\u0005o\u0000"+
		"\u0000CD\u0005o\u0000\u0000DE\u0005l\u0000\u0000E\b\u0001\u0000\u0000"+
		"\u0000FG\u0005s\u0000\u0000GH\u0005t\u0000\u0000HI\u0005r\u0000\u0000"+
		"IJ\u0005i\u0000\u0000JK\u0005n\u0000\u0000KL\u0005g\u0000\u0000L\n\u0001"+
		"\u0000\u0000\u0000MN\u0005f\u0000\u0000NO\u0005u\u0000\u0000OP\u0005n"+
		"\u0000\u0000P\f\u0001\u0000\u0000\u0000QR\u0005v\u0000\u0000RS\u0005o"+
		"\u0000\u0000ST\u0005i\u0000\u0000TU\u0005d\u0000\u0000U\u000e\u0001\u0000"+
		"\u0000\u0000VW\u0005a\u0000\u0000WX\u0005n\u0000\u0000XY\u0005y\u0000"+
		"\u0000YZ\u0005t\u0000\u0000Z[\u0005h\u0000\u0000[\\\u0005i\u0000\u0000"+
		"\\]\u0005n\u0000\u0000]^\u0005g\u0000\u0000^\u0010\u0001\u0000\u0000\u0000"+
		"_`\u0005r\u0000\u0000`a\u0005e\u0000\u0000ab\u0005c\u0000\u0000b\u0012"+
		"\u0001\u0000\u0000\u0000cd\u0005t\u0000\u0000de\u0005r\u0000\u0000ef\u0005"+
		"u\u0000\u0000fg\u0005e\u0000\u0000g\u0014\u0001\u0000\u0000\u0000hi\u0005"+
		"f\u0000\u0000ij\u0005a\u0000\u0000jk\u0005l\u0000\u0000kl\u0005s\u0000"+
		"\u0000lm\u0005e\u0000\u0000m\u0016\u0001\u0000\u0000\u0000no\u0005n\u0000"+
		"\u0000op\u0005i\u0000\u0000pq\u0005x\u0000\u0000q\u0018\u0001\u0000\u0000"+
		"\u0000rx\u0005\"\u0000\u0000st\u0005\\\u0000\u0000tw\u0005\"\u0000\u0000"+
		"uw\b\u0000\u0000\u0000vs\u0001\u0000\u0000\u0000vu\u0001\u0000\u0000\u0000"+
		"wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000"+
		"\u0000y{\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000{|\u0005\"\u0000"+
		"\u0000|\u001a\u0001\u0000\u0000\u0000}~\u0005{\u0000\u0000~\u001c\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0005}\u0000\u0000\u0080\u001e\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0005(\u0000\u0000\u0082 \u0001\u0000\u0000\u0000"+
		"\u0083\u0084\u0005)\u0000\u0000\u0084\"\u0001\u0000\u0000\u0000\u0085"+
		"\u0087\u0007\u0001\u0000\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0087"+
		"\u0088\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088"+
		"\u0089\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0006\u0011\u0000\u0000\u008b$\u0001\u0000\u0000\u0000\u008c\u008e"+
		"\u000209\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000"+
		"\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000"+
		"\u0000\u0000\u0090\u0097\u0001\u0000\u0000\u0000\u0091\u0093\u0005.\u0000"+
		"\u0000\u0092\u0094\u000209\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095"+
		"\u0096\u0001\u0000\u0000\u0000\u0096\u0098\u0001\u0000\u0000\u0000\u0097"+
		"\u0091\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098"+
		"&\u0001\u0000\u0000\u0000\u0099\u009a\u0005:\u0000\u0000\u009a(\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0005=\u0000\u0000\u009c*\u0001\u0000\u0000"+
		"\u0000\u009d\u009e\u0005,\u0000\u0000\u009e,\u0001\u0000\u0000\u0000\u009f"+
		"\u00a0\u0005-\u0000\u0000\u00a0\u00a1\u0005>\u0000\u0000\u00a1.\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a3\u0005.\u0000\u0000\u00a30\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a8\u0007\u0002\u0000\u0000\u00a5\u00a7\u0007\u0003\u0000"+
		"\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000"+
		"\u0000\u00a92\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000"+
		"\b\u0000vx\u0088\u008f\u0095\u0097\u00a8\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}