package com.intellij.plugins.thrift;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by fkorotkov.
 */
public class ThriftBraceMatcher implements PairedBraceMatcher {

  private static final BracePair[] PAIRS = new BracePair[] {
    new BracePair(ThriftTokenTypes.LEFT_CURLY_BRACE, ThriftTokenTypes.RIGHT_CURLY_BRACE, false),
    new BracePair(ThriftTokenTypes.LEFT_BRACE, ThriftTokenTypes.RIGHT_BRACE, false),
    new BracePair(ThriftTokenTypes.LEFT_BRACKET, ThriftTokenTypes.RIGHT_BRACKET, false),
    new BracePair(ThriftTokenTypes.LT, ThriftTokenTypes.GT, false)
  };

  @Override
  public BracePair[] getPairs() {
    return PAIRS;
  }

  @Override
  public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
    return true;
  }

  @Override
  public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
    return openingBraceOffset;
  }
}
