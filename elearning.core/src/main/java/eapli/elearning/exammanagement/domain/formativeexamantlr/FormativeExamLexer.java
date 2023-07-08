// Generated from D:/ISEP/teste/elearning.core/src/main/java/eapli/elearning/exammanagement/domain/formativeexamantlr\FormativeExam.g4 by ANTLR 4.12.0
package eapli.elearning.exammanagement.domain.formativeexamantlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class FormativeExamLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, FEEDBACK=2, GRADE=3, FEEDBACK_GRADE_TYPE=4, QUESTION_TYPE=5, TEXT=6, 
		WS=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "FEEDBACK", "GRADE", "FEEDBACK_GRADE_TYPE", "QUESTION_TYPE", 
			"TEXT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\\n'", "'feedback: '", "'grade: '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "FEEDBACK", "GRADE", "FEEDBACK_GRADE_TYPE", "QUESTION_TYPE", 
			"TEXT", "WS"
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


	public FormativeExamLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FormativeExam.g4"; }

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
		"\u0004\u0000\u0007\u009f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003C\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0092\b\u0004\u0001"+
		"\u0005\u0004\u0005\u0095\b\u0005\u000b\u0005\f\u0005\u0096\u0001\u0006"+
		"\u0004\u0006\u009a\b\u0006\u000b\u0006\f\u0006\u009b\u0001\u0006\u0001"+
		"\u0006\u0000\u0000\u0007\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u0001\u0000\u0002\u0006\u0000 \",,09??AZ"+
		"az\u0003\u0000\t\n\r\r  \u00a7\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0001\u000f\u0001"+
		"\u0000\u0000\u0000\u0003\u0011\u0001\u0000\u0000\u0000\u0005\u001c\u0001"+
		"\u0000\u0000\u0000\u0007B\u0001\u0000\u0000\u0000\t\u0091\u0001\u0000"+
		"\u0000\u0000\u000b\u0094\u0001\u0000\u0000\u0000\r\u0099\u0001\u0000\u0000"+
		"\u0000\u000f\u0010\u0005\n\u0000\u0000\u0010\u0002\u0001\u0000\u0000\u0000"+
		"\u0011\u0012\u0005f\u0000\u0000\u0012\u0013\u0005e\u0000\u0000\u0013\u0014"+
		"\u0005e\u0000\u0000\u0014\u0015\u0005d\u0000\u0000\u0015\u0016\u0005b"+
		"\u0000\u0000\u0016\u0017\u0005a\u0000\u0000\u0017\u0018\u0005c\u0000\u0000"+
		"\u0018\u0019\u0005k\u0000\u0000\u0019\u001a\u0005:\u0000\u0000\u001a\u001b"+
		"\u0005 \u0000\u0000\u001b\u0004\u0001\u0000\u0000\u0000\u001c\u001d\u0005"+
		"g\u0000\u0000\u001d\u001e\u0005r\u0000\u0000\u001e\u001f\u0005a\u0000"+
		"\u0000\u001f \u0005d\u0000\u0000 !\u0005e\u0000\u0000!\"\u0005:\u0000"+
		"\u0000\"#\u0005 \u0000\u0000#\u0006\u0001\u0000\u0000\u0000$%\u0005n\u0000"+
		"\u0000%&\u0005o\u0000\u0000&\'\u0005n\u0000\u0000\'C\u0005e\u0000\u0000"+
		"()\u0005o\u0000\u0000)*\u0005n\u0000\u0000*+\u0005-\u0000\u0000+,\u0005"+
		"s\u0000\u0000,-\u0005u\u0000\u0000-.\u0005b\u0000\u0000./\u0005m\u0000"+
		"\u0000/0\u0005i\u0000\u000001\u0005s\u0000\u000012\u0005s\u0000\u0000"+
		"23\u0005i\u0000\u000034\u0005o\u0000\u00004C\u0005n\u0000\u000056\u0005"+
		"a\u0000\u000067\u0005f\u0000\u000078\u0005t\u0000\u000089\u0005e\u0000"+
		"\u00009:\u0005r\u0000\u0000:;\u0005-\u0000\u0000;<\u0005c\u0000\u0000"+
		"<=\u0005l\u0000\u0000=>\u0005o\u0000\u0000>?\u0005s\u0000\u0000?@\u0005"+
		"i\u0000\u0000@A\u0005n\u0000\u0000AC\u0005g\u0000\u0000B$\u0001\u0000"+
		"\u0000\u0000B(\u0001\u0000\u0000\u0000B5\u0001\u0000\u0000\u0000C\b\u0001"+
		"\u0000\u0000\u0000DE\u0005m\u0000\u0000EF\u0005a\u0000\u0000FG\u0005t"+
		"\u0000\u0000GH\u0005c\u0000\u0000HI\u0005h\u0000\u0000IJ\u0005i\u0000"+
		"\u0000JK\u0005n\u0000\u0000K\u0092\u0005g\u0000\u0000LM\u0005m\u0000\u0000"+
		"MN\u0005u\u0000\u0000NO\u0005l\u0000\u0000OP\u0005t\u0000\u0000PQ\u0005"+
		"i\u0000\u0000QR\u0005p\u0000\u0000RS\u0005l\u0000\u0000ST\u0005e\u0000"+
		"\u0000TU\u0005 \u0000\u0000UV\u0005c\u0000\u0000VW\u0005h\u0000\u0000"+
		"WX\u0005o\u0000\u0000XY\u0005i\u0000\u0000YZ\u0005c\u0000\u0000Z\u0092"+
		"\u0005e\u0000\u0000[\\\u0005s\u0000\u0000\\]\u0005h\u0000\u0000]^\u0005"+
		"o\u0000\u0000^_\u0005r\u0000\u0000_`\u0005t\u0000\u0000`a\u0005 \u0000"+
		"\u0000ab\u0005a\u0000\u0000bc\u0005n\u0000\u0000cd\u0005s\u0000\u0000"+
		"de\u0005w\u0000\u0000ef\u0005e\u0000\u0000f\u0092\u0005r\u0000\u0000g"+
		"h\u0005n\u0000\u0000hi\u0005u\u0000\u0000ij\u0005m\u0000\u0000jk\u0005"+
		"e\u0000\u0000kl\u0005r\u0000\u0000lm\u0005i\u0000\u0000mn\u0005c\u0000"+
		"\u0000no\u0005a\u0000\u0000o\u0092\u0005l\u0000\u0000pq\u0005s\u0000\u0000"+
		"qr\u0005e\u0000\u0000rs\u0005l\u0000\u0000st\u0005e\u0000\u0000tu\u0005"+
		"c\u0000\u0000uv\u0005t\u0000\u0000vw\u0005 \u0000\u0000wx\u0005m\u0000"+
		"\u0000xy\u0005i\u0000\u0000yz\u0005s\u0000\u0000z{\u0005s\u0000\u0000"+
		"{|\u0005i\u0000\u0000|}\u0005n\u0000\u0000}~\u0005g\u0000\u0000~\u007f"+
		"\u0005 \u0000\u0000\u007f\u0080\u0005w\u0000\u0000\u0080\u0081\u0005o"+
		"\u0000\u0000\u0081\u0082\u0005r\u0000\u0000\u0082\u0083\u0005d\u0000\u0000"+
		"\u0083\u0092\u0005s\u0000\u0000\u0084\u0085\u0005t\u0000\u0000\u0085\u0086"+
		"\u0005r\u0000\u0000\u0086\u0087\u0005u\u0000\u0000\u0087\u0088\u0005e"+
		"\u0000\u0000\u0088\u0089\u0005 \u0000\u0000\u0089\u008a\u0005o\u0000\u0000"+
		"\u008a\u008b\u0005r\u0000\u0000\u008b\u008c\u0005 \u0000\u0000\u008c\u008d"+
		"\u0005f\u0000\u0000\u008d\u008e\u0005a\u0000\u0000\u008e\u008f\u0005l"+
		"\u0000\u0000\u008f\u0090\u0005s\u0000\u0000\u0090\u0092\u0005e\u0000\u0000"+
		"\u0091D\u0001\u0000\u0000\u0000\u0091L\u0001\u0000\u0000\u0000\u0091["+
		"\u0001\u0000\u0000\u0000\u0091g\u0001\u0000\u0000\u0000\u0091p\u0001\u0000"+
		"\u0000\u0000\u0091\u0084\u0001\u0000\u0000\u0000\u0092\n\u0001\u0000\u0000"+
		"\u0000\u0093\u0095\u0007\u0000\u0000\u0000\u0094\u0093\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000"+
		"\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\f\u0001\u0000\u0000\u0000"+
		"\u0098\u009a\u0007\u0001\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\u0006\u0006\u0000\u0000\u009e\u000e\u0001\u0000\u0000\u0000"+
		"\u0005\u0000B\u0091\u0096\u009b\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}