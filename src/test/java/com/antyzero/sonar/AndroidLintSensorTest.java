package com.antyzero.sonar;

import org.junit.Before;
import org.junit.Test;
import org.sonar.api.batch.fs.internal.DefaultFileSystem;

import java.io.File;

import static org.fest.assertions.api.Assertions.assertThat;

public class AndroidLintSensorTest {

    private AndroidLintSensor androidLintSensor;

    @Before
    public void setUp() throws Exception {

        // Base dir for main code
        File baseDir = new File(getClass().getResource("/test-project/src/main").toURI());

        DefaultFileSystem fileSystem = new DefaultFileSystem().setBaseDir(baseDir);

        androidLintSensor = new AndroidLintSensor(fileSystem);
    }

    @Test
    public void testShouldExecuteOnProject() throws Exception {
        assertThat(androidLintSensor.shouldExecuteOnProject(null)).isTrue();
    }

    @Test
    public void testHasJavaFiles() {
        assertThat(androidLintSensor.hasJavaFiles()).isTrue();
    }

    @Test
    public void testHasAndroidManifest() {
        assertThat(androidLintSensor.hasAndroidManifest()).isTrue();
    }
}