// Generated from C:/Users/ricar/IdeaProjects/sem4pi-22-23-58/elearning.core/src/main/java/eapli/elearning/examquestionmanagement/application/antlr\Answers.g4 by ANTLR 4.12.0
package eapli.elearning.examquestionmanagement.application.antlr.documents;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AnswersParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, INTEGER=21, FLOAT=22, FLOATEXPO=23, WORD=24, 
		WS=25;
	public static final int
		RULE_start = 0, RULE_answers = 1, RULE_truefalse = 2, RULE_matching = 3, 
		RULE_multiple = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "answers", "truefalse", "matching", "multiple"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\\n'", "'MISSING_WORDS'", "'-'", "';'", "'MATCHING'", "'MULTIPLE_CHOICE'", 
			"'TRUE_OR_FALSE'", "'NUMERICAL'", "'SHORT_ANSWER'", "'true;'", "'True;'", 
			"'TRUE;'", "'false;'", "'False;'", "'FALSE;'", "'T;'", "'t;'", "'F;'", 
			"'f;'", "'&'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "INTEGER", "FLOAT", 
			"FLOATEXPO", "WORD", "WS"
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
	public String getGrammarFileName() { return "Answers.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AnswersParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public List<AnswersContext> answers() {
			return getRuleContexts(AnswersContext.class);
		}
		public AnswersContext answers(int i) {
			return getRuleContext(AnswersContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswersVisitor ) return ((AnswersVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				answers();
				setState(11);
				match(T__0);
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 996L) != 0) );
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
	public static class AnswersContext extends ParserRuleContext {
		public AnswersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answers; }
	 
		public AnswersContext() { }
		public void copyFrom(AnswersContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumericalsContext extends AnswersContext {
		public Token f;
		public Token i;
		public Token fe;
		public TerminalNode FLOAT() { return getToken(AnswersParser.FLOAT, 0); }
		public TerminalNode INTEGER() { return getToken(AnswersParser.INTEGER, 0); }
		public TerminalNode FLOATEXPO() { return getToken(AnswersParser.FLOATEXPO, 0); }
		public NumericalsContext(AnswersContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).enterNumericals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).exitNumericals(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswersVisitor ) return ((AnswersVisitor<? extends T>)visitor).visitNumericals(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultipleChoiceContext extends AnswersContext {
		public MultipleContext multiple() {
			return getRuleContext(MultipleContext.class,0);
		}
		public MultipleChoiceContext(AnswersContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).enterMultipleChoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).exitMultipleChoice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswersVisitor ) return ((AnswersVisitor<? extends T>)visitor).visitMultipleChoice(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MissingWordsContext extends AnswersContext {
		public TerminalNode WORD() { return getToken(AnswersParser.WORD, 0); }
		public MissingWordsContext(AnswersContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).enterMissingWords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).exitMissingWords(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswersVisitor ) return ((AnswersVisitor<? extends T>)visitor).visitMissingWords(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MatchingsContext extends AnswersContext {
		public MatchingContext matching() {
			return getRuleContext(MatchingContext.class,0);
		}
		public MatchingsContext(AnswersContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).enterMatchings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).exitMatchings(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswersVisitor ) return ((AnswersVisitor<? extends T>)visitor).visitMatchings(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ShortAnswerContext extends AnswersContext {
		public TerminalNode WORD() { return getToken(AnswersParser.WORD, 0); }
		public ShortAnswerContext(AnswersContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).enterShortAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).exitShortAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswersVisitor ) return ((AnswersVisitor<? extends T>)visitor).visitShortAnswer(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueOrFalseContext extends AnswersContext {
		public TruefalseContext truefalse() {
			return getRuleContext(TruefalseContext.class,0);
		}
		public TrueOrFalseContext(AnswersContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).enterTrueOrFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).exitTrueOrFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswersVisitor ) return ((AnswersVisitor<? extends T>)visitor).visitTrueOrFalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswersContext answers() throws RecognitionException {
		AnswersContext _localctx = new AnswersContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_answers);
		int _la;
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				_localctx = new MissingWordsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				match(T__1);
				setState(18);
				match(T__2);
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WORD) {
					{
					setState(19);
					match(WORD);
					}
				}

				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(22);
					match(T__3);
					}
				}

				}
				break;
			case T__4:
				_localctx = new MatchingsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				match(T__4);
				setState(26);
				match(T__2);
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTEGER) {
					{
					setState(27);
					matching();
					}
				}

				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(30);
					match(T__3);
					}
				}

				}
				break;
			case T__5:
				_localctx = new MultipleChoiceContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(33);
				match(T__5);
				setState(34);
				match(T__2);
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTEGER) {
					{
					setState(35);
					multiple();
					}
				}

				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(38);
					match(T__3);
					}
				}

				}
				break;
			case T__6:
				_localctx = new TrueOrFalseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				match(T__6);
				setState(42);
				match(T__2);
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1047552L) != 0)) {
					{
					setState(43);
					truefalse();
					}
				}

				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(46);
					match(T__3);
					}
				}

				}
				break;
			case T__7:
				_localctx = new NumericalsContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(49);
				match(T__7);
				setState(50);
				match(T__2);
				setState(54);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FLOAT:
					{
					setState(51);
					((NumericalsContext)_localctx).f = match(FLOAT);
					}
					break;
				case INTEGER:
					{
					setState(52);
					((NumericalsContext)_localctx).i = match(INTEGER);
					}
					break;
				case FLOATEXPO:
					{
					setState(53);
					((NumericalsContext)_localctx).fe = match(FLOATEXPO);
					}
					break;
				case T__0:
				case T__3:
					break;
				default:
					break;
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(56);
					match(T__3);
					}
				}

				}
				break;
			case T__8:
				_localctx = new ShortAnswerContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(59);
				match(T__8);
				setState(60);
				match(T__2);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WORD) {
					{
					setState(61);
					match(WORD);
					}
				}

				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(64);
					match(T__3);
					}
				}

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
	public static class TruefalseContext extends ParserRuleContext {
		public TruefalseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_truefalse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).enterTruefalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).exitTruefalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswersVisitor ) return ((AnswersVisitor<? extends T>)visitor).visitTruefalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TruefalseContext truefalse() throws RecognitionException {
		TruefalseContext _localctx = new TruefalseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_truefalse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1047552L) != 0)) ) {
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
	public static class MatchingContext extends ParserRuleContext {
		public Token left;
		public Token right;
		public List<TerminalNode> INTEGER() { return getTokens(AnswersParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(AnswersParser.INTEGER, i);
		}
		public MatchingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matching; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).enterMatching(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).exitMatching(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswersVisitor ) return ((AnswersVisitor<? extends T>)visitor).visitMatching(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchingContext matching() throws RecognitionException {
		MatchingContext _localctx = new MatchingContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_matching);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(71);
				((MatchingContext)_localctx).left = match(INTEGER);
				setState(72);
				match(T__19);
				setState(73);
				((MatchingContext)_localctx).right = match(INTEGER);
				setState(74);
				match(T__3);
				}
				}
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INTEGER );
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
	public static class MultipleContext extends ParserRuleContext {
		public List<TerminalNode> INTEGER() { return getTokens(AnswersParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(AnswersParser.INTEGER, i);
		}
		public MultipleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).enterMultiple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).exitMultiple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswersVisitor ) return ((AnswersVisitor<? extends T>)visitor).visitMultiple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleContext multiple() throws RecognitionException {
		MultipleContext _localctx = new MultipleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_multiple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79);
				match(INTEGER);
				setState(80);
				match(T__3);
				}
				}
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INTEGER );
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
		"\u0004\u0001\u0019V\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u000e\b\u0000\u000b\u0000\f"+
		"\u0000\u000f\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u0015\b\u0001"+
		"\u0001\u0001\u0003\u0001\u0018\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001\u001d\b\u0001\u0001\u0001\u0003\u0001 \b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001%\b\u0001\u0001\u0001\u0003\u0001"+
		"(\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001-\b\u0001\u0001"+
		"\u0001\u0003\u00010\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u00017\b\u0001\u0001\u0001\u0003\u0001:\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001?\b\u0001\u0001\u0001"+
		"\u0003\u0001B\b\u0001\u0003\u0001D\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003L\b\u0003\u000b"+
		"\u0003\f\u0003M\u0001\u0004\u0001\u0004\u0004\u0004R\b\u0004\u000b\u0004"+
		"\f\u0004S\u0001\u0004\u0000\u0000\u0005\u0000\u0002\u0004\u0006\b\u0000"+
		"\u0001\u0001\u0000\n\u0013f\u0000\r\u0001\u0000\u0000\u0000\u0002C\u0001"+
		"\u0000\u0000\u0000\u0004E\u0001\u0000\u0000\u0000\u0006K\u0001\u0000\u0000"+
		"\u0000\bQ\u0001\u0000\u0000\u0000\n\u000b\u0003\u0002\u0001\u0000\u000b"+
		"\f\u0005\u0001\u0000\u0000\f\u000e\u0001\u0000\u0000\u0000\r\n\u0001\u0000"+
		"\u0000\u0000\u000e\u000f\u0001\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000"+
		"\u0000\u000f\u0010\u0001\u0000\u0000\u0000\u0010\u0001\u0001\u0000\u0000"+
		"\u0000\u0011\u0012\u0005\u0002\u0000\u0000\u0012\u0014\u0005\u0003\u0000"+
		"\u0000\u0013\u0015\u0005\u0018\u0000\u0000\u0014\u0013\u0001\u0000\u0000"+
		"\u0000\u0014\u0015\u0001\u0000\u0000\u0000\u0015\u0017\u0001\u0000\u0000"+
		"\u0000\u0016\u0018\u0005\u0004\u0000\u0000\u0017\u0016\u0001\u0000\u0000"+
		"\u0000\u0017\u0018\u0001\u0000\u0000\u0000\u0018D\u0001\u0000\u0000\u0000"+
		"\u0019\u001a\u0005\u0005\u0000\u0000\u001a\u001c\u0005\u0003\u0000\u0000"+
		"\u001b\u001d\u0003\u0006\u0003\u0000\u001c\u001b\u0001\u0000\u0000\u0000"+
		"\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u001f\u0001\u0000\u0000\u0000"+
		"\u001e \u0005\u0004\u0000\u0000\u001f\u001e\u0001\u0000\u0000\u0000\u001f"+
		" \u0001\u0000\u0000\u0000 D\u0001\u0000\u0000\u0000!\"\u0005\u0006\u0000"+
		"\u0000\"$\u0005\u0003\u0000\u0000#%\u0003\b\u0004\u0000$#\u0001\u0000"+
		"\u0000\u0000$%\u0001\u0000\u0000\u0000%\'\u0001\u0000\u0000\u0000&(\u0005"+
		"\u0004\u0000\u0000\'&\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000"+
		"(D\u0001\u0000\u0000\u0000)*\u0005\u0007\u0000\u0000*,\u0005\u0003\u0000"+
		"\u0000+-\u0003\u0004\u0002\u0000,+\u0001\u0000\u0000\u0000,-\u0001\u0000"+
		"\u0000\u0000-/\u0001\u0000\u0000\u0000.0\u0005\u0004\u0000\u0000/.\u0001"+
		"\u0000\u0000\u0000/0\u0001\u0000\u0000\u00000D\u0001\u0000\u0000\u0000"+
		"12\u0005\b\u0000\u000026\u0005\u0003\u0000\u000037\u0005\u0016\u0000\u0000"+
		"47\u0005\u0015\u0000\u000057\u0005\u0017\u0000\u000063\u0001\u0000\u0000"+
		"\u000064\u0001\u0000\u0000\u000065\u0001\u0000\u0000\u000067\u0001\u0000"+
		"\u0000\u000079\u0001\u0000\u0000\u00008:\u0005\u0004\u0000\u000098\u0001"+
		"\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:D\u0001\u0000\u0000\u0000"+
		";<\u0005\t\u0000\u0000<>\u0005\u0003\u0000\u0000=?\u0005\u0018\u0000\u0000"+
		">=\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?A\u0001\u0000\u0000"+
		"\u0000@B\u0005\u0004\u0000\u0000A@\u0001\u0000\u0000\u0000AB\u0001\u0000"+
		"\u0000\u0000BD\u0001\u0000\u0000\u0000C\u0011\u0001\u0000\u0000\u0000"+
		"C\u0019\u0001\u0000\u0000\u0000C!\u0001\u0000\u0000\u0000C)\u0001\u0000"+
		"\u0000\u0000C1\u0001\u0000\u0000\u0000C;\u0001\u0000\u0000\u0000D\u0003"+
		"\u0001\u0000\u0000\u0000EF\u0007\u0000\u0000\u0000F\u0005\u0001\u0000"+
		"\u0000\u0000GH\u0005\u0015\u0000\u0000HI\u0005\u0014\u0000\u0000IJ\u0005"+
		"\u0015\u0000\u0000JL\u0005\u0004\u0000\u0000KG\u0001\u0000\u0000\u0000"+
		"LM\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000"+
		"\u0000N\u0007\u0001\u0000\u0000\u0000OP\u0005\u0015\u0000\u0000PR\u0005"+
		"\u0004\u0000\u0000QO\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000"+
		"SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000T\t\u0001\u0000\u0000"+
		"\u0000\u0010\u000f\u0014\u0017\u001c\u001f$\',/69>ACMS";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}