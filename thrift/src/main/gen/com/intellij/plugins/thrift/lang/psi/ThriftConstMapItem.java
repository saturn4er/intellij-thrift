// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ThriftConstMapItem extends ThriftPsiCompositeElement {

  @NotNull
  List<ThriftConstValue> getConstValueList();

  @Nullable
  ThriftListSeparator getListSeparator();

}
