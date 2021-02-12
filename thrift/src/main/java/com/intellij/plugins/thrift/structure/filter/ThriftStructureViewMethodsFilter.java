package com.intellij.plugins.thrift.structure.filter;

import com.intellij.ide.util.treeView.smartTree.ActionPresentation;
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData;
import com.intellij.ide.util.treeView.smartTree.Filter;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.plugins.thrift.lang.psi.ThriftFunction;
import com.intellij.plugins.thrift.structure.ThriftStructureViewElement;
import com.intellij.psi.PsiElement;
import com.intellij.util.PlatformIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class ThriftStructureViewMethodsFilter implements Filter {
  public static ThriftStructureViewMethodsFilter INSTANCE = new ThriftStructureViewMethodsFilter();
  @NonNls public static final String ID = "SHOW_METHODS";

  public boolean isVisible(TreeElement treeNode) {
    if (!(treeNode instanceof ThriftStructureViewElement)) return true;
    final PsiElement element = ((ThriftStructureViewElement)treeNode).getRealElement();

    return !(element instanceof ThriftFunction);
  }

  public boolean isReverted() {
    return true;
  }

  @NotNull
  public ActionPresentation getPresentation() {
    return new ActionPresentationData(
            "Show Functions",
            null,
            PlatformIcons.METHOD_ICON
    );
  }

  @NotNull
  public String getName() {
    return ID;
  }
}
