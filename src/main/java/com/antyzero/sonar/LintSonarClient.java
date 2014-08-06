package com.antyzero.sonar;

import com.android.annotations.NonNull;
import com.android.annotations.Nullable;
import com.android.tools.lint.client.api.JavaParser;
import com.android.tools.lint.client.api.LintClient;
import com.android.tools.lint.client.api.XmlParser;
import com.android.tools.lint.detector.api.*;
import org.sonar.api.BatchExtension;
import org.sonar.api.batch.fs.internal.DefaultFileSystem;

import java.io.File;

/**
 *
 */
public class LintSonarClient extends LintClient implements BatchExtension {

    private final DefaultFileSystem fileSystem;
    private final Project project;

    public LintSonarClient(DefaultFileSystem fileSystem) {
        this.fileSystem = fileSystem;

        File baseDir = fileSystem.baseDir();

        project = Project.create(this, baseDir, baseDir);
    }

    public Project getProject() {
        return project;
    }

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
