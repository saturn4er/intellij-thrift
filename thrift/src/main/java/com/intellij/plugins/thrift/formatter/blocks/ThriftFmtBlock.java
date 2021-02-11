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
            .after(ThriftTokenTypes.NAMESPACE).spaces(1)
            .after(ThriftTokenTypes.NAMESPACE_SCOPE).spaces(1)
            .after(ThriftTokenTypes.TYPEDEF).spaces(1)
            .aroundInside(ThriftTokenTypes.DEFINITION_NAME, ThriftTokenTypeSets.DECLARATIONS).spaces(1)

            // field
//            .after(ThriftTokenTypes.FIELD_ID).spaces(1)
            .beforeInside(ThriftTokenTypes.COLON, ThriftTokenTypes.FIELD_ID).none()
            .after(ThriftTokenTypes.FIELD_ID).spaces(1)
            .beforeInside(ThriftTokenTypes.DEFINITION_NAME, ThriftTokenTypes.FIELD).spaces(1)
            .beforeInside(ThriftTokenTypes.LIST_SEPARATOR, ThriftTokenTypes.FIELD).none()
            .betweenInside(ThriftTokenTypes.DEFINITION_NAME, ThriftTokenTypes.LIST_SEPARATOR, ThriftTokenTypes.FIELD).none()

            // function
            .between(ThriftTokenTypes.FUNCTION_TYPE, ThriftTokenTypes.DEFINITION_NAME).spaces(1)
            .between(ThriftTokenTypes.ONEWAY, ThriftTokenTypes.FUNCTION_TYPE).spaces(1)

            // throws
            .between(ThriftTokenTypes.THROWS, ThriftTokenTypes.LEFT_BRACE).spaces(1)

            // type
            .aroundInside(ThriftTokenTypes.TYPE, ThriftTokenTypes.FIELD).spaces(1)
            .aroundInside(ThriftTokenTypes.TYPE, ThriftTokenTypes.CONST).spaces(1)
            // map
            .afterInside(ThriftTokenTypes.LT, ThriftTokenTypeSets.CONTAINER_TYPE).none()
            .beforeInside(ThriftTokenTypes.GT, ThriftTokenTypeSets.CONTAINER_TYPE).none()

            // const values
            .betweenInside(ThriftTokenTypes.CONST_VALUE, ThriftTokenTypes.LIST_SEPARATOR, ThriftTokenTypes.CONST_LIST).none()
            .betweenInside(ThriftTokenTypes.CONST_VALUE, ThriftTokenTypes.LIST_SEPARATOR, ThriftTokenTypes.CONST_MAP).none()
            .betweenInside(ThriftTokenTypes.LIST_SEPARATOR, ThriftTokenTypes.CONST_VALUE, ThriftTokenTypes.CONST_MAP).spaces(1)

            .around(ThriftTokenTypes.EQUALS).spaces(1)
            .before(ThriftTokenTypes.SEMICOLON).none()
            .after(ThriftTokenTypes.COMMA).spaces(1)
            .before(ThriftTokenTypes.COMMA).none()
            .after(ThriftTokenTypes.COLON).spaces(1)
            .before(ThriftTokenTypes.COLON).none()

            .getSpacing(this, child1, child2);
  }

  @Override
  public @NotNull ChildAttributes getChildAttributes(int newChildIndex) {
    return new ChildAttributes(Indent.getAbsoluteNoneIndent(), Alignment.createAlignment());
  }

  @Override
  public boolean isIncomplete() {
    return false;
  }

  @Override
  public boolean isLeaf() {
    return node.getFirstChildNode() == null;
  }

  private Indent computeIndent(ASTNode childNode) {
    PsiElement childNodePsi = childNode.getPsi();
    if (childNodePsi instanceof ThriftField
            || childNodePsi instanceof ThriftFunction
            || childNodePsi instanceof ThriftSenumField
            || childNodePsi instanceof ThriftEnumField
            || childNodePsi instanceof ThriftFunctionThrows
    ) {
      return Indent.getNormalIndent();
    }

    return Indent.getNoneIndent();
  }
}
