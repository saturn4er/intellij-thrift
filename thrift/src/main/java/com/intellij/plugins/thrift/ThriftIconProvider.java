package com.intellij.plugins.thrift;

import com.intellij.icons.AllIcons;
import com.intellij.ide.IconProvider;
import com.intellij.openapi.util.Iconable;
import com.intellij.plugins.thrift.lang.psi.*;
import com.intellij.psi.PsiElement;
import icons.ThriftIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ThriftIconProvider extends IconProvider {
  @Nullable
  @Override
  public Icon getIcon(@NotNull PsiElement element, @Iconable.IconFlags int flags) {
    if (element instanceof ThriftConstDeclaration) {
      return ThriftIcons.CONST;
    }
    if (element instanceof ThriftEnumDeclaration) {
      return ThriftIcons.ENUM;
    }
    if (element instanceof ThriftSenumDeclaration) {
      return ThriftIcons.ENUM;
    }
    if (element instanceof ThriftExceptionDeclaration) {
      return ThriftIcons.EXCEPTION;
    }
    if (element instanceof ThriftServiceDeclaration) {
      return ThriftIcons.SERVICE;
    }
    if (element instanceof ThriftStructDeclaration) {
      return ThriftIcons.STRUCT;
    }
    if (element instanceof ThriftTypeDeclaration) {
      return ThriftIcons.TYPEDEF;
    }
    if (element instanceof ThriftUnionDeclaration) {
      return ThriftIcons.UNION;
    }
    if (element instanceof ThriftField) {
      return AllIcons.Nodes.Field;
    }
    if (element instanceof ThriftFunction) {
      return AllIcons.Nodes.Method;
    }
    return null;
  }
}
