package com.intellij.plugins.thrift.formatter.settings;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class ThriftCodeStyleSettings extends CustomCodeStyleSettings {

  protected ThriftCodeStyleSettings(@NonNls @NotNull String tagName, CodeStyleSettings container) {
    super(tagName, container);
  }
}
