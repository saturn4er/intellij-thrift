// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ThriftMapType extends ThriftContainerType {

  @NotNull
  List<ThriftAnnotatedType> getAnnotatedTypeList();

  @Nullable
  ThriftCppTypeAttr getCppTypeAttr();

}
