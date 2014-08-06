package com.antyzero.sonar;

import com.android.tools.lint.detector.api.Project;
import org.junit.Before;
import org.junit.Test;

import java.net.URISyntaxException;

import static org.fest.assertions.api.Assertions.assertThat;

public class LintSonarClientTest {

    private LintSonarClient lintSonarClient;

    @Before
    public void setUp() throws Exception {
        lintSonarClient = new LintSonarClient(TestHelper.testProjectFileSystem());
    }

    @Test
    public void testClientCreation() throws URISyntaxException {
        assertThat(lintSonarClient.isGradleProject(lintSonarClient.getProject())).isTrue();
    }

    @Test
    public void testProjectRecognizion() {
        Project project = lintSonarClient.getProject();
        assertThat(project).isNotNull();
    }

}