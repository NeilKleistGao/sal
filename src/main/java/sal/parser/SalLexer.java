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
		ANY_KW=8, REC_KW=9, NEW_KW=10, TRUE_LIT=11, FALSE_LIT=12, NIX_LIT=13, 
		STRING_LIT=14, LEFT_BRACES=15, RIGHT_BRACES=16, LEFT_PARENTHESE=17, RIGHT_PARENTHESE=18, 
		WS=19, NUMBER=20, COLON_OP=21, ASSIGN_OP=22, COMMA_OP=23, ARROW_OP=24, 
		DOT_OP=25, ID=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VAL_KW", "INT_KW", "FLOAT_KW", "BOOL_KW", "STRING_KW", "FUN_KW", "VOID_KW", 
			"ANY_KW", "REC_KW", "NEW_KW", "TRUE_LIT", "FALSE_LIT", "NIX_LIT", "STRING_LIT", 
			"LEFT_BRACES", "RIGHT_BRACES", "LEFT_PARENTHESE", "RIGHT_PARENTHESE", 
			"WS", "NUMBER", "COLON_OP", "ASSIGN_OP", "COMMA_OP", "ARROW_OP", "DOT_OP", 
			"ID"
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
		"\u0004\u0000\u001a\u00b1\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0005\r}\b\r\n\r\f\r\u0080\t\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0004\u0012\u008d\b\u0012\u000b\u0012"+
		"\f\u0012\u008e\u0001\u0012\u0001\u0012\u0001\u0013\u0004\u0013\u0094\b"+
		"\u0013\u000b\u0013\f\u0013\u0095\u0001\u0013\u0001\u0013\u0004\u0013\u009a"+
		"\b\u0013\u000b\u0013\f\u0013\u009b\u0003\u0013\u009e\b\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0005\u0019\u00ad\b\u0019\n\u0019\f\u0019\u00b0\t\u0019\u0000\u0000\u001a"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u00181\u00193\u001a\u0001\u0000\u0004\u0001\u0000\"\"\u0002\u0000\t"+
		"\n  \u0003\u0000AZ__az\u0004\u000009AZ__az\u00b7\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000"+
		"\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u0000"+
		"1\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00015\u0001"+
		"\u0000\u0000\u0000\u00039\u0001\u0000\u0000\u0000\u0005=\u0001\u0000\u0000"+
		"\u0000\u0007C\u0001\u0000\u0000\u0000\tH\u0001\u0000\u0000\u0000\u000b"+
		"O\u0001\u0000\u0000\u0000\rS\u0001\u0000\u0000\u0000\u000fX\u0001\u0000"+
		"\u0000\u0000\u0011a\u0001\u0000\u0000\u0000\u0013e\u0001\u0000\u0000\u0000"+
		"\u0015i\u0001\u0000\u0000\u0000\u0017n\u0001\u0000\u0000\u0000\u0019t"+
		"\u0001\u0000\u0000\u0000\u001bx\u0001\u0000\u0000\u0000\u001d\u0083\u0001"+
		"\u0000\u0000\u0000\u001f\u0085\u0001\u0000\u0000\u0000!\u0087\u0001\u0000"+
		"\u0000\u0000#\u0089\u0001\u0000\u0000\u0000%\u008c\u0001\u0000\u0000\u0000"+
		"\'\u0093\u0001\u0000\u0000\u0000)\u009f\u0001\u0000\u0000\u0000+\u00a1"+
		"\u0001\u0000\u0000\u0000-\u00a3\u0001\u0000\u0000\u0000/\u00a5\u0001\u0000"+
		"\u0000\u00001\u00a8\u0001\u0000\u0000\u00003\u00aa\u0001\u0000\u0000\u0000"+
		"56\u0005v\u0000\u000067\u0005a\u0000\u000078\u0005l\u0000\u00008\u0002"+
		"\u0001\u0000\u0000\u00009:\u0005i\u0000\u0000:;\u0005n\u0000\u0000;<\u0005"+
		"t\u0000\u0000<\u0004\u0001\u0000\u0000\u0000=>\u0005f\u0000\u0000>?\u0005"+
		"l\u0000\u0000?@\u0005o\u0000\u0000@A\u0005a\u0000\u0000AB\u0005t\u0000"+
		"\u0000B\u0006\u0001\u0000\u0000\u0000CD\u0005b\u0000\u0000DE\u0005o\u0000"+
		"\u0000EF\u0005o\u0000\u0000FG\u0005l\u0000\u0000G\b\u0001\u0000\u0000"+
		"\u0000HI\u0005s\u0000\u0000IJ\u0005t\u0000\u0000JK\u0005r\u0000\u0000"+
		"KL\u0005i\u0000\u0000LM\u0005n\u0000\u0000MN\u0005g\u0000\u0000N\n\u0001"+
		"\u0000\u0000\u0000OP\u0005f\u0000\u0000PQ\u0005u\u0000\u0000QR\u0005n"+
		"\u0000\u0000R\f\u0001\u0000\u0000\u0000ST\u0005v\u0000\u0000TU\u0005o"+
		"\u0000\u0000UV\u0005i\u0000\u0000VW\u0005d\u0000\u0000W\u000e\u0001\u0000"+
		"\u0000\u0000XY\u0005a\u0000\u0000YZ\u0005n\u0000\u0000Z[\u0005y\u0000"+
		"\u0000[\\\u0005t\u0000\u0000\\]\u0005h\u0000\u0000]^\u0005i\u0000\u0000"+
		"^_\u0005n\u0000\u0000_`\u0005g\u0000\u0000`\u0010\u0001\u0000\u0000\u0000"+
		"ab\u0005r\u0000\u0000bc\u0005e\u0000\u0000cd\u0005c\u0000\u0000d\u0012"+
		"\u0001\u0000\u0000\u0000ef\u0005n\u0000\u0000fg\u0005e\u0000\u0000gh\u0005"+
		"w\u0000\u0000h\u0014\u0001\u0000\u0000\u0000ij\u0005t\u0000\u0000jk\u0005"+
		"r\u0000\u0000kl\u0005u\u0000\u0000lm\u0005e\u0000\u0000m\u0016\u0001\u0000"+
		"\u0000\u0000no\u0005f\u0000\u0000op\u0005a\u0000\u0000pq\u0005l\u0000"+
		"\u0000qr\u0005s\u0000\u0000rs\u0005e\u0000\u0000s\u0018\u0001\u0000\u0000"+
		"\u0000tu\u0005n\u0000\u0000uv\u0005i\u0000\u0000vw\u0005x\u0000\u0000"+
		"w\u001a\u0001\u0000\u0000\u0000x~\u0005\"\u0000\u0000yz\u0005\\\u0000"+
		"\u0000z}\u0005\"\u0000\u0000{}\b\u0000\u0000\u0000|y\u0001\u0000\u0000"+
		"\u0000|{\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001"+
		"\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0081\u0001\u0000"+
		"\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0081\u0082\u0005\"\u0000"+
		"\u0000\u0082\u001c\u0001\u0000\u0000\u0000\u0083\u0084\u0005{\u0000\u0000"+
		"\u0084\u001e\u0001\u0000\u0000\u0000\u0085\u0086\u0005}\u0000\u0000\u0086"+
		" \u0001\u0000\u0000\u0000\u0087\u0088\u0005(\u0000\u0000\u0088\"\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0005)\u0000\u0000\u008a$\u0001\u0000\u0000"+
		"\u0000\u008b\u008d\u0007\u0001\u0000\u0000\u008c\u008b\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0006\u0012\u0000\u0000\u0091&\u0001\u0000\u0000\u0000"+
		"\u0092\u0094\u000209\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0096"+
		"\u0001\u0000\u0000\u0000\u0096\u009d\u0001\u0000\u0000\u0000\u0097\u0099"+
		"\u0005.\u0000\u0000\u0098\u009a\u000209\u0000\u0099\u0098\u0001\u0000"+
		"\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000"+
		"\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009e\u0001\u0000"+
		"\u0000\u0000\u009d\u0097\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000"+
		"\u0000\u0000\u009e(\u0001\u0000\u0000\u0000\u009f\u00a0\u0005:\u0000\u0000"+
		"\u00a0*\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005=\u0000\u0000\u00a2,"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005,\u0000\u0000\u00a4.\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a6\u0005-\u0000\u0000\u00a6\u00a7\u0005>\u0000\u0000"+
		"\u00a70\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005.\u0000\u0000\u00a92"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ae\u0007\u0002\u0000\u0000\u00ab\u00ad"+
		"\u0007\u0003\u0000\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad\u00b0"+
		"\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af"+
		"\u0001\u0000\u0000\u0000\u00af4\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001"+
		"\u0000\u0000\u0000\b\u0000|~\u008e\u0095\u009b\u009d\u00ae\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}