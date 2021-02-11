// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ThriftMapType extends ThriftContainerType {

  @Nullable
  ThriftCppTypeAttr getCppTypeAttr();

  @NotNull
  List<ThriftType> getTypeList();

  @Nullable
  ThriftType getKeyType();

  @Nullable
  ThriftType getValueType();

}
