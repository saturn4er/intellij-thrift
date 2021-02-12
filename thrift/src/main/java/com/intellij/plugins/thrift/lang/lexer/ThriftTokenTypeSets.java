package com.intellij.plugins.thrift.lang.lexer;

import com.intellij.plugins.thrift.ThriftLanguage;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;

import static com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes.*;

public interface ThriftTokenTypeSets {
  IFileElementType THRIFT_FILE = new IFileElementType("THRIFT_FILE", ThriftLanguage.INSTANCE);

  TokenSet WHITESPACES = TokenSet.WHITE_SPACE;
  TokenSet COMMENTS = TokenSet.create(
          COMMENT,
          BLOCK_COMMENT
  );
  TokenSet STRINGS = TokenSet.create(
          LITERAL
  );
  TokenSet OPERATORS = TokenSet.create(
          PLUS,
          MULTIPLY, MINUS
  );

  TokenSet BAD_TOKENS = TokenSet.create(
          TokenType.BAD_CHARACTER
  );

  TokenSet CONTAINER_TYPE = TokenSet.create(
          MAP_TYPE,
          LIST_TYPE,
          SET_TYPE
  );

  TokenSet DECLARATIONS = TokenSet.create(
          CONST_DECLARATION,
          ENUM_DECLARATION,
          TYPE_DECLARATION,
          STRUCT_DECLARATION,
          SENUM_DECLARATION,
          UNION_DECLARATION,
          SERVICE_DECLARATION,
          EXCEPTION_DECLARATION
  );

  TokenSet BASE_TYPES = TokenSet.create(
          I8, I16, I32, I64, DOUBLE, STRING, BINARY, SLIST, LIST, MAP, BOOL, BYTE, SET
  );

  TokenSet KEYWORDS = TokenSet.create(
          MAP, SET, LIST, CPP_TYPE, BOOL, BYTE,
          I8, I16, I32, I64, DOUBLE, STRING, BINARY, SLIST,
          INCLUDE, CPP_INCLUDE, NAMESPACE, XSD_NAMESPACE, PHP_NAMESPACE,
          ENUM, SENUM, SERVICE, EXTENDS, EXCEPTION, STRUCT, TYPEDEF, UNION, CONST, XSD_ALL, VOID, THROWS, ONEWAY,
          REQUIRED, OPTIONAL, XSD_OPTIONAL, XSD_NILLABLE, XSD_ATTRS
  );
}

