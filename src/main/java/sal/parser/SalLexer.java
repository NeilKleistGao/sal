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
		VAL_KW=1, INT_KW=2, FLOAT_KW=3, BOOL_KW=4, STRING_KW=5, FUN_KW=6, TRUE_LIT=7, 
		FALSE_LIT=8, STRING_LIT=9, LEFT_BRACES=10, RIGHT_BRACES=11, LEFT_PARENTHESE=12, 
		RIGHT_PARENTHESE=13, WS=14, NUMBER=15, COLON_OP=16, ASSIGN_OP=17, COMMA_OP=18, 
		ID=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VAL_KW", "INT_KW", "FLOAT_KW", "BOOL_KW", "STRING_KW", "FUN_KW", "TRUE_LIT", 
			"FALSE_LIT", "STRING_LIT", "LEFT_BRACES", "RIGHT_BRACES", "LEFT_PARENTHESE", 
			"RIGHT_PARENTHESE", "WS", "NUMBER", "COLON_OP", "ASSIGN_OP", "COMMA_OP", 
			"ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'val'", "'int'", "'float'", "'bool'", "'string'", "'fun'", "'true'", 
			"'false'", null, "'{'", "'}'", "'('", "')'", null, null, "':'", "'='", 
			"','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAL_KW", "INT_KW", "FLOAT_KW", "BOOL_KW", "STRING_KW", "FUN_KW", 
			"TRUE_LIT", "FALSE_LIT", "STRING_LIT", "LEFT_BRACES", "RIGHT_BRACES", 
			"LEFT_PARENTHESE", "RIGHT_PARENTHESE", "WS", "NUMBER", "COLON_OP", "ASSIGN_OP", 
			"COMMA_OP", "ID"
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
		"\u0004\u0000\u0013\u0084\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bU\b\b\n\b\f\bX\t\b"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0004\re\b\r\u000b\r\f\rf\u0001\r\u0001\r\u0001"+
		"\u000e\u0004\u000el\b\u000e\u000b\u000e\f\u000em\u0001\u000e\u0001\u000e"+
		"\u0004\u000er\b\u000e\u000b\u000e\f\u000es\u0003\u000ev\b\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0005\u0012\u0080\b\u0012\n\u0012\f\u0012\u0083\t\u0012"+
		"\u0000\u0000\u0013\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\u0001\u0000"+
		"\u0004\u0001\u0000\"\"\u0002\u0000\t\n  \u0003\u0000AZ__az\u0004\u0000"+
		"09AZ__az\u008a\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0001\'\u0001\u0000\u0000\u0000\u0003+\u0001"+
		"\u0000\u0000\u0000\u0005/\u0001\u0000\u0000\u0000\u00075\u0001\u0000\u0000"+
		"\u0000\t:\u0001\u0000\u0000\u0000\u000bA\u0001\u0000\u0000\u0000\rE\u0001"+
		"\u0000\u0000\u0000\u000fJ\u0001\u0000\u0000\u0000\u0011P\u0001\u0000\u0000"+
		"\u0000\u0013[\u0001\u0000\u0000\u0000\u0015]\u0001\u0000\u0000\u0000\u0017"+
		"_\u0001\u0000\u0000\u0000\u0019a\u0001\u0000\u0000\u0000\u001bd\u0001"+
		"\u0000\u0000\u0000\u001dk\u0001\u0000\u0000\u0000\u001fw\u0001\u0000\u0000"+
		"\u0000!y\u0001\u0000\u0000\u0000#{\u0001\u0000\u0000\u0000%}\u0001\u0000"+
		"\u0000\u0000\'(\u0005v\u0000\u0000()\u0005a\u0000\u0000)*\u0005l\u0000"+
		"\u0000*\u0002\u0001\u0000\u0000\u0000+,\u0005i\u0000\u0000,-\u0005n\u0000"+
		"\u0000-.\u0005t\u0000\u0000.\u0004\u0001\u0000\u0000\u0000/0\u0005f\u0000"+
		"\u000001\u0005l\u0000\u000012\u0005o\u0000\u000023\u0005a\u0000\u0000"+
		"34\u0005t\u0000\u00004\u0006\u0001\u0000\u0000\u000056\u0005b\u0000\u0000"+
		"67\u0005o\u0000\u000078\u0005o\u0000\u000089\u0005l\u0000\u00009\b\u0001"+
		"\u0000\u0000\u0000:;\u0005s\u0000\u0000;<\u0005t\u0000\u0000<=\u0005r"+
		"\u0000\u0000=>\u0005i\u0000\u0000>?\u0005n\u0000\u0000?@\u0005g\u0000"+
		"\u0000@\n\u0001\u0000\u0000\u0000AB\u0005f\u0000\u0000BC\u0005u\u0000"+
		"\u0000CD\u0005n\u0000\u0000D\f\u0001\u0000\u0000\u0000EF\u0005t\u0000"+
		"\u0000FG\u0005r\u0000\u0000GH\u0005u\u0000\u0000HI\u0005e\u0000\u0000"+
		"I\u000e\u0001\u0000\u0000\u0000JK\u0005f\u0000\u0000KL\u0005a\u0000\u0000"+
		"LM\u0005l\u0000\u0000MN\u0005s\u0000\u0000NO\u0005e\u0000\u0000O\u0010"+
		"\u0001\u0000\u0000\u0000PV\u0005\"\u0000\u0000QR\u0005\\\u0000\u0000R"+
		"U\u0005\"\u0000\u0000SU\b\u0000\u0000\u0000TQ\u0001\u0000\u0000\u0000"+
		"TS\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000"+
		"\u0000VW\u0001\u0000\u0000\u0000WY\u0001\u0000\u0000\u0000XV\u0001\u0000"+
		"\u0000\u0000YZ\u0005\"\u0000\u0000Z\u0012\u0001\u0000\u0000\u0000[\\\u0005"+
		"{\u0000\u0000\\\u0014\u0001\u0000\u0000\u0000]^\u0005}\u0000\u0000^\u0016"+
		"\u0001\u0000\u0000\u0000_`\u0005(\u0000\u0000`\u0018\u0001\u0000\u0000"+
		"\u0000ab\u0005)\u0000\u0000b\u001a\u0001\u0000\u0000\u0000ce\u0007\u0001"+
		"\u0000\u0000dc\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fd\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000"+
		"hi\u0006\r\u0000\u0000i\u001c\u0001\u0000\u0000\u0000jl\u000209\u0000"+
		"kj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000"+
		"\u0000mn\u0001\u0000\u0000\u0000nu\u0001\u0000\u0000\u0000oq\u0005.\u0000"+
		"\u0000pr\u000209\u0000qp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000"+
		"sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tv\u0001\u0000\u0000"+
		"\u0000uo\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000v\u001e\u0001"+
		"\u0000\u0000\u0000wx\u0005:\u0000\u0000x \u0001\u0000\u0000\u0000yz\u0005"+
		"=\u0000\u0000z\"\u0001\u0000\u0000\u0000{|\u0005,\u0000\u0000|$\u0001"+
		"\u0000\u0000\u0000}\u0081\u0007\u0002\u0000\u0000~\u0080\u0007\u0003\u0000"+
		"\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0083\u0001\u0000\u0000\u0000"+
		"\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000"+
		"\u0082&\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\b"+
		"\u0000TVfmsu\u0081\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}