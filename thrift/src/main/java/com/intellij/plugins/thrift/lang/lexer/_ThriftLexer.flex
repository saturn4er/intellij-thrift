package com.intellij.plugins.thrift.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes.*;

%%

%{
  public _ThriftLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _ThriftLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

SPACE=[ \t\n\x0B\f\r]+
COMMENT=#[^\r\n]*
BLOCK_COMMENT="/*" .* "*/"
LITERAL=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
IDENTIFIER=[\p{Alpha}_][\p{Alnum}._-]*
INTEGER=[0-9]+
NUMBER=[0-9]+(\.[0-9]*)?

%%
<YYINITIAL> {
  {WHITE_SPACE}        { return WHITE_SPACE; }
  {COMMENT}            { return COMMENT; }
  {BLOCK_COMMENT}      { return BLOCK_COMMENT; }

  "{"                  { return LEFT_CURLY_BRACE; }
  "}"                  { return RIGHT_CURLY_BRACE; }
  "["                  { return LEFT_BRACKET; }
  "]"                  { return RIGHT_BRACKET; }
  "("                  { return LEFT_BRACE; }
  ")"                  { return RIGHT_BRACE; }
  "="                  { return EQUALS; }
  ";"                  { return SEMICOLON; }
  ":"                  { return COLON; }
  "<"                  { return LT; }
  ">"                  { return GT; }
  ","                  { return COMMA; }
  "+"                  { return PLUS; }
  "-"                  { return MINUS; }
  "*"                  { return MULTIPLY; }
  "map"                { return MAP; }
  "set"                { return SET; }
  "list"               { return LIST; }
  "cpp_type"           { return CPP_TYPE; }
  "bool"               { return BOOL; }
  "byte"               { return BYTE; }
  "i8"                 { return I8; }
  "i16"                { return I16; }
  "i32"                { return I32; }
  "i64"                { return I64; }
  "double"             { return DOUBLE; }
  "string"             { return STRING; }
  "binary"             { return BINARY; }
  "slist"              { return SLIST; }
  "include"            { return INCLUDE; }
  "cpp_include"        { return CPP_INCLUDE; }
  "namespace"          { return NAMESPACE; }
  "xsd_namespace"      { return XSD_NAMESPACE; }
  "php_namespace"      { return PHP_NAMESPACE; }
  "enum"               { return ENUM; }
  "senum"              { return SENUM; }
  "service"            { return SERVICE; }
  "extends"            { return EXTENDS; }
  "exception"          { return EXCEPTION; }
  "struct"             { return STRUCT; }
  "typedef"            { return TYPEDEF; }
  "union"              { return UNION; }
  "const"              { return CONST; }
  "xsd_all"            { return XSD_ALL; }
  "void"               { return VOID; }
  "throws"             { return THROWS; }
  "oneway"             { return ONEWAY; }
  "required"           { return REQUIRED; }
  "optional"           { return OPTIONAL; }
  "xsd_optional"       { return XSD_OPTIONAL; }
  "xsd_nillable"       { return XSD_NILLABLE; }
  "xsd_attrs"          { return XSD_ATTRS; }

  {SPACE}              { return SPACE; }
  {LITERAL}            { return LITERAL; }
  {IDENTIFIER}         { return IDENTIFIER; }
  {INTEGER}            { return INTEGER; }
  {NUMBER}             { return NUMBER; }

}


[^] { return BAD_CHARACTER; }
