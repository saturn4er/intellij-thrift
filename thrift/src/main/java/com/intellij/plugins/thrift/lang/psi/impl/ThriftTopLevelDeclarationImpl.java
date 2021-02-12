package com.intellij.plugins.thrift.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.plugins.thrift.lang.psi.ThriftDeclaration;
import com.intellij.plugins.thrift.lang.psi.ThriftTopLevelDeclaration;
import org.jetbrains.annotations.NotNull;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThriftTopLevelDeclarationImpl extends AbstractThriftDeclaration implements ThriftTopLevelDeclaration {
  public ThriftTopLevelDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public List<ThriftDeclaration> findSubDeclarations() {
    return Arrays
            .stream(getChildren())
            .filter(c->c instanceof ThriftDeclaration)
            .map(c->(ThriftDeclaration) c)
            .collect(Collectors.toList());

  }
}
