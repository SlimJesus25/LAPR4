// Generated from C:/Users/ricar/IdeaProjects/sem4pi-22-23-58/elearning.core/src/main/java/eapli/elearning/automaticformativeexammanagement/application/antlr\Question.g4 by ANTLR 4.12.0
package eapli.elearning.automaticformativeexammanagement.application.antlr.documents;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class QuestionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, INT=21, FLOAT=22, WORD=23, WS=24;
	public static final int
		RULE_question = 0, RULE_matchingQuestion = 1, RULE_matchingquestionType = 2, 
		RULE_matchingalinea = 3, RULE_matchingsolution = 4, RULE_matchingcotacao = 5, 
		RULE_matchingquestionText = 6, RULE_matchingtext = 7, RULE_matchingnumber = 8, 
		RULE_multipleChoiceQuestion = 9, RULE_multiplequestionType = 10, RULE_multiplealinea = 11, 
		RULE_multiplesolution = 12, RULE_multiplecotacao = 13, RULE_multiplequestionText = 14, 
		RULE_multipletext = 15, RULE_multiplenumber = 16, RULE_selectMissingWordsQuestion = 17, 
		RULE_missingquestionType = 18, RULE_missingalinea = 19, RULE_missingsolution = 20, 
		RULE_missingcotacao = 21, RULE_missingquestion = 22, RULE_feedback = 23, 
		RULE_missingquestionText = 24, RULE_missingnumber = 25, RULE_trueFalseQuestion = 26, 
		RULE_tfquestionType = 27, RULE_tfsolution = 28, RULE_truefalseOptions = 29, 
		RULE_tfcotacao = 30, RULE_tfquestionText = 31, RULE_tfnumber = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"question", "matchingQuestion", "matchingquestionType", "matchingalinea", 
			"matchingsolution", "matchingcotacao", "matchingquestionText", "matchingtext", 
			"matchingnumber", "multipleChoiceQuestion", "multiplequestionType", "multiplealinea", 
			"multiplesolution", "multiplecotacao", "multiplequestionText", "multipletext", 
			"multiplenumber", "selectMissingWordsQuestion", "missingquestionType", 
			"missingalinea", "missingsolution", "missingcotacao", "missingquestion", 
			"feedback", "missingquestionText", "missingnumber", "trueFalseQuestion", 
			"tfquestionType", "tfsolution", "truefalseOptions", "tfcotacao", "tfquestionText", 
			"tfnumber"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'-'", "'MATCHING'", "'OP:'", "'RES:'", "'&'", "'Cotacao:'", "';'", 
			"'MULTIPLE_CHOICE'", "'MISSING_WORDS'", "'TRUE_OR_FALSE'", "'true'", 
			"'True'", "'TRUE'", "'false'", "'False'", "'FALSE'", "'T'", "'t'", "'F'", 
			"'f'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "INT", "FLOAT", 
			"WORD", "WS"
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
	public String getGrammarFileName() { return "Question.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QuestionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuestionContext extends ParserRuleContext {
		public MultipleChoiceQuestionContext multipleChoiceQuestion() {
			return getRuleContext(MultipleChoiceQuestionContext.class,0);
		}
		public MatchingQuestionContext matchingQuestion() {
			return getRuleContext(MatchingQuestionContext.class,0);
		}
		public SelectMissingWordsQuestionContext selectMissingWordsQuestion() {
			return getRuleContext(SelectMissingWordsQuestionContext.class,0);
		}
		public TrueFalseQuestionContext trueFalseQuestion() {
			return getRuleContext(TrueFalseQuestionContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_question);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				multipleChoiceQuestion();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				matchingQuestion();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				selectMissingWordsQuestion();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				trueFalseQuestion();
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
	public static class MatchingQuestionContext extends ParserRuleContext {
		public MatchingquestionTypeContext matchingquestionType() {
			return getRuleContext(MatchingquestionTypeContext.class,0);
		}
		public MatchingcotacaoContext matchingcotacao() {
			return getRuleContext(MatchingcotacaoContext.class,0);
		}
		public List<MatchingquestionTextContext> matchingquestionText() {
			return getRuleContexts(MatchingquestionTextContext.class);
		}
		public MatchingquestionTextContext matchingquestionText(int i) {
			return getRuleContext(MatchingquestionTextContext.class,i);
		}
		public List<MatchingalineaContext> matchingalinea() {
			return getRuleContexts(MatchingalineaContext.class);
		}
		public MatchingalineaContext matchingalinea(int i) {
			return getRuleContext(MatchingalineaContext.class,i);
		}
		public List<MatchingsolutionContext> matchingsolution() {
			return getRuleContexts(MatchingsolutionContext.class);
		}
		public MatchingsolutionContext matchingsolution(int i) {
			return getRuleContext(MatchingsolutionContext.class,i);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public MatchingQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchingQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMatchingQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMatchingQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMatchingQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchingQuestionContext matchingQuestion() throws RecognitionException {
		MatchingQuestionContext _localctx = new MatchingQuestionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_matchingQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			matchingquestionType();
			setState(73);
			match(T__0);
			setState(75); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(74);
				matchingquestionText();
				}
				}
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD );
			setState(80); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79);
				matchingalinea();
				}
				}
				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			setState(85); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(84);
				matchingsolution();
				}
				}
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
			setState(89);
			match(T__0);
			setState(90);
			matchingcotacao();
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WORD) {
				{
				setState(91);
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
	public static class MatchingquestionTypeContext extends ParserRuleContext {
		public MatchingquestionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchingquestionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMatchingquestionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMatchingquestionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMatchingquestionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchingquestionTypeContext matchingquestionType() throws RecognitionException {
		MatchingquestionTypeContext _localctx = new MatchingquestionTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_matchingquestionType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__1);
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
	public static class MatchingalineaContext extends ParserRuleContext {
		public List<MatchingtextContext> matchingtext() {
			return getRuleContexts(MatchingtextContext.class);
		}
		public MatchingtextContext matchingtext(int i) {
			return getRuleContext(MatchingtextContext.class,i);
		}
		public MatchingalineaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchingalinea; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMatchingalinea(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMatchingalinea(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMatchingalinea(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchingalineaContext matchingalinea() throws RecognitionException {
		MatchingalineaContext _localctx = new MatchingalineaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_matchingalinea);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__2);
			setState(98); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(97);
				matchingtext();
				}
				}
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD );
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
		public List<MatchingnumberContext> matchingnumber() {
			return getRuleContexts(MatchingnumberContext.class);
		}
		public MatchingnumberContext matchingnumber(int i) {
			return getRuleContext(MatchingnumberContext.class,i);
		}
		public MatchingsolutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchingsolution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMatchingsolution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMatchingsolution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMatchingsolution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchingsolutionContext matchingsolution() throws RecognitionException {
		MatchingsolutionContext _localctx = new MatchingsolutionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_matchingsolution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__3);
			setState(103);
			matchingnumber();
			setState(104);
			match(T__4);
			setState(105);
			matchingnumber();
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
	public static class MatchingcotacaoContext extends ParserRuleContext {
		public MatchingnumberContext matchingnumber() {
			return getRuleContext(MatchingnumberContext.class,0);
		}
		public MatchingcotacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchingcotacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMatchingcotacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMatchingcotacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMatchingcotacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchingcotacaoContext matchingcotacao() throws RecognitionException {
		MatchingcotacaoContext _localctx = new MatchingcotacaoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_matchingcotacao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__5);
			setState(108);
			matchingnumber();
			setState(109);
			match(T__6);
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
	public static class MatchingquestionTextContext extends ParserRuleContext {
		public MatchingtextContext matchingtext() {
			return getRuleContext(MatchingtextContext.class,0);
		}
		public MatchingquestionTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchingquestionText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMatchingquestionText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMatchingquestionText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMatchingquestionText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchingquestionTextContext matchingquestionText() throws RecognitionException {
		MatchingquestionTextContext _localctx = new MatchingquestionTextContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_matchingquestionText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			matchingtext();
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
	public static class MatchingtextContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(QuestionParser.WORD, 0); }
		public MatchingtextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchingtext; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMatchingtext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMatchingtext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMatchingtext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchingtextContext matchingtext() throws RecognitionException {
		MatchingtextContext _localctx = new MatchingtextContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_matchingtext);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(WORD);
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
	public static class MatchingnumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(QuestionParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(QuestionParser.FLOAT, 0); }
		public MatchingnumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchingnumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMatchingnumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMatchingnumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMatchingnumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchingnumberContext matchingnumber() throws RecognitionException {
		MatchingnumberContext _localctx = new MatchingnumberContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_matchingnumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
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
	public static class MultipleChoiceQuestionContext extends ParserRuleContext {
		public MultiplequestionTypeContext multiplequestionType() {
			return getRuleContext(MultiplequestionTypeContext.class,0);
		}
		public MultiplecotacaoContext multiplecotacao() {
			return getRuleContext(MultiplecotacaoContext.class,0);
		}
		public List<MultiplequestionTextContext> multiplequestionText() {
			return getRuleContexts(MultiplequestionTextContext.class);
		}
		public MultiplequestionTextContext multiplequestionText(int i) {
			return getRuleContext(MultiplequestionTextContext.class,i);
		}
		public List<MultiplealineaContext> multiplealinea() {
			return getRuleContexts(MultiplealineaContext.class);
		}
		public MultiplealineaContext multiplealinea(int i) {
			return getRuleContext(MultiplealineaContext.class,i);
		}
		public List<MultiplesolutionContext> multiplesolution() {
			return getRuleContexts(MultiplesolutionContext.class);
		}
		public MultiplesolutionContext multiplesolution(int i) {
			return getRuleContext(MultiplesolutionContext.class,i);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public MultipleChoiceQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleChoiceQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMultipleChoiceQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMultipleChoiceQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMultipleChoiceQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleChoiceQuestionContext multipleChoiceQuestion() throws RecognitionException {
		MultipleChoiceQuestionContext _localctx = new MultipleChoiceQuestionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_multipleChoiceQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			multiplequestionType();
			setState(118);
			match(T__0);
			setState(120); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(119);
				multiplequestionText();
				}
				}
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 14680064L) != 0) );
			setState(125); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(124);
				multiplealinea();
				}
				}
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			setState(130); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(129);
				multiplesolution();
				}
				}
				setState(132); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
			setState(134);
			match(T__0);
			setState(135);
			multiplecotacao();
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WORD) {
				{
				setState(136);
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
	public static class MultiplequestionTypeContext extends ParserRuleContext {
		public MultiplequestionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplequestionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMultiplequestionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMultiplequestionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMultiplequestionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplequestionTypeContext multiplequestionType() throws RecognitionException {
		MultiplequestionTypeContext _localctx = new MultiplequestionTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_multiplequestionType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(T__7);
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
	public static class MultiplealineaContext extends ParserRuleContext {
		public List<MultipletextContext> multipletext() {
			return getRuleContexts(MultipletextContext.class);
		}
		public MultipletextContext multipletext(int i) {
			return getRuleContext(MultipletextContext.class,i);
		}
		public MultiplealineaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplealinea; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMultiplealinea(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMultiplealinea(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMultiplealinea(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplealineaContext multiplealinea() throws RecognitionException {
		MultiplealineaContext _localctx = new MultiplealineaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_multiplealinea);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__2);
			setState(143); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(142);
				multipletext();
				}
				}
				setState(145); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD );
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
		public MultiplenumberContext multiplenumber() {
			return getRuleContext(MultiplenumberContext.class,0);
		}
		public MultiplesolutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplesolution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMultiplesolution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMultiplesolution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMultiplesolution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplesolutionContext multiplesolution() throws RecognitionException {
		MultiplesolutionContext _localctx = new MultiplesolutionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_multiplesolution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__3);
			setState(148);
			multiplenumber();
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
	public static class MultiplecotacaoContext extends ParserRuleContext {
		public MultiplenumberContext multiplenumber() {
			return getRuleContext(MultiplenumberContext.class,0);
		}
		public MultiplecotacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplecotacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMultiplecotacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMultiplecotacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMultiplecotacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplecotacaoContext multiplecotacao() throws RecognitionException {
		MultiplecotacaoContext _localctx = new MultiplecotacaoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_multiplecotacao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__5);
			setState(151);
			multiplenumber();
			setState(152);
			match(T__6);
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
	public static class MultiplequestionTextContext extends ParserRuleContext {
		public MultipletextContext multipletext() {
			return getRuleContext(MultipletextContext.class,0);
		}
		public List<MultiplenumberContext> multiplenumber() {
			return getRuleContexts(MultiplenumberContext.class);
		}
		public MultiplenumberContext multiplenumber(int i) {
			return getRuleContext(MultiplenumberContext.class,i);
		}
		public MultiplequestionTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplequestionText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMultiplequestionText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMultiplequestionText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMultiplequestionText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplequestionTextContext multiplequestionText() throws RecognitionException {
		MultiplequestionTextContext _localctx = new MultiplequestionTextContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_multiplequestionText);
		try {
			int _alt;
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				multipletext();
				}
				break;
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(156); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(155);
						multiplenumber();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(158); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
	public static class MultipletextContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(QuestionParser.WORD, 0); }
		public MultipletextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipletext; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMultipletext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMultipletext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMultipletext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipletextContext multipletext() throws RecognitionException {
		MultipletextContext _localctx = new MultipletextContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_multipletext);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(WORD);
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
	public static class MultiplenumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(QuestionParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(QuestionParser.FLOAT, 0); }
		public MultiplenumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplenumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMultiplenumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMultiplenumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMultiplenumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplenumberContext multiplenumber() throws RecognitionException {
		MultiplenumberContext _localctx = new MultiplenumberContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_multiplenumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
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
	public static class SelectMissingWordsQuestionContext extends ParserRuleContext {
		public MissingquestionTypeContext missingquestionType() {
			return getRuleContext(MissingquestionTypeContext.class,0);
		}
		public MissingcotacaoContext missingcotacao() {
			return getRuleContext(MissingcotacaoContext.class,0);
		}
		public List<MissingquestionContext> missingquestion() {
			return getRuleContexts(MissingquestionContext.class);
		}
		public MissingquestionContext missingquestion(int i) {
			return getRuleContext(MissingquestionContext.class,i);
		}
		public List<MissingalineaContext> missingalinea() {
			return getRuleContexts(MissingalineaContext.class);
		}
		public MissingalineaContext missingalinea(int i) {
			return getRuleContext(MissingalineaContext.class,i);
		}
		public List<MissingsolutionContext> missingsolution() {
			return getRuleContexts(MissingsolutionContext.class);
		}
		public MissingsolutionContext missingsolution(int i) {
			return getRuleContext(MissingsolutionContext.class,i);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public SelectMissingWordsQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectMissingWordsQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterSelectMissingWordsQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitSelectMissingWordsQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitSelectMissingWordsQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectMissingWordsQuestionContext selectMissingWordsQuestion() throws RecognitionException {
		SelectMissingWordsQuestionContext _localctx = new SelectMissingWordsQuestionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_selectMissingWordsQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			missingquestionType();
			setState(167);
			match(T__0);
			setState(169); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(168);
				missingquestion();
				}
				}
				setState(171); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD );
			setState(174); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(173);
				missingalinea();
				}
				}
				setState(176); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			setState(179); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(178);
				missingsolution();
				}
				}
				setState(181); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
			setState(183);
			match(T__0);
			setState(184);
			missingcotacao();
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WORD) {
				{
				setState(185);
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
	public static class MissingquestionTypeContext extends ParserRuleContext {
		public MissingquestionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missingquestionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMissingquestionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMissingquestionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMissingquestionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MissingquestionTypeContext missingquestionType() throws RecognitionException {
		MissingquestionTypeContext _localctx = new MissingquestionTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_missingquestionType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__8);
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
	public static class MissingalineaContext extends ParserRuleContext {
		public MissingquestionTextContext missingquestionText() {
			return getRuleContext(MissingquestionTextContext.class,0);
		}
		public MissingalineaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missingalinea; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMissingalinea(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMissingalinea(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMissingalinea(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MissingalineaContext missingalinea() throws RecognitionException {
		MissingalineaContext _localctx = new MissingalineaContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_missingalinea);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(T__2);
			setState(191);
			missingquestionText();
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
	public static class MissingsolutionContext extends ParserRuleContext {
		public MissingquestionTextContext missingquestionText() {
			return getRuleContext(MissingquestionTextContext.class,0);
		}
		public MissingsolutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missingsolution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMissingsolution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMissingsolution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMissingsolution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MissingsolutionContext missingsolution() throws RecognitionException {
		MissingsolutionContext _localctx = new MissingsolutionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_missingsolution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(T__3);
			setState(194);
			missingquestionText();
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
	public static class MissingcotacaoContext extends ParserRuleContext {
		public MissingnumberContext missingnumber() {
			return getRuleContext(MissingnumberContext.class,0);
		}
		public MissingcotacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missingcotacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMissingcotacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMissingcotacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMissingcotacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MissingcotacaoContext missingcotacao() throws RecognitionException {
		MissingcotacaoContext _localctx = new MissingcotacaoContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_missingcotacao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(T__5);
			setState(197);
			missingnumber();
			setState(198);
			match(T__6);
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
	public static class MissingquestionContext extends ParserRuleContext {
		public MissingquestionTextContext missingquestionText() {
			return getRuleContext(MissingquestionTextContext.class,0);
		}
		public MissingquestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missingquestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMissingquestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMissingquestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMissingquestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MissingquestionContext missingquestion() throws RecognitionException {
		MissingquestionContext _localctx = new MissingquestionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_missingquestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			missingquestionText();
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
		public List<TerminalNode> WORD() { return getTokens(QuestionParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(QuestionParser.WORD, i);
		}
		public FeedbackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feedback; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterFeedback(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitFeedback(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitFeedback(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeedbackContext feedback() throws RecognitionException {
		FeedbackContext _localctx = new FeedbackContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_feedback);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(202);
				match(WORD);
				}
				}
				setState(205); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD );
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
	public static class MissingquestionTextContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(QuestionParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(QuestionParser.WORD, i);
		}
		public MissingquestionTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missingquestionText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMissingquestionText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMissingquestionText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMissingquestionText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MissingquestionTextContext missingquestionText() throws RecognitionException {
		MissingquestionTextContext _localctx = new MissingquestionTextContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_missingquestionText);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(208); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(207);
					match(WORD);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(210); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
	public static class MissingnumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(QuestionParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(QuestionParser.FLOAT, 0); }
		public MissingnumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missingnumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterMissingnumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitMissingnumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitMissingnumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MissingnumberContext missingnumber() throws RecognitionException {
		MissingnumberContext _localctx = new MissingnumberContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_missingnumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
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
	public static class TrueFalseQuestionContext extends ParserRuleContext {
		public TfquestionTypeContext tfquestionType() {
			return getRuleContext(TfquestionTypeContext.class,0);
		}
		public TfsolutionContext tfsolution() {
			return getRuleContext(TfsolutionContext.class,0);
		}
		public TfcotacaoContext tfcotacao() {
			return getRuleContext(TfcotacaoContext.class,0);
		}
		public List<TfquestionTextContext> tfquestionText() {
			return getRuleContexts(TfquestionTextContext.class);
		}
		public TfquestionTextContext tfquestionText(int i) {
			return getRuleContext(TfquestionTextContext.class,i);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public TrueFalseQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueFalseQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterTrueFalseQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitTrueFalseQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitTrueFalseQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueFalseQuestionContext trueFalseQuestion() throws RecognitionException {
		TrueFalseQuestionContext _localctx = new TrueFalseQuestionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_trueFalseQuestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			tfquestionType();
			setState(215);
			match(T__0);
			setState(217); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(216);
				tfquestionText();
				}
				}
				setState(219); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD );
			setState(221);
			tfsolution();
			setState(222);
			match(T__0);
			setState(223);
			tfcotacao();
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WORD) {
				{
				setState(224);
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
	public static class TfquestionTypeContext extends ParserRuleContext {
		public TfquestionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tfquestionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterTfquestionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitTfquestionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitTfquestionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TfquestionTypeContext tfquestionType() throws RecognitionException {
		TfquestionTypeContext _localctx = new TfquestionTypeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_tfquestionType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(T__9);
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
	public static class TfsolutionContext extends ParserRuleContext {
		public TruefalseOptionsContext truefalseOptions() {
			return getRuleContext(TruefalseOptionsContext.class,0);
		}
		public TfsolutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tfsolution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterTfsolution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitTfsolution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitTfsolution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TfsolutionContext tfsolution() throws RecognitionException {
		TfsolutionContext _localctx = new TfsolutionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_tfsolution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(T__3);
			setState(230);
			truefalseOptions();
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
	public static class TruefalseOptionsContext extends ParserRuleContext {
		public TruefalseOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_truefalseOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterTruefalseOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitTruefalseOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitTruefalseOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TruefalseOptionsContext truefalseOptions() throws RecognitionException {
		TruefalseOptionsContext _localctx = new TruefalseOptionsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_truefalseOptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2095104L) != 0)) ) {
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
	public static class TfcotacaoContext extends ParserRuleContext {
		public TfnumberContext tfnumber() {
			return getRuleContext(TfnumberContext.class,0);
		}
		public TfcotacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tfcotacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterTfcotacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitTfcotacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitTfcotacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TfcotacaoContext tfcotacao() throws RecognitionException {
		TfcotacaoContext _localctx = new TfcotacaoContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_tfcotacao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(T__5);
			setState(235);
			tfnumber();
			setState(236);
			match(T__6);
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
	public static class TfquestionTextContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(QuestionParser.WORD, 0); }
		public TfquestionTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tfquestionText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterTfquestionText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitTfquestionText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitTfquestionText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TfquestionTextContext tfquestionText() throws RecognitionException {
		TfquestionTextContext _localctx = new TfquestionTextContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_tfquestionText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(WORD);
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
	public static class TfnumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(QuestionParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(QuestionParser.FLOAT, 0); }
		public TfnumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tfnumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).enterTfnumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionListener ) ((QuestionListener)listener).exitTfnumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionVisitor ) return ((QuestionVisitor<? extends T>)visitor).visitTfnumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TfnumberContext tfnumber() throws RecognitionException {
		TfnumberContext _localctx = new TfnumberContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_tfnumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
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

	public static final String _serializedATN =
		"\u0004\u0001\u0018\u00f3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0003\u0000G\b\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0004\u0001L\b\u0001\u000b\u0001\f\u0001M\u0001\u0001\u0004\u0001"+
		"Q\b\u0001\u000b\u0001\f\u0001R\u0001\u0001\u0004\u0001V\b\u0001\u000b"+
		"\u0001\f\u0001W\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001]\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0004\u0003c\b\u0003"+
		"\u000b\u0003\f\u0003d\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0004\ty\b\t\u000b\t\f\tz\u0001\t\u0004\t~\b\t\u000b\t\f\t\u007f\u0001"+
		"\t\u0004\t\u0083\b\t\u000b\t\f\t\u0084\u0001\t\u0001\t\u0001\t\u0003\t"+
		"\u008a\b\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0004\u000b\u0090\b"+
		"\u000b\u000b\u000b\f\u000b\u0091\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0004\u000e\u009d\b\u000e\u000b"+
		"\u000e\f\u000e\u009e\u0003\u000e\u00a1\b\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0004\u0011"+
		"\u00aa\b\u0011\u000b\u0011\f\u0011\u00ab\u0001\u0011\u0004\u0011\u00af"+
		"\b\u0011\u000b\u0011\f\u0011\u00b0\u0001\u0011\u0004\u0011\u00b4\b\u0011"+
		"\u000b\u0011\f\u0011\u00b5\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011"+
		"\u00bb\b\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0004\u0017\u00cc\b\u0017"+
		"\u000b\u0017\f\u0017\u00cd\u0001\u0018\u0004\u0018\u00d1\b\u0018\u000b"+
		"\u0018\f\u0018\u00d2\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0004\u001a\u00da\b\u001a\u000b\u001a\f\u001a\u00db\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u00e2\b\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"+
		"\u0001 \u0001 \u0001 \u0000\u0000!\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@\u0000"+
		"\u0002\u0001\u0000\u0015\u0016\u0001\u0000\u000b\u0014\u00e8\u0000F\u0001"+
		"\u0000\u0000\u0000\u0002H\u0001\u0000\u0000\u0000\u0004^\u0001\u0000\u0000"+
		"\u0000\u0006`\u0001\u0000\u0000\u0000\bf\u0001\u0000\u0000\u0000\nk\u0001"+
		"\u0000\u0000\u0000\fo\u0001\u0000\u0000\u0000\u000eq\u0001\u0000\u0000"+
		"\u0000\u0010s\u0001\u0000\u0000\u0000\u0012u\u0001\u0000\u0000\u0000\u0014"+
		"\u008b\u0001\u0000\u0000\u0000\u0016\u008d\u0001\u0000\u0000\u0000\u0018"+
		"\u0093\u0001\u0000\u0000\u0000\u001a\u0096\u0001\u0000\u0000\u0000\u001c"+
		"\u00a0\u0001\u0000\u0000\u0000\u001e\u00a2\u0001\u0000\u0000\u0000 \u00a4"+
		"\u0001\u0000\u0000\u0000\"\u00a6\u0001\u0000\u0000\u0000$\u00bc\u0001"+
		"\u0000\u0000\u0000&\u00be\u0001\u0000\u0000\u0000(\u00c1\u0001\u0000\u0000"+
		"\u0000*\u00c4\u0001\u0000\u0000\u0000,\u00c8\u0001\u0000\u0000\u0000."+
		"\u00cb\u0001\u0000\u0000\u00000\u00d0\u0001\u0000\u0000\u00002\u00d4\u0001"+
		"\u0000\u0000\u00004\u00d6\u0001\u0000\u0000\u00006\u00e3\u0001\u0000\u0000"+
		"\u00008\u00e5\u0001\u0000\u0000\u0000:\u00e8\u0001\u0000\u0000\u0000<"+
		"\u00ea\u0001\u0000\u0000\u0000>\u00ee\u0001\u0000\u0000\u0000@\u00f0\u0001"+
		"\u0000\u0000\u0000BG\u0003\u0012\t\u0000CG\u0003\u0002\u0001\u0000DG\u0003"+
		"\"\u0011\u0000EG\u00034\u001a\u0000FB\u0001\u0000\u0000\u0000FC\u0001"+
		"\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FE\u0001\u0000\u0000\u0000"+
		"G\u0001\u0001\u0000\u0000\u0000HI\u0003\u0004\u0002\u0000IK\u0005\u0001"+
		"\u0000\u0000JL\u0003\f\u0006\u0000KJ\u0001\u0000\u0000\u0000LM\u0001\u0000"+
		"\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NP\u0001"+
		"\u0000\u0000\u0000OQ\u0003\u0006\u0003\u0000PO\u0001\u0000\u0000\u0000"+
		"QR\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000"+
		"\u0000SU\u0001\u0000\u0000\u0000TV\u0003\b\u0004\u0000UT\u0001\u0000\u0000"+
		"\u0000VW\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000"+
		"\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0005\u0001\u0000\u0000Z\\\u0003"+
		"\n\u0005\u0000[]\u0003.\u0017\u0000\\[\u0001\u0000\u0000\u0000\\]\u0001"+
		"\u0000\u0000\u0000]\u0003\u0001\u0000\u0000\u0000^_\u0005\u0002\u0000"+
		"\u0000_\u0005\u0001\u0000\u0000\u0000`b\u0005\u0003\u0000\u0000ac\u0003"+
		"\u000e\u0007\u0000ba\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000"+
		"db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000e\u0007\u0001\u0000"+
		"\u0000\u0000fg\u0005\u0004\u0000\u0000gh\u0003\u0010\b\u0000hi\u0005\u0005"+
		"\u0000\u0000ij\u0003\u0010\b\u0000j\t\u0001\u0000\u0000\u0000kl\u0005"+
		"\u0006\u0000\u0000lm\u0003\u0010\b\u0000mn\u0005\u0007\u0000\u0000n\u000b"+
		"\u0001\u0000\u0000\u0000op\u0003\u000e\u0007\u0000p\r\u0001\u0000\u0000"+
		"\u0000qr\u0005\u0017\u0000\u0000r\u000f\u0001\u0000\u0000\u0000st\u0007"+
		"\u0000\u0000\u0000t\u0011\u0001\u0000\u0000\u0000uv\u0003\u0014\n\u0000"+
		"vx\u0005\u0001\u0000\u0000wy\u0003\u001c\u000e\u0000xw\u0001\u0000\u0000"+
		"\u0000yz\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000"+
		"\u0000\u0000{}\u0001\u0000\u0000\u0000|~\u0003\u0016\u000b\u0000}|\u0001"+
		"\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0082\u0001\u0000\u0000"+
		"\u0000\u0081\u0083\u0003\u0018\f\u0000\u0082\u0081\u0001\u0000\u0000\u0000"+
		"\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0005\u0001\u0000\u0000\u0087\u0089\u0003\u001a\r\u0000\u0088"+
		"\u008a\u0003.\u0017\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u0089\u008a"+
		"\u0001\u0000\u0000\u0000\u008a\u0013\u0001\u0000\u0000\u0000\u008b\u008c"+
		"\u0005\b\u0000\u0000\u008c\u0015\u0001\u0000\u0000\u0000\u008d\u008f\u0005"+
		"\u0003\u0000\u0000\u008e\u0090\u0003\u001e\u000f\u0000\u008f\u008e\u0001"+
		"\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u008f\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0017\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0005\u0004\u0000\u0000\u0094\u0095\u0003"+
		" \u0010\u0000\u0095\u0019\u0001\u0000\u0000\u0000\u0096\u0097\u0005\u0006"+
		"\u0000\u0000\u0097\u0098\u0003 \u0010\u0000\u0098\u0099\u0005\u0007\u0000"+
		"\u0000\u0099\u001b\u0001\u0000\u0000\u0000\u009a\u00a1\u0003\u001e\u000f"+
		"\u0000\u009b\u009d\u0003 \u0010\u0000\u009c\u009b\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a0\u009a\u0001\u0000\u0000\u0000\u00a0\u009c\u0001\u0000\u0000\u0000"+
		"\u00a1\u001d\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005\u0017\u0000\u0000"+
		"\u00a3\u001f\u0001\u0000\u0000\u0000\u00a4\u00a5\u0007\u0000\u0000\u0000"+
		"\u00a5!\u0001\u0000\u0000\u0000\u00a6\u00a7\u0003$\u0012\u0000\u00a7\u00a9"+
		"\u0005\u0001\u0000\u0000\u00a8\u00aa\u0003,\u0016\u0000\u00a9\u00a8\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ae\u0001"+
		"\u0000\u0000\u0000\u00ad\u00af\u0003&\u0013\u0000\u00ae\u00ad\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b4\u0003(\u0014\u0000\u00b3\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b8\u0005\u0001\u0000\u0000\u00b8\u00ba\u0003*\u0015\u0000"+
		"\u00b9\u00bb\u0003.\u0017\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bb\u0001\u0000\u0000\u0000\u00bb#\u0001\u0000\u0000\u0000\u00bc\u00bd"+
		"\u0005\t\u0000\u0000\u00bd%\u0001\u0000\u0000\u0000\u00be\u00bf\u0005"+
		"\u0003\u0000\u0000\u00bf\u00c0\u00030\u0018\u0000\u00c0\'\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0005\u0004\u0000\u0000\u00c2\u00c3\u00030\u0018"+
		"\u0000\u00c3)\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u0006\u0000\u0000"+
		"\u00c5\u00c6\u00032\u0019\u0000\u00c6\u00c7\u0005\u0007\u0000\u0000\u00c7"+
		"+\u0001\u0000\u0000\u0000\u00c8\u00c9\u00030\u0018\u0000\u00c9-\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cc\u0005\u0017\u0000\u0000\u00cb\u00ca\u0001"+
		"\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001"+
		"\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce/\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d1\u0005\u0017\u0000\u0000\u00d0\u00cf\u0001\u0000"+
		"\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d31\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d5\u0007\u0000\u0000\u0000\u00d53\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d7\u00036\u001b\u0000\u00d7\u00d9\u0005\u0001\u0000\u0000\u00d8"+
		"\u00da\u0003>\u001f\u0000\u00d9\u00d8\u0001\u0000\u0000\u0000\u00da\u00db"+
		"\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc"+
		"\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u00de"+
		"\u00038\u001c\u0000\u00de\u00df\u0005\u0001\u0000\u0000\u00df\u00e1\u0003"+
		"<\u001e\u0000\u00e0\u00e2\u0003.\u0017\u0000\u00e1\u00e0\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e25\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e4\u0005\n\u0000\u0000\u00e47\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e6\u0005\u0004\u0000\u0000\u00e6\u00e7\u0003:\u001d\u0000\u00e79\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e9\u0007\u0001\u0000\u0000\u00e9;\u0001\u0000"+
		"\u0000\u0000\u00ea\u00eb\u0005\u0006\u0000\u0000\u00eb\u00ec\u0003@ \u0000"+
		"\u00ec\u00ed\u0005\u0007\u0000\u0000\u00ed=\u0001\u0000\u0000\u0000\u00ee"+
		"\u00ef\u0005\u0017\u0000\u0000\u00ef?\u0001\u0000\u0000\u0000\u00f0\u00f1"+
		"\u0007\u0000\u0000\u0000\u00f1A\u0001\u0000\u0000\u0000\u0015FMRW\\dz"+
		"\u007f\u0084\u0089\u0091\u009e\u00a0\u00ab\u00b0\u00b5\u00ba\u00cd\u00d2"+
		"\u00db\u00e1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}