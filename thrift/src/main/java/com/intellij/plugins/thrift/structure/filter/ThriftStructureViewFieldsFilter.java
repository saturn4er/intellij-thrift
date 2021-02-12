package com.intellij.plugins.thrift.structure.filter;

import com.intellij.ide.util.treeView.smartTree.ActionPresentation;
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData;
import com.intellij.ide.util.treeView.smartTree.Filter;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.plugins.thrift.lang.psi.ThriftFunction;
import com.intellij.plugins.thrift.lang.psi.ThriftSubDeclaration;
import com.intellij.plugins.thrift.structure.ThriftStructureViewElement;
import com.intellij.psi.PsiElement;
import com.intellij.util.PlatformIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class ThriftStructureViewFieldsFilter implements Filter {
  public static ThriftStructureViewFieldsFilter INSTANCE = new ThriftStructureViewFieldsFilter();

  @NonNls
  public static final String ID = "SHOW_FIELDS";

  public boolean isVisible(TreeElement treeNode) {
    if (!(treeNode instanceof ThriftStructureViewElement)) return true;
    final PsiElement element = ((ThriftStructureViewElement) treeNode).getRealElement();

    return !(element instanceof ThriftSubDeclaration);
  }

  public boolean isReverted() {
    return true;
  }

  @NotNull
  public ActionPresentation getPresentation() {
    return new ActionPresentationData(
            "Show fields",
            null,
            PlatformIcons.FIELD_ICON
    );
  }

  @NotNull
  public String getName() {
    return ID;
  }
}
