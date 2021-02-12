package com.intellij.plugins.thrift.lang.psi.presentation;

import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.ItemPresentationProvider;
import com.intellij.openapi.util.Iconable;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.plugins.thrift.lang.psi.ThriftAnnotatedType;
import com.intellij.plugins.thrift.lang.psi.ThriftDeclaration;
import com.intellij.plugins.thrift.lang.psi.ThriftType;
import com.intellij.plugins.thrift.lang.psi.ThriftTypeDeclaration;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by fkorotkov.
 */
public class ThriftTopLevelDeclarationPresentationProvider implements ItemPresentationProvider<ThriftDeclaration> {
  @Override
  public ItemPresentation getPresentation(final ThriftDeclaration item) {
    return new ItemPresentation() {
      @Nullable
      @Override
      public String getPresentableText() {
        if (item instanceof ThriftTypeDeclaration){
          @Nullable @NlsSafe String result = item.getName();
          @Nullable ThriftAnnotatedType type = ((ThriftTypeDeclaration) item).getAnnotatedType();
          if(type != null){
            result += "-> "+type.getType().getText();
          }

          return result;
        }
        return item.getName();
      }

      @Nullable
      @Override
      public String getLocationString() {
        return null;
      }

      @Nullable
      @Override
      public Icon getIcon(boolean unused) {
        return item.getIcon(Iconable.ICON_FLAG_VISIBILITY);
      }
    };
  }
}
