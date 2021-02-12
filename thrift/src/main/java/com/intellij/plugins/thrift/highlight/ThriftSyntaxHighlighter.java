package com.intellij.plugins.thrift.highlight;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.plugins.thrift.lang.ThriftElementFactory;
import com.intellij.plugins.thrift.lang.lexer.ThriftElementType;
import com.intellij.plugins.thrift.lang.lexer.ThriftLexer;
import com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypeSets;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypeSets.BAD_TOKENS;
import static com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypeSets.OPERATORS;
import static com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes.*;

/**
 * Created by fkorotkov.
 */
public class ThriftSyntaxHighlighter extends SyntaxHighlighterBase {
  private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<IElementType, TextAttributesKey>();

  static {
    fillMap(ATTRIBUTES, OPERATORS, ThriftSyntaxHighlighterColors.OPERATION_SIGN);

    ATTRIBUTES.put(INT_NUMBER, ThriftSyntaxHighlighterColors.NUMBER);
    ATTRIBUTES.put(FLOAT_NUMBER, ThriftSyntaxHighlighterColors.NUMBER);
    ATTRIBUTES.put(HEX_NUMBER, ThriftSyntaxHighlighterColors.NUMBER);


    ATTRIBUTES.put(LITERAL, ThriftSyntaxHighlighterColors.STRING);

    ATTRIBUTES.put(LEFT_BRACE, ThriftSyntaxHighlighterColors.PARENTHS);
    ATTRIBUTES.put(RIGHT_BRACE, ThriftSyntaxHighlighterColors.PARENTHS);

    ATTRIBUTES.put(LEFT_CURLY_BRACE, ThriftSyntaxHighlighterColors.BRACES);
    ATTRIBUTES.put(RIGHT_CURLY_BRACE, ThriftSyntaxHighlighterColors.BRACES);

    ATTRIBUTES.put(LEFT_BRACKET, ThriftSyntaxHighlighterColors.BRACKETS);
    ATTRIBUTES.put(RIGHT_BRACKET, ThriftSyntaxHighlighterColors.BRACKETS);

    ATTRIBUTES.put(COMMA, ThriftSyntaxHighlighterColors.COMMA);
    ATTRIBUTES.put(SEMICOLON, ThriftSyntaxHighlighterColors.SEMICOLON);

    ATTRIBUTES.put(BLOCK_COMMENT, ThriftSyntaxHighlighterColors.BLOCK_COMMENT);
    ATTRIBUTES.put(COMMENT, ThriftSyntaxHighlighterColors.LINE_COMMENT);

    fillMap(ATTRIBUTES, BAD_TOKENS, ThriftSyntaxHighlighterColors.BAD_CHARACTER);
  }


  @NotNull
  public Lexer getHighlightingLexer() {
    return new ThriftLexer();
  }

  @NotNull
  public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
    if(ThriftTokenTypeSets.KEYWORDS.contains(tokenType)){
        return pack(ThriftSyntaxHighlighterColors.KEYWORD);
    }
    
    return pack(ATTRIBUTES.get(tokenType));
  }
}
