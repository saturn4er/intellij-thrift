// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ThriftService extends ThriftDeclaration {

  @Nullable
  ThriftDefinitionName getDefinitionName();

  @NotNull
  List<ThriftFunction> getFunctionList();

  @NotNull
  List<ThriftListSeparator> getListSeparatorList();

}