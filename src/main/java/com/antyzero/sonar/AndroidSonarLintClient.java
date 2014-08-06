package com.antyzero.sonar;

import com.android.annotations.NonNull;
import com.android.annotations.Nullable;
import com.android.tools.lint.client.api.JavaParser;
import com.android.tools.lint.client.api.LintClient;
import com.android.tools.lint.client.api.XmlParser;
import com.android.tools.lint.detector.api.*;

import java.io.File;

/**
 * Created by tornax on 06.08.14.
 */
public class AndroidSonarLintClient extends LintClient {

    @Override
    public void report(@NonNull Context context, @NonNull Issue issue, @NonNull Severity severity, @Nullable Location location, @NonNull String message, @Nullable Object data) {

    }

    @Override
    public void log(@NonNull Severity severity, @Nullable Throwable exception, @Nullable String format, @Nullable Object... args) {

    }

    @Override
    public XmlParser getXmlParser() {
        return null;
    }

    @Override
    public JavaParser getJavaParser(@Nullable Project project) {
        return null;
    }

    @Override
    public String readFile(@NonNull File file) {
        return null;
    }
}
