/*
 * Copyright 2000-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.plugins.thrift.structure;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Filter;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.plugins.thrift.lang.psi.ThriftDeclaration;
import com.intellij.plugins.thrift.lang.psi.ThriftField;
import com.intellij.plugins.thrift.structure.filter.ThriftStructureViewFieldsFilter;
import com.intellij.plugins.thrift.structure.filter.ThriftStructureViewMethodsFilter;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

/**
 * @author: Fedor.Korotkov
 */
public class ThriftStructureViewModel extends StructureViewModelBase implements StructureViewModel.ElementInfoProvider {
  public ThriftStructureViewModel(@NotNull PsiFile psiFile) {
    super(psiFile, new ThriftStructureViewElement(psiFile));
    withSorters(Sorter.ALPHA_SORTER);
    withSuitableClasses(ThriftDeclaration.class);
  }

  @Override
  public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
    return false;
  }

  @Override
  public Filter @NotNull [] getFilters() {
    return new Filter[]{
            ThriftStructureViewFieldsFilter.INSTANCE,
            ThriftStructureViewMethodsFilter.INSTANCE,
    };
  }

  @Override
  public boolean isAlwaysLeaf(StructureViewTreeElement element) {
    final Object value = element.getValue();
    return value instanceof ThriftField;
  }

  @Override
  public boolean shouldEnterElement(Object element) {
    return element instanceof ThriftDeclaration;
  }
}
