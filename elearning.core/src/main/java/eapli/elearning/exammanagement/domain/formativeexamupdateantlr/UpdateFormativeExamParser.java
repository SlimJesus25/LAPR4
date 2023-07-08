// Generated from D:/ISEP/teste/elearning.core/src/main/java/eapli/elearning/exammanagement/domain/formativeexamupdateantlr\UpdateFormativeExam.g4 by ANTLR 4.12.0
package eapli.elearning.exammanagement.domain.formativeexamupdateantlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class UpdateFormativeExamParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, FEEDBACK=2, GRADE=3, FEEDBACK_GRADE_TYPE=4, QUESTION_TYPE=5, TEXT=6, 
		WS=7;
	public static final int
		RULE_start = 0, RULE_title = 1, RULE_header = 2, RULE_header_feedback_grade = 3, 
		RULE_section = 4, RULE_question = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "title", "header", "header_feedback_grade", "section", "question"
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

	@Override
	public String getGrammarFileName() { return "UpdateFormativeExam.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public UpdateFormativeExamParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateFormativeExamListener ) ((UpdateFormativeExamListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateFormativeExamListener ) ((UpdateFormativeExamListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateFormativeExamVisitor ) return ((UpdateFormativeExamVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			setState(20);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__0:
			case TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(13);
				title();
				setState(14);
				match(T__0);
				setState(16); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(15);
					section();
					}
					}
					setState(18); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUESTION_TYPE || _la==TEXT );
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

	@SuppressWarnings("CheckReturnValue")
	public static class TitleContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(UpdateFormativeExamParser.TEXT, 0); }
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateFormativeExamListener ) ((UpdateFormativeExamListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateFormativeExamListener ) ((UpdateFormativeExamListener)listener).exitTitle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateFormativeExamVisitor ) return ((UpdateFormativeExamVisitor<? extends T>)visitor).visitTitle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_title);
		try {
			setState(24);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				match(TEXT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class HeaderContext extends ParserRuleContext {
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
	 
		public HeaderContext() { }
		public void copyFrom(HeaderContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HeaderfgNoTextContext extends HeaderContext {
		public Header_feedback_gradeContext header_feedback_grade() {
			return getRuleContext(Header_feedback_gradeContext.class,0);
		}
		public HeaderfgNoTextContext(HeaderContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateFormativeExamListener ) ((UpdateFormativeExamListener)listener).enterHeaderfgNoText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateFormativeExamListener ) ((UpdateFormativeExamListener)listener).exitHeaderfgNoText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateFormativeExamVisitor ) return ((UpdateFormativeExamVisitor<? extends T>)visitor).visitHeaderfgNoText(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HeaderfgContext extends HeaderContext {
		public Header_feedback_gradeContext header_feedback_grade() {
			return getRuleContext(Header_feedback_gradeContext.class,0);
		}
		public TerminalNode TEXT() { return getToken(UpdateFormativeExamParser.TEXT, 0); }
		public HeaderfgContext(HeaderContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateFormativeExamListener ) ((UpdateFormativeExamListener)listener).enterHeaderfg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateFormativeExamListener ) ((UpdateFormativeExamListener)listener).exitHeaderfg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateFormativeExamVisitor ) return ((UpdateFormativeExamVisitor<? extends T>)visitor).visitHeaderfg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_header);
		try {
			setState(30);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new HeaderfgNoTextContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				header_feedback_grade();
				}
				break;
			case 2:
				_localctx = new HeaderfgContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				header_feedback_grade();
				setState(28);
				match(TEXT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Header_feedback_gradeContext extends ParserRuleContext {
		public Token left;
		public Token rigth;
		public TerminalNode FEEDBACK() { return getToken(UpdateFormativeExamParser.FEEDBACK, 0); }
		public TerminalNode GRADE() { return getToken(UpdateFormativeExamParser.GRADE, 0); }
		public List<TerminalNode> FEEDBACK_GRADE_TYPE() { return getTokens(UpdateFormativeExamParser.FEEDBACK_GRADE_TYPE); }
		public TerminalNode FEEDBACK_GRADE_TYPE(int i) {
			return getToken(UpdateFormativeExamParser.FEEDBACK_GRADE_TYPE, i);
		}
		public Header_feedback_gradeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header_feedback_grade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateFormativeExamListener ) ((UpdateFormativeExamListener)listener).enterHeader_feedback_grade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateFormativeExamListener ) ((UpdateFormativeExamListener)listener).exitHeader_feedback_grade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateFormativeExamVisitor ) return ((UpdateFormativeExamVisitor<? extends T>)visitor).visitHeader_feedback_grade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Header_feedback_gradeContext header_feedback_grade() throws RecognitionException {
		Header_feedback_gradeContext _localctx = new Header_feedback_gradeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_header_feedback_grade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(FEEDBACK);
			setState(33);
			((Header_feedback_gradeContext)_localctx).left = match(FEEDBACK_GRADE_TYPE);
			setState(34);
			match(T__0);
			setState(35);
			match(GRADE);
			setState(36);
			((Header_feedback_gradeContext)_localctx).rigth = match(FEEDBACK_GRADE_TYPE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SectionContext extends ParserRuleContext {
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
	 
		public SectionContext() { }
		public void copyFrom(SectionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SectionTextContext extends SectionContext {
		public TerminalNode TEXT() { return getToken(UpdateFormativeExamParser.TEXT, 0); }
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public SectionTextContext(SectionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateFormativeExamListener ) ((UpdateFormativeExamListener)listener).enterSectionText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateFormativeExamListener ) ((UpdateFormativeExamListener)listener).exitSectionText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateFormativeExamVisitor ) return ((UpdateFormativeExamVisitor<? extends T>)visitor).visitSectionText(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SectionNoTextContext extends SectionContext {
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public SectionNoTextContext(SectionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateFormativeExamListener ) ((UpdateFormativeExamListener)listener).enterSectionNoText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateFormativeExamListener ) ((UpdateFormativeExamListener)listener).exitSectionNoText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateFormativeExamVisitor ) return ((UpdateFormativeExamVisitor<? extends T>)visitor).visitSectionNoText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_section);
		try {
			int _alt;
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXT:
				_localctx = new SectionTextContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				match(TEXT);
				setState(39);
				match(T__0);
				setState(41); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(40);
						question();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(43); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case QUESTION_TYPE:
				_localctx = new SectionNoTextContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(46); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(45);
						question();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(48); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	@SuppressWarnings("CheckReturnValue")
	public static class QuestionContext extends ParserRuleContext {
		public TerminalNode QUESTION_TYPE() { return getToken(UpdateFormativeExamParser.QUESTION_TYPE, 0); }
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateFormativeExamListener ) ((UpdateFormativeExamListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UpdateFormativeExamListener ) ((UpdateFormativeExamListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UpdateFormativeExamVisitor ) return ((UpdateFormativeExamVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(QUESTION_TYPE);
			setState(53);
			match(T__0);
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

	public static final String _serializedATN =
		"\u0004\u0001\u00078\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004"+
		"\u0000\u0011\b\u0000\u000b\u0000\f\u0000\u0012\u0003\u0000\u0015\b\u0000"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\u0019\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002\u001f\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0004\u0004*\b\u0004\u000b\u0004\f\u0004+\u0001\u0004\u0004"+
		"\u0004/\b\u0004\u000b\u0004\f\u00040\u0003\u00043\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0000\u0000\u0006\u0000\u0002\u0004"+
		"\u0006\b\n\u0000\u00008\u0000\u0014\u0001\u0000\u0000\u0000\u0002\u0018"+
		"\u0001\u0000\u0000\u0000\u0004\u001e\u0001\u0000\u0000\u0000\u0006 \u0001"+
		"\u0000\u0000\u0000\b2\u0001\u0000\u0000\u0000\n4\u0001\u0000\u0000\u0000"+
		"\f\u0015\u0001\u0000\u0000\u0000\r\u000e\u0003\u0002\u0001\u0000\u000e"+
		"\u0010\u0005\u0001\u0000\u0000\u000f\u0011\u0003\b\u0004\u0000\u0010\u000f"+
		"\u0001\u0000\u0000\u0000\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0010"+
		"\u0001\u0000\u0000\u0000\u0012\u0013\u0001\u0000\u0000\u0000\u0013\u0015"+
		"\u0001\u0000\u0000\u0000\u0014\f\u0001\u0000\u0000\u0000\u0014\r\u0001"+
		"\u0000\u0000\u0000\u0015\u0001\u0001\u0000\u0000\u0000\u0016\u0019\u0001"+
		"\u0000\u0000\u0000\u0017\u0019\u0005\u0006\u0000\u0000\u0018\u0016\u0001"+
		"\u0000\u0000\u0000\u0018\u0017\u0001\u0000\u0000\u0000\u0019\u0003\u0001"+
		"\u0000\u0000\u0000\u001a\u001f\u0003\u0006\u0003\u0000\u001b\u001c\u0003"+
		"\u0006\u0003\u0000\u001c\u001d\u0005\u0006\u0000\u0000\u001d\u001f\u0001"+
		"\u0000\u0000\u0000\u001e\u001a\u0001\u0000\u0000\u0000\u001e\u001b\u0001"+
		"\u0000\u0000\u0000\u001f\u0005\u0001\u0000\u0000\u0000 !\u0005\u0002\u0000"+
		"\u0000!\"\u0005\u0004\u0000\u0000\"#\u0005\u0001\u0000\u0000#$\u0005\u0003"+
		"\u0000\u0000$%\u0005\u0004\u0000\u0000%\u0007\u0001\u0000\u0000\u0000"+
		"&\'\u0005\u0006\u0000\u0000\')\u0005\u0001\u0000\u0000(*\u0003\n\u0005"+
		"\u0000)(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+)\u0001\u0000"+
		"\u0000\u0000+,\u0001\u0000\u0000\u0000,3\u0001\u0000\u0000\u0000-/\u0003"+
		"\n\u0005\u0000.-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u00000.\u0001"+
		"\u0000\u0000\u000001\u0001\u0000\u0000\u000013\u0001\u0000\u0000\u0000"+
		"2&\u0001\u0000\u0000\u00002.\u0001\u0000\u0000\u00003\t\u0001\u0000\u0000"+
		"\u000045\u0005\u0005\u0000\u000056\u0005\u0001\u0000\u00006\u000b\u0001"+
		"\u0000\u0000\u0000\u0007\u0012\u0014\u0018\u001e+02";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}