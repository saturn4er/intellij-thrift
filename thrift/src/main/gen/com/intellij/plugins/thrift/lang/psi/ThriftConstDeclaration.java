// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ThriftConstDeclaration extends ThriftTopLevelDeclaration {

  @Nullable
  ThriftConstValue getConstValue();

  @Nullable
  ThriftDefinitionName getDefinitionName();

  @Nullable
  ThriftListSeparator getListSeparator();

  @Nullable
  ThriftType getType();

}
