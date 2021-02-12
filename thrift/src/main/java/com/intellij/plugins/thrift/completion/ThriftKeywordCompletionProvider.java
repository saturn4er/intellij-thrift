package com.intellij.plugins.thrift.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.AutoCompletionPolicy;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.codeInsight.template.Template;
import com.intellij.codeInsight.template.TemplateManager;
import com.intellij.codeInsight.template.impl.TemplateSettings;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorModificationUtil;
import com.intellij.util.ObjectUtils;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ThriftKeywordCompletionProvider extends CompletionProvider {
  private final int myPriority;
  @Nullable
  private final InsertHandler<LookupElement> myInsertHandler;
  @Nullable private final AutoCompletionPolicy myCompletionPolicy;
  @NotNull private final String[] myKeywords;

  public ThriftKeywordCompletionProvider(int priority, String... keywords) {
    this(priority, null, null, keywords);
  }

  public ThriftKeywordCompletionProvider(int priority, @Nullable AutoCompletionPolicy completionPolicy, @NotNull String... keywords) {
    this(priority, null, completionPolicy, keywords);
  }

  public ThriftKeywordCompletionProvider(int priority, @Nullable InsertHandler<LookupElement> insertHandler, @NotNull String... keywords) {
    this(priority, insertHandler, null, keywords);
  }

  private ThriftKeywordCompletionProvider(int priority,
                                      @Nullable InsertHandler<LookupElement> insertHandler,
                                      @Nullable AutoCompletionPolicy completionPolicy,
                                      @NotNull String... keywords) {
    myPriority = priority;
    myInsertHandler = insertHandler;
    myCompletionPolicy = completionPolicy;
    myKeywords = keywords;
  }


  @Override
  protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
    for (String keyword : myKeywords) {
      result.addElement(createKeywordLookupElement(keyword));
    }
  }


  @NotNull
  private LookupElement createKeywordLookupElement(@NotNull String keyword) {
    InsertHandler<LookupElement> insertHandler = ObjectUtils.chooseNotNull(
            myInsertHandler,
            createTemplateBasedInsertHandler("thrift_" + keyword)
    );
    LookupElement result = createKeywordLookupElement(keyword, myPriority, insertHandler);
    return myCompletionPolicy != null ? myCompletionPolicy.applyPolicy(result) : result;
  }

  public static LookupElement createKeywordLookupElement(@NotNull String keyword,
                                                         int priority,
                                                         @Nullable InsertHandler<LookupElement> insertHandler) {
    LookupElementBuilder builder = LookupElementBuilder.create(keyword).withBoldness(true).withInsertHandler(insertHandler);
    return PrioritizedLookupElement.withPriority(builder, priority);
  }

  @Nullable
  public static InsertHandler<LookupElement> createTemplateBasedInsertHandler(@NotNull String templateId) {
    return (context, item) -> {
      Template template = TemplateSettings.getInstance().getTemplateById(templateId);
      Editor editor = context.getEditor();
      if (template != null) {
        editor.getDocument().deleteString(context.getStartOffset(), context.getTailOffset());
        TemplateManager.getInstance(context.getProject()).startTemplate(editor, template);
      }
      else {
        int currentOffset = editor.getCaretModel().getOffset();
        CharSequence documentText = editor.getDocument().getImmutableCharSequence();
        if (documentText.length() <= currentOffset || documentText.charAt(currentOffset) != ' ') {
          EditorModificationUtil.insertStringAtCaret(editor, " ");
        }
        else {
          EditorModificationUtil.moveCaretRelatively(editor, 1);
        }
      }
    };
  }
}
