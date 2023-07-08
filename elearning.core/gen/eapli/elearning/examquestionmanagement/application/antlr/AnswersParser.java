// Generated from C:/Users/Vicen/IdeaProjects/sem4pi-22-23-59/elearning.core/src/main/java/eapli/elearning/examquestionmanagement/application/antlr\Answers.g4 by ANTLR 4.12.0
package eapli.elearning.examquestionmanagement.application.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AnswersParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, INT=21, INTEGER=22, NUMERIC_VALUE=23, FLOAT=24, 
		FLOATEXPO=25, WORD=26, WS=27;
	public static final int
		RULE_start = 0, RULE_answers = 1, RULE_truefalse = 2, RULE_matching = 3, 
		RULE_multiple = 4, RULE_numerical = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "answers", "truefalse", "matching", "multiple", "numerical"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\\n'", "'MISSING_WORDS'", "'-'", "';'", "'MATCHING'", "'MULTIPLE_CHOICE'", 
			"'TRUE_OR_FALSE'", "'NUMERICAL'", "'SHORT_ANSWER'", "'true'", "'True'", 
			"'TRUE'", "'false'", "'False'", "'FALSE'", "'T'", "'t'", "'F'", "'f'", 
			"'&'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "INT", "INTEGER", 
			"NUMERIC_VALUE", "FLOAT", "FLOATEXPO", "WORD", "WS"
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
		public List<TerminalNode> EOF() { return getTokens(AnswersParser.EOF); }
		public TerminalNode EOF(int i) {
			return getToken(AnswersParser.EOF, i);
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
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12);
				answers();
				setState(13);
				_la = _input.LA(1);
				if ( !(_la==EOF || _la==T__0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(17); 
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
		public NumericalContext numerical() {
			return getRuleContext(NumericalContext.class,0);
		}
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
				setState(19);
				match(T__1);
				setState(20);
				match(T__2);
				setState(22);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WORD) {
					{
					setState(21);
					match(WORD);
					}
				}

				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(24);
					match(T__3);
					}
				}

				}
				break;
			case T__4:
				_localctx = new MatchingsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				match(T__4);
				setState(28);
				match(T__2);
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INT) {
					{
					setState(29);
					matching();
					}
				}

				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(32);
					match(T__3);
					}
				}

				}
				break;
			case T__5:
				_localctx = new MultipleChoiceContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(35);
				match(T__5);
				setState(36);
				match(T__2);
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INT) {
					{
					setState(37);
					multiple();
					}
				}

				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(40);
					match(T__3);
					}
				}

				}
				break;
			case T__6:
				_localctx = new TrueOrFalseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				match(T__6);
				setState(44);
				match(T__2);
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1047552L) != 0)) {
					{
					setState(45);
					truefalse();
					}
				}

				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(48);
					match(T__3);
					}
				}

				}
				break;
			case T__7:
				_localctx = new NumericalsContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
				match(T__7);
				setState(52);
				match(T__2);
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMERIC_VALUE) {
					{
					setState(53);
					numerical();
					}
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
		public List<TerminalNode> INT() { return getTokens(AnswersParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(AnswersParser.INT, i);
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
				match(INT);
				setState(72);
				match(T__19);
				setState(73);
				match(INT);
				setState(74);
				match(T__3);
				}
				}
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INT );
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
		public List<TerminalNode> INT() { return getTokens(AnswersParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(AnswersParser.INT, i);
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
				match(INT);
				setState(80);
				match(T__3);
				}
				}
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INT );
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
	public static class NumericalContext extends ParserRuleContext {
		public TerminalNode NUMERIC_VALUE() { return getToken(AnswersParser.NUMERIC_VALUE, 0); }
		public NumericalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerical; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).enterNumerical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnswersListener ) ((AnswersListener)listener).exitNumerical(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnswersVisitor ) return ((AnswersVisitor<? extends T>)visitor).visitNumerical(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericalContext numerical() throws RecognitionException {
		NumericalContext _localctx = new NumericalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_numerical);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(NUMERIC_VALUE);
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
		"\u0004\u0001\u001bX\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u0010"+
		"\b\u0000\u000b\u0000\f\u0000\u0011\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001\u0017\b\u0001\u0001\u0001\u0003\u0001\u001a\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u001f\b\u0001\u0001\u0001\u0003"+
		"\u0001\"\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\'\b\u0001"+
		"\u0001\u0001\u0003\u0001*\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001/\b\u0001\u0001\u0001\u0003\u00012\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u00017\b\u0001\u0001\u0001\u0003\u0001:\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001?\b\u0001\u0001\u0001"+
		"\u0003\u0001B\b\u0001\u0003\u0001D\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003L\b\u0003\u000b"+
		"\u0003\f\u0003M\u0001\u0004\u0001\u0004\u0004\u0004R\b\u0004\u000b\u0004"+
		"\f\u0004S\u0001\u0005\u0001\u0005\u0001\u0005\u0000\u0000\u0006\u0000"+
		"\u0002\u0004\u0006\b\n\u0000\u0002\u0001\u0001\u0001\u0001\u0001\u0000"+
		"\n\u0013e\u0000\u000f\u0001\u0000\u0000\u0000\u0002C\u0001\u0000\u0000"+
		"\u0000\u0004E\u0001\u0000\u0000\u0000\u0006K\u0001\u0000\u0000\u0000\b"+
		"Q\u0001\u0000\u0000\u0000\nU\u0001\u0000\u0000\u0000\f\r\u0003\u0002\u0001"+
		"\u0000\r\u000e\u0007\u0000\u0000\u0000\u000e\u0010\u0001\u0000\u0000\u0000"+
		"\u000f\f\u0001\u0000\u0000\u0000\u0010\u0011\u0001\u0000\u0000\u0000\u0011"+
		"\u000f\u0001\u0000\u0000\u0000\u0011\u0012\u0001\u0000\u0000\u0000\u0012"+
		"\u0001\u0001\u0000\u0000\u0000\u0013\u0014\u0005\u0002\u0000\u0000\u0014"+
		"\u0016\u0005\u0003\u0000\u0000\u0015\u0017\u0005\u001a\u0000\u0000\u0016"+
		"\u0015\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000\u0017"+
		"\u0019\u0001\u0000\u0000\u0000\u0018\u001a\u0005\u0004\u0000\u0000\u0019"+
		"\u0018\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a"+
		"D\u0001\u0000\u0000\u0000\u001b\u001c\u0005\u0005\u0000\u0000\u001c\u001e"+
		"\u0005\u0003\u0000\u0000\u001d\u001f\u0003\u0006\u0003\u0000\u001e\u001d"+
		"\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f!\u0001"+
		"\u0000\u0000\u0000 \"\u0005\u0004\u0000\u0000! \u0001\u0000\u0000\u0000"+
		"!\"\u0001\u0000\u0000\u0000\"D\u0001\u0000\u0000\u0000#$\u0005\u0006\u0000"+
		"\u0000$&\u0005\u0003\u0000\u0000%\'\u0003\b\u0004\u0000&%\u0001\u0000"+
		"\u0000\u0000&\'\u0001\u0000\u0000\u0000\')\u0001\u0000\u0000\u0000(*\u0005"+
		"\u0004\u0000\u0000)(\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000"+
		"*D\u0001\u0000\u0000\u0000+,\u0005\u0007\u0000\u0000,.\u0005\u0003\u0000"+
		"\u0000-/\u0003\u0004\u0002\u0000.-\u0001\u0000\u0000\u0000./\u0001\u0000"+
		"\u0000\u0000/1\u0001\u0000\u0000\u000002\u0005\u0004\u0000\u000010\u0001"+
		"\u0000\u0000\u000012\u0001\u0000\u0000\u00002D\u0001\u0000\u0000\u0000"+
		"34\u0005\b\u0000\u000046\u0005\u0003\u0000\u000057\u0003\n\u0005\u0000"+
		"65\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u000079\u0001\u0000\u0000"+
		"\u00008:\u0005\u0004\u0000\u000098\u0001\u0000\u0000\u00009:\u0001\u0000"+
		"\u0000\u0000:D\u0001\u0000\u0000\u0000;<\u0005\t\u0000\u0000<>\u0005\u0003"+
		"\u0000\u0000=?\u0005\u001a\u0000\u0000>=\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?A\u0001\u0000\u0000\u0000@B\u0005\u0004\u0000\u0000"+
		"A@\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BD\u0001\u0000\u0000"+
		"\u0000C\u0013\u0001\u0000\u0000\u0000C\u001b\u0001\u0000\u0000\u0000C"+
		"#\u0001\u0000\u0000\u0000C+\u0001\u0000\u0000\u0000C3\u0001\u0000\u0000"+
		"\u0000C;\u0001\u0000\u0000\u0000D\u0003\u0001\u0000\u0000\u0000EF\u0007"+
		"\u0001\u0000\u0000F\u0005\u0001\u0000\u0000\u0000GH\u0005\u0015\u0000"+
		"\u0000HI\u0005\u0014\u0000\u0000IJ\u0005\u0015\u0000\u0000JL\u0005\u0004"+
		"\u0000\u0000KG\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MK\u0001"+
		"\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000N\u0007\u0001\u0000\u0000"+
		"\u0000OP\u0005\u0015\u0000\u0000PR\u0005\u0004\u0000\u0000QO\u0001\u0000"+
		"\u0000\u0000RS\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001"+
		"\u0000\u0000\u0000T\t\u0001\u0000\u0000\u0000UV\u0005\u0017\u0000\u0000"+
		"V\u000b\u0001\u0000\u0000\u0000\u0010\u0011\u0016\u0019\u001e!&).169>"+
		"ACMS";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}