package com.intellij.plugins.thrift.formatter.blocks;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.plugins.thrift.ThriftLanguage;
import com.intellij.plugins.thrift.formatter.ThriftFormattingModelBuilder;
import com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypeSets;
import com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes;
import com.intellij.plugins.thrift.lang.psi.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes.*;

public class ThriftFmtBlock implements ASTBlock {
  ASTNode node;
  Alignment alignment;
  Indent indent;
  Wrap wrap;
  CodeStyleSettings settings;


  public ThriftFmtBlock(ASTNode node, Alignment alignment, Indent indent, Wrap wrap, CodeStyleSettings settings) {
    this.node = node;
    this.alignment = alignment;
    this.indent = indent;
    this.wrap = wrap;
    this.settings = settings;
  }

  @Override
  public @Nullable ASTNode getNode() {
    return node;
  }

  @Override
  public @NotNull TextRange getTextRange() {
    return node.getTextRange();
  }

  @Override
  public @NotNull List<Block> getSubBlocks() {
    return Arrays.stream(node.getChildren(null))
            .filter(c -> !ThriftTokenTypeSets.WHITESPACES.contains(c.getElementType()))
            .map(c -> ThriftFormattingModelBuilder.buildBlock(
                    c,
                    null,
                    computeIndent(c),
                    wrap,
                    settings
            ))
            .collect(Collectors.toList());
  }

  @Override
  public @Nullable Wrap getWrap() {
    return wrap;
  }

  @Override
  public @Nullable Indent getIndent() {
    return indent;
  }

  @Override
  public @Nullable Alignment getAlignment() {
    return alignment;
  }

  @Override
  public @Nullable Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
    return new SpacingBuilder(settings, ThriftLanguage.INSTANCE)
            // declarations
            .after(ThriftTokenTypeSets.DECLARATIONS).blankLines(1)
            .after(NAMESPACE).spaces(1)
            .after(NAMESPACE_SCOPE).spaces(1)
            .after(TYPEDEF).spaces(1)
            .aroundInside(DEFINITION_NAME, ThriftTokenTypeSets.DECLARATIONS).spaces(1)

            // field
//            .after(FIELD_ID).spaces(1)
            .beforeInside(COLON, FIELD_ID).none()
            .after(FIELD_ID).spaces(1)
            .beforeInside(DEFINITION_NAME, FIELD).spaces(1)
            .beforeInside(LIST_SEPARATOR, FIELD).none()
            .betweenInside(DEFINITION_NAME, LIST_SEPARATOR, FIELD).none()

            // function
            .between(FUNCTION_TYPE, DEFINITION_NAME).spaces(1)
            .between(ONEWAY, FUNCTION_TYPE).spaces(1)

            // throws
            .between(THROWS, LEFT_BRACE).spaces(1)

            // type
            .aroundInside(TYPE, FIELD).spaces(1)
            .aroundInside(TYPE, CONST).spaces(1)
            // map
            .afterInside(LT, ThriftTokenTypeSets.CONTAINER_TYPE).none()
            .beforeInside(GT, ThriftTokenTypeSets.CONTAINER_TYPE).none()

            // const values
            .betweenInside(CONST_VALUE, LIST_SEPARATOR, CONST_LIST).none()
            .betweenInside(CONST_VALUE, LIST_SEPARATOR, CONST_MAP).none()
            .betweenInside(LIST_SEPARATOR, CONST_VALUE, CONST_MAP).spaces(1)

            .around(EQUALS).spaces(1)
            .before(SEMICOLON).none()
            .after(COMMA).spaces(1)
            .before(COMMA).none()
            .after(COLON).spaces(1)
            .before(COLON).none()

            .getSpacing(this, child1, child2);
  }

  @Override
  public @NotNull ChildAttributes getChildAttributes(int newChildIndex) {
    if (isLeaf()) {
      if (TokenSet.create(RIGHT_BRACKET, RIGHT_CURLY_BRACE, RIGHT_BRACE).contains(node.getElementType())) {
        return new ChildAttributes(Indent.getNormalIndent(), alignment);
      }

      return new ChildAttributes(Indent.getNoneIndent(), null);
    }

    return ChildAttributes.DELEGATE_TO_NEXT_CHILD;
  }

  @Override
  public boolean isIncomplete() {
    return false;
  }

  @Override
  public boolean isLeaf() {
    return Arrays.stream(node.getChildren(null))
            .allMatch(c -> ThriftTokenTypeSets.WHITESPACES.contains(c.getElementType()));
  }

  private Indent computeIndent(ASTNode childNode) {
    PsiElement childNodePsi = childNode.getPsi();
    if (childNodePsi instanceof ThriftField
            || childNodePsi instanceof ThriftFunction
            || childNodePsi instanceof ThriftSenumField
            || childNodePsi instanceof ThriftEnumField
            || childNodePsi instanceof ThriftFunctionThrows
            || childNodePsi instanceof ThriftConstMapItem
            || childNodePsi instanceof ThriftTypeAnnotation
    ) {
      return Indent.getNormalIndent();
    }

    return Indent.getNoneIndent();
  }
}
