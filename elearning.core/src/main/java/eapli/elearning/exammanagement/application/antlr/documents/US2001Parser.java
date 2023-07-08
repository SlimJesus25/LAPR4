// Generated from C:/Users/ricar/IdeaProjects/sem4pi-22-23-58/elearning.core/src/main/java/eapli/elearning/exammanagement/application/antlr\US2001.g4 by ANTLR 4.12.0
package eapli.elearning.exammanagement.application.antlr.documents;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class US2001Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		NUMBER=25, TEXT=26, WS=27;
	public static final int
		RULE_exam = 0, RULE_inicaldate = 1, RULE_finaldate = 2, RULE_title = 3, 
		RULE_header = 4, RULE_courseCode = 5, RULE_value = 6, RULE_section = 7, 
		RULE_question = 8, RULE_statement = 9, RULE_solution = 10, RULE_matchingsolution = 11, 
		RULE_multiplesolution = 12, RULE_shortsolution = 13, RULE_textsolution = 14, 
		RULE_feedback = 15, RULE_options = 16, RULE_questionType = 17, RULE_quotation = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"exam", "inicaldate", "finaldate", "title", "header", "courseCode", "value", 
			"section", "question", "statement", "solution", "matchingsolution", "multiplesolution", 
			"shortsolution", "textsolution", "feedback", "options", "questionType", 
			"quotation"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Exam Title:'", "'Exam Header:'", "'Course Code:'", "'InicialDate:'", 
			"'FinalDate:'", "'-'", "' '", "':'", "'Section:'", "'Question:'", "'?'", 
			"'Options:'", "'Solution:'", "'Type:'", "'Value:'", "'FeedBack:'", "'&'", 
			"'|'", "'MATCHING'", "'MULTIPLE_CHOICE'", "'SHORT_ANSWER'", "'NUMERICAL'", 
			"'MISSING_WORDS'", "'TRUE_OR_FALSE'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "NUMBER", "TEXT", "WS"
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
	public String getGrammarFileName() { return "US2001.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public US2001Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExamContext extends ParserRuleContext {
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public CourseCodeContext courseCode() {
			return getRuleContext(CourseCodeContext.class,0);
		}
		public InicaldateContext inicaldate() {
			return getRuleContext(InicaldateContext.class,0);
		}
		public FinaldateContext finaldate() {
			return getRuleContext(FinaldateContext.class,0);
		}
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public ExamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterExam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitExam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitExam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExamContext exam() throws RecognitionException {
		ExamContext _localctx = new ExamContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_exam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(T__0);
			setState(39);
			title();
			setState(40);
			match(T__1);
			setState(41);
			header();
			setState(42);
			match(T__2);
			setState(43);
			courseCode();
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44);
				section();
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__8 );
			setState(49);
			match(T__3);
			setState(50);
			inicaldate();
			setState(51);
			match(T__4);
			setState(52);
			finaldate();
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
	public static class InicaldateContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(US2001Parser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(US2001Parser.NUMBER, i);
		}
		public InicaldateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicaldate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterInicaldate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitInicaldate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitInicaldate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InicaldateContext inicaldate() throws RecognitionException {
		InicaldateContext _localctx = new InicaldateContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_inicaldate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(NUMBER);
			setState(55);
			match(T__5);
			setState(56);
			match(NUMBER);
			setState(57);
			match(T__5);
			setState(58);
			match(NUMBER);
			setState(59);
			match(T__6);
			setState(60);
			match(NUMBER);
			setState(61);
			match(T__7);
			setState(62);
			match(NUMBER);
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
	public static class FinaldateContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(US2001Parser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(US2001Parser.NUMBER, i);
		}
		public FinaldateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finaldate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterFinaldate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitFinaldate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitFinaldate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinaldateContext finaldate() throws RecognitionException {
		FinaldateContext _localctx = new FinaldateContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_finaldate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(NUMBER);
			setState(65);
			match(T__5);
			setState(66);
			match(NUMBER);
			setState(67);
			match(T__5);
			setState(68);
			match(NUMBER);
			setState(69);
			match(T__6);
			setState(70);
			match(NUMBER);
			setState(71);
			match(T__7);
			setState(72);
			match(NUMBER);
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
		public TerminalNode TEXT() { return getToken(US2001Parser.TEXT, 0); }
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitTitle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitTitle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(TEXT);
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
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(76);
				value();
				}
				}
				setState(79); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMBER || _la==TEXT );
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
	public static class CourseCodeContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public CourseCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_courseCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterCourseCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitCourseCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitCourseCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CourseCodeContext courseCode() throws RecognitionException {
		CourseCodeContext _localctx = new CourseCodeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_courseCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(81);
				value();
				}
				}
				setState(84); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMBER || _la==TEXT );
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
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(US2001Parser.TEXT, 0); }
		public TerminalNode NUMBER() { return getToken(US2001Parser.NUMBER, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==TEXT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__8);
			setState(89);
			value();
			setState(91); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(90);
				question();
				}
				}
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__9 );
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public SolutionContext solution() {
			return getRuleContext(SolutionContext.class,0);
		}
		public QuestionTypeContext questionType() {
			return getRuleContext(QuestionTypeContext.class,0);
		}
		public QuotationContext quotation() {
			return getRuleContext(QuotationContext.class,0);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public List<OptionsContext> options() {
			return getRuleContexts(OptionsContext.class);
		}
		public OptionsContext options(int i) {
			return getRuleContext(OptionsContext.class,i);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__9);
			setState(96);
			statement();
			setState(97);
			match(T__10);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(98);
				match(T__11);
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(99);
					options();
					}
					}
					setState(102); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMBER || _la==TEXT );
				}
			}

			setState(106);
			match(T__12);
			setState(107);
			solution();
			setState(108);
			match(T__13);
			setState(109);
			questionType();
			setState(110);
			match(T__14);
			setState(111);
			quotation();
			setState(112);
			match(T__15);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMBER || _la==TEXT) {
				{
				setState(113);
				feedback();
				}
			}

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
	public static class StatementContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(116);
				value();
				}
				}
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMBER || _la==TEXT );
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
	public static class SolutionContext extends ParserRuleContext {
		public List<MatchingsolutionContext> matchingsolution() {
			return getRuleContexts(MatchingsolutionContext.class);
		}
		public MatchingsolutionContext matchingsolution(int i) {
			return getRuleContext(MatchingsolutionContext.class,i);
		}
		public List<MultiplesolutionContext> multiplesolution() {
			return getRuleContexts(MultiplesolutionContext.class);
		}
		public MultiplesolutionContext multiplesolution(int i) {
			return getRuleContext(MultiplesolutionContext.class,i);
		}
		public List<ShortsolutionContext> shortsolution() {
			return getRuleContexts(ShortsolutionContext.class);
		}
		public ShortsolutionContext shortsolution(int i) {
			return getRuleContext(ShortsolutionContext.class,i);
		}
		public TextsolutionContext textsolution() {
			return getRuleContext(TextsolutionContext.class,0);
		}
		public SolutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterSolution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitSolution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitSolution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SolutionContext solution() throws RecognitionException {
		SolutionContext _localctx = new SolutionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_solution);
		int _la;
		try {
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(121);
					matchingsolution();
					}
					}
					setState(124); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(126);
					multiplesolution();
					}
					}
					setState(129); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMBER );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(132); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(131);
					shortsolution();
					}
					}
					setState(134); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NUMBER || _la==TEXT );
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(136);
				textsolution();
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
	public static class MatchingsolutionContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(US2001Parser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(US2001Parser.NUMBER, i);
		}
		public MatchingsolutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchingsolution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterMatchingsolution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitMatchingsolution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitMatchingsolution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchingsolutionContext matchingsolution() throws RecognitionException {
		MatchingsolutionContext _localctx = new MatchingsolutionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_matchingsolution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(NUMBER);
			setState(140);
			match(T__16);
			setState(141);
			match(NUMBER);
			setState(142);
			match(T__17);
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
	public static class MultiplesolutionContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(US2001Parser.NUMBER, 0); }
		public MultiplesolutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplesolution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterMultiplesolution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitMultiplesolution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitMultiplesolution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplesolutionContext multiplesolution() throws RecognitionException {
		MultiplesolutionContext _localctx = new MultiplesolutionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_multiplesolution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(NUMBER);
			setState(145);
			match(T__17);
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
	public static class ShortsolutionContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ShortsolutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shortsolution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterShortsolution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitShortsolution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitShortsolution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShortsolutionContext shortsolution() throws RecognitionException {
		ShortsolutionContext _localctx = new ShortsolutionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_shortsolution);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(147);
				value();
				}
				}
				setState(150); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMBER || _la==TEXT );
			setState(152);
			match(T__17);
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
	public static class TextsolutionContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TextsolutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textsolution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterTextsolution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitTextsolution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitTextsolution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextsolutionContext textsolution() throws RecognitionException {
		TextsolutionContext _localctx = new TextsolutionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_textsolution);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(154);
				value();
				}
				}
				setState(157); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMBER || _la==TEXT );
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
	public static class FeedbackContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public FeedbackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feedback; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterFeedback(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitFeedback(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitFeedback(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeedbackContext feedback() throws RecognitionException {
		FeedbackContext _localctx = new FeedbackContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_feedback);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(159);
				value();
				}
				}
				setState(162); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMBER || _la==TEXT );
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
	public static class OptionsContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public OptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_options; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionsContext options() throws RecognitionException {
		OptionsContext _localctx = new OptionsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_options);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(164);
				value();
				}
				}
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMBER || _la==TEXT );
			setState(169);
			match(T__17);
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
	public static class QuestionTypeContext extends ParserRuleContext {
		public QuestionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterQuestionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitQuestionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitQuestionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionTypeContext questionType() throws RecognitionException {
		QuestionTypeContext _localctx = new QuestionTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_questionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33030144L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
	public static class QuotationContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(US2001Parser.NUMBER, 0); }
		public QuotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).enterQuotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof US2001Listener ) ((US2001Listener)listener).exitQuotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof US2001Visitor ) return ((US2001Visitor<? extends T>)visitor).visitQuotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuotationContext quotation() throws RecognitionException {
		QuotationContext _localctx = new QuotationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_quotation);
		try {
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				match(T__6);
				setState(174);
				match(NUMBER);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				match(NUMBER);
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

	public static final String _serializedATN =
		"\u0004\u0001\u001b\u00b3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0004\u0000.\b\u0000\u000b\u0000\f\u0000/\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0004\u0004N\b\u0004\u000b\u0004"+
		"\f\u0004O\u0001\u0005\u0004\u0005S\b\u0005\u000b\u0005\f\u0005T\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007\\\b"+
		"\u0007\u000b\u0007\f\u0007]\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0004"+
		"\be\b\b\u000b\b\f\bf\u0003\bi\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\bs\b\b\u0001\t\u0004\tv\b\t\u000b\t\f"+
		"\tw\u0001\n\u0004\n{\b\n\u000b\n\f\n|\u0001\n\u0004\n\u0080\b\n\u000b"+
		"\n\f\n\u0081\u0001\n\u0004\n\u0085\b\n\u000b\n\f\n\u0086\u0001\n\u0003"+
		"\n\u008a\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\r\u0004\r\u0095\b\r\u000b\r\f\r\u0096\u0001"+
		"\r\u0001\r\u0001\u000e\u0004\u000e\u009c\b\u000e\u000b\u000e\f\u000e\u009d"+
		"\u0001\u000f\u0004\u000f\u00a1\b\u000f\u000b\u000f\f\u000f\u00a2\u0001"+
		"\u0010\u0004\u0010\u00a6\b\u0010\u000b\u0010\f\u0010\u00a7\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u00b1\b\u0012\u0001\u0012\u0000\u0000\u0013\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$\u0000\u0002\u0001\u0000\u0019\u001a\u0001\u0000\u0013\u0018\u00b2\u0000"+
		"&\u0001\u0000\u0000\u0000\u00026\u0001\u0000\u0000\u0000\u0004@\u0001"+
		"\u0000\u0000\u0000\u0006J\u0001\u0000\u0000\u0000\bM\u0001\u0000\u0000"+
		"\u0000\nR\u0001\u0000\u0000\u0000\fV\u0001\u0000\u0000\u0000\u000eX\u0001"+
		"\u0000\u0000\u0000\u0010_\u0001\u0000\u0000\u0000\u0012u\u0001\u0000\u0000"+
		"\u0000\u0014\u0089\u0001\u0000\u0000\u0000\u0016\u008b\u0001\u0000\u0000"+
		"\u0000\u0018\u0090\u0001\u0000\u0000\u0000\u001a\u0094\u0001\u0000\u0000"+
		"\u0000\u001c\u009b\u0001\u0000\u0000\u0000\u001e\u00a0\u0001\u0000\u0000"+
		"\u0000 \u00a5\u0001\u0000\u0000\u0000\"\u00ab\u0001\u0000\u0000\u0000"+
		"$\u00b0\u0001\u0000\u0000\u0000&\'\u0005\u0001\u0000\u0000\'(\u0003\u0006"+
		"\u0003\u0000()\u0005\u0002\u0000\u0000)*\u0003\b\u0004\u0000*+\u0005\u0003"+
		"\u0000\u0000+-\u0003\n\u0005\u0000,.\u0003\u000e\u0007\u0000-,\u0001\u0000"+
		"\u0000\u0000./\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000/0\u0001"+
		"\u0000\u0000\u000001\u0001\u0000\u0000\u000012\u0005\u0004\u0000\u0000"+
		"23\u0003\u0002\u0001\u000034\u0005\u0005\u0000\u000045\u0003\u0004\u0002"+
		"\u00005\u0001\u0001\u0000\u0000\u000067\u0005\u0019\u0000\u000078\u0005"+
		"\u0006\u0000\u000089\u0005\u0019\u0000\u00009:\u0005\u0006\u0000\u0000"+
		":;\u0005\u0019\u0000\u0000;<\u0005\u0007\u0000\u0000<=\u0005\u0019\u0000"+
		"\u0000=>\u0005\b\u0000\u0000>?\u0005\u0019\u0000\u0000?\u0003\u0001\u0000"+
		"\u0000\u0000@A\u0005\u0019\u0000\u0000AB\u0005\u0006\u0000\u0000BC\u0005"+
		"\u0019\u0000\u0000CD\u0005\u0006\u0000\u0000DE\u0005\u0019\u0000\u0000"+
		"EF\u0005\u0007\u0000\u0000FG\u0005\u0019\u0000\u0000GH\u0005\b\u0000\u0000"+
		"HI\u0005\u0019\u0000\u0000I\u0005\u0001\u0000\u0000\u0000JK\u0005\u001a"+
		"\u0000\u0000K\u0007\u0001\u0000\u0000\u0000LN\u0003\f\u0006\u0000ML\u0001"+
		"\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000"+
		"OP\u0001\u0000\u0000\u0000P\t\u0001\u0000\u0000\u0000QS\u0003\f\u0006"+
		"\u0000RQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TR\u0001\u0000"+
		"\u0000\u0000TU\u0001\u0000\u0000\u0000U\u000b\u0001\u0000\u0000\u0000"+
		"VW\u0007\u0000\u0000\u0000W\r\u0001\u0000\u0000\u0000XY\u0005\t\u0000"+
		"\u0000Y[\u0003\f\u0006\u0000Z\\\u0003\u0010\b\u0000[Z\u0001\u0000\u0000"+
		"\u0000\\]\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000"+
		"\u0000\u0000^\u000f\u0001\u0000\u0000\u0000_`\u0005\n\u0000\u0000`a\u0003"+
		"\u0012\t\u0000ah\u0005\u000b\u0000\u0000bd\u0005\f\u0000\u0000ce\u0003"+
		" \u0010\u0000dc\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fd\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gi\u0001\u0000\u0000\u0000"+
		"hb\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000"+
		"\u0000jk\u0005\r\u0000\u0000kl\u0003\u0014\n\u0000lm\u0005\u000e\u0000"+
		"\u0000mn\u0003\"\u0011\u0000no\u0005\u000f\u0000\u0000op\u0003$\u0012"+
		"\u0000pr\u0005\u0010\u0000\u0000qs\u0003\u001e\u000f\u0000rq\u0001\u0000"+
		"\u0000\u0000rs\u0001\u0000\u0000\u0000s\u0011\u0001\u0000\u0000\u0000"+
		"tv\u0003\f\u0006\u0000ut\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000x\u0013\u0001\u0000"+
		"\u0000\u0000y{\u0003\u0016\u000b\u0000zy\u0001\u0000\u0000\u0000{|\u0001"+
		"\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000"+
		"}\u008a\u0001\u0000\u0000\u0000~\u0080\u0003\u0018\f\u0000\u007f~\u0001"+
		"\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u007f\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u008a\u0001"+
		"\u0000\u0000\u0000\u0083\u0085\u0003\u001a\r\u0000\u0084\u0083\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u008a\u0001\u0000"+
		"\u0000\u0000\u0088\u008a\u0003\u001c\u000e\u0000\u0089z\u0001\u0000\u0000"+
		"\u0000\u0089\u007f\u0001\u0000\u0000\u0000\u0089\u0084\u0001\u0000\u0000"+
		"\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a\u0015\u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0005\u0019\u0000\u0000\u008c\u008d\u0005\u0011\u0000"+
		"\u0000\u008d\u008e\u0005\u0019\u0000\u0000\u008e\u008f\u0005\u0012\u0000"+
		"\u0000\u008f\u0017\u0001\u0000\u0000\u0000\u0090\u0091\u0005\u0019\u0000"+
		"\u0000\u0091\u0092\u0005\u0012\u0000\u0000\u0092\u0019\u0001\u0000\u0000"+
		"\u0000\u0093\u0095\u0003\f\u0006\u0000\u0094\u0093\u0001\u0000\u0000\u0000"+
		"\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0005\u0012\u0000\u0000\u0099\u001b\u0001\u0000\u0000\u0000"+
		"\u009a\u009c\u0003\f\u0006\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009c"+
		"\u009d\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d"+
		"\u009e\u0001\u0000\u0000\u0000\u009e\u001d\u0001\u0000\u0000\u0000\u009f"+
		"\u00a1\u0003\f\u0006\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3"+
		"\u0001\u0000\u0000\u0000\u00a3\u001f\u0001\u0000\u0000\u0000\u00a4\u00a6"+
		"\u0003\f\u0006\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005"+
		"\u0012\u0000\u0000\u00aa!\u0001\u0000\u0000\u0000\u00ab\u00ac\u0007\u0001"+
		"\u0000\u0000\u00ac#\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u0007\u0000"+
		"\u0000\u00ae\u00b1\u0005\u0019\u0000\u0000\u00af\u00b1\u0005\u0019\u0000"+
		"\u0000\u00b0\u00ad\u0001\u0000\u0000\u0000\u00b0\u00af\u0001\u0000\u0000"+
		"\u0000\u00b1%\u0001\u0000\u0000\u0000\u0011/OT]fhrw|\u0081\u0086\u0089"+
		"\u0096\u009d\u00a2\u00a7\u00b0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}