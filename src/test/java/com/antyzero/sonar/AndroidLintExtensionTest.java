package com.antyzero.sonar;

import org.junit.Before;
import org.sonar.api.batch.fs.internal.DefaultFileSystem;

import static org.fest.assertions.api.Assertions.assertThat;

public class AndroidLintExtensionTest {

    private AndroidLintExtension androidLintExtension;

    @Before
    public void setUp() throws Exception {

        DefaultFileSystem fileSystem = new DefaultFileSystem();

        // "/test-project/src/main"
        getClass().getResource("/test-project");

        //fileSystem.setBaseDir(null);

        androidLintExtension = new AndroidLintExtension(fileSystem);
    }

    @org.junit.Test
    public void testShouldExecuteOnProject() throws Exception {
        assertThat(androidLintExtension.shouldExecuteOnProject(null)).isTrue();
    }
}