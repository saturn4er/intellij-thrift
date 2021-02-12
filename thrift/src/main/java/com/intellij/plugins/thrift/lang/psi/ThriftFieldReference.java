package com.intellij.plugins.thrift.lang.psi;

import com.intellij.model.Symbol;
import com.intellij.model.SymbolResolveResult;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public class ThriftFieldReference extends PsiReferenceBase<ThriftConstValue> {
  public ThriftFieldReference(@NotNull ThriftConstValue element, int offset) {
    super(element, TextRange.create(offset, element.getTextLength()));
  }
  @Override
  public @Nullable PsiElement resolve() {
    return null;
  }

  @Override
  public Object @NotNull [] getVariants() {
    return new Object[0];
  }

  @Override
  public @NotNull Collection<? extends SymbolResolveResult> resolveReference() {
    return null;
  }

  @Override
  public boolean resolvesTo(@NotNull Symbol target) {
    return false;
  }

  @Override
  public @NotNull TextRange getAbsoluteRange() {
    return null;
  }
}
