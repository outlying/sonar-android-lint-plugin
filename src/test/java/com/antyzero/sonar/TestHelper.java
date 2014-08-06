package com.antyzero.sonar;

import org.sonar.api.batch.fs.internal.DefaultFileSystem;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Created by tornax on 06.08.14.
 */
public class TestHelper {

    public static DefaultFileSystem testProjectFileSystem() throws URISyntaxException {

        File baseDir = new File(TestHelper.class.getResource("/test-project/src/main").toURI());

        return new DefaultFileSystem().setBaseDir(baseDir);
    }
}
