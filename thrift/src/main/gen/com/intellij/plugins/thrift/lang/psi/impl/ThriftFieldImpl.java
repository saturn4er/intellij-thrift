// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes.*;
import com.intellij.plugins.thrift.lang.psi.*;
import com.intellij.plugins.thrift.util.ThriftPsiUtil;

public class ThriftFieldImpl extends AbstractThriftDeclaration implements ThriftField {

  public ThriftFieldImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ThriftVisitor visitor) {
    visitor.visitField(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ThriftVisitor) accept((ThriftVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ThriftAnnotatedType getAnnotatedType() {
    return findNotNullChildByClass(ThriftAnnotatedType.class);
  }

  @Override
  @Nullable
  public ThriftConstValue getConstValue() {
    return findChildByClass(ThriftConstValue.class);
  }

  @Override
  @Nullable
  public ThriftDefinitionName getDefinitionName() {
    return findChildByClass(ThriftDefinitionName.class);
  }

  @Override
  @Nullable
  public ThriftFieldId getFieldId() {
    return findChildByClass(ThriftFieldId.class);
  }

  @Override
  @Nullable
  public ThriftFieldReq getFieldReq() {
    return findChildByClass(ThriftFieldReq.class);
  }

  @Override
  @Nullable
  public ThriftFieldXdfAttrs getFieldXdfAttrs() {
    return findChildByClass(ThriftFieldXdfAttrs.class);
  }

  @Override
  @Nullable
  public ThriftListSeparator getListSeparator() {
    return findChildByClass(ThriftListSeparator.class);
  }

  @Override
  @Nullable
  public ThriftTypeAnnotations getTypeAnnotations() {
    return findChildByClass(ThriftTypeAnnotations.class);
  }

}
