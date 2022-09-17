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
		ANY_KW=8, REC_KW=9, NEW_KW=10, IF_KW=11, ELSE_KW=12, AS_KW=13, WITH_KW=14, 
		TRUE_LIT=15, FALSE_LIT=16, NIX_LIT=17, STRING_LIT=18, LEFT_BRACES=19, 
		RIGHT_BRACES=20, LEFT_PARENTHESE=21, RIGHT_PARENTHESE=22, LEFT_SQUARE=23, 
		RIGHT_SQUARE=24, WS=25, NUMBER=26, COLON_OP=27, ASSIGN_OP=28, COMMA_OP=29, 
		ARROW_OP=30, DOT_OP=31, BIT_AND_OP=32, BIT_OR_OP=33, BIT_NOT_OP=34, BIT_XOR_OP=35, 
		LEFT_SHIFT_OP=36, RIGHT_SHIFT_OP=37, LOGIC_AND_OP=38, LOGIC_OR_OP=39, 
		LOGIC_NOT_OP=40, ADD_OP=41, SUB_OP=42, MUL_OP=43, DIV_OP=44, MOD_OP=45, 
		POW_OP=46, LESS_OP=47, GREATER_OP=48, LE_OP=49, GE_OP=50, NE_OP=51, EQ_OP=52, 
		ID=53;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VAL_KW", "INT_KW", "FLOAT_KW", "BOOL_KW", "STRING_KW", "FUN_KW", "VOID_KW", 
			"ANY_KW", "REC_KW", "NEW_KW", "IF_KW", "ELSE_KW", "AS_KW", "WITH_KW", 
			"TRUE_LIT", "FALSE_LIT", "NIX_LIT", "STRING_LIT", "LEFT_BRACES", "RIGHT_BRACES", 
			"LEFT_PARENTHESE", "RIGHT_PARENTHESE", "LEFT_SQUARE", "RIGHT_SQUARE", 
			"WS", "NUMBER", "COLON_OP", "ASSIGN_OP", "COMMA_OP", "ARROW_OP", "DOT_OP", 
			"BIT_AND_OP", "BIT_OR_OP", "BIT_NOT_OP", "BIT_XOR_OP", "LEFT_SHIFT_OP", 
			"RIGHT_SHIFT_OP", "LOGIC_AND_OP", "LOGIC_OR_OP", "LOGIC_NOT_OP", "ADD_OP", 
			"SUB_OP", "MUL_OP", "DIV_OP", "MOD_OP", "POW_OP", "LESS_OP", "GREATER_OP", 
			"LE_OP", "GE_OP", "NE_OP", "EQ_OP", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'val'", "'int'", "'float'", "'bool'", "'string'", "'fun'", "'void'", 
			"'anything'", "'rec'", "'new'", "'if'", "'else'", "'as'", "'with'", "'true'", 
			"'false'", "'nix'", null, "'{'", "'}'", "'('", "')'", "'['", "']'", null, 
			null, "':'", "'='", "','", "'->'", "'.'", "'&'", "'|'", "'~'", "'^'", 
			"'<<'", "'>>'", "'&&'", "'||'", "'!'", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'^^'", "'<'", "'>'", "'<='", "'>='", "'!='", "'=='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAL_KW", "INT_KW", "FLOAT_KW", "BOOL_KW", "STRING_KW", "FUN_KW", 
			"VOID_KW", "ANY_KW", "REC_KW", "NEW_KW", "IF_KW", "ELSE_KW", "AS_KW", 
			"WITH_KW", "TRUE_LIT", "FALSE_LIT", "NIX_LIT", "STRING_LIT", "LEFT_BRACES", 
			"RIGHT_BRACES", "LEFT_PARENTHESE", "RIGHT_PARENTHESE", "LEFT_SQUARE", 
			"RIGHT_SQUARE", "WS", "NUMBER", "COLON_OP", "ASSIGN_OP", "COMMA_OP", 
			"ARROW_OP", "DOT_OP", "BIT_AND_OP", "BIT_OR_OP", "BIT_NOT_OP", "BIT_XOR_OP", 
			"LEFT_SHIFT_OP", "RIGHT_SHIFT_OP", "LOGIC_AND_OP", "LOGIC_OR_OP", "LOGIC_NOT_OP", 
			"ADD_OP", "SUB_OP", "MUL_OP", "DIV_OP", "MOD_OP", "POW_OP", "LESS_OP", 
			"GREATER_OP", "LE_OP", "GE_OP", "NE_OP", "EQ_OP", "ID"
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
		"\u0004\u00005\u012e\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0005\u0011\u00c3\b\u0011\n\u0011\f\u0011\u00c6\t\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0004\u0018\u00d7\b\u0018\u000b\u0018\f"+
		"\u0018\u00d8\u0001\u0018\u0001\u0018\u0001\u0019\u0004\u0019\u00de\b\u0019"+
		"\u000b\u0019\f\u0019\u00df\u0001\u0019\u0001\u0019\u0004\u0019\u00e4\b"+
		"\u0019\u000b\u0019\f\u0019\u00e5\u0003\u0019\u00e8\b\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"+
		"\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001"+
		"$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001\'\u0001"+
		"\'\u0001(\u0001(\u0001)\u0001)\u0001*\u0001*\u0001+\u0001+\u0001,\u0001"+
		",\u0001-\u0001-\u0001-\u0001.\u0001.\u0001/\u0001/\u00010\u00010\u0001"+
		"0\u00011\u00011\u00011\u00012\u00012\u00012\u00013\u00013\u00013\u0001"+
		"4\u00014\u00054\u012a\b4\n4\f4\u012d\t4\u0000\u00005\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a"+
		"5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/"+
		"_0a1c2e3g4i5\u0001\u0000\u0004\u0001\u0000\"\"\u0002\u0000\t\n  \u0003"+
		"\u0000AZ__az\u0004\u000009AZ__az\u0134\u0000\u0001\u0001\u0000\u0000\u0000"+
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
		"\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000"+
		"\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000"+
		";\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001"+
		"\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000"+
		"\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000"+
		"I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001"+
		"\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000"+
		"\u0000\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000"+
		"W\u0001\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001"+
		"\u0000\u0000\u0000\u0000]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000"+
		"\u0000\u0000a\u0001\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000\u0000"+
		"e\u0001\u0000\u0000\u0000\u0000g\u0001\u0000\u0000\u0000\u0000i\u0001"+
		"\u0000\u0000\u0000\u0001k\u0001\u0000\u0000\u0000\u0003o\u0001\u0000\u0000"+
		"\u0000\u0005s\u0001\u0000\u0000\u0000\u0007y\u0001\u0000\u0000\u0000\t"+
		"~\u0001\u0000\u0000\u0000\u000b\u0085\u0001\u0000\u0000\u0000\r\u0089"+
		"\u0001\u0000\u0000\u0000\u000f\u008e\u0001\u0000\u0000\u0000\u0011\u0097"+
		"\u0001\u0000\u0000\u0000\u0013\u009b\u0001\u0000\u0000\u0000\u0015\u009f"+
		"\u0001\u0000\u0000\u0000\u0017\u00a2\u0001\u0000\u0000\u0000\u0019\u00a7"+
		"\u0001\u0000\u0000\u0000\u001b\u00aa\u0001\u0000\u0000\u0000\u001d\u00af"+
		"\u0001\u0000\u0000\u0000\u001f\u00b4\u0001\u0000\u0000\u0000!\u00ba\u0001"+
		"\u0000\u0000\u0000#\u00be\u0001\u0000\u0000\u0000%\u00c9\u0001\u0000\u0000"+
		"\u0000\'\u00cb\u0001\u0000\u0000\u0000)\u00cd\u0001\u0000\u0000\u0000"+
		"+\u00cf\u0001\u0000\u0000\u0000-\u00d1\u0001\u0000\u0000\u0000/\u00d3"+
		"\u0001\u0000\u0000\u00001\u00d6\u0001\u0000\u0000\u00003\u00dd\u0001\u0000"+
		"\u0000\u00005\u00e9\u0001\u0000\u0000\u00007\u00eb\u0001\u0000\u0000\u0000"+
		"9\u00ed\u0001\u0000\u0000\u0000;\u00ef\u0001\u0000\u0000\u0000=\u00f2"+
		"\u0001\u0000\u0000\u0000?\u00f4\u0001\u0000\u0000\u0000A\u00f6\u0001\u0000"+
		"\u0000\u0000C\u00f8\u0001\u0000\u0000\u0000E\u00fa\u0001\u0000\u0000\u0000"+
		"G\u00fc\u0001\u0000\u0000\u0000I\u00ff\u0001\u0000\u0000\u0000K\u0102"+
		"\u0001\u0000\u0000\u0000M\u0105\u0001\u0000\u0000\u0000O\u0108\u0001\u0000"+
		"\u0000\u0000Q\u010a\u0001\u0000\u0000\u0000S\u010c\u0001\u0000\u0000\u0000"+
		"U\u010e\u0001\u0000\u0000\u0000W\u0110\u0001\u0000\u0000\u0000Y\u0112"+
		"\u0001\u0000\u0000\u0000[\u0114\u0001\u0000\u0000\u0000]\u0117\u0001\u0000"+
		"\u0000\u0000_\u0119\u0001\u0000\u0000\u0000a\u011b\u0001\u0000\u0000\u0000"+
		"c\u011e\u0001\u0000\u0000\u0000e\u0121\u0001\u0000\u0000\u0000g\u0124"+
		"\u0001\u0000\u0000\u0000i\u0127\u0001\u0000\u0000\u0000kl\u0005v\u0000"+
		"\u0000lm\u0005a\u0000\u0000mn\u0005l\u0000\u0000n\u0002\u0001\u0000\u0000"+
		"\u0000op\u0005i\u0000\u0000pq\u0005n\u0000\u0000qr\u0005t\u0000\u0000"+
		"r\u0004\u0001\u0000\u0000\u0000st\u0005f\u0000\u0000tu\u0005l\u0000\u0000"+
		"uv\u0005o\u0000\u0000vw\u0005a\u0000\u0000wx\u0005t\u0000\u0000x\u0006"+
		"\u0001\u0000\u0000\u0000yz\u0005b\u0000\u0000z{\u0005o\u0000\u0000{|\u0005"+
		"o\u0000\u0000|}\u0005l\u0000\u0000}\b\u0001\u0000\u0000\u0000~\u007f\u0005"+
		"s\u0000\u0000\u007f\u0080\u0005t\u0000\u0000\u0080\u0081\u0005r\u0000"+
		"\u0000\u0081\u0082\u0005i\u0000\u0000\u0082\u0083\u0005n\u0000\u0000\u0083"+
		"\u0084\u0005g\u0000\u0000\u0084\n\u0001\u0000\u0000\u0000\u0085\u0086"+
		"\u0005f\u0000\u0000\u0086\u0087\u0005u\u0000\u0000\u0087\u0088\u0005n"+
		"\u0000\u0000\u0088\f\u0001\u0000\u0000\u0000\u0089\u008a\u0005v\u0000"+
		"\u0000\u008a\u008b\u0005o\u0000\u0000\u008b\u008c\u0005i\u0000\u0000\u008c"+
		"\u008d\u0005d\u0000\u0000\u008d\u000e\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0005a\u0000\u0000\u008f\u0090\u0005n\u0000\u0000\u0090\u0091\u0005y"+
		"\u0000\u0000\u0091\u0092\u0005t\u0000\u0000\u0092\u0093\u0005h\u0000\u0000"+
		"\u0093\u0094\u0005i\u0000\u0000\u0094\u0095\u0005n\u0000\u0000\u0095\u0096"+
		"\u0005g\u0000\u0000\u0096\u0010\u0001\u0000\u0000\u0000\u0097\u0098\u0005"+
		"r\u0000\u0000\u0098\u0099\u0005e\u0000\u0000\u0099\u009a\u0005c\u0000"+
		"\u0000\u009a\u0012\u0001\u0000\u0000\u0000\u009b\u009c\u0005n\u0000\u0000"+
		"\u009c\u009d\u0005e\u0000\u0000\u009d\u009e\u0005w\u0000\u0000\u009e\u0014"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0005i\u0000\u0000\u00a0\u00a1\u0005"+
		"f\u0000\u0000\u00a1\u0016\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005e\u0000"+
		"\u0000\u00a3\u00a4\u0005l\u0000\u0000\u00a4\u00a5\u0005s\u0000\u0000\u00a5"+
		"\u00a6\u0005e\u0000\u0000\u00a6\u0018\u0001\u0000\u0000\u0000\u00a7\u00a8"+
		"\u0005a\u0000\u0000\u00a8\u00a9\u0005s\u0000\u0000\u00a9\u001a\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0005w\u0000\u0000\u00ab\u00ac\u0005i\u0000\u0000"+
		"\u00ac\u00ad\u0005t\u0000\u0000\u00ad\u00ae\u0005h\u0000\u0000\u00ae\u001c"+
		"\u0001\u0000\u0000\u0000\u00af\u00b0\u0005t\u0000\u0000\u00b0\u00b1\u0005"+
		"r\u0000\u0000\u00b1\u00b2\u0005u\u0000\u0000\u00b2\u00b3\u0005e\u0000"+
		"\u0000\u00b3\u001e\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005f\u0000\u0000"+
		"\u00b5\u00b6\u0005a\u0000\u0000\u00b6\u00b7\u0005l\u0000\u0000\u00b7\u00b8"+
		"\u0005s\u0000\u0000\u00b8\u00b9\u0005e\u0000\u0000\u00b9 \u0001\u0000"+
		"\u0000\u0000\u00ba\u00bb\u0005n\u0000\u0000\u00bb\u00bc\u0005i\u0000\u0000"+
		"\u00bc\u00bd\u0005x\u0000\u0000\u00bd\"\u0001\u0000\u0000\u0000\u00be"+
		"\u00c4\u0005\"\u0000\u0000\u00bf\u00c0\u0005\\\u0000\u0000\u00c0\u00c3"+
		"\u0005\"\u0000\u0000\u00c1\u00c3\b\u0000\u0000\u0000\u00c2\u00bf\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c7\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c8\u0005\"\u0000\u0000\u00c8$\u0001\u0000"+
		"\u0000\u0000\u00c9\u00ca\u0005{\u0000\u0000\u00ca&\u0001\u0000\u0000\u0000"+
		"\u00cb\u00cc\u0005}\u0000\u0000\u00cc(\u0001\u0000\u0000\u0000\u00cd\u00ce"+
		"\u0005(\u0000\u0000\u00ce*\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005)"+
		"\u0000\u0000\u00d0,\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005[\u0000\u0000"+
		"\u00d2.\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005]\u0000\u0000\u00d40"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d7\u0007\u0001\u0000\u0000\u00d6\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00da"+
		"\u0001\u0000\u0000\u0000\u00da\u00db\u0006\u0018\u0000\u0000\u00db2\u0001"+
		"\u0000\u0000\u0000\u00dc\u00de\u000209\u0000\u00dd\u00dc\u0001\u0000\u0000"+
		"\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e7\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e3\u0005.\u0000\u0000\u00e2\u00e4\u000209\u0000\u00e3"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e8\u0001\u0000\u0000\u0000\u00e7\u00e1\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e8\u0001\u0000\u0000\u0000\u00e84\u0001\u0000\u0000\u0000\u00e9\u00ea"+
		"\u0005:\u0000\u0000\u00ea6\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005="+
		"\u0000\u0000\u00ec8\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005,\u0000\u0000"+
		"\u00ee:\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005-\u0000\u0000\u00f0\u00f1"+
		"\u0005>\u0000\u0000\u00f1<\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005."+
		"\u0000\u0000\u00f3>\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005&\u0000\u0000"+
		"\u00f5@\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005|\u0000\u0000\u00f7B"+
		"\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005~\u0000\u0000\u00f9D\u0001\u0000"+
		"\u0000\u0000\u00fa\u00fb\u0005^\u0000\u0000\u00fbF\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fd\u0005<\u0000\u0000\u00fd\u00fe\u0005<\u0000\u0000\u00feH"+
		"\u0001\u0000\u0000\u0000\u00ff\u0100\u0005>\u0000\u0000\u0100\u0101\u0005"+
		">\u0000\u0000\u0101J\u0001\u0000\u0000\u0000\u0102\u0103\u0005&\u0000"+
		"\u0000\u0103\u0104\u0005&\u0000\u0000\u0104L\u0001\u0000\u0000\u0000\u0105"+
		"\u0106\u0005|\u0000\u0000\u0106\u0107\u0005|\u0000\u0000\u0107N\u0001"+
		"\u0000\u0000\u0000\u0108\u0109\u0005!\u0000\u0000\u0109P\u0001\u0000\u0000"+
		"\u0000\u010a\u010b\u0005+\u0000\u0000\u010bR\u0001\u0000\u0000\u0000\u010c"+
		"\u010d\u0005-\u0000\u0000\u010dT\u0001\u0000\u0000\u0000\u010e\u010f\u0005"+
		"*\u0000\u0000\u010fV\u0001\u0000\u0000\u0000\u0110\u0111\u0005/\u0000"+
		"\u0000\u0111X\u0001\u0000\u0000\u0000\u0112\u0113\u0005%\u0000\u0000\u0113"+
		"Z\u0001\u0000\u0000\u0000\u0114\u0115\u0005^\u0000\u0000\u0115\u0116\u0005"+
		"^\u0000\u0000\u0116\\\u0001\u0000\u0000\u0000\u0117\u0118\u0005<\u0000"+
		"\u0000\u0118^\u0001\u0000\u0000\u0000\u0119\u011a\u0005>\u0000\u0000\u011a"+
		"`\u0001\u0000\u0000\u0000\u011b\u011c\u0005<\u0000\u0000\u011c\u011d\u0005"+
		"=\u0000\u0000\u011db\u0001\u0000\u0000\u0000\u011e\u011f\u0005>\u0000"+
		"\u0000\u011f\u0120\u0005=\u0000\u0000\u0120d\u0001\u0000\u0000\u0000\u0121"+
		"\u0122\u0005!\u0000\u0000\u0122\u0123\u0005=\u0000\u0000\u0123f\u0001"+
		"\u0000\u0000\u0000\u0124\u0125\u0005=\u0000\u0000\u0125\u0126\u0005=\u0000"+
		"\u0000\u0126h\u0001\u0000\u0000\u0000\u0127\u012b\u0007\u0002\u0000\u0000"+
		"\u0128\u012a\u0007\u0003\u0000\u0000\u0129\u0128\u0001\u0000\u0000\u0000"+
		"\u012a\u012d\u0001\u0000\u0000\u0000\u012b\u0129\u0001\u0000\u0000\u0000"+
		"\u012b\u012c\u0001\u0000\u0000\u0000\u012cj\u0001\u0000\u0000\u0000\u012d"+
		"\u012b\u0001\u0000\u0000\u0000\b\u0000\u00c2\u00c4\u00d8\u00df\u00e5\u00e7"+
		"\u012b\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}