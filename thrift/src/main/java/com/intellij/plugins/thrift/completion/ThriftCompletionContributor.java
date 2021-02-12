package com.intellij.plugins.thrift.completion;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.patterns.*;
import com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes;
import com.intellij.plugins.thrift.lang.psi.ThriftDeclaration;
import com.intellij.plugins.thrift.lang.psi.ThriftField;
import com.intellij.plugins.thrift.lang.psi.ThriftFile;
import com.intellij.plugins.thrift.lang.psi.ThriftType;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;


import java.util.Collection;
import java.util.List;

import static com.intellij.patterns.PlatformPatterns.psiElement;
import static com.intellij.patterns.StandardPatterns.*;

public class ThriftCompletionContributor extends CompletionContributor {

  public ThriftCompletionContributor() {
//    extend(CompletionType.BASIC, psiElement().inside(ThriftFunctionType.class), new ThriftFunctionCompletionProvider());
    extend(CompletionType.BASIC, thriftFileDeclaration(),
            new ThriftKeywordCompletionProvider(0,
                    "const", "namespace", "xsd_namespace", "php_namespace", "include", "cpp_include",
                    "typedef", "struct", "enum", "senum", "union", "exception", "service"
            ));

    extend(CompletionType.BASIC, functionType(), new ThriftKeywordCompletionProvider(0, "void"));
    extend(CompletionType.BASIC, functionThrows(), new ThriftKeywordCompletionProvider(0, "throws"));
    extend(CompletionType.BASIC, fieldType(), new ThriftKeywordCompletionProvider(
            0,
            "i8", "i16", "i32", "i64", "double", "string", "binary", "slist", "bool", "byte",
            "map", "list", "set"
    ));


  }

  private static PsiElementPattern.Capture<PsiElement> thriftFileDeclaration() {
    return psiElement()
            .inside(true, psiElement(ThriftFile.class), psiElement(ThriftDeclaration.class));
  }

  private static PsiElementPattern.Capture<PsiElement> fieldType() {
    return psiElement()
            .inside(true, psiElement(ThriftType.class).inside(ThriftField.class));
  }

  private static PsiElementPattern.Capture<PsiElement> functionThrows() {
    return psiElement(ThriftTokenTypes.IDENTIFIER).inside(
            psiElement(ThriftTokenTypes.FUNCTION).afterSibling(functionWithoutThrows())
    );
  }

  private static PsiElementPattern.Capture<PsiElement> functionWithoutThrows() {
    CollectionPattern<PsiElement> collection = collection(PsiElement.class);
    PsiElementPattern.Capture<PsiElement> a = psiElement(ThriftTokenTypes.FUNCTION).withChildren(
            collection.filter(
                    psiElement().and(psiElement(ThriftTokenTypes.FUNCTION_THROWS)),
                    collection.empty()
            )
    );

    System.out.println(a);

    return a;
  }

  private static PsiElementPattern.Capture<PsiElement> functionType() {
    return psiElement(ThriftTokenTypes.IDENTIFIER).inside(
            psiElement(ThriftTokenTypes.FUNCTION)
    );
  }

  @Override
  public boolean invokeAutoPopup(@NotNull PsiElement position, char typeChar) {
    return true;
  }

}
