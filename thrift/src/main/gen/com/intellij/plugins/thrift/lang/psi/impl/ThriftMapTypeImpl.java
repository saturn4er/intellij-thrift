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

public class ThriftMapTypeImpl extends ThriftContainerTypeImpl implements ThriftMapType {

  public ThriftMapTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull ThriftVisitor visitor) {
    visitor.visitMapType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ThriftVisitor) accept((ThriftVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ThriftCppTypeAttr getCppTypeAttr() {
    return findChildByClass(ThriftCppTypeAttr.class);
  }

  @Override
  @NotNull
  public List<ThriftType> getTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ThriftType.class);
  }

  @Override
  @Nullable
  public ThriftType getKeyType() {
    List<ThriftType> p1 = getTypeList();
    return p1.size() < 1 ? null : p1.get(0);
  }

  @Override
  @Nullable
  public ThriftType getValueType() {
    List<ThriftType> p1 = getTypeList();
    return p1.size() < 2 ? null : p1.get(1);
  }

}
