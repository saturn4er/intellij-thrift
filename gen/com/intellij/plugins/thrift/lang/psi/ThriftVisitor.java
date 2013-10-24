// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;

public class ThriftVisitor extends PsiElementVisitor {

  public void visitBaseType(@NotNull ThriftBaseType o) {
    visitPsiCompositeElement(o);
  }

  public void visitConst(@NotNull ThriftConst o) {
    visitDeclaration(o);
  }

  public void visitConstList(@NotNull ThriftConstList o) {
    visitPsiCompositeElement(o);
  }

  public void visitConstMap(@NotNull ThriftConstMap o) {
    visitPsiCompositeElement(o);
  }

  public void visitConstValue(@NotNull ThriftConstValue o) {
    visitPsiCompositeElement(o);
  }

  public void visitCppType(@NotNull ThriftCppType o) {
    visitPsiCompositeElement(o);
  }

  public void visitCustomType(@NotNull ThriftCustomType o) {
    visitPsiCompositeElement(o);
  }

  public void visitDefinitionName(@NotNull ThriftDefinitionName o) {
    visitPsiCompositeElement(o);
  }

  public void visitDoubleConstant(@NotNull ThriftDoubleConstant o) {
    visitPsiCompositeElement(o);
  }

  public void visitEnum(@NotNull ThriftEnum o) {
    visitDeclaration(o);
  }

  public void visitException(@NotNull ThriftException o) {
    visitDeclaration(o);
  }

  public void visitField(@NotNull ThriftField o) {
    visitPsiCompositeElement(o);
  }

  public void visitFieldID(@NotNull ThriftFieldID o) {
    visitPsiCompositeElement(o);
  }

  public void visitFieldReq(@NotNull ThriftFieldReq o) {
    visitPsiCompositeElement(o);
  }

  public void visitFieldType(@NotNull ThriftFieldType o) {
    visitPsiCompositeElement(o);
  }

  public void visitFunction(@NotNull ThriftFunction o) {
    visitPsiCompositeElement(o);
  }

  public void visitFunctionType(@NotNull ThriftFunctionType o) {
    visitPsiCompositeElement(o);
  }

  public void visitInclude(@NotNull ThriftInclude o) {
    visitPsiCompositeElement(o);
  }

  public void visitIntConstant(@NotNull ThriftIntConstant o) {
    visitPsiCompositeElement(o);
  }

  public void visitListSeparator(@NotNull ThriftListSeparator o) {
    visitPsiCompositeElement(o);
  }

  public void visitListType(@NotNull ThriftListType o) {
    visitPsiCompositeElement(o);
  }

  public void visitMapType(@NotNull ThriftMapType o) {
    visitPsiCompositeElement(o);
  }

  public void visitNamespace(@NotNull ThriftNamespace o) {
    visitPsiCompositeElement(o);
  }

  public void visitNamespaceScope(@NotNull ThriftNamespaceScope o) {
    visitPsiCompositeElement(o);
  }

  public void visitSenum(@NotNull ThriftSenum o) {
    visitDeclaration(o);
  }

  public void visitService(@NotNull ThriftService o) {
    visitDeclaration(o);
  }

  public void visitSetType(@NotNull ThriftSetType o) {
    visitPsiCompositeElement(o);
  }

  public void visitStruct(@NotNull ThriftStruct o) {
    visitDeclaration(o);
  }

  public void visitThrows(@NotNull ThriftThrows o) {
    visitPsiCompositeElement(o);
  }

  public void visitTypedef(@NotNull ThriftTypedef o) {
    visitDeclaration(o);
  }

  public void visitUnion(@NotNull ThriftUnion o) {
    visitDeclaration(o);
  }

  public void visitXsdAttrs(@NotNull ThriftXsdAttrs o) {
    visitPsiCompositeElement(o);
  }

  public void visitXsdFieldOptions(@NotNull ThriftXsdFieldOptions o) {
    visitPsiCompositeElement(o);
  }

  public void visitEnumField(@NotNull ThriftEnumField o) {
    visitPsiCompositeElement(o);
  }

  public void visitSemunField(@NotNull ThriftSemunField o) {
    visitPsiCompositeElement(o);
  }

  public void visitDeclaration(@NotNull ThriftDeclaration o) {
    visitPsiCompositeElement(o);
  }

  public void visitPsiCompositeElement(@NotNull ThriftPsiCompositeElement o) {
    visitElement(o);
  }

}