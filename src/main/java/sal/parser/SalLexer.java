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
		ANY_KW=8, TRUE_LIT=9, FALSE_LIT=10, STRING_LIT=11, LEFT_BRACES=12, RIGHT_BRACES=13, 
		LEFT_PARENTHESE=14, RIGHT_PARENTHESE=15, WS=16, NUMBER=17, COLON_OP=18, 
		ASSIGN_OP=19, COMMA_OP=20, ID=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VAL_KW", "INT_KW", "FLOAT_KW", "BOOL_KW", "STRING_KW", "FUN_KW", "VOID_KW", 
			"ANY_KW", "TRUE_LIT", "FALSE_LIT", "STRING_LIT", "LEFT_BRACES", "RIGHT_BRACES", 
			"LEFT_PARENTHESE", "RIGHT_PARENTHESE", "WS", "NUMBER", "COLON_OP", "ASSIGN_OP", 
			"COMMA_OP", "ID"
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
		"\u0004\u0000\u0015\u0096\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0005\ng\b\n\n\n\f\nj\t\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0004\u000f"+
		"w\b\u000f\u000b\u000f\f\u000fx\u0001\u000f\u0001\u000f\u0001\u0010\u0004"+
		"\u0010~\b\u0010\u000b\u0010\f\u0010\u007f\u0001\u0010\u0001\u0010\u0004"+
		"\u0010\u0084\b\u0010\u000b\u0010\f\u0010\u0085\u0003\u0010\u0088\b\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u0092\b\u0014\n\u0014\f\u0014\u0095"+
		"\t\u0014\u0000\u0000\u0015\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'"+
		"\u0014)\u0015\u0001\u0000\u0004\u0001\u0000\"\"\u0002\u0000\t\n  \u0003"+
		"\u0000AZ__az\u0004\u000009AZ__az\u009c\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0000)\u0001\u0000\u0000\u0000\u0001+\u0001\u0000\u0000\u0000\u0003"+
		"/\u0001\u0000\u0000\u0000\u00053\u0001\u0000\u0000\u0000\u00079\u0001"+
		"\u0000\u0000\u0000\t>\u0001\u0000\u0000\u0000\u000bE\u0001\u0000\u0000"+
		"\u0000\rI\u0001\u0000\u0000\u0000\u000fN\u0001\u0000\u0000\u0000\u0011"+
		"W\u0001\u0000\u0000\u0000\u0013\\\u0001\u0000\u0000\u0000\u0015b\u0001"+
		"\u0000\u0000\u0000\u0017m\u0001\u0000\u0000\u0000\u0019o\u0001\u0000\u0000"+
		"\u0000\u001bq\u0001\u0000\u0000\u0000\u001ds\u0001\u0000\u0000\u0000\u001f"+
		"v\u0001\u0000\u0000\u0000!}\u0001\u0000\u0000\u0000#\u0089\u0001\u0000"+
		"\u0000\u0000%\u008b\u0001\u0000\u0000\u0000\'\u008d\u0001\u0000\u0000"+
		"\u0000)\u008f\u0001\u0000\u0000\u0000+,\u0005v\u0000\u0000,-\u0005a\u0000"+
		"\u0000-.\u0005l\u0000\u0000.\u0002\u0001\u0000\u0000\u0000/0\u0005i\u0000"+
		"\u000001\u0005n\u0000\u000012\u0005t\u0000\u00002\u0004\u0001\u0000\u0000"+
		"\u000034\u0005f\u0000\u000045\u0005l\u0000\u000056\u0005o\u0000\u0000"+
		"67\u0005a\u0000\u000078\u0005t\u0000\u00008\u0006\u0001\u0000\u0000\u0000"+
		"9:\u0005b\u0000\u0000:;\u0005o\u0000\u0000;<\u0005o\u0000\u0000<=\u0005"+
		"l\u0000\u0000=\b\u0001\u0000\u0000\u0000>?\u0005s\u0000\u0000?@\u0005"+
		"t\u0000\u0000@A\u0005r\u0000\u0000AB\u0005i\u0000\u0000BC\u0005n\u0000"+
		"\u0000CD\u0005g\u0000\u0000D\n\u0001\u0000\u0000\u0000EF\u0005f\u0000"+
		"\u0000FG\u0005u\u0000\u0000GH\u0005n\u0000\u0000H\f\u0001\u0000\u0000"+
		"\u0000IJ\u0005v\u0000\u0000JK\u0005o\u0000\u0000KL\u0005i\u0000\u0000"+
		"LM\u0005d\u0000\u0000M\u000e\u0001\u0000\u0000\u0000NO\u0005a\u0000\u0000"+
		"OP\u0005n\u0000\u0000PQ\u0005y\u0000\u0000QR\u0005t\u0000\u0000RS\u0005"+
		"h\u0000\u0000ST\u0005i\u0000\u0000TU\u0005n\u0000\u0000UV\u0005g\u0000"+
		"\u0000V\u0010\u0001\u0000\u0000\u0000WX\u0005t\u0000\u0000XY\u0005r\u0000"+
		"\u0000YZ\u0005u\u0000\u0000Z[\u0005e\u0000\u0000[\u0012\u0001\u0000\u0000"+
		"\u0000\\]\u0005f\u0000\u0000]^\u0005a\u0000\u0000^_\u0005l\u0000\u0000"+
		"_`\u0005s\u0000\u0000`a\u0005e\u0000\u0000a\u0014\u0001\u0000\u0000\u0000"+
		"bh\u0005\"\u0000\u0000cd\u0005\\\u0000\u0000dg\u0005\"\u0000\u0000eg\b"+
		"\u0000\u0000\u0000fc\u0001\u0000\u0000\u0000fe\u0001\u0000\u0000\u0000"+
		"gj\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000"+
		"\u0000ik\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000kl\u0005\"\u0000"+
		"\u0000l\u0016\u0001\u0000\u0000\u0000mn\u0005{\u0000\u0000n\u0018\u0001"+
		"\u0000\u0000\u0000op\u0005}\u0000\u0000p\u001a\u0001\u0000\u0000\u0000"+
		"qr\u0005(\u0000\u0000r\u001c\u0001\u0000\u0000\u0000st\u0005)\u0000\u0000"+
		"t\u001e\u0001\u0000\u0000\u0000uw\u0007\u0001\u0000\u0000vu\u0001\u0000"+
		"\u0000\u0000wx\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001"+
		"\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0006\u000f\u0000\u0000"+
		"{ \u0001\u0000\u0000\u0000|~\u000209\u0000}|\u0001\u0000\u0000\u0000~"+
		"\u007f\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0001\u0000\u0000\u0000\u0080\u0087\u0001\u0000\u0000\u0000\u0081\u0083"+
		"\u0005.\u0000\u0000\u0082\u0084\u000209\u0000\u0083\u0082\u0001\u0000"+
		"\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0088\u0001\u0000"+
		"\u0000\u0000\u0087\u0081\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000"+
		"\u0000\u0000\u0088\"\u0001\u0000\u0000\u0000\u0089\u008a\u0005:\u0000"+
		"\u0000\u008a$\u0001\u0000\u0000\u0000\u008b\u008c\u0005=\u0000\u0000\u008c"+
		"&\u0001\u0000\u0000\u0000\u008d\u008e\u0005,\u0000\u0000\u008e(\u0001"+
		"\u0000\u0000\u0000\u008f\u0093\u0007\u0002\u0000\u0000\u0090\u0092\u0007"+
		"\u0003\u0000\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0092\u0095\u0001"+
		"\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001"+
		"\u0000\u0000\u0000\u0094*\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000"+
		"\u0000\u0000\b\u0000fhx\u007f\u0085\u0087\u0093\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}