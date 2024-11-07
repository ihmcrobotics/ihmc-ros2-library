// Generated from F:\GitRepos\ihmc-pub-sub\eprosima-idl-parser\src\main\antlr4\omg\IDL.g4 by ANTLR 4.2.2
package com.eprosima.idl.parser.grammar;

    //package com.eprosima.idl.parser.grammar;
    
    import com.eprosima.idl.context.Context;
    import com.eprosima.idl.generator.manager.TemplateManager;
    import com.eprosima.idl.generator.manager.TemplateGroup;
    import com.eprosima.idl.generator.manager.TemplateUtil;
    import com.eprosima.idl.parser.typecode.*;
    import com.eprosima.idl.parser.tree.*;
    import com.eprosima.idl.util.Pair;
    import com.eprosima.idl.parser.strategy.DefaultErrorStrategy;
    import com.eprosima.idl.parser.listener.DefaultErrorListener;
    import com.eprosima.idl.parser.exception.ParseException;

    import java.util.Vector;
    import java.util.ArrayList;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IDLLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__1=1, T__0=2, INTEGER_LITERAL=3, OCTAL_LITERAL=4, HEX_LITERAL=5, FLOATING_PT_LITERAL=6, 
		FIXED_PT_LITERAL=7, WIDE_CHARACTER_LITERAL=8, CHARACTER_LITERAL=9, WIDE_STRING_LITERAL=10, 
		STRING_LITERAL=11, BOOLEAN_LITERAL=12, SEMICOLON=13, COLON=14, COMA=15, 
		LEFT_BRACE=16, RIGHT_BRACE=17, LEFT_BRACKET=18, RIGHT_BRACKET=19, LEFT_SQUARE_BRACKET=20, 
		RIGHT_SQUARE_BRACKET=21, TILDE=22, SLASH=23, LEFT_ANG_BRACKET=24, RIGHT_ANG_BRACKET=25, 
		STAR=26, PLUS=27, MINUS=28, CARET=29, AMPERSAND=30, PIPE=31, EQUAL=32, 
		PERCENT=33, AT=34, DOUBLE_COLON=35, RIGHT_SHIFT=36, LEFT_SHIFT=37, KW_SETRAISES=38, 
		KW_OUT=39, KW_EMITS=40, KW_STRING=41, KW_SWITCH=42, KW_PUBLISHES=43, KW_TYPEDEF=44, 
		KW_USES=45, KW_PRIMARYKEY=46, KW_CUSTOM=47, KW_OCTET=48, KW_SEQUENCE=49, 
		KW_IMPORT=50, KW_STRUCT=51, KW_NATIVE=52, KW_READONLY=53, KW_FINDER=54, 
		KW_RAISES=55, KW_VOID=56, KW_PRIVATE=57, KW_EVENTTYPE=58, KW_WCHAR=59, 
		KW_IN=60, KW_DEFAULT=61, KW_PUBLIC=62, KW_SHORT=63, KW_LONG=64, KW_ENUM=65, 
		KW_WSTRING=66, KW_CONTEXT=67, KW_HOME=68, KW_FACTORY=69, KW_EXCEPTION=70, 
		KW_GETRAISES=71, KW_CONST=72, KW_VALUEBASE=73, KW_VALUETYPE=74, KW_SUPPORTS=75, 
		KW_MODULE=76, KW_OBJECT=77, KW_TRUNCATABLE=78, KW_UNSIGNED=79, KW_FIXED=80, 
		KW_UNION=81, KW_ONEWAY=82, KW_ANY=83, KW_CHAR=84, KW_CASE=85, KW_FLOAT=86, 
		KW_BOOLEAN=87, KW_MULTIPLE=88, KW_ABSTRACT=89, KW_INOUT=90, KW_PROVIDES=91, 
		KW_CONSUMES=92, KW_DOUBLE=93, KW_TYPEPREFIX=94, KW_TYPEID=95, KW_ATTRIBUTE=96, 
		KW_LOCAL=97, KW_MANAGES=98, KW_INTERFACE=99, KW_COMPONENT=100, KW_AT_ANNOTATION=101, 
		ID=102, WS=103, PREPROC_DIRECTIVE=104, COMMENT=105, LINE_COMMENT=106;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'FALSE'", "'TRUE'", "INTEGER_LITERAL", "OCTAL_LITERAL", "HEX_LITERAL", 
		"FLOATING_PT_LITERAL", "FIXED_PT_LITERAL", "WIDE_CHARACTER_LITERAL", "CHARACTER_LITERAL", 
		"WIDE_STRING_LITERAL", "STRING_LITERAL", "BOOLEAN_LITERAL", "';'", "':'", 
		"','", "'{'", "'}'", "'('", "')'", "'['", "']'", "'~'", "'/'", "'<'", 
		"'>'", "'*'", "'+'", "'-'", "'^'", "'&'", "'|'", "'='", "'%'", "'@'", 
		"'::'", "'>>'", "'<<'", "'setraises'", "'out'", "'emits'", "'string'", 
		"'switch'", "'publishes'", "'typedef'", "'uses'", "'primarykey'", "'custom'", 
		"'octet'", "'sequence'", "'import'", "'struct'", "'native'", "'readonly'", 
		"'finder'", "'raises'", "'void'", "'private'", "'eventtype'", "'wchar'", 
		"'in'", "'default'", "'public'", "'short'", "'long'", "'enum'", "'wstring'", 
		"'context'", "'home'", "'factory'", "'exception'", "'getraises'", "'const'", 
		"'ValueBase'", "'valuetype'", "'supports'", "'module'", "'Object'", "'truncatable'", 
		"'unsigned'", "'fixed'", "'union'", "'oneway'", "'any'", "'char'", "'case'", 
		"'float'", "'boolean'", "'multiple'", "'abstract'", "'inout'", "'provides'", 
		"'consumes'", "'double'", "'typeprefix'", "'typeid'", "'attribute'", "'local'", 
		"'manages'", "'interface'", "'component'", "'@annotation'", "ID", "WS", 
		"PREPROC_DIRECTIVE", "COMMENT", "LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__1", "T__0", "INTEGER_LITERAL", "OCTAL_LITERAL", "HEX_LITERAL", "HEX_DIGIT", 
		"INTEGER_TYPE_SUFFIX", "FLOATING_PT_LITERAL", "FIXED_PT_LITERAL", "EXPONENT", 
		"FLOAT_TYPE_SUFFIX", "WIDE_CHARACTER_LITERAL", "CHARACTER_LITERAL", "WIDE_STRING_LITERAL", 
		"STRING_LITERAL", "BOOLEAN_LITERAL", "ESCAPE_SEQUENCE", "OCTAL_ESCAPE", 
		"UNICODE_ESCAPE", "LETTER", "ID_DIGIT", "SEMICOLON", "COLON", "COMA", 
		"LEFT_BRACE", "RIGHT_BRACE", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_SQUARE_BRACKET", 
		"RIGHT_SQUARE_BRACKET", "TILDE", "SLASH", "LEFT_ANG_BRACKET", "RIGHT_ANG_BRACKET", 
		"STAR", "PLUS", "MINUS", "CARET", "AMPERSAND", "PIPE", "EQUAL", "PERCENT", 
		"AT", "DOUBLE_COLON", "RIGHT_SHIFT", "LEFT_SHIFT", "KW_SETRAISES", "KW_OUT", 
		"KW_EMITS", "KW_STRING", "KW_SWITCH", "KW_PUBLISHES", "KW_TYPEDEF", "KW_USES", 
		"KW_PRIMARYKEY", "KW_CUSTOM", "KW_OCTET", "KW_SEQUENCE", "KW_IMPORT", 
		"KW_STRUCT", "KW_NATIVE", "KW_READONLY", "KW_FINDER", "KW_RAISES", "KW_VOID", 
		"KW_PRIVATE", "KW_EVENTTYPE", "KW_WCHAR", "KW_IN", "KW_DEFAULT", "KW_PUBLIC", 
		"KW_SHORT", "KW_LONG", "KW_ENUM", "KW_WSTRING", "KW_CONTEXT", "KW_HOME", 
		"KW_FACTORY", "KW_EXCEPTION", "KW_GETRAISES", "KW_CONST", "KW_VALUEBASE", 
		"KW_VALUETYPE", "KW_SUPPORTS", "KW_MODULE", "KW_OBJECT", "KW_TRUNCATABLE", 
		"KW_UNSIGNED", "KW_FIXED", "KW_UNION", "KW_ONEWAY", "KW_ANY", "KW_CHAR", 
		"KW_CASE", "KW_FLOAT", "KW_BOOLEAN", "KW_MULTIPLE", "KW_ABSTRACT", "KW_INOUT", 
		"KW_PROVIDES", "KW_CONSUMES", "KW_DOUBLE", "KW_TYPEPREFIX", "KW_TYPEID", 
		"KW_ATTRIBUTE", "KW_LOCAL", "KW_MANAGES", "KW_INTERFACE", "KW_COMPONENT", 
		"KW_AT_ANNOTATION", "ID", "WS", "PREPROC_DIRECTIVE", "COMMENT", "LINE_COMMENT"
	};


	    public static final int COMMENTS = 2;

	    Context ctx = null;
	    
	    public void setContext(Context _ctx)
	    {
	        ctx = _ctx;
	    }


	public IDLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IDL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 112: PREPROC_DIRECTIVE_action((RuleContext)_localctx, actionIndex); break;

		case 113: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 114: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: _channel = COMMENTS; break;
		}
	}
	private void PREPROC_DIRECTIVE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  
				ctx.processPreprocessorLine(new String(getText()), getLine());
				skip();
				//newline();
			 break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: _channel = COMMENTS; break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2l\u03e5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4\u00f8\n\4\f\4\16\4\u00fb"+
		"\13\4\5\4\u00fd\n\4\3\4\5\4\u0100\n\4\3\5\3\5\6\5\u0104\n\5\r\5\16\5\u0105"+
		"\3\5\5\5\u0109\n\5\3\6\3\6\3\6\6\6\u010e\n\6\r\6\16\6\u010f\3\6\5\6\u0113"+
		"\n\6\3\7\3\7\3\b\3\b\3\t\6\t\u011a\n\t\r\t\16\t\u011b\3\t\3\t\7\t\u0120"+
		"\n\t\f\t\16\t\u0123\13\t\3\t\5\t\u0126\n\t\3\t\5\t\u0129\n\t\3\t\3\t\6"+
		"\t\u012d\n\t\r\t\16\t\u012e\3\t\5\t\u0132\n\t\3\t\5\t\u0135\n\t\3\t\6"+
		"\t\u0138\n\t\r\t\16\t\u0139\3\t\3\t\5\t\u013e\n\t\3\t\6\t\u0141\n\t\r"+
		"\t\16\t\u0142\3\t\5\t\u0146\n\t\3\t\5\t\u0149\n\t\3\n\3\n\3\13\3\13\3"+
		"\13\5\13\u0150\n\13\3\13\6\13\u0153\n\13\r\13\16\13\u0154\3\f\3\f\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\5\16\u015f\n\16\3\16\3\16\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\7\20\u0169\n\20\f\20\16\20\u016c\13\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0179\n\21\3\22\3\22\3\22\3\22"+
		"\5\22\u017f\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u018a"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3"+
		")\3)\3*\3*\3+\3+\3,\3,\3-\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38\38\38\3"+
		"8\38\38\38\38\38\38\39\39\39\39\39\39\39\3:\3:\3:\3:\3:\3:\3;\3;\3;\3"+
		";\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3>\3>\3>\3"+
		">\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3A\3A\3A\3"+
		"A\3A\3A\3A\3B\3B\3B\3B\3B\3C\3C\3C\3C\3C\3C\3C\3C\3D\3D\3D\3D\3D\3D\3"+
		"D\3D\3D\3D\3E\3E\3E\3E\3E\3E\3F\3F\3F\3G\3G\3G\3G\3G\3G\3G\3G\3H\3H\3"+
		"H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3I\3J\3J\3J\3J\3J\3K\3K\3K\3K\3K\3L\3L\3"+
		"L\3L\3L\3L\3L\3L\3M\3M\3M\3M\3M\3M\3M\3M\3N\3N\3N\3N\3N\3O\3O\3O\3O\3"+
		"O\3O\3O\3O\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3"+
		"Q\3R\3R\3R\3R\3R\3R\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3T\3T\3T\3T\3T\3T\3"+
		"T\3T\3T\3T\3U\3U\3U\3U\3U\3U\3U\3U\3U\3V\3V\3V\3V\3V\3V\3V\3W\3W\3W\3"+
		"W\3W\3W\3W\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3"+
		"Y\3Y\3Z\3Z\3Z\3Z\3Z\3Z\3[\3[\3[\3[\3[\3[\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3"+
		"]\3]\3]\3]\3^\3^\3^\3^\3^\3_\3_\3_\3_\3_\3`\3`\3`\3`\3`\3`\3a\3a\3a\3"+
		"a\3a\3a\3a\3a\3b\3b\3b\3b\3b\3b\3b\3b\3b\3c\3c\3c\3c\3c\3c\3c\3c\3c\3"+
		"d\3d\3d\3d\3d\3d\3e\3e\3e\3e\3e\3e\3e\3e\3e\3f\3f\3f\3f\3f\3f\3f\3f\3"+
		"f\3g\3g\3g\3g\3g\3g\3g\3h\3h\3h\3h\3h\3h\3h\3h\3h\3h\3h\3i\3i\3i\3i\3"+
		"i\3i\3i\3j\3j\3j\3j\3j\3j\3j\3j\3j\3j\3k\3k\3k\3k\3k\3k\3l\3l\3l\3l\3"+
		"l\3l\3l\3l\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3n\3n\3n\3n\3n\3n\3n\3n\3n\3"+
		"n\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3p\3p\3p\7p\u03b5\np\fp\16p\u03b8"+
		"\13p\3q\3q\3q\3q\3r\3r\7r\u03c0\nr\fr\16r\u03c3\13r\3r\3r\3r\3s\3s\3s"+
		"\3s\7s\u03cc\ns\fs\16s\u03cf\13s\3s\3s\3s\3s\3s\3t\3t\3t\3t\7t\u03da\n"+
		"t\ft\16t\u03dd\13t\3t\5t\u03e0\nt\3t\3t\3t\3t\3\u03cd\2u\3\3\5\4\7\5\t"+
		"\6\13\7\r\2\17\2\21\b\23\t\25\2\27\2\31\n\33\13\35\f\37\r!\16#\2%\2\'"+
		"\2)\2+\2-\17/\20\61\21\63\22\65\23\67\249\25;\26=\27?\30A\31C\32E\33G"+
		"\34I\35K\36M\37O Q!S\"U#W$Y%[&]\'_(a)c*e+g,i-k.m/o\60q\61s\62u\63w\64"+
		"y\65{\66}\67\1778\u00819\u0083:\u0085;\u0087<\u0089=\u008b>\u008d?\u008f"+
		"@\u0091A\u0093B\u0095C\u0097D\u0099E\u009bF\u009dG\u009fH\u00a1I\u00a3"+
		"J\u00a5K\u00a7L\u00a9M\u00abN\u00adO\u00afP\u00b1Q\u00b3R\u00b5S\u00b7"+
		"T\u00b9U\u00bbV\u00bdW\u00bfX\u00c1Y\u00c3Z\u00c5[\u00c7\\\u00c9]\u00cb"+
		"^\u00cd_\u00cf`\u00d1a\u00d3b\u00d5c\u00d7d\u00d9e\u00dbf\u00ddg\u00df"+
		"h\u00e1i\u00e3j\u00e5k\u00e7l\3\2\17\4\2ZZzz\5\2\62;CHch\4\2NNnn\4\2G"+
		"Ggg\6\2FFHHffhh\4\2))^^\4\2$$^^\n\2$$))^^ddhhppttvv\16\2&&C\\aac|\u00c2"+
		"\u00d8\u00da\u00f8\u00fa\u2001\u3042\u3191\u3302\u3381\u3402\u3d2f\u4e02"+
		"\ua001\uf902\ufb01\21\2\62;\u0662\u066b\u06f2\u06fb\u0968\u0971\u09e8"+
		"\u09f1\u0a68\u0a71\u0ae8\u0af1\u0b68\u0b71\u0be9\u0bf1\u0c68\u0c71\u0ce8"+
		"\u0cf1\u0d68\u0d71\u0e52\u0e5b\u0ed2\u0edb\u1042\u104b\5\2\13\f\16\17"+
		"\"\"\3\2\f\f\4\2\f\f\17\17\u0401\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2"+
		"\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2"+
		"\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o"+
		"\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2"+
		"\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097"+
		"\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2"+
		"\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9"+
		"\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2"+
		"\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb"+
		"\3\2\2\2\2\u00bd\3\2\2\2\2\u00bf\3\2\2\2\2\u00c1\3\2\2\2\2\u00c3\3\2\2"+
		"\2\2\u00c5\3\2\2\2\2\u00c7\3\2\2\2\2\u00c9\3\2\2\2\2\u00cb\3\2\2\2\2\u00cd"+
		"\3\2\2\2\2\u00cf\3\2\2\2\2\u00d1\3\2\2\2\2\u00d3\3\2\2\2\2\u00d5\3\2\2"+
		"\2\2\u00d7\3\2\2\2\2\u00d9\3\2\2\2\2\u00db\3\2\2\2\2\u00dd\3\2\2\2\2\u00df"+
		"\3\2\2\2\2\u00e1\3\2\2\2\2\u00e3\3\2\2\2\2\u00e5\3\2\2\2\2\u00e7\3\2\2"+
		"\2\3\u00e9\3\2\2\2\5\u00ef\3\2\2\2\7\u00fc\3\2\2\2\t\u0101\3\2\2\2\13"+
		"\u010a\3\2\2\2\r\u0114\3\2\2\2\17\u0116\3\2\2\2\21\u0148\3\2\2\2\23\u014a"+
		"\3\2\2\2\25\u014c\3\2\2\2\27\u0156\3\2\2\2\31\u0158\3\2\2\2\33\u015b\3"+
		"\2\2\2\35\u0162\3\2\2\2\37\u0165\3\2\2\2!\u0178\3\2\2\2#\u017e\3\2\2\2"+
		"%\u0189\3\2\2\2\'\u018b\3\2\2\2)\u0192\3\2\2\2+\u0194\3\2\2\2-\u0196\3"+
		"\2\2\2/\u0198\3\2\2\2\61\u019a\3\2\2\2\63\u019c\3\2\2\2\65\u019e\3\2\2"+
		"\2\67\u01a0\3\2\2\29\u01a2\3\2\2\2;\u01a4\3\2\2\2=\u01a6\3\2\2\2?\u01a8"+
		"\3\2\2\2A\u01aa\3\2\2\2C\u01ac\3\2\2\2E\u01ae\3\2\2\2G\u01b0\3\2\2\2I"+
		"\u01b2\3\2\2\2K\u01b4\3\2\2\2M\u01b6\3\2\2\2O\u01b8\3\2\2\2Q\u01ba\3\2"+
		"\2\2S\u01bc\3\2\2\2U\u01be\3\2\2\2W\u01c0\3\2\2\2Y\u01c2\3\2\2\2[\u01c5"+
		"\3\2\2\2]\u01c8\3\2\2\2_\u01cb\3\2\2\2a\u01d5\3\2\2\2c\u01d9\3\2\2\2e"+
		"\u01df\3\2\2\2g\u01e6\3\2\2\2i\u01ed\3\2\2\2k\u01f7\3\2\2\2m\u01ff\3\2"+
		"\2\2o\u0204\3\2\2\2q\u020f\3\2\2\2s\u0216\3\2\2\2u\u021c\3\2\2\2w\u0225"+
		"\3\2\2\2y\u022c\3\2\2\2{\u0233\3\2\2\2}\u023a\3\2\2\2\177\u0243\3\2\2"+
		"\2\u0081\u024a\3\2\2\2\u0083\u0251\3\2\2\2\u0085\u0256\3\2\2\2\u0087\u025e"+
		"\3\2\2\2\u0089\u0268\3\2\2\2\u008b\u026e\3\2\2\2\u008d\u0271\3\2\2\2\u008f"+
		"\u0279\3\2\2\2\u0091\u0280\3\2\2\2\u0093\u0286\3\2\2\2\u0095\u028b\3\2"+
		"\2\2\u0097\u0290\3\2\2\2\u0099\u0298\3\2\2\2\u009b\u02a0\3\2\2\2\u009d"+
		"\u02a5\3\2\2\2\u009f\u02ad\3\2\2\2\u00a1\u02b7\3\2\2\2\u00a3\u02c1\3\2"+
		"\2\2\u00a5\u02c7\3\2\2\2\u00a7\u02d1\3\2\2\2\u00a9\u02db\3\2\2\2\u00ab"+
		"\u02e4\3\2\2\2\u00ad\u02eb\3\2\2\2\u00af\u02f2\3\2\2\2\u00b1\u02fe\3\2"+
		"\2\2\u00b3\u0307\3\2\2\2\u00b5\u030d\3\2\2\2\u00b7\u0313\3\2\2\2\u00b9"+
		"\u031a\3\2\2\2\u00bb\u031e\3\2\2\2\u00bd\u0323\3\2\2\2\u00bf\u0328\3\2"+
		"\2\2\u00c1\u032e\3\2\2\2\u00c3\u0336\3\2\2\2\u00c5\u033f\3\2\2\2\u00c7"+
		"\u0348\3\2\2\2\u00c9\u034e\3\2\2\2\u00cb\u0357\3\2\2\2\u00cd\u0360\3\2"+
		"\2\2\u00cf\u0367\3\2\2\2\u00d1\u0372\3\2\2\2\u00d3\u0379\3\2\2\2\u00d5"+
		"\u0383\3\2\2\2\u00d7\u0389\3\2\2\2\u00d9\u0391\3\2\2\2\u00db\u039b\3\2"+
		"\2\2\u00dd\u03a5\3\2\2\2\u00df\u03b1\3\2\2\2\u00e1\u03b9\3\2\2\2\u00e3"+
		"\u03bd\3\2\2\2\u00e5\u03c7\3\2\2\2\u00e7\u03d5\3\2\2\2\u00e9\u00ea\7H"+
		"\2\2\u00ea\u00eb\7C\2\2\u00eb\u00ec\7N\2\2\u00ec\u00ed\7U\2\2\u00ed\u00ee"+
		"\7G\2\2\u00ee\4\3\2\2\2\u00ef\u00f0\7V\2\2\u00f0\u00f1\7T\2\2\u00f1\u00f2"+
		"\7W\2\2\u00f2\u00f3\7G\2\2\u00f3\6\3\2\2\2\u00f4\u00fd\7\62\2\2\u00f5"+
		"\u00f9\4\63;\2\u00f6\u00f8\4\62;\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3\2"+
		"\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb"+
		"\u00f9\3\2\2\2\u00fc\u00f4\3\2\2\2\u00fc\u00f5\3\2\2\2\u00fd\u00ff\3\2"+
		"\2\2\u00fe\u0100\5\17\b\2\u00ff\u00fe\3\2\2\2\u00ff\u0100\3\2\2\2\u0100"+
		"\b\3\2\2\2\u0101\u0103\7\62\2\2\u0102\u0104\4\629\2\u0103\u0102\3\2\2"+
		"\2\u0104\u0105\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108"+
		"\3\2\2\2\u0107\u0109\5\17\b\2\u0108\u0107\3\2\2\2\u0108\u0109\3\2\2\2"+
		"\u0109\n\3\2\2\2\u010a\u010b\7\62\2\2\u010b\u010d\t\2\2\2\u010c\u010e"+
		"\5\r\7\2\u010d\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u010d\3\2\2\2\u010f"+
		"\u0110\3\2\2\2\u0110\u0112\3\2\2\2\u0111\u0113\5\17\b\2\u0112\u0111\3"+
		"\2\2\2\u0112\u0113\3\2\2\2\u0113\f\3\2\2\2\u0114\u0115\t\3\2\2\u0115\16"+
		"\3\2\2\2\u0116\u0117\t\4\2\2\u0117\20\3\2\2\2\u0118\u011a\4\62;\2\u0119"+
		"\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2"+
		"\2\2\u011c\u011d\3\2\2\2\u011d\u0121\7\60\2\2\u011e\u0120\4\62;\2\u011f"+
		"\u011e\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2"+
		"\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0126\5\25\13\2\u0125"+
		"\u0124\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0128\3\2\2\2\u0127\u0129\5\27"+
		"\f\2\u0128\u0127\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u0149\3\2\2\2\u012a"+
		"\u012c\7\60\2\2\u012b\u012d\4\62;\2\u012c\u012b\3\2\2\2\u012d\u012e\3"+
		"\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0131\3\2\2\2\u0130"+
		"\u0132\5\25\13\2\u0131\u0130\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134\3"+
		"\2\2\2\u0133\u0135\5\27\f\2\u0134\u0133\3\2\2\2\u0134\u0135\3\2\2\2\u0135"+
		"\u0149\3\2\2\2\u0136\u0138\4\62;\2\u0137\u0136\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013b\3\2\2\2\u013b"+
		"\u013d\5\25\13\2\u013c\u013e\5\27\f\2\u013d\u013c\3\2\2\2\u013d\u013e"+
		"\3\2\2\2\u013e\u0149\3\2\2\2\u013f\u0141\4\62;\2\u0140\u013f\3\2\2\2\u0141"+
		"\u0142\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0145\3\2"+
		"\2\2\u0144\u0146\5\25\13\2\u0145\u0144\3\2\2\2\u0145\u0146\3\2\2\2\u0146"+
		"\u0147\3\2\2\2\u0147\u0149\5\27\f\2\u0148\u0119\3\2\2\2\u0148\u012a\3"+
		"\2\2\2\u0148\u0137\3\2\2\2\u0148\u0140\3\2\2\2\u0149\22\3\2\2\2\u014a"+
		"\u014b\5\21\t\2\u014b\24\3\2\2\2\u014c\u014f\t\5\2\2\u014d\u0150\5I%\2"+
		"\u014e\u0150\5K&\2\u014f\u014d\3\2\2\2\u014f\u014e\3\2\2\2\u014f\u0150"+
		"\3\2\2\2\u0150\u0152\3\2\2\2\u0151\u0153\4\62;\2\u0152\u0151\3\2\2\2\u0153"+
		"\u0154\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\26\3\2\2"+
		"\2\u0156\u0157\t\6\2\2\u0157\30\3\2\2\2\u0158\u0159\7N\2\2\u0159\u015a"+
		"\5\33\16\2\u015a\32\3\2\2\2\u015b\u015e\7)\2\2\u015c\u015f\5#\22\2\u015d"+
		"\u015f\n\7\2\2\u015e\u015c\3\2\2\2\u015e\u015d\3\2\2\2\u015f\u0160\3\2"+
		"\2\2\u0160\u0161\7)\2\2\u0161\34\3\2\2\2\u0162\u0163\7N\2\2\u0163\u0164"+
		"\5\37\20\2\u0164\36\3\2\2\2\u0165\u016a\7$\2\2\u0166\u0169\5#\22\2\u0167"+
		"\u0169\n\b\2\2\u0168\u0166\3\2\2\2\u0168\u0167\3\2\2\2\u0169\u016c\3\2"+
		"\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016d\3\2\2\2\u016c"+
		"\u016a\3\2\2\2\u016d\u016e\7$\2\2\u016e \3\2\2\2\u016f\u0170\7V\2\2\u0170"+
		"\u0171\7T\2\2\u0171\u0172\7W\2\2\u0172\u0179\7G\2\2\u0173\u0174\7H\2\2"+
		"\u0174\u0175\7C\2\2\u0175\u0176\7N\2\2\u0176\u0177\7U\2\2\u0177\u0179"+
		"\7G\2\2\u0178\u016f\3\2\2\2\u0178\u0173\3\2\2\2\u0179\"\3\2\2\2\u017a"+
		"\u017b\7^\2\2\u017b\u017f\t\t\2\2\u017c\u017f\5\'\24\2\u017d\u017f\5%"+
		"\23\2\u017e\u017a\3\2\2\2\u017e\u017c\3\2\2\2\u017e\u017d\3\2\2\2\u017f"+
		"$\3\2\2\2\u0180\u0181\7^\2\2\u0181\u0182\4\62\65\2\u0182\u0183\4\629\2"+
		"\u0183\u018a\4\629\2\u0184\u0185\7^\2\2\u0185\u0186\4\629\2\u0186\u018a"+
		"\4\629\2\u0187\u0188\7^\2\2\u0188\u018a\4\629\2\u0189\u0180\3\2\2\2\u0189"+
		"\u0184\3\2\2\2\u0189\u0187\3\2\2\2\u018a&\3\2\2\2\u018b\u018c\7^\2\2\u018c"+
		"\u018d\7w\2\2\u018d\u018e\5\r\7\2\u018e\u018f\5\r\7\2\u018f\u0190\5\r"+
		"\7\2\u0190\u0191\5\r\7\2\u0191(\3\2\2\2\u0192\u0193\t\n\2\2\u0193*\3\2"+
		"\2\2\u0194\u0195\t\13\2\2\u0195,\3\2\2\2\u0196\u0197\7=\2\2\u0197.\3\2"+
		"\2\2\u0198\u0199\7<\2\2\u0199\60\3\2\2\2\u019a\u019b\7.\2\2\u019b\62\3"+
		"\2\2\2\u019c\u019d\7}\2\2\u019d\64\3\2\2\2\u019e\u019f\7\177\2\2\u019f"+
		"\66\3\2\2\2\u01a0\u01a1\7*\2\2\u01a18\3\2\2\2\u01a2\u01a3\7+\2\2\u01a3"+
		":\3\2\2\2\u01a4\u01a5\7]\2\2\u01a5<\3\2\2\2\u01a6\u01a7\7_\2\2\u01a7>"+
		"\3\2\2\2\u01a8\u01a9\7\u0080\2\2\u01a9@\3\2\2\2\u01aa\u01ab\7\61\2\2\u01ab"+
		"B\3\2\2\2\u01ac\u01ad\7>\2\2\u01adD\3\2\2\2\u01ae\u01af\7@\2\2\u01afF"+
		"\3\2\2\2\u01b0\u01b1\7,\2\2\u01b1H\3\2\2\2\u01b2\u01b3\7-\2\2\u01b3J\3"+
		"\2\2\2\u01b4\u01b5\7/\2\2\u01b5L\3\2\2\2\u01b6\u01b7\7`\2\2\u01b7N\3\2"+
		"\2\2\u01b8\u01b9\7(\2\2\u01b9P\3\2\2\2\u01ba\u01bb\7~\2\2\u01bbR\3\2\2"+
		"\2\u01bc\u01bd\7?\2\2\u01bdT\3\2\2\2\u01be\u01bf\7\'\2\2\u01bfV\3\2\2"+
		"\2\u01c0\u01c1\7B\2\2\u01c1X\3\2\2\2\u01c2\u01c3\7<\2\2\u01c3\u01c4\7"+
		"<\2\2\u01c4Z\3\2\2\2\u01c5\u01c6\7@\2\2\u01c6\u01c7\7@\2\2\u01c7\\\3\2"+
		"\2\2\u01c8\u01c9\7>\2\2\u01c9\u01ca\7>\2\2\u01ca^\3\2\2\2\u01cb\u01cc"+
		"\7u\2\2\u01cc\u01cd\7g\2\2\u01cd\u01ce\7v\2\2\u01ce\u01cf\7t\2\2\u01cf"+
		"\u01d0\7c\2\2\u01d0\u01d1\7k\2\2\u01d1\u01d2\7u\2\2\u01d2\u01d3\7g\2\2"+
		"\u01d3\u01d4\7u\2\2\u01d4`\3\2\2\2\u01d5\u01d6\7q\2\2\u01d6\u01d7\7w\2"+
		"\2\u01d7\u01d8\7v\2\2\u01d8b\3\2\2\2\u01d9\u01da\7g\2\2\u01da\u01db\7"+
		"o\2\2\u01db\u01dc\7k\2\2\u01dc\u01dd\7v\2\2\u01dd\u01de\7u\2\2\u01ded"+
		"\3\2\2\2\u01df\u01e0\7u\2\2\u01e0\u01e1\7v\2\2\u01e1\u01e2\7t\2\2\u01e2"+
		"\u01e3\7k\2\2\u01e3\u01e4\7p\2\2\u01e4\u01e5\7i\2\2\u01e5f\3\2\2\2\u01e6"+
		"\u01e7\7u\2\2\u01e7\u01e8\7y\2\2\u01e8\u01e9\7k\2\2\u01e9\u01ea\7v\2\2"+
		"\u01ea\u01eb\7e\2\2\u01eb\u01ec\7j\2\2\u01ech\3\2\2\2\u01ed\u01ee\7r\2"+
		"\2\u01ee\u01ef\7w\2\2\u01ef\u01f0\7d\2\2\u01f0\u01f1\7n\2\2\u01f1\u01f2"+
		"\7k\2\2\u01f2\u01f3\7u\2\2\u01f3\u01f4\7j\2\2\u01f4\u01f5\7g\2\2\u01f5"+
		"\u01f6\7u\2\2\u01f6j\3\2\2\2\u01f7\u01f8\7v\2\2\u01f8\u01f9\7{\2\2\u01f9"+
		"\u01fa\7r\2\2\u01fa\u01fb\7g\2\2\u01fb\u01fc\7f\2\2\u01fc\u01fd\7g\2\2"+
		"\u01fd\u01fe\7h\2\2\u01fel\3\2\2\2\u01ff\u0200\7w\2\2\u0200\u0201\7u\2"+
		"\2\u0201\u0202\7g\2\2\u0202\u0203\7u\2\2\u0203n\3\2\2\2\u0204\u0205\7"+
		"r\2\2\u0205\u0206\7t\2\2\u0206\u0207\7k\2\2\u0207\u0208\7o\2\2\u0208\u0209"+
		"\7c\2\2\u0209\u020a\7t\2\2\u020a\u020b\7{\2\2\u020b\u020c\7m\2\2\u020c"+
		"\u020d\7g\2\2\u020d\u020e\7{\2\2\u020ep\3\2\2\2\u020f\u0210\7e\2\2\u0210"+
		"\u0211\7w\2\2\u0211\u0212\7u\2\2\u0212\u0213\7v\2\2\u0213\u0214\7q\2\2"+
		"\u0214\u0215\7o\2\2\u0215r\3\2\2\2\u0216\u0217\7q\2\2\u0217\u0218\7e\2"+
		"\2\u0218\u0219\7v\2\2\u0219\u021a\7g\2\2\u021a\u021b\7v\2\2\u021bt\3\2"+
		"\2\2\u021c\u021d\7u\2\2\u021d\u021e\7g\2\2\u021e\u021f\7s\2\2\u021f\u0220"+
		"\7w\2\2\u0220\u0221\7g\2\2\u0221\u0222\7p\2\2\u0222\u0223\7e\2\2\u0223"+
		"\u0224\7g\2\2\u0224v\3\2\2\2\u0225\u0226\7k\2\2\u0226\u0227\7o\2\2\u0227"+
		"\u0228\7r\2\2\u0228\u0229\7q\2\2\u0229\u022a\7t\2\2\u022a\u022b\7v\2\2"+
		"\u022bx\3\2\2\2\u022c\u022d\7u\2\2\u022d\u022e\7v\2\2\u022e\u022f\7t\2"+
		"\2\u022f\u0230\7w\2\2\u0230\u0231\7e\2\2\u0231\u0232\7v\2\2\u0232z\3\2"+
		"\2\2\u0233\u0234\7p\2\2\u0234\u0235\7c\2\2\u0235\u0236\7v\2\2\u0236\u0237"+
		"\7k\2\2\u0237\u0238\7x\2\2\u0238\u0239\7g\2\2\u0239|\3\2\2\2\u023a\u023b"+
		"\7t\2\2\u023b\u023c\7g\2\2\u023c\u023d\7c\2\2\u023d\u023e\7f\2\2\u023e"+
		"\u023f\7q\2\2\u023f\u0240\7p\2\2\u0240\u0241\7n\2\2\u0241\u0242\7{\2\2"+
		"\u0242~\3\2\2\2\u0243\u0244\7h\2\2\u0244\u0245\7k\2\2\u0245\u0246\7p\2"+
		"\2\u0246\u0247\7f\2\2\u0247\u0248\7g\2\2\u0248\u0249\7t\2\2\u0249\u0080"+
		"\3\2\2\2\u024a\u024b\7t\2\2\u024b\u024c\7c\2\2\u024c\u024d\7k\2\2\u024d"+
		"\u024e\7u\2\2\u024e\u024f\7g\2\2\u024f\u0250\7u\2\2\u0250\u0082\3\2\2"+
		"\2\u0251\u0252\7x\2\2\u0252\u0253\7q\2\2\u0253\u0254\7k\2\2\u0254\u0255"+
		"\7f\2\2\u0255\u0084\3\2\2\2\u0256\u0257\7r\2\2\u0257\u0258\7t\2\2\u0258"+
		"\u0259\7k\2\2\u0259\u025a\7x\2\2\u025a\u025b\7c\2\2\u025b\u025c\7v\2\2"+
		"\u025c\u025d\7g\2\2\u025d\u0086\3\2\2\2\u025e\u025f\7g\2\2\u025f\u0260"+
		"\7x\2\2\u0260\u0261\7g\2\2\u0261\u0262\7p\2\2\u0262\u0263\7v\2\2\u0263"+
		"\u0264\7v\2\2\u0264\u0265\7{\2\2\u0265\u0266\7r\2\2\u0266\u0267\7g\2\2"+
		"\u0267\u0088\3\2\2\2\u0268\u0269\7y\2\2\u0269\u026a\7e\2\2\u026a\u026b"+
		"\7j\2\2\u026b\u026c\7c\2\2\u026c\u026d\7t\2\2\u026d\u008a\3\2\2\2\u026e"+
		"\u026f\7k\2\2\u026f\u0270\7p\2\2\u0270\u008c\3\2\2\2\u0271\u0272\7f\2"+
		"\2\u0272\u0273\7g\2\2\u0273\u0274\7h\2\2\u0274\u0275\7c\2\2\u0275\u0276"+
		"\7w\2\2\u0276\u0277\7n\2\2\u0277\u0278\7v\2\2\u0278\u008e\3\2\2\2\u0279"+
		"\u027a\7r\2\2\u027a\u027b\7w\2\2\u027b\u027c\7d\2\2\u027c\u027d\7n\2\2"+
		"\u027d\u027e\7k\2\2\u027e\u027f\7e\2\2\u027f\u0090\3\2\2\2\u0280\u0281"+
		"\7u\2\2\u0281\u0282\7j\2\2\u0282\u0283\7q\2\2\u0283\u0284\7t\2\2\u0284"+
		"\u0285\7v\2\2\u0285\u0092\3\2\2\2\u0286\u0287\7n\2\2\u0287\u0288\7q\2"+
		"\2\u0288\u0289\7p\2\2\u0289\u028a\7i\2\2\u028a\u0094\3\2\2\2\u028b\u028c"+
		"\7g\2\2\u028c\u028d\7p\2\2\u028d\u028e\7w\2\2\u028e\u028f\7o\2\2\u028f"+
		"\u0096\3\2\2\2\u0290\u0291\7y\2\2\u0291\u0292\7u\2\2\u0292\u0293\7v\2"+
		"\2\u0293\u0294\7t\2\2\u0294\u0295\7k\2\2\u0295\u0296\7p\2\2\u0296\u0297"+
		"\7i\2\2\u0297\u0098\3\2\2\2\u0298\u0299\7e\2\2\u0299\u029a\7q\2\2\u029a"+
		"\u029b\7p\2\2\u029b\u029c\7v\2\2\u029c\u029d\7g\2\2\u029d\u029e\7z\2\2"+
		"\u029e\u029f\7v\2\2\u029f\u009a\3\2\2\2\u02a0\u02a1\7j\2\2\u02a1\u02a2"+
		"\7q\2\2\u02a2\u02a3\7o\2\2\u02a3\u02a4\7g\2\2\u02a4\u009c\3\2\2\2\u02a5"+
		"\u02a6\7h\2\2\u02a6\u02a7\7c\2\2\u02a7\u02a8\7e\2\2\u02a8\u02a9\7v\2\2"+
		"\u02a9\u02aa\7q\2\2\u02aa\u02ab\7t\2\2\u02ab\u02ac\7{\2\2\u02ac\u009e"+
		"\3\2\2\2\u02ad\u02ae\7g\2\2\u02ae\u02af\7z\2\2\u02af\u02b0\7e\2\2\u02b0"+
		"\u02b1\7g\2\2\u02b1\u02b2\7r\2\2\u02b2\u02b3\7v\2\2\u02b3\u02b4\7k\2\2"+
		"\u02b4\u02b5\7q\2\2\u02b5\u02b6\7p\2\2\u02b6\u00a0\3\2\2\2\u02b7\u02b8"+
		"\7i\2\2\u02b8\u02b9\7g\2\2\u02b9\u02ba\7v\2\2\u02ba\u02bb\7t\2\2\u02bb"+
		"\u02bc\7c\2\2\u02bc\u02bd\7k\2\2\u02bd\u02be\7u\2\2\u02be\u02bf\7g\2\2"+
		"\u02bf\u02c0\7u\2\2\u02c0\u00a2\3\2\2\2\u02c1\u02c2\7e\2\2\u02c2\u02c3"+
		"\7q\2\2\u02c3\u02c4\7p\2\2\u02c4\u02c5\7u\2\2\u02c5\u02c6\7v\2\2\u02c6"+
		"\u00a4\3\2\2\2\u02c7\u02c8\7X\2\2\u02c8\u02c9\7c\2\2\u02c9\u02ca\7n\2"+
		"\2\u02ca\u02cb\7w\2\2\u02cb\u02cc\7g\2\2\u02cc\u02cd\7D\2\2\u02cd\u02ce"+
		"\7c\2\2\u02ce\u02cf\7u\2\2\u02cf\u02d0\7g\2\2\u02d0\u00a6\3\2\2\2\u02d1"+
		"\u02d2\7x\2\2\u02d2\u02d3\7c\2\2\u02d3\u02d4\7n\2\2\u02d4\u02d5\7w\2\2"+
		"\u02d5\u02d6\7g\2\2\u02d6\u02d7\7v\2\2\u02d7\u02d8\7{\2\2\u02d8\u02d9"+
		"\7r\2\2\u02d9\u02da\7g\2\2\u02da\u00a8\3\2\2\2\u02db\u02dc\7u\2\2\u02dc"+
		"\u02dd\7w\2\2\u02dd\u02de\7r\2\2\u02de\u02df\7r\2\2\u02df\u02e0\7q\2\2"+
		"\u02e0\u02e1\7t\2\2\u02e1\u02e2\7v\2\2\u02e2\u02e3\7u\2\2\u02e3\u00aa"+
		"\3\2\2\2\u02e4\u02e5\7o\2\2\u02e5\u02e6\7q\2\2\u02e6\u02e7\7f\2\2\u02e7"+
		"\u02e8\7w\2\2\u02e8\u02e9\7n\2\2\u02e9\u02ea\7g\2\2\u02ea\u00ac\3\2\2"+
		"\2\u02eb\u02ec\7Q\2\2\u02ec\u02ed\7d\2\2\u02ed\u02ee\7l\2\2\u02ee\u02ef"+
		"\7g\2\2\u02ef\u02f0\7e\2\2\u02f0\u02f1\7v\2\2\u02f1\u00ae\3\2\2\2\u02f2"+
		"\u02f3\7v\2\2\u02f3\u02f4\7t\2\2\u02f4\u02f5\7w\2\2\u02f5\u02f6\7p\2\2"+
		"\u02f6\u02f7\7e\2\2\u02f7\u02f8\7c\2\2\u02f8\u02f9\7v\2\2\u02f9\u02fa"+
		"\7c\2\2\u02fa\u02fb\7d\2\2\u02fb\u02fc\7n\2\2\u02fc\u02fd\7g\2\2\u02fd"+
		"\u00b0\3\2\2\2\u02fe\u02ff\7w\2\2\u02ff\u0300\7p\2\2\u0300\u0301\7u\2"+
		"\2\u0301\u0302\7k\2\2\u0302\u0303\7i\2\2\u0303\u0304\7p\2\2\u0304\u0305"+
		"\7g\2\2\u0305\u0306\7f\2\2\u0306\u00b2\3\2\2\2\u0307\u0308\7h\2\2\u0308"+
		"\u0309\7k\2\2\u0309\u030a\7z\2\2\u030a\u030b\7g\2\2\u030b\u030c\7f\2\2"+
		"\u030c\u00b4\3\2\2\2\u030d\u030e\7w\2\2\u030e\u030f\7p\2\2\u030f\u0310"+
		"\7k\2\2\u0310\u0311\7q\2\2\u0311\u0312\7p\2\2\u0312\u00b6\3\2\2\2\u0313"+
		"\u0314\7q\2\2\u0314\u0315\7p\2\2\u0315\u0316\7g\2\2\u0316\u0317\7y\2\2"+
		"\u0317\u0318\7c\2\2\u0318\u0319\7{\2\2\u0319\u00b8\3\2\2\2\u031a\u031b"+
		"\7c\2\2\u031b\u031c\7p\2\2\u031c\u031d\7{\2\2\u031d\u00ba\3\2\2\2\u031e"+
		"\u031f\7e\2\2\u031f\u0320\7j\2\2\u0320\u0321\7c\2\2\u0321\u0322\7t\2\2"+
		"\u0322\u00bc\3\2\2\2\u0323\u0324\7e\2\2\u0324\u0325\7c\2\2\u0325\u0326"+
		"\7u\2\2\u0326\u0327\7g\2\2\u0327\u00be\3\2\2\2\u0328\u0329\7h\2\2\u0329"+
		"\u032a\7n\2\2\u032a\u032b\7q\2\2\u032b\u032c\7c\2\2\u032c\u032d\7v\2\2"+
		"\u032d\u00c0\3\2\2\2\u032e\u032f\7d\2\2\u032f\u0330\7q\2\2\u0330\u0331"+
		"\7q\2\2\u0331\u0332\7n\2\2\u0332\u0333\7g\2\2\u0333\u0334\7c\2\2\u0334"+
		"\u0335\7p\2\2\u0335\u00c2\3\2\2\2\u0336\u0337\7o\2\2\u0337\u0338\7w\2"+
		"\2\u0338\u0339\7n\2\2\u0339\u033a\7v\2\2\u033a\u033b\7k\2\2\u033b\u033c"+
		"\7r\2\2\u033c\u033d\7n\2\2\u033d\u033e\7g\2\2\u033e\u00c4\3\2\2\2\u033f"+
		"\u0340\7c\2\2\u0340\u0341\7d\2\2\u0341\u0342\7u\2\2\u0342\u0343\7v\2\2"+
		"\u0343\u0344\7t\2\2\u0344\u0345\7c\2\2\u0345\u0346\7e\2\2\u0346\u0347"+
		"\7v\2\2\u0347\u00c6\3\2\2\2\u0348\u0349\7k\2\2\u0349\u034a\7p\2\2\u034a"+
		"\u034b\7q\2\2\u034b\u034c\7w\2\2\u034c\u034d\7v\2\2\u034d\u00c8\3\2\2"+
		"\2\u034e\u034f\7r\2\2\u034f\u0350\7t\2\2\u0350\u0351\7q\2\2\u0351\u0352"+
		"\7x\2\2\u0352\u0353\7k\2\2\u0353\u0354\7f\2\2\u0354\u0355\7g\2\2\u0355"+
		"\u0356\7u\2\2\u0356\u00ca\3\2\2\2\u0357\u0358\7e\2\2\u0358\u0359\7q\2"+
		"\2\u0359\u035a\7p\2\2\u035a\u035b\7u\2\2\u035b\u035c\7w\2\2\u035c\u035d"+
		"\7o\2\2\u035d\u035e\7g\2\2\u035e\u035f\7u\2\2\u035f\u00cc\3\2\2\2\u0360"+
		"\u0361\7f\2\2\u0361\u0362\7q\2\2\u0362\u0363\7w\2\2\u0363\u0364\7d\2\2"+
		"\u0364\u0365\7n\2\2\u0365\u0366\7g\2\2\u0366\u00ce\3\2\2\2\u0367\u0368"+
		"\7v\2\2\u0368\u0369\7{\2\2\u0369\u036a\7r\2\2\u036a\u036b\7g\2\2\u036b"+
		"\u036c\7r\2\2\u036c\u036d\7t\2\2\u036d\u036e\7g\2\2\u036e\u036f\7h\2\2"+
		"\u036f\u0370\7k\2\2\u0370\u0371\7z\2\2\u0371\u00d0\3\2\2\2\u0372\u0373"+
		"\7v\2\2\u0373\u0374\7{\2\2\u0374\u0375\7r\2\2\u0375\u0376\7g\2\2\u0376"+
		"\u0377\7k\2\2\u0377\u0378\7f\2\2\u0378\u00d2\3\2\2\2\u0379\u037a\7c\2"+
		"\2\u037a\u037b\7v\2\2\u037b\u037c\7v\2\2\u037c\u037d\7t\2\2\u037d\u037e"+
		"\7k\2\2\u037e\u037f\7d\2\2\u037f\u0380\7w\2\2\u0380\u0381\7v\2\2\u0381"+
		"\u0382\7g\2\2\u0382\u00d4\3\2\2\2\u0383\u0384\7n\2\2\u0384\u0385\7q\2"+
		"\2\u0385\u0386\7e\2\2\u0386\u0387\7c\2\2\u0387\u0388\7n\2\2\u0388\u00d6"+
		"\3\2\2\2\u0389\u038a\7o\2\2\u038a\u038b\7c\2\2\u038b\u038c\7p\2\2\u038c"+
		"\u038d\7c\2\2\u038d\u038e\7i\2\2\u038e\u038f\7g\2\2\u038f\u0390\7u\2\2"+
		"\u0390\u00d8\3\2\2\2\u0391\u0392\7k\2\2\u0392\u0393\7p\2\2\u0393\u0394"+
		"\7v\2\2\u0394\u0395\7g\2\2\u0395\u0396\7t\2\2\u0396\u0397\7h\2\2\u0397"+
		"\u0398\7c\2\2\u0398\u0399\7e\2\2\u0399\u039a\7g\2\2\u039a\u00da\3\2\2"+
		"\2\u039b\u039c\7e\2\2\u039c\u039d\7q\2\2\u039d\u039e\7o\2\2\u039e\u039f"+
		"\7r\2\2\u039f\u03a0\7q\2\2\u03a0\u03a1\7p\2\2\u03a1\u03a2\7g\2\2\u03a2"+
		"\u03a3\7p\2\2\u03a3\u03a4\7v\2\2\u03a4\u00dc\3\2\2\2\u03a5\u03a6\7B\2"+
		"\2\u03a6\u03a7\7c\2\2\u03a7\u03a8\7p\2\2\u03a8\u03a9\7p\2\2\u03a9\u03aa"+
		"\7q\2\2\u03aa\u03ab\7v\2\2\u03ab\u03ac\7c\2\2\u03ac\u03ad\7v\2\2\u03ad"+
		"\u03ae\7k\2\2\u03ae\u03af\7q\2\2\u03af\u03b0\7p\2\2\u03b0\u00de\3\2\2"+
		"\2\u03b1\u03b6\5)\25\2\u03b2\u03b5\5)\25\2\u03b3\u03b5\5+\26\2\u03b4\u03b2"+
		"\3\2\2\2\u03b4\u03b3\3\2\2\2\u03b5\u03b8\3\2\2\2\u03b6\u03b4\3\2\2\2\u03b6"+
		"\u03b7\3\2\2\2\u03b7\u00e0\3\2\2\2\u03b8\u03b6\3\2\2\2\u03b9\u03ba\t\f"+
		"\2\2\u03ba\u03bb\3\2\2\2\u03bb\u03bc\bq\2\2\u03bc\u00e2\3\2\2\2\u03bd"+
		"\u03c1\7%\2\2\u03be\u03c0\n\r\2\2\u03bf\u03be\3\2\2\2\u03c0\u03c3\3\2"+
		"\2\2\u03c1\u03bf\3\2\2\2\u03c1\u03c2\3\2\2\2\u03c2\u03c4\3\2\2\2\u03c3"+
		"\u03c1\3\2\2\2\u03c4\u03c5\7\f\2\2\u03c5\u03c6\br\3\2\u03c6\u00e4\3\2"+
		"\2\2\u03c7\u03c8\7\61\2\2\u03c8\u03c9\7,\2\2\u03c9\u03cd\3\2\2\2\u03ca"+
		"\u03cc\13\2\2\2\u03cb\u03ca\3\2\2\2\u03cc\u03cf\3\2\2\2\u03cd\u03ce\3"+
		"\2\2\2\u03cd\u03cb\3\2\2\2\u03ce\u03d0\3\2\2\2\u03cf\u03cd\3\2\2\2\u03d0"+
		"\u03d1\7,\2\2\u03d1\u03d2\7\61\2\2\u03d2\u03d3\3\2\2\2\u03d3\u03d4\bs"+
		"\4\2\u03d4\u00e6\3\2\2\2\u03d5\u03d6\7\61\2\2\u03d6\u03d7\7\61\2\2\u03d7"+
		"\u03db\3\2\2\2\u03d8\u03da\n\16\2\2\u03d9\u03d8\3\2\2\2\u03da\u03dd\3"+
		"\2\2\2\u03db\u03d9\3\2\2\2\u03db\u03dc\3\2\2\2\u03dc\u03df\3\2\2\2\u03dd"+
		"\u03db\3\2\2\2\u03de\u03e0\7\17\2\2\u03df\u03de\3\2\2\2\u03df\u03e0\3"+
		"\2\2\2\u03e0\u03e1\3\2\2\2\u03e1\u03e2\7\f\2\2\u03e2\u03e3\3\2\2\2\u03e3"+
		"\u03e4\bt\5\2\u03e4\u00e8\3\2\2\2$\2\u00f9\u00fc\u00ff\u0105\u0108\u010f"+
		"\u0112\u011b\u0121\u0125\u0128\u012e\u0131\u0134\u0139\u013d\u0142\u0145"+
		"\u0148\u014f\u0154\u015e\u0168\u016a\u0178\u017e\u0189\u03b4\u03b6\u03c1"+
		"\u03cd\u03db\u03df\6\2\3\2\3r\2\3s\3\3t\4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}