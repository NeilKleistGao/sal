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
		VAL_KW=1, INT_KW=2, FLOAT_KW=3, BOOL_KW=4, STRING_KW=5, TRUE_LIT=6, FALSE_LIT=7, 
		STRING_LIT=8, WS=9, NUMBER=10, COLON_OP=11, ASSIGN_OP=12, ID=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VAL_KW", "INT_KW", "FLOAT_KW", "BOOL_KW", "STRING_KW", "TRUE_LIT", "FALSE_LIT", 
			"STRING_LIT", "WS", "NUMBER", "COLON_OP", "ASSIGN_OP", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'val'", "'int'", "'float'", "'bool'", "'string'", "'true'", "'false'", 
			null, null, null, "':'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAL_KW", "INT_KW", "FLOAT_KW", "BOOL_KW", "STRING_KW", "TRUE_LIT", 
			"FALSE_LIT", "STRING_LIT", "WS", "NUMBER", "COLON_OP", "ASSIGN_OP", "ID"
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
		"\u0004\u0000\rj\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007E\b\u0007\n\u0007\f\u0007H\t\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0004\bM\b\b\u000b\b\f\bN\u0001\b\u0001\b\u0001"+
		"\t\u0004\tT\b\t\u000b\t\f\tU\u0001\t\u0001\t\u0004\tZ\b\t\u000b\t\f\t"+
		"[\u0003\t^\b\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0005\ff\b\f\n\f\f\fi\t\f\u0000\u0000\r\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\r\u0001\u0000\u0004\u0001\u0000\"\"\u0002\u0000"+
		"\t\n  \u0003\u0000AZ__az\u0004\u000009AZ__azp\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0001\u001b\u0001\u0000\u0000\u0000\u0003\u001f\u0001\u0000\u0000\u0000"+
		"\u0005#\u0001\u0000\u0000\u0000\u0007)\u0001\u0000\u0000\u0000\t.\u0001"+
		"\u0000\u0000\u0000\u000b5\u0001\u0000\u0000\u0000\r:\u0001\u0000\u0000"+
		"\u0000\u000f@\u0001\u0000\u0000\u0000\u0011L\u0001\u0000\u0000\u0000\u0013"+
		"S\u0001\u0000\u0000\u0000\u0015_\u0001\u0000\u0000\u0000\u0017a\u0001"+
		"\u0000\u0000\u0000\u0019c\u0001\u0000\u0000\u0000\u001b\u001c\u0005v\u0000"+
		"\u0000\u001c\u001d\u0005a\u0000\u0000\u001d\u001e\u0005l\u0000\u0000\u001e"+
		"\u0002\u0001\u0000\u0000\u0000\u001f \u0005i\u0000\u0000 !\u0005n\u0000"+
		"\u0000!\"\u0005t\u0000\u0000\"\u0004\u0001\u0000\u0000\u0000#$\u0005f"+
		"\u0000\u0000$%\u0005l\u0000\u0000%&\u0005o\u0000\u0000&\'\u0005a\u0000"+
		"\u0000\'(\u0005t\u0000\u0000(\u0006\u0001\u0000\u0000\u0000)*\u0005b\u0000"+
		"\u0000*+\u0005o\u0000\u0000+,\u0005o\u0000\u0000,-\u0005l\u0000\u0000"+
		"-\b\u0001\u0000\u0000\u0000./\u0005s\u0000\u0000/0\u0005t\u0000\u0000"+
		"01\u0005r\u0000\u000012\u0005i\u0000\u000023\u0005n\u0000\u000034\u0005"+
		"g\u0000\u00004\n\u0001\u0000\u0000\u000056\u0005t\u0000\u000067\u0005"+
		"r\u0000\u000078\u0005u\u0000\u000089\u0005e\u0000\u00009\f\u0001\u0000"+
		"\u0000\u0000:;\u0005f\u0000\u0000;<\u0005a\u0000\u0000<=\u0005l\u0000"+
		"\u0000=>\u0005s\u0000\u0000>?\u0005e\u0000\u0000?\u000e\u0001\u0000\u0000"+
		"\u0000@F\u0005\"\u0000\u0000AB\u0005\\\u0000\u0000BE\u0005\"\u0000\u0000"+
		"CE\b\u0000\u0000\u0000DA\u0001\u0000\u0000\u0000DC\u0001\u0000\u0000\u0000"+
		"EH\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000"+
		"\u0000GI\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IJ\u0005\"\u0000"+
		"\u0000J\u0010\u0001\u0000\u0000\u0000KM\u0007\u0001\u0000\u0000LK\u0001"+
		"\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000"+
		"NO\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PQ\u0006\b\u0000\u0000"+
		"Q\u0012\u0001\u0000\u0000\u0000RT\u000209\u0000SR\u0001\u0000\u0000\u0000"+
		"TU\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000"+
		"\u0000V]\u0001\u0000\u0000\u0000WY\u0005.\u0000\u0000XZ\u000209\u0000"+
		"YX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000"+
		"\u0000[\\\u0001\u0000\u0000\u0000\\^\u0001\u0000\u0000\u0000]W\u0001\u0000"+
		"\u0000\u0000]^\u0001\u0000\u0000\u0000^\u0014\u0001\u0000\u0000\u0000"+
		"_`\u0005:\u0000\u0000`\u0016\u0001\u0000\u0000\u0000ab\u0005=\u0000\u0000"+
		"b\u0018\u0001\u0000\u0000\u0000cg\u0007\u0002\u0000\u0000df\u0007\u0003"+
		"\u0000\u0000ed\u0001\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000ge\u0001"+
		"\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000h\u001a\u0001\u0000\u0000"+
		"\u0000ig\u0001\u0000\u0000\u0000\b\u0000DFNU[]g\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}