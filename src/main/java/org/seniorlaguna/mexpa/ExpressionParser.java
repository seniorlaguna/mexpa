// Generated from /Users/ft/IdeaProjects/mexpa/grammar/Expression.g4 by ANTLR 4.9.2
package org.seniorlaguna.mexpa;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, NUMBER=9, 
		WHITESPACE=10;
	public static final int
		RULE_parse = 0, RULE_term = 1, RULE_power = 2, RULE_implicitMul = 3, RULE_prefix = 4, 
		RULE_suffix = 5, RULE_mulDiv = 6, RULE_addSub = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "term", "power", "implicitMul", "prefix", "suffix", "mulDiv", 
			"addSub"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'^'", "'-'", "'%'", "'*'", "'/'", "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "NUMBER", "WHITESPACE"
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
	public String getGrammarFileName() { return "Expression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ParseContext extends ParserRuleContext {
		public AddSubContext addSub() {
			return getRuleContext(AddSubContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ExpressionParser.EOF, 0); }
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			setState(18);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__3:
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				addSub(0);
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(17);
				match(EOF);
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

	public static class TermContext extends ParserRuleContext {
		public AddSubContext number;
		public TerminalNode NUMBER() { return getToken(ExpressionParser.NUMBER, 0); }
		public AddSubContext addSub() {
			return getRuleContext(AddSubContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_term);
		try {
			setState(25);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				match(NUMBER);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				match(T__0);
				setState(22);
				((TermContext)_localctx).number = addSub(0);
				setState(23);
				match(T__1);
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

	public static class PowerContext extends ParserRuleContext {
		public TermContext left;
		public PowerContext right;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public PowerContext power() {
			return getRuleContext(PowerContext.class,0);
		}
		public PowerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_power; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitPower(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowerContext power() throws RecognitionException {
		PowerContext _localctx = new PowerContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_power);
		try {
			setState(32);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				((PowerContext)_localctx).left = term();
				setState(29);
				match(T__2);
				setState(30);
				((PowerContext)_localctx).right = power();
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

	public static class ImplicitMulContext extends ParserRuleContext {
		public ImplicitMulContext left;
		public PowerContext right;
		public PowerContext power() {
			return getRuleContext(PowerContext.class,0);
		}
		public ImplicitMulContext implicitMul() {
			return getRuleContext(ImplicitMulContext.class,0);
		}
		public ImplicitMulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implicitMul; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitImplicitMul(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImplicitMulContext implicitMul() throws RecognitionException {
		return implicitMul(0);
	}

	private ImplicitMulContext implicitMul(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ImplicitMulContext _localctx = new ImplicitMulContext(_ctx, _parentState);
		ImplicitMulContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_implicitMul, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(35);
			power();
			}
			_ctx.stop = _input.LT(-1);
			setState(41);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ImplicitMulContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_implicitMul);
					setState(37);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(38);
					((ImplicitMulContext)_localctx).right = power();
					}
					} 
				}
				setState(43);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrefixContext extends ParserRuleContext {
		public PrefixContext number;
		public ImplicitMulContext implicitMul() {
			return getRuleContext(ImplicitMulContext.class,0);
		}
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public PrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitPrefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixContext prefix() throws RecognitionException {
		PrefixContext _localctx = new PrefixContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_prefix);
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				implicitMul(0);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(T__3);
				setState(46);
				((PrefixContext)_localctx).number = prefix();
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

	public static class SuffixContext extends ParserRuleContext {
		public SuffixContext number;
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public SuffixContext suffix() {
			return getRuleContext(SuffixContext.class,0);
		}
		public SuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suffix; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitSuffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuffixContext suffix() throws RecognitionException {
		return suffix(0);
	}

	private SuffixContext suffix(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SuffixContext _localctx = new SuffixContext(_ctx, _parentState);
		SuffixContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_suffix, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(50);
			prefix();
			}
			_ctx.stop = _input.LT(-1);
			setState(56);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SuffixContext(_parentctx, _parentState);
					_localctx.number = _prevctx;
					_localctx.number = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_suffix);
					setState(52);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(53);
					match(T__4);
					}
					} 
				}
				setState(58);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MulDivContext extends ParserRuleContext {
		public MulDivContext left;
		public Token op;
		public SuffixContext right;
		public SuffixContext suffix() {
			return getRuleContext(SuffixContext.class,0);
		}
		public MulDivContext mulDiv() {
			return getRuleContext(MulDivContext.class,0);
		}
		public MulDivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulDiv; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulDivContext mulDiv() throws RecognitionException {
		return mulDiv(0);
	}

	private MulDivContext mulDiv(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulDivContext _localctx = new MulDivContext(_ctx, _parentState);
		MulDivContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_mulDiv, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(60);
			suffix(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(67);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulDivContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_mulDiv);
					setState(62);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(63);
					((MulDivContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__5 || _la==T__6) ) {
						((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(64);
					((MulDivContext)_localctx).right = suffix(0);
					}
					} 
				}
				setState(69);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AddSubContext extends ParserRuleContext {
		public AddSubContext left;
		public Token op;
		public MulDivContext right;
		public MulDivContext mulDiv() {
			return getRuleContext(MulDivContext.class,0);
		}
		public AddSubContext addSub() {
			return getRuleContext(AddSubContext.class,0);
		}
		public AddSubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addSub; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddSubContext addSub() throws RecognitionException {
		return addSub(0);
	}

	private AddSubContext addSub(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddSubContext _localctx = new AddSubContext(_ctx, _parentState);
		AddSubContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_addSub, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(71);
			mulDiv(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(78);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddSubContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_addSub);
					setState(73);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(74);
					((AddSubContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__3 || _la==T__7) ) {
						((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(75);
					((AddSubContext)_localctx).right = mulDiv(0);
					}
					} 
				}
				setState(80);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return implicitMul_sempred((ImplicitMulContext)_localctx, predIndex);
		case 5:
			return suffix_sempred((SuffixContext)_localctx, predIndex);
		case 6:
			return mulDiv_sempred((MulDivContext)_localctx, predIndex);
		case 7:
			return addSub_sempred((AddSubContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean implicitMul_sempred(ImplicitMulContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean suffix_sempred(SuffixContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean mulDiv_sempred(MulDivContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean addSub_sempred(AddSubContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\fT\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\5\2\25\n\2"+
		"\3\3\3\3\3\3\3\3\3\3\5\3\34\n\3\3\4\3\4\3\4\3\4\3\4\5\4#\n\4\3\5\3\5\3"+
		"\5\3\5\3\5\7\5*\n\5\f\5\16\5-\13\5\3\6\3\6\3\6\5\6\62\n\6\3\7\3\7\3\7"+
		"\3\7\3\7\7\79\n\7\f\7\16\7<\13\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bD\n\b\f\b"+
		"\16\bG\13\b\3\t\3\t\3\t\3\t\3\t\3\t\7\tO\n\t\f\t\16\tR\13\t\3\t\2\6\b"+
		"\f\16\20\n\2\4\6\b\n\f\16\20\2\4\3\2\b\t\4\2\6\6\n\n\2S\2\24\3\2\2\2\4"+
		"\33\3\2\2\2\6\"\3\2\2\2\b$\3\2\2\2\n\61\3\2\2\2\f\63\3\2\2\2\16=\3\2\2"+
		"\2\20H\3\2\2\2\22\25\5\20\t\2\23\25\7\2\2\3\24\22\3\2\2\2\24\23\3\2\2"+
		"\2\25\3\3\2\2\2\26\34\7\13\2\2\27\30\7\3\2\2\30\31\5\20\t\2\31\32\7\4"+
		"\2\2\32\34\3\2\2\2\33\26\3\2\2\2\33\27\3\2\2\2\34\5\3\2\2\2\35#\5\4\3"+
		"\2\36\37\5\4\3\2\37 \7\5\2\2 !\5\6\4\2!#\3\2\2\2\"\35\3\2\2\2\"\36\3\2"+
		"\2\2#\7\3\2\2\2$%\b\5\1\2%&\5\6\4\2&+\3\2\2\2\'(\f\3\2\2(*\5\6\4\2)\'"+
		"\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\t\3\2\2\2-+\3\2\2\2.\62\5\b\5"+
		"\2/\60\7\6\2\2\60\62\5\n\6\2\61.\3\2\2\2\61/\3\2\2\2\62\13\3\2\2\2\63"+
		"\64\b\7\1\2\64\65\5\n\6\2\65:\3\2\2\2\66\67\f\3\2\2\679\7\7\2\28\66\3"+
		"\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\r\3\2\2\2<:\3\2\2\2=>\b\b\1\2>?"+
		"\5\f\7\2?E\3\2\2\2@A\f\3\2\2AB\t\2\2\2BD\5\f\7\2C@\3\2\2\2DG\3\2\2\2E"+
		"C\3\2\2\2EF\3\2\2\2F\17\3\2\2\2GE\3\2\2\2HI\b\t\1\2IJ\5\16\b\2JP\3\2\2"+
		"\2KL\f\3\2\2LM\t\3\2\2MO\5\16\b\2NK\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2"+
		"\2\2Q\21\3\2\2\2RP\3\2\2\2\n\24\33\"+\61:EP";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}