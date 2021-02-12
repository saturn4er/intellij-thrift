// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.lexer;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.plugins.thrift.lang.psi.impl.*;

public interface ThriftTokenTypes {

  IElementType ANNOTATED_TYPE = new ThriftElementType("ANNOTATED_TYPE");
  IElementType BASE_TYPE = new ThriftElementType("BASE_TYPE");
  IElementType CONST_DECLARATION = new ThriftElementType("CONST_DECLARATION");
  IElementType CONST_LIST = new ThriftElementType("CONST_LIST");
  IElementType CONST_MAP = new ThriftElementType("CONST_MAP");
  IElementType CONST_MAP_ITEM = new ThriftElementType("CONST_MAP_ITEM");
  IElementType CONST_VALUE = new ThriftElementType("CONST_VALUE");
  IElementType CONTAINER_TYPE = new ThriftElementType("CONTAINER_TYPE");
  IElementType CPP_TYPE_ATTR = new ThriftElementType("CPP_TYPE_ATTR");
  IElementType CUSTOM_TYPE = new ThriftElementType("CUSTOM_TYPE");
  IElementType DEFINITION_NAME = new ThriftElementType("DEFINITION_NAME");
  IElementType DOUBLE_CONSTANT = new ThriftElementType("DOUBLE_CONSTANT");
  IElementType ENUM_DECLARATION = new ThriftElementType("ENUM_DECLARATION");
  IElementType ENUM_FIELD = new ThriftElementType("ENUM_FIELD");
  IElementType EXCEPTION_DECLARATION = new ThriftElementType("EXCEPTION_DECLARATION");
  IElementType FIELD = new ThriftElementType("FIELD");
  IElementType FIELD_ID = new ThriftElementType("FIELD_ID");
  IElementType FIELD_REQ = new ThriftElementType("FIELD_REQ");
  IElementType FIELD_XDF_ATTRS = new ThriftElementType("FIELD_XDF_ATTRS");
  IElementType FUNCTION = new ThriftElementType("FUNCTION");
  IElementType FUNCTION_THROWS = new ThriftElementType("FUNCTION_THROWS");
  IElementType FUNCTION_TYPE = new ThriftElementType("FUNCTION_TYPE");
  IElementType INCLUDE_STATEMENT = new ThriftElementType("INCLUDE_STATEMENT");
  IElementType INT_CONSTANT = new ThriftElementType("INT_CONSTANT");
  IElementType LIST_SEPARATOR = new ThriftElementType("LIST_SEPARATOR");
  IElementType LIST_TYPE = new ThriftElementType("LIST_TYPE");
  IElementType MAP_TYPE = new ThriftElementType("MAP_TYPE");
  IElementType NAMESPACE_SCOPE = new ThriftElementType("NAMESPACE_SCOPE");
  IElementType NAMESPACE_STATEMENT = new ThriftElementType("NAMESPACE_STATEMENT");
  IElementType SENUM_DECLARATION = new ThriftElementType("SENUM_DECLARATION");
  IElementType SENUM_FIELD = new ThriftElementType("SENUM_FIELD");
  IElementType SERVICE_DECLARATION = new ThriftElementType("SERVICE_DECLARATION");
  IElementType SERVICE_SUPER_NAME = new ThriftElementType("SERVICE_SUPER_NAME");
  IElementType SET_TYPE = new ThriftElementType("SET_TYPE");
  IElementType STRUCT_DECLARATION = new ThriftElementType("STRUCT_DECLARATION");
  IElementType TYPE = new ThriftElementType("TYPE");
  IElementType TYPE_ANNOTATION = new ThriftElementType("TYPE_ANNOTATION");
  IElementType TYPE_ANNOTATIONS = new ThriftElementType("TYPE_ANNOTATIONS");
  IElementType TYPE_ANNOTATION_RECOVERY = new ThriftElementType("TYPE_ANNOTATION_RECOVERY");
  IElementType TYPE_DECLARATION = new ThriftElementType("TYPE_DECLARATION");
  IElementType UNION_DECLARATION = new ThriftElementType("UNION_DECLARATION");

