package com.intellij.plugins.thrift.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.plugins.thrift.lang.lexer.ThriftElementType;
import com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes;
import com.intellij.plugins.thrift.lang.psi.ThriftDeclaration;
import com.intellij.plugins.thrift.lang.psi.ThriftListSeparator;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class SenumBodyImpl extends ThriftPsiCompositeElementImpl{
  public SenumBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  @NotNull
  public List<ASTNode> getValues() {
    return Arrays.asList(getNode().getChildren(TokenSet.create(ThriftTokenTypes.LITERAL)));
  }
}
