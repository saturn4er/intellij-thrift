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
                    null,
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
            .around(ThriftTokenTypes.EQUALS).spaces(1)
            .after(ThriftTokenTypes.FIELD_ID).spaces(1)
            .after(ThriftTokenTypes.LIST_SEPARATOR).spaces(1)
            .around(ThriftTokenTypes.NAMESPACE_SCOPE).spaces(1)
            .around(ThriftTokenTypes.CUSTOM_TYPE).spaces(1)
            .afterInside(ThriftTokenTypes.DEFINITION_NAME, ThriftTokenTypes.FUNCTION).none()
            .afterInside(ThriftTokenTypes.DEFINITION_NAME, ThriftTokenTypes.FIELD).none()
            .afterInside(ThriftTokenTypes.IDENTIFIER, ThriftTokenTypes.INCLUDE).spaces(1)
            .around(ThriftTokenTypes.FIELD_TYPE).spaces(1)
            .withinPairInside(ThriftTokenTypes.FIELD_ID,ThriftTokenTypes.DEFINITION_NAME, ThriftTokenTypes.FIELD).spaces(1)
            .aroundInside(ThriftTokenTypes.DEFINITION_NAME, ThriftTokenTypes.STRUCT).spaces(1)
            .aroundInside(ThriftTokenTypes.DEFINITION_NAME, ThriftTokenTypes.EXCEPTION).spaces(1)
            .aroundInside(ThriftTokenTypes.DEFINITION_NAME, ThriftTokenTypes.SENUM).spaces(1)
            .aroundInside(ThriftTokenTypes.DEFINITION_NAME, ThriftTokenTypes.SERVICE).spaces(1)
            .betweenInside(ThriftTokenTypes.IDENTIFIER, null, ThriftTokenTypes.CONST).spaces(1)
            .beforeInside(ThriftTokenTypes.COLON, ThriftTokenTypes.FIELD_ID).none()

            .after(ThriftTokenTypes.STRUCT).blankLines(1)
            .after(ThriftTokenTypes.EXCEPTION).blankLines(1)
            .after(ThriftTokenTypes.SENUM).blankLines(1)
            .after(ThriftTokenTypes.ENUM).blankLines(1)
            .after(ThriftTokenTypes.SERVICE).blankLines(1)
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
    PsiElement nodePsi = node.getPsi();
    PsiElement childNodePsi = childNode.getPsi();
    if (childNodePsi instanceof ThriftFields ||
            childNodePsi instanceof ThriftFunction ||
            childNodePsi instanceof ThriftSenumBody ||
            childNodePsi instanceof ThriftEnumField ||
            childNodePsi instanceof ThriftThrows ||
            (nodePsi instanceof ThriftThrows && childNodePsi instanceof ThriftField)
    ) {
      return Indent.getNormalIndent();
    }

    return Indent.getNoneIndent();
  }
}