  IElementType BINARY = new ThriftElementType("binary");
  IElementType BLOCK_COMMENT = new ThriftElementType("BLOCK_COMMENT");
  IElementType BOOL = new ThriftElementType("bool");
  IElementType BYTE = new ThriftElementType("byte");
  IElementType COLON = new ThriftElementType(":");
  IElementType COMMA = new ThriftElementType(",");
  IElementType COMMENT = new ThriftElementType("COMMENT");
  IElementType CONST = new ThriftElementType("const");
  IElementType CPP_INCLUDE = new ThriftElementType("cpp_include");
  IElementType CPP_TYPE = new ThriftElementType("cpp_type");
  IElementType DOUBLE = new ThriftElementType("double");
  IElementType ENUM = new ThriftElementType("enum");
  IElementType EQUALS = new ThriftElementType("=");
  IElementType EXCEPTION = new ThriftElementType("exception");
  IElementType EXTENDS = new ThriftElementType("extends");
  IElementType FLOAT_NUMBER = new ThriftElementType("FLOAT_NUMBER");
  IElementType GT = new ThriftElementType(">");
  IElementType HEX_NUMBER = new ThriftElementType("HEX_NUMBER");
  IElementType I16 = new ThriftElementType("i16");
  IElementType I32 = new ThriftElementType("i32");
  IElementType I64 = new ThriftElementType("i64");
  IElementType I8 = new ThriftElementType("i8");
  IElementType IDENTIFIER = new ThriftElementType("IDENTIFIER");
  IElementType INCLUDE = new ThriftElementType("include");
  IElementType INT_NUMBER = new ThriftElementType("INT_NUMBER");
  IElementType LEFT_BRACE = new ThriftElementType("(");
  IElementType LEFT_BRACKET = new ThriftElementType("[");
  IElementType LEFT_CURLY_BRACE = new ThriftElementType("{");
  IElementType LIST = new ThriftElementType("list");
  IElementType LITERAL = new ThriftElementType("LITERAL");
  IElementType LT = new ThriftElementType("<");
  IElementType MAP = new ThriftElementType("map");
  IElementType MINUS = new ThriftElementType("-");
  IElementType MULTIPLY = new ThriftElementType("*");
  IElementType NAMESPACE = new ThriftElementType("namespace");
  IElementType ONEWAY = new ThriftElementType("oneway");
  IElementType OPTIONAL = new ThriftElementType("optional");
  IElementType PHP_NAMESPACE = new ThriftElementType("php_namespace");
  IElementType PLUS = new ThriftElementType("+");
  IElementType REQUIRED = new ThriftElementType("required");
  IElementType RIGHT_BRACE = new ThriftElementType(")");
  IElementType RIGHT_BRACKET = new ThriftElementType("]");
  IElementType RIGHT_CURLY_BRACE = new ThriftElementType("}");
  IElementType SEMICOLON = new ThriftElementType(";");
  IElementType SENUM = new ThriftElementType("senum");
  IElementType SERVICE = new ThriftElementType("service");
  IElementType SET = new ThriftElementType("set");
  IElementType SLIST = new ThriftElementType("slist");
  IElementType STRING = new ThriftElementType("string");
  IElementType STRUCT = new ThriftElementType("struct");
  IElementType THROWS = new ThriftElementType("throws");
  IElementType TYPEDEF = new ThriftElementType("typedef");
  IElementType UNION = new ThriftElementType("union");
  IElementType VOID = new ThriftElementType("void");
  IElementType XSD_ALL = new ThriftElementType("xsd_all");
  IElementType XSD_ATTRS = new ThriftElementType("xsd_attrs");
  IElementType XSD_NAMESPACE = new ThriftElementType("xsd_namespace");
  IElementType XSD_NILLABLE = new ThriftElementType("xsd_nillable");
  IElementType XSD_OPTIONAL = new ThriftElementType("xsd_optional");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANNOTATED_TYPE) {
        return new ThriftAnnotatedTypeImpl(node);
      }
      else if (type == BASE_TYPE) {
        return new ThriftBaseTypeImpl(node);
      }
      else if (type == CONST_DECLARATION) {
        return new ThriftConstDeclarationImpl(node);
      }
      else if (type == CONST_LIST) {
        return new ThriftConstListImpl(node);
      }
      else if (type == CONST_MAP) {
        return new ThriftConstMapImpl(node);
      }
      else if (type == CONST_MAP_ITEM) {
        return new ThriftConstMapItemImpl(node);
      }
      else if (type == CONST_VALUE) {
        return new ThriftConstValueImpl(node);
      }
      else if (type == CPP_TYPE_ATTR) {
        return new ThriftCppTypeAttrImpl(node);
      }
      else if (type == CUSTOM_TYPE) {
        return new ThriftCustomTypeImpl(node);
      }
      else if (type == DEFINITION_NAME) {
        return new ThriftDefinitionNameImpl(node);
      }
      else if (type == DOUBLE_CONSTANT) {
        return new ThriftDoubleConstantImpl(node);
      }
      else if (type == ENUM_DECLARATION) {
        return new ThriftEnumDeclarationImpl(node);
      }
      else if (type == ENUM_FIELD) {
        return new ThriftEnumFieldImpl(node);
      }
      else if (type == EXCEPTION_DECLARATION) {
        return new ThriftExceptionDeclarationImpl(node);
      }
      else if (type == FIELD) {
        return new ThriftFieldImpl(node);
      }
      else if (type == FIELD_ID) {
        return new ThriftFieldIdImpl(node);
      }
      else if (type == FIELD_REQ) {
        return new ThriftFieldReqImpl(node);
      }
      else if (type == FIELD_XDF_ATTRS) {
        return new ThriftFieldXdfAttrsImpl(node);
      }
      else if (type == FUNCTION) {
        return new ThriftFunctionImpl(node);
      }
      else if (type == FUNCTION_THROWS) {
        return new ThriftFunctionThrowsImpl(node);
      }
      else if (type == FUNCTION_TYPE) {
        return new ThriftFunctionTypeImpl(node);
      }
      else if (type == INCLUDE_STATEMENT) {
        return new ThriftIncludeStatementImpl(node);
      }
      else if (type == INT_CONSTANT) {
        return new ThriftIntConstantImpl(node);
      }
      else if (type == LIST_SEPARATOR) {
        return new ThriftListSeparatorImpl(node);
      }
      else if (type == LIST_TYPE) {
        return new ThriftListTypeImpl(node);
      }
      else if (type == MAP_TYPE) {
        return new ThriftMapTypeImpl(node);
      }
      else if (type == NAMESPACE_SCOPE) {
        return new ThriftNamespaceScopeImpl(node);
      }
      else if (type == NAMESPACE_STATEMENT) {
        return new ThriftNamespaceStatementImpl(node);
      }
      else if (type == SENUM_DECLARATION) {
        return new ThriftSenumDeclarationImpl(node);
      }
      else if (type == SENUM_FIELD) {
        return new ThriftSenumFieldImpl(node);
      }
      else if (type == SERVICE_DECLARATION) {
        return new ThriftServiceDeclarationImpl(node);
      }
      else if (type == SERVICE_SUPER_NAME) {
        return new ThriftServiceSuperNameImpl(node);
      }
      else if (type == SET_TYPE) {
        return new ThriftSetTypeImpl(node);
      }
      else if (type == STRUCT_DECLARATION) {
        return new ThriftStructDeclarationImpl(node);
      }
      else if (type == TYPE_ANNOTATION) {
        return new ThriftTypeAnnotationImpl(node);
      }
      else if (type == TYPE_ANNOTATIONS) {
        return new ThriftTypeAnnotationsImpl(node);
      }
      else if (type == TYPE_ANNOTATION_RECOVERY) {
        return new ThriftTypeAnnotationRecoveryImpl(node);
      }
      else if (type == TYPE_DECLARATION) {
        return new ThriftTypeDeclarationImpl(node);
      }
      else if (type == UNION_DECLARATION) {
        return new ThriftUnionDeclarationImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
