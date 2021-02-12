package com.intellij.plugins.thrift.lang.psi.presentation;

import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.ItemPresentationProvider;
import com.intellij.openapi.util.Iconable;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.plugins.thrift.lang.psi.ThriftField;
import com.intellij.plugins.thrift.lang.psi.ThriftFunction;
import com.intellij.plugins.thrift.lang.psi.ThriftFunctionThrows;
import com.intellij.plugins.thrift.lang.psi.ThriftStructDeclaration;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ThriftFieldPresentationProvider implements ItemPresentationProvider<ThriftField> {

  @Override
  public ItemPresentation getPresentation(@NotNull ThriftField field) {
    return new ItemPresentation() {
      @Override
      public @NlsSafe @Nullable String getPresentableText() {
        String id = field.getFieldId() == null ? "" : field.getFieldId().getText() + " ";
        String req = field.getFieldReq() == null ? "" : field.getFieldReq().getText() + " ";

        return id + req + field.getAnnotatedType().getType().getText();
      }

      @Override
      public @NlsSafe @Nullable String getLocationString() {
        PsiElement parent = field.getParent();
        if (parent instanceof ThriftStructDeclaration) {
          return ((ThriftStructDeclaration) parent).getName();
        } else if (parent instanceof ThriftFunction) {
          return ((ThriftFunction) parent).getName();
        } else if (parent instanceof ThriftFunctionThrows) {
          return ((ThriftFunction) parent.getParent()).getName();
        }

        return null;
      }

      @Override
      public @Nullable Icon getIcon(boolean unused) {
        return field.getIcon(Iconable.ICON_FLAG_VISIBILITY);
      }
    };
  }


}
