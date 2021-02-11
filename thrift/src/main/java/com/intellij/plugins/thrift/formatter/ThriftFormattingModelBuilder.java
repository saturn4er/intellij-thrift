package com.intellij.plugins.thrift.formatter;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.plugins.thrift.formatter.blocks.ThriftFmtBlock;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;

public class ThriftFormattingModelBuilder implements FormattingModelBuilder {
  @NotNull
  @Override
  public FormattingModel createModel(FormattingContext context) {
    return FormattingModelProvider.createFormattingModelForPsiFile(
            context.getContainingFile(),
            buildBlock(context.getNode(), null, Indent.getNoneIndent(), null, context.getCodeStyleSettings()),
            context.getCodeStyleSettings()
    );
  }

  @NotNull
  public static Block buildBlock(
          ASTNode node,
          Alignment alignment,
          Indent indent,
          Wrap wrap,
          CodeStyleSettings settings
  ) {
    return new ThriftFmtBlock(node,alignment, indent, wrap, settings);
  }
}
