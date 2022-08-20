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
		ANY_KW=8, TRUE_LIT=9, FALSE_LIT=10, NIX_LIT=11, STRING_LIT=12, LEFT_BRACES=13, 
		RIGHT_BRACES=14, LEFT_PARENTHESE=15, RIGHT_PARENTHESE=16, WS=17, NUMBER=18, 
		COLON_OP=19, ASSIGN_OP=20, COMMA_OP=21, ID=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VAL_KW", "INT_KW", "FLOAT_KW", "BOOL_KW", "STRING_KW", "FUN_KW", "VOID_KW", 
			"ANY_KW", "TRUE_LIT", "FALSE_LIT", "NIX_LIT", "STRING_LIT", "LEFT_BRACES", 
			"RIGHT_BRACES", "LEFT_PARENTHESE", "RIGHT_PARENTHESE", "WS", "NUMBER", 
			"COLON_OP", "ASSIGN_OP", "COMMA_OP", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'val'", "'int'", "'float'", "'bool'", "'string'", "'fun'", "'void'", 
			"'anything'", "'true'", "'false'", "'nix'", null, "'{'", "'}'", "'('", 
			"')'", null, null, "':'", "'='", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAL_KW", "INT_KW", "FLOAT_KW", "BOOL_KW", "STRING_KW", "FUN_KW", 
			"VOID_KW", "ANY_KW", "TRUE_LIT", "FALSE_LIT", "NIX_LIT", "STRING_LIT", 
			"LEFT_BRACES", "RIGHT_BRACES", "LEFT_PARENTHESE", "RIGHT_PARENTHESE", 
			"WS", "NUMBER", "COLON_OP", "ASSIGN_OP", "COMMA_OP", "ID"
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
		"\u0004\u0000\u0016\u009c\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000bm\b\u000b\n\u000b\f\u000bp\t\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0004\u0010}\b\u0010\u000b\u0010\f\u0010~\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0004\u0011\u0084\b\u0011\u000b\u0011\f\u0011"+
		"\u0085\u0001\u0011\u0001\u0011\u0004\u0011\u008a\b\u0011\u000b\u0011\f"+
		"\u0011\u008b\u0003\u0011\u008e\b\u0011\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0005\u0015"+
		"\u0098\b\u0015\n\u0015\f\u0015\u009b\t\u0015\u0000\u0000\u0016\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016\u0001\u0000\u0004"+
		"\u0001\u0000\"\"\u0002\u0000\t\n  \u0003\u0000AZ__az\u0004\u000009AZ_"+
		"_az\u00a2\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0001-\u0001\u0000\u0000"+
		"\u0000\u00031\u0001\u0000\u0000\u0000\u00055\u0001\u0000\u0000\u0000\u0007"+
		";\u0001\u0000\u0000\u0000\t@\u0001\u0000\u0000\u0000\u000bG\u0001\u0000"+
		"\u0000\u0000\rK\u0001\u0000\u0000\u0000\u000fP\u0001\u0000\u0000\u0000"+
		"\u0011Y\u0001\u0000\u0000\u0000\u0013^\u0001\u0000\u0000\u0000\u0015d"+
		"\u0001\u0000\u0000\u0000\u0017h\u0001\u0000\u0000\u0000\u0019s\u0001\u0000"+
		"\u0000\u0000\u001bu\u0001\u0000\u0000\u0000\u001dw\u0001\u0000\u0000\u0000"+
		"\u001fy\u0001\u0000\u0000\u0000!|\u0001\u0000\u0000\u0000#\u0083\u0001"+
		"\u0000\u0000\u0000%\u008f\u0001\u0000\u0000\u0000\'\u0091\u0001\u0000"+
		"\u0000\u0000)\u0093\u0001\u0000\u0000\u0000+\u0095\u0001\u0000\u0000\u0000"+
		"-.\u0005v\u0000\u0000./\u0005a\u0000\u0000/0\u0005l\u0000\u00000\u0002"+
		"\u0001\u0000\u0000\u000012\u0005i\u0000\u000023\u0005n\u0000\u000034\u0005"+
		"t\u0000\u00004\u0004\u0001\u0000\u0000\u000056\u0005f\u0000\u000067\u0005"+
		"l\u0000\u000078\u0005o\u0000\u000089\u0005a\u0000\u00009:\u0005t\u0000"+
		"\u0000:\u0006\u0001\u0000\u0000\u0000;<\u0005b\u0000\u0000<=\u0005o\u0000"+
		"\u0000=>\u0005o\u0000\u0000>?\u0005l\u0000\u0000?\b\u0001\u0000\u0000"+
		"\u0000@A\u0005s\u0000\u0000AB\u0005t\u0000\u0000BC\u0005r\u0000\u0000"+
		"CD\u0005i\u0000\u0000DE\u0005n\u0000\u0000EF\u0005g\u0000\u0000F\n\u0001"+
		"\u0000\u0000\u0000GH\u0005f\u0000\u0000HI\u0005u\u0000\u0000IJ\u0005n"+
		"\u0000\u0000J\f\u0001\u0000\u0000\u0000KL\u0005v\u0000\u0000LM\u0005o"+
		"\u0000\u0000MN\u0005i\u0000\u0000NO\u0005d\u0000\u0000O\u000e\u0001\u0000"+
		"\u0000\u0000PQ\u0005a\u0000\u0000QR\u0005n\u0000\u0000RS\u0005y\u0000"+
		"\u0000ST\u0005t\u0000\u0000TU\u0005h\u0000\u0000UV\u0005i\u0000\u0000"+
		"VW\u0005n\u0000\u0000WX\u0005g\u0000\u0000X\u0010\u0001\u0000\u0000\u0000"+
		"YZ\u0005t\u0000\u0000Z[\u0005r\u0000\u0000[\\\u0005u\u0000\u0000\\]\u0005"+
		"e\u0000\u0000]\u0012\u0001\u0000\u0000\u0000^_\u0005f\u0000\u0000_`\u0005"+
		"a\u0000\u0000`a\u0005l\u0000\u0000ab\u0005s\u0000\u0000bc\u0005e\u0000"+
		"\u0000c\u0014\u0001\u0000\u0000\u0000de\u0005n\u0000\u0000ef\u0005i\u0000"+
		"\u0000fg\u0005x\u0000\u0000g\u0016\u0001\u0000\u0000\u0000hn\u0005\"\u0000"+
		"\u0000ij\u0005\\\u0000\u0000jm\u0005\"\u0000\u0000km\b\u0000\u0000\u0000"+
		"li\u0001\u0000\u0000\u0000lk\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000"+
		"\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000oq\u0001\u0000"+
		"\u0000\u0000pn\u0001\u0000\u0000\u0000qr\u0005\"\u0000\u0000r\u0018\u0001"+
		"\u0000\u0000\u0000st\u0005{\u0000\u0000t\u001a\u0001\u0000\u0000\u0000"+
		"uv\u0005}\u0000\u0000v\u001c\u0001\u0000\u0000\u0000wx\u0005(\u0000\u0000"+
		"x\u001e\u0001\u0000\u0000\u0000yz\u0005)\u0000\u0000z \u0001\u0000\u0000"+
		"\u0000{}\u0007\u0001\u0000\u0000|{\u0001\u0000\u0000\u0000}~\u0001\u0000"+
		"\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0006\u0010\u0000\u0000"+
		"\u0081\"\u0001\u0000\u0000\u0000\u0082\u0084\u000209\u0000\u0083\u0082"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0083"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u008d"+
		"\u0001\u0000\u0000\u0000\u0087\u0089\u0005.\u0000\u0000\u0088\u008a\u0002"+
		"09\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000"+
		"\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000"+
		"\u0000\u008c\u008e\u0001\u0000\u0000\u0000\u008d\u0087\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e$\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0005:\u0000\u0000\u0090&\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0005=\u0000\u0000\u0092(\u0001\u0000\u0000\u0000\u0093\u0094\u0005,"+
		"\u0000\u0000\u0094*\u0001\u0000\u0000\u0000\u0095\u0099\u0007\u0002\u0000"+
		"\u0000\u0096\u0098\u0007\u0003\u0000\u0000\u0097\u0096\u0001\u0000\u0000"+
		"\u0000\u0098\u009b\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000"+
		"\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a,\u0001\u0000\u0000\u0000"+
		"\u009b\u0099\u0001\u0000\u0000\u0000\b\u0000ln~\u0085\u008b\u008d\u0099"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}