// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ThriftFunction extends ThriftSubDeclaration {

  @Nullable
  ThriftDefinitionName getDefinitionName();

  @NotNull
  List<ThriftField> getFieldList();

  @Nullable
  ThriftFunctionThrows getFunctionThrows();

  @NotNull
  ThriftFunctionType getFunctionType();

  @Nullable
  ThriftTypeAnnotations getTypeAnnotations();

}
