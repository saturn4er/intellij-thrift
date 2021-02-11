// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ThriftParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return document(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(BASE_TYPE, CONTAINER_TYPE, CUSTOM_TYPE, LIST_TYPE,
      MAP_TYPE, SET_TYPE, TYPE),
  };

  /* ********************************************************** */
  // simple_base_type type_annotations?
  public static boolean base_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "base_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BASE_TYPE, "<base type>");
    r = simple_base_type(b, l + 1);
    r = r && base_type_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // type_annotations?
  private static boolean base_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "base_type_1")) return false;
    type_annotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // !(')')
  static boolean brace_recovery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_recovery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'const' type definition_name '=' const_value list_separator?
  public static boolean const_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_declaration")) return false;
    if (!nextTokenIs(b, CONST)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONST_DECLARATION, null);
    r = consumeToken(b, CONST);
    p = r; // pin = 1
    r = r && report_error_(b, type(b, l + 1));
    r = p && report_error_(b, definition_name(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, EQUALS)) && r;
    r = p && report_error_(b, const_value(b, l + 1)) && r;
    r = p && const_declaration_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // list_separator?
  private static boolean const_declaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_declaration_5")) return false;
    list_separator(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '[' (const_value list_separator?)* ']'
  public static boolean const_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_list")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKET);
    r = r && const_list_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKET);
    exit_section_(b, m, CONST_LIST, r);
    return r;
  }

  // (const_value list_separator?)*
  private static boolean const_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!const_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "const_list_1", c)) break;
    }
    return true;
  }

  // const_value list_separator?
  private static boolean const_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = const_value(b, l + 1);
    r = r && const_list_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // list_separator?
  private static boolean const_list_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_list_1_0_1")) return false;
    list_separator(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '{' (const_value ':' const_value list_separator?)* '}'
  public static boolean const_map(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_map")) return false;
    if (!nextTokenIs(b, LEFT_CURLY_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_CURLY_BRACE);
    r = r && const_map_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY_BRACE);
    exit_section_(b, m, CONST_MAP, r);
    return r;
  }

  // (const_value ':' const_value list_separator?)*
  private static boolean const_map_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_map_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!const_map_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "const_map_1", c)) break;
    }
    return true;
  }

  // const_value ':' const_value list_separator?
  private static boolean const_map_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_map_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = const_value(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && const_value(b, l + 1);
    r = r && const_map_1_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // list_separator?
  private static boolean const_map_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_map_1_0_3")) return false;
    list_separator(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // int_constant | double_constant | LITERAL | IDENTIFIER | const_list | const_map
  public static boolean const_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONST_VALUE, "<const value>");
    r = int_constant(b, l + 1);
    if (!r) r = double_constant(b, l + 1);
    if (!r) r = consumeToken(b, LITERAL);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = const_list(b, l + 1);
    if (!r) r = const_map(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (map_type | set_type | list_type) type_annotations?
  public static boolean container_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, CONTAINER_TYPE, "<container type>");
    r = container_type_0(b, l + 1);
    r = r && container_type_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // map_type | set_type | list_type
  private static boolean container_type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_type_0")) return false;
    boolean r;
    r = map_type(b, l + 1);
    if (!r) r = set_type(b, l + 1);
    if (!r) r = list_type(b, l + 1);
    return r;
  }

  // type_annotations?
  private static boolean container_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "container_type_1")) return false;
    type_annotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'cpp_type' LITERAL
  public static boolean cpp_type_attr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cpp_type_attr")) return false;
    if (!nextTokenIs(b, CPP_TYPE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CPP_TYPE_ATTR, null);
    r = consumeTokens(b, 1, CPP_TYPE, LITERAL);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // !('}')
  static boolean curly_brace_recovery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "curly_brace_recovery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RIGHT_CURLY_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean custom_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "custom_type")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, CUSTOM_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // const_declaration
  //     | type_declaration
  //     | enum_declaration
  //     | senum_declaration
  //     | struct_declaration
  //     | union_declaration
  //     | exception_declaration
  //     | service_declaration
  static boolean declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration")) return false;
    boolean r;
    r = const_declaration(b, l + 1);
    if (!r) r = type_declaration(b, l + 1);
    if (!r) r = enum_declaration(b, l + 1);
    if (!r) r = senum_declaration(b, l + 1);
    if (!r) r = struct_declaration(b, l + 1);
    if (!r) r = union_declaration(b, l + 1);
    if (!r) r = exception_declaration(b, l + 1);
    if (!r) r = service_declaration(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean definition_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definition_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, DEFINITION_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // top_level_element*
  static boolean document(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "document")) return false;
    while (true) {
      int c = current_position_(b);
      if (!top_level_element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "document", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ('+' | '-')? NUMBER
  public static boolean double_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "double_constant")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DOUBLE_CONSTANT, "<double constant>");
    r = double_constant_0(b, l + 1);
    r = r && consumeToken(b, NUMBER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('+' | '-')?
  private static boolean double_constant_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "double_constant_0")) return false;
    double_constant_0_0(b, l + 1);
    return true;
  }

  // '+' | '-'
  private static boolean double_constant_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "double_constant_0_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    return r;
  }

  /* ********************************************************** */
  // enum_field (list_separator? enum_field)*
  static boolean enum_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_body")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enum_field(b, l + 1);
    r = r && enum_body_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (list_separator? enum_field)*
  private static boolean enum_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_body_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enum_body_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_body_1", c)) break;
    }
    return true;
  }

  // list_separator? enum_field
  private static boolean enum_body_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_body_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enum_body_1_0_0(b, l + 1);
    r = r && enum_field(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // list_separator?
  private static boolean enum_body_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_body_1_0_0")) return false;
    list_separator(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'enum' definition_name '{' enum_body? '}' type_annotations?
  public static boolean enum_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_declaration")) return false;
    if (!nextTokenIs(b, ENUM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENUM_DECLARATION, null);
    r = consumeToken(b, ENUM);
    p = r; // pin = 1
    r = r && report_error_(b, definition_name(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LEFT_CURLY_BRACE)) && r;
    r = p && report_error_(b, enum_declaration_3(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RIGHT_CURLY_BRACE)) && r;
    r = p && enum_declaration_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // enum_body?
  private static boolean enum_declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_declaration_3")) return false;
    enum_body(b, l + 1);
    return true;
  }

  // type_annotations?
  private static boolean enum_declaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_declaration_5")) return false;
    type_annotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER ('=' int_constant)? type_annotations?
  public static boolean enum_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_field")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_FIELD, "<enum field>");
    r = consumeToken(b, IDENTIFIER);
    r = r && enum_field_1(b, l + 1);
    r = r && enum_field_2(b, l + 1);
    exit_section_(b, l, m, r, false, ThriftParser::enum_field_recovery);
    return r;
  }

  // ('=' int_constant)?
  private static boolean enum_field_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_field_1")) return false;
    enum_field_1_0(b, l + 1);
    return true;
  }

  // '=' int_constant
  private static boolean enum_field_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_field_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && int_constant(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // type_annotations?
  private static boolean enum_field_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_field_2")) return false;
    type_annotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // !('}' | IDENTIFIER)
  static boolean enum_field_recovery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_field_recovery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !enum_field_recovery_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '}' | IDENTIFIER
  private static boolean enum_field_recovery_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_field_recovery_0")) return false;
    boolean r;
    r = consumeToken(b, RIGHT_CURLY_BRACE);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  /* ********************************************************** */
  // 'exception' definition_name '{' fields_body '}' type_annotations?
  public static boolean exception_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exception_declaration")) return false;
    if (!nextTokenIs(b, EXCEPTION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXCEPTION_DECLARATION, null);
    r = consumeToken(b, EXCEPTION);
    p = r; // pin = 1
    r = r && report_error_(b, definition_name(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LEFT_CURLY_BRACE)) && r;
    r = p && report_error_(b, fields_body(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RIGHT_CURLY_BRACE)) && r;
    r = p && exception_declaration_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // type_annotations?
  private static boolean exception_declaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exception_declaration_5")) return false;
    type_annotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // field_id? field_req? type definition_name ('=' const_value)? field_xsd_options? type_annotations? list_separator?
  public static boolean field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FIELD, "<field>");
    r = field_0(b, l + 1);
    r = r && field_1(b, l + 1);
    r = r && type(b, l + 1);
    p = r; // pin = 3
    r = r && report_error_(b, definition_name(b, l + 1));
    r = p && report_error_(b, field_4(b, l + 1)) && r;
    r = p && report_error_(b, field_5(b, l + 1)) && r;
    r = p && report_error_(b, field_6(b, l + 1)) && r;
    r = p && field_7(b, l + 1) && r;
    exit_section_(b, l, m, r, p, ThriftParser::field_recovery);
    return r || p;
  }

  // field_id?
  private static boolean field_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_0")) return false;
    field_id(b, l + 1);
    return true;
  }

  // field_req?
  private static boolean field_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_1")) return false;
    field_req(b, l + 1);
    return true;
  }

  // ('=' const_value)?
  private static boolean field_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_4")) return false;
    field_4_0(b, l + 1);
    return true;
  }

  // '=' const_value
  private static boolean field_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && const_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // field_xsd_options?
  private static boolean field_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_5")) return false;
    field_xsd_options(b, l + 1);
    return true;
  }

  // type_annotations?
  private static boolean field_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_6")) return false;
    type_annotations(b, l + 1);
    return true;
  }

  // list_separator?
  private static boolean field_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_7")) return false;
    list_separator(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // int_constant ':'
  public static boolean field_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_id")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_ID, "<field id>");
    r = int_constant(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !(')' | '+' | '-' | 'binary' | 'bool' | 'byte' | 'double' | 'i8' | 'i16' | 'i32' | 'i64' | 'list' |
  //                             'map' | 'optional' | 'required' | 'set' | 'slist' | 'string' | '}'| INTEGER | IDENTIFIER | NUMBER )
  static boolean field_recovery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_recovery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !field_recovery_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ')' | '+' | '-' | 'binary' | 'bool' | 'byte' | 'double' | 'i8' | 'i16' | 'i32' | 'i64' | 'list' |
  //                             'map' | 'optional' | 'required' | 'set' | 'slist' | 'string' | '}'| INTEGER | IDENTIFIER | NUMBER
  private static boolean field_recovery_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_recovery_0")) return false;
    boolean r;
    r = consumeToken(b, RIGHT_BRACE);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, BINARY);
    if (!r) r = consumeToken(b, BOOL);
    if (!r) r = consumeToken(b, BYTE);
    if (!r) r = consumeToken(b, DOUBLE);
    if (!r) r = consumeToken(b, I8);
    if (!r) r = consumeToken(b, I16);
    if (!r) r = consumeToken(b, I32);
    if (!r) r = consumeToken(b, I64);
    if (!r) r = consumeToken(b, LIST);
    if (!r) r = consumeToken(b, MAP);
    if (!r) r = consumeToken(b, OPTIONAL);
    if (!r) r = consumeToken(b, REQUIRED);
    if (!r) r = consumeToken(b, SET);
    if (!r) r = consumeToken(b, SLIST);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, RIGHT_CURLY_BRACE);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NUMBER);
    return r;
  }

  /* ********************************************************** */
  // 'required' | 'optional'
  public static boolean field_req(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_req")) return false;
    if (!nextTokenIs(b, "<field req>", OPTIONAL, REQUIRED)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_REQ, "<field req>");
    r = consumeToken(b, REQUIRED);
    if (!r) r = consumeToken(b, OPTIONAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'xsd_attrs' '{' fields '}'
  public static boolean field_xdf_attrs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_xdf_attrs")) return false;
    if (!nextTokenIs(b, XSD_ATTRS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FIELD_XDF_ATTRS, null);
    r = consumeTokens(b, 1, XSD_ATTRS, LEFT_CURLY_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, fields(b, l + 1));
    r = p && consumeToken(b, RIGHT_CURLY_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'xsd_optional'? 'xsd_nillable'? field_xdf_attrs?
  static boolean field_xsd_options(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_xsd_options")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field_xsd_options_0(b, l + 1);
    r = r && field_xsd_options_1(b, l + 1);
    r = r && field_xsd_options_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'xsd_optional'?
  private static boolean field_xsd_options_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_xsd_options_0")) return false;
    consumeToken(b, XSD_OPTIONAL);
    return true;
  }

  // 'xsd_nillable'?
  private static boolean field_xsd_options_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_xsd_options_1")) return false;
    consumeToken(b, XSD_NILLABLE);
    return true;
  }

  // field_xdf_attrs?
  private static boolean field_xsd_options_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_xsd_options_2")) return false;
    field_xdf_attrs(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // field*
  static boolean fields(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fields")) return false;
    while (true) {
      int c = current_position_(b);
      if (!field(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fields", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // fields_with_curly_brace_recovery
  static boolean fields_body(PsiBuilder b, int l) {
    return fields_with_curly_brace_recovery(b, l + 1);
  }

  /* ********************************************************** */
  // fields
  static boolean fields_with_brace_recovery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fields_with_brace_recovery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = fields(b, l + 1);
    exit_section_(b, l, m, r, false, ThriftParser::brace_recovery);
    return r;
  }

  /* ********************************************************** */
  // fields
  static boolean fields_with_curly_brace_recovery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fields_with_curly_brace_recovery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = fields(b, l + 1);
    exit_section_(b, l, m, r, false, ThriftParser::curly_brace_recovery);
    return r;
  }

  /* ********************************************************** */
  // 'oneway'? function_type definition_name '(' fields_with_brace_recovery ')' function_throws? type_annotations?
  public static boolean function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION, "<function>");
    r = function_0(b, l + 1);
    r = r && function_type(b, l + 1);
    r = r && definition_name(b, l + 1);
    p = r; // pin = 3
    r = r && report_error_(b, consumeToken(b, LEFT_BRACE));
    r = p && report_error_(b, fields_with_brace_recovery(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RIGHT_BRACE)) && r;
    r = p && report_error_(b, function_6(b, l + 1)) && r;
    r = p && function_7(b, l + 1) && r;
    exit_section_(b, l, m, r, p, ThriftParser::function_recovery);
    return r || p;
  }

  // 'oneway'?
  private static boolean function_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_0")) return false;
    consumeToken(b, ONEWAY);
    return true;
  }

  // function_throws?
  private static boolean function_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_6")) return false;
    function_throws(b, l + 1);
    return true;
  }

  // type_annotations?
  private static boolean function_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_7")) return false;
    type_annotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // !('binary' | 'bool' | 'byte' | 'double' |'i8' | 'i16' | 'i32' | 'i64' | 'list' | 'map' |
  //                                'oneway' | 'set' | 'slist' | 'string' | 'void' | '}' | IDENTIFIER | list_separator)
  static boolean function_recovery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_recovery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !function_recovery_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'binary' | 'bool' | 'byte' | 'double' |'i8' | 'i16' | 'i32' | 'i64' | 'list' | 'map' |
  //                                'oneway' | 'set' | 'slist' | 'string' | 'void' | '}' | IDENTIFIER | list_separator
  private static boolean function_recovery_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_recovery_0")) return false;
    boolean r;
    r = consumeToken(b, BINARY);
    if (!r) r = consumeToken(b, BOOL);
    if (!r) r = consumeToken(b, BYTE);
    if (!r) r = consumeToken(b, DOUBLE);
    if (!r) r = consumeToken(b, I8);
    if (!r) r = consumeToken(b, I16);
    if (!r) r = consumeToken(b, I32);
    if (!r) r = consumeToken(b, I64);
    if (!r) r = consumeToken(b, LIST);
    if (!r) r = consumeToken(b, MAP);
    if (!r) r = consumeToken(b, ONEWAY);
    if (!r) r = consumeToken(b, SET);
    if (!r) r = consumeToken(b, SLIST);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, VOID);
    if (!r) r = consumeToken(b, RIGHT_CURLY_BRACE);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = list_separator(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'throws' '(' fields_with_brace_recovery ')'
  public static boolean function_throws(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_throws")) return false;
    if (!nextTokenIs(b, THROWS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_THROWS, null);
    r = consumeTokens(b, 1, THROWS, LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, fields_with_brace_recovery(b, l + 1));
    r = p && consumeToken(b, RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'void' | type
  public static boolean function_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_TYPE, "<function type>");
    r = consumeToken(b, VOID);
    if (!r) r = type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ('include' | 'cpp_include') LITERAL
  public static boolean include_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_statement")) return false;
    if (!nextTokenIs(b, "<include statement>", CPP_INCLUDE, INCLUDE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INCLUDE_STATEMENT, "<include statement>");
    r = include_statement_0(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, LITERAL);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // 'include' | 'cpp_include'
  private static boolean include_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_statement_0")) return false;
    boolean r;
    r = consumeToken(b, INCLUDE);
    if (!r) r = consumeToken(b, CPP_INCLUDE);
    return r;
  }

  /* ********************************************************** */
  // ('+' | '-')? INTEGER
  public static boolean int_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_constant")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INT_CONSTANT, "<int constant>");
    r = int_constant_0(b, l + 1);
    r = r && consumeToken(b, INTEGER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('+' | '-')?
  private static boolean int_constant_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_constant_0")) return false;
    int_constant_0_0(b, l + 1);
    return true;
  }

  // '+' | '-'
  private static boolean int_constant_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_constant_0_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    return r;
  }

  /* ********************************************************** */
  // ',' | ';'
  public static boolean list_separator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_separator")) return false;
    if (!nextTokenIs(b, "<list separator>", COMMA, SEMICOLON)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LIST_SEPARATOR, "<list separator>");
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'list' '<' type '>' cpp_type_attr?
  public static boolean list_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_type")) return false;
    if (!nextTokenIs(b, LIST)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LIST_TYPE, null);
    r = consumeTokens(b, 1, LIST, LT);
    p = r; // pin = 1
    r = r && report_error_(b, type(b, l + 1));
    r = p && report_error_(b, consumeToken(b, GT)) && r;
    r = p && list_type_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // cpp_type_attr?
  private static boolean list_type_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_type_4")) return false;
    cpp_type_attr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'map' cpp_type_attr? '<' type ',' type '>'
  public static boolean map_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_type")) return false;
    if (!nextTokenIs(b, MAP)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MAP_TYPE, null);
    r = consumeToken(b, MAP);
    p = r; // pin = 1
    r = r && report_error_(b, map_type_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LT)) && r;
    r = p && report_error_(b, type(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, COMMA)) && r;
    r = p && report_error_(b, type(b, l + 1)) && r;
    r = p && consumeToken(b, GT) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // cpp_type_attr?
  private static boolean map_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_type_1")) return false;
    cpp_type_attr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // MULTIPLY | IDENTIFIER
  public static boolean namespace_scope(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_scope")) return false;
    if (!nextTokenIs(b, "<namespace scope>", IDENTIFIER, MULTIPLY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMESPACE_SCOPE, "<namespace scope>");
    r = consumeToken(b, MULTIPLY);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // std_namespace | php_namespace | xsd_namespace
  public static boolean namespace_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMESPACE_STATEMENT, "<namespace statement>");
    r = std_namespace(b, l + 1);
    if (!r) r = php_namespace(b, l + 1);
    if (!r) r = xsd_namespace(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'php_namespace' LITERAL
  static boolean php_namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "php_namespace")) return false;
    if (!nextTokenIs(b, PHP_NAMESPACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokens(b, 1, PHP_NAMESPACE, LITERAL);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // senum_field (list_separator? senum_field)*
  static boolean senum_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "senum_body")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = senum_field(b, l + 1);
    p = r; // pin = 1
    r = r && senum_body_1(b, l + 1);
    exit_section_(b, l, m, r, p, ThriftParser::senum_field_recovery);
    return r || p;
  }

  // (list_separator? senum_field)*
  private static boolean senum_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "senum_body_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!senum_body_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "senum_body_1", c)) break;
    }
    return true;
  }

  // list_separator? senum_field
  private static boolean senum_body_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "senum_body_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = senum_body_1_0_0(b, l + 1);
    r = r && senum_field(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // list_separator?
  private static boolean senum_body_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "senum_body_1_0_0")) return false;
    list_separator(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'senum' definition_name '{' senum_body? '}' type_annotations?
  public static boolean senum_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "senum_declaration")) return false;
    if (!nextTokenIs(b, SENUM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SENUM_DECLARATION, null);
    r = consumeToken(b, SENUM);
    p = r; // pin = 1
    r = r && report_error_(b, definition_name(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LEFT_CURLY_BRACE)) && r;
    r = p && report_error_(b, senum_declaration_3(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RIGHT_CURLY_BRACE)) && r;
    r = p && senum_declaration_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // senum_body?
  private static boolean senum_declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "senum_declaration_3")) return false;
    senum_body(b, l + 1);
    return true;
  }

  // type_annotations?
  private static boolean senum_declaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "senum_declaration_5")) return false;
    type_annotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LITERAL
  public static boolean senum_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "senum_field")) return false;
    if (!nextTokenIs(b, LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LITERAL);
    exit_section_(b, m, SENUM_FIELD, r);
    return r;
  }

  /* ********************************************************** */
  // !('}' | LITERAL)
  static boolean senum_field_recovery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "senum_field_recovery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !senum_field_recovery_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '}' | LITERAL
  private static boolean senum_field_recovery_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "senum_field_recovery_0")) return false;
    boolean r;
    r = consumeToken(b, RIGHT_CURLY_BRACE);
    if (!r) r = consumeToken(b, LITERAL);
    return r;
  }

  /* ********************************************************** */
  // (function list_separator?)*
  static boolean service_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "service_body")) return false;
    Marker m = enter_section_(b, l, _NONE_);
    while (true) {
      int c = current_position_(b);
      if (!service_body_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "service_body", c)) break;
    }
    exit_section_(b, l, m, true, false, ThriftParser::curly_brace_recovery);
    return true;
  }

  // function list_separator?
  private static boolean service_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "service_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function(b, l + 1);
    r = r && service_body_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // list_separator?
  private static boolean service_body_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "service_body_0_1")) return false;
    list_separator(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'service' definition_name ( 'extends' service_super_name )? '{' service_body '}' type_annotations?
  public static boolean service_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "service_declaration")) return false;
    if (!nextTokenIs(b, SERVICE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SERVICE_DECLARATION, null);
    r = consumeToken(b, SERVICE);
    p = r; // pin = 1
    r = r && report_error_(b, definition_name(b, l + 1));
    r = p && report_error_(b, service_declaration_2(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, LEFT_CURLY_BRACE)) && r;
    r = p && report_error_(b, service_body(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RIGHT_CURLY_BRACE)) && r;
    r = p && service_declaration_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( 'extends' service_super_name )?
  private static boolean service_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "service_declaration_2")) return false;
    service_declaration_2_0(b, l + 1);
    return true;
  }

  // 'extends' service_super_name
  private static boolean service_declaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "service_declaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    r = r && service_super_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // type_annotations?
  private static boolean service_declaration_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "service_declaration_6")) return false;
    type_annotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // custom_type
  public static boolean service_super_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "service_super_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = custom_type(b, l + 1);
    exit_section_(b, m, SERVICE_SUPER_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // 'set' cpp_type_attr? '<' type '>'
  public static boolean set_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_type")) return false;
    if (!nextTokenIs(b, SET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SET_TYPE, null);
    r = consumeToken(b, SET);
    p = r; // pin = 1
    r = r && report_error_(b, set_type_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LT)) && r;
    r = p && report_error_(b, type(b, l + 1)) && r;
    r = p && consumeToken(b, GT) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // cpp_type_attr?
  private static boolean set_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "set_type_1")) return false;
    cpp_type_attr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'bool' | 'byte' | 'i8' | 'i16' | 'i32' | 'i64' | 'double' | 'string' | 'binary' | 'slist'
  static boolean simple_base_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_base_type")) return false;
    boolean r;
    r = consumeToken(b, BOOL);
    if (!r) r = consumeToken(b, BYTE);
    if (!r) r = consumeToken(b, I8);
    if (!r) r = consumeToken(b, I16);
    if (!r) r = consumeToken(b, I32);
    if (!r) r = consumeToken(b, I64);
    if (!r) r = consumeToken(b, DOUBLE);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, BINARY);
    if (!r) r = consumeToken(b, SLIST);
    return r;
  }

  /* ********************************************************** */
  // include_statement
  //     | namespace_statement
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    r = include_statement(b, l + 1);
    if (!r) r = namespace_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'namespace' (namespace_scope (IDENTIFIER | LITERAL))
  static boolean std_namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "std_namespace")) return false;
    if (!nextTokenIs(b, NAMESPACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, NAMESPACE);
    p = r; // pin = 1
    r = r && std_namespace_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // namespace_scope (IDENTIFIER | LITERAL)
  private static boolean std_namespace_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "std_namespace_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = namespace_scope(b, l + 1);
    r = r && std_namespace_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER | LITERAL
  private static boolean std_namespace_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "std_namespace_1_1")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, LITERAL);
    return r;
  }

  /* ********************************************************** */
  // 'struct' definition_name 'xsd_all'? '{' fields_body '}' type_annotations?
  public static boolean struct_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_declaration")) return false;
    if (!nextTokenIs(b, STRUCT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_DECLARATION, null);
    r = consumeToken(b, STRUCT);
    p = r; // pin = 1
    r = r && report_error_(b, definition_name(b, l + 1));
    r = p && report_error_(b, struct_declaration_2(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, LEFT_CURLY_BRACE)) && r;
    r = p && report_error_(b, fields_body(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RIGHT_CURLY_BRACE)) && r;
    r = p && struct_declaration_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // 'xsd_all'?
  private static boolean struct_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_declaration_2")) return false;
    consumeToken(b, XSD_ALL);
    return true;
  }

  // type_annotations?
  private static boolean struct_declaration_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_declaration_6")) return false;
    type_annotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // statement | declaration
  static boolean top_level_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_level_element")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = statement(b, l + 1);
    if (!r) r = declaration(b, l + 1);
    exit_section_(b, l, m, r, false, ThriftParser::top_level_recover);
    return r;
  }

  /* ********************************************************** */
  // !('const' | 'cpp_include' | 'enum' | 'exception' | 'include' | 'namespace' |
  //                               'php_namespace' | 'senum' | 'service' | 'struct' | 'typedef' | 'union' |
  //                               'xsd_namespace' )
  static boolean top_level_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_level_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !top_level_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'const' | 'cpp_include' | 'enum' | 'exception' | 'include' | 'namespace' |
  //                               'php_namespace' | 'senum' | 'service' | 'struct' | 'typedef' | 'union' |
  //                               'xsd_namespace'
  private static boolean top_level_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_level_recover_0")) return false;
    boolean r;
    r = consumeToken(b, CONST);
    if (!r) r = consumeToken(b, CPP_INCLUDE);
    if (!r) r = consumeToken(b, ENUM);
    if (!r) r = consumeToken(b, EXCEPTION);
    if (!r) r = consumeToken(b, INCLUDE);
    if (!r) r = consumeToken(b, NAMESPACE);
    if (!r) r = consumeToken(b, PHP_NAMESPACE);
    if (!r) r = consumeToken(b, SENUM);
    if (!r) r = consumeToken(b, SERVICE);
    if (!r) r = consumeToken(b, STRUCT);
    if (!r) r = consumeToken(b, TYPEDEF);
    if (!r) r = consumeToken(b, UNION);
    if (!r) r = consumeToken(b, XSD_NAMESPACE);
    return r;
  }

  /* ********************************************************** */
  // base_type | container_type | custom_type
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, TYPE, "<type>");
    r = base_type(b, l + 1);
    if (!r) r = container_type(b, l + 1);
    if (!r) r = custom_type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ('=' LITERAL list_separator?)?
  public static boolean type_annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_annotation")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && type_annotation_1(b, l + 1);
    exit_section_(b, m, TYPE_ANNOTATION, r);
    return r;
  }

  // ('=' LITERAL list_separator?)?
  private static boolean type_annotation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_annotation_1")) return false;
    type_annotation_1_0(b, l + 1);
    return true;
  }

  // '=' LITERAL list_separator?
  private static boolean type_annotation_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_annotation_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, EQUALS, LITERAL);
    r = r && type_annotation_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // list_separator?
  private static boolean type_annotation_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_annotation_1_0_2")) return false;
    list_separator(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // type_annotation*
  public static boolean type_annotation_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_annotation_list")) return false;
    Marker m = enter_section_(b, l, _NONE_, TYPE_ANNOTATION_LIST, "<type annotation list>");
    while (true) {
      int c = current_position_(b);
      if (!type_annotation(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_annotation_list", c)) break;
    }
    exit_section_(b, l, m, true, false, ThriftParser::brace_recovery);
    return true;
  }

  /* ********************************************************** */
  // '(' type_annotation_list ')'
  public static boolean type_annotations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_annotations")) return false;
    if (!nextTokenIs(b, LEFT_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACE);
    r = r && type_annotation_list(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, TYPE_ANNOTATIONS, r);
    return r;
  }

  /* ********************************************************** */
  // 'typedef' type definition_name type_annotations?
  public static boolean type_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_declaration")) return false;
    if (!nextTokenIs(b, TYPEDEF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPE_DECLARATION, null);
    r = consumeToken(b, TYPEDEF);
    p = r; // pin = 1
    r = r && report_error_(b, type(b, l + 1));
    r = p && report_error_(b, definition_name(b, l + 1)) && r;
    r = p && type_declaration_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // type_annotations?
  private static boolean type_declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_declaration_3")) return false;
    type_annotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'union' definition_name 'xsd_all'? '{' fields_body '}' type_annotations?
  public static boolean union_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_declaration")) return false;
    if (!nextTokenIs(b, UNION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UNION_DECLARATION, null);
    r = consumeToken(b, UNION);
    p = r; // pin = 1
    r = r && report_error_(b, definition_name(b, l + 1));
    r = p && report_error_(b, union_declaration_2(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, LEFT_CURLY_BRACE)) && r;
    r = p && report_error_(b, fields_body(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RIGHT_CURLY_BRACE)) && r;
    r = p && union_declaration_6(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // 'xsd_all'?
  private static boolean union_declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_declaration_2")) return false;
    consumeToken(b, XSD_ALL);
    return true;
  }

  // type_annotations?
  private static boolean union_declaration_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_declaration_6")) return false;
    type_annotations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'xsd_namespace' LITERAL
  static boolean xsd_namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xsd_namespace")) return false;
    if (!nextTokenIs(b, XSD_NAMESPACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokens(b, 1, XSD_NAMESPACE, LITERAL);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

}
