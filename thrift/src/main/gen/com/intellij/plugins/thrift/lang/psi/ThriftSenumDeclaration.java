// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ThriftSenumDeclaration extends ThriftTopLevelDeclaration {

  @Nullable
  ThriftDefinitionName getDefinitionName();

  @NotNull
  List<ThriftListSeparator> getListSeparatorList();

  @NotNull
  List<ThriftSenumField> getSenumFieldList();

  @Nullable
  ThriftTypeAnnotations getTypeAnnotations();

}
