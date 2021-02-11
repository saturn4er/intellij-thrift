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

public class ThriftIDDuplicatesInspection extends LocalInspectionTool {
  @NotNull
  public String getGroupDisplayName() {
    return ThriftBundle.message("inspections.group.name");
  }

  @Nls
  @NotNull
  @Override
  public String getDisplayName() {
    return ThriftBundle.message("thrift.inspection.duplicates.id");
  }

  @Override
  public boolean isEnabledByDefault() {
    return true;
  }

  @NotNull
  @Override
  public String getShortName() {
    return "ThriftIDDuplicates";
  }

  @Nullable
  @Override
  public ProblemDescriptor[] checkFile(@NotNull PsiFile file, @NotNull final InspectionManager manager, final boolean isOnTheFly) {
    final List<ProblemDescriptor> result = new ArrayList<ProblemDescriptor>();
    new ThriftVisitor() {
      @Override
      public void visitTopLevelDeclaration(@NotNull ThriftTopLevelDeclaration o) {
        Set<String> ids = new HashSet<String>();

        if (o instanceof ThriftEnumDeclaration) {
          for (ThriftEnumField enumField : ((ThriftEnumDeclaration) o).getEnumFieldList()) {
            ThriftIntConstant id = enumField.getIntConstant();
            if (id != null && !ids.add(id.getText())) {
              result.add(manager.createProblemDescriptor(
                      enumField.getIntConstant(),
                      String.format("multiple enum values with id %s", id.getText()),
                      true,
                      ProblemHighlightType.ERROR,
                      isOnTheFly
              ));
            }
          }

        } else if (o instanceof ThriftServiceDeclaration) {
          for (ThriftFunction f : ((ThriftServiceDeclaration) o).getFunctionList()) {
            result.addAll(checkFieldList(manager, isOnTheFly, f.getFieldList(), "args"));

            ThriftFunctionThrows t = f.getFunctionThrows();
            if (t != null) {
              result.addAll(checkFieldList(manager, isOnTheFly, t.getFieldList(), "throws"));
            }
          }

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

  private List<ProblemDescriptor> checkFieldList(
          @NotNull final InspectionManager manager,
          final boolean isOnTheFly,
          List<ThriftField> fields,
          String part
  ) {
    Set<String> ids = new HashSet<String>();
    final List<ProblemDescriptor> result = new ArrayList<ProblemDescriptor>();

    for (ThriftField field : fields) {
      ThriftFieldId id = field.getFieldId();

      if (id != null && !ids.add(id.getText())) {
        result.add(manager.createProblemDescriptor(
                id.getIntConstant(),
                String.format("multiple %s with id %s", part, id.getIntConstant().getText()),
                true,
                ProblemHighlightType.ERROR,
                isOnTheFly
        ));
      }
    }

    return result;
  }
}
