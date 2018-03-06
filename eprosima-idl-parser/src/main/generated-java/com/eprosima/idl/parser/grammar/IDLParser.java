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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IDLParser extends Parser {
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
	public static final String[] tokenNames = {
		"<INVALID>", "'FALSE'", "'TRUE'", "INTEGER_LITERAL", "OCTAL_LITERAL", 
		"HEX_LITERAL", "FLOATING_PT_LITERAL", "FIXED_PT_LITERAL", "WIDE_CHARACTER_LITERAL", 
		"CHARACTER_LITERAL", "WIDE_STRING_LITERAL", "STRING_LITERAL", "BOOLEAN_LITERAL", 
		"';'", "':'", "','", "'{'", "'}'", "'('", "')'", "'['", "']'", "'~'", 
		"'/'", "'<'", "'>'", "'*'", "'+'", "'-'", "'^'", "'&'", "'|'", "'='", 
		"'%'", "'@'", "'::'", "'>>'", "'<<'", "'setraises'", "'out'", "'emits'", 
		"'string'", "'switch'", "'publishes'", "'typedef'", "'uses'", "'primarykey'", 
		"'custom'", "'octet'", "'sequence'", "'import'", "'struct'", "'native'", 
		"'readonly'", "'finder'", "'raises'", "'void'", "'private'", "'eventtype'", 
		"'wchar'", "'in'", "'default'", "'public'", "'short'", "'long'", "'enum'", 
		"'wstring'", "'context'", "'home'", "'factory'", "'exception'", "'getraises'", 
		"'const'", "'ValueBase'", "'valuetype'", "'supports'", "'module'", "'Object'", 
		"'truncatable'", "'unsigned'", "'fixed'", "'union'", "'oneway'", "'any'", 
		"'char'", "'case'", "'float'", "'boolean'", "'multiple'", "'abstract'", 
		"'inout'", "'provides'", "'consumes'", "'double'", "'typeprefix'", "'typeid'", 
		"'attribute'", "'local'", "'manages'", "'interface'", "'component'", "'@annotation'", 
		"ID", "WS", "PREPROC_DIRECTIVE", "COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_specification = 0, RULE_definition = 1, RULE_aux_definition = 2, 
		RULE_module = 3, RULE_definition_list = 4, RULE_interface_or_forward_decl = 5, 
		RULE_interface_decl = 6, RULE_forward_decl = 7, RULE_interface_body = 8, 
		RULE_export = 9, RULE_aux_export = 10, RULE_interface_inheritance_spec = 11, 
		RULE_interface_name = 12, RULE_scoped_name_list = 13, RULE_scoped_name = 14, 
		RULE_value = 15, RULE_value_forward_decl = 16, RULE_value_box_decl = 17, 
		RULE_value_abs_decl = 18, RULE_value_decl = 19, RULE_value_header = 20, 
		RULE_value_inheritance_spec = 21, RULE_value_name = 22, RULE_value_element = 23, 
		RULE_state_member = 24, RULE_init_decl = 25, RULE_init_param_decls = 26, 
		RULE_init_param_decl = 27, RULE_init_param_attribute = 28, RULE_const_decl = 29, 
		RULE_const_type = 30, RULE_const_exp = 31, RULE_or_expr = 32, RULE_xor_expr = 33, 
		RULE_and_expr = 34, RULE_shift_expr = 35, RULE_add_expr = 36, RULE_mult_expr = 37, 
		RULE_unary_expr = 38, RULE_primary_expr = 39, RULE_literal = 40, RULE_boolean_literal = 41, 
		RULE_positive_int_const = 42, RULE_type_decl = 43, RULE_type_declarator = 44, 
		RULE_type_spec = 45, RULE_simple_type_spec = 46, RULE_base_type_spec = 47, 
		RULE_template_type_spec = 48, RULE_constr_type_spec = 49, RULE_declarators = 50, 
		RULE_declarator = 51, RULE_simple_declarator = 52, RULE_complex_declarator = 53, 
		RULE_floating_pt_type = 54, RULE_integer_type = 55, RULE_signed_int = 56, 
		RULE_signed_short_int = 57, RULE_signed_long_int = 58, RULE_signed_longlong_int = 59, 
		RULE_unsigned_int = 60, RULE_unsigned_short_int = 61, RULE_unsigned_long_int = 62, 
		RULE_unsigned_longlong_int = 63, RULE_char_type = 64, RULE_wide_char_type = 65, 
		RULE_boolean_type = 66, RULE_octet_type = 67, RULE_any_type = 68, RULE_object_type = 69, 
		RULE_annotation_decl = 70, RULE_annotation_def = 71, RULE_annotation_header = 72, 
		RULE_annotation_inheritance_spec = 73, RULE_annotation_body = 74, RULE_annotation_member = 75, 
		RULE_annotation_forward_dcl = 76, RULE_struct_type = 77, RULE_member_list = 78, 
		RULE_member_def = 79, RULE_member = 80, RULE_union_type = 81, RULE_switch_type_spec = 82, 
		RULE_switch_body = 83, RULE_case_stmt_list = 84, RULE_case_stmt = 85, 
		RULE_element_spec = 86, RULE_enum_type = 87, RULE_enumerator_list = 88, 
		RULE_enumerator = 89, RULE_sequence_type = 90, RULE_string_type = 91, 
		RULE_wide_string_type = 92, RULE_array_declarator = 93, RULE_fixed_array_size = 94, 
		RULE_attr_decl = 95, RULE_except_decl = 96, RULE_opt_member_list = 97, 
		RULE_op_decl = 98, RULE_op_attribute = 99, RULE_op_type_spec = 100, RULE_parameter_decls = 101, 
		RULE_param_decl_list = 102, RULE_param_decl = 103, RULE_raises_expr = 104, 
		RULE_context_expr = 105, RULE_param_type_spec = 106, RULE_fixed_pt_type = 107, 
		RULE_fixed_pt_const_type = 108, RULE_value_base_type = 109, RULE_constr_forward_decl = 110, 
		RULE_import_decl = 111, RULE_imported_scope = 112, RULE_type_id_decl = 113, 
		RULE_type_prefix_decl = 114, RULE_readonly_attr_spec = 115, RULE_readonly_attr_declarator = 116, 
		RULE_attr_spec = 117, RULE_attr_declarator = 118, RULE_attr_raises_expr = 119, 
		RULE_get_excep_expr = 120, RULE_set_excep_expr = 121, RULE_exception_list = 122, 
		RULE_component = 123, RULE_component_forward_decl = 124, RULE_component_decl = 125, 
		RULE_component_header = 126, RULE_supported_interface_spec = 127, RULE_component_inheritance_spec = 128, 
		RULE_component_body = 129, RULE_component_export = 130, RULE_provides_decl = 131, 
		RULE_interface_type = 132, RULE_uses_decl = 133, RULE_emits_decl = 134, 
		RULE_publishes_decl = 135, RULE_consumes_decl = 136, RULE_home_decl = 137, 
		RULE_home_header = 138, RULE_home_inheritance_spec = 139, RULE_primary_key_spec = 140, 
		RULE_home_body = 141, RULE_home_export = 142, RULE_factory_decl = 143, 
		RULE_finder_decl = 144, RULE_event = 145, RULE_event_forward_decl = 146, 
		RULE_event_abs_decl = 147, RULE_event_decl = 148, RULE_event_header = 149, 
		RULE_annotation_appl = 150, RULE_annotation_appl_params = 151, RULE_annotation_appl_param = 152, 
		RULE_identifier = 153;
	public static final String[] ruleNames = {
		"specification", "definition", "aux_definition", "module", "definition_list", 
		"interface_or_forward_decl", "interface_decl", "forward_decl", "interface_body", 
		"export", "aux_export", "interface_inheritance_spec", "interface_name", 
		"scoped_name_list", "scoped_name", "value", "value_forward_decl", "value_box_decl", 
		"value_abs_decl", "value_decl", "value_header", "value_inheritance_spec", 
		"value_name", "value_element", "state_member", "init_decl", "init_param_decls", 
		"init_param_decl", "init_param_attribute", "const_decl", "const_type", 
		"const_exp", "or_expr", "xor_expr", "and_expr", "shift_expr", "add_expr", 
		"mult_expr", "unary_expr", "primary_expr", "literal", "boolean_literal", 
		"positive_int_const", "type_decl", "type_declarator", "type_spec", "simple_type_spec", 
		"base_type_spec", "template_type_spec", "constr_type_spec", "declarators", 
		"declarator", "simple_declarator", "complex_declarator", "floating_pt_type", 
		"integer_type", "signed_int", "signed_short_int", "signed_long_int", "signed_longlong_int", 
		"unsigned_int", "unsigned_short_int", "unsigned_long_int", "unsigned_longlong_int", 
		"char_type", "wide_char_type", "boolean_type", "octet_type", "any_type", 
		"object_type", "annotation_decl", "annotation_def", "annotation_header", 
		"annotation_inheritance_spec", "annotation_body", "annotation_member", 
		"annotation_forward_dcl", "struct_type", "member_list", "member_def", 
		"member", "union_type", "switch_type_spec", "switch_body", "case_stmt_list", 
		"case_stmt", "element_spec", "enum_type", "enumerator_list", "enumerator", 
		"sequence_type", "string_type", "wide_string_type", "array_declarator", 
		"fixed_array_size", "attr_decl", "except_decl", "opt_member_list", "op_decl", 
		"op_attribute", "op_type_spec", "parameter_decls", "param_decl_list", 
		"param_decl", "raises_expr", "context_expr", "param_type_spec", "fixed_pt_type", 
		"fixed_pt_const_type", "value_base_type", "constr_forward_decl", "import_decl", 
		"imported_scope", "type_id_decl", "type_prefix_decl", "readonly_attr_spec", 
		"readonly_attr_declarator", "attr_spec", "attr_declarator", "attr_raises_expr", 
		"get_excep_expr", "set_excep_expr", "exception_list", "component", "component_forward_decl", 
		"component_decl", "component_header", "supported_interface_spec", "component_inheritance_spec", 
		"component_body", "component_export", "provides_decl", "interface_type", 
		"uses_decl", "emits_decl", "publishes_decl", "consumes_decl", "home_decl", 
		"home_header", "home_inheritance_spec", "primary_key_spec", "home_body", 
		"home_export", "factory_decl", "finder_decl", "event", "event_forward_decl", 
		"event_abs_decl", "event_decl", "event_header", "annotation_appl", "annotation_appl_params", 
		"annotation_appl_param", "identifier"
	};

	@Override
	public String getGrammarFileName() { return "IDL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private TemplateManager tmanager = null;
	    private Context ctx = null;
	    private List<ConstDeclaration> constDeclarations = new ArrayList<>();

	    public Context getContext_()
	    {
	        return ctx;
	    }

	public IDLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SpecificationContext extends ParserRuleContext {
		public Context context;
		public TemplateManager templatemanager;
		public TemplateGroup maintemplates;
		public Specification spec = null;
		public DefinitionContext definition;
		public List<Import_declContext> import_decl() {
			return getRuleContexts(Import_declContext.class);
		}
		public Import_declContext import_decl(int i) {
			return getRuleContext(Import_declContext.class,i);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public SpecificationContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public SpecificationContext(ParserRuleContext parent, int invokingState, Context context, TemplateManager templatemanager, TemplateGroup maintemplates) {
			super(parent, invokingState);
			this.context = context;
			this.templatemanager = templatemanager;
			this.maintemplates = maintemplates;
		}
		@Override public int getRuleIndex() { return RULE_specification; }
	}

	public final SpecificationContext specification(Context context,TemplateManager templatemanager,TemplateGroup maintemplates) throws RecognitionException {
		SpecificationContext _localctx = new SpecificationContext(_ctx, getState(), context, templatemanager, maintemplates);
		enterRule(_localctx, 0, RULE_specification);

		    //! Used to catch each definition grammar element in the whole IDL file.
		    Pair<Vector<Definition>, TemplateGroup> dtg = null;
		    List<Definition> specificationChildren = new ArrayList<Definition>();
		    ctx = context;
		    tmanager = templatemanager;

		    // Set error handler
		    DefaultErrorListener listener = new DefaultErrorListener(ctx);
		    this.setErrorHandler(DefaultErrorStrategy.INSTANCE);
		    // Select listener for errors.
		    ((Lexer)this._input.getTokenSource()).removeErrorListeners();
		    ((Lexer)this._input.getTokenSource()).addErrorListener(listener);
		    this.removeErrorListeners();
		    this.addErrorListener(listener);

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_IMPORT) {
				{
				{
				setState(308); import_decl();
				}
				}
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(317); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(314); ((SpecificationContext)_localctx).definition = definition(null);

							dtg=((SpecificationContext)_localctx).definition.dtg;
							if (dtg!=null) { 
								if(maintemplates != null) {
									maintemplates.setAttribute("definitions", dtg.second());
								}
				                for(int count = 0; count < dtg.first().size(); ++count)
				                {
				                    ctx.addDefinition(dtg.first().get(count));
				                    specificationChildren.add(dtg.first().get(count));
				                }
							} 
						
				}
				}
				setState(319); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << KW_TYPEDEF) | (1L << KW_CUSTOM) | (1L << KW_STRUCT) | (1L << KW_NATIVE) | (1L << KW_EVENTTYPE))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (KW_ENUM - 65)) | (1L << (KW_HOME - 65)) | (1L << (KW_EXCEPTION - 65)) | (1L << (KW_CONST - 65)) | (1L << (KW_VALUETYPE - 65)) | (1L << (KW_MODULE - 65)) | (1L << (KW_UNION - 65)) | (1L << (KW_ABSTRACT - 65)) | (1L << (KW_TYPEPREFIX - 65)) | (1L << (KW_TYPEID - 65)) | (1L << (KW_LOCAL - 65)) | (1L << (KW_INTERFACE - 65)) | (1L << (KW_COMPONENT - 65)) | (1L << (KW_AT_ANNOTATION - 65)))) != 0) );

			        if(getNumberOfSyntaxErrors() == 0)
			        {
			            ((SpecificationContext)_localctx).spec =  new Specification();
			            _localctx.spec.setDefinitions(specificationChildren);
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

	public static class DefinitionContext extends ParserRuleContext {
		public Vector<Annotation> annotations;
		public Pair<Vector<Definition>, TemplateGroup> dtg = null;
		public Type_declContext type_decl;
		public Const_declContext const_decl;
		public Except_declContext except_decl;
		public Interface_or_forward_declContext interface_or_forward_decl;
		public ModuleContext module;
		public Annotation_declContext annotation_decl;
		public Annotation_applContext annotation_appl;
		public Aux_definitionContext aux_definition;
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public Home_declContext home_decl() {
			return getRuleContext(Home_declContext.class,0);
		}
		public Except_declContext except_decl() {
			return getRuleContext(Except_declContext.class,0);
		}
		public Annotation_declContext annotation_decl() {
			return getRuleContext(Annotation_declContext.class,0);
		}
		public Type_declContext type_decl() {
			return getRuleContext(Type_declContext.class,0);
		}
		public Aux_definitionContext aux_definition() {
			return getRuleContext(Aux_definitionContext.class,0);
		}
		public ModuleContext module() {
			return getRuleContext(ModuleContext.class,0);
		}
		public Interface_or_forward_declContext interface_or_forward_decl() {
			return getRuleContext(Interface_or_forward_declContext.class,0);
		}
		public Annotation_applContext annotation_appl() {
			return getRuleContext(Annotation_applContext.class,0);
		}
		public Type_prefix_declContext type_prefix_decl() {
			return getRuleContext(Type_prefix_declContext.class,0);
		}
		public Type_id_declContext type_id_decl() {
			return getRuleContext(Type_id_declContext.class,0);
		}
		public Const_declContext const_decl() {
			return getRuleContext(Const_declContext.class,0);
		}
		public EventContext event() {
			return getRuleContext(EventContext.class,0);
		}
		public ComponentContext component() {
			return getRuleContext(ComponentContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public DefinitionContext(ParserRuleContext parent, int invokingState, Vector<Annotation> annotations) {
			super(parent, invokingState);
			this.annotations = annotations;
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition(Vector<Annotation> annotations) throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState(), annotations);
		enterRule(_localctx, 2, RULE_definition);

		    // TODO Cambiar esto. No me gusta la forma.
			
		    Vector<Definition> vector = new Vector<Definition>();
		    Pair<Vector<TypeDeclaration>, TemplateGroup> tdtg = null;
		    Pair<ConstDeclaration, TemplateGroup> cdtg = null;
		    Pair<com.eprosima.idl.parser.tree.Exception, TemplateGroup> etg = null;
		    Pair<Interface, TemplateGroup> itg = null;
		    Pair<Module, TemplateGroup> mtg = null;
		    Pair<AnnotationDeclaration, TemplateGroup> atg = null;

		    if(annotations == null) annotations = new Vector<Annotation>();

		try {
			setState(370);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(323); ((DefinitionContext)_localctx).type_decl = type_decl(annotations);
				setState(324); match(SEMICOLON);
				 tdtg=((DefinitionContext)_localctx).type_decl.returnPair; if(tdtg!=null){ for(TypeDeclaration tydl : tdtg.first()) vector.add(tydl); ((DefinitionContext)_localctx).dtg =  new Pair<Vector<Definition>, TemplateGroup>(vector, tdtg.second());}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(327); ((DefinitionContext)_localctx).const_decl = const_decl();
				setState(328); match(SEMICOLON);
				 cdtg=((DefinitionContext)_localctx).const_decl.returnPair; if(cdtg!=null){ vector.add(cdtg.first()); ((DefinitionContext)_localctx).dtg =  new Pair<Vector<Definition>, TemplateGroup>(vector, cdtg.second());}
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(331); ((DefinitionContext)_localctx).except_decl = except_decl();
				setState(332); match(SEMICOLON);
				 etg=((DefinitionContext)_localctx).except_decl.returnPair; if(etg!=null){ vector.add(etg.first()); ((DefinitionContext)_localctx).dtg =  new Pair<Vector<Definition>, TemplateGroup>(vector, etg.second());}
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(335); ((DefinitionContext)_localctx).interface_or_forward_decl = interface_or_forward_decl(annotations);
				setState(336); match(SEMICOLON);
				 itg=((DefinitionContext)_localctx).interface_or_forward_decl.itg; if(itg!=null){ vector.add(itg.first()); ((DefinitionContext)_localctx).dtg =  new Pair<Vector<Definition>, TemplateGroup>(vector, itg.second());}
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(339); ((DefinitionContext)_localctx).module = module();
				setState(340); match(SEMICOLON);
				 mtg=((DefinitionContext)_localctx).module.returnPair; if(mtg!=null){ vector.add(mtg.first()); ((DefinitionContext)_localctx).dtg =  new Pair<Vector<Definition>, TemplateGroup>(vector, mtg.second());}
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(343); value();
				setState(344); match(SEMICOLON);
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(346); type_id_decl();
				setState(347); match(SEMICOLON);
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(349); type_prefix_decl();
				setState(350); match(SEMICOLON);
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(352); event();
				setState(353); match(SEMICOLON);
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(355); component();
				setState(356); match(SEMICOLON);
				}
				break;

			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(358); home_decl();
				setState(359); match(SEMICOLON);
				}
				break;

			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(361); ((DefinitionContext)_localctx).annotation_decl = annotation_decl();
				setState(362); match(SEMICOLON);
				 atg=((DefinitionContext)_localctx).annotation_decl.returnPair; if(atg!=null){ vector.add(atg.first()); ((DefinitionContext)_localctx).dtg =  new Pair<Vector<Definition>, TemplateGroup>(vector, atg.second());}
				}
				break;

			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(365); ((DefinitionContext)_localctx).annotation_appl = annotation_appl();

				            annotations.add(((DefinitionContext)_localctx).annotation_appl.annotation);
				        
				setState(367); ((DefinitionContext)_localctx).aux_definition = aux_definition(annotations);
				((DefinitionContext)_localctx).dtg = ((DefinitionContext)_localctx).aux_definition.dtg;
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

	public static class Aux_definitionContext extends ParserRuleContext {
		public Vector<Annotation> annotations;
		public Pair<Vector<Definition>, TemplateGroup> dtg = null;
		public DefinitionContext definition;
		public DefinitionContext definition() {
			return getRuleContext(DefinitionContext.class,0);
		}
		public Aux_definitionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Aux_definitionContext(ParserRuleContext parent, int invokingState, Vector<Annotation> annotations) {
			super(parent, invokingState);
			this.annotations = annotations;
		}
		@Override public int getRuleIndex() { return RULE_aux_definition; }
	}

	public final Aux_definitionContext aux_definition(Vector<Annotation> annotations) throws RecognitionException {
		Aux_definitionContext _localctx = new Aux_definitionContext(_ctx, getState(), annotations);
		enterRule(_localctx, 4, RULE_aux_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372); ((Aux_definitionContext)_localctx).definition = definition(annotations);
			((Aux_definitionContext)_localctx).dtg = ((Aux_definitionContext)_localctx).definition.dtg;
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

	public static class ModuleContext extends ParserRuleContext {
		public Pair<Module, TemplateGroup> returnPair = null;
		public IdentifierContext identifier;
		public Definition_listContext definition_list;
		public TerminalNode KW_MODULE() { return getToken(IDLParser.KW_MODULE, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Definition_listContext definition_list() {
			return getRuleContext(Definition_listContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_module);

		    Module moduleObject = null;
		    TemplateGroup moduleTemplates = null;
		    TemplateGroup tg = null;
		    // Store old namespace.
		    String name = null, old_scope = ctx.getScope();
		    Token tk = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(375); match(KW_MODULE);
			}

			        tk = _input.LT(1);
			    
			setState(377); ((ModuleContext)_localctx).identifier = identifier();

					name=((ModuleContext)_localctx).identifier.id;
			        // Check if the module already was defined.
			        moduleObject = ctx.existsModule(ctx.getScope() + "::" + name);

			        if(moduleObject != null)
			        {
			            // Add the module to the context.
			            ctx.addModule(moduleObject);
			        }
			        else
			        {
			            // Create the Module object.
			            moduleObject = new Module(ctx.getScopeFile(), ctx.isInScopedFile(), ctx.getScope(), name, tk); 
			        }

					if(ctx.isInScopedFile() || ctx.isScopeLimitToAll()) {
						if(tmanager != null) {
							moduleTemplates = tmanager.createTemplateGroup("module");
							moduleTemplates.setAttribute("ctx", ctx);
							// Set the module object to the TemplateGroup of the module.
							moduleTemplates.setAttribute("module", moduleObject);
						}
					}
					
					// Update to a new namespace.
					if(old_scope.isEmpty())
						ctx.setScope(name);
					else
						ctx.setScope(old_scope + "::" + name);
				
			setState(379); match(LEFT_BRACE);
			setState(380); ((ModuleContext)_localctx).definition_list = definition_list(moduleObject);
			 tg=((ModuleContext)_localctx).definition_list.dlTemplates; if(moduleTemplates!=null && tg!=null)moduleTemplates.setAttribute("definition_list", tg);
			setState(382); match(RIGHT_BRACE);

				    // Set the old namespace.
				    ctx.setScope(old_scope);
				    // Create the returned data.
					((ModuleContext)_localctx).returnPair =  new Pair<Module, TemplateGroup>(moduleObject, moduleTemplates);
				
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

	public static class Definition_listContext extends ParserRuleContext {
		public DefinitionContainer dc;
		public TemplateGroup dlTemplates;
		public DefinitionContext definition;
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public Definition_listContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Definition_listContext(ParserRuleContext parent, int invokingState, DefinitionContainer dc) {
			super(parent, invokingState);
			this.dc = dc;
		}
		@Override public int getRuleIndex() { return RULE_definition_list; }
	}

	public final Definition_listContext definition_list(DefinitionContainer dc) throws RecognitionException {
		Definition_listContext _localctx = new Definition_listContext(_ctx, getState(), dc);
		enterRule(_localctx, 8, RULE_definition_list);

		    Pair<Vector<Definition>, TemplateGroup> dtg = null;
			if(tmanager != null) {
				((Definition_listContext)_localctx).dlTemplates =  tmanager.createTemplateGroup("definition_list");
			}

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(385); ((Definition_listContext)_localctx).definition = definition(null);

							dtg=((Definition_listContext)_localctx).definition.dtg;
							if(dtg!=null)
				            {
				                for(int count = 0; count < dtg.first().size(); ++count)
				                    dc.add(dtg.first().get(count));

								if(_localctx.dlTemplates != null && dtg.second() != null)
				                {
				                    // Set parent
				                    dtg.second().setAttribute("parent", dc);
				                    // Print template into definitions rule
									_localctx.dlTemplates.setAttribute("definitions", dtg.second());
								}
							}
						
				}
				}
				setState(390); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << KW_TYPEDEF) | (1L << KW_CUSTOM) | (1L << KW_STRUCT) | (1L << KW_NATIVE) | (1L << KW_EVENTTYPE))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (KW_ENUM - 65)) | (1L << (KW_HOME - 65)) | (1L << (KW_EXCEPTION - 65)) | (1L << (KW_CONST - 65)) | (1L << (KW_VALUETYPE - 65)) | (1L << (KW_MODULE - 65)) | (1L << (KW_UNION - 65)) | (1L << (KW_ABSTRACT - 65)) | (1L << (KW_TYPEPREFIX - 65)) | (1L << (KW_TYPEID - 65)) | (1L << (KW_LOCAL - 65)) | (1L << (KW_INTERFACE - 65)) | (1L << (KW_COMPONENT - 65)) | (1L << (KW_AT_ANNOTATION - 65)))) != 0) );
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

	public static class Interface_or_forward_declContext extends ParserRuleContext {
		public Vector<Annotation> annotations;
		public Pair<Interface, TemplateGroup> itg = null;
		public Interface_declContext interface_decl;
		public Interface_declContext interface_decl() {
			return getRuleContext(Interface_declContext.class,0);
		}
		public Forward_declContext forward_decl() {
			return getRuleContext(Forward_declContext.class,0);
		}
		public Interface_or_forward_declContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Interface_or_forward_declContext(ParserRuleContext parent, int invokingState, Vector<Annotation> annotations) {
			super(parent, invokingState);
			this.annotations = annotations;
		}
		@Override public int getRuleIndex() { return RULE_interface_or_forward_decl; }
	}

	public final Interface_or_forward_declContext interface_or_forward_decl(Vector<Annotation> annotations) throws RecognitionException {
		Interface_or_forward_declContext _localctx = new Interface_or_forward_declContext(_ctx, getState(), annotations);
		enterRule(_localctx, 10, RULE_interface_or_forward_decl);
		try {
			setState(396);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(392); ((Interface_or_forward_declContext)_localctx).interface_decl = interface_decl(annotations);
				((Interface_or_forward_declContext)_localctx).itg =  ((Interface_or_forward_declContext)_localctx).interface_decl.returnPair;
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(395); forward_decl();
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

	public static class Interface_declContext extends ParserRuleContext {
		public Vector<Annotation> annotations;
		public Pair<Interface, TemplateGroup> returnPair = null;
		public IdentifierContext identifier;
		public Interface_bodyContext interface_body;
		public Interface_bodyContext interface_body() {
			return getRuleContext(Interface_bodyContext.class,0);
		}
		public Interface_inheritance_specContext interface_inheritance_spec() {
			return getRuleContext(Interface_inheritance_specContext.class,0);
		}
		public TerminalNode KW_LOCAL() { return getToken(IDLParser.KW_LOCAL, 0); }
		public TerminalNode KW_INTERFACE() { return getToken(IDLParser.KW_INTERFACE, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public TerminalNode KW_ABSTRACT() { return getToken(IDLParser.KW_ABSTRACT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public Interface_declContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Interface_declContext(ParserRuleContext parent, int invokingState, Vector<Annotation> annotations) {
			super(parent, invokingState);
			this.annotations = annotations;
		}
		@Override public int getRuleIndex() { return RULE_interface_decl; }
	}

	public final Interface_declContext interface_decl(Vector<Annotation> annotations) throws RecognitionException {
		Interface_declContext _localctx = new Interface_declContext(_ctx, getState(), annotations);
		enterRule(_localctx, 12, RULE_interface_decl);

		    Token tk = null;   
		    Interface interfaceObject = null;
		    TemplateGroup interfaceTemplates = null;
		    TemplateGroup tg = null;
		    String name = null, old_scope = ctx.getScope();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(399);
			_la = _input.LA(1);
			if (_la==KW_ABSTRACT || _la==KW_LOCAL) {
				{
				setState(398);
				_la = _input.LA(1);
				if ( !(_la==KW_ABSTRACT || _la==KW_LOCAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			{
			setState(401); match(KW_INTERFACE);
			}

			            tk = _input.LT(1);
			        
			setState(403); ((Interface_declContext)_localctx).identifier = identifier();

						name=((Interface_declContext)_localctx).identifier.id;
			           // Create the Interface object.
			           interfaceObject = ctx.createInterface(name, tk);

			           // Add annotations.
			           for(Annotation annotation : annotations)
			               interfaceObject.addAnnotation(ctx, annotation);

			           if(ctx.isInScopedFile() || ctx.isScopeLimitToAll())
			           {
						   if(tmanager != null) {
								interfaceTemplates = tmanager.createTemplateGroup("interface");
								interfaceTemplates.setAttribute("ctx", ctx);
								// Set the the interface object to the TemplateGroup of the module.
								interfaceTemplates.setAttribute("interface", interfaceObject);
							}
			            }

				       // Update to a new namespace.
			           if(old_scope.isEmpty())
				           ctx.setScope(name);
			           else
				           ctx.setScope(old_scope + "::" + name);
			        
			setState(406);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(405); interface_inheritance_spec(interfaceObject);
				}
			}

			setState(408); match(LEFT_BRACE);
			setState(409); ((Interface_declContext)_localctx).interface_body = interface_body(interfaceObject);
			 tg=((Interface_declContext)_localctx).interface_body.elTemplates; if(interfaceTemplates!=null && tg!=null)interfaceTemplates.setAttribute("export_list", tg);
			setState(411); match(RIGHT_BRACE);
			}

				       // Set the old namespace.
				       ctx.setScope(old_scope);
			           // Create the returned data.
			           ((Interface_declContext)_localctx).returnPair =  new Pair<Interface, TemplateGroup>(interfaceObject, interfaceTemplates);
			        
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

	public static class Forward_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode KW_LOCAL() { return getToken(IDLParser.KW_LOCAL, 0); }
		public TerminalNode KW_INTERFACE() { return getToken(IDLParser.KW_INTERFACE, 0); }
		public TerminalNode KW_ABSTRACT() { return getToken(IDLParser.KW_ABSTRACT, 0); }
		public Forward_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forward_decl; }
	}

	public final Forward_declContext forward_decl() throws RecognitionException {
		Forward_declContext _localctx = new Forward_declContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_forward_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			_la = _input.LA(1);
			if (_la==KW_ABSTRACT || _la==KW_LOCAL) {
				{
				setState(415);
				_la = _input.LA(1);
				if ( !(_la==KW_ABSTRACT || _la==KW_LOCAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			{
			setState(418); match(KW_INTERFACE);
			}
			setState(419); match(ID);
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

	public static class Interface_bodyContext extends ParserRuleContext {
		public ExportContainer ec;
		public TemplateGroup elTemplates;
		public ExportContext export;
		public List<ExportContext> export() {
			return getRuleContexts(ExportContext.class);
		}
		public ExportContext export(int i) {
			return getRuleContext(ExportContext.class,i);
		}
		public Interface_bodyContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Interface_bodyContext(ParserRuleContext parent, int invokingState, ExportContainer ec) {
			super(parent, invokingState);
			this.ec = ec;
		}
		@Override public int getRuleIndex() { return RULE_interface_body; }
	}

	public final Interface_bodyContext interface_body(ExportContainer ec) throws RecognitionException {
		Interface_bodyContext _localctx = new Interface_bodyContext(_ctx, getState(), ec);
		enterRule(_localctx, 16, RULE_interface_body);

		        Pair<Vector<Export>, TemplateGroup> etg = null;
				if(tmanager != null) {
					((Interface_bodyContext)_localctx).elTemplates =  tmanager.createTemplateGroup("export_list");
				}

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << DOUBLE_COLON) | (1L << KW_STRING) | (1L << KW_TYPEDEF) | (1L << KW_OCTET) | (1L << KW_STRUCT) | (1L << KW_NATIVE) | (1L << KW_READONLY) | (1L << KW_VOID) | (1L << KW_WCHAR) | (1L << KW_SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_LONG - 64)) | (1L << (KW_ENUM - 64)) | (1L << (KW_WSTRING - 64)) | (1L << (KW_EXCEPTION - 64)) | (1L << (KW_CONST - 64)) | (1L << (KW_VALUEBASE - 64)) | (1L << (KW_OBJECT - 64)) | (1L << (KW_UNSIGNED - 64)) | (1L << (KW_UNION - 64)) | (1L << (KW_ONEWAY - 64)) | (1L << (KW_ANY - 64)) | (1L << (KW_CHAR - 64)) | (1L << (KW_FLOAT - 64)) | (1L << (KW_BOOLEAN - 64)) | (1L << (KW_DOUBLE - 64)) | (1L << (KW_TYPEPREFIX - 64)) | (1L << (KW_TYPEID - 64)) | (1L << (KW_ATTRIBUTE - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(421); ((Interface_bodyContext)_localctx).export = export(null);

							etg=((Interface_bodyContext)_localctx).export.etg;
							if(etg!=null)
				            {
				                for(int count = 0; count < etg.first().size(); ++count)
				                {
								    ec.add(etg.first().get(count));
								    etg.first().get(count).resolve(ctx);
				                }

								if(_localctx.elTemplates != null && etg.second() != null)
				                {
				                    // Add parent
				                    etg.second().setAttribute("parent", ec);
				                    // Print template into exports rule
									_localctx.elTemplates.setAttribute("exports", etg.second());
								}
							}
						
				}
				}
				setState(428);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ExportContext extends ParserRuleContext {
		public Vector<Annotation> annotations;
		public Pair<Vector<Export>, TemplateGroup> etg = null;
		public Type_declContext type_decl;
		public Const_declContext const_decl;
		public Except_declContext except_decl;
		public Op_declContext op_decl;
		public Annotation_applContext annotation_appl;
		public Aux_exportContext aux_export;
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public Attr_declContext attr_decl() {
			return getRuleContext(Attr_declContext.class,0);
		}
		public Annotation_applContext annotation_appl() {
			return getRuleContext(Annotation_applContext.class,0);
		}
		public Type_prefix_declContext type_prefix_decl() {
			return getRuleContext(Type_prefix_declContext.class,0);
		}
		public Aux_exportContext aux_export() {
			return getRuleContext(Aux_exportContext.class,0);
		}
		public Except_declContext except_decl() {
			return getRuleContext(Except_declContext.class,0);
		}
		public Type_declContext type_decl() {
			return getRuleContext(Type_declContext.class,0);
		}
		public Type_id_declContext type_id_decl() {
			return getRuleContext(Type_id_declContext.class,0);
		}
		public Const_declContext const_decl() {
			return getRuleContext(Const_declContext.class,0);
		}
		public Op_declContext op_decl() {
			return getRuleContext(Op_declContext.class,0);
		}
		public ExportContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExportContext(ParserRuleContext parent, int invokingState, Vector<Annotation> annotations) {
			super(parent, invokingState);
			this.annotations = annotations;
		}
		@Override public int getRuleIndex() { return RULE_export; }
	}

	public final ExportContext export(Vector<Annotation> annotations) throws RecognitionException {
		ExportContext _localctx = new ExportContext(_ctx, getState(), annotations);
		enterRule(_localctx, 18, RULE_export);

		        // TODO Cambiar esto. No me gusta la forma.
		        Vector<Export> vector = new Vector<Export>();
		        Pair<Vector<TypeDeclaration>, TemplateGroup> tetg = null;
		        Pair<ConstDeclaration, TemplateGroup> cetg = null;
		        Pair<Operation, TemplateGroup> oetg = null;
		        Pair<com.eprosima.idl.parser.tree.Exception, TemplateGroup> eetg = null;
		        
		        if(annotations == null) annotations = new Vector<Annotation>();

		try {
			setState(460);
			switch (_input.LA(1)) {
			case KW_TYPEDEF:
			case KW_STRUCT:
			case KW_NATIVE:
			case KW_ENUM:
			case KW_UNION:
				enterOuterAlt(_localctx, 1);
				{
				setState(429); ((ExportContext)_localctx).type_decl = type_decl(annotations);
				setState(430); match(SEMICOLON);
				 tetg=((ExportContext)_localctx).type_decl.returnPair; if(tetg!=null){ for(TypeDeclaration tydl : tetg.first()) vector.add(tydl); ((ExportContext)_localctx).etg =  new Pair<Vector<Export>, TemplateGroup>(vector, tetg.second());} 
				}
				break;
			case KW_CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(433); ((ExportContext)_localctx).const_decl = const_decl();
				setState(434); match(SEMICOLON);
				 cetg=((ExportContext)_localctx).const_decl.returnPair; if(cetg!=null){ vector.add(cetg.first()); ((ExportContext)_localctx).etg =  new Pair<Vector<Export>, TemplateGroup>(vector, cetg.second());}
				}
				break;
			case KW_EXCEPTION:
				enterOuterAlt(_localctx, 3);
				{
				setState(437); ((ExportContext)_localctx).except_decl = except_decl();
				setState(438); match(SEMICOLON);
				 eetg=((ExportContext)_localctx).except_decl.returnPair; if(eetg!=null){ vector.add(eetg.first()); ((ExportContext)_localctx).etg =  new Pair<Vector<Export>, TemplateGroup>(vector, eetg.second());}
				}
				break;
			case KW_READONLY:
			case KW_ATTRIBUTE:
				enterOuterAlt(_localctx, 4);
				{
				setState(441); attr_decl();
				setState(442); match(SEMICOLON);
				 System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Attribute declarations are not supported. Ignoring..."); 
				}
				break;
			case DOUBLE_COLON:
			case KW_STRING:
			case KW_OCTET:
			case KW_VOID:
			case KW_WCHAR:
			case KW_SHORT:
			case KW_LONG:
			case KW_WSTRING:
			case KW_VALUEBASE:
			case KW_OBJECT:
			case KW_UNSIGNED:
			case KW_ONEWAY:
			case KW_ANY:
			case KW_CHAR:
			case KW_FLOAT:
			case KW_BOOLEAN:
			case KW_DOUBLE:
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(445); ((ExportContext)_localctx).op_decl = op_decl(annotations);
				setState(446); match(SEMICOLON);
				 oetg=((ExportContext)_localctx).op_decl.returnPair; if(oetg!=null){ vector.add(oetg.first()); ((ExportContext)_localctx).etg =  new Pair<Vector<Export>, TemplateGroup>(vector, oetg.second());}
				}
				break;
			case KW_TYPEID:
				enterOuterAlt(_localctx, 6);
				{
				setState(449); type_id_decl();
				setState(450); match(SEMICOLON);
				}
				break;
			case KW_TYPEPREFIX:
				enterOuterAlt(_localctx, 7);
				{
				setState(452); type_prefix_decl();
				setState(453); match(SEMICOLON);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 8);
				{
				setState(455); ((ExportContext)_localctx).annotation_appl = annotation_appl();

				            annotations.add(((ExportContext)_localctx).annotation_appl.annotation);
				        
				setState(457); ((ExportContext)_localctx).aux_export = aux_export(annotations);
				((ExportContext)_localctx).etg = ((ExportContext)_localctx).aux_export.etg;
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

	public static class Aux_exportContext extends ParserRuleContext {
		public Vector<Annotation> annotations;
		public Pair<Vector<Export>, TemplateGroup> etg = null;
		public ExportContext export;
		public ExportContext export() {
			return getRuleContext(ExportContext.class,0);
		}
		public Aux_exportContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Aux_exportContext(ParserRuleContext parent, int invokingState, Vector<Annotation> annotations) {
			super(parent, invokingState);
			this.annotations = annotations;
		}
		@Override public int getRuleIndex() { return RULE_aux_export; }
	}

	public final Aux_exportContext aux_export(Vector<Annotation> annotations) throws RecognitionException {
		Aux_exportContext _localctx = new Aux_exportContext(_ctx, getState(), annotations);
		enterRule(_localctx, 20, RULE_aux_export);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462); ((Aux_exportContext)_localctx).export = export(annotations);
			((Aux_exportContext)_localctx).etg = ((Aux_exportContext)_localctx).export.etg;
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

	public static class Interface_inheritance_specContext extends ParserRuleContext {
		public Interface interfaceObject;
		public Scoped_name_listContext scoped_name_list;
		public TerminalNode COLON() { return getToken(IDLParser.COLON, 0); }
		public Scoped_name_listContext scoped_name_list() {
			return getRuleContext(Scoped_name_listContext.class,0);
		}
		public Interface_inheritance_specContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Interface_inheritance_specContext(ParserRuleContext parent, int invokingState, Interface interfaceObject) {
			super(parent, invokingState);
			this.interfaceObject = interfaceObject;
		}
		@Override public int getRuleIndex() { return RULE_interface_inheritance_spec; }
	}

	public final Interface_inheritance_specContext interface_inheritance_spec(Interface interfaceObject) throws RecognitionException {
		Interface_inheritance_specContext _localctx = new Interface_inheritance_specContext(_ctx, getState(), interfaceObject);
		enterRule(_localctx, 22, RULE_interface_inheritance_spec);

		        Vector<Pair<String, Token>> iflist = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465); match(COLON);
			setState(466); ((Interface_inheritance_specContext)_localctx).scoped_name_list = scoped_name_list();
			 iflist=((Interface_inheritance_specContext)_localctx).scoped_name_list.retlist; 

			        for(Pair<String, Token> pair : iflist)
			        {
			            Interface base = ctx.getInterface(pair.first());

			            if(base != null)
			            {
			                if(!_localctx.interfaceObject.addBase(base))
			                    throw new ParseException(pair.second(), " is duplicated.");
			            }
			            else
			            {
				           throw new ParseException(pair.second(), "was not defined previously");
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

	public static class Interface_nameContext extends ParserRuleContext {
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Interface_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interface_name; }
	}

	public final Interface_nameContext interface_name() throws RecognitionException {
		Interface_nameContext _localctx = new Interface_nameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_interface_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470); scoped_name();
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

	public static class Scoped_name_listContext extends ParserRuleContext {
		public Vector<Pair<String, Token>> retlist = null;
		public Scoped_nameContext scoped_name;
		public List<Scoped_nameContext> scoped_name() {
			return getRuleContexts(Scoped_nameContext.class);
		}
		public Scoped_nameContext scoped_name(int i) {
			return getRuleContext(Scoped_nameContext.class,i);
		}
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public Scoped_name_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scoped_name_list; }
	}

	public final Scoped_name_listContext scoped_name_list() throws RecognitionException {
		Scoped_name_listContext _localctx = new Scoped_name_listContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_scoped_name_list);

		   ((Scoped_name_listContext)_localctx).retlist =  new Vector<Pair<String, Token>>();
		   Pair<String, Token> pair = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472); ((Scoped_name_listContext)_localctx).scoped_name = scoped_name();
			 pair=((Scoped_name_listContext)_localctx).scoped_name.pair; _localctx.retlist.add(pair);
			setState(480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(474); match(COMA);
				setState(475); ((Scoped_name_listContext)_localctx).scoped_name = scoped_name();
				 pair=((Scoped_name_listContext)_localctx).scoped_name.pair; _localctx.retlist.add(pair);
				}
				}
				setState(482);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Scoped_nameContext extends ParserRuleContext {
		public Pair<String, Token> pair = null;
		public IdentifierContext identifier;
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode DOUBLE_COLON(int i) {
			return getToken(IDLParser.DOUBLE_COLON, i);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public List<TerminalNode> DOUBLE_COLON() { return getTokens(IDLParser.DOUBLE_COLON); }
		public Scoped_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scoped_name; }
	}

	public final Scoped_nameContext scoped_name() throws RecognitionException {
		Scoped_nameContext _localctx = new Scoped_nameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_scoped_name);

		    String literalStr = "";
		    Token tk = _input.LT(1);

		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			_la = _input.LA(1);
			if (_la==DOUBLE_COLON) {
				{
				literalStr += _input.LT(1).getText();
				setState(484); match(DOUBLE_COLON);
				}
			}

			literalStr += _input.LT(1).getText();
			setState(488); match(ID);
			setState(496);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					literalStr += _input.LT(1).getText();
					setState(490); match(DOUBLE_COLON);
					setState(491); ((Scoped_nameContext)_localctx).identifier = identifier();
					 literalStr+=((Scoped_nameContext)_localctx).identifier.id; 
					}
					} 
				}
				setState(498);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			((Scoped_nameContext)_localctx).pair =  new Pair<String, Token>(literalStr, tk);
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

	public static class ValueContext extends ParserRuleContext {
		public Value_declContext value_decl() {
			return getRuleContext(Value_declContext.class,0);
		}
		public Value_forward_declContext value_forward_decl() {
			return getRuleContext(Value_forward_declContext.class,0);
		}
		public Value_abs_declContext value_abs_decl() {
			return getRuleContext(Value_abs_declContext.class,0);
		}
		public Value_box_declContext value_box_decl() {
			return getRuleContext(Value_box_declContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_value);

		    System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): ValueType declarations are not supported. Ignoring...");

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(501); value_decl();
				}
				break;

			case 2:
				{
				setState(502); value_abs_decl();
				}
				break;

			case 3:
				{
				setState(503); value_box_decl();
				}
				break;

			case 4:
				{
				setState(504); value_forward_decl();
				}
				break;
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

	public static class Value_forward_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode KW_VALUETYPE() { return getToken(IDLParser.KW_VALUETYPE, 0); }
		public TerminalNode KW_ABSTRACT() { return getToken(IDLParser.KW_ABSTRACT, 0); }
		public Value_forward_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_forward_decl; }
	}

	public final Value_forward_declContext value_forward_decl() throws RecognitionException {
		Value_forward_declContext _localctx = new Value_forward_declContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_value_forward_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			_la = _input.LA(1);
			if (_la==KW_ABSTRACT) {
				{
				setState(507); match(KW_ABSTRACT);
				}
			}

			setState(510); match(KW_VALUETYPE);
			setState(511); match(ID);
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

	public static class Value_box_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode KW_VALUETYPE() { return getToken(IDLParser.KW_VALUETYPE, 0); }
		public Value_box_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_box_decl; }
	}

	public final Value_box_declContext value_box_decl() throws RecognitionException {
		Value_box_declContext _localctx = new Value_box_declContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_value_box_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513); match(KW_VALUETYPE);
			setState(514); match(ID);
			setState(515); type_spec();
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

	public static class Value_abs_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public List<ExportContext> export() {
			return getRuleContexts(ExportContext.class);
		}
		public ExportContext export(int i) {
			return getRuleContext(ExportContext.class,i);
		}
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public TerminalNode KW_ABSTRACT() { return getToken(IDLParser.KW_ABSTRACT, 0); }
		public TerminalNode KW_VALUETYPE() { return getToken(IDLParser.KW_VALUETYPE, 0); }
		public Value_inheritance_specContext value_inheritance_spec() {
			return getRuleContext(Value_inheritance_specContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public Value_abs_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_abs_decl; }
	}

	public final Value_abs_declContext value_abs_decl() throws RecognitionException {
		Value_abs_declContext _localctx = new Value_abs_declContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_value_abs_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517); match(KW_ABSTRACT);
			setState(518); match(KW_VALUETYPE);
			setState(519); match(ID);
			setState(520); value_inheritance_spec();
			setState(521); match(LEFT_BRACE);
			setState(525);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << DOUBLE_COLON) | (1L << KW_STRING) | (1L << KW_TYPEDEF) | (1L << KW_OCTET) | (1L << KW_STRUCT) | (1L << KW_NATIVE) | (1L << KW_READONLY) | (1L << KW_VOID) | (1L << KW_WCHAR) | (1L << KW_SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_LONG - 64)) | (1L << (KW_ENUM - 64)) | (1L << (KW_WSTRING - 64)) | (1L << (KW_EXCEPTION - 64)) | (1L << (KW_CONST - 64)) | (1L << (KW_VALUEBASE - 64)) | (1L << (KW_OBJECT - 64)) | (1L << (KW_UNSIGNED - 64)) | (1L << (KW_UNION - 64)) | (1L << (KW_ONEWAY - 64)) | (1L << (KW_ANY - 64)) | (1L << (KW_CHAR - 64)) | (1L << (KW_FLOAT - 64)) | (1L << (KW_BOOLEAN - 64)) | (1L << (KW_DOUBLE - 64)) | (1L << (KW_TYPEPREFIX - 64)) | (1L << (KW_TYPEID - 64)) | (1L << (KW_ATTRIBUTE - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(522); export(null);
				}
				}
				setState(527);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(528); match(RIGHT_BRACE);
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

	public static class Value_declContext extends ParserRuleContext {
		public Value_headerContext value_header() {
			return getRuleContext(Value_headerContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public Value_elementContext value_element(int i) {
			return getRuleContext(Value_elementContext.class,i);
		}
		public List<Value_elementContext> value_element() {
			return getRuleContexts(Value_elementContext.class);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public Value_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_decl; }
	}

	public final Value_declContext value_decl() throws RecognitionException {
		Value_declContext _localctx = new Value_declContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_value_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530); value_header();
			setState(531); match(LEFT_BRACE);
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << DOUBLE_COLON) | (1L << KW_STRING) | (1L << KW_TYPEDEF) | (1L << KW_OCTET) | (1L << KW_STRUCT) | (1L << KW_NATIVE) | (1L << KW_READONLY) | (1L << KW_VOID) | (1L << KW_PRIVATE) | (1L << KW_WCHAR) | (1L << KW_PUBLIC) | (1L << KW_SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_LONG - 64)) | (1L << (KW_ENUM - 64)) | (1L << (KW_WSTRING - 64)) | (1L << (KW_FACTORY - 64)) | (1L << (KW_EXCEPTION - 64)) | (1L << (KW_CONST - 64)) | (1L << (KW_VALUEBASE - 64)) | (1L << (KW_OBJECT - 64)) | (1L << (KW_UNSIGNED - 64)) | (1L << (KW_UNION - 64)) | (1L << (KW_ONEWAY - 64)) | (1L << (KW_ANY - 64)) | (1L << (KW_CHAR - 64)) | (1L << (KW_FLOAT - 64)) | (1L << (KW_BOOLEAN - 64)) | (1L << (KW_DOUBLE - 64)) | (1L << (KW_TYPEPREFIX - 64)) | (1L << (KW_TYPEID - 64)) | (1L << (KW_ATTRIBUTE - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(532); value_element();
				}
				}
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(538); match(RIGHT_BRACE);
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

	public static class Value_headerContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode KW_VALUETYPE() { return getToken(IDLParser.KW_VALUETYPE, 0); }
		public TerminalNode KW_CUSTOM() { return getToken(IDLParser.KW_CUSTOM, 0); }
		public Value_inheritance_specContext value_inheritance_spec() {
			return getRuleContext(Value_inheritance_specContext.class,0);
		}
		public Value_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_header; }
	}

	public final Value_headerContext value_header() throws RecognitionException {
		Value_headerContext _localctx = new Value_headerContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_value_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			_la = _input.LA(1);
			if (_la==KW_CUSTOM) {
				{
				setState(540); match(KW_CUSTOM);
				}
			}

			setState(543); match(KW_VALUETYPE);
			setState(544); match(ID);
			setState(545); value_inheritance_spec();
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

	public static class Value_inheritance_specContext extends ParserRuleContext {
		public Interface_nameContext interface_name(int i) {
			return getRuleContext(Interface_nameContext.class,i);
		}
		public List<Interface_nameContext> interface_name() {
			return getRuleContexts(Interface_nameContext.class);
		}
		public TerminalNode COLON() { return getToken(IDLParser.COLON, 0); }
		public Value_nameContext value_name(int i) {
			return getRuleContext(Value_nameContext.class,i);
		}
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public TerminalNode KW_TRUNCATABLE() { return getToken(IDLParser.KW_TRUNCATABLE, 0); }
		public List<Value_nameContext> value_name() {
			return getRuleContexts(Value_nameContext.class);
		}
		public TerminalNode KW_SUPPORTS() { return getToken(IDLParser.KW_SUPPORTS, 0); }
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public Value_inheritance_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_inheritance_spec; }
	}

	public final Value_inheritance_specContext value_inheritance_spec() throws RecognitionException {
		Value_inheritance_specContext _localctx = new Value_inheritance_specContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_value_inheritance_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(547); match(COLON);
				setState(549);
				_la = _input.LA(1);
				if (_la==KW_TRUNCATABLE) {
					{
					setState(548); match(KW_TRUNCATABLE);
					}
				}

				setState(551); value_name();
				setState(556);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(552); match(COMA);
					setState(553); value_name();
					}
					}
					setState(558);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(570);
			_la = _input.LA(1);
			if (_la==KW_SUPPORTS) {
				{
				setState(561); match(KW_SUPPORTS);
				setState(562); interface_name();
				setState(567);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(563); match(COMA);
					setState(564); interface_name();
					}
					}
					setState(569);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class Value_nameContext extends ParserRuleContext {
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Value_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_name; }
	}

	public final Value_nameContext value_name() throws RecognitionException {
		Value_nameContext _localctx = new Value_nameContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_value_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572); scoped_name();
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

	public static class Value_elementContext extends ParserRuleContext {
		public ExportContext export() {
			return getRuleContext(ExportContext.class,0);
		}
		public State_memberContext state_member() {
			return getRuleContext(State_memberContext.class,0);
		}
		public Init_declContext init_decl() {
			return getRuleContext(Init_declContext.class,0);
		}
		public Value_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_element; }
	}

	public final Value_elementContext value_element() throws RecognitionException {
		Value_elementContext _localctx = new Value_elementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_value_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577);
			switch (_input.LA(1)) {
			case AT:
			case DOUBLE_COLON:
			case KW_STRING:
			case KW_TYPEDEF:
			case KW_OCTET:
			case KW_STRUCT:
			case KW_NATIVE:
			case KW_READONLY:
			case KW_VOID:
			case KW_WCHAR:
			case KW_SHORT:
			case KW_LONG:
			case KW_ENUM:
			case KW_WSTRING:
			case KW_EXCEPTION:
			case KW_CONST:
			case KW_VALUEBASE:
			case KW_OBJECT:
			case KW_UNSIGNED:
			case KW_UNION:
			case KW_ONEWAY:
			case KW_ANY:
			case KW_CHAR:
			case KW_FLOAT:
			case KW_BOOLEAN:
			case KW_DOUBLE:
			case KW_TYPEPREFIX:
			case KW_TYPEID:
			case KW_ATTRIBUTE:
			case ID:
				{
				setState(574); export(null);
				}
				break;
			case KW_PRIVATE:
			case KW_PUBLIC:
				{
				setState(575); state_member();
				}
				break;
			case KW_FACTORY:
				{
				setState(576); init_decl();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class State_memberContext extends ParserRuleContext {
		public TerminalNode KW_PUBLIC() { return getToken(IDLParser.KW_PUBLIC, 0); }
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public TerminalNode KW_PRIVATE() { return getToken(IDLParser.KW_PRIVATE, 0); }
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public DeclaratorsContext declarators() {
			return getRuleContext(DeclaratorsContext.class,0);
		}
		public State_memberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_member; }
	}

	public final State_memberContext state_member() throws RecognitionException {
		State_memberContext _localctx = new State_memberContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_state_member);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579);
			_la = _input.LA(1);
			if ( !(_la==KW_PRIVATE || _la==KW_PUBLIC) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(580); type_spec();
			setState(581); declarators();
			setState(582); match(SEMICOLON);
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

	public static class Init_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public Init_param_declsContext init_param_decls() {
			return getRuleContext(Init_param_declsContext.class,0);
		}
		public TerminalNode KW_FACTORY() { return getToken(IDLParser.KW_FACTORY, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public Raises_exprContext raises_expr() {
			return getRuleContext(Raises_exprContext.class,0);
		}
		public Init_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_decl; }
	}

	public final Init_declContext init_decl() throws RecognitionException {
		Init_declContext _localctx = new Init_declContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_init_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584); match(KW_FACTORY);
			setState(585); match(ID);
			setState(586); match(LEFT_BRACKET);
			setState(588);
			_la = _input.LA(1);
			if (_la==KW_IN) {
				{
				setState(587); init_param_decls();
				}
			}

			setState(590); match(RIGHT_BRACKET);
			setState(592);
			_la = _input.LA(1);
			if (_la==KW_RAISES) {
				{
				setState(591); raises_expr();
				}
			}

			setState(594); match(SEMICOLON);
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

	public static class Init_param_declsContext extends ParserRuleContext {
		public Init_param_declContext init_param_decl(int i) {
			return getRuleContext(Init_param_declContext.class,i);
		}
		public List<Init_param_declContext> init_param_decl() {
			return getRuleContexts(Init_param_declContext.class);
		}
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public Init_param_declsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_param_decls; }
	}

	public final Init_param_declsContext init_param_decls() throws RecognitionException {
		Init_param_declsContext _localctx = new Init_param_declsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_init_param_decls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596); init_param_decl();
			setState(601);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(597); match(COMA);
				setState(598); init_param_decl();
				}
				}
				setState(603);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Init_param_declContext extends ParserRuleContext {
		public Param_type_specContext param_type_spec() {
			return getRuleContext(Param_type_specContext.class,0);
		}
		public Simple_declaratorContext simple_declarator() {
			return getRuleContext(Simple_declaratorContext.class,0);
		}
		public Init_param_attributeContext init_param_attribute() {
			return getRuleContext(Init_param_attributeContext.class,0);
		}
		public Init_param_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_param_decl; }
	}

	public final Init_param_declContext init_param_decl() throws RecognitionException {
		Init_param_declContext _localctx = new Init_param_declContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_init_param_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(604); init_param_attribute();
			setState(605); param_type_spec();
			setState(606); simple_declarator();
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

	public static class Init_param_attributeContext extends ParserRuleContext {
		public TerminalNode KW_IN() { return getToken(IDLParser.KW_IN, 0); }
		public Init_param_attributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_param_attribute; }
	}

	public final Init_param_attributeContext init_param_attribute() throws RecognitionException {
		Init_param_attributeContext _localctx = new Init_param_attributeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_init_param_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608); match(KW_IN);
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

	public static class Const_declContext extends ParserRuleContext {
		public Pair<ConstDeclaration, TemplateGroup> returnPair = null;
		public Const_typeContext const_type;
		public IdentifierContext identifier;
		public Const_expContext const_exp;
		public TerminalNode EQUAL() { return getToken(IDLParser.EQUAL, 0); }
		public TerminalNode KW_CONST() { return getToken(IDLParser.KW_CONST, 0); }
		public Const_typeContext const_type() {
			return getRuleContext(Const_typeContext.class,0);
		}
		public Const_expContext const_exp() {
			return getRuleContext(Const_expContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Const_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_decl; }
	}

	public final Const_declContext const_decl() throws RecognitionException {
		Const_declContext _localctx = new Const_declContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_const_decl);

		    ConstDeclaration constDecl = null;
		    TypeCode typecode = null;
		    String constName = null, constValue = null;
			TemplateGroup constTemplates = null;
			if(tmanager != null) {
				constTemplates = tmanager.createTemplateGroup("const_decl");
			}
		    Token tk = null;
		    String comments = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(610); match(KW_CONST);
			setState(611); ((Const_declContext)_localctx).const_type = const_type();
			 typecode=((Const_declContext)_localctx).const_type.typecode; tk = _input.LT(1);
			setState(613); ((Const_declContext)_localctx).identifier = identifier();
			 constName=((Const_declContext)_localctx).identifier.id; 
			setState(615); match(EQUAL);
			setState(616); ((Const_declContext)_localctx).const_exp = const_exp();
			 constValue=((Const_declContext)_localctx).const_exp.literalStr; 

					if(typecode != null)
			        {
			            comments = ctx.lookForComments(_input, tk, 50);
			            String modifiedName = constName.contains("__") ? constName.substring(constName.indexOf("__") + 2) : constName;
						constDecl = new ConstDeclaration(ctx.getScopeFile(), ctx.isInScopedFile(), ctx.getScope(), modifiedName, typecode, constValue, tk, comments);
						constDeclarations.add(constDecl);

						if(constTemplates != null)
			            {
							constTemplates.setAttribute("ctx", ctx);
							constTemplates.setAttribute("const", constDecl);
						}			

						((Const_declContext)_localctx).returnPair =  new Pair<ConstDeclaration, TemplateGroup>(constDecl, constTemplates);
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

	public static class Const_typeContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Integer_typeContext integer_type;
		public Char_typeContext char_type;
		public Wide_char_typeContext wide_char_type;
		public Boolean_typeContext boolean_type;
		public Floating_pt_typeContext floating_pt_type;
		public String_typeContext string_type;
		public Wide_string_typeContext wide_string_type;
		public Scoped_nameContext scoped_name;
		public Octet_typeContext octet_type;
		public String_typeContext string_type() {
			return getRuleContext(String_typeContext.class,0);
		}
		public Octet_typeContext octet_type() {
			return getRuleContext(Octet_typeContext.class,0);
		}
		public Boolean_typeContext boolean_type() {
			return getRuleContext(Boolean_typeContext.class,0);
		}
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Fixed_pt_const_typeContext fixed_pt_const_type() {
			return getRuleContext(Fixed_pt_const_typeContext.class,0);
		}
		public Wide_char_typeContext wide_char_type() {
			return getRuleContext(Wide_char_typeContext.class,0);
		}
		public Integer_typeContext integer_type() {
			return getRuleContext(Integer_typeContext.class,0);
		}
		public Char_typeContext char_type() {
			return getRuleContext(Char_typeContext.class,0);
		}
		public Wide_string_typeContext wide_string_type() {
			return getRuleContext(Wide_string_typeContext.class,0);
		}
		public Floating_pt_typeContext floating_pt_type() {
			return getRuleContext(Floating_pt_typeContext.class,0);
		}
		public Const_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_type; }
	}

	public final Const_typeContext const_type() throws RecognitionException {
		Const_typeContext _localctx = new Const_typeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_const_type);

		    Pair<String, Token> pair = null;

		try {
			setState(648);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(620); ((Const_typeContext)_localctx).integer_type = integer_type();
				 ((Const_typeContext)_localctx).typecode =  ((Const_typeContext)_localctx).integer_type.typecode; 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(623); ((Const_typeContext)_localctx).char_type = char_type();
				 ((Const_typeContext)_localctx).typecode =  ((Const_typeContext)_localctx).char_type.typecode; 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(626); ((Const_typeContext)_localctx).wide_char_type = wide_char_type();
				 ((Const_typeContext)_localctx).typecode =  ((Const_typeContext)_localctx).wide_char_type.typecode; 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(629); ((Const_typeContext)_localctx).boolean_type = boolean_type();
				 ((Const_typeContext)_localctx).typecode =  ((Const_typeContext)_localctx).boolean_type.typecode; 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(632); ((Const_typeContext)_localctx).floating_pt_type = floating_pt_type();
				 ((Const_typeContext)_localctx).typecode =  ((Const_typeContext)_localctx).floating_pt_type.typecode; 
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(635); ((Const_typeContext)_localctx).string_type = string_type();
				 ((Const_typeContext)_localctx).typecode =  ((Const_typeContext)_localctx).string_type.typecode; 
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(638); ((Const_typeContext)_localctx).wide_string_type = wide_string_type();
				 ((Const_typeContext)_localctx).typecode =  ((Const_typeContext)_localctx).wide_string_type.typecode; 
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(641); fixed_pt_const_type();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(642); ((Const_typeContext)_localctx).scoped_name = scoped_name();

						   pair = ((Const_typeContext)_localctx).scoped_name.pair;
					       // Find typecode in the global map.
					       ((Const_typeContext)_localctx).typecode =  ctx.getTypeCode(pair.first());
					       
					       if(_localctx.typecode == null)
					           throw new ParseException(pair.second(), "was not defined previously");
					    
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(645); ((Const_typeContext)_localctx).octet_type = octet_type();
				 ((Const_typeContext)_localctx).typecode =  ((Const_typeContext)_localctx).octet_type.typecode; 
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

	public static class Const_expContext extends ParserRuleContext {
		public String literalStr = null;
		public Or_exprContext or_expr;
		public Or_exprContext or_expr() {
			return getRuleContext(Or_exprContext.class,0);
		}
		public Const_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_exp; }
	}

	public final Const_expContext const_exp() throws RecognitionException {
		Const_expContext _localctx = new Const_expContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_const_exp);

		    String aux = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(650); ((Const_expContext)_localctx).or_expr = or_expr();
			 ((Const_expContext)_localctx).literalStr =  ((Const_expContext)_localctx).or_expr.literalStr; 
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

	public static class Or_exprContext extends ParserRuleContext {
		public String literalStr = null;
		public Xor_exprContext xor_expr;
		public List<Xor_exprContext> xor_expr() {
			return getRuleContexts(Xor_exprContext.class);
		}
		public List<TerminalNode> PIPE() { return getTokens(IDLParser.PIPE); }
		public Xor_exprContext xor_expr(int i) {
			return getRuleContext(Xor_exprContext.class,i);
		}
		public TerminalNode PIPE(int i) {
			return getToken(IDLParser.PIPE, i);
		}
		public Or_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_expr; }
	}

	public final Or_exprContext or_expr() throws RecognitionException {
		Or_exprContext _localctx = new Or_exprContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_or_expr);

		    String aux = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(653); ((Or_exprContext)_localctx).xor_expr = xor_expr();
			 ((Or_exprContext)_localctx).literalStr =  ((Or_exprContext)_localctx).xor_expr.literalStr; 
			setState(662);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PIPE) {
				{
				{
				_localctx.literalStr += _input.LT(1).getText();
				setState(656); match(PIPE);
				setState(657); ((Or_exprContext)_localctx).xor_expr = xor_expr();
				 aux=((Or_exprContext)_localctx).xor_expr.literalStr; _localctx.literalStr += aux;
				}
				}
				setState(664);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Xor_exprContext extends ParserRuleContext {
		public String literalStr = null;
		public And_exprContext and_expr;
		public List<And_exprContext> and_expr() {
			return getRuleContexts(And_exprContext.class);
		}
		public TerminalNode CARET(int i) {
			return getToken(IDLParser.CARET, i);
		}
		public List<TerminalNode> CARET() { return getTokens(IDLParser.CARET); }
		public And_exprContext and_expr(int i) {
			return getRuleContext(And_exprContext.class,i);
		}
		public Xor_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xor_expr; }
	}

	public final Xor_exprContext xor_expr() throws RecognitionException {
		Xor_exprContext _localctx = new Xor_exprContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_xor_expr);

		    String aux = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(665); ((Xor_exprContext)_localctx).and_expr = and_expr();
			 ((Xor_exprContext)_localctx).literalStr =  ((Xor_exprContext)_localctx).and_expr.literalStr; 
			setState(674);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CARET) {
				{
				{
				_localctx.literalStr += _input.LT(1).getText();
				setState(668); match(CARET);
				setState(669); ((Xor_exprContext)_localctx).and_expr = and_expr();
				 aux=((Xor_exprContext)_localctx).and_expr.literalStr; _localctx.literalStr += aux;
				}
				}
				setState(676);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class And_exprContext extends ParserRuleContext {
		public String literalStr = null;
		public Shift_exprContext shift_expr;
		public Shift_exprContext shift_expr(int i) {
			return getRuleContext(Shift_exprContext.class,i);
		}
		public List<Shift_exprContext> shift_expr() {
			return getRuleContexts(Shift_exprContext.class);
		}
		public List<TerminalNode> AMPERSAND() { return getTokens(IDLParser.AMPERSAND); }
		public TerminalNode AMPERSAND(int i) {
			return getToken(IDLParser.AMPERSAND, i);
		}
		public And_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expr; }
	}

	public final And_exprContext and_expr() throws RecognitionException {
		And_exprContext _localctx = new And_exprContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_and_expr);

		    String aux = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(677); ((And_exprContext)_localctx).shift_expr = shift_expr();
			 ((And_exprContext)_localctx).literalStr =  ((And_exprContext)_localctx).shift_expr.literalStr; 
			setState(686);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AMPERSAND) {
				{
				{
				_localctx.literalStr += _input.LT(1).getText();
				setState(680); match(AMPERSAND);
				setState(681); ((And_exprContext)_localctx).shift_expr = shift_expr();
				 aux=((And_exprContext)_localctx).shift_expr.literalStr; _localctx.literalStr += aux;
				}
				}
				setState(688);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Shift_exprContext extends ParserRuleContext {
		public String literalStr = null;
		public Add_exprContext add_expr;
		public List<TerminalNode> RIGHT_SHIFT() { return getTokens(IDLParser.RIGHT_SHIFT); }
		public List<Add_exprContext> add_expr() {
			return getRuleContexts(Add_exprContext.class);
		}
		public TerminalNode RIGHT_SHIFT(int i) {
			return getToken(IDLParser.RIGHT_SHIFT, i);
		}
		public Add_exprContext add_expr(int i) {
			return getRuleContext(Add_exprContext.class,i);
		}
		public List<TerminalNode> LEFT_SHIFT() { return getTokens(IDLParser.LEFT_SHIFT); }
		public TerminalNode LEFT_SHIFT(int i) {
			return getToken(IDLParser.LEFT_SHIFT, i);
		}
		public Shift_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expr; }
	}

	public final Shift_exprContext shift_expr() throws RecognitionException {
		Shift_exprContext _localctx = new Shift_exprContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_shift_expr);

		    String aux = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(689); ((Shift_exprContext)_localctx).add_expr = add_expr();
			 ((Shift_exprContext)_localctx).literalStr =  ((Shift_exprContext)_localctx).add_expr.literalStr; 
			setState(698);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RIGHT_SHIFT || _la==LEFT_SHIFT) {
				{
				{
				_localctx.literalStr += _input.LT(1).getText();
				setState(692);
				_la = _input.LA(1);
				if ( !(_la==RIGHT_SHIFT || _la==LEFT_SHIFT) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(693); ((Shift_exprContext)_localctx).add_expr = add_expr();
				 aux=((Shift_exprContext)_localctx).add_expr.literalStr; _localctx.literalStr += aux;
				}
				}
				setState(700);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Add_exprContext extends ParserRuleContext {
		public String literalStr = null;
		public Mult_exprContext mult_expr;
		public TerminalNode MINUS(int i) {
			return getToken(IDLParser.MINUS, i);
		}
		public List<Mult_exprContext> mult_expr() {
			return getRuleContexts(Mult_exprContext.class);
		}
		public Mult_exprContext mult_expr(int i) {
			return getRuleContext(Mult_exprContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(IDLParser.PLUS); }
		public List<TerminalNode> MINUS() { return getTokens(IDLParser.MINUS); }
		public TerminalNode PLUS(int i) {
			return getToken(IDLParser.PLUS, i);
		}
		public Add_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add_expr; }
	}

	public final Add_exprContext add_expr() throws RecognitionException {
		Add_exprContext _localctx = new Add_exprContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_add_expr);

		    String aux = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(701); ((Add_exprContext)_localctx).mult_expr = mult_expr();
			 ((Add_exprContext)_localctx).literalStr =  ((Add_exprContext)_localctx).mult_expr.literalStr; 
			setState(710);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				_localctx.literalStr += _input.LT(1).getText();
				setState(704);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(705); ((Add_exprContext)_localctx).mult_expr = mult_expr();
				 aux=((Add_exprContext)_localctx).mult_expr.literalStr; _localctx.literalStr += aux;
				}
				}
				setState(712);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Mult_exprContext extends ParserRuleContext {
		public String literalStr = null;
		public Unary_exprContext unary_expr;
		public List<Unary_exprContext> unary_expr() {
			return getRuleContexts(Unary_exprContext.class);
		}
		public Unary_exprContext unary_expr(int i) {
			return getRuleContext(Unary_exprContext.class,i);
		}
		public List<TerminalNode> SLASH() { return getTokens(IDLParser.SLASH); }
		public TerminalNode PERCENT(int i) {
			return getToken(IDLParser.PERCENT, i);
		}
		public TerminalNode SLASH(int i) {
			return getToken(IDLParser.SLASH, i);
		}
		public List<TerminalNode> PERCENT() { return getTokens(IDLParser.PERCENT); }
		public Mult_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult_expr; }
	}

	public final Mult_exprContext mult_expr() throws RecognitionException {
		Mult_exprContext _localctx = new Mult_exprContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_mult_expr);

		    String aux = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(713); ((Mult_exprContext)_localctx).unary_expr = unary_expr();
			 ((Mult_exprContext)_localctx).literalStr =  ((Mult_exprContext)_localctx).unary_expr.literalStr; 
			setState(722);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SLASH) | (1L << STAR) | (1L << PERCENT))) != 0)) {
				{
				{
				_localctx.literalStr += _input.LT(1).getText();
				setState(716);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SLASH) | (1L << STAR) | (1L << PERCENT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(717); ((Mult_exprContext)_localctx).unary_expr = unary_expr();
				 aux=((Mult_exprContext)_localctx).unary_expr.literalStr; _localctx.literalStr += aux;
				}
				}
				setState(724);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Unary_exprContext extends ParserRuleContext {
		public String literalStr = null;
		public Primary_exprContext primary_expr;
		public Primary_exprContext primary_expr() {
			return getRuleContext(Primary_exprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(IDLParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(IDLParser.PLUS, 0); }
		public TerminalNode TILDE() { return getToken(IDLParser.TILDE, 0); }
		public Unary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expr; }
	}

	public final Unary_exprContext unary_expr() throws RecognitionException {
		Unary_exprContext _localctx = new Unary_exprContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_unary_expr);

		    String aux = null;

		int _la;
		try {
			setState(733);
			switch (_input.LA(1)) {
			case TILDE:
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				_localctx.literalStr += _input.LT(1).getText();
				setState(726);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TILDE) | (1L << PLUS) | (1L << MINUS))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(727); ((Unary_exprContext)_localctx).primary_expr = primary_expr();
				 aux=((Unary_exprContext)_localctx).primary_expr.literalStr; _localctx.literalStr += aux;
				}
				break;
			case 1:
			case 2:
			case INTEGER_LITERAL:
			case HEX_LITERAL:
			case FLOATING_PT_LITERAL:
			case FIXED_PT_LITERAL:
			case WIDE_CHARACTER_LITERAL:
			case CHARACTER_LITERAL:
			case WIDE_STRING_LITERAL:
			case STRING_LITERAL:
			case LEFT_BRACKET:
			case DOUBLE_COLON:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(730); ((Unary_exprContext)_localctx).primary_expr = primary_expr();
				 ((Unary_exprContext)_localctx).literalStr =  ((Unary_exprContext)_localctx).primary_expr.literalStr; 
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

	public static class Primary_exprContext extends ParserRuleContext {
		public String literalStr = null;
		public Scoped_nameContext scoped_name;
		public LiteralContext literal;
		public Const_expContext const_exp;
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public Const_expContext const_exp() {
			return getRuleContext(Const_expContext.class,0);
		}
		public Primary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expr; }
	}

	public final Primary_exprContext primary_expr() throws RecognitionException {
		Primary_exprContext _localctx = new Primary_exprContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_primary_expr);

		    String aux = null;

		try {
			setState(747);
			switch (_input.LA(1)) {
			case DOUBLE_COLON:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(735); ((Primary_exprContext)_localctx).scoped_name = scoped_name();
				 ((Primary_exprContext)_localctx).literalStr =  ((Primary_exprContext)_localctx).scoped_name.pair.first(); 
				}
				break;
			case 1:
			case 2:
			case INTEGER_LITERAL:
			case HEX_LITERAL:
			case FLOATING_PT_LITERAL:
			case FIXED_PT_LITERAL:
			case WIDE_CHARACTER_LITERAL:
			case CHARACTER_LITERAL:
			case WIDE_STRING_LITERAL:
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(738); ((Primary_exprContext)_localctx).literal = literal();
				 ((Primary_exprContext)_localctx).literalStr =  ((Primary_exprContext)_localctx).literal.pair.first(); 
				}
				break;
			case LEFT_BRACKET:
				enterOuterAlt(_localctx, 3);
				{
				((Primary_exprContext)_localctx).literalStr =  _input.LT(1).getText();
				setState(742); match(LEFT_BRACKET);
				setState(743); ((Primary_exprContext)_localctx).const_exp = const_exp();
				 aux=((Primary_exprContext)_localctx).const_exp.literalStr; _localctx.literalStr += aux; _localctx.literalStr += _input.LT(1).getText();
				setState(745); match(RIGHT_BRACKET);
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

	public static class LiteralContext extends ParserRuleContext {
		public Pair<String, Token> pair = null;
		public Boolean_literalContext boolean_literal;
		public TerminalNode FLOATING_PT_LITERAL() { return getToken(IDLParser.FLOATING_PT_LITERAL, 0); }
		public TerminalNode INTEGER_LITERAL() { return getToken(IDLParser.INTEGER_LITERAL, 0); }
		public TerminalNode WIDE_CHARACTER_LITERAL() { return getToken(IDLParser.WIDE_CHARACTER_LITERAL, 0); }
		public TerminalNode FIXED_PT_LITERAL() { return getToken(IDLParser.FIXED_PT_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(IDLParser.STRING_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(IDLParser.HEX_LITERAL, 0); }
		public TerminalNode CHARACTER_LITERAL() { return getToken(IDLParser.CHARACTER_LITERAL, 0); }
		public TerminalNode WIDE_STRING_LITERAL() { return getToken(IDLParser.WIDE_STRING_LITERAL, 0); }
		public Boolean_literalContext boolean_literal() {
			return getRuleContext(Boolean_literalContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_literal);

		    Token tk = _input.LT(1);
		    String literalStr = tk.getText();

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(760);
			switch (_input.LA(1)) {
			case HEX_LITERAL:
				{
				setState(749); match(HEX_LITERAL);
				}
				break;
			case INTEGER_LITERAL:
				{
				setState(750); match(INTEGER_LITERAL);
				}
				break;
			case STRING_LITERAL:
				{
				setState(751); match(STRING_LITERAL);
				}
				break;
			case WIDE_STRING_LITERAL:
				{
				setState(752); match(WIDE_STRING_LITERAL);
				}
				break;
			case CHARACTER_LITERAL:
				{
				setState(753); match(CHARACTER_LITERAL);
				}
				break;
			case WIDE_CHARACTER_LITERAL:
				{
				setState(754); match(WIDE_CHARACTER_LITERAL);
				}
				break;
			case FIXED_PT_LITERAL:
				{
				setState(755); match(FIXED_PT_LITERAL);
				}
				break;
			case FLOATING_PT_LITERAL:
				{
				setState(756); match(FLOATING_PT_LITERAL);
				}
				break;
			case 1:
			case 2:
				{
				setState(757); ((LiteralContext)_localctx).boolean_literal = boolean_literal();
				literalStr = ((LiteralContext)_localctx).boolean_literal.literalStr;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			((LiteralContext)_localctx).pair =  new Pair<String, Token>(literalStr, tk);
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

	public static class Boolean_literalContext extends ParserRuleContext {
		public String literalStr = null;
		public Boolean_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_literal; }
	}

	public final Boolean_literalContext boolean_literal() throws RecognitionException {
		Boolean_literalContext _localctx = new Boolean_literalContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_boolean_literal);
		try {
			setState(768);
			switch (_input.LA(1)) {
			case 2:
				enterOuterAlt(_localctx, 1);
				{
				setState(764); match(2);
				 ((Boolean_literalContext)_localctx).literalStr =  "true";
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 2);
				{
				setState(766); match(1);
				 ((Boolean_literalContext)_localctx).literalStr =  "false";
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

	public static class Positive_int_constContext extends ParserRuleContext {
		public String literalStr = null;
		public Const_expContext const_exp;
		public Const_expContext const_exp() {
			return getRuleContext(Const_expContext.class,0);
		}
		public Positive_int_constContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_positive_int_const; }
	}

	public final Positive_int_constContext positive_int_const() throws RecognitionException {
		Positive_int_constContext _localctx = new Positive_int_constContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_positive_int_const);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(770); ((Positive_int_constContext)_localctx).const_exp = const_exp();
			 ((Positive_int_constContext)_localctx).literalStr =  ((Positive_int_constContext)_localctx).const_exp.literalStr; 

			           // TODO Calcular la expresion
			           /*try {
			               int value = Integer.parseInt(_localctx.literalStr);

			               if(value < 0)
			                   throw new ParseException(_localctx.literalStr, "expression is not supported. You must use a positive integer.");
			           } catch(NumberFormatException e) {
			           }*/
			       
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

	public static class Type_declContext extends ParserRuleContext {
		public Vector<Annotation> annotations;
		public Pair<Vector<TypeDeclaration>, TemplateGroup> returnPair = null;
		public Type_declaratorContext type_declarator;
		public Struct_typeContext struct_type;
		public Union_typeContext union_type;
		public Enum_typeContext enum_type;
		public TerminalNode KW_NATIVE() { return getToken(IDLParser.KW_NATIVE, 0); }
		public Union_typeContext union_type() {
			return getRuleContext(Union_typeContext.class,0);
		}
		public Type_declaratorContext type_declarator() {
			return getRuleContext(Type_declaratorContext.class,0);
		}
		public Enum_typeContext enum_type() {
			return getRuleContext(Enum_typeContext.class,0);
		}
		public Simple_declaratorContext simple_declarator() {
			return getRuleContext(Simple_declaratorContext.class,0);
		}
		public Struct_typeContext struct_type() {
			return getRuleContext(Struct_typeContext.class,0);
		}
		public Constr_forward_declContext constr_forward_decl() {
			return getRuleContext(Constr_forward_declContext.class,0);
		}
		public TerminalNode KW_TYPEDEF() { return getToken(IDLParser.KW_TYPEDEF, 0); }
		public Type_declContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Type_declContext(ParserRuleContext parent, int invokingState, Vector<Annotation> annotations) {
			super(parent, invokingState);
			this.annotations = annotations;
		}
		@Override public int getRuleIndex() { return RULE_type_decl; }
	}

	public final Type_declContext type_decl(Vector<Annotation> annotations) throws RecognitionException {
		Type_declContext _localctx = new Type_declContext(_ctx, getState(), annotations);
		enterRule(_localctx, 86, RULE_type_decl);

		    Pair<Vector<TypeCode>, TemplateGroup> ttg = null;
		    Vector<TypeDeclaration> vector = null;
		    Token tk = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(792);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(774); match(KW_TYPEDEF);
				tk = _input.LT(1);
				setState(776); ((Type_declContext)_localctx).type_declarator = type_declarator();
				 ttg=((Type_declContext)_localctx).type_declarator.returnPair; 
				}
				break;

			case 2:
				{
				setState(779); ((Type_declContext)_localctx).struct_type = struct_type();
				 ttg=((Type_declContext)_localctx).struct_type.returnPair; 
				}
				break;

			case 3:
				{
				setState(782); ((Type_declContext)_localctx).union_type = union_type();
				 ttg=((Type_declContext)_localctx).union_type.returnPair; 
				}
				break;

			case 4:
				{
				setState(785); ((Type_declContext)_localctx).enum_type = enum_type();
				 ttg=((Type_declContext)_localctx).enum_type.returnPair; 
				}
				break;

			case 5:
				{
				setState(788); match(KW_NATIVE);
				 System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Native declarations are not supported. Ignoring..."); 
				setState(790); simple_declarator();
				}
				break;

			case 6:
				{
				setState(791); constr_forward_decl();
				}
				break;
			}

				    if(ttg!=null)
			        {
			            vector = new Vector<TypeDeclaration>();

			            for(int count = 0; count < ttg.first().size(); ++count)
			            {
			                String name = null;
			                if(ttg.first().get(count) instanceof MemberedTypeCode)
			                    name = ((MemberedTypeCode)ttg.first().get(count)).getName();
			                else if(ttg.first().get(count) instanceof AliasTypeCode)
			                    name = ((AliasTypeCode)ttg.first().get(count)).getName();

			                TypeDeclaration typedeclaration = new TypeDeclaration(ctx.getScopeFile(), ctx.isInScopedFile(), ctx.getScope(), name, ttg.first().get(count), tk);

			                // Add annotations
			                for(Annotation annotation : annotations)
			                    typedeclaration.addAnnotation(ctx, annotation);

			                // Add type declaration to the map with all typedeclarations.
			                ctx.addTypeDeclaration(typedeclaration);

			                vector.add(typedeclaration);

			                ((Type_declContext)_localctx).returnPair =  new Pair<Vector<TypeDeclaration>, TemplateGroup>(vector, ttg.second());
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

	public static class Type_declaratorContext extends ParserRuleContext {
		public Pair<Vector<TypeCode>, TemplateGroup> returnPair = null;
		public Type_specContext type_spec;
		public DeclaratorsContext declarators;
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public DeclaratorsContext declarators() {
			return getRuleContext(DeclaratorsContext.class,0);
		}
		public Type_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_declarator; }
	}

	public final Type_declaratorContext type_declarator() throws RecognitionException {
		Type_declaratorContext _localctx = new Type_declaratorContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_type_declarator);

		    Vector<TypeCode> vector = null;
		    AliasTypeCode typedefTypecode = null;
		    TemplateGroup typedefTemplates =  null;
			if(tmanager != null) {
				typedefTemplates = tmanager.createTemplateGroup("typedef_decl");
			}

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(796); ((Type_declaratorContext)_localctx).type_spec = type_spec();
			setState(797); ((Type_declaratorContext)_localctx).declarators = declarators();

				   if(((Type_declaratorContext)_localctx).type_spec.typecode != null)
				   {
			           vector = new Vector<TypeCode>();

				       for(int count = 0; count < ((Type_declaratorContext)_localctx).declarators.ret.size(); ++count)
				       {
				           typedefTypecode = new AliasTypeCode(ctx.getScope(), ((Type_declaratorContext)_localctx).declarators.ret.get(count).first().first());
				           
				           if(((Type_declaratorContext)_localctx).declarators.ret.get(count).second() != null)
				           {
				               // Array declaration
				               ((Type_declaratorContext)_localctx).declarators.ret.get(count).second().setContentTypeCode(((Type_declaratorContext)_localctx).type_spec.typecode);
				               typedefTypecode.setContentTypeCode(((Type_declaratorContext)_localctx).declarators.ret.get(count).second());
				           }
				           else
				           {
				               // Simple declaration
				               typedefTypecode.setContentTypeCode(((Type_declaratorContext)_localctx).type_spec.typecode);
				           }
				           
						   if(typedefTemplates != null) {
								typedefTemplates.setAttribute("typedefs", typedefTypecode);
						   }

			               vector.add(typedefTypecode);
				       }

						if(typedefTemplates != null) {
							typedefTemplates.setAttribute("ctx", ctx);
						}

			            ((Type_declaratorContext)_localctx).returnPair =  new Pair<Vector<TypeCode>, TemplateGroup>(vector, typedefTemplates);
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

	public static class Type_specContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Simple_type_specContext simple_type_spec;
		public Simple_type_specContext simple_type_spec() {
			return getRuleContext(Simple_type_specContext.class,0);
		}
		public Constr_type_specContext constr_type_spec() {
			return getRuleContext(Constr_type_specContext.class,0);
		}
		public Type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_spec; }
	}

	public final Type_specContext type_spec() throws RecognitionException {
		Type_specContext _localctx = new Type_specContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_type_spec);
		try {
			setState(804);
			switch (_input.LA(1)) {
			case DOUBLE_COLON:
			case KW_STRING:
			case KW_OCTET:
			case KW_SEQUENCE:
			case KW_WCHAR:
			case KW_SHORT:
			case KW_LONG:
			case KW_WSTRING:
			case KW_VALUEBASE:
			case KW_OBJECT:
			case KW_UNSIGNED:
			case KW_FIXED:
			case KW_ANY:
			case KW_CHAR:
			case KW_FLOAT:
			case KW_BOOLEAN:
			case KW_DOUBLE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(800); ((Type_specContext)_localctx).simple_type_spec = simple_type_spec();
				 ((Type_specContext)_localctx).typecode = ((Type_specContext)_localctx).simple_type_spec.typecode; 
				}
				break;
			case KW_STRUCT:
			case KW_ENUM:
			case KW_UNION:
				enterOuterAlt(_localctx, 2);
				{
				setState(803); constr_type_spec();
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

	public static class Simple_type_specContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Base_type_specContext base_type_spec;
		public Template_type_specContext template_type_spec;
		public Scoped_nameContext scoped_name;
		public Base_type_specContext base_type_spec() {
			return getRuleContext(Base_type_specContext.class,0);
		}
		public Template_type_specContext template_type_spec() {
			return getRuleContext(Template_type_specContext.class,0);
		}
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Simple_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_type_spec; }
	}

	public final Simple_type_specContext simple_type_spec() throws RecognitionException {
		Simple_type_specContext _localctx = new Simple_type_specContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_simple_type_spec);

		    Pair<String, Token> pair = null;

		try {
			setState(815);
			switch (_input.LA(1)) {
			case KW_OCTET:
			case KW_WCHAR:
			case KW_SHORT:
			case KW_LONG:
			case KW_VALUEBASE:
			case KW_OBJECT:
			case KW_UNSIGNED:
			case KW_ANY:
			case KW_CHAR:
			case KW_FLOAT:
			case KW_BOOLEAN:
			case KW_DOUBLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(806); ((Simple_type_specContext)_localctx).base_type_spec = base_type_spec();
				 ((Simple_type_specContext)_localctx).typecode = ((Simple_type_specContext)_localctx).base_type_spec.typecode; 
				}
				break;
			case KW_STRING:
			case KW_SEQUENCE:
			case KW_WSTRING:
			case KW_FIXED:
				enterOuterAlt(_localctx, 2);
				{
				setState(809); ((Simple_type_specContext)_localctx).template_type_spec = template_type_spec();
				 ((Simple_type_specContext)_localctx).typecode = ((Simple_type_specContext)_localctx).template_type_spec.typecode; 
				}
				break;
			case DOUBLE_COLON:
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(812); ((Simple_type_specContext)_localctx).scoped_name = scoped_name();

						   pair=((Simple_type_specContext)_localctx).scoped_name.pair;
							
					       // Find typecode in the global map.
					       ((Simple_type_specContext)_localctx).typecode =  ctx.getTypeCode(pair.first());
					       
					       if(_localctx.typecode == null)
					           throw new ParseException(pair.second(), "was not defined previously");
					    
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

	public static class Base_type_specContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Floating_pt_typeContext floating_pt_type;
		public Integer_typeContext integer_type;
		public Char_typeContext char_type;
		public Wide_char_typeContext wide_char_type;
		public Boolean_typeContext boolean_type;
		public Octet_typeContext octet_type;
		public Octet_typeContext octet_type() {
			return getRuleContext(Octet_typeContext.class,0);
		}
		public Value_base_typeContext value_base_type() {
			return getRuleContext(Value_base_typeContext.class,0);
		}
		public Boolean_typeContext boolean_type() {
			return getRuleContext(Boolean_typeContext.class,0);
		}
		public Wide_char_typeContext wide_char_type() {
			return getRuleContext(Wide_char_typeContext.class,0);
		}
		public Any_typeContext any_type() {
			return getRuleContext(Any_typeContext.class,0);
		}
		public Integer_typeContext integer_type() {
			return getRuleContext(Integer_typeContext.class,0);
		}
		public Char_typeContext char_type() {
			return getRuleContext(Char_typeContext.class,0);
		}
		public Floating_pt_typeContext floating_pt_type() {
			return getRuleContext(Floating_pt_typeContext.class,0);
		}
		public Object_typeContext object_type() {
			return getRuleContext(Object_typeContext.class,0);
		}
		public Base_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type_spec; }
	}

	public final Base_type_specContext base_type_spec() throws RecognitionException {
		Base_type_specContext _localctx = new Base_type_specContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_base_type_spec);
		try {
			setState(838);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(817); ((Base_type_specContext)_localctx).floating_pt_type = floating_pt_type();
				 ((Base_type_specContext)_localctx).typecode = ((Base_type_specContext)_localctx).floating_pt_type.typecode; 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(820); ((Base_type_specContext)_localctx).integer_type = integer_type();
				 ((Base_type_specContext)_localctx).typecode = ((Base_type_specContext)_localctx).integer_type.typecode; 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(823); ((Base_type_specContext)_localctx).char_type = char_type();
				 ((Base_type_specContext)_localctx).typecode = ((Base_type_specContext)_localctx).char_type.typecode; 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(826); ((Base_type_specContext)_localctx).wide_char_type = wide_char_type();
				 ((Base_type_specContext)_localctx).typecode = ((Base_type_specContext)_localctx).wide_char_type.typecode; 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(829); ((Base_type_specContext)_localctx).boolean_type = boolean_type();
				 ((Base_type_specContext)_localctx).typecode = ((Base_type_specContext)_localctx).boolean_type.typecode; 
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(832); ((Base_type_specContext)_localctx).octet_type = octet_type();
				 ((Base_type_specContext)_localctx).typecode = ((Base_type_specContext)_localctx).octet_type.typecode; 
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(835); any_type();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(836); object_type();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(837); value_base_type();
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

	public static class Template_type_specContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Sequence_typeContext sequence_type;
		public String_typeContext string_type;
		public Wide_string_typeContext wide_string_type;
		public Sequence_typeContext sequence_type() {
			return getRuleContext(Sequence_typeContext.class,0);
		}
		public String_typeContext string_type() {
			return getRuleContext(String_typeContext.class,0);
		}
		public Fixed_pt_typeContext fixed_pt_type() {
			return getRuleContext(Fixed_pt_typeContext.class,0);
		}
		public Wide_string_typeContext wide_string_type() {
			return getRuleContext(Wide_string_typeContext.class,0);
		}
		public Template_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_type_spec; }
	}

	public final Template_type_specContext template_type_spec() throws RecognitionException {
		Template_type_specContext _localctx = new Template_type_specContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_template_type_spec);
		try {
			setState(850);
			switch (_input.LA(1)) {
			case KW_SEQUENCE:
				enterOuterAlt(_localctx, 1);
				{
				setState(840); ((Template_type_specContext)_localctx).sequence_type = sequence_type();
				 ((Template_type_specContext)_localctx).typecode = ((Template_type_specContext)_localctx).sequence_type.typecode; 
				}
				break;
			case KW_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(843); ((Template_type_specContext)_localctx).string_type = string_type();
				 ((Template_type_specContext)_localctx).typecode = ((Template_type_specContext)_localctx).string_type.typecode; 
				}
				break;
			case KW_WSTRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(846); ((Template_type_specContext)_localctx).wide_string_type = wide_string_type();
				 ((Template_type_specContext)_localctx).typecode = ((Template_type_specContext)_localctx).wide_string_type.typecode; 
				}
				break;
			case KW_FIXED:
				enterOuterAlt(_localctx, 4);
				{
				setState(849); fixed_pt_type();
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

	public static class Constr_type_specContext extends ParserRuleContext {
		public Union_typeContext union_type() {
			return getRuleContext(Union_typeContext.class,0);
		}
		public Enum_typeContext enum_type() {
			return getRuleContext(Enum_typeContext.class,0);
		}
		public Struct_typeContext struct_type() {
			return getRuleContext(Struct_typeContext.class,0);
		}
		public Constr_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constr_type_spec; }
	}

	public final Constr_type_specContext constr_type_spec() throws RecognitionException {
		Constr_type_specContext _localctx = new Constr_type_specContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_constr_type_spec);
		try {
			setState(855);
			switch (_input.LA(1)) {
			case KW_STRUCT:
				enterOuterAlt(_localctx, 1);
				{
				setState(852); struct_type();
				}
				break;
			case KW_UNION:
				enterOuterAlt(_localctx, 2);
				{
				setState(853); union_type();
				}
				break;
			case KW_ENUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(854); enum_type();
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

	public static class DeclaratorsContext extends ParserRuleContext {
		public Vector<Pair<Pair<String, Token>, ContainerTypeCode>> ret = new Vector<Pair<Pair<String, Token>, ContainerTypeCode>>();
		public DeclaratorContext declarator;
		public List<DeclaratorContext> declarator() {
			return getRuleContexts(DeclaratorContext.class);
		}
		public DeclaratorContext declarator(int i) {
			return getRuleContext(DeclaratorContext.class,i);
		}
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public DeclaratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarators; }
	}

	public final DeclaratorsContext declarators() throws RecognitionException {
		DeclaratorsContext _localctx = new DeclaratorsContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_declarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(857); ((DeclaratorsContext)_localctx).declarator = declarator();

			            if(((DeclaratorsContext)_localctx).declarator.ret != null)
			                _localctx.ret.add(((DeclaratorsContext)_localctx).declarator.ret);
			            else
			                throw new ParseException(null, "Cannot parse type declarator");
			        
			setState(865);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(859); match(COMA);
				setState(860); ((DeclaratorsContext)_localctx).declarator = declarator();

				            if(((DeclaratorsContext)_localctx).declarator.ret != null)
				                _localctx.ret.add(((DeclaratorsContext)_localctx).declarator.ret);
				            else
				                throw new ParseException(null, "Cannot parse type declarator");
				        
				}
				}
				setState(867);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class DeclaratorContext extends ParserRuleContext {
		public Pair<Pair<String, Token>, ContainerTypeCode> ret = null;
		public Simple_declaratorContext simple_declarator;
		public Complex_declaratorContext complex_declarator;
		public Complex_declaratorContext complex_declarator() {
			return getRuleContext(Complex_declaratorContext.class,0);
		}
		public Simple_declaratorContext simple_declarator() {
			return getRuleContext(Simple_declaratorContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_declarator);
		try {
			setState(874);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(868); ((DeclaratorContext)_localctx).simple_declarator = simple_declarator();
				 ((DeclaratorContext)_localctx).ret = ((DeclaratorContext)_localctx).simple_declarator.ret; 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(871); ((DeclaratorContext)_localctx).complex_declarator = complex_declarator();
				 ((DeclaratorContext)_localctx).ret = ((DeclaratorContext)_localctx).complex_declarator.ret; 
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

	public static class Simple_declaratorContext extends ParserRuleContext {
		public Pair<Pair<String, Token>, ContainerTypeCode> ret = null;
		public IdentifierContext identifier;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Simple_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_declarator; }
	}

	public final Simple_declaratorContext simple_declarator() throws RecognitionException {
		Simple_declaratorContext _localctx = new Simple_declaratorContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_simple_declarator);

		    Token tk = _input.LT(1);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(876); ((Simple_declaratorContext)_localctx).identifier = identifier();

			           Pair<String, Token> p = new Pair<String, Token>(((Simple_declaratorContext)_localctx).identifier.id, tk);
				       ((Simple_declaratorContext)_localctx).ret =  new Pair<Pair<String, Token>, ContainerTypeCode>(p, null);
				   
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

	public static class Complex_declaratorContext extends ParserRuleContext {
		public Pair<Pair<String, Token>, ContainerTypeCode> ret = null;
		public Array_declaratorContext array_declarator;
		public Array_declaratorContext array_declarator() {
			return getRuleContext(Array_declaratorContext.class,0);
		}
		public Complex_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complex_declarator; }
	}

	public final Complex_declaratorContext complex_declarator() throws RecognitionException {
		Complex_declaratorContext _localctx = new Complex_declaratorContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_complex_declarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(879); ((Complex_declaratorContext)_localctx).array_declarator = array_declarator();
			 ((Complex_declaratorContext)_localctx).ret = ((Complex_declaratorContext)_localctx).array_declarator.pair; 
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

	public static class Floating_pt_typeContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public TerminalNode KW_LONG() { return getToken(IDLParser.KW_LONG, 0); }
		public TerminalNode KW_DOUBLE() { return getToken(IDLParser.KW_DOUBLE, 0); }
		public TerminalNode KW_FLOAT() { return getToken(IDLParser.KW_FLOAT, 0); }
		public Floating_pt_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floating_pt_type; }
	}

	public final Floating_pt_typeContext floating_pt_type() throws RecognitionException {
		Floating_pt_typeContext _localctx = new Floating_pt_typeContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_floating_pt_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(889);
			switch (_input.LA(1)) {
			case KW_FLOAT:
				{
				setState(882); match(KW_FLOAT);
				 ((Floating_pt_typeContext)_localctx).typecode =  new PrimitiveTypeCode(TypeCode.KIND_FLOAT);
				}
				break;
			case KW_DOUBLE:
				{
				setState(884); match(KW_DOUBLE);
				 ((Floating_pt_typeContext)_localctx).typecode =  new PrimitiveTypeCode(TypeCode.KIND_DOUBLE);
				}
				break;
			case KW_LONG:
				{
				setState(886); match(KW_LONG);
				setState(887); match(KW_DOUBLE);
				 ((Floating_pt_typeContext)_localctx).typecode =  new PrimitiveTypeCode(TypeCode.KIND_LONGDOUBLE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Integer_typeContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Signed_intContext signed_int;
		public Unsigned_intContext unsigned_int;
		public Unsigned_intContext unsigned_int() {
			return getRuleContext(Unsigned_intContext.class,0);
		}
		public Signed_intContext signed_int() {
			return getRuleContext(Signed_intContext.class,0);
		}
		public Integer_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_type; }
	}

	public final Integer_typeContext integer_type() throws RecognitionException {
		Integer_typeContext _localctx = new Integer_typeContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_integer_type);
		try {
			setState(897);
			switch (_input.LA(1)) {
			case KW_SHORT:
			case KW_LONG:
				enterOuterAlt(_localctx, 1);
				{
				setState(891); ((Integer_typeContext)_localctx).signed_int = signed_int();
				 ((Integer_typeContext)_localctx).typecode =  ((Integer_typeContext)_localctx).signed_int.typecode; 
				}
				break;
			case KW_UNSIGNED:
				enterOuterAlt(_localctx, 2);
				{
				setState(894); ((Integer_typeContext)_localctx).unsigned_int = unsigned_int();
				 ((Integer_typeContext)_localctx).typecode =  ((Integer_typeContext)_localctx).unsigned_int.typecode; 
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

	public static class Signed_intContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Signed_short_intContext signed_short_int;
		public Signed_long_intContext signed_long_int;
		public Signed_longlong_intContext signed_longlong_int;
		public Signed_long_intContext signed_long_int() {
			return getRuleContext(Signed_long_intContext.class,0);
		}
		public Signed_longlong_intContext signed_longlong_int() {
			return getRuleContext(Signed_longlong_intContext.class,0);
		}
		public Signed_short_intContext signed_short_int() {
			return getRuleContext(Signed_short_intContext.class,0);
		}
		public Signed_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_int; }
	}

	public final Signed_intContext signed_int() throws RecognitionException {
		Signed_intContext _localctx = new Signed_intContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_signed_int);
		try {
			setState(908);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(899); ((Signed_intContext)_localctx).signed_short_int = signed_short_int();
				 ((Signed_intContext)_localctx).typecode =  ((Signed_intContext)_localctx).signed_short_int.typecode; 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(902); ((Signed_intContext)_localctx).signed_long_int = signed_long_int();
				 ((Signed_intContext)_localctx).typecode =  ((Signed_intContext)_localctx).signed_long_int.typecode; 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(905); ((Signed_intContext)_localctx).signed_longlong_int = signed_longlong_int();
				 ((Signed_intContext)_localctx).typecode =  ((Signed_intContext)_localctx).signed_longlong_int.typecode; 
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

	public static class Signed_short_intContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_SHORT() { return getToken(IDLParser.KW_SHORT, 0); }
		public Signed_short_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_short_int; }
	}

	public final Signed_short_intContext signed_short_int() throws RecognitionException {
		Signed_short_intContext _localctx = new Signed_short_intContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_signed_short_int);

			((Signed_short_intContext)_localctx).typecode =  new PrimitiveTypeCode(TypeCode.KIND_SHORT);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(910); match(KW_SHORT);
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

	public static class Signed_long_intContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_LONG() { return getToken(IDLParser.KW_LONG, 0); }
		public Signed_long_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_long_int; }
	}

	public final Signed_long_intContext signed_long_int() throws RecognitionException {
		Signed_long_intContext _localctx = new Signed_long_intContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_signed_long_int);

			((Signed_long_intContext)_localctx).typecode =  new PrimitiveTypeCode(TypeCode.KIND_LONG);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(912); match(KW_LONG);
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

	public static class Signed_longlong_intContext extends ParserRuleContext {
		public TypeCode typecode;
		public List<TerminalNode> KW_LONG() { return getTokens(IDLParser.KW_LONG); }
		public TerminalNode KW_LONG(int i) {
			return getToken(IDLParser.KW_LONG, i);
		}
		public Signed_longlong_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_longlong_int; }
	}

	public final Signed_longlong_intContext signed_longlong_int() throws RecognitionException {
		Signed_longlong_intContext _localctx = new Signed_longlong_intContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_signed_longlong_int);

			((Signed_longlong_intContext)_localctx).typecode =  new PrimitiveTypeCode(TypeCode.KIND_LONGLONG);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(914); match(KW_LONG);
			setState(915); match(KW_LONG);
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

	public static class Unsigned_intContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Unsigned_short_intContext unsigned_short_int;
		public Unsigned_long_intContext unsigned_long_int;
		public Unsigned_longlong_intContext unsigned_longlong_int;
		public Unsigned_longlong_intContext unsigned_longlong_int() {
			return getRuleContext(Unsigned_longlong_intContext.class,0);
		}
		public Unsigned_long_intContext unsigned_long_int() {
			return getRuleContext(Unsigned_long_intContext.class,0);
		}
		public Unsigned_short_intContext unsigned_short_int() {
			return getRuleContext(Unsigned_short_intContext.class,0);
		}
		public Unsigned_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_int; }
	}

	public final Unsigned_intContext unsigned_int() throws RecognitionException {
		Unsigned_intContext _localctx = new Unsigned_intContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_unsigned_int);
		try {
			setState(926);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(917); ((Unsigned_intContext)_localctx).unsigned_short_int = unsigned_short_int();
				 ((Unsigned_intContext)_localctx).typecode =  ((Unsigned_intContext)_localctx).unsigned_short_int.typecode; 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(920); ((Unsigned_intContext)_localctx).unsigned_long_int = unsigned_long_int();
				 ((Unsigned_intContext)_localctx).typecode =  ((Unsigned_intContext)_localctx).unsigned_long_int.typecode; 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(923); ((Unsigned_intContext)_localctx).unsigned_longlong_int = unsigned_longlong_int();
				 ((Unsigned_intContext)_localctx).typecode =  ((Unsigned_intContext)_localctx).unsigned_longlong_int.typecode; 
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

	public static class Unsigned_short_intContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_SHORT() { return getToken(IDLParser.KW_SHORT, 0); }
		public TerminalNode KW_UNSIGNED() { return getToken(IDLParser.KW_UNSIGNED, 0); }
		public Unsigned_short_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_short_int; }
	}

	public final Unsigned_short_intContext unsigned_short_int() throws RecognitionException {
		Unsigned_short_intContext _localctx = new Unsigned_short_intContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_unsigned_short_int);

			((Unsigned_short_intContext)_localctx).typecode =  new PrimitiveTypeCode(TypeCode.KIND_USHORT);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(928); match(KW_UNSIGNED);
			setState(929); match(KW_SHORT);
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

	public static class Unsigned_long_intContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_LONG() { return getToken(IDLParser.KW_LONG, 0); }
		public TerminalNode KW_UNSIGNED() { return getToken(IDLParser.KW_UNSIGNED, 0); }
		public Unsigned_long_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_long_int; }
	}

	public final Unsigned_long_intContext unsigned_long_int() throws RecognitionException {
		Unsigned_long_intContext _localctx = new Unsigned_long_intContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_unsigned_long_int);

			((Unsigned_long_intContext)_localctx).typecode =  new PrimitiveTypeCode(TypeCode.KIND_ULONG);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(931); match(KW_UNSIGNED);
			setState(932); match(KW_LONG);
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

	public static class Unsigned_longlong_intContext extends ParserRuleContext {
		public TypeCode typecode;
		public List<TerminalNode> KW_LONG() { return getTokens(IDLParser.KW_LONG); }
		public TerminalNode KW_LONG(int i) {
			return getToken(IDLParser.KW_LONG, i);
		}
		public TerminalNode KW_UNSIGNED() { return getToken(IDLParser.KW_UNSIGNED, 0); }
		public Unsigned_longlong_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_longlong_int; }
	}

	public final Unsigned_longlong_intContext unsigned_longlong_int() throws RecognitionException {
		Unsigned_longlong_intContext _localctx = new Unsigned_longlong_intContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_unsigned_longlong_int);

			((Unsigned_longlong_intContext)_localctx).typecode =  new PrimitiveTypeCode(TypeCode.KIND_ULONGLONG);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(934); match(KW_UNSIGNED);
			setState(935); match(KW_LONG);
			setState(936); match(KW_LONG);
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

	public static class Char_typeContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_CHAR() { return getToken(IDLParser.KW_CHAR, 0); }
		public Char_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char_type; }
	}

	public final Char_typeContext char_type() throws RecognitionException {
		Char_typeContext _localctx = new Char_typeContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_char_type);

			((Char_typeContext)_localctx).typecode =  new PrimitiveTypeCode(TypeCode.KIND_CHAR);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(938); match(KW_CHAR);
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

	public static class Wide_char_typeContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_WCHAR() { return getToken(IDLParser.KW_WCHAR, 0); }
		public Wide_char_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wide_char_type; }
	}

	public final Wide_char_typeContext wide_char_type() throws RecognitionException {
		Wide_char_typeContext _localctx = new Wide_char_typeContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_wide_char_type);

			((Wide_char_typeContext)_localctx).typecode =  new PrimitiveTypeCode(TypeCode.KIND_WCHAR);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(940); match(KW_WCHAR);
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

	public static class Boolean_typeContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_BOOLEAN() { return getToken(IDLParser.KW_BOOLEAN, 0); }
		public Boolean_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_type; }
	}

	public final Boolean_typeContext boolean_type() throws RecognitionException {
		Boolean_typeContext _localctx = new Boolean_typeContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_boolean_type);

			((Boolean_typeContext)_localctx).typecode =  new PrimitiveTypeCode(TypeCode.KIND_BOOLEAN);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(942); match(KW_BOOLEAN);
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

	public static class Octet_typeContext extends ParserRuleContext {
		public TypeCode typecode;
		public TerminalNode KW_OCTET() { return getToken(IDLParser.KW_OCTET, 0); }
		public Octet_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_octet_type; }
	}

	public final Octet_typeContext octet_type() throws RecognitionException {
		Octet_typeContext _localctx = new Octet_typeContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_octet_type);

			((Octet_typeContext)_localctx).typecode =  new PrimitiveTypeCode(TypeCode.KIND_OCTET);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(944); match(KW_OCTET);
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

	public static class Any_typeContext extends ParserRuleContext {
		public TerminalNode KW_ANY() { return getToken(IDLParser.KW_ANY, 0); }
		public Any_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_type; }
	}

	public final Any_typeContext any_type() throws RecognitionException {
		Any_typeContext _localctx = new Any_typeContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_any_type);

		    Token tk = _input.LT(1);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(946); match(KW_ANY);
			throw new ParseException(tk, ". Any type is not supported"); 
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

	public static class Object_typeContext extends ParserRuleContext {
		public TerminalNode KW_OBJECT() { return getToken(IDLParser.KW_OBJECT, 0); }
		public Object_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object_type; }
	}

	public final Object_typeContext object_type() throws RecognitionException {
		Object_typeContext _localctx = new Object_typeContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_object_type);

		    Token tk = _input.LT(1);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(949); match(KW_OBJECT);
			throw new ParseException(tk, ". Object type is not supported"); 
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

	public static class Annotation_declContext extends ParserRuleContext {
		public Pair<AnnotationDeclaration, TemplateGroup> returnPair = null;
		public Annotation_defContext annotation_def;
		public Annotation_forward_dclContext annotation_forward_dcl() {
			return getRuleContext(Annotation_forward_dclContext.class,0);
		}
		public Annotation_defContext annotation_def() {
			return getRuleContext(Annotation_defContext.class,0);
		}
		public Annotation_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation_decl; }
	}

	public final Annotation_declContext annotation_decl() throws RecognitionException {
		Annotation_declContext _localctx = new Annotation_declContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_annotation_decl);
		try {
			setState(956);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(952); ((Annotation_declContext)_localctx).annotation_def = annotation_def();
				 ((Annotation_declContext)_localctx).returnPair = ((Annotation_declContext)_localctx).annotation_def.returnPair; 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(955); annotation_forward_dcl();
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

	public static class Annotation_defContext extends ParserRuleContext {
		public Pair<AnnotationDeclaration, TemplateGroup> returnPair = null;
		public Annotation_headerContext annotation_header;
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public Annotation_headerContext annotation_header() {
			return getRuleContext(Annotation_headerContext.class,0);
		}
		public Annotation_bodyContext annotation_body() {
			return getRuleContext(Annotation_bodyContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public Annotation_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation_def; }
	}

	public final Annotation_defContext annotation_def() throws RecognitionException {
		Annotation_defContext _localctx = new Annotation_defContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_annotation_def);

			TemplateGroup annotationTemplates = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(958); ((Annotation_defContext)_localctx).annotation_header = annotation_header();
			setState(959); match(LEFT_BRACE);
			setState(960); annotation_body(((Annotation_defContext)_localctx).annotation_header.annotation);
			setState(961); match(RIGHT_BRACE);

					if(((Annotation_defContext)_localctx).annotation_header.annotation != null)
			        {
						if(ctx.isInScopedFile() || ctx.isScopeLimitToAll())
			            {
							if(tmanager != null)
			                {
								annotationTemplates = tmanager.createTemplateGroup("annotation");
								annotationTemplates.setAttribute("ctx", ctx);
								// Set the annotation object to the TemplateGroup of the annotation.
								annotationTemplates.setAttribute("annotation", ((Annotation_defContext)_localctx).annotation_header.annotation);
							}
						}
						
						((Annotation_defContext)_localctx).returnPair =  new Pair<AnnotationDeclaration, TemplateGroup>(((Annotation_defContext)_localctx).annotation_header.annotation, annotationTemplates);
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

	public static class Annotation_headerContext extends ParserRuleContext {
		public AnnotationDeclaration annotation = null;
		public IdentifierContext identifier;
		public Annotation_inheritance_specContext annotation_inheritance_spec() {
			return getRuleContext(Annotation_inheritance_specContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode KW_AT_ANNOTATION() { return getToken(IDLParser.KW_AT_ANNOTATION, 0); }
		public Annotation_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation_header; }
	}

	public final Annotation_headerContext annotation_header() throws RecognitionException {
		Annotation_headerContext _localctx = new Annotation_headerContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_annotation_header);

		    Token tk = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(964); match(KW_AT_ANNOTATION);

			        tk = _input.LT(1);
			    
			setState(966); ((Annotation_headerContext)_localctx).identifier = identifier();
			 ((Annotation_headerContext)_localctx).annotation =  ctx.createAnnotationDeclaration(((Annotation_headerContext)_localctx).identifier.id, tk); 
			setState(969);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(968); annotation_inheritance_spec(_localctx.annotation);
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

	public static class Annotation_inheritance_specContext extends ParserRuleContext {
		public AnnotationDeclaration annotation;
		public Scoped_nameContext scoped_name;
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(IDLParser.COLON, 0); }
		public Annotation_inheritance_specContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Annotation_inheritance_specContext(ParserRuleContext parent, int invokingState, AnnotationDeclaration annotation) {
			super(parent, invokingState);
			this.annotation = annotation;
		}
		@Override public int getRuleIndex() { return RULE_annotation_inheritance_spec; }
	}

	public final Annotation_inheritance_specContext annotation_inheritance_spec(AnnotationDeclaration annotation) throws RecognitionException {
		Annotation_inheritance_specContext _localctx = new Annotation_inheritance_specContext(_ctx, getState(), annotation);
		enterRule(_localctx, 146, RULE_annotation_inheritance_spec);

		    AnnotationDeclaration inhanno = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(971); match(COLON);
			setState(972); ((Annotation_inheritance_specContext)_localctx).scoped_name = scoped_name();

			        if(annotation != null)
			        {
			            inhanno = ctx.getAnnotationDeclaration(((Annotation_inheritance_specContext)_localctx).scoped_name.pair.first());

			            if(inhanno != null)
			            {
			                annotation.addMembers(inhanno);
			            }
			            else
			                throw new ParseException(((Annotation_inheritance_specContext)_localctx).scoped_name.pair.second(), "was not defined previously");
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

	public static class Annotation_bodyContext extends ParserRuleContext {
		public AnnotationDeclaration annotation;
		public Annotation_memberContext annotation_member(int i) {
			return getRuleContext(Annotation_memberContext.class,i);
		}
		public List<Annotation_memberContext> annotation_member() {
			return getRuleContexts(Annotation_memberContext.class);
		}
		public Annotation_bodyContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Annotation_bodyContext(ParserRuleContext parent, int invokingState, AnnotationDeclaration annotation) {
			super(parent, invokingState);
			this.annotation = annotation;
		}
		@Override public int getRuleIndex() { return RULE_annotation_body; }
	}

	public final Annotation_bodyContext annotation_body(AnnotationDeclaration annotation) throws RecognitionException {
		Annotation_bodyContext _localctx = new Annotation_bodyContext(_ctx, getState(), annotation);
		enterRule(_localctx, 148, RULE_annotation_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(978);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_COLON) | (1L << KW_STRING) | (1L << KW_OCTET) | (1L << KW_WCHAR) | (1L << KW_SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_LONG - 64)) | (1L << (KW_WSTRING - 64)) | (1L << (KW_UNSIGNED - 64)) | (1L << (KW_FIXED - 64)) | (1L << (KW_CHAR - 64)) | (1L << (KW_FLOAT - 64)) | (1L << (KW_BOOLEAN - 64)) | (1L << (KW_DOUBLE - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(975); annotation_member(annotation);
				}
				}
				setState(980);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Annotation_memberContext extends ParserRuleContext {
		public AnnotationDeclaration annotation;
		public Const_typeContext const_type;
		public Simple_declaratorContext simple_declarator;
		public Const_expContext const_exp;
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public Const_typeContext const_type() {
			return getRuleContext(Const_typeContext.class,0);
		}
		public TerminalNode KW_DEFAULT() { return getToken(IDLParser.KW_DEFAULT, 0); }
		public Simple_declaratorContext simple_declarator() {
			return getRuleContext(Simple_declaratorContext.class,0);
		}
		public Const_expContext const_exp() {
			return getRuleContext(Const_expContext.class,0);
		}
		public Annotation_memberContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Annotation_memberContext(ParserRuleContext parent, int invokingState, AnnotationDeclaration annotation) {
			super(parent, invokingState);
			this.annotation = annotation;
		}
		@Override public int getRuleIndex() { return RULE_annotation_member; }
	}

	public final Annotation_memberContext annotation_member(AnnotationDeclaration annotation) throws RecognitionException {
		Annotation_memberContext _localctx = new Annotation_memberContext(_ctx, getState(), annotation);
		enterRule(_localctx, 150, RULE_annotation_member);

		    String literalStr = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(981); ((Annotation_memberContext)_localctx).const_type = const_type();
			setState(982); ((Annotation_memberContext)_localctx).simple_declarator = simple_declarator();
			setState(987);
			_la = _input.LA(1);
			if (_la==KW_DEFAULT) {
				{
				setState(983); match(KW_DEFAULT);
				setState(984); ((Annotation_memberContext)_localctx).const_exp = const_exp();
				 literalStr=((Annotation_memberContext)_localctx).const_exp.literalStr; 
				}
			}

			setState(989); match(SEMICOLON);

					if(!_localctx.annotation.addMember(new AnnotationMember(((Annotation_memberContext)_localctx).simple_declarator.ret.first().first(), ((Annotation_memberContext)_localctx).const_type.typecode, literalStr)))
			        {
			            throw new ParseException(((Annotation_memberContext)_localctx).simple_declarator.ret.first().second(), "was defined previously");
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

	public static class Annotation_forward_dclContext extends ParserRuleContext {
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode KW_AT_ANNOTATION() { return getToken(IDLParser.KW_AT_ANNOTATION, 0); }
		public Annotation_forward_dclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation_forward_dcl; }
	}

	public final Annotation_forward_dclContext annotation_forward_dcl() throws RecognitionException {
		Annotation_forward_dclContext _localctx = new Annotation_forward_dclContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_annotation_forward_dcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(992); match(KW_AT_ANNOTATION);
			setState(993); scoped_name();
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

	public static class Struct_typeContext extends ParserRuleContext {
		public Pair<Vector<TypeCode>, TemplateGroup> returnPair = null;
		public IdentifierContext identifier;
		public Member_listContext member_list() {
			return getRuleContext(Member_listContext.class,0);
		}
		public TerminalNode KW_STRUCT() { return getToken(IDLParser.KW_STRUCT, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public Struct_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_type; }
	}

	public final Struct_typeContext struct_type() throws RecognitionException {
		Struct_typeContext _localctx = new Struct_typeContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_struct_type);

		    String name = null;
		    Vector<TypeCode> vector = null;
		    StructTypeCode structTP = null;
		    TemplateGroup structTemplates = null;
		    Token tk = null;
		    String comments = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(995); match(KW_STRUCT);
			setState(996); ((Struct_typeContext)_localctx).identifier = identifier();

			           tk = _input.LT(1);
			           comments = ctx.lookForComments(_input, tk, 50);
					   name=((Struct_typeContext)_localctx).identifier.id;
				       structTP = ctx.createStructTypeCode(name, comments);
			           for (ConstDeclaration constDeclaration : constDeclarations)
				          structTP.addConstant(constDeclaration);
				       constDeclarations.clear();
				    
			setState(998); match(LEFT_BRACE);
			setState(999); member_list(structTP);
			setState(1000); match(RIGHT_BRACE);

			           if(ctx.isInScopedFile() || ctx.isScopeLimitToAll())
			           {
							if(tmanager != null) {
							   structTemplates = tmanager.createTemplateGroup("struct_type");
							   structTemplates.setAttribute("ctx", ctx);
							   structTemplates.setAttribute("struct", structTP);
							}
			           }
			           // Return the returned data.
			           vector = new Vector<TypeCode>();
			           vector.add(structTP);
			           ((Struct_typeContext)_localctx).returnPair =  new Pair<Vector<TypeCode>, TemplateGroup>(vector, structTemplates);
				    
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

	public static class Member_listContext extends ParserRuleContext {
		public StructTypeCode structTP;
		public Member_defContext member_def;
		public Member_defContext member_def(int i) {
			return getRuleContext(Member_defContext.class,i);
		}
		public List<Member_defContext> member_def() {
			return getRuleContexts(Member_defContext.class);
		}
		public Member_listContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Member_listContext(ParserRuleContext parent, int invokingState, StructTypeCode structTP) {
			super(parent, invokingState);
			this.structTP = structTP;
		}
		@Override public int getRuleIndex() { return RULE_member_list; }
	}

	public final Member_listContext member_list(StructTypeCode structTP) throws RecognitionException {
		Member_listContext _localctx = new Member_listContext(_ctx, getState(), structTP);
		enterRule(_localctx, 156, RULE_member_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1006); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1003); ((Member_listContext)_localctx).member_def = member_def();

				               if(((Member_listContext)_localctx).member_def.ret != null)
				               {
				                   for(Pair<Pair<String, Token>, Member> pair : ((Member_listContext)_localctx).member_def.ret)
				                   {
					                   if(!_localctx.structTP.addMember(pair.second()))
				                           throw new ParseException(pair.first().second(), "was defined previously");
				                   }
				               }
					       
				}
				}
				setState(1008); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << DOUBLE_COLON) | (1L << KW_STRING) | (1L << KW_OCTET) | (1L << KW_SEQUENCE) | (1L << KW_STRUCT) | (1L << KW_WCHAR) | (1L << KW_SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_LONG - 64)) | (1L << (KW_ENUM - 64)) | (1L << (KW_WSTRING - 64)) | (1L << (KW_VALUEBASE - 64)) | (1L << (KW_OBJECT - 64)) | (1L << (KW_UNSIGNED - 64)) | (1L << (KW_FIXED - 64)) | (1L << (KW_UNION - 64)) | (1L << (KW_ANY - 64)) | (1L << (KW_CHAR - 64)) | (1L << (KW_FLOAT - 64)) | (1L << (KW_BOOLEAN - 64)) | (1L << (KW_DOUBLE - 64)) | (1L << (ID - 64)))) != 0) );
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

	public static class Member_defContext extends ParserRuleContext {
		public Vector<Pair<Pair<String, Token>, Member>> ret = null;
		public MemberContext member;
		public Annotation_applContext annotation_appl;
		public Member_defContext defret;
		public Annotation_applContext annotation_appl() {
			return getRuleContext(Annotation_applContext.class,0);
		}
		public MemberContext member() {
			return getRuleContext(MemberContext.class,0);
		}
		public Member_defContext member_def() {
			return getRuleContext(Member_defContext.class,0);
		}
		public Member_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member_def; }
	}

	public final Member_defContext member_def() throws RecognitionException {
		Member_defContext _localctx = new Member_defContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_member_def);
		try {
			setState(1017);
			switch (_input.LA(1)) {
			case DOUBLE_COLON:
			case KW_STRING:
			case KW_OCTET:
			case KW_SEQUENCE:
			case KW_STRUCT:
			case KW_WCHAR:
			case KW_SHORT:
			case KW_LONG:
			case KW_ENUM:
			case KW_WSTRING:
			case KW_VALUEBASE:
			case KW_OBJECT:
			case KW_UNSIGNED:
			case KW_FIXED:
			case KW_UNION:
			case KW_ANY:
			case KW_CHAR:
			case KW_FLOAT:
			case KW_BOOLEAN:
			case KW_DOUBLE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1010); ((Member_defContext)_localctx).member = member();
				 ((Member_defContext)_localctx).ret = ((Member_defContext)_localctx).member.ret; 
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1013); ((Member_defContext)_localctx).annotation_appl = annotation_appl();
				setState(1014); ((Member_defContext)_localctx).defret = member_def();

				            if(((Member_defContext)_localctx).defret.ret != null)
				            {
				                ((Member_defContext)_localctx).ret = ((Member_defContext)_localctx).defret.ret; 

				                for(Pair<Pair<String, Token>, Member> pair : _localctx.ret)
				                {
				                    if(pair.second() != null)
				                        pair.second().addAnnotation(ctx, ((Member_defContext)_localctx).annotation_appl.annotation);
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

	public static class MemberContext extends ParserRuleContext {
		public Vector<Pair<Pair<String, Token>, Member>> ret = new Vector<Pair<Pair<String, Token>, Member>>();
		public Type_specContext type_spec;
		public DeclaratorsContext declarators;
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public DeclaratorsContext declarators() {
			return getRuleContext(DeclaratorsContext.class,0);
		}
		public MemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member; }
	}

	public final MemberContext member() throws RecognitionException {
		MemberContext _localctx = new MemberContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_member);

		    Token tk = null;
		    String comments = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1019); ((MemberContext)_localctx).type_spec = type_spec();
			 tk = _input.LT(1);
			setState(1021); ((MemberContext)_localctx).declarators = declarators();
			setState(1022); match(SEMICOLON);

				       if(((MemberContext)_localctx).type_spec.typecode!=null)
				       {
			               comments = ctx.lookForComments(_input, tk, 50);

				           // for ex:
				           // int x = 5, y = 6;
				           // but we are just gonna have one declarator most of the time
					       for(int count = 0; count < ((MemberContext)_localctx).declarators.ret.size(); ++count)
					       {
			                   Member member = null;

					           if(((MemberContext)_localctx).declarators.ret.get(count).second() != null)
					           {
					               // Array declaration
					               ((MemberContext)_localctx).declarators.ret.get(count).second().setContentTypeCode(((MemberContext)_localctx).type_spec.typecode);
			                       member = new Member(((MemberContext)_localctx).declarators.ret.get(count).second(), ((MemberContext)_localctx).declarators.ret.get(count).first().first(), comments);
					               
					           }
					           else
					           {
					               // Simple declaration
			                       member = new Member(((MemberContext)_localctx).type_spec.typecode, ((MemberContext)_localctx).declarators.ret.get(count).first().first(), comments);
					           }

			                   _localctx.ret.add(new Pair<Pair<String, Token>, Member>(((MemberContext)_localctx).declarators.ret.get(count).first(), member));
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

	public static class Union_typeContext extends ParserRuleContext {
		public Pair<Vector<TypeCode>, TemplateGroup> returnPair = null;
		public IdentifierContext identifier;
		public Switch_type_specContext switch_type_spec;
		public TerminalNode KW_UNION() { return getToken(IDLParser.KW_UNION, 0); }
		public Switch_bodyContext switch_body() {
			return getRuleContext(Switch_bodyContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public TerminalNode KW_SWITCH() { return getToken(IDLParser.KW_SWITCH, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public Switch_type_specContext switch_type_spec() {
			return getRuleContext(Switch_type_specContext.class,0);
		}
		public Union_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union_type; }
	}

	public final Union_typeContext union_type() throws RecognitionException {
		Union_typeContext _localctx = new Union_typeContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_union_type);

		    String name = null;
		    int line = 0;
		    TypeCode dist_type = null;
		    Vector<TypeCode> vector = null;
		    UnionTypeCode unionTP = null;
		    TemplateGroup unionTemplates = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1025); match(KW_UNION);
			setState(1026); ((Union_typeContext)_localctx).identifier = identifier();
			 name=((Union_typeContext)_localctx).identifier.id;
			setState(1028); match(KW_SWITCH);
			setState(1029); match(LEFT_BRACKET);
			setState(1030); ((Union_typeContext)_localctx).switch_type_spec = switch_type_spec();
			 dist_type=((Union_typeContext)_localctx).switch_type_spec.typecode; 
			setState(1032); match(RIGHT_BRACKET);

			            // TODO Check supported types for discriminator: long, enumeration, etc...
				       unionTP = new UnionTypeCode(ctx.getScope(), name, dist_type);
			           line= _input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : 1;
				    
			setState(1034); match(LEFT_BRACE);
			setState(1035); switch_body(unionTP);
			setState(1036); match(RIGHT_BRACE);

				       // Calculate default label.
				       TemplateUtil.setUnionDefaultLabel(unionTP, ctx.getScopeFile(), line);

			           if(ctx.isInScopedFile() || ctx.isScopeLimitToAll())
			           {
							if(tmanager != null) {
			                   unionTemplates = tmanager.createTemplateGroup("union_type");
			                   unionTemplates.setAttribute("ctx", ctx);
			                   unionTemplates.setAttribute("union", unionTP);
							}
			           }
			           
			           // Return the returned data.
			           vector = new Vector<TypeCode>();
			           vector.add(unionTP);
			           ((Union_typeContext)_localctx).returnPair =  new Pair<Vector<TypeCode>, TemplateGroup>(vector, unionTemplates);
			        
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

	public static class Switch_type_specContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Integer_typeContext integer_type;
		public Char_typeContext char_type;
		public Boolean_typeContext boolean_type;
		public Scoped_nameContext scoped_name;
		public Boolean_typeContext boolean_type() {
			return getRuleContext(Boolean_typeContext.class,0);
		}
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Enum_typeContext enum_type() {
			return getRuleContext(Enum_typeContext.class,0);
		}
		public Integer_typeContext integer_type() {
			return getRuleContext(Integer_typeContext.class,0);
		}
		public Char_typeContext char_type() {
			return getRuleContext(Char_typeContext.class,0);
		}
		public Switch_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_type_spec; }
	}

	public final Switch_type_specContext switch_type_spec() throws RecognitionException {
		Switch_type_specContext _localctx = new Switch_type_specContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_switch_type_spec);

		    Pair<String, Token> pair = null;

		try {
			setState(1052);
			switch (_input.LA(1)) {
			case KW_SHORT:
			case KW_LONG:
			case KW_UNSIGNED:
				enterOuterAlt(_localctx, 1);
				{
				setState(1039); ((Switch_type_specContext)_localctx).integer_type = integer_type();
				 ((Switch_type_specContext)_localctx).typecode = ((Switch_type_specContext)_localctx).integer_type.typecode; 
				}
				break;
			case KW_CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1042); ((Switch_type_specContext)_localctx).char_type = char_type();
				 ((Switch_type_specContext)_localctx).typecode = ((Switch_type_specContext)_localctx).char_type.typecode; 
				}
				break;
			case KW_BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(1045); ((Switch_type_specContext)_localctx).boolean_type = boolean_type();
				 ((Switch_type_specContext)_localctx).typecode = ((Switch_type_specContext)_localctx).boolean_type.typecode; 
				}
				break;
			case KW_ENUM:
				enterOuterAlt(_localctx, 4);
				{
				setState(1048); enum_type();
				}
				break;
			case DOUBLE_COLON:
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(1049); ((Switch_type_specContext)_localctx).scoped_name = scoped_name();

						   pair=((Switch_type_specContext)_localctx).scoped_name.pair;
				           // Find typecode in the global map.
				           ((Switch_type_specContext)_localctx).typecode =  ctx.getTypeCode(pair.first());
				           
				           if(_localctx.typecode == null)
				               throw new ParseException(pair.second(), "was not defined previously");
				        
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

	public static class Switch_bodyContext extends ParserRuleContext {
		public UnionTypeCode unionTP;
		public Case_stmt_listContext case_stmt_list() {
			return getRuleContext(Case_stmt_listContext.class,0);
		}
		public Switch_bodyContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Switch_bodyContext(ParserRuleContext parent, int invokingState, UnionTypeCode unionTP) {
			super(parent, invokingState);
			this.unionTP = unionTP;
		}
		@Override public int getRuleIndex() { return RULE_switch_body; }
	}

	public final Switch_bodyContext switch_body(UnionTypeCode unionTP) throws RecognitionException {
		Switch_bodyContext _localctx = new Switch_bodyContext(_ctx, getState(), unionTP);
		enterRule(_localctx, 166, RULE_switch_body);


		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1054); case_stmt_list(unionTP);
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

	public static class Case_stmt_listContext extends ParserRuleContext {
		public UnionTypeCode unionTP;
		public Case_stmtContext case_stmt(int i) {
			return getRuleContext(Case_stmtContext.class,i);
		}
		public List<Case_stmtContext> case_stmt() {
			return getRuleContexts(Case_stmtContext.class);
		}
		public Case_stmt_listContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Case_stmt_listContext(ParserRuleContext parent, int invokingState, UnionTypeCode unionTP) {
			super(parent, invokingState);
			this.unionTP = unionTP;
		}
		@Override public int getRuleIndex() { return RULE_case_stmt_list; }
	}

	public final Case_stmt_listContext case_stmt_list(UnionTypeCode unionTP) throws RecognitionException {
		Case_stmt_listContext _localctx = new Case_stmt_listContext(_ctx, getState(), unionTP);
		enterRule(_localctx, 168, RULE_case_stmt_list);


		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1057); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1056); case_stmt(unionTP);
				}
				}
				setState(1059); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==KW_DEFAULT || _la==KW_CASE );
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

	public static class Case_stmtContext extends ParserRuleContext {
		public UnionTypeCode unionTP;
		public Const_expContext const_exp;
		public Element_specContext element_spec;
		public Element_specContext element_spec() {
			return getRuleContext(Element_specContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public TerminalNode KW_DEFAULT(int i) {
			return getToken(IDLParser.KW_DEFAULT, i);
		}
		public Const_expContext const_exp(int i) {
			return getRuleContext(Const_expContext.class,i);
		}
		public TerminalNode COLON(int i) {
			return getToken(IDLParser.COLON, i);
		}
		public List<TerminalNode> KW_CASE() { return getTokens(IDLParser.KW_CASE); }
		public List<TerminalNode> COLON() { return getTokens(IDLParser.COLON); }
		public List<TerminalNode> KW_DEFAULT() { return getTokens(IDLParser.KW_DEFAULT); }
		public List<Const_expContext> const_exp() {
			return getRuleContexts(Const_expContext.class);
		}
		public TerminalNode KW_CASE(int i) {
			return getToken(IDLParser.KW_CASE, i);
		}
		public Case_stmtContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Case_stmtContext(ParserRuleContext parent, int invokingState, UnionTypeCode unionTP) {
			super(parent, invokingState);
			this.unionTP = unionTP;
		}
		@Override public int getRuleIndex() { return RULE_case_stmt; }
	}

	public final Case_stmtContext case_stmt(UnionTypeCode unionTP) throws RecognitionException {
		Case_stmtContext _localctx = new Case_stmtContext(_ctx, getState(), unionTP);
		enterRule(_localctx, 170, RULE_case_stmt);

		    List<String> labels = new ArrayList<String>();
		    boolean defaul = false;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1069); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(1069);
				switch (_input.LA(1)) {
				case KW_CASE:
					{
					setState(1061); match(KW_CASE);
					setState(1062); ((Case_stmtContext)_localctx).const_exp = const_exp();

								labels.add(TemplateUtil.checkUnionLabel(unionTP.getDiscriminator(), ((Case_stmtContext)_localctx).const_exp.literalStr, ctx.getScopeFile(), _input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : 1));
							
					setState(1064); match(COLON);
					}
					break;
				case KW_DEFAULT:
					{
					setState(1066); match(KW_DEFAULT);
					 defaul = true; 
					setState(1068); match(COLON);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1071); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==KW_DEFAULT || _la==KW_CASE );
			setState(1073); ((Case_stmtContext)_localctx).element_spec = element_spec(labels, defaul);
			setState(1074); match(SEMICOLON);

				       if(((Case_stmtContext)_localctx).element_spec.ret != null)
				       {
					       int ret = unionTP.addMember(((Case_stmtContext)_localctx).element_spec.ret.second());

			               if(ret == -1)
			                   throw new ParseException(((Case_stmtContext)_localctx).element_spec.ret.first().second(), " is already defined.");
			               else if(ret == -2)
			                   throw new ParseException(((Case_stmtContext)_localctx).element_spec.ret.first().second(), " is also a default attribute. Another was defined previously.");
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

	public static class Element_specContext extends ParserRuleContext {
		public List<String> labels;
		public boolean isDefault;
		public Pair<Pair<String, Token>, UnionMember> ret = null;
		public Type_specContext type_spec;
		public DeclaratorContext declarator;
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public Element_specContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Element_specContext(ParserRuleContext parent, int invokingState, List<String> labels, boolean isDefault) {
			super(parent, invokingState);
			this.labels = labels;
			this.isDefault = isDefault;
		}
		@Override public int getRuleIndex() { return RULE_element_spec; }
	}

	public final Element_specContext element_spec(List<String> labels,boolean isDefault) throws RecognitionException {
		Element_specContext _localctx = new Element_specContext(_ctx, getState(), labels, isDefault);
		enterRule(_localctx, 172, RULE_element_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1077); ((Element_specContext)_localctx).type_spec = type_spec();
			setState(1078); ((Element_specContext)_localctx).declarator = declarator();

				        if(((Element_specContext)_localctx).type_spec.typecode != null)
				        {
			                UnionMember member = null;

				            if(((Element_specContext)_localctx).declarator.ret.second() != null)
				            {
				                ((Element_specContext)_localctx).declarator.ret.second().setContentTypeCode(((Element_specContext)_localctx).type_spec.typecode);
			                    member = new UnionMember(((Element_specContext)_localctx).declarator.ret.second(), ((Element_specContext)_localctx).declarator.ret.first().first(), labels, isDefault);
				            }
				            else
				            {
			                    member = new UnionMember(((Element_specContext)_localctx).type_spec.typecode, ((Element_specContext)_localctx).declarator.ret.first().first(), labels, isDefault);
				            }

			                ((Element_specContext)_localctx).ret =  new Pair<Pair<String, Token>, UnionMember>(((Element_specContext)_localctx).declarator.ret.first(), member);
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

	public static class Enum_typeContext extends ParserRuleContext {
		public Pair<Vector<TypeCode>, TemplateGroup> returnPair = null;
		public IdentifierContext identifier;
		public Enumerator_listContext enumerator_list() {
			return getRuleContext(Enumerator_listContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public TerminalNode KW_ENUM() { return getToken(IDLParser.KW_ENUM, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public Enum_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enum_type; }
	}

	public final Enum_typeContext enum_type() throws RecognitionException {
		Enum_typeContext _localctx = new Enum_typeContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_enum_type);

		    String name = null;
		    Vector<TypeCode> vector = null;
		    EnumTypeCode enumTP = null;
		    TemplateGroup enumTemplates = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1081); match(KW_ENUM);
			setState(1082); ((Enum_typeContext)_localctx).identifier = identifier();
			 name=((Enum_typeContext)_localctx).identifier.id; enumTP = new EnumTypeCode(ctx.getScope(), name); 
			setState(1084); match(LEFT_BRACE);
			setState(1085); enumerator_list(enumTP);
			setState(1086); match(RIGHT_BRACE);

			           if(ctx.isInScopedFile() || ctx.isScopeLimitToAll())
			           {
							if(tmanager != null) {
			                    enumTemplates = tmanager.createTemplateGroup("enum_type");
							    enumTemplates.setAttribute("ctx", ctx);
			                    enumTemplates.setAttribute("enum", enumTP);
			                }
					   }

			           // Return the returned data.
			           vector = new Vector<TypeCode>();
			           vector.add(enumTP);
			           ((Enum_typeContext)_localctx).returnPair =  new Pair<Vector<TypeCode>, TemplateGroup>(vector, enumTemplates);
				   
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

	public static class Enumerator_listContext extends ParserRuleContext {
		public EnumTypeCode enumTP;
		public List<EnumeratorContext> enumerator() {
			return getRuleContexts(EnumeratorContext.class);
		}
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public EnumeratorContext enumerator(int i) {
			return getRuleContext(EnumeratorContext.class,i);
		}
		public Enumerator_listContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Enumerator_listContext(ParserRuleContext parent, int invokingState, EnumTypeCode enumTP) {
			super(parent, invokingState);
			this.enumTP = enumTP;
		}
		@Override public int getRuleIndex() { return RULE_enumerator_list; }
	}

	public final Enumerator_listContext enumerator_list(EnumTypeCode enumTP) throws RecognitionException {
		Enumerator_listContext _localctx = new Enumerator_listContext(_ctx, getState(), enumTP);
		enterRule(_localctx, 176, RULE_enumerator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1089); enumerator(enumTP);
			setState(1094);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(1090); match(COMA);
				setState(1091); enumerator(enumTP);
				}
				}
				setState(1096);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class EnumeratorContext extends ParserRuleContext {
		public EnumTypeCode enumTP;
		public IdentifierContext identifier;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EnumeratorContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public EnumeratorContext(ParserRuleContext parent, int invokingState, EnumTypeCode enumTP) {
			super(parent, invokingState);
			this.enumTP = enumTP;
		}
		@Override public int getRuleIndex() { return RULE_enumerator; }
	}

	public final EnumeratorContext enumerator(EnumTypeCode enumTP) throws RecognitionException {
		EnumeratorContext _localctx = new EnumeratorContext(_ctx, getState(), enumTP);
		enterRule(_localctx, 178, RULE_enumerator);

		    String name = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1097); ((EnumeratorContext)_localctx).identifier = identifier();
			 name=((EnumeratorContext)_localctx).identifier.id; enumTP.addMember(new EnumMember(name));
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

	public static class Sequence_typeContext extends ParserRuleContext {
		public SequenceTypeCode typecode = null;
		public Simple_type_specContext simple_type_spec;
		public Positive_int_constContext positive_int_const;
		public Positive_int_constContext positive_int_const() {
			return getRuleContext(Positive_int_constContext.class,0);
		}
		public Simple_type_specContext simple_type_spec() {
			return getRuleContext(Simple_type_specContext.class,0);
		}
		public TerminalNode RIGHT_ANG_BRACKET() { return getToken(IDLParser.RIGHT_ANG_BRACKET, 0); }
		public TerminalNode LEFT_ANG_BRACKET() { return getToken(IDLParser.LEFT_ANG_BRACKET, 0); }
		public TerminalNode COMA() { return getToken(IDLParser.COMA, 0); }
		public TerminalNode KW_SEQUENCE() { return getToken(IDLParser.KW_SEQUENCE, 0); }
		public Sequence_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence_type; }
	}

	public final Sequence_typeContext sequence_type() throws RecognitionException {
		Sequence_typeContext _localctx = new Sequence_typeContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_sequence_type);

		    TypeCode type = null;
		    String maxsize = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1115);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				{
				setState(1100); match(KW_SEQUENCE);
				}
				setState(1101); match(LEFT_ANG_BRACKET);
				setState(1102); ((Sequence_typeContext)_localctx).simple_type_spec = simple_type_spec();
				 type=((Sequence_typeContext)_localctx).simple_type_spec.typecode; 
				setState(1104); match(COMA);
				setState(1105); ((Sequence_typeContext)_localctx).positive_int_const = positive_int_const();
				 maxsize=((Sequence_typeContext)_localctx).positive_int_const.literalStr; 
				setState(1107); match(RIGHT_ANG_BRACKET);
				}
				break;

			case 2:
				{
				{
				setState(1109); match(KW_SEQUENCE);
				}
				setState(1110); match(LEFT_ANG_BRACKET);
				setState(1111); ((Sequence_typeContext)_localctx).simple_type_spec = simple_type_spec();
				 type=((Sequence_typeContext)_localctx).simple_type_spec.typecode; 
				setState(1113); match(RIGHT_ANG_BRACKET);
				}
				break;
			}

			           if(type != null)
			           {
			               ((Sequence_typeContext)_localctx).typecode =  new SequenceTypeCode(maxsize);
			               _localctx.typecode.setContentTypeCode(type);
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

	public static class String_typeContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Positive_int_constContext positive_int_const;
		public Positive_int_constContext positive_int_const() {
			return getRuleContext(Positive_int_constContext.class,0);
		}
		public TerminalNode KW_STRING() { return getToken(IDLParser.KW_STRING, 0); }
		public TerminalNode RIGHT_ANG_BRACKET() { return getToken(IDLParser.RIGHT_ANG_BRACKET, 0); }
		public TerminalNode LEFT_ANG_BRACKET() { return getToken(IDLParser.LEFT_ANG_BRACKET, 0); }
		public String_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_type; }
	}

	public final String_typeContext string_type() throws RecognitionException {
		String_typeContext _localctx = new String_typeContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_string_type);

		    String maxsize = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1126);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(1119); match(KW_STRING);
				setState(1120); match(LEFT_ANG_BRACKET);
				setState(1121); ((String_typeContext)_localctx).positive_int_const = positive_int_const();
				 maxsize=((String_typeContext)_localctx).positive_int_const.literalStr; 
				setState(1123); match(RIGHT_ANG_BRACKET);
				}
				break;

			case 2:
				{
				setState(1125); match(KW_STRING);
				}
				break;
			}
			((String_typeContext)_localctx).typecode =  new StringTypeCode(TypeCode.KIND_STRING, maxsize);
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

	public static class Wide_string_typeContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Positive_int_constContext positive_int_const;
		public Positive_int_constContext positive_int_const() {
			return getRuleContext(Positive_int_constContext.class,0);
		}
		public TerminalNode KW_WSTRING() { return getToken(IDLParser.KW_WSTRING, 0); }
		public TerminalNode RIGHT_ANG_BRACKET() { return getToken(IDLParser.RIGHT_ANG_BRACKET, 0); }
		public TerminalNode LEFT_ANG_BRACKET() { return getToken(IDLParser.LEFT_ANG_BRACKET, 0); }
		public Wide_string_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wide_string_type; }
	}

	public final Wide_string_typeContext wide_string_type() throws RecognitionException {
		Wide_string_typeContext _localctx = new Wide_string_typeContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_wide_string_type);

		    String maxsize = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1137);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(1130); match(KW_WSTRING);
				setState(1131); match(LEFT_ANG_BRACKET);
				setState(1132); ((Wide_string_typeContext)_localctx).positive_int_const = positive_int_const();
				 maxsize=((Wide_string_typeContext)_localctx).positive_int_const.literalStr; 
				setState(1134); match(RIGHT_ANG_BRACKET);
				}
				break;

			case 2:
				{
				setState(1136); match(KW_WSTRING);
				}
				break;
			}
			((Wide_string_typeContext)_localctx).typecode =  new StringTypeCode(TypeCode.KIND_WSTRING, maxsize);
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

	public static class Array_declaratorContext extends ParserRuleContext {
		public Pair<Pair<String, Token>, ContainerTypeCode> pair = null;
		public Fixed_array_sizeContext fixed_array_size;
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Fixed_array_sizeContext fixed_array_size(int i) {
			return getRuleContext(Fixed_array_sizeContext.class,i);
		}
		public List<Fixed_array_sizeContext> fixed_array_size() {
			return getRuleContexts(Fixed_array_sizeContext.class);
		}
		public Array_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_declarator; }
	}

	public final Array_declaratorContext array_declarator() throws RecognitionException {
		Array_declaratorContext _localctx = new Array_declaratorContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_array_declarator);

		    Token tk = _input.LT(1);
		    ArrayTypeCode typecode = new ArrayTypeCode();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1141); match(ID);
			setState(1145); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1142); ((Array_declaratorContext)_localctx).fixed_array_size = fixed_array_size();

					           typecode.addDimension(((Array_declaratorContext)_localctx).fixed_array_size.literalStr);
					        
				}
				}
				setState(1147); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LEFT_SQUARE_BRACKET );

			            Pair<String, Token> p = new Pair<String, Token>(tk.getText(), tk);
			            ((Array_declaratorContext)_localctx).pair =  new Pair<Pair<String, Token>, ContainerTypeCode>(p, typecode);
				    
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

	public static class Fixed_array_sizeContext extends ParserRuleContext {
		public String literalStr = null;
		public Positive_int_constContext positive_int_const;
		public Positive_int_constContext positive_int_const() {
			return getRuleContext(Positive_int_constContext.class,0);
		}
		public TerminalNode RIGHT_SQUARE_BRACKET() { return getToken(IDLParser.RIGHT_SQUARE_BRACKET, 0); }
		public TerminalNode LEFT_SQUARE_BRACKET() { return getToken(IDLParser.LEFT_SQUARE_BRACKET, 0); }
		public Fixed_array_sizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fixed_array_size; }
	}

	public final Fixed_array_sizeContext fixed_array_size() throws RecognitionException {
		Fixed_array_sizeContext _localctx = new Fixed_array_sizeContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_fixed_array_size);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1151); match(LEFT_SQUARE_BRACKET);
			setState(1152); ((Fixed_array_sizeContext)_localctx).positive_int_const = positive_int_const();
			 ((Fixed_array_sizeContext)_localctx).literalStr = ((Fixed_array_sizeContext)_localctx).positive_int_const.literalStr; 
			setState(1154); match(RIGHT_SQUARE_BRACKET);
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

	public static class Attr_declContext extends ParserRuleContext {
		public Vector<Pair<Pair<String, Token>, TypeCode>> ret = null;
		public Attr_specContext attr_spec;
		public Readonly_attr_specContext readonly_attr_spec() {
			return getRuleContext(Readonly_attr_specContext.class,0);
		}
		public Attr_specContext attr_spec() {
			return getRuleContext(Attr_specContext.class,0);
		}
		public Attr_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_decl; }
	}

	public final Attr_declContext attr_decl() throws RecognitionException {
		Attr_declContext _localctx = new Attr_declContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_attr_decl);
		try {
			setState(1160);
			switch (_input.LA(1)) {
			case KW_READONLY:
				enterOuterAlt(_localctx, 1);
				{
				setState(1156); readonly_attr_spec();
				}
				break;
			case KW_ATTRIBUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1157); ((Attr_declContext)_localctx).attr_spec = attr_spec();
				 ((Attr_declContext)_localctx).ret = ((Attr_declContext)_localctx).attr_spec.ret; 
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

	public static class Except_declContext extends ParserRuleContext {
		public Pair<com.eprosima.idl.parser.tree.Exception, TemplateGroup> returnPair = null;
		public IdentifierContext identifier;
		public TerminalNode KW_EXCEPTION() { return getToken(IDLParser.KW_EXCEPTION, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public Opt_member_listContext opt_member_list() {
			return getRuleContext(Opt_member_listContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public Except_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_except_decl; }
	}

	public final Except_declContext except_decl() throws RecognitionException {
		Except_declContext _localctx = new Except_declContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_except_decl);

		    String name = null;
		    com.eprosima.idl.parser.tree.Exception exceptionObject = null;
		    TemplateGroup exTemplates = null;
		    Token tk = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1162); match(KW_EXCEPTION);

			            tk = _input.LT(1);
			        
			setState(1164); ((Except_declContext)_localctx).identifier = identifier();
			 name=((Except_declContext)_localctx).identifier.id; 

			            // Create the Exception object.
			            exceptionObject = ctx.createException(name, tk);

			            if(ctx.isInScopedFile() || ctx.isScopeLimitToAll())
			            {
							if(tmanager != null) {
								exTemplates = tmanager.createTemplateGroup("exception");
								exTemplates.setAttribute("ctx", ctx);
								// Set the the exception object to the TemplateGroup of the module.
								exTemplates.setAttribute("exception", exceptionObject);
							}
			            }
			            // Its a dependency.
			            else
			            {
			                ctx.addIncludeDependency(ctx.getScopeFile());
			            }
				    
			setState(1167); match(LEFT_BRACE);
			setState(1168); opt_member_list(exceptionObject);
			setState(1169); match(RIGHT_BRACE);

			            // Create the returned data.
			            ((Except_declContext)_localctx).returnPair =  new Pair<com.eprosima.idl.parser.tree.Exception, TemplateGroup>(exceptionObject, exTemplates);
			        
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

	public static class Opt_member_listContext extends ParserRuleContext {
		public com.eprosima.idl.parser.tree.Exception exceptionObject;
		public MemberContext member;
		public MemberContext member(int i) {
			return getRuleContext(MemberContext.class,i);
		}
		public List<MemberContext> member() {
			return getRuleContexts(MemberContext.class);
		}
		public Opt_member_listContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Opt_member_listContext(ParserRuleContext parent, int invokingState, com.eprosima.idl.parser.tree.Exception exceptionObject) {
			super(parent, invokingState);
			this.exceptionObject = exceptionObject;
		}
		@Override public int getRuleIndex() { return RULE_opt_member_list; }
	}

	public final Opt_member_listContext opt_member_list(com.eprosima.idl.parser.tree.Exception exceptionObject) throws RecognitionException {
		Opt_member_listContext _localctx = new Opt_member_listContext(_ctx, getState(), exceptionObject);
		enterRule(_localctx, 194, RULE_opt_member_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_COLON) | (1L << KW_STRING) | (1L << KW_OCTET) | (1L << KW_SEQUENCE) | (1L << KW_STRUCT) | (1L << KW_WCHAR) | (1L << KW_SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_LONG - 64)) | (1L << (KW_ENUM - 64)) | (1L << (KW_WSTRING - 64)) | (1L << (KW_VALUEBASE - 64)) | (1L << (KW_OBJECT - 64)) | (1L << (KW_UNSIGNED - 64)) | (1L << (KW_FIXED - 64)) | (1L << (KW_UNION - 64)) | (1L << (KW_ANY - 64)) | (1L << (KW_CHAR - 64)) | (1L << (KW_FLOAT - 64)) | (1L << (KW_BOOLEAN - 64)) | (1L << (KW_DOUBLE - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(1172); ((Opt_member_listContext)_localctx).member = member();

					          for(int count = 0; count < ((Opt_member_listContext)_localctx).member.ret.size(); ++count)
					              _localctx.exceptionObject.addMember(((Opt_member_listContext)_localctx).member.ret.get(count).second());
					      
				}
				}
				setState(1179);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Op_declContext extends ParserRuleContext {
		public Vector<Annotation> annotations;
		public Pair<Operation, TemplateGroup> returnPair = null;
		public Op_attributeContext op_attribute;
		public Op_type_specContext op_type_spec;
		public Parameter_declsContext parameter_decls;
		public Raises_exprContext raises_expr;
		public Op_type_specContext op_type_spec() {
			return getRuleContext(Op_type_specContext.class,0);
		}
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Context_exprContext context_expr() {
			return getRuleContext(Context_exprContext.class,0);
		}
		public Raises_exprContext raises_expr() {
			return getRuleContext(Raises_exprContext.class,0);
		}
		public Parameter_declsContext parameter_decls() {
			return getRuleContext(Parameter_declsContext.class,0);
		}
		public Op_attributeContext op_attribute() {
			return getRuleContext(Op_attributeContext.class,0);
		}
		public Op_declContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Op_declContext(ParserRuleContext parent, int invokingState, Vector<Annotation> annotations) {
			super(parent, invokingState);
			this.annotations = annotations;
		}
		@Override public int getRuleIndex() { return RULE_op_decl; }
	}

	public final Op_declContext op_decl(Vector<Annotation> annotations) throws RecognitionException {
		Op_declContext _localctx = new Op_declContext(_ctx, getState(), annotations);
		enterRule(_localctx, 196, RULE_op_decl);

		        Operation operationObject = null;
		        TemplateGroup operationTemplates = null;
				if(tmanager != null) {
					operationTemplates = tmanager.createTemplateGroup("operation");
				}
		        TemplateGroup tpl = null;
		        String name = "";
		        Token tk = null, tkoneway = null;
		        TypeCode retType = null;
		        Vector<Pair<String, Token>> exceptions = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1183);
			_la = _input.LA(1);
			if (_la==KW_ONEWAY) {
				{
				setState(1180); ((Op_declContext)_localctx).op_attribute = op_attribute();
				 tkoneway=((Op_declContext)_localctx).op_attribute.token; 
				}
			}

			setState(1185); ((Op_declContext)_localctx).op_type_spec = op_type_spec();
			 retType=((Op_declContext)_localctx).op_type_spec.typecode; 

			            tk = _input.LT(1);
			            name += tk.getText();
			        
			setState(1188); match(ID);

			           // Create the Operation object.
			           operationObject = ctx.createOperation(name, tk);

			           // Add annotations.
			           for(Annotation annotation : annotations)
			               operationObject.addAnnotation(ctx, annotation);
					   
					   if(operationTemplates != null)
			           {
						   operationTemplates.setAttribute("ctx", ctx);
						   // Set the the interface object to the TemplateGroup of the module.
						   operationTemplates.setAttribute("operation", operationObject);
					   }
			           
			           // Set return type
			           operationObject.setRettype(retType);
			           
			           // Set oneway
			           if(tkoneway != null)
			           {
			               operationObject.setOneway(true);

			               if(retType != null)
			               {
			                   throw new ParseException(tkoneway, ". Oneway function cannot have a return type.");
			               }
			           }
			        
			setState(1190); ((Op_declContext)_localctx).parameter_decls = parameter_decls(operationObject);
			 tpl=((Op_declContext)_localctx).parameter_decls.tpl; 
			setState(1196);
			_la = _input.LA(1);
			if (_la==KW_RAISES) {
				{
				setState(1192); ((Op_declContext)_localctx).raises_expr = raises_expr();
				 exceptions=((Op_declContext)_localctx).raises_expr.exlist; 

					          // Search global exceptions and add them to the operation.
				              for(Pair<String, Token> pair : exceptions)
					          {
					             com.eprosima.idl.parser.tree.Exception exception = ctx.getException(pair.first());
					             
					             if(exception != null)
					                operationObject.addException(exception);
					             else
					                operationObject.addUnresolvedException(pair.first());
					          }
					       
				}
			}

			setState(1199);
			_la = _input.LA(1);
			if (_la==KW_CONTEXT) {
				{
				setState(1198); context_expr();
				}
			}


						if(operationTemplates != null) {
							// Store the parameter list template group in the operation template group.
							operationTemplates.setAttribute("param_list", tpl);
						}
			           // Create the returned data.
			           ((Op_declContext)_localctx).returnPair =  new Pair<Operation, TemplateGroup>(operationObject, operationTemplates);
			        
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

	public static class Op_attributeContext extends ParserRuleContext {
		public Token token = null;
		public TerminalNode KW_ONEWAY() { return getToken(IDLParser.KW_ONEWAY, 0); }
		public Op_attributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_attribute; }
	}

	public final Op_attributeContext op_attribute() throws RecognitionException {
		Op_attributeContext _localctx = new Op_attributeContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_op_attribute);

		    Token tk = _input.LT(1);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1203); match(KW_ONEWAY);
			 ((Op_attributeContext)_localctx).token =  tk;
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

	public static class Op_type_specContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Param_type_specContext param_type_spec;
		public Param_type_specContext param_type_spec() {
			return getRuleContext(Param_type_specContext.class,0);
		}
		public TerminalNode KW_VOID() { return getToken(IDLParser.KW_VOID, 0); }
		public Op_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_type_spec; }
	}

	public final Op_type_specContext op_type_spec() throws RecognitionException {
		Op_type_specContext _localctx = new Op_type_specContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_op_type_spec);
		try {
			setState(1210);
			switch (_input.LA(1)) {
			case DOUBLE_COLON:
			case KW_STRING:
			case KW_OCTET:
			case KW_WCHAR:
			case KW_SHORT:
			case KW_LONG:
			case KW_WSTRING:
			case KW_VALUEBASE:
			case KW_OBJECT:
			case KW_UNSIGNED:
			case KW_ANY:
			case KW_CHAR:
			case KW_FLOAT:
			case KW_BOOLEAN:
			case KW_DOUBLE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1206); ((Op_type_specContext)_localctx).param_type_spec = param_type_spec();
				 ((Op_type_specContext)_localctx).typecode = ((Op_type_specContext)_localctx).param_type_spec.typecode; 
				}
				break;
			case KW_VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(1209); match(KW_VOID);
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

	public static class Parameter_declsContext extends ParserRuleContext {
		public Operation operation;
		public TemplateGroup tpl;
		public Param_decl_listContext param_decl_list() {
			return getRuleContext(Param_decl_listContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public Parameter_declsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Parameter_declsContext(ParserRuleContext parent, int invokingState, Operation operation) {
			super(parent, invokingState);
			this.operation = operation;
		}
		@Override public int getRuleIndex() { return RULE_parameter_decls; }
	}

	public final Parameter_declsContext parameter_decls(Operation operation) throws RecognitionException {
		Parameter_declsContext _localctx = new Parameter_declsContext(_ctx, getState(), operation);
		enterRule(_localctx, 202, RULE_parameter_decls);

			if(tmanager != null) {
				((Parameter_declsContext)_localctx).tpl =  tmanager.createTemplateGroup("param_list");
			}

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1212); match(LEFT_BRACKET);
			setState(1214);
			_la = _input.LA(1);
			if (((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & ((1L << (KW_OUT - 39)) | (1L << (KW_IN - 39)) | (1L << (KW_INOUT - 39)))) != 0)) {
				{
				setState(1213); param_decl_list(operation, _localctx.tpl);
				}
			}

			setState(1216); match(RIGHT_BRACKET);
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

	public static class Param_decl_listContext extends ParserRuleContext {
		public Operation operation;
		public TemplateGroup tpl;
		public Param_declContext param_decl;
		public Param_declContext param_decl(int i) {
			return getRuleContext(Param_declContext.class,i);
		}
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public List<Param_declContext> param_decl() {
			return getRuleContexts(Param_declContext.class);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public Param_decl_listContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Param_decl_listContext(ParserRuleContext parent, int invokingState, Operation operation, TemplateGroup tpl) {
			super(parent, invokingState);
			this.operation = operation;
			this.tpl = tpl;
		}
		@Override public int getRuleIndex() { return RULE_param_decl_list; }
	}

	public final Param_decl_listContext param_decl_list(Operation operation,TemplateGroup tpl) throws RecognitionException {
		Param_decl_listContext _localctx = new Param_decl_listContext(_ctx, getState(), operation, tpl);
		enterRule(_localctx, 204, RULE_param_decl_list);

		        Pair<Param, TemplateGroup> ptg = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1218); ((Param_decl_listContext)_localctx).param_decl = param_decl();
			 ptg=((Param_decl_listContext)_localctx).param_decl.returnPair; 

						if(ptg!=null) {
							operation.add(ptg.first());
							if(tpl != null) {
								tpl.setAttribute("parameters", ptg.second());
							}
						}
					
			setState(1228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(1221); match(COMA);
				setState(1222); ((Param_decl_listContext)_localctx).param_decl = param_decl();
				 ptg=((Param_decl_listContext)_localctx).param_decl.returnPair; 

							if(ptg!=null) {
								operation.add(ptg.first());
								if(tpl != null) {
									tpl.setAttribute("parameters", ptg.second());
								}
							}
						
				}
				}
				setState(1230);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Param_declContext extends ParserRuleContext {
		public Pair<Param, TemplateGroup> returnPair = null;
		public Param_type_specContext param_type_spec;
		public Simple_declaratorContext simple_declarator;
		public Param_type_specContext param_type_spec() {
			return getRuleContext(Param_type_specContext.class,0);
		}
		public Simple_declaratorContext simple_declarator() {
			return getRuleContext(Simple_declaratorContext.class,0);
		}
		public Param_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl; }
	}

	public final Param_declContext param_decl() throws RecognitionException {
		Param_declContext _localctx = new Param_declContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_param_decl);

		        TemplateGroup paramTemplate = null;
				if(tmanager != null) {
					paramTemplate = tmanager.createTemplateGroup("param");
				}
		        TypeCode typecode = null;
		        String literalStr = _input.LT(1).getText();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1231);
			_la = _input.LA(1);
			if ( !(((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & ((1L << (KW_OUT - 39)) | (1L << (KW_IN - 39)) | (1L << (KW_INOUT - 39)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(1232); ((Param_declContext)_localctx).param_type_spec = param_type_spec();
			 typecode=((Param_declContext)_localctx).param_type_spec.typecode; 
			setState(1234); ((Param_declContext)_localctx).simple_declarator = simple_declarator();

				        if(typecode != null)
				        {
					        Param param = null;
					        if(literalStr.equals("in"))
					            param = ctx.createParam(((Param_declContext)_localctx).simple_declarator.ret.first().first(), typecode, Param.Kind.IN_PARAM);
					        else if(literalStr.equals("out"))
					            param = ctx.createParam(((Param_declContext)_localctx).simple_declarator.ret.first().first(), typecode, Param.Kind.OUT_PARAM);
					        else if(literalStr.equals("inout"))
					            param = ctx.createParam(((Param_declContext)_localctx).simple_declarator.ret.first().first(), typecode, Param.Kind.INOUT_PARAM);
					            
							if(paramTemplate != null) {
								paramTemplate.setAttribute("parameter", param);
							}
					        ((Param_declContext)_localctx).returnPair =  new Pair<Param, TemplateGroup>(param, paramTemplate);
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

	public static class Raises_exprContext extends ParserRuleContext {
		public Vector<Pair<String, Token>> exlist = null;
		public Scoped_name_listContext scoped_name_list;
		public TerminalNode KW_RAISES() { return getToken(IDLParser.KW_RAISES, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public Scoped_name_listContext scoped_name_list() {
			return getRuleContext(Scoped_name_listContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public Raises_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raises_expr; }
	}

	public final Raises_exprContext raises_expr() throws RecognitionException {
		Raises_exprContext _localctx = new Raises_exprContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_raises_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1237); match(KW_RAISES);
			setState(1238); match(LEFT_BRACKET);
			setState(1239); ((Raises_exprContext)_localctx).scoped_name_list = scoped_name_list();
			 ((Raises_exprContext)_localctx).exlist = ((Raises_exprContext)_localctx).scoped_name_list.retlist; 
			setState(1241); match(RIGHT_BRACKET);
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

	public static class Context_exprContext extends ParserRuleContext {
		public List<TerminalNode> STRING_LITERAL() { return getTokens(IDLParser.STRING_LITERAL); }
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public TerminalNode KW_CONTEXT() { return getToken(IDLParser.KW_CONTEXT, 0); }
		public TerminalNode STRING_LITERAL(int i) {
			return getToken(IDLParser.STRING_LITERAL, i);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public Context_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_context_expr; }
	}

	public final Context_exprContext context_expr() throws RecognitionException {
		Context_exprContext _localctx = new Context_exprContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_context_expr);

			System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Context declarations are not supported. Ignoring...");

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1243); match(KW_CONTEXT);
			setState(1244); match(LEFT_BRACKET);
			setState(1245); match(STRING_LITERAL);
			setState(1250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(1246); match(COMA);
				setState(1247); match(STRING_LITERAL);
				}
				}
				setState(1252);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1253); match(RIGHT_BRACKET);
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

	public static class Param_type_specContext extends ParserRuleContext {
		public TypeCode typecode = null;
		public Base_type_specContext base_type_spec;
		public String_typeContext string_type;
		public Wide_string_typeContext wide_string_type;
		public Scoped_nameContext scoped_name;
		public String_typeContext string_type() {
			return getRuleContext(String_typeContext.class,0);
		}
		public Base_type_specContext base_type_spec() {
			return getRuleContext(Base_type_specContext.class,0);
		}
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Wide_string_typeContext wide_string_type() {
			return getRuleContext(Wide_string_typeContext.class,0);
		}
		public Param_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type_spec; }
	}

	public final Param_type_specContext param_type_spec() throws RecognitionException {
		Param_type_specContext _localctx = new Param_type_specContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_param_type_spec);

		    Pair<String, Token> pair = null;

		try {
			setState(1267);
			switch (_input.LA(1)) {
			case KW_OCTET:
			case KW_WCHAR:
			case KW_SHORT:
			case KW_LONG:
			case KW_VALUEBASE:
			case KW_OBJECT:
			case KW_UNSIGNED:
			case KW_ANY:
			case KW_CHAR:
			case KW_FLOAT:
			case KW_BOOLEAN:
			case KW_DOUBLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1255); ((Param_type_specContext)_localctx).base_type_spec = base_type_spec();
				 ((Param_type_specContext)_localctx).typecode = ((Param_type_specContext)_localctx).base_type_spec.typecode; 
				}
				break;
			case KW_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1258); ((Param_type_specContext)_localctx).string_type = string_type();
				 ((Param_type_specContext)_localctx).typecode = ((Param_type_specContext)_localctx).string_type.typecode; 
				}
				break;
			case KW_WSTRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(1261); ((Param_type_specContext)_localctx).wide_string_type = wide_string_type();
				 ((Param_type_specContext)_localctx).typecode = ((Param_type_specContext)_localctx).wide_string_type.typecode; 
				}
				break;
			case DOUBLE_COLON:
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(1264); ((Param_type_specContext)_localctx).scoped_name = scoped_name();

				           pair=((Param_type_specContext)_localctx).scoped_name.pair;
				           // Find typecode in the global map.
				           ((Param_type_specContext)_localctx).typecode =  ctx.getTypeCode(pair.first());
				           
				           if(_localctx.typecode == null)
				               throw new ParseException(pair.second(), "was not defined previously");
				        
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

	public static class Fixed_pt_typeContext extends ParserRuleContext {
		public List<Positive_int_constContext> positive_int_const() {
			return getRuleContexts(Positive_int_constContext.class);
		}
		public TerminalNode RIGHT_ANG_BRACKET() { return getToken(IDLParser.RIGHT_ANG_BRACKET, 0); }
		public TerminalNode LEFT_ANG_BRACKET() { return getToken(IDLParser.LEFT_ANG_BRACKET, 0); }
		public Positive_int_constContext positive_int_const(int i) {
			return getRuleContext(Positive_int_constContext.class,i);
		}
		public TerminalNode KW_FIXED() { return getToken(IDLParser.KW_FIXED, 0); }
		public TerminalNode COMA() { return getToken(IDLParser.COMA, 0); }
		public Fixed_pt_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fixed_pt_type; }
	}

	public final Fixed_pt_typeContext fixed_pt_type() throws RecognitionException {
		Fixed_pt_typeContext _localctx = new Fixed_pt_typeContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_fixed_pt_type);

		    Token tk = _input.LT(1);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1269); match(KW_FIXED);
			setState(1270); match(LEFT_ANG_BRACKET);
			setState(1271); positive_int_const();
			setState(1272); match(COMA);
			setState(1273); positive_int_const();
			setState(1274); match(RIGHT_ANG_BRACKET);
			throw new ParseException(tk, ". Fixed type is not supported");
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

	public static class Fixed_pt_const_typeContext extends ParserRuleContext {
		public TerminalNode KW_FIXED() { return getToken(IDLParser.KW_FIXED, 0); }
		public Fixed_pt_const_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fixed_pt_const_type; }
	}

	public final Fixed_pt_const_typeContext fixed_pt_const_type() throws RecognitionException {
		Fixed_pt_const_typeContext _localctx = new Fixed_pt_const_typeContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_fixed_pt_const_type);

		    Token tk = _input.LT(1);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1277); match(KW_FIXED);
			throw new ParseException(tk, ". Fixed type is not supported");
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

	public static class Value_base_typeContext extends ParserRuleContext {
		public TerminalNode KW_VALUEBASE() { return getToken(IDLParser.KW_VALUEBASE, 0); }
		public Value_base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_base_type; }
	}

	public final Value_base_typeContext value_base_type() throws RecognitionException {
		Value_base_typeContext _localctx = new Value_base_typeContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_value_base_type);

		    Token tk = _input.LT(1);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1280); match(KW_VALUEBASE);
			throw new ParseException(tk, ". Value type is not supported");
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

	public static class Constr_forward_declContext extends ParserRuleContext {
		public TerminalNode KW_UNION() { return getToken(IDLParser.KW_UNION, 0); }
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode KW_STRUCT() { return getToken(IDLParser.KW_STRUCT, 0); }
		public Constr_forward_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constr_forward_decl; }
	}

	public final Constr_forward_declContext constr_forward_decl() throws RecognitionException {
		Constr_forward_declContext _localctx = new Constr_forward_declContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_constr_forward_decl);
		try {
			setState(1287);
			switch (_input.LA(1)) {
			case KW_STRUCT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1283); match(KW_STRUCT);
				setState(1284); match(ID);
				}
				break;
			case KW_UNION:
				enterOuterAlt(_localctx, 2);
				{
				setState(1285); match(KW_UNION);
				setState(1286); match(ID);
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

	public static class Import_declContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public TerminalNode KW_IMPORT() { return getToken(IDLParser.KW_IMPORT, 0); }
		public Imported_scopeContext imported_scope() {
			return getRuleContext(Imported_scopeContext.class,0);
		}
		public Import_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_decl; }
	}

	public final Import_declContext import_decl() throws RecognitionException {
		Import_declContext _localctx = new Import_declContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_import_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1289); match(KW_IMPORT);

					System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Import declarations are not supported. Ignoring...");
				
			setState(1291); imported_scope();
			setState(1292); match(SEMICOLON);
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

	public static class Imported_scopeContext extends ParserRuleContext {
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(IDLParser.STRING_LITERAL, 0); }
		public Imported_scopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imported_scope; }
	}

	public final Imported_scopeContext imported_scope() throws RecognitionException {
		Imported_scopeContext _localctx = new Imported_scopeContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_imported_scope);
		try {
			setState(1296);
			switch (_input.LA(1)) {
			case DOUBLE_COLON:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1294); scoped_name();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1295); match(STRING_LITERAL);
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

	public static class Type_id_declContext extends ParserRuleContext {
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(IDLParser.STRING_LITERAL, 0); }
		public TerminalNode KW_TYPEID() { return getToken(IDLParser.KW_TYPEID, 0); }
		public Type_id_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_id_decl; }
	}

	public final Type_id_declContext type_id_decl() throws RecognitionException {
		Type_id_declContext _localctx = new Type_id_declContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_type_id_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1298); match(KW_TYPEID);

			            System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): TypeID declarations are not supported. Ignoring...");
			        
			setState(1300); scoped_name();
			setState(1301); match(STRING_LITERAL);
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

	public static class Type_prefix_declContext extends ParserRuleContext {
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode KW_TYPEPREFIX() { return getToken(IDLParser.KW_TYPEPREFIX, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(IDLParser.STRING_LITERAL, 0); }
		public Type_prefix_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_prefix_decl; }
	}

	public final Type_prefix_declContext type_prefix_decl() throws RecognitionException {
		Type_prefix_declContext _localctx = new Type_prefix_declContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_type_prefix_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1303); match(KW_TYPEPREFIX);

			            System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): TypePrefix declarations are not supported. Ignoring...");
			        
			setState(1305); scoped_name();
			setState(1306); match(STRING_LITERAL);
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

	public static class Readonly_attr_specContext extends ParserRuleContext {
		public TerminalNode KW_READONLY() { return getToken(IDLParser.KW_READONLY, 0); }
		public Param_type_specContext param_type_spec() {
			return getRuleContext(Param_type_specContext.class,0);
		}
		public TerminalNode KW_ATTRIBUTE() { return getToken(IDLParser.KW_ATTRIBUTE, 0); }
		public Readonly_attr_declaratorContext readonly_attr_declarator() {
			return getRuleContext(Readonly_attr_declaratorContext.class,0);
		}
		public Readonly_attr_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readonly_attr_spec; }
	}

	public final Readonly_attr_specContext readonly_attr_spec() throws RecognitionException {
		Readonly_attr_specContext _localctx = new Readonly_attr_specContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_readonly_attr_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1308); match(KW_READONLY);
			setState(1309); match(KW_ATTRIBUTE);
			setState(1310); param_type_spec();
			setState(1311); readonly_attr_declarator();
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

	public static class Readonly_attr_declaratorContext extends ParserRuleContext {
		public List<Simple_declaratorContext> simple_declarator() {
			return getRuleContexts(Simple_declaratorContext.class);
		}
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public Simple_declaratorContext simple_declarator(int i) {
			return getRuleContext(Simple_declaratorContext.class,i);
		}
		public Raises_exprContext raises_expr() {
			return getRuleContext(Raises_exprContext.class,0);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public Readonly_attr_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readonly_attr_declarator; }
	}

	public final Readonly_attr_declaratorContext readonly_attr_declarator() throws RecognitionException {
		Readonly_attr_declaratorContext _localctx = new Readonly_attr_declaratorContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_readonly_attr_declarator);
		int _la;
		try {
			setState(1324);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1313); simple_declarator();
				setState(1314); raises_expr();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1316); simple_declarator();
				setState(1321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(1317); match(COMA);
					setState(1318); simple_declarator();
					}
					}
					setState(1323);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class Attr_specContext extends ParserRuleContext {
		public Vector<Pair<Pair<String, Token>, TypeCode>> ret = new Vector<Pair<Pair<String, Token>, TypeCode>>();
		public Param_type_specContext param_type_spec;
		public Attr_declaratorContext attr_declarator;
		public Param_type_specContext param_type_spec() {
			return getRuleContext(Param_type_specContext.class,0);
		}
		public Attr_declaratorContext attr_declarator() {
			return getRuleContext(Attr_declaratorContext.class,0);
		}
		public TerminalNode KW_ATTRIBUTE() { return getToken(IDLParser.KW_ATTRIBUTE, 0); }
		public Attr_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_spec; }
	}

	public final Attr_specContext attr_spec() throws RecognitionException {
		Attr_specContext _localctx = new Attr_specContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_attr_spec);

		    TypeCode typecode = null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1326); match(KW_ATTRIBUTE);
			setState(1327); ((Attr_specContext)_localctx).param_type_spec = param_type_spec();
			 typecode=((Attr_specContext)_localctx).param_type_spec.typecode; 
			setState(1329); ((Attr_specContext)_localctx).attr_declarator = attr_declarator();

			    	   if(typecode != null)
			           {
			               for(int count = 0; count < ((Attr_specContext)_localctx).attr_declarator.ret.size(); ++count)
			               {
			                   // attr_declarator always is a simple declarator. Not a complex (array):
			                   // Simple declaration
			                   _localctx.ret.add(new Pair<Pair<String, Token>, TypeCode>(((Attr_specContext)_localctx).attr_declarator.ret.get(count).first(), typecode));
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

	public static class Attr_declaratorContext extends ParserRuleContext {
		public Vector<Pair<Pair<String, Token>, ContainerTypeCode>> ret;
		public Simple_declaratorContext simple_declarator;
		public List<Simple_declaratorContext> simple_declarator() {
			return getRuleContexts(Simple_declaratorContext.class);
		}
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public Simple_declaratorContext simple_declarator(int i) {
			return getRuleContext(Simple_declaratorContext.class,i);
		}
		public Attr_raises_exprContext attr_raises_expr() {
			return getRuleContext(Attr_raises_exprContext.class,0);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public Attr_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_declarator; }
	}

	public final Attr_declaratorContext attr_declarator() throws RecognitionException {
		Attr_declaratorContext _localctx = new Attr_declaratorContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_attr_declarator);

			((Attr_declaratorContext)_localctx).ret =  new Vector<Pair<Pair<String, Token>, ContainerTypeCode>>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1332); ((Attr_declaratorContext)_localctx).simple_declarator = simple_declarator();
			_localctx.ret.add(((Attr_declaratorContext)_localctx).simple_declarator.ret);
			setState(1344);
			switch (_input.LA(1)) {
			case KW_SETRAISES:
			case KW_GETRAISES:
				{
				setState(1334); attr_raises_expr();
				}
				break;
			case SEMICOLON:
			case COMA:
				{
				setState(1341);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(1335); match(COMA);
					setState(1336); ((Attr_declaratorContext)_localctx).simple_declarator = simple_declarator();
					_localctx.ret.add(((Attr_declaratorContext)_localctx).simple_declarator.ret);
					}
					}
					setState(1343);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Attr_raises_exprContext extends ParserRuleContext {
		public Set_excep_exprContext set_excep_expr() {
			return getRuleContext(Set_excep_exprContext.class,0);
		}
		public Get_excep_exprContext get_excep_expr() {
			return getRuleContext(Get_excep_exprContext.class,0);
		}
		public Attr_raises_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_raises_expr; }
	}

	public final Attr_raises_exprContext attr_raises_expr() throws RecognitionException {
		Attr_raises_exprContext _localctx = new Attr_raises_exprContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_attr_raises_expr);
		int _la;
		try {
			setState(1351);
			switch (_input.LA(1)) {
			case KW_GETRAISES:
				enterOuterAlt(_localctx, 1);
				{
				setState(1346); get_excep_expr();
				setState(1348);
				_la = _input.LA(1);
				if (_la==KW_SETRAISES) {
					{
					setState(1347); set_excep_expr();
					}
				}

				}
				break;
			case KW_SETRAISES:
				enterOuterAlt(_localctx, 2);
				{
				setState(1350); set_excep_expr();
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

	public static class Get_excep_exprContext extends ParserRuleContext {
		public TerminalNode KW_GETRAISES() { return getToken(IDLParser.KW_GETRAISES, 0); }
		public Exception_listContext exception_list() {
			return getRuleContext(Exception_listContext.class,0);
		}
		public Get_excep_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_get_excep_expr; }
	}

	public final Get_excep_exprContext get_excep_expr() throws RecognitionException {
		Get_excep_exprContext _localctx = new Get_excep_exprContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_get_excep_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1353); match(KW_GETRAISES);
			setState(1354); exception_list();
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

	public static class Set_excep_exprContext extends ParserRuleContext {
		public Exception_listContext exception_list() {
			return getRuleContext(Exception_listContext.class,0);
		}
		public TerminalNode KW_SETRAISES() { return getToken(IDLParser.KW_SETRAISES, 0); }
		public Set_excep_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_excep_expr; }
	}

	public final Set_excep_exprContext set_excep_expr() throws RecognitionException {
		Set_excep_exprContext _localctx = new Set_excep_exprContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_set_excep_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1356); match(KW_SETRAISES);
			setState(1357); exception_list();
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

	public static class Exception_listContext extends ParserRuleContext {
		public List<Scoped_nameContext> scoped_name() {
			return getRuleContexts(Scoped_nameContext.class);
		}
		public Scoped_nameContext scoped_name(int i) {
			return getRuleContext(Scoped_nameContext.class,i);
		}
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public Exception_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exception_list; }
	}

	public final Exception_listContext exception_list() throws RecognitionException {
		Exception_listContext _localctx = new Exception_listContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_exception_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1359); match(LEFT_BRACKET);
			setState(1360); scoped_name();
			setState(1365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(1361); match(COMA);
				setState(1362); scoped_name();
				}
				}
				setState(1367);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1368); match(RIGHT_BRACKET);
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

	public static class ComponentContext extends ParserRuleContext {
		public Component_forward_declContext component_forward_decl() {
			return getRuleContext(Component_forward_declContext.class,0);
		}
		public Component_declContext component_decl() {
			return getRuleContext(Component_declContext.class,0);
		}
		public ComponentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component; }
	}

	public final ComponentContext component() throws RecognitionException {
		ComponentContext _localctx = new ComponentContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_component);
		try {
			setState(1372);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1370); component_decl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1371); component_forward_decl();
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

	public static class Component_forward_declContext extends ParserRuleContext {
		public TerminalNode KW_COMPONENT() { return getToken(IDLParser.KW_COMPONENT, 0); }
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Component_forward_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component_forward_decl; }
	}

	public final Component_forward_declContext component_forward_decl() throws RecognitionException {
		Component_forward_declContext _localctx = new Component_forward_declContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_component_forward_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1374); match(KW_COMPONENT);

			            System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Component declarations are not supported. Ignoring...");
			        
			setState(1376); match(ID);
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

	public static class Component_declContext extends ParserRuleContext {
		public Component_bodyContext component_body() {
			return getRuleContext(Component_bodyContext.class,0);
		}
		public Component_headerContext component_header() {
			return getRuleContext(Component_headerContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public Component_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component_decl; }
	}

	public final Component_declContext component_decl() throws RecognitionException {
		Component_declContext _localctx = new Component_declContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_component_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1378); component_header();
			setState(1379); match(LEFT_BRACE);
			setState(1380); component_body();
			setState(1381); match(RIGHT_BRACE);
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

	public static class Component_headerContext extends ParserRuleContext {
		public TerminalNode KW_COMPONENT() { return getToken(IDLParser.KW_COMPONENT, 0); }
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Supported_interface_specContext supported_interface_spec() {
			return getRuleContext(Supported_interface_specContext.class,0);
		}
		public Component_inheritance_specContext component_inheritance_spec() {
			return getRuleContext(Component_inheritance_specContext.class,0);
		}
		public Component_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component_header; }
	}

	public final Component_headerContext component_header() throws RecognitionException {
		Component_headerContext _localctx = new Component_headerContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_component_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1383); match(KW_COMPONENT);
			setState(1384); match(ID);
			setState(1386);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(1385); component_inheritance_spec();
				}
			}

			setState(1389);
			_la = _input.LA(1);
			if (_la==KW_SUPPORTS) {
				{
				setState(1388); supported_interface_spec();
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

	public static class Supported_interface_specContext extends ParserRuleContext {
		public List<Scoped_nameContext> scoped_name() {
			return getRuleContexts(Scoped_nameContext.class);
		}
		public Scoped_nameContext scoped_name(int i) {
			return getRuleContext(Scoped_nameContext.class,i);
		}
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public TerminalNode KW_SUPPORTS() { return getToken(IDLParser.KW_SUPPORTS, 0); }
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public Supported_interface_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_supported_interface_spec; }
	}

	public final Supported_interface_specContext supported_interface_spec() throws RecognitionException {
		Supported_interface_specContext _localctx = new Supported_interface_specContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_supported_interface_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1391); match(KW_SUPPORTS);
			setState(1392); scoped_name();
			setState(1397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(1393); match(COMA);
				setState(1394); scoped_name();
				}
				}
				setState(1399);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Component_inheritance_specContext extends ParserRuleContext {
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(IDLParser.COLON, 0); }
		public Component_inheritance_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component_inheritance_spec; }
	}

	public final Component_inheritance_specContext component_inheritance_spec() throws RecognitionException {
		Component_inheritance_specContext _localctx = new Component_inheritance_specContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_component_inheritance_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1400); match(COLON);
			setState(1401); scoped_name();
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

	public static class Component_bodyContext extends ParserRuleContext {
		public Component_exportContext component_export(int i) {
			return getRuleContext(Component_exportContext.class,i);
		}
		public List<Component_exportContext> component_export() {
			return getRuleContexts(Component_exportContext.class);
		}
		public Component_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component_body; }
	}

	public final Component_bodyContext component_body() throws RecognitionException {
		Component_bodyContext _localctx = new Component_bodyContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_component_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1406);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & ((1L << (KW_EMITS - 40)) | (1L << (KW_PUBLISHES - 40)) | (1L << (KW_USES - 40)) | (1L << (KW_READONLY - 40)) | (1L << (KW_PROVIDES - 40)) | (1L << (KW_CONSUMES - 40)) | (1L << (KW_ATTRIBUTE - 40)))) != 0)) {
				{
				{
				setState(1403); component_export();
				}
				}
				setState(1408);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Component_exportContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public Attr_declContext attr_decl() {
			return getRuleContext(Attr_declContext.class,0);
		}
		public Provides_declContext provides_decl() {
			return getRuleContext(Provides_declContext.class,0);
		}
		public Emits_declContext emits_decl() {
			return getRuleContext(Emits_declContext.class,0);
		}
		public Consumes_declContext consumes_decl() {
			return getRuleContext(Consumes_declContext.class,0);
		}
		public Publishes_declContext publishes_decl() {
			return getRuleContext(Publishes_declContext.class,0);
		}
		public Uses_declContext uses_decl() {
			return getRuleContext(Uses_declContext.class,0);
		}
		public Component_exportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component_export; }
	}

	public final Component_exportContext component_export() throws RecognitionException {
		Component_exportContext _localctx = new Component_exportContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_component_export);
		try {
			setState(1427);
			switch (_input.LA(1)) {
			case KW_PROVIDES:
				enterOuterAlt(_localctx, 1);
				{
				setState(1409); provides_decl();
				setState(1410); match(SEMICOLON);
				}
				break;
			case KW_USES:
				enterOuterAlt(_localctx, 2);
				{
				setState(1412); uses_decl();
				setState(1413); match(SEMICOLON);
				}
				break;
			case KW_EMITS:
				enterOuterAlt(_localctx, 3);
				{
				setState(1415); emits_decl();
				setState(1416); match(SEMICOLON);
				}
				break;
			case KW_PUBLISHES:
				enterOuterAlt(_localctx, 4);
				{
				setState(1418); publishes_decl();
				setState(1419); match(SEMICOLON);
				}
				break;
			case KW_CONSUMES:
				enterOuterAlt(_localctx, 5);
				{
				setState(1421); consumes_decl();
				setState(1422); match(SEMICOLON);
				}
				break;
			case KW_READONLY:
			case KW_ATTRIBUTE:
				enterOuterAlt(_localctx, 6);
				{
				setState(1424); attr_decl();
				setState(1425); match(SEMICOLON);
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

	public static class Provides_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode KW_PROVIDES() { return getToken(IDLParser.KW_PROVIDES, 0); }
		public Interface_typeContext interface_type() {
			return getRuleContext(Interface_typeContext.class,0);
		}
		public Provides_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_provides_decl; }
	}

	public final Provides_declContext provides_decl() throws RecognitionException {
		Provides_declContext _localctx = new Provides_declContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_provides_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1429); match(KW_PROVIDES);
			setState(1430); interface_type();
			setState(1431); match(ID);
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

	public static class Interface_typeContext extends ParserRuleContext {
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode KW_OBJECT() { return getToken(IDLParser.KW_OBJECT, 0); }
		public Interface_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interface_type; }
	}

	public final Interface_typeContext interface_type() throws RecognitionException {
		Interface_typeContext _localctx = new Interface_typeContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_interface_type);
		try {
			setState(1435);
			switch (_input.LA(1)) {
			case DOUBLE_COLON:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1433); scoped_name();
				}
				break;
			case KW_OBJECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1434); match(KW_OBJECT);
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

	public static class Uses_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode KW_USES() { return getToken(IDLParser.KW_USES, 0); }
		public TerminalNode KW_MULTIPLE() { return getToken(IDLParser.KW_MULTIPLE, 0); }
		public Interface_typeContext interface_type() {
			return getRuleContext(Interface_typeContext.class,0);
		}
		public Uses_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uses_decl; }
	}

	public final Uses_declContext uses_decl() throws RecognitionException {
		Uses_declContext _localctx = new Uses_declContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_uses_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1437); match(KW_USES);
			setState(1439);
			_la = _input.LA(1);
			if (_la==KW_MULTIPLE) {
				{
				setState(1438); match(KW_MULTIPLE);
				}
			}

			setState(1441); interface_type();
			setState(1442); match(ID);
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

	public static class Emits_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode KW_EMITS() { return getToken(IDLParser.KW_EMITS, 0); }
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Emits_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emits_decl; }
	}

	public final Emits_declContext emits_decl() throws RecognitionException {
		Emits_declContext _localctx = new Emits_declContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_emits_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1444); match(KW_EMITS);
			setState(1445); scoped_name();
			setState(1446); match(ID);
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

	public static class Publishes_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode KW_PUBLISHES() { return getToken(IDLParser.KW_PUBLISHES, 0); }
		public Publishes_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_publishes_decl; }
	}

	public final Publishes_declContext publishes_decl() throws RecognitionException {
		Publishes_declContext _localctx = new Publishes_declContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_publishes_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1448); match(KW_PUBLISHES);
			setState(1449); scoped_name();
			setState(1450); match(ID);
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

	public static class Consumes_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode KW_CONSUMES() { return getToken(IDLParser.KW_CONSUMES, 0); }
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public Consumes_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_consumes_decl; }
	}

	public final Consumes_declContext consumes_decl() throws RecognitionException {
		Consumes_declContext _localctx = new Consumes_declContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_consumes_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1452); match(KW_CONSUMES);
			setState(1453); scoped_name();
			setState(1454); match(ID);
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

	public static class Home_declContext extends ParserRuleContext {
		public Home_headerContext home_header() {
			return getRuleContext(Home_headerContext.class,0);
		}
		public Home_bodyContext home_body() {
			return getRuleContext(Home_bodyContext.class,0);
		}
		public Home_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_home_decl; }
	}

	public final Home_declContext home_decl() throws RecognitionException {
		Home_declContext _localctx = new Home_declContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_home_decl);

		    System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Home declarations are not supported. Ignoring...");

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1456); home_header();
			setState(1457); home_body();
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

	public static class Home_headerContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode KW_HOME() { return getToken(IDLParser.KW_HOME, 0); }
		public Home_inheritance_specContext home_inheritance_spec() {
			return getRuleContext(Home_inheritance_specContext.class,0);
		}
		public TerminalNode KW_MANAGES() { return getToken(IDLParser.KW_MANAGES, 0); }
		public Supported_interface_specContext supported_interface_spec() {
			return getRuleContext(Supported_interface_specContext.class,0);
		}
		public Primary_key_specContext primary_key_spec() {
			return getRuleContext(Primary_key_specContext.class,0);
		}
		public Home_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_home_header; }
	}

	public final Home_headerContext home_header() throws RecognitionException {
		Home_headerContext _localctx = new Home_headerContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_home_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1459); match(KW_HOME);
			setState(1460); match(ID);
			setState(1462);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(1461); home_inheritance_spec();
				}
			}

			setState(1465);
			_la = _input.LA(1);
			if (_la==KW_SUPPORTS) {
				{
				setState(1464); supported_interface_spec();
				}
			}

			setState(1467); match(KW_MANAGES);
			setState(1468); scoped_name();
			setState(1470);
			_la = _input.LA(1);
			if (_la==KW_PRIMARYKEY) {
				{
				setState(1469); primary_key_spec();
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

	public static class Home_inheritance_specContext extends ParserRuleContext {
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(IDLParser.COLON, 0); }
		public Home_inheritance_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_home_inheritance_spec; }
	}

	public final Home_inheritance_specContext home_inheritance_spec() throws RecognitionException {
		Home_inheritance_specContext _localctx = new Home_inheritance_specContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_home_inheritance_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1472); match(COLON);
			setState(1473); scoped_name();
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

	public static class Primary_key_specContext extends ParserRuleContext {
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode KW_PRIMARYKEY() { return getToken(IDLParser.KW_PRIMARYKEY, 0); }
		public Primary_key_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_key_spec; }
	}

	public final Primary_key_specContext primary_key_spec() throws RecognitionException {
		Primary_key_specContext _localctx = new Primary_key_specContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_primary_key_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1475); match(KW_PRIMARYKEY);
			setState(1476); scoped_name();
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

	public static class Home_bodyContext extends ParserRuleContext {
		public Home_exportContext home_export(int i) {
			return getRuleContext(Home_exportContext.class,i);
		}
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public List<Home_exportContext> home_export() {
			return getRuleContexts(Home_exportContext.class);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public Home_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_home_body; }
	}

	public final Home_bodyContext home_body() throws RecognitionException {
		Home_bodyContext _localctx = new Home_bodyContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_home_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1478); match(LEFT_BRACE);
			setState(1482);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << DOUBLE_COLON) | (1L << KW_STRING) | (1L << KW_TYPEDEF) | (1L << KW_OCTET) | (1L << KW_STRUCT) | (1L << KW_NATIVE) | (1L << KW_READONLY) | (1L << KW_FINDER) | (1L << KW_VOID) | (1L << KW_WCHAR) | (1L << KW_SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_LONG - 64)) | (1L << (KW_ENUM - 64)) | (1L << (KW_WSTRING - 64)) | (1L << (KW_FACTORY - 64)) | (1L << (KW_EXCEPTION - 64)) | (1L << (KW_CONST - 64)) | (1L << (KW_VALUEBASE - 64)) | (1L << (KW_OBJECT - 64)) | (1L << (KW_UNSIGNED - 64)) | (1L << (KW_UNION - 64)) | (1L << (KW_ONEWAY - 64)) | (1L << (KW_ANY - 64)) | (1L << (KW_CHAR - 64)) | (1L << (KW_FLOAT - 64)) | (1L << (KW_BOOLEAN - 64)) | (1L << (KW_DOUBLE - 64)) | (1L << (KW_TYPEPREFIX - 64)) | (1L << (KW_TYPEID - 64)) | (1L << (KW_ATTRIBUTE - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(1479); home_export();
				}
				}
				setState(1484);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1485); match(RIGHT_BRACE);
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

	public static class Home_exportContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(IDLParser.SEMICOLON, 0); }
		public ExportContext export() {
			return getRuleContext(ExportContext.class,0);
		}
		public Factory_declContext factory_decl() {
			return getRuleContext(Factory_declContext.class,0);
		}
		public Finder_declContext finder_decl() {
			return getRuleContext(Finder_declContext.class,0);
		}
		public Home_exportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_home_export; }
	}

	public final Home_exportContext home_export() throws RecognitionException {
		Home_exportContext _localctx = new Home_exportContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_home_export);
		try {
			setState(1494);
			switch (_input.LA(1)) {
			case AT:
			case DOUBLE_COLON:
			case KW_STRING:
			case KW_TYPEDEF:
			case KW_OCTET:
			case KW_STRUCT:
			case KW_NATIVE:
			case KW_READONLY:
			case KW_VOID:
			case KW_WCHAR:
			case KW_SHORT:
			case KW_LONG:
			case KW_ENUM:
			case KW_WSTRING:
			case KW_EXCEPTION:
			case KW_CONST:
			case KW_VALUEBASE:
			case KW_OBJECT:
			case KW_UNSIGNED:
			case KW_UNION:
			case KW_ONEWAY:
			case KW_ANY:
			case KW_CHAR:
			case KW_FLOAT:
			case KW_BOOLEAN:
			case KW_DOUBLE:
			case KW_TYPEPREFIX:
			case KW_TYPEID:
			case KW_ATTRIBUTE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1487); export(null);
				}
				break;
			case KW_FACTORY:
				enterOuterAlt(_localctx, 2);
				{
				setState(1488); factory_decl();
				setState(1489); match(SEMICOLON);
				}
				break;
			case KW_FINDER:
				enterOuterAlt(_localctx, 3);
				{
				setState(1491); finder_decl();
				setState(1492); match(SEMICOLON);
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

	public static class Factory_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Init_param_declsContext init_param_decls() {
			return getRuleContext(Init_param_declsContext.class,0);
		}
		public TerminalNode KW_FACTORY() { return getToken(IDLParser.KW_FACTORY, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public Raises_exprContext raises_expr() {
			return getRuleContext(Raises_exprContext.class,0);
		}
		public Factory_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factory_decl; }
	}

	public final Factory_declContext factory_decl() throws RecognitionException {
		Factory_declContext _localctx = new Factory_declContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_factory_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1496); match(KW_FACTORY);
			setState(1497); match(ID);
			setState(1498); match(LEFT_BRACKET);
			setState(1500);
			_la = _input.LA(1);
			if (_la==KW_IN) {
				{
				setState(1499); init_param_decls();
				}
			}

			setState(1502); match(RIGHT_BRACKET);
			setState(1504);
			_la = _input.LA(1);
			if (_la==KW_RAISES) {
				{
				setState(1503); raises_expr();
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

	public static class Finder_declContext extends ParserRuleContext {
		public TerminalNode KW_FINDER() { return getToken(IDLParser.KW_FINDER, 0); }
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public Init_param_declsContext init_param_decls() {
			return getRuleContext(Init_param_declsContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public Raises_exprContext raises_expr() {
			return getRuleContext(Raises_exprContext.class,0);
		}
		public Finder_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finder_decl; }
	}

	public final Finder_declContext finder_decl() throws RecognitionException {
		Finder_declContext _localctx = new Finder_declContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_finder_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1506); match(KW_FINDER);
			setState(1507); match(ID);
			setState(1508); match(LEFT_BRACKET);
			setState(1510);
			_la = _input.LA(1);
			if (_la==KW_IN) {
				{
				setState(1509); init_param_decls();
				}
			}

			setState(1512); match(RIGHT_BRACKET);
			setState(1514);
			_la = _input.LA(1);
			if (_la==KW_RAISES) {
				{
				setState(1513); raises_expr();
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

	public static class EventContext extends ParserRuleContext {
		public Event_abs_declContext event_abs_decl() {
			return getRuleContext(Event_abs_declContext.class,0);
		}
		public Event_declContext event_decl() {
			return getRuleContext(Event_declContext.class,0);
		}
		public Event_forward_declContext event_forward_decl() {
			return getRuleContext(Event_forward_declContext.class,0);
		}
		public EventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event; }
	}

	public final EventContext event() throws RecognitionException {
		EventContext _localctx = new EventContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_event);

		    System.out.println("WARNING (File " + ctx.getFilename() + ", Line " + (_input.LT(1) != null ? _input.LT(1).getLine() - ctx.getCurrentIncludeLine() : "1") + "): Event declarations are not supported. Ignoring...");

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1519);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				{
				setState(1516); event_decl();
				}
				break;

			case 2:
				{
				setState(1517); event_abs_decl();
				}
				break;

			case 3:
				{
				setState(1518); event_forward_decl();
				}
				break;
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

	public static class Event_forward_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode KW_EVENTTYPE() { return getToken(IDLParser.KW_EVENTTYPE, 0); }
		public TerminalNode KW_ABSTRACT() { return getToken(IDLParser.KW_ABSTRACT, 0); }
		public Event_forward_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_forward_decl; }
	}

	public final Event_forward_declContext event_forward_decl() throws RecognitionException {
		Event_forward_declContext _localctx = new Event_forward_declContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_event_forward_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1522);
			_la = _input.LA(1);
			if (_la==KW_ABSTRACT) {
				{
				setState(1521); match(KW_ABSTRACT);
				}
			}

			setState(1524); match(KW_EVENTTYPE);
			setState(1525); match(ID);
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

	public static class Event_abs_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public List<ExportContext> export() {
			return getRuleContexts(ExportContext.class);
		}
		public ExportContext export(int i) {
			return getRuleContext(ExportContext.class,i);
		}
		public TerminalNode KW_EVENTTYPE() { return getToken(IDLParser.KW_EVENTTYPE, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public TerminalNode KW_ABSTRACT() { return getToken(IDLParser.KW_ABSTRACT, 0); }
		public Value_inheritance_specContext value_inheritance_spec() {
			return getRuleContext(Value_inheritance_specContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public Event_abs_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_abs_decl; }
	}

	public final Event_abs_declContext event_abs_decl() throws RecognitionException {
		Event_abs_declContext _localctx = new Event_abs_declContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_event_abs_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1527); match(KW_ABSTRACT);
			setState(1528); match(KW_EVENTTYPE);
			setState(1529); match(ID);
			setState(1530); value_inheritance_spec();
			setState(1531); match(LEFT_BRACE);
			setState(1535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << DOUBLE_COLON) | (1L << KW_STRING) | (1L << KW_TYPEDEF) | (1L << KW_OCTET) | (1L << KW_STRUCT) | (1L << KW_NATIVE) | (1L << KW_READONLY) | (1L << KW_VOID) | (1L << KW_WCHAR) | (1L << KW_SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_LONG - 64)) | (1L << (KW_ENUM - 64)) | (1L << (KW_WSTRING - 64)) | (1L << (KW_EXCEPTION - 64)) | (1L << (KW_CONST - 64)) | (1L << (KW_VALUEBASE - 64)) | (1L << (KW_OBJECT - 64)) | (1L << (KW_UNSIGNED - 64)) | (1L << (KW_UNION - 64)) | (1L << (KW_ONEWAY - 64)) | (1L << (KW_ANY - 64)) | (1L << (KW_CHAR - 64)) | (1L << (KW_FLOAT - 64)) | (1L << (KW_BOOLEAN - 64)) | (1L << (KW_DOUBLE - 64)) | (1L << (KW_TYPEPREFIX - 64)) | (1L << (KW_TYPEID - 64)) | (1L << (KW_ATTRIBUTE - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(1532); export(null);
				}
				}
				setState(1537);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1538); match(RIGHT_BRACE);
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

	public static class Event_declContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(IDLParser.LEFT_BRACE, 0); }
		public Value_elementContext value_element(int i) {
			return getRuleContext(Value_elementContext.class,i);
		}
		public List<Value_elementContext> value_element() {
			return getRuleContexts(Value_elementContext.class);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(IDLParser.RIGHT_BRACE, 0); }
		public Event_headerContext event_header() {
			return getRuleContext(Event_headerContext.class,0);
		}
		public Event_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_decl; }
	}

	public final Event_declContext event_decl() throws RecognitionException {
		Event_declContext _localctx = new Event_declContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_event_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1540); event_header();
			setState(1541); match(LEFT_BRACE);
			setState(1545);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << DOUBLE_COLON) | (1L << KW_STRING) | (1L << KW_TYPEDEF) | (1L << KW_OCTET) | (1L << KW_STRUCT) | (1L << KW_NATIVE) | (1L << KW_READONLY) | (1L << KW_VOID) | (1L << KW_PRIVATE) | (1L << KW_WCHAR) | (1L << KW_PUBLIC) | (1L << KW_SHORT))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (KW_LONG - 64)) | (1L << (KW_ENUM - 64)) | (1L << (KW_WSTRING - 64)) | (1L << (KW_FACTORY - 64)) | (1L << (KW_EXCEPTION - 64)) | (1L << (KW_CONST - 64)) | (1L << (KW_VALUEBASE - 64)) | (1L << (KW_OBJECT - 64)) | (1L << (KW_UNSIGNED - 64)) | (1L << (KW_UNION - 64)) | (1L << (KW_ONEWAY - 64)) | (1L << (KW_ANY - 64)) | (1L << (KW_CHAR - 64)) | (1L << (KW_FLOAT - 64)) | (1L << (KW_BOOLEAN - 64)) | (1L << (KW_DOUBLE - 64)) | (1L << (KW_TYPEPREFIX - 64)) | (1L << (KW_TYPEID - 64)) | (1L << (KW_ATTRIBUTE - 64)) | (1L << (ID - 64)))) != 0)) {
				{
				{
				setState(1542); value_element();
				}
				}
				setState(1547);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1548); match(RIGHT_BRACE);
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

	public static class Event_headerContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public TerminalNode KW_EVENTTYPE() { return getToken(IDLParser.KW_EVENTTYPE, 0); }
		public TerminalNode KW_CUSTOM() { return getToken(IDLParser.KW_CUSTOM, 0); }
		public Value_inheritance_specContext value_inheritance_spec() {
			return getRuleContext(Value_inheritance_specContext.class,0);
		}
		public Event_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_header; }
	}

	public final Event_headerContext event_header() throws RecognitionException {
		Event_headerContext _localctx = new Event_headerContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_event_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1551);
			_la = _input.LA(1);
			if (_la==KW_CUSTOM) {
				{
				setState(1550); match(KW_CUSTOM);
				}
			}

			setState(1553); match(KW_EVENTTYPE);
			setState(1554); match(ID);
			setState(1555); value_inheritance_spec();
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

	public static class Annotation_applContext extends ParserRuleContext {
		public Annotation annotation = null;
		public Scoped_nameContext scoped_name;
		public TerminalNode AT() { return getToken(IDLParser.AT, 0); }
		public Annotation_appl_paramsContext annotation_appl_params() {
			return getRuleContext(Annotation_appl_paramsContext.class,0);
		}
		public Scoped_nameContext scoped_name() {
			return getRuleContext(Scoped_nameContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(IDLParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(IDLParser.RIGHT_BRACKET, 0); }
		public Annotation_applContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation_appl; }
	}

	public final Annotation_applContext annotation_appl() throws RecognitionException {
		Annotation_applContext _localctx = new Annotation_applContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_annotation_appl);

		    AnnotationDeclaration anndecl = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1557); match(AT);
			setState(1558); ((Annotation_applContext)_localctx).scoped_name = scoped_name();

			        anndecl = ctx.getAnnotationDeclaration(((Annotation_applContext)_localctx).scoped_name.pair.first());
					if(anndecl == null)
			        {
						throw new ParseException(((Annotation_applContext)_localctx).scoped_name.pair.second(), "was not defined previously");
					}

			        ((Annotation_applContext)_localctx).annotation =  new Annotation(anndecl);
				
			setState(1565);
			_la = _input.LA(1);
			if (_la==LEFT_BRACKET) {
				{
				setState(1560); match(LEFT_BRACKET);
				setState(1562);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 2) | (1L << INTEGER_LITERAL) | (1L << HEX_LITERAL) | (1L << FLOATING_PT_LITERAL) | (1L << FIXED_PT_LITERAL) | (1L << WIDE_CHARACTER_LITERAL) | (1L << CHARACTER_LITERAL) | (1L << WIDE_STRING_LITERAL) | (1L << STRING_LITERAL) | (1L << LEFT_BRACKET) | (1L << TILDE) | (1L << PLUS) | (1L << MINUS) | (1L << DOUBLE_COLON))) != 0) || _la==ID) {
					{
					setState(1561); annotation_appl_params(_localctx.annotation, ((Annotation_applContext)_localctx).scoped_name.pair.second());
					}
				}

				setState(1564); match(RIGHT_BRACKET);
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

	public static class Annotation_appl_paramsContext extends ParserRuleContext {
		public Annotation annotation;
		public Token tkannot;
		public Const_expContext const_exp;
		public List<Annotation_appl_paramContext> annotation_appl_param() {
			return getRuleContexts(Annotation_appl_paramContext.class);
		}
		public Annotation_appl_paramContext annotation_appl_param(int i) {
			return getRuleContext(Annotation_appl_paramContext.class,i);
		}
		public TerminalNode COMA(int i) {
			return getToken(IDLParser.COMA, i);
		}
		public Const_expContext const_exp() {
			return getRuleContext(Const_expContext.class,0);
		}
		public List<TerminalNode> COMA() { return getTokens(IDLParser.COMA); }
		public Annotation_appl_paramsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Annotation_appl_paramsContext(ParserRuleContext parent, int invokingState, Annotation annotation, Token tkannot) {
			super(parent, invokingState);
			this.annotation = annotation;
			this.tkannot = tkannot;
		}
		@Override public int getRuleIndex() { return RULE_annotation_appl_params; }
	}

	public final Annotation_appl_paramsContext annotation_appl_params(Annotation annotation,Token tkannot) throws RecognitionException {
		Annotation_appl_paramsContext _localctx = new Annotation_appl_paramsContext(_ctx, getState(), annotation, tkannot);
		enterRule(_localctx, 302, RULE_annotation_appl_params);
		int _la;
		try {
			setState(1578);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1567); ((Annotation_appl_paramsContext)_localctx).const_exp = const_exp();

				        if(!annotation.addValue(((Annotation_appl_paramsContext)_localctx).const_exp.literalStr))
				            throw new ParseException(tkannot, "not has only one attribute.");
					
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1570); annotation_appl_param(annotation);
				setState(1575);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(1571); match(COMA);
					setState(1572); annotation_appl_param(annotation);
					}
					}
					setState(1577);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class Annotation_appl_paramContext extends ParserRuleContext {
		public Annotation annotation;
		public IdentifierContext identifier;
		public Const_expContext const_exp;
		public TerminalNode EQUAL() { return getToken(IDLParser.EQUAL, 0); }
		public Const_expContext const_exp() {
			return getRuleContext(Const_expContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Annotation_appl_paramContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Annotation_appl_paramContext(ParserRuleContext parent, int invokingState, Annotation annotation) {
			super(parent, invokingState);
			this.annotation = annotation;
		}
		@Override public int getRuleIndex() { return RULE_annotation_appl_param; }
	}

	public final Annotation_appl_paramContext annotation_appl_param(Annotation annotation) throws RecognitionException {
		Annotation_appl_paramContext _localctx = new Annotation_appl_paramContext(_ctx, getState(), annotation);
		enterRule(_localctx, 304, RULE_annotation_appl_param);

		    Token tk = _input.LT(1);

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1580); ((Annotation_appl_paramContext)_localctx).identifier = identifier();
			setState(1581); match(EQUAL);
			setState(1582); ((Annotation_appl_paramContext)_localctx).const_exp = const_exp();

			        if(!annotation.addValue(((Annotation_appl_paramContext)_localctx).identifier.id, ((Annotation_appl_paramContext)_localctx).const_exp.literalStr))
			            throw new ParseException(tk, "is not an attribute of annotation " + annotation.getName());
			    
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

	public static class IdentifierContext extends ParserRuleContext {
		public String id;
		public TerminalNode ID() { return getToken(IDLParser.ID, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_identifier);

			((IdentifierContext)_localctx).id =  _input.LT(1).getText();

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1585); match(ID);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3l\u0636\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"+
		"\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"+
		"\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e"+
		"\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092\t\u0092"+
		"\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096\4\u0097"+
		"\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b\t\u009b"+
		"\3\2\7\2\u0138\n\2\f\2\16\2\u013b\13\2\3\2\3\2\3\2\6\2\u0140\n\2\r\2\16"+
		"\2\u0141\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u0175"+
		"\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\6"+
		"\6\u0187\n\6\r\6\16\6\u0188\3\7\3\7\3\7\3\7\5\7\u018f\n\7\3\b\5\b\u0192"+
		"\n\b\3\b\3\b\3\b\3\b\3\b\5\b\u0199\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\5\t\u01a3\n\t\3\t\3\t\3\t\3\n\3\n\3\n\7\n\u01ab\n\n\f\n\16\n\u01ae\13"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u01cf\n\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u01e1\n\17\f\17\16\17\u01e4\13"+
		"\17\3\20\3\20\5\20\u01e8\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20"+
		"\u01f1\n\20\f\20\16\20\u01f4\13\20\3\20\3\20\3\21\3\21\3\21\3\21\5\21"+
		"\u01fc\n\21\3\22\5\22\u01ff\n\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\7\24\u020e\n\24\f\24\16\24\u0211\13\24\3"+
		"\24\3\24\3\25\3\25\3\25\7\25\u0218\n\25\f\25\16\25\u021b\13\25\3\25\3"+
		"\25\3\26\5\26\u0220\n\26\3\26\3\26\3\26\3\26\3\27\3\27\5\27\u0228\n\27"+
		"\3\27\3\27\3\27\7\27\u022d\n\27\f\27\16\27\u0230\13\27\5\27\u0232\n\27"+
		"\3\27\3\27\3\27\3\27\7\27\u0238\n\27\f\27\16\27\u023b\13\27\5\27\u023d"+
		"\n\27\3\30\3\30\3\31\3\31\3\31\5\31\u0244\n\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\5\33\u024f\n\33\3\33\3\33\5\33\u0253\n\33\3\33\3"+
		"\33\3\34\3\34\3\34\7\34\u025a\n\34\f\34\16\34\u025d\13\34\3\35\3\35\3"+
		"\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \5 \u028b\n \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\7\"\u0297"+
		"\n\"\f\"\16\"\u029a\13\"\3#\3#\3#\3#\3#\3#\3#\7#\u02a3\n#\f#\16#\u02a6"+
		"\13#\3$\3$\3$\3$\3$\3$\3$\7$\u02af\n$\f$\16$\u02b2\13$\3%\3%\3%\3%\3%"+
		"\3%\3%\7%\u02bb\n%\f%\16%\u02be\13%\3&\3&\3&\3&\3&\3&\3&\7&\u02c7\n&\f"+
		"&\16&\u02ca\13&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u02d3\n\'\f\'\16\'\u02d6"+
		"\13\'\3(\3(\3(\3(\3(\3(\3(\3(\5(\u02e0\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\3)\3)\5)\u02ee\n)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u02fb\n*\3*\3"+
		"*\3+\3+\3+\3+\5+\u0303\n+\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3"+
		"-\3-\3-\3-\3-\3-\3-\3-\5-\u031b\n-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\5/\u0327"+
		"\n/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u0332\n\60\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u0349\n\61\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\5\62\u0355\n\62\3\63\3\63\3\63\5\63\u035a\n"+
		"\63\3\64\3\64\3\64\3\64\3\64\3\64\7\64\u0362\n\64\f\64\16\64\u0365\13"+
		"\64\3\65\3\65\3\65\3\65\3\65\3\65\5\65\u036d\n\65\3\66\3\66\3\66\3\67"+
		"\3\67\3\67\38\38\38\38\38\38\38\58\u037c\n8\39\39\39\39\39\39\59\u0384"+
		"\n9\3:\3:\3:\3:\3:\3:\3:\3:\3:\5:\u038f\n:\3;\3;\3<\3<\3=\3=\3=\3>\3>"+
		"\3>\3>\3>\3>\3>\3>\3>\5>\u03a1\n>\3?\3?\3?\3@\3@\3@\3A\3A\3A\3A\3B\3B"+
		"\3C\3C\3D\3D\3E\3E\3F\3F\3F\3G\3G\3G\3H\3H\3H\3H\5H\u03bf\nH\3I\3I\3I"+
		"\3I\3I\3I\3J\3J\3J\3J\3J\5J\u03cc\nJ\3K\3K\3K\3K\3L\7L\u03d3\nL\fL\16"+
		"L\u03d6\13L\3M\3M\3M\3M\3M\3M\5M\u03de\nM\3M\3M\3M\3N\3N\3N\3O\3O\3O\3"+
		"O\3O\3O\3O\3O\3P\3P\3P\6P\u03f1\nP\rP\16P\u03f2\3Q\3Q\3Q\3Q\3Q\3Q\3Q\5"+
		"Q\u03fc\nQ\3R\3R\3R\3R\3R\3R\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3"+
		"S\3T\3T\3T\3T\3T\3T\3T\3T\3T\3T\3T\3T\3T\5T\u041f\nT\3U\3U\3V\6V\u0424"+
		"\nV\rV\16V\u0425\3W\3W\3W\3W\3W\3W\3W\3W\6W\u0430\nW\rW\16W\u0431\3W\3"+
		"W\3W\3W\3X\3X\3X\3X\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Z\3Z\3Z\7Z\u0447\nZ\fZ\16"+
		"Z\u044a\13Z\3[\3[\3[\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3"+
		"\\\3\\\3\\\5\\\u045e\n\\\3\\\3\\\3]\3]\3]\3]\3]\3]\3]\5]\u0469\n]\3]\3"+
		"]\3^\3^\3^\3^\3^\3^\3^\5^\u0474\n^\3^\3^\3_\3_\3_\3_\6_\u047c\n_\r_\16"+
		"_\u047d\3_\3_\3`\3`\3`\3`\3`\3a\3a\3a\3a\5a\u048b\na\3b\3b\3b\3b\3b\3"+
		"b\3b\3b\3b\3b\3c\3c\3c\7c\u049a\nc\fc\16c\u049d\13c\3d\3d\3d\5d\u04a2"+
		"\nd\3d\3d\3d\3d\3d\3d\3d\3d\3d\3d\3d\5d\u04af\nd\3d\5d\u04b2\nd\3d\3d"+
		"\3e\3e\3e\3f\3f\3f\3f\5f\u04bd\nf\3g\3g\5g\u04c1\ng\3g\3g\3h\3h\3h\3h"+
		"\3h\3h\3h\3h\7h\u04cd\nh\fh\16h\u04d0\13h\3i\3i\3i\3i\3i\3i\3j\3j\3j\3"+
		"j\3j\3j\3k\3k\3k\3k\3k\7k\u04e3\nk\fk\16k\u04e6\13k\3k\3k\3l\3l\3l\3l"+
		"\3l\3l\3l\3l\3l\3l\3l\3l\5l\u04f6\nl\3m\3m\3m\3m\3m\3m\3m\3m\3n\3n\3n"+
		"\3o\3o\3o\3p\3p\3p\3p\5p\u050a\np\3q\3q\3q\3q\3q\3r\3r\5r\u0513\nr\3s"+
		"\3s\3s\3s\3s\3t\3t\3t\3t\3t\3u\3u\3u\3u\3u\3v\3v\3v\3v\3v\3v\7v\u052a"+
		"\nv\fv\16v\u052d\13v\5v\u052f\nv\3w\3w\3w\3w\3w\3w\3x\3x\3x\3x\3x\3x\3"+
		"x\7x\u053e\nx\fx\16x\u0541\13x\5x\u0543\nx\3y\3y\5y\u0547\ny\3y\5y\u054a"+
		"\ny\3z\3z\3z\3{\3{\3{\3|\3|\3|\3|\7|\u0556\n|\f|\16|\u0559\13|\3|\3|\3"+
		"}\3}\5}\u055f\n}\3~\3~\3~\3~\3\177\3\177\3\177\3\177\3\177\3\u0080\3\u0080"+
		"\3\u0080\5\u0080\u056d\n\u0080\3\u0080\5\u0080\u0570\n\u0080\3\u0081\3"+
		"\u0081\3\u0081\3\u0081\7\u0081\u0576\n\u0081\f\u0081\16\u0081\u0579\13"+
		"\u0081\3\u0082\3\u0082\3\u0082\3\u0083\7\u0083\u057f\n\u0083\f\u0083\16"+
		"\u0083\u0582\13\u0083\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084"+
		"\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084"+
		"\3\u0084\3\u0084\3\u0084\5\u0084\u0596\n\u0084\3\u0085\3\u0085\3\u0085"+
		"\3\u0085\3\u0086\3\u0086\5\u0086\u059e\n\u0086\3\u0087\3\u0087\5\u0087"+
		"\u05a2\n\u0087\3\u0087\3\u0087\3\u0087\3\u0088\3\u0088\3\u0088\3\u0088"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u008a\3\u008a\3\u008a\3\u008a\3\u008b"+
		"\3\u008b\3\u008b\3\u008c\3\u008c\3\u008c\5\u008c\u05b9\n\u008c\3\u008c"+
		"\5\u008c\u05bc\n\u008c\3\u008c\3\u008c\3\u008c\5\u008c\u05c1\n\u008c\3"+
		"\u008d\3\u008d\3\u008d\3\u008e\3\u008e\3\u008e\3\u008f\3\u008f\7\u008f"+
		"\u05cb\n\u008f\f\u008f\16\u008f\u05ce\13\u008f\3\u008f\3\u008f\3\u0090"+
		"\3\u0090\3\u0090\3\u0090\3\u0090\3\u0090\3\u0090\5\u0090\u05d9\n\u0090"+
		"\3\u0091\3\u0091\3\u0091\3\u0091\5\u0091\u05df\n\u0091\3\u0091\3\u0091"+
		"\5\u0091\u05e3\n\u0091\3\u0092\3\u0092\3\u0092\3\u0092\5\u0092\u05e9\n"+
		"\u0092\3\u0092\3\u0092\5\u0092\u05ed\n\u0092\3\u0093\3\u0093\3\u0093\5"+
		"\u0093\u05f2\n\u0093\3\u0094\5\u0094\u05f5\n\u0094\3\u0094\3\u0094\3\u0094"+
		"\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\7\u0095\u0600\n\u0095"+
		"\f\u0095\16\u0095\u0603\13\u0095\3\u0095\3\u0095\3\u0096\3\u0096\3\u0096"+
		"\7\u0096\u060a\n\u0096\f\u0096\16\u0096\u060d\13\u0096\3\u0096\3\u0096"+
		"\3\u0097\5\u0097\u0612\n\u0097\3\u0097\3\u0097\3\u0097\3\u0097\3\u0098"+
		"\3\u0098\3\u0098\3\u0098\3\u0098\5\u0098\u061d\n\u0098\3\u0098\5\u0098"+
		"\u0620\n\u0098\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\7\u0099"+
		"\u0628\n\u0099\f\u0099\16\u0099\u062b\13\u0099\5\u0099\u062d\n\u0099\3"+
		"\u009a\3\u009a\3\u009a\3\u009a\3\u009a\3\u009b\3\u009b\3\u009b\2\2\u009c"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH"+
		"JLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c"+
		"\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4"+
		"\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc"+
		"\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4"+
		"\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec"+
		"\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104"+
		"\u0106\u0108\u010a\u010c\u010e\u0110\u0112\u0114\u0116\u0118\u011a\u011c"+
		"\u011e\u0120\u0122\u0124\u0126\u0128\u012a\u012c\u012e\u0130\u0132\u0134"+
		"\2\t\4\2[[cc\4\2;;@@\3\2&\'\3\2\35\36\5\2\31\31\34\34##\4\2\30\30\35\36"+
		"\5\2))>>\\\\\u064a\2\u0139\3\2\2\2\4\u0174\3\2\2\2\6\u0176\3\2\2\2\b\u0179"+
		"\3\2\2\2\n\u0186\3\2\2\2\f\u018e\3\2\2\2\16\u0191\3\2\2\2\20\u01a2\3\2"+
		"\2\2\22\u01ac\3\2\2\2\24\u01ce\3\2\2\2\26\u01d0\3\2\2\2\30\u01d3\3\2\2"+
		"\2\32\u01d8\3\2\2\2\34\u01da\3\2\2\2\36\u01e7\3\2\2\2 \u01fb\3\2\2\2\""+
		"\u01fe\3\2\2\2$\u0203\3\2\2\2&\u0207\3\2\2\2(\u0214\3\2\2\2*\u021f\3\2"+
		"\2\2,\u0231\3\2\2\2.\u023e\3\2\2\2\60\u0243\3\2\2\2\62\u0245\3\2\2\2\64"+
		"\u024a\3\2\2\2\66\u0256\3\2\2\28\u025e\3\2\2\2:\u0262\3\2\2\2<\u0264\3"+
		"\2\2\2>\u028a\3\2\2\2@\u028c\3\2\2\2B\u028f\3\2\2\2D\u029b\3\2\2\2F\u02a7"+
		"\3\2\2\2H\u02b3\3\2\2\2J\u02bf\3\2\2\2L\u02cb\3\2\2\2N\u02df\3\2\2\2P"+
		"\u02ed\3\2\2\2R\u02fa\3\2\2\2T\u0302\3\2\2\2V\u0304\3\2\2\2X\u031a\3\2"+
		"\2\2Z\u031e\3\2\2\2\\\u0326\3\2\2\2^\u0331\3\2\2\2`\u0348\3\2\2\2b\u0354"+
		"\3\2\2\2d\u0359\3\2\2\2f\u035b\3\2\2\2h\u036c\3\2\2\2j\u036e\3\2\2\2l"+
		"\u0371\3\2\2\2n\u037b\3\2\2\2p\u0383\3\2\2\2r\u038e\3\2\2\2t\u0390\3\2"+
		"\2\2v\u0392\3\2\2\2x\u0394\3\2\2\2z\u03a0\3\2\2\2|\u03a2\3\2\2\2~\u03a5"+
		"\3\2\2\2\u0080\u03a8\3\2\2\2\u0082\u03ac\3\2\2\2\u0084\u03ae\3\2\2\2\u0086"+
		"\u03b0\3\2\2\2\u0088\u03b2\3\2\2\2\u008a\u03b4\3\2\2\2\u008c\u03b7\3\2"+
		"\2\2\u008e\u03be\3\2\2\2\u0090\u03c0\3\2\2\2\u0092\u03c6\3\2\2\2\u0094"+
		"\u03cd\3\2\2\2\u0096\u03d4\3\2\2\2\u0098\u03d7\3\2\2\2\u009a\u03e2\3\2"+
		"\2\2\u009c\u03e5\3\2\2\2\u009e\u03f0\3\2\2\2\u00a0\u03fb\3\2\2\2\u00a2"+
		"\u03fd\3\2\2\2\u00a4\u0403\3\2\2\2\u00a6\u041e\3\2\2\2\u00a8\u0420\3\2"+
		"\2\2\u00aa\u0423\3\2\2\2\u00ac\u042f\3\2\2\2\u00ae\u0437\3\2\2\2\u00b0"+
		"\u043b\3\2\2\2\u00b2\u0443\3\2\2\2\u00b4\u044b\3\2\2\2\u00b6\u045d\3\2"+
		"\2\2\u00b8\u0468\3\2\2\2\u00ba\u0473\3\2\2\2\u00bc\u0477\3\2\2\2\u00be"+
		"\u0481\3\2\2\2\u00c0\u048a\3\2\2\2\u00c2\u048c\3\2\2\2\u00c4\u049b\3\2"+
		"\2\2\u00c6\u04a1\3\2\2\2\u00c8\u04b5\3\2\2\2\u00ca\u04bc\3\2\2\2\u00cc"+
		"\u04be\3\2\2\2\u00ce\u04c4\3\2\2\2\u00d0\u04d1\3\2\2\2\u00d2\u04d7\3\2"+
		"\2\2\u00d4\u04dd\3\2\2\2\u00d6\u04f5\3\2\2\2\u00d8\u04f7\3\2\2\2\u00da"+
		"\u04ff\3\2\2\2\u00dc\u0502\3\2\2\2\u00de\u0509\3\2\2\2\u00e0\u050b\3\2"+
		"\2\2\u00e2\u0512\3\2\2\2\u00e4\u0514\3\2\2\2\u00e6\u0519\3\2\2\2\u00e8"+
		"\u051e\3\2\2\2\u00ea\u052e\3\2\2\2\u00ec\u0530\3\2\2\2\u00ee\u0536\3\2"+
		"\2\2\u00f0\u0549\3\2\2\2\u00f2\u054b\3\2\2\2\u00f4\u054e\3\2\2\2\u00f6"+
		"\u0551\3\2\2\2\u00f8\u055e\3\2\2\2\u00fa\u0560\3\2\2\2\u00fc\u0564\3\2"+
		"\2\2\u00fe\u0569\3\2\2\2\u0100\u0571\3\2\2\2\u0102\u057a\3\2\2\2\u0104"+
		"\u0580\3\2\2\2\u0106\u0595\3\2\2\2\u0108\u0597\3\2\2\2\u010a\u059d\3\2"+
		"\2\2\u010c\u059f\3\2\2\2\u010e\u05a6\3\2\2\2\u0110\u05aa\3\2\2\2\u0112"+
		"\u05ae\3\2\2\2\u0114\u05b2\3\2\2\2\u0116\u05b5\3\2\2\2\u0118\u05c2\3\2"+
		"\2\2\u011a\u05c5\3\2\2\2\u011c\u05c8\3\2\2\2\u011e\u05d8\3\2\2\2\u0120"+
		"\u05da\3\2\2\2\u0122\u05e4\3\2\2\2\u0124\u05f1\3\2\2\2\u0126\u05f4\3\2"+
		"\2\2\u0128\u05f9\3\2\2\2\u012a\u0606\3\2\2\2\u012c\u0611\3\2\2\2\u012e"+
		"\u0617\3\2\2\2\u0130\u062c\3\2\2\2\u0132\u062e\3\2\2\2\u0134\u0633\3\2"+
		"\2\2\u0136\u0138\5\u00e0q\2\u0137\u0136\3\2\2\2\u0138\u013b\3\2\2\2\u0139"+
		"\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013f\3\2\2\2\u013b\u0139\3\2"+
		"\2\2\u013c\u013d\5\4\3\2\u013d\u013e\b\2\1\2\u013e\u0140\3\2\2\2\u013f"+
		"\u013c\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2"+
		"\2\2\u0142\u0143\3\2\2\2\u0143\u0144\b\2\1\2\u0144\3\3\2\2\2\u0145\u0146"+
		"\5X-\2\u0146\u0147\7\17\2\2\u0147\u0148\b\3\1\2\u0148\u0175\3\2\2\2\u0149"+
		"\u014a\5<\37\2\u014a\u014b\7\17\2\2\u014b\u014c\b\3\1\2\u014c\u0175\3"+
		"\2\2\2\u014d\u014e\5\u00c2b\2\u014e\u014f\7\17\2\2\u014f\u0150\b\3\1\2"+
		"\u0150\u0175\3\2\2\2\u0151\u0152\5\f\7\2\u0152\u0153\7\17\2\2\u0153\u0154"+
		"\b\3\1\2\u0154\u0175\3\2\2\2\u0155\u0156\5\b\5\2\u0156\u0157\7\17\2\2"+
		"\u0157\u0158\b\3\1\2\u0158\u0175\3\2\2\2\u0159\u015a\5 \21\2\u015a\u015b"+
		"\7\17\2\2\u015b\u0175\3\2\2\2\u015c\u015d\5\u00e4s\2\u015d\u015e\7\17"+
		"\2\2\u015e\u0175\3\2\2\2\u015f\u0160\5\u00e6t\2\u0160\u0161\7\17\2\2\u0161"+
		"\u0175\3\2\2\2\u0162\u0163\5\u0124\u0093\2\u0163\u0164\7\17\2\2\u0164"+
		"\u0175\3\2\2\2\u0165\u0166\5\u00f8}\2\u0166\u0167\7\17\2\2\u0167\u0175"+
		"\3\2\2\2\u0168\u0169\5\u0114\u008b\2\u0169\u016a\7\17\2\2\u016a\u0175"+
		"\3\2\2\2\u016b\u016c\5\u008eH\2\u016c\u016d\7\17\2\2\u016d\u016e\b\3\1"+
		"\2\u016e\u0175\3\2\2\2\u016f\u0170\5\u012e\u0098\2\u0170\u0171\b\3\1\2"+
		"\u0171\u0172\5\6\4\2\u0172\u0173\b\3\1\2\u0173\u0175\3\2\2\2\u0174\u0145"+
		"\3\2\2\2\u0174\u0149\3\2\2\2\u0174\u014d\3\2\2\2\u0174\u0151\3\2\2\2\u0174"+
		"\u0155\3\2\2\2\u0174\u0159\3\2\2\2\u0174\u015c\3\2\2\2\u0174\u015f\3\2"+
		"\2\2\u0174\u0162\3\2\2\2\u0174\u0165\3\2\2\2\u0174\u0168\3\2\2\2\u0174"+
		"\u016b\3\2\2\2\u0174\u016f\3\2\2\2\u0175\5\3\2\2\2\u0176\u0177\5\4\3\2"+
		"\u0177\u0178\b\4\1\2\u0178\7\3\2\2\2\u0179\u017a\7N\2\2\u017a\u017b\b"+
		"\5\1\2\u017b\u017c\5\u0134\u009b\2\u017c\u017d\b\5\1\2\u017d\u017e\7\22"+
		"\2\2\u017e\u017f\5\n\6\2\u017f\u0180\b\5\1\2\u0180\u0181\7\23\2\2\u0181"+
		"\u0182\b\5\1\2\u0182\t\3\2\2\2\u0183\u0184\5\4\3\2\u0184\u0185\b\6\1\2"+
		"\u0185\u0187\3\2\2\2\u0186\u0183\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0186"+
		"\3\2\2\2\u0188\u0189\3\2\2\2\u0189\13\3\2\2\2\u018a\u018b\5\16\b\2\u018b"+
		"\u018c\b\7\1\2\u018c\u018f\3\2\2\2\u018d\u018f\5\20\t\2\u018e\u018a\3"+
		"\2\2\2\u018e\u018d\3\2\2\2\u018f\r\3\2\2\2\u0190\u0192\t\2\2\2\u0191\u0190"+
		"\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0194\7e\2\2\u0194"+
		"\u0195\b\b\1\2\u0195\u0196\5\u0134\u009b\2\u0196\u0198\b\b\1\2\u0197\u0199"+
		"\5\30\r\2\u0198\u0197\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019a\3\2\2\2"+
		"\u019a\u019b\7\22\2\2\u019b\u019c\5\22\n\2\u019c\u019d\b\b\1\2\u019d\u019e"+
		"\7\23\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\b\b\1\2\u01a0\17\3\2\2\2\u01a1"+
		"\u01a3\t\2\2\2\u01a2\u01a1\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a4\3\2"+
		"\2\2\u01a4\u01a5\7e\2\2\u01a5\u01a6\7h\2\2\u01a6\21\3\2\2\2\u01a7\u01a8"+
		"\5\24\13\2\u01a8\u01a9\b\n\1\2\u01a9\u01ab\3\2\2\2\u01aa\u01a7\3\2\2\2"+
		"\u01ab\u01ae\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\23"+
		"\3\2\2\2\u01ae\u01ac\3\2\2\2\u01af\u01b0\5X-\2\u01b0\u01b1\7\17\2\2\u01b1"+
		"\u01b2\b\13\1\2\u01b2\u01cf\3\2\2\2\u01b3\u01b4\5<\37\2\u01b4\u01b5\7"+
		"\17\2\2\u01b5\u01b6\b\13\1\2\u01b6\u01cf\3\2\2\2\u01b7\u01b8\5\u00c2b"+
		"\2\u01b8\u01b9\7\17\2\2\u01b9\u01ba\b\13\1\2\u01ba\u01cf\3\2\2\2\u01bb"+
		"\u01bc\5\u00c0a\2\u01bc\u01bd\7\17\2\2\u01bd\u01be\b\13\1\2\u01be\u01cf"+
		"\3\2\2\2\u01bf\u01c0\5\u00c6d\2\u01c0\u01c1\7\17\2\2\u01c1\u01c2\b\13"+
		"\1\2\u01c2\u01cf\3\2\2\2\u01c3\u01c4\5\u00e4s\2\u01c4\u01c5\7\17\2\2\u01c5"+
		"\u01cf\3\2\2\2\u01c6\u01c7\5\u00e6t\2\u01c7\u01c8\7\17\2\2\u01c8\u01cf"+
		"\3\2\2\2\u01c9\u01ca\5\u012e\u0098\2\u01ca\u01cb\b\13\1\2\u01cb\u01cc"+
		"\5\26\f\2\u01cc\u01cd\b\13\1\2\u01cd\u01cf\3\2\2\2\u01ce\u01af\3\2\2\2"+
		"\u01ce\u01b3\3\2\2\2\u01ce\u01b7\3\2\2\2\u01ce\u01bb\3\2\2\2\u01ce\u01bf"+
		"\3\2\2\2\u01ce\u01c3\3\2\2\2\u01ce\u01c6\3\2\2\2\u01ce\u01c9\3\2\2\2\u01cf"+
		"\25\3\2\2\2\u01d0\u01d1\5\24\13\2\u01d1\u01d2\b\f\1\2\u01d2\27\3\2\2\2"+
		"\u01d3\u01d4\7\20\2\2\u01d4\u01d5\5\34\17\2\u01d5\u01d6\b\r\1\2\u01d6"+
		"\u01d7\b\r\1\2\u01d7\31\3\2\2\2\u01d8\u01d9\5\36\20\2\u01d9\33\3\2\2\2"+
		"\u01da\u01db\5\36\20\2\u01db\u01e2\b\17\1\2\u01dc\u01dd\7\21\2\2\u01dd"+
		"\u01de\5\36\20\2\u01de\u01df\b\17\1\2\u01df\u01e1\3\2\2\2\u01e0\u01dc"+
		"\3\2\2\2\u01e1\u01e4\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3"+
		"\35\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e5\u01e6\b\20\1\2\u01e6\u01e8\7%\2"+
		"\2\u01e7\u01e5\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ea"+
		"\b\20\1\2\u01ea\u01f2\7h\2\2\u01eb\u01ec\b\20\1\2\u01ec\u01ed\7%\2\2\u01ed"+
		"\u01ee\5\u0134\u009b\2\u01ee\u01ef\b\20\1\2\u01ef\u01f1\3\2\2\2\u01f0"+
		"\u01eb\3\2\2\2\u01f1\u01f4\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2"+
		"\2\2\u01f3\u01f5\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f5\u01f6\b\20\1\2\u01f6"+
		"\37\3\2\2\2\u01f7\u01fc\5(\25\2\u01f8\u01fc\5&\24\2\u01f9\u01fc\5$\23"+
		"\2\u01fa\u01fc\5\"\22\2\u01fb\u01f7\3\2\2\2\u01fb\u01f8\3\2\2\2\u01fb"+
		"\u01f9\3\2\2\2\u01fb\u01fa\3\2\2\2\u01fc!\3\2\2\2\u01fd\u01ff\7[\2\2\u01fe"+
		"\u01fd\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0201\7L"+
		"\2\2\u0201\u0202\7h\2\2\u0202#\3\2\2\2\u0203\u0204\7L\2\2\u0204\u0205"+
		"\7h\2\2\u0205\u0206\5\\/\2\u0206%\3\2\2\2\u0207\u0208\7[\2\2\u0208\u0209"+
		"\7L\2\2\u0209\u020a\7h\2\2\u020a\u020b\5,\27\2\u020b\u020f\7\22\2\2\u020c"+
		"\u020e\5\24\13\2\u020d\u020c\3\2\2\2\u020e\u0211\3\2\2\2\u020f\u020d\3"+
		"\2\2\2\u020f\u0210\3\2\2\2\u0210\u0212\3\2\2\2\u0211\u020f\3\2\2\2\u0212"+
		"\u0213\7\23\2\2\u0213\'\3\2\2\2\u0214\u0215\5*\26\2\u0215\u0219\7\22\2"+
		"\2\u0216\u0218\5\60\31\2\u0217\u0216\3\2\2\2\u0218\u021b\3\2\2\2\u0219"+
		"\u0217\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021c\3\2\2\2\u021b\u0219\3\2"+
		"\2\2\u021c\u021d\7\23\2\2\u021d)\3\2\2\2\u021e\u0220\7\61\2\2\u021f\u021e"+
		"\3\2\2\2\u021f\u0220\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0222\7L\2\2\u0222"+
		"\u0223\7h\2\2\u0223\u0224\5,\27\2\u0224+\3\2\2\2\u0225\u0227\7\20\2\2"+
		"\u0226\u0228\7P\2\2\u0227\u0226\3\2\2\2\u0227\u0228\3\2\2\2\u0228\u0229"+
		"\3\2\2\2\u0229\u022e\5.\30\2\u022a\u022b\7\21\2\2\u022b\u022d\5.\30\2"+
		"\u022c\u022a\3\2\2\2\u022d\u0230\3\2\2\2\u022e\u022c\3\2\2\2\u022e\u022f"+
		"\3\2\2\2\u022f\u0232\3\2\2\2\u0230\u022e\3\2\2\2\u0231\u0225\3\2\2\2\u0231"+
		"\u0232\3\2\2\2\u0232\u023c\3\2\2\2\u0233\u0234\7M\2\2\u0234\u0239\5\32"+
		"\16\2\u0235\u0236\7\21\2\2\u0236\u0238\5\32\16\2\u0237\u0235\3\2\2\2\u0238"+
		"\u023b\3\2\2\2\u0239\u0237\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u023d\3\2"+
		"\2\2\u023b\u0239\3\2\2\2\u023c\u0233\3\2\2\2\u023c\u023d\3\2\2\2\u023d"+
		"-\3\2\2\2\u023e\u023f\5\36\20\2\u023f/\3\2\2\2\u0240\u0244\5\24\13\2\u0241"+
		"\u0244\5\62\32\2\u0242\u0244\5\64\33\2\u0243\u0240\3\2\2\2\u0243\u0241"+
		"\3\2\2\2\u0243\u0242\3\2\2\2\u0244\61\3\2\2\2\u0245\u0246\t\3\2\2\u0246"+
		"\u0247\5\\/\2\u0247\u0248\5f\64\2\u0248\u0249\7\17\2\2\u0249\63\3\2\2"+
		"\2\u024a\u024b\7G\2\2\u024b\u024c\7h\2\2\u024c\u024e\7\24\2\2\u024d\u024f"+
		"\5\66\34\2\u024e\u024d\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0250\3\2\2\2"+
		"\u0250\u0252\7\25\2\2\u0251\u0253\5\u00d2j\2\u0252\u0251\3\2\2\2\u0252"+
		"\u0253\3\2\2\2\u0253\u0254\3\2\2\2\u0254\u0255\7\17\2\2\u0255\65\3\2\2"+
		"\2\u0256\u025b\58\35\2\u0257\u0258\7\21\2\2\u0258\u025a\58\35\2\u0259"+
		"\u0257\3\2\2\2\u025a\u025d\3\2\2\2\u025b\u0259\3\2\2\2\u025b\u025c\3\2"+
		"\2\2\u025c\67\3\2\2\2\u025d\u025b\3\2\2\2\u025e\u025f\5:\36\2\u025f\u0260"+
		"\5\u00d6l\2\u0260\u0261\5j\66\2\u02619\3\2\2\2\u0262\u0263\7>\2\2\u0263"+
		";\3\2\2\2\u0264\u0265\7J\2\2\u0265\u0266\5> \2\u0266\u0267\b\37\1\2\u0267"+
		"\u0268\5\u0134\u009b\2\u0268\u0269\b\37\1\2\u0269\u026a\7\"\2\2\u026a"+
		"\u026b\5@!\2\u026b\u026c\b\37\1\2\u026c\u026d\b\37\1\2\u026d=\3\2\2\2"+
		"\u026e\u026f\5p9\2\u026f\u0270\b \1\2\u0270\u028b\3\2\2\2\u0271\u0272"+
		"\5\u0082B\2\u0272\u0273\b \1\2\u0273\u028b\3\2\2\2\u0274\u0275\5\u0084"+
		"C\2\u0275\u0276\b \1\2\u0276\u028b\3\2\2\2\u0277\u0278\5\u0086D\2\u0278"+
		"\u0279\b \1\2\u0279\u028b\3\2\2\2\u027a\u027b\5n8\2\u027b\u027c\b \1\2"+
		"\u027c\u028b\3\2\2\2\u027d\u027e\5\u00b8]\2\u027e\u027f\b \1\2\u027f\u028b"+
		"\3\2\2\2\u0280\u0281\5\u00ba^\2\u0281\u0282\b \1\2\u0282\u028b\3\2\2\2"+
		"\u0283\u028b\5\u00dan\2\u0284\u0285\5\36\20\2\u0285\u0286\b \1\2\u0286"+
		"\u028b\3\2\2\2\u0287\u0288\5\u0088E\2\u0288\u0289\b \1\2\u0289\u028b\3"+
		"\2\2\2\u028a\u026e\3\2\2\2\u028a\u0271\3\2\2\2\u028a\u0274\3\2\2\2\u028a"+
		"\u0277\3\2\2\2\u028a\u027a\3\2\2\2\u028a\u027d\3\2\2\2\u028a\u0280\3\2"+
		"\2\2\u028a\u0283\3\2\2\2\u028a\u0284\3\2\2\2\u028a\u0287\3\2\2\2\u028b"+
		"?\3\2\2\2\u028c\u028d\5B\"\2\u028d\u028e\b!\1\2\u028eA\3\2\2\2\u028f\u0290"+
		"\5D#\2\u0290\u0298\b\"\1\2\u0291\u0292\b\"\1\2\u0292\u0293\7!\2\2\u0293"+
		"\u0294\5D#\2\u0294\u0295\b\"\1\2\u0295\u0297\3\2\2\2\u0296\u0291\3\2\2"+
		"\2\u0297\u029a\3\2\2\2\u0298\u0296\3\2\2\2\u0298\u0299\3\2\2\2\u0299C"+
		"\3\2\2\2\u029a\u0298\3\2\2\2\u029b\u029c\5F$\2\u029c\u02a4\b#\1\2\u029d"+
		"\u029e\b#\1\2\u029e\u029f\7\37\2\2\u029f\u02a0\5F$\2\u02a0\u02a1\b#\1"+
		"\2\u02a1\u02a3\3\2\2\2\u02a2\u029d\3\2\2\2\u02a3\u02a6\3\2\2\2\u02a4\u02a2"+
		"\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5E\3\2\2\2\u02a6\u02a4\3\2\2\2\u02a7"+
		"\u02a8\5H%\2\u02a8\u02b0\b$\1\2\u02a9\u02aa\b$\1\2\u02aa\u02ab\7 \2\2"+
		"\u02ab\u02ac\5H%\2\u02ac\u02ad\b$\1\2\u02ad\u02af\3\2\2\2\u02ae\u02a9"+
		"\3\2\2\2\u02af\u02b2\3\2\2\2\u02b0\u02ae\3\2\2\2\u02b0\u02b1\3\2\2\2\u02b1"+
		"G\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b3\u02b4\5J&\2\u02b4\u02bc\b%\1\2\u02b5"+
		"\u02b6\b%\1\2\u02b6\u02b7\t\4\2\2\u02b7\u02b8\5J&\2\u02b8\u02b9\b%\1\2"+
		"\u02b9\u02bb\3\2\2\2\u02ba\u02b5\3\2\2\2\u02bb\u02be\3\2\2\2\u02bc\u02ba"+
		"\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bdI\3\2\2\2\u02be\u02bc\3\2\2\2\u02bf"+
		"\u02c0\5L\'\2\u02c0\u02c8\b&\1\2\u02c1\u02c2\b&\1\2\u02c2\u02c3\t\5\2"+
		"\2\u02c3\u02c4\5L\'\2\u02c4\u02c5\b&\1\2\u02c5\u02c7\3\2\2\2\u02c6\u02c1"+
		"\3\2\2\2\u02c7\u02ca\3\2\2\2\u02c8\u02c6\3\2\2\2\u02c8\u02c9\3\2\2\2\u02c9"+
		"K\3\2\2\2\u02ca\u02c8\3\2\2\2\u02cb\u02cc\5N(\2\u02cc\u02d4\b\'\1\2\u02cd"+
		"\u02ce\b\'\1\2\u02ce\u02cf\t\6\2\2\u02cf\u02d0\5N(\2\u02d0\u02d1\b\'\1"+
		"\2\u02d1\u02d3\3\2\2\2\u02d2\u02cd\3\2\2\2\u02d3\u02d6\3\2\2\2\u02d4\u02d2"+
		"\3\2\2\2\u02d4\u02d5\3\2\2\2\u02d5M\3\2\2\2\u02d6\u02d4\3\2\2\2\u02d7"+
		"\u02d8\b(\1\2\u02d8\u02d9\t\7\2\2\u02d9\u02da\5P)\2\u02da\u02db\b(\1\2"+
		"\u02db\u02e0\3\2\2\2\u02dc\u02dd\5P)\2\u02dd\u02de\b(\1\2\u02de\u02e0"+
		"\3\2\2\2\u02df\u02d7\3\2\2\2\u02df\u02dc\3\2\2\2\u02e0O\3\2\2\2\u02e1"+
		"\u02e2\5\36\20\2\u02e2\u02e3\b)\1\2\u02e3\u02ee\3\2\2\2\u02e4\u02e5\5"+
		"R*\2\u02e5\u02e6\b)\1\2\u02e6\u02ee\3\2\2\2\u02e7\u02e8\b)\1\2\u02e8\u02e9"+
		"\7\24\2\2\u02e9\u02ea\5@!\2\u02ea\u02eb\b)\1\2\u02eb\u02ec\7\25\2\2\u02ec"+
		"\u02ee\3\2\2\2\u02ed\u02e1\3\2\2\2\u02ed\u02e4\3\2\2\2\u02ed\u02e7\3\2"+
		"\2\2\u02eeQ\3\2\2\2\u02ef\u02fb\7\7\2\2\u02f0\u02fb\7\5\2\2\u02f1\u02fb"+
		"\7\r\2\2\u02f2\u02fb\7\f\2\2\u02f3\u02fb\7\13\2\2\u02f4\u02fb\7\n\2\2"+
		"\u02f5\u02fb\7\t\2\2\u02f6\u02fb\7\b\2\2\u02f7\u02f8\5T+\2\u02f8\u02f9"+
		"\b*\1\2\u02f9\u02fb\3\2\2\2\u02fa\u02ef\3\2\2\2\u02fa\u02f0\3\2\2\2\u02fa"+
		"\u02f1\3\2\2\2\u02fa\u02f2\3\2\2\2\u02fa\u02f3\3\2\2\2\u02fa\u02f4\3\2"+
		"\2\2\u02fa\u02f5\3\2\2\2\u02fa\u02f6\3\2\2\2\u02fa\u02f7\3\2\2\2\u02fb"+
		"\u02fc\3\2\2\2\u02fc\u02fd\b*\1\2\u02fdS\3\2\2\2\u02fe\u02ff\7\4\2\2\u02ff"+
		"\u0303\b+\1\2\u0300\u0301\7\3\2\2\u0301\u0303\b+\1\2\u0302\u02fe\3\2\2"+
		"\2\u0302\u0300\3\2\2\2\u0303U\3\2\2\2\u0304\u0305\5@!\2\u0305\u0306\b"+
		",\1\2\u0306\u0307\b,\1\2\u0307W\3\2\2\2\u0308\u0309\7.\2\2\u0309\u030a"+
		"\b-\1\2\u030a\u030b\5Z.\2\u030b\u030c\b-\1\2\u030c\u031b\3\2\2\2\u030d"+
		"\u030e\5\u009cO\2\u030e\u030f\b-\1\2\u030f\u031b\3\2\2\2\u0310\u0311\5"+
		"\u00a4S\2\u0311\u0312\b-\1\2\u0312\u031b\3\2\2\2\u0313\u0314\5\u00b0Y"+
		"\2\u0314\u0315\b-\1\2\u0315\u031b\3\2\2\2\u0316\u0317\7\66\2\2\u0317\u0318"+
		"\b-\1\2\u0318\u031b\5j\66\2\u0319\u031b\5\u00dep\2\u031a\u0308\3\2\2\2"+
		"\u031a\u030d\3\2\2\2\u031a\u0310\3\2\2\2\u031a\u0313\3\2\2\2\u031a\u0316"+
		"\3\2\2\2\u031a\u0319\3\2\2\2\u031b\u031c\3\2\2\2\u031c\u031d\b-\1\2\u031d"+
		"Y\3\2\2\2\u031e\u031f\5\\/\2\u031f\u0320\5f\64\2\u0320\u0321\b.\1\2\u0321"+
		"[\3\2\2\2\u0322\u0323\5^\60\2\u0323\u0324\b/\1\2\u0324\u0327\3\2\2\2\u0325"+
		"\u0327\5d\63\2\u0326\u0322\3\2\2\2\u0326\u0325\3\2\2\2\u0327]\3\2\2\2"+
		"\u0328\u0329\5`\61\2\u0329\u032a\b\60\1\2\u032a\u0332\3\2\2\2\u032b\u032c"+
		"\5b\62\2\u032c\u032d\b\60\1\2\u032d\u0332\3\2\2\2\u032e\u032f\5\36\20"+
		"\2\u032f\u0330\b\60\1\2\u0330\u0332\3\2\2\2\u0331\u0328\3\2\2\2\u0331"+
		"\u032b\3\2\2\2\u0331\u032e\3\2\2\2\u0332_\3\2\2\2\u0333\u0334\5n8\2\u0334"+
		"\u0335\b\61\1\2\u0335\u0349\3\2\2\2\u0336\u0337\5p9\2\u0337\u0338\b\61"+
		"\1\2\u0338\u0349\3\2\2\2\u0339\u033a\5\u0082B\2\u033a\u033b\b\61\1\2\u033b"+
		"\u0349\3\2\2\2\u033c\u033d\5\u0084C\2\u033d\u033e\b\61\1\2\u033e\u0349"+
		"\3\2\2\2\u033f\u0340\5\u0086D\2\u0340\u0341\b\61\1\2\u0341\u0349\3\2\2"+
		"\2\u0342\u0343\5\u0088E\2\u0343\u0344\b\61\1\2\u0344\u0349\3\2\2\2\u0345"+
		"\u0349\5\u008aF\2\u0346\u0349\5\u008cG\2\u0347\u0349\5\u00dco\2\u0348"+
		"\u0333\3\2\2\2\u0348\u0336\3\2\2\2\u0348\u0339\3\2\2\2\u0348\u033c\3\2"+
		"\2\2\u0348\u033f\3\2\2\2\u0348\u0342\3\2\2\2\u0348\u0345\3\2\2\2\u0348"+
		"\u0346\3\2\2\2\u0348\u0347\3\2\2\2\u0349a\3\2\2\2\u034a\u034b\5\u00b6"+
		"\\\2\u034b\u034c\b\62\1\2\u034c\u0355\3\2\2\2\u034d\u034e\5\u00b8]\2\u034e"+
		"\u034f\b\62\1\2\u034f\u0355\3\2\2\2\u0350\u0351\5\u00ba^\2\u0351\u0352"+
		"\b\62\1\2\u0352\u0355\3\2\2\2\u0353\u0355\5\u00d8m\2\u0354\u034a\3\2\2"+
		"\2\u0354\u034d\3\2\2\2\u0354\u0350\3\2\2\2\u0354\u0353\3\2\2\2\u0355c"+
		"\3\2\2\2\u0356\u035a\5\u009cO\2\u0357\u035a\5\u00a4S\2\u0358\u035a\5\u00b0"+
		"Y\2\u0359\u0356\3\2\2\2\u0359\u0357\3\2\2\2\u0359\u0358\3\2\2\2\u035a"+
		"e\3\2\2\2\u035b\u035c\5h\65\2\u035c\u0363\b\64\1\2\u035d\u035e\7\21\2"+
		"\2\u035e\u035f\5h\65\2\u035f\u0360\b\64\1\2\u0360\u0362\3\2\2\2\u0361"+
		"\u035d\3\2\2\2\u0362\u0365\3\2\2\2\u0363\u0361\3\2\2\2\u0363\u0364\3\2"+
		"\2\2\u0364g\3\2\2\2\u0365\u0363\3\2\2\2\u0366\u0367\5j\66\2\u0367\u0368"+
		"\b\65\1\2\u0368\u036d\3\2\2\2\u0369\u036a\5l\67\2\u036a\u036b\b\65\1\2"+
		"\u036b\u036d\3\2\2\2\u036c\u0366\3\2\2\2\u036c\u0369\3\2\2\2\u036di\3"+
		"\2\2\2\u036e\u036f\5\u0134\u009b\2\u036f\u0370\b\66\1\2\u0370k\3\2\2\2"+
		"\u0371\u0372\5\u00bc_\2\u0372\u0373\b\67\1\2\u0373m\3\2\2\2\u0374\u0375"+
		"\7X\2\2\u0375\u037c\b8\1\2\u0376\u0377\7_\2\2\u0377\u037c\b8\1\2\u0378"+
		"\u0379\7B\2\2\u0379\u037a\7_\2\2\u037a\u037c\b8\1\2\u037b\u0374\3\2\2"+
		"\2\u037b\u0376\3\2\2\2\u037b\u0378\3\2\2\2\u037co\3\2\2\2\u037d\u037e"+
		"\5r:\2\u037e\u037f\b9\1\2\u037f\u0384\3\2\2\2\u0380\u0381\5z>\2\u0381"+
		"\u0382\b9\1\2\u0382\u0384\3\2\2\2\u0383\u037d\3\2\2\2\u0383\u0380\3\2"+
		"\2\2\u0384q\3\2\2\2\u0385\u0386\5t;\2\u0386\u0387\b:\1\2\u0387\u038f\3"+
		"\2\2\2\u0388\u0389\5v<\2\u0389\u038a\b:\1\2\u038a\u038f\3\2\2\2\u038b"+
		"\u038c\5x=\2\u038c\u038d\b:\1\2\u038d\u038f\3\2\2\2\u038e\u0385\3\2\2"+
		"\2\u038e\u0388\3\2\2\2\u038e\u038b\3\2\2\2\u038fs\3\2\2\2\u0390\u0391"+
		"\7A\2\2\u0391u\3\2\2\2\u0392\u0393\7B\2\2\u0393w\3\2\2\2\u0394\u0395\7"+
		"B\2\2\u0395\u0396\7B\2\2\u0396y\3\2\2\2\u0397\u0398\5|?\2\u0398\u0399"+
		"\b>\1\2\u0399\u03a1\3\2\2\2\u039a\u039b\5~@\2\u039b\u039c\b>\1\2\u039c"+
		"\u03a1\3\2\2\2\u039d\u039e\5\u0080A\2\u039e\u039f\b>\1\2\u039f\u03a1\3"+
		"\2\2\2\u03a0\u0397\3\2\2\2\u03a0\u039a\3\2\2\2\u03a0\u039d\3\2\2\2\u03a1"+
		"{\3\2\2\2\u03a2\u03a3\7Q\2\2\u03a3\u03a4\7A\2\2\u03a4}\3\2\2\2\u03a5\u03a6"+
		"\7Q\2\2\u03a6\u03a7\7B\2\2\u03a7\177\3\2\2\2\u03a8\u03a9\7Q\2\2\u03a9"+
		"\u03aa\7B\2\2\u03aa\u03ab\7B\2\2\u03ab\u0081\3\2\2\2\u03ac\u03ad\7V\2"+
		"\2\u03ad\u0083\3\2\2\2\u03ae\u03af\7=\2\2\u03af\u0085\3\2\2\2\u03b0\u03b1"+
		"\7Y\2\2\u03b1\u0087\3\2\2\2\u03b2\u03b3\7\62\2\2\u03b3\u0089\3\2\2\2\u03b4"+
		"\u03b5\7U\2\2\u03b5\u03b6\bF\1\2\u03b6\u008b\3\2\2\2\u03b7\u03b8\7O\2"+
		"\2\u03b8\u03b9\bG\1\2\u03b9\u008d\3\2\2\2\u03ba\u03bb\5\u0090I\2\u03bb"+
		"\u03bc\bH\1\2\u03bc\u03bf\3\2\2\2\u03bd\u03bf\5\u009aN\2\u03be\u03ba\3"+
		"\2\2\2\u03be\u03bd\3\2\2\2\u03bf\u008f\3\2\2\2\u03c0\u03c1\5\u0092J\2"+
		"\u03c1\u03c2\7\22\2\2\u03c2\u03c3\5\u0096L\2\u03c3\u03c4\7\23\2\2\u03c4"+
		"\u03c5\bI\1\2\u03c5\u0091\3\2\2\2\u03c6\u03c7\7g\2\2\u03c7\u03c8\bJ\1"+
		"\2\u03c8\u03c9\5\u0134\u009b\2\u03c9\u03cb\bJ\1\2\u03ca\u03cc\5\u0094"+
		"K\2\u03cb\u03ca\3\2\2\2\u03cb\u03cc\3\2\2\2\u03cc\u0093\3\2\2\2\u03cd"+
		"\u03ce\7\20\2\2\u03ce\u03cf\5\36\20\2\u03cf\u03d0\bK\1\2\u03d0\u0095\3"+
		"\2\2\2\u03d1\u03d3\5\u0098M\2\u03d2\u03d1\3\2\2\2\u03d3\u03d6\3\2\2\2"+
		"\u03d4\u03d2\3\2\2\2\u03d4\u03d5\3\2\2\2\u03d5\u0097\3\2\2\2\u03d6\u03d4"+
		"\3\2\2\2\u03d7\u03d8\5> \2\u03d8\u03dd\5j\66\2\u03d9\u03da\7?\2\2\u03da"+
		"\u03db\5@!\2\u03db\u03dc\bM\1\2\u03dc\u03de\3\2\2\2\u03dd\u03d9\3\2\2"+
		"\2\u03dd\u03de\3\2\2\2\u03de\u03df\3\2\2\2\u03df\u03e0\7\17\2\2\u03e0"+
		"\u03e1\bM\1\2\u03e1\u0099\3\2\2\2\u03e2\u03e3\7g\2\2\u03e3\u03e4\5\36"+
		"\20\2\u03e4\u009b\3\2\2\2\u03e5\u03e6\7\65\2\2\u03e6\u03e7\5\u0134\u009b"+
		"\2\u03e7\u03e8\bO\1\2\u03e8\u03e9\7\22\2\2\u03e9\u03ea\5\u009eP\2\u03ea"+
		"\u03eb\7\23\2\2\u03eb\u03ec\bO\1\2\u03ec\u009d\3\2\2\2\u03ed\u03ee\5\u00a0"+
		"Q\2\u03ee\u03ef\bP\1\2\u03ef\u03f1\3\2\2\2\u03f0\u03ed\3\2\2\2\u03f1\u03f2"+
		"\3\2\2\2\u03f2\u03f0\3\2\2\2\u03f2\u03f3\3\2\2\2\u03f3\u009f\3\2\2\2\u03f4"+
		"\u03f5\5\u00a2R\2\u03f5\u03f6\bQ\1\2\u03f6\u03fc\3\2\2\2\u03f7\u03f8\5"+
		"\u012e\u0098\2\u03f8\u03f9\5\u00a0Q\2\u03f9\u03fa\bQ\1\2\u03fa\u03fc\3"+
		"\2\2\2\u03fb\u03f4\3\2\2\2\u03fb\u03f7\3\2\2\2\u03fc\u00a1\3\2\2\2\u03fd"+
		"\u03fe\5\\/\2\u03fe\u03ff\bR\1\2\u03ff\u0400\5f\64\2\u0400\u0401\7\17"+
		"\2\2\u0401\u0402\bR\1\2\u0402\u00a3\3\2\2\2\u0403\u0404\7S\2\2\u0404\u0405"+
		"\5\u0134\u009b\2\u0405\u0406\bS\1\2\u0406\u0407\7,\2\2\u0407\u0408\7\24"+
		"\2\2\u0408\u0409\5\u00a6T\2\u0409\u040a\bS\1\2\u040a\u040b\7\25\2\2\u040b"+
		"\u040c\bS\1\2\u040c\u040d\7\22\2\2\u040d\u040e\5\u00a8U\2\u040e\u040f"+
		"\7\23\2\2\u040f\u0410\bS\1\2\u0410\u00a5\3\2\2\2\u0411\u0412\5p9\2\u0412"+
		"\u0413\bT\1\2\u0413\u041f\3\2\2\2\u0414\u0415\5\u0082B\2\u0415\u0416\b"+
		"T\1\2\u0416\u041f\3\2\2\2\u0417\u0418\5\u0086D\2\u0418\u0419\bT\1\2\u0419"+
		"\u041f\3\2\2\2\u041a\u041f\5\u00b0Y\2\u041b\u041c\5\36\20\2\u041c\u041d"+
		"\bT\1\2\u041d\u041f\3\2\2\2\u041e\u0411\3\2\2\2\u041e\u0414\3\2\2\2\u041e"+
		"\u0417\3\2\2\2\u041e\u041a\3\2\2\2\u041e\u041b\3\2\2\2\u041f\u00a7\3\2"+
		"\2\2\u0420\u0421\5\u00aaV\2\u0421\u00a9\3\2\2\2\u0422\u0424\5\u00acW\2"+
		"\u0423\u0422\3\2\2\2\u0424\u0425\3\2\2\2\u0425\u0423\3\2\2\2\u0425\u0426"+
		"\3\2\2\2\u0426\u00ab\3\2\2\2\u0427\u0428\7W\2\2\u0428\u0429\5@!\2\u0429"+
		"\u042a\bW\1\2\u042a\u042b\7\20\2\2\u042b\u0430\3\2\2\2\u042c\u042d\7?"+
		"\2\2\u042d\u042e\bW\1\2\u042e\u0430\7\20\2\2\u042f\u0427\3\2\2\2\u042f"+
		"\u042c\3\2\2\2\u0430\u0431\3\2\2\2\u0431\u042f\3\2\2\2\u0431\u0432\3\2"+
		"\2\2\u0432\u0433\3\2\2\2\u0433\u0434\5\u00aeX\2\u0434\u0435\7\17\2\2\u0435"+
		"\u0436\bW\1\2\u0436\u00ad\3\2\2\2\u0437\u0438\5\\/\2\u0438\u0439\5h\65"+
		"\2\u0439\u043a\bX\1\2\u043a\u00af\3\2\2\2\u043b\u043c\7C\2\2\u043c\u043d"+
		"\5\u0134\u009b\2\u043d\u043e\bY\1\2\u043e\u043f\7\22\2\2\u043f\u0440\5"+
		"\u00b2Z\2\u0440\u0441\7\23\2\2\u0441\u0442\bY\1\2\u0442\u00b1\3\2\2\2"+
		"\u0443\u0448\5\u00b4[\2\u0444\u0445\7\21\2\2\u0445\u0447\5\u00b4[\2\u0446"+
		"\u0444\3\2\2\2\u0447\u044a\3\2\2\2\u0448\u0446\3\2\2\2\u0448\u0449\3\2"+
		"\2\2\u0449\u00b3\3\2\2\2\u044a\u0448\3\2\2\2\u044b\u044c\5\u0134\u009b"+
		"\2\u044c\u044d\b[\1\2\u044d\u00b5\3\2\2\2\u044e\u044f\7\63\2\2\u044f\u0450"+
		"\7\32\2\2\u0450\u0451\5^\60\2\u0451\u0452\b\\\1\2\u0452\u0453\7\21\2\2"+
		"\u0453\u0454\5V,\2\u0454\u0455\b\\\1\2\u0455\u0456\7\33\2\2\u0456\u045e"+
		"\3\2\2\2\u0457\u0458\7\63\2\2\u0458\u0459\7\32\2\2\u0459\u045a\5^\60\2"+
		"\u045a\u045b\b\\\1\2\u045b\u045c\7\33\2\2\u045c\u045e\3\2\2\2\u045d\u044e"+
		"\3\2\2\2\u045d\u0457\3\2\2\2\u045e\u045f\3\2\2\2\u045f\u0460\b\\\1\2\u0460"+
		"\u00b7\3\2\2\2\u0461\u0462\7+\2\2\u0462\u0463\7\32\2\2\u0463\u0464\5V"+
		",\2\u0464\u0465\b]\1\2\u0465\u0466\7\33\2\2\u0466\u0469\3\2\2\2\u0467"+
		"\u0469\7+\2\2\u0468\u0461\3\2\2\2\u0468\u0467\3\2\2\2\u0469\u046a\3\2"+
		"\2\2\u046a\u046b\b]\1\2\u046b\u00b9\3\2\2\2\u046c\u046d\7D\2\2\u046d\u046e"+
		"\7\32\2\2\u046e\u046f\5V,\2\u046f\u0470\b^\1\2\u0470\u0471\7\33\2\2\u0471"+
		"\u0474\3\2\2\2\u0472\u0474\7D\2\2\u0473\u046c\3\2\2\2\u0473\u0472\3\2"+
		"\2\2\u0474\u0475\3\2\2\2\u0475\u0476\b^\1\2\u0476\u00bb\3\2\2\2\u0477"+
		"\u047b\7h\2\2\u0478\u0479\5\u00be`\2\u0479\u047a\b_\1\2\u047a\u047c\3"+
		"\2\2\2\u047b\u0478\3\2\2\2\u047c\u047d\3\2\2\2\u047d\u047b\3\2\2\2\u047d"+
		"\u047e\3\2\2\2\u047e\u047f\3\2\2\2\u047f\u0480\b_\1\2\u0480\u00bd\3\2"+
		"\2\2\u0481\u0482\7\26\2\2\u0482\u0483\5V,\2\u0483\u0484\b`\1\2\u0484\u0485"+
		"\7\27\2\2\u0485\u00bf\3\2\2\2\u0486\u048b\5\u00e8u\2\u0487\u0488\5\u00ec"+
		"w\2\u0488\u0489\ba\1\2\u0489\u048b\3\2\2\2\u048a\u0486\3\2\2\2\u048a\u0487"+
		"\3\2\2\2\u048b\u00c1\3\2\2\2\u048c\u048d\7H\2\2\u048d\u048e\bb\1\2\u048e"+
		"\u048f\5\u0134\u009b\2\u048f\u0490\bb\1\2\u0490\u0491\bb\1\2\u0491\u0492"+
		"\7\22\2\2\u0492\u0493\5\u00c4c\2\u0493\u0494\7\23\2\2\u0494\u0495\bb\1"+
		"\2\u0495\u00c3\3\2\2\2\u0496\u0497\5\u00a2R\2\u0497\u0498\bc\1\2\u0498"+
		"\u049a\3\2\2\2\u0499\u0496\3\2\2\2\u049a\u049d\3\2\2\2\u049b\u0499\3\2"+
		"\2\2\u049b\u049c\3\2\2\2\u049c\u00c5\3\2\2\2\u049d\u049b\3\2\2\2\u049e"+
		"\u049f\5\u00c8e\2\u049f\u04a0\bd\1\2\u04a0\u04a2\3\2\2\2\u04a1\u049e\3"+
		"\2\2\2\u04a1\u04a2\3\2\2\2\u04a2\u04a3\3\2\2\2\u04a3\u04a4\5\u00caf\2"+
		"\u04a4\u04a5\bd\1\2\u04a5\u04a6\bd\1\2\u04a6\u04a7\7h\2\2\u04a7\u04a8"+
		"\bd\1\2\u04a8\u04a9\5\u00ccg\2\u04a9\u04ae\bd\1\2\u04aa\u04ab\5\u00d2"+
		"j\2\u04ab\u04ac\bd\1\2\u04ac\u04ad\bd\1\2\u04ad\u04af\3\2\2\2\u04ae\u04aa"+
		"\3\2\2\2\u04ae\u04af\3\2\2\2\u04af\u04b1\3\2\2\2\u04b0\u04b2\5\u00d4k"+
		"\2\u04b1\u04b0\3\2\2\2\u04b1\u04b2\3\2\2\2\u04b2\u04b3\3\2\2\2\u04b3\u04b4"+
		"\bd\1\2\u04b4\u00c7\3\2\2\2\u04b5\u04b6\7T\2\2\u04b6\u04b7\be\1\2\u04b7"+
		"\u00c9\3\2\2\2\u04b8\u04b9\5\u00d6l\2\u04b9\u04ba\bf\1\2\u04ba\u04bd\3"+
		"\2\2\2\u04bb\u04bd\7:\2\2\u04bc\u04b8\3\2\2\2\u04bc\u04bb\3\2\2\2\u04bd"+
		"\u00cb\3\2\2\2\u04be\u04c0\7\24\2\2\u04bf\u04c1\5\u00ceh\2\u04c0\u04bf"+
		"\3\2\2\2\u04c0\u04c1\3\2\2\2\u04c1\u04c2\3\2\2\2\u04c2\u04c3\7\25\2\2"+
		"\u04c3\u00cd\3\2\2\2\u04c4\u04c5\5\u00d0i\2\u04c5\u04c6\bh\1\2\u04c6\u04ce"+
		"\bh\1\2\u04c7\u04c8\7\21\2\2\u04c8\u04c9\5\u00d0i\2\u04c9\u04ca\bh\1\2"+
		"\u04ca\u04cb\bh\1\2\u04cb\u04cd\3\2\2\2\u04cc\u04c7\3\2\2\2\u04cd\u04d0"+
		"\3\2\2\2\u04ce\u04cc\3\2\2\2\u04ce\u04cf\3\2\2\2\u04cf\u00cf\3\2\2\2\u04d0"+
		"\u04ce\3\2\2\2\u04d1\u04d2\t\b\2\2\u04d2\u04d3\5\u00d6l\2\u04d3\u04d4"+
		"\bi\1\2\u04d4\u04d5\5j\66\2\u04d5\u04d6\bi\1\2\u04d6\u00d1\3\2\2\2\u04d7"+
		"\u04d8\79\2\2\u04d8\u04d9\7\24\2\2\u04d9\u04da\5\34\17\2\u04da\u04db\b"+
		"j\1\2\u04db\u04dc\7\25\2\2\u04dc\u00d3\3\2\2\2\u04dd\u04de\7E\2\2\u04de"+
		"\u04df\7\24\2\2\u04df\u04e4\7\r\2\2\u04e0\u04e1\7\21\2\2\u04e1\u04e3\7"+
		"\r\2\2\u04e2\u04e0\3\2\2\2\u04e3\u04e6\3\2\2\2\u04e4\u04e2\3\2\2\2\u04e4"+
		"\u04e5\3\2\2\2\u04e5\u04e7\3\2\2\2\u04e6\u04e4\3\2\2\2\u04e7\u04e8\7\25"+
		"\2\2\u04e8\u00d5\3\2\2\2\u04e9\u04ea\5`\61\2\u04ea\u04eb\bl\1\2\u04eb"+
		"\u04f6\3\2\2\2\u04ec\u04ed\5\u00b8]\2\u04ed\u04ee\bl\1\2\u04ee\u04f6\3"+
		"\2\2\2\u04ef\u04f0\5\u00ba^\2\u04f0\u04f1\bl\1\2\u04f1\u04f6\3\2\2\2\u04f2"+
		"\u04f3\5\36\20\2\u04f3\u04f4\bl\1\2\u04f4\u04f6\3\2\2\2\u04f5\u04e9\3"+
		"\2\2\2\u04f5\u04ec\3\2\2\2\u04f5\u04ef\3\2\2\2\u04f5\u04f2\3\2\2\2\u04f6"+
		"\u00d7\3\2\2\2\u04f7\u04f8\7R\2\2\u04f8\u04f9\7\32\2\2\u04f9\u04fa\5V"+
		",\2\u04fa\u04fb\7\21\2\2\u04fb\u04fc\5V,\2\u04fc\u04fd\7\33\2\2\u04fd"+
		"\u04fe\bm\1\2\u04fe\u00d9\3\2\2\2\u04ff\u0500\7R\2\2\u0500\u0501\bn\1"+
		"\2\u0501\u00db\3\2\2\2\u0502\u0503\7K\2\2\u0503\u0504\bo\1\2\u0504\u00dd"+
		"\3\2\2\2\u0505\u0506\7\65\2\2\u0506\u050a\7h\2\2\u0507\u0508\7S\2\2\u0508"+
		"\u050a\7h\2\2\u0509\u0505\3\2\2\2\u0509\u0507\3\2\2\2\u050a\u00df\3\2"+
		"\2\2\u050b\u050c\7\64\2\2\u050c\u050d\bq\1\2\u050d\u050e\5\u00e2r\2\u050e"+
		"\u050f\7\17\2\2\u050f\u00e1\3\2\2\2\u0510\u0513\5\36\20\2\u0511\u0513"+
		"\7\r\2\2\u0512\u0510\3\2\2\2\u0512\u0511\3\2\2\2\u0513\u00e3\3\2\2\2\u0514"+
		"\u0515\7a\2\2\u0515\u0516\bs\1\2\u0516\u0517\5\36\20\2\u0517\u0518\7\r"+
		"\2\2\u0518\u00e5\3\2\2\2\u0519\u051a\7`\2\2\u051a\u051b\bt\1\2\u051b\u051c"+
		"\5\36\20\2\u051c\u051d\7\r\2\2\u051d\u00e7\3\2\2\2\u051e\u051f\7\67\2"+
		"\2\u051f\u0520\7b\2\2\u0520\u0521\5\u00d6l\2\u0521\u0522\5\u00eav\2\u0522"+
		"\u00e9\3\2\2\2\u0523\u0524\5j\66\2\u0524\u0525\5\u00d2j\2\u0525\u052f"+
		"\3\2\2\2\u0526\u052b\5j\66\2\u0527\u0528\7\21\2\2\u0528\u052a\5j\66\2"+
		"\u0529\u0527\3\2\2\2\u052a\u052d\3\2\2\2\u052b\u0529\3\2\2\2\u052b\u052c"+
		"\3\2\2\2\u052c\u052f\3\2\2\2\u052d\u052b\3\2\2\2\u052e\u0523\3\2\2\2\u052e"+
		"\u0526\3\2\2\2\u052f\u00eb\3\2\2\2\u0530\u0531\7b\2\2\u0531\u0532\5\u00d6"+
		"l\2\u0532\u0533\bw\1\2\u0533\u0534\5\u00eex\2\u0534\u0535\bw\1\2\u0535"+
		"\u00ed\3\2\2\2\u0536\u0537\5j\66\2\u0537\u0542\bx\1\2\u0538\u0543\5\u00f0"+
		"y\2\u0539\u053a\7\21\2\2\u053a\u053b\5j\66\2\u053b\u053c\bx\1\2\u053c"+
		"\u053e\3\2\2\2\u053d\u0539\3\2\2\2\u053e\u0541\3\2\2\2\u053f\u053d\3\2"+
		"\2\2\u053f\u0540\3\2\2\2\u0540\u0543\3\2\2\2\u0541\u053f\3\2\2\2\u0542"+
		"\u0538\3\2\2\2\u0542\u053f\3\2\2\2\u0543\u00ef\3\2\2\2\u0544\u0546\5\u00f2"+
		"z\2\u0545\u0547\5\u00f4{\2\u0546\u0545\3\2\2\2\u0546\u0547\3\2\2\2\u0547"+
		"\u054a\3\2\2\2\u0548\u054a\5\u00f4{\2\u0549\u0544\3\2\2\2\u0549\u0548"+
		"\3\2\2\2\u054a\u00f1\3\2\2\2\u054b\u054c\7I\2\2\u054c\u054d\5\u00f6|\2"+
		"\u054d\u00f3\3\2\2\2\u054e\u054f\7(\2\2\u054f\u0550\5\u00f6|\2\u0550\u00f5"+
		"\3\2\2\2\u0551\u0552\7\24\2\2\u0552\u0557\5\36\20\2\u0553\u0554\7\21\2"+
		"\2\u0554\u0556\5\36\20\2\u0555\u0553\3\2\2\2\u0556\u0559\3\2\2\2\u0557"+
		"\u0555\3\2\2\2\u0557\u0558\3\2\2\2\u0558\u055a\3\2\2\2\u0559\u0557\3\2"+
		"\2\2\u055a\u055b\7\25\2\2\u055b\u00f7\3\2\2\2\u055c\u055f\5\u00fc\177"+
		"\2\u055d\u055f\5\u00fa~\2\u055e\u055c\3\2\2\2\u055e\u055d\3\2\2\2\u055f"+
		"\u00f9\3\2\2\2\u0560\u0561\7f\2\2\u0561\u0562\b~\1\2\u0562\u0563\7h\2"+
		"\2\u0563\u00fb\3\2\2\2\u0564\u0565\5\u00fe\u0080\2\u0565\u0566\7\22\2"+
		"\2\u0566\u0567\5\u0104\u0083\2\u0567\u0568\7\23\2\2\u0568\u00fd\3\2\2"+
		"\2\u0569\u056a\7f\2\2\u056a\u056c\7h\2\2\u056b\u056d\5\u0102\u0082\2\u056c"+
		"\u056b\3\2\2\2\u056c\u056d\3\2\2\2\u056d\u056f\3\2\2\2\u056e\u0570\5\u0100"+
		"\u0081\2\u056f\u056e\3\2\2\2\u056f\u0570\3\2\2\2\u0570\u00ff\3\2\2\2\u0571"+
		"\u0572\7M\2\2\u0572\u0577\5\36\20\2\u0573\u0574\7\21\2\2\u0574\u0576\5"+
		"\36\20\2\u0575\u0573\3\2\2\2\u0576\u0579\3\2\2\2\u0577\u0575\3\2\2\2\u0577"+
		"\u0578\3\2\2\2\u0578\u0101\3\2\2\2\u0579\u0577\3\2\2\2\u057a\u057b\7\20"+
		"\2\2\u057b\u057c\5\36\20\2\u057c\u0103\3\2\2\2\u057d\u057f\5\u0106\u0084"+
		"\2\u057e\u057d\3\2\2\2\u057f\u0582\3\2\2\2\u0580\u057e\3\2\2\2\u0580\u0581"+
		"\3\2\2\2\u0581\u0105\3\2\2\2\u0582\u0580\3\2\2\2\u0583\u0584\5\u0108\u0085"+
		"\2\u0584\u0585\7\17\2\2\u0585\u0596\3\2\2\2\u0586\u0587\5\u010c\u0087"+
		"\2\u0587\u0588\7\17\2\2\u0588\u0596\3\2\2\2\u0589\u058a\5\u010e\u0088"+
		"\2\u058a\u058b\7\17\2\2\u058b\u0596\3\2\2\2\u058c\u058d\5\u0110\u0089"+
		"\2\u058d\u058e\7\17\2\2\u058e\u0596\3\2\2\2\u058f\u0590\5\u0112\u008a"+
		"\2\u0590\u0591\7\17\2\2\u0591\u0596\3\2\2\2\u0592\u0593\5\u00c0a\2\u0593"+
		"\u0594\7\17\2\2\u0594\u0596\3\2\2\2\u0595\u0583\3\2\2\2\u0595\u0586\3"+
		"\2\2\2\u0595\u0589\3\2\2\2\u0595\u058c\3\2\2\2\u0595\u058f\3\2\2\2\u0595"+
		"\u0592\3\2\2\2\u0596\u0107\3\2\2\2\u0597\u0598\7]\2\2\u0598\u0599\5\u010a"+
		"\u0086\2\u0599\u059a\7h\2\2\u059a\u0109\3\2\2\2\u059b\u059e\5\36\20\2"+
		"\u059c\u059e\7O\2\2\u059d\u059b\3\2\2\2\u059d\u059c\3\2\2\2\u059e\u010b"+
		"\3\2\2\2\u059f\u05a1\7/\2\2\u05a0\u05a2\7Z\2\2\u05a1\u05a0\3\2\2\2\u05a1"+
		"\u05a2\3\2\2\2\u05a2\u05a3\3\2\2\2\u05a3\u05a4\5\u010a\u0086\2\u05a4\u05a5"+
		"\7h\2\2\u05a5\u010d\3\2\2\2\u05a6\u05a7\7*\2\2\u05a7\u05a8\5\36\20\2\u05a8"+
		"\u05a9\7h\2\2\u05a9\u010f\3\2\2\2\u05aa\u05ab\7-\2\2\u05ab\u05ac\5\36"+
		"\20\2\u05ac\u05ad\7h\2\2\u05ad\u0111\3\2\2\2\u05ae\u05af\7^\2\2\u05af"+
		"\u05b0\5\36\20\2\u05b0\u05b1\7h\2\2\u05b1\u0113\3\2\2\2\u05b2\u05b3\5"+
		"\u0116\u008c\2\u05b3\u05b4\5\u011c\u008f\2\u05b4\u0115\3\2\2\2\u05b5\u05b6"+
		"\7F\2\2\u05b6\u05b8\7h\2\2\u05b7\u05b9\5\u0118\u008d\2\u05b8\u05b7\3\2"+
		"\2\2\u05b8\u05b9\3\2\2\2\u05b9\u05bb\3\2\2\2\u05ba\u05bc\5\u0100\u0081"+
		"\2\u05bb\u05ba\3\2\2\2\u05bb\u05bc\3\2\2\2\u05bc\u05bd\3\2\2\2\u05bd\u05be"+
		"\7d\2\2\u05be\u05c0\5\36\20\2\u05bf\u05c1\5\u011a\u008e\2\u05c0\u05bf"+
		"\3\2\2\2\u05c0\u05c1\3\2\2\2\u05c1\u0117\3\2\2\2\u05c2\u05c3\7\20\2\2"+
		"\u05c3\u05c4\5\36\20\2\u05c4\u0119\3\2\2\2\u05c5\u05c6\7\60\2\2\u05c6"+
		"\u05c7\5\36\20\2\u05c7\u011b\3\2\2\2\u05c8\u05cc\7\22\2\2\u05c9\u05cb"+
		"\5\u011e\u0090\2\u05ca\u05c9\3\2\2\2\u05cb\u05ce\3\2\2\2\u05cc\u05ca\3"+
		"\2\2\2\u05cc\u05cd\3\2\2\2\u05cd\u05cf\3\2\2\2\u05ce\u05cc\3\2\2\2\u05cf"+
		"\u05d0\7\23\2\2\u05d0\u011d\3\2\2\2\u05d1\u05d9\5\24\13\2\u05d2\u05d3"+
		"\5\u0120\u0091\2\u05d3\u05d4\7\17\2\2\u05d4\u05d9\3\2\2\2\u05d5\u05d6"+
		"\5\u0122\u0092\2\u05d6\u05d7\7\17\2\2\u05d7\u05d9\3\2\2\2\u05d8\u05d1"+
		"\3\2\2\2\u05d8\u05d2\3\2\2\2\u05d8\u05d5\3\2\2\2\u05d9\u011f\3\2\2\2\u05da"+
		"\u05db\7G\2\2\u05db\u05dc\7h\2\2\u05dc\u05de\7\24\2\2\u05dd\u05df\5\66"+
		"\34\2\u05de\u05dd\3\2\2\2\u05de\u05df\3\2\2\2\u05df\u05e0\3\2\2\2\u05e0"+
		"\u05e2\7\25\2\2\u05e1\u05e3\5\u00d2j\2\u05e2\u05e1\3\2\2\2\u05e2\u05e3"+
		"\3\2\2\2\u05e3\u0121\3\2\2\2\u05e4\u05e5\78\2\2\u05e5\u05e6\7h\2\2\u05e6"+
		"\u05e8\7\24\2\2\u05e7\u05e9\5\66\34\2\u05e8\u05e7\3\2\2\2\u05e8\u05e9"+
		"\3\2\2\2\u05e9\u05ea\3\2\2\2\u05ea\u05ec\7\25\2\2\u05eb\u05ed\5\u00d2"+
		"j\2\u05ec\u05eb\3\2\2\2\u05ec\u05ed\3\2\2\2\u05ed\u0123\3\2\2\2\u05ee"+
		"\u05f2\5\u012a\u0096\2\u05ef\u05f2\5\u0128\u0095\2\u05f0\u05f2\5\u0126"+
		"\u0094\2\u05f1\u05ee\3\2\2\2\u05f1\u05ef\3\2\2\2\u05f1\u05f0\3\2\2\2\u05f2"+
		"\u0125\3\2\2\2\u05f3\u05f5\7[\2\2\u05f4\u05f3\3\2\2\2\u05f4\u05f5\3\2"+
		"\2\2\u05f5\u05f6\3\2\2\2\u05f6\u05f7\7<\2\2\u05f7\u05f8\7h\2\2\u05f8\u0127"+
		"\3\2\2\2\u05f9\u05fa\7[\2\2\u05fa\u05fb\7<\2\2\u05fb\u05fc\7h\2\2\u05fc"+
		"\u05fd\5,\27\2\u05fd\u0601\7\22\2\2\u05fe\u0600\5\24\13\2\u05ff\u05fe"+
		"\3\2\2\2\u0600\u0603\3\2\2\2\u0601\u05ff\3\2\2\2\u0601\u0602\3\2\2\2\u0602"+
		"\u0604\3\2\2\2\u0603\u0601\3\2\2\2\u0604\u0605\7\23\2\2\u0605\u0129\3"+
		"\2\2\2\u0606\u0607\5\u012c\u0097\2\u0607\u060b\7\22\2\2\u0608\u060a\5"+
		"\60\31\2\u0609\u0608\3\2\2\2\u060a\u060d\3\2\2\2\u060b\u0609\3\2\2\2\u060b"+
		"\u060c\3\2\2\2\u060c\u060e\3\2\2\2\u060d\u060b\3\2\2\2\u060e\u060f\7\23"+
		"\2\2\u060f\u012b\3\2\2\2\u0610\u0612\7\61\2\2\u0611\u0610\3\2\2\2\u0611"+
		"\u0612\3\2\2\2\u0612\u0613\3\2\2\2\u0613\u0614\7<\2\2\u0614\u0615\7h\2"+
		"\2\u0615\u0616\5,\27\2\u0616\u012d\3\2\2\2\u0617\u0618\7$\2\2\u0618\u0619"+
		"\5\36\20\2\u0619\u061f\b\u0098\1\2\u061a\u061c\7\24\2\2\u061b\u061d\5"+
		"\u0130\u0099\2\u061c\u061b\3\2\2\2\u061c\u061d\3\2\2\2\u061d\u061e\3\2"+
		"\2\2\u061e\u0620\7\25\2\2\u061f\u061a\3\2\2\2\u061f\u0620\3\2\2\2\u0620"+
		"\u012f\3\2\2\2\u0621\u0622\5@!\2\u0622\u0623\b\u0099\1\2\u0623\u062d\3"+
		"\2\2\2\u0624\u0629\5\u0132\u009a\2\u0625\u0626\7\21\2\2\u0626\u0628\5"+
		"\u0132\u009a\2\u0627\u0625\3\2\2\2\u0628\u062b\3\2\2\2\u0629\u0627\3\2"+
		"\2\2\u0629\u062a\3\2\2\2\u062a\u062d\3\2\2\2\u062b\u0629\3\2\2\2\u062c"+
		"\u0621\3\2\2\2\u062c\u0624\3\2\2\2\u062d\u0131\3\2\2\2\u062e\u062f\5\u0134"+
		"\u009b\2\u062f\u0630\7\"\2\2\u0630\u0631\5@!\2\u0631\u0632\b\u009a\1\2"+
		"\u0632\u0133\3\2\2\2\u0633\u0634\7h\2\2\u0634\u0135\3\2\2\2p\u0139\u0141"+
		"\u0174\u0188\u018e\u0191\u0198\u01a2\u01ac\u01ce\u01e2\u01e7\u01f2\u01fb"+
		"\u01fe\u020f\u0219\u021f\u0227\u022e\u0231\u0239\u023c\u0243\u024e\u0252"+
		"\u025b\u028a\u0298\u02a4\u02b0\u02bc\u02c8\u02d4\u02df\u02ed\u02fa\u0302"+
		"\u031a\u0326\u0331\u0348\u0354\u0359\u0363\u036c\u037b\u0383\u038e\u03a0"+
		"\u03be\u03cb\u03d4\u03dd\u03f2\u03fb\u041e\u0425\u042f\u0431\u0448\u045d"+
		"\u0468\u0473\u047d\u048a\u049b\u04a1\u04ae\u04b1\u04bc\u04c0\u04ce\u04e4"+
		"\u04f5\u0509\u0512\u052b\u052e\u053f\u0542\u0546\u0549\u0557\u055e\u056c"+
		"\u056f\u0577\u0580\u0595\u059d\u05a1\u05b8\u05bb\u05c0\u05cc\u05d8\u05de"+
		"\u05e2\u05e8\u05ec\u05f1\u05f4\u0601\u060b\u0611\u061c\u061f\u0629\u062c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}