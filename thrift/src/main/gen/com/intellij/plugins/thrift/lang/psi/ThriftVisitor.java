// This is a generated file. Not intended for manual editing.
package com.intellij.plugins.thrift.lang.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiNamedElement;
import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiNameIdentifierOwner;

public class ThriftVisitor extends PsiElementVisitor {

  public void visitAnnotatedType(@NotNull ThriftAnnotatedType o) {
    visitPsiCompositeElement(o);
  }

  public void visitBaseType(@NotNull ThriftBaseType o) {
    visitType(o);
  }

  public void visitConstDeclaration(@NotNull ThriftConstDeclaration o) {
    visitTopLevelDeclaration(o);
  }

  public void visitConstList(@NotNull ThriftConstList o) {
    visitPsiCompositeElement(o);
  }

  public void visitConstMap(@NotNull ThriftConstMap o) {
    visitPsiCompositeElement(o);
  }

  public void visitConstMapItem(@NotNull ThriftConstMapItem o) {
    visitPsiCompositeElement(o);
  }

  public void visitConstValue(@NotNull ThriftConstValue o) {
    visitPsiCompositeElement(o);
  }

  public void visitContainerType(@NotNull ThriftContainerType o) {
    visitType(o);
  }

  public void visitCppTypeAttr(@NotNull ThriftCppTypeAttr o) {
    visitPsiCompositeElement(o);
  }

  public void visitCustomType(@NotNull ThriftCustomType o) {
    visitType(o);
  }

  public void visitDefinitionName(@NotNull ThriftDefinitionName o) {
    visitPsiNamedElement(o);
    // visitNavigationItem(o);
    // visitPsiNameIdentifierOwner(o);
  }

  public void visitDoubleConstant(@NotNull ThriftDoubleConstant o) {
    visitPsiCompositeElement(o);
  }

  public void visitEnumDeclaration(@NotNull ThriftEnumDeclaration o) {
    visitTopLevelDeclaration(o);
  }

  public void visitEnumField(@NotNull ThriftEnumField o) {
    visitPsiCompositeElement(o);
  }

  public void visitExceptionDeclaration(@NotNull ThriftExceptionDeclaration o) {
    visitTopLevelDeclaration(o);
  }

  public void visitField(@NotNull ThriftField o) {
    visitSubDeclaration(o);
  }

  public void visitFieldId(@NotNull ThriftFieldId o) {
    visitPsiCompositeElement(o);
  }

  public void visitFieldReq(@NotNull ThriftFieldReq o) {
    visitPsiCompositeElement(o);
  }

  public void visitFieldXdfAttrs(@NotNull ThriftFieldXdfAttrs o) {
    visitPsiCompositeElement(o);
  }

  public void visitFunction(@NotNull ThriftFunction o) {
    visitSubDeclaration(o);
  }

  public void visitFunctionThrows(@NotNull ThriftFunctionThrows o) {
    visitPsiCompositeElement(o);
  }

  public void visitFunctionType(@NotNull ThriftFunctionType o) {
    visitPsiCompositeElement(o);
  }

  public void visitIncludeStatement(@NotNull ThriftIncludeStatement o) {
    visitPsiCompositeElement(o);
  }

  public void visitIntConstant(@NotNull ThriftIntConstant o) {
    visitPsiCompositeElement(o);
  }

  public void visitListSeparator(@NotNull ThriftListSeparator o) {
    visitPsiCompositeElement(o);
  }

  public void visitListType(@NotNull ThriftListType o) {
    visitContainerType(o);
  }

  public void visitMapType(@NotNull ThriftMapType o) {
    visitContainerType(o);
  }

  public void visitNamespaceScope(@NotNull ThriftNamespaceScope o) {
    visitPsiCompositeElement(o);
  }

  public void visitNamespaceStatement(@NotNull ThriftNamespaceStatement o) {
    visitPsiCompositeElement(o);
  }

  public void visitSenumDeclaration(@NotNull ThriftSenumDeclaration o) {
    visitTopLevelDeclaration(o);
  }

  public void visitSenumField(@NotNull ThriftSenumField o) {
    visitPsiCompositeElement(o);
  }

  public void visitServiceDeclaration(@NotNull ThriftServiceDeclaration o) {
    visitTopLevelDeclaration(o);
  }

  public void visitServiceSuperName(@NotNull ThriftServiceSuperName o) {
    visitPsiCompositeElement(o);
  }

  public void visitSetType(@NotNull ThriftSetType o) {
    visitContainerType(o);
  }

  public void visitStructDeclaration(@NotNull ThriftStructDeclaration o) {
    visitTopLevelDeclaration(o);
  }

  public void visitType(@NotNull ThriftType o) {
    visitPsiCompositeElement(o);
  }

  public void visitTypeAnnotation(@NotNull ThriftTypeAnnotation o) {
    visitPsiCompositeElement(o);
  }

  public void visitTypeAnnotationRecovery(@NotNull ThriftTypeAnnotationRecovery o) {
    visitPsiCompositeElement(o);
  }

  public void visitTypeAnnotations(@NotNull ThriftTypeAnnotations o) {
    visitPsiCompositeElement(o);
  }

  public void visitTypeDeclaration(@NotNull ThriftTypeDeclaration o) {
    visitTopLevelDeclaration(o);
  }

  public void visitUnionDeclaration(@NotNull ThriftUnionDeclaration o) {
    visitTopLevelDeclaration(o);
  }

  public void visitSubDeclaration(@NotNull ThriftSubDeclaration o) {
    visitPsiCompositeElement(o);
  }

  public void visitTopLevelDeclaration(@NotNull ThriftTopLevelDeclaration o) {
    visitPsiCompositeElement(o);
  }

  public void visitPsiNamedElement(@NotNull PsiNamedElement o) {
    visitElement(o);
  }

  public void visitPsiCompositeElement(@NotNull ThriftPsiCompositeElement o) {
    visitElement(o);
  }

}
