package com.antyzero.sonar;

import org.junit.Before;
import org.junit.Test;
import org.sonar.api.batch.fs.internal.DefaultFileSystem;

import java.io.File;

import static org.fest.assertions.api.Assertions.assertThat;

public class AndroidLintExtensionTest {

    private AndroidLintExtension androidLintExtension;

    @Before
    public void setUp() throws Exception {

        // "/test-project/src/main"
        File baseDir = new File(getClass().getResource("/test-project").toURI());

        DefaultFileSystem fileSystem = new DefaultFileSystem().setBaseDir(baseDir);

        androidLintExtension = new AndroidLintExtension(fileSystem);
    }

    @Test
    public void testShouldExecuteOnProject() throws Exception {
        assertThat(androidLintExtension.shouldExecuteOnProject(null)).isTrue();
    }

    @Test
    public void testHasJavaFiles() {
        assertThat(androidLintExtension.hasJavaFiles()).isTrue();
    }
}