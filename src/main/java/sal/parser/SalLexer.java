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
		VAL_KW=1, INT_KW=2, FLOAT_KW=3, BOOL_KW=4, TRUE_LIT=5, FALSE_LIT=6, WS=7, 
		NUMBER=8, COLON_OP=9, ASSIGN_OP=10, ID=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VAL_KW", "INT_KW", "FLOAT_KW", "BOOL_KW", "TRUE_LIT", "FALSE_LIT", "WS", 
			"NUMBER", "COLON_OP", "ASSIGN_OP", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'val'", "'int'", "'float'", "'bool'", "'true'", "'false'", null, 
			null, "':'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAL_KW", "INT_KW", "FLOAT_KW", "BOOL_KW", "TRUE_LIT", "FALSE_LIT", 
			"WS", "NUMBER", "COLON_OP", "ASSIGN_OP", "ID"
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
		"\u0004\u0000\u000bT\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0004\u00067\b\u0006\u000b\u0006\f\u00068\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0004\u0007>\b\u0007\u000b\u0007\f\u0007?\u0001\u0007\u0001\u0007"+
		"\u0004\u0007D\b\u0007\u000b\u0007\f\u0007E\u0003\u0007H\b\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0005\nP\b\n\n\n\f\nS\t\n\u0000"+
		"\u0000\u000b\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0001\u0000\u0003\u0002"+
		"\u0000\t\n  \u0003\u0000AZ__az\u0004\u000009AZ__azX\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0001\u0017\u0001\u0000\u0000\u0000\u0003\u001b\u0001\u0000\u0000"+
		"\u0000\u0005\u001f\u0001\u0000\u0000\u0000\u0007%\u0001\u0000\u0000\u0000"+
		"\t*\u0001\u0000\u0000\u0000\u000b/\u0001\u0000\u0000\u0000\r6\u0001\u0000"+
		"\u0000\u0000\u000f=\u0001\u0000\u0000\u0000\u0011I\u0001\u0000\u0000\u0000"+
		"\u0013K\u0001\u0000\u0000\u0000\u0015M\u0001\u0000\u0000\u0000\u0017\u0018"+
		"\u0005v\u0000\u0000\u0018\u0019\u0005a\u0000\u0000\u0019\u001a\u0005l"+
		"\u0000\u0000\u001a\u0002\u0001\u0000\u0000\u0000\u001b\u001c\u0005i\u0000"+
		"\u0000\u001c\u001d\u0005n\u0000\u0000\u001d\u001e\u0005t\u0000\u0000\u001e"+
		"\u0004\u0001\u0000\u0000\u0000\u001f \u0005f\u0000\u0000 !\u0005l\u0000"+
		"\u0000!\"\u0005o\u0000\u0000\"#\u0005a\u0000\u0000#$\u0005t\u0000\u0000"+
		"$\u0006\u0001\u0000\u0000\u0000%&\u0005b\u0000\u0000&\'\u0005o\u0000\u0000"+
		"\'(\u0005o\u0000\u0000()\u0005l\u0000\u0000)\b\u0001\u0000\u0000\u0000"+
		"*+\u0005t\u0000\u0000+,\u0005r\u0000\u0000,-\u0005u\u0000\u0000-.\u0005"+
		"e\u0000\u0000.\n\u0001\u0000\u0000\u0000/0\u0005f\u0000\u000001\u0005"+
		"a\u0000\u000012\u0005l\u0000\u000023\u0005s\u0000\u000034\u0005e\u0000"+
		"\u00004\f\u0001\u0000\u0000\u000057\u0007\u0000\u0000\u000065\u0001\u0000"+
		"\u0000\u000078\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001"+
		"\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:;\u0006\u0006\u0000\u0000"+
		";\u000e\u0001\u0000\u0000\u0000<>\u000209\u0000=<\u0001\u0000\u0000\u0000"+
		">?\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000"+
		"\u0000@G\u0001\u0000\u0000\u0000AC\u0005.\u0000\u0000BD\u000209\u0000"+
		"CB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000FH\u0001\u0000\u0000\u0000GA\u0001\u0000"+
		"\u0000\u0000GH\u0001\u0000\u0000\u0000H\u0010\u0001\u0000\u0000\u0000"+
		"IJ\u0005:\u0000\u0000J\u0012\u0001\u0000\u0000\u0000KL\u0005=\u0000\u0000"+
		"L\u0014\u0001\u0000\u0000\u0000MQ\u0007\u0001\u0000\u0000NP\u0007\u0002"+
		"\u0000\u0000ON\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001"+
		"\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000R\u0016\u0001\u0000\u0000"+
		"\u0000SQ\u0001\u0000\u0000\u0000\u0006\u00008?EGQ\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}