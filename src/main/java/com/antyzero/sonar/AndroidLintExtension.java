package com.antyzero.sonar;

import com.google.common.collect.Iterators;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.batch.fs.FilePredicates;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.resources.Project;

/**
 * ...
 */
public class AndroidLintExtension implements Sensor {

    private static final String LANGUAGE_JAVA = "java";

    private final FileSystem fileSystem;

    public AndroidLintExtension(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public void analyse(Project project, SensorContext sensorContext) {

    }

    @Override
    public boolean shouldExecuteOnProject(Project project) {


        FilePredicates predicates = fileSystem.predicates();


        // Detect Java files

        boolean hasJavaMainFiles = hasJavaFiles();

        // Detect AndroidManifest file

        predicates.hasType(InputFile.Type.MAIN);

        boolean hasAndroidManifest = false;

        return hasJavaMainFiles;
    }

    /**
     * Detects Java files
     *
     * @return
     */
    boolean hasJavaFiles() {

        FilePredicates predicates = fileSystem.predicates();

        Iterable<InputFile> files = fileSystem.inputFiles(
                predicates.and(
                        predicates.hasLanguage(LANGUAGE_JAVA),
                        predicates.hasType(InputFile.Type.MAIN)));

        return Iterators.size(files.iterator()) > 0;
    }
}
