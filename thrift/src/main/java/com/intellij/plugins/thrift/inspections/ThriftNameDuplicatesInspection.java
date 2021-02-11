package com.intellij.plugins.thrift.inspections;

import com.intellij.codeInspection.InspectionManager;
import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.plugins.thrift.ThriftBundle;
import com.intellij.plugins.thrift.lang.psi.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.util.ArrayUtil;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThriftNameDuplicatesInspection extends LocalInspectionTool {
  @NotNull
  public String getGroupDisplayName() {
    return ThriftBundle.message("inspections.group.name");
  }

  @Nls
  @NotNull
  @Override
  public String getDisplayName() {
    return ThriftBundle.message("thrift.inspection.duplicates.name");
  }

  @Override
  public boolean isEnabledByDefault() {
    return true;
  }

  @NotNull
  @Override
  public String getShortName() {
    return "ThriftNameDuplicates";
  }

  @Nullable
  @Override
  public ProblemDescriptor[] checkFile(@NotNull PsiFile file, @NotNull final InspectionManager manager, final boolean isOnTheFly) {
    final List<ProblemDescriptor> result = new ArrayList<ProblemDescriptor>();
    new ThriftVisitor() {
      @Override
      public void visitTopLevelDeclaration(@NotNull ThriftTopLevelDeclaration o) {
        if (o instanceof ThriftEnumDeclaration) {
          Set<String> names = new HashSet<String>();
          for (ThriftEnumField enumField : ((ThriftEnumDeclaration) o).getEnumFieldList()) {
            PsiElement nameIdentifier = enumField.getIdentifier();

            if (!names.add(nameIdentifier.getText())) {
              result.add(manager.createProblemDescriptor(
                      enumField.getIdentifier(),
                      String.format("multiple enum value names '%s'", nameIdentifier.getText()),
                      true,
                      ProblemHighlightType.ERROR,
                      isOnTheFly
              ));
            }
          }
        } else if (o instanceof ThriftSenumDeclaration) {
          checkSenum((ThriftSenumDeclaration) o, result, manager, isOnTheFly);
        } else if (o instanceof ThriftServiceDeclaration) {
          checkService((ThriftServiceDeclaration) o, result, manager, isOnTheFly);
        } else if (o instanceof ThriftStructDeclaration) {
          result.addAll(checkFieldList(manager, isOnTheFly, ((ThriftStructDeclaration) o).getFieldList(), "fields"));
        } else if (o instanceof ThriftUnionDeclaration) {
          result.addAll(checkFieldList(manager, isOnTheFly, ((ThriftUnionDeclaration) o).getFieldList(), "union values"));
        } else if (o instanceof ThriftExceptionDeclaration) {
          result.addAll(checkFieldList(manager, isOnTheFly, ((ThriftExceptionDeclaration) o).getFieldList(), "fields"));
        }
      }

      public void visitElement(@NotNull PsiElement element) {
        super.visitElement(element);
        element.acceptChildren(this);
      }
    }.visitFile(file);
    return ArrayUtil.toObjectArray(result, ProblemDescriptor.class);
  }

  private void checkSenum(ThriftSenumDeclaration o, List<ProblemDescriptor> result, @NotNull InspectionManager manager, boolean isOnTheFly) {
    Set<String> names = new HashSet<String>();

    for (ThriftSenumField field : o.getSenumFieldList()) {
      if (!names.add(field.getLiteral().getText())) {
        result.add(manager.createProblemDescriptor(
                field.getLiteral(),
                String.format("multiple senum values %s", field.getLiteral().getText()),
                true,
                ProblemHighlightType.ERROR,
                isOnTheFly
        ));
      }
    }
  }

  private void checkService(ThriftServiceDeclaration service, List<ProblemDescriptor> result, @NotNull InspectionManager manager, boolean isOnTheFly) {
    Set<String> methodNames = new HashSet<String>();

    for (ThriftFunction f : service.getFunctionList()) {
      String methodName = f.getDefinitionName().getName();

      if (!methodNames.add(methodName)) {
        result.add(manager.createProblemDescriptor(
                f.getIdentifier(),
                String.format("multiple methods with name '%s'", methodName),
                true,
                ProblemHighlightType.ERROR,
                isOnTheFly
        ));
      }

      result.addAll(checkFieldList(manager, isOnTheFly, f.getFieldList(), "args"));
      ThriftFunctionThrows functionThrows = f.getFunctionThrows();
      if (functionThrows != null) {
        result.addAll(checkFieldList(manager, isOnTheFly, functionThrows.getFieldList(), "throws"));
      }
    }
  }

  private List<ProblemDescriptor> checkFieldList(
          @NotNull final InspectionManager manager,
          final boolean isOnTheFly,
          List<ThriftField> fields,
          String part
  ) {
    Set<String> names = new HashSet<String>();
    final List<ProblemDescriptor> result = new ArrayList<ProblemDescriptor>();

    for (ThriftField field : fields) {
      ThriftDefinitionName name = field.getDefinitionName();

      if (name != null && !names.add(name.getText())) {
        result.add(manager.createProblemDescriptor(
                field.getIdentifier(),
                String.format("multiple %s with name '%s'", part, name.getText()),
                true,
                ProblemHighlightType.ERROR,
                isOnTheFly
        ));
      }
    }

    return result;
  }
}
