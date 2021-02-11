package com.intellij.plugins.thrift.formatter;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.plugins.thrift.util.ThriftTestUtils;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;
import com.intellij.util.containers.ContainerUtil;

public class FormatterTest extends LightJavaCodeInsightFixtureTestCase {
  @Override
  protected String getTestDataPath() {
    return ThriftTestUtils.BASE_TEST_DATA_PATH +"/formatter/";
  }

  public void testFormatter() {
    myFixture.configureByFile("test.thrift");
    WriteCommandAction.writeCommandAction(getProject()).run(() -> {
      CodeStyleManager.getInstance(getProject()).reformatText(myFixture.getFile(),
              ContainerUtil.newArrayList(myFixture.getFile().getTextRange()));
    });
    myFixture.checkResultByFile("formatted_test.thrift");
  }
}
