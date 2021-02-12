package com.intellij.plugins.thrift.lang.psi;

import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.model.SymbolResolveResult;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.plugins.thrift.completion.ThriftKeywordCompletionProvider;
import com.intellij.plugins.thrift.lang.ThriftElementFactory;
import com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypeSets;
import com.intellij.plugins.thrift.util.ThriftPsiUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.util.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

import static com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes.*;
import static com.intellij.plugins.thrift.lang.lexer.ThriftTokenTypes.MAP;

/**
 * Created by fkorotkov.
 */
public class ThriftTypeReference extends PsiReferenceBase<ThriftCustomType> {
  public ThriftTypeReference(@NotNull ThriftCustomType element, int offset) {
    super(element, TextRange.create(offset, element.getTextLength()));
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    return processComponentAndFile(new Function<Pair<String, PsiFile>, PsiElement>() {
      @Override
      public PsiElement fun(@Nullable Pair<String, PsiFile> pair) {
        return pair != null ? ThriftPsiUtil.findDeclaration(pair.getFirst(), pair.getSecond()) : null;
      }
    });
  }

  @Override
  public Object @NotNull [] getVariants() {
    final Object[] result = processComponentAndFile(pair -> {
      final List<Object> result1 = new ArrayList<>();
      PsiFile psiFile = pair.getSecond();
      ThriftPsiUtil.processDeclarations(psiFile, declaration -> {
        if (declaration.getIdentifier() != null) {
          result1.add(declaration);
        }
        return true;
      });

      if (isSimple()) {
        ThriftPsiUtil.processIncludes(getElement().getContainingFile(), include -> {
          String path = include.getPath();
          String fileName = PathUtil.getFileName(path);
          result1.add(LookupElementBuilder.create(FileUtil.getNameWithoutExtension(fileName)));
          return true;
        });
      }


      return ArrayUtil.toObjectArray(result1);
    });

    return result != null ? result : PsiElement.EMPTY_ARRAY;
  }

  private boolean isSimple() {
    return getRangeInElement().getStartOffset() == 0;
  }

  @Nullable
  private <T> T processComponentAndFile(@NotNull Function<Pair<String, PsiFile>, T> fun) {
    final String name = getElement().getText();
    int index = getRangeInElement().getStartOffset();
    if (index > 0) {
      String fileName = name.substring(0, index - 1);
      String componentName = name.substring(index);
      ThriftIncludeStatement include = ThriftPsiUtil.findImportByPrefix(getElement().getContainingFile(), fileName);
      PsiFile includedFile = ThriftPsiUtil.resolveInclude(include);
      return includedFile != null ? fun.fun(Pair.create(componentName, includedFile)) : null;
    } else {
      return fun.fun(Pair.create(name, getElement().getContainingFile()));
    }
  }

  @NotNull
  @Override
  public Collection<? extends SymbolResolveResult> resolveReference() {
    return super.resolveReference();
  }

  @Override
  public PsiElement handleElementRename(@NotNull String newElementName) throws IncorrectOperationException {
    ThriftCustomType element = this.getElement();
    PsiElement identifier = element.getIdentifier();
    String currentText = identifier.getText();
    String newText = TextRange.create(currentText.indexOf(".") + 1, currentText.length()).replace(currentText, newElementName);

    element.getIdentifier().replace(ThriftElementFactory.createCustomTypeFromText(element.getProject(), newText));
    return element;
  }
}