// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ThriftField extends ThriftSubDeclaration {

  @Nullable
  ThriftConstValue getConstValue();

  @Nullable
  ThriftDefinitionName getDefinitionName();

  @Nullable
  ThriftFieldId getFieldId();

  @Nullable
  ThriftFieldReq getFieldReq();

  @Nullable
  ThriftFieldXdfAttrs getFieldXdfAttrs();

  @Nullable
  ThriftListSeparator getListSeparator();

  @NotNull
  ThriftType getType();

  @Nullable
  ThriftTypeAnnotations getTypeAnnotations();

  //WARNING: getType(...) is skipped
  //matching getType(ThriftField, ...)
  //methods are not found in ThriftPsiUtil

}
