package com.antyzero.sonar;

import com.android.SdkConstants;
import com.google.common.collect.Iterators;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.batch.fs.FilePredicate;
import org.sonar.api.batch.fs.FilePredicates;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.resources.Project;

import java.io.File;
import java.util.regex.Pattern;

/**
 * ...
 */
public class AndroidLintSensor implements Sensor {

    private static final String LANGUAGE_JAVA = "java";
    private static final String PATTERN_ANDROID_MANIFEST = ".*" + Pattern.quote(SdkConstants.ANDROID_MANIFEST_XML);

    private final FileSystem fileSystem;

    /**
     *
     */
    public AndroidLintSensor(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void analyse(Project project, SensorContext sensorContext) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean shouldExecuteOnProject(Project project) {
        return hasJavaFiles() && hasAndroidManifest();
    }

    /**
     * Detects Java files
     *
     * @return {@code true} if Java files are present
     */
    boolean hasJavaFiles() {

        FilePredicates predicates = fileSystem.predicates();

        Iterable<InputFile> files = fileSystem.inputFiles(
                predicates.and(
                        predicates.hasLanguage(LANGUAGE_JAVA),
                        predicates.hasType(InputFile.Type.MAIN)));

        return Iterators.size(files.iterator()) > 0;
    }

    /**
     * Detects AndroidManifest.xml file
     *
     * @return {@code true} if file is present
     */
    boolean hasAndroidManifest() {

        File pathAndroidManifest = new File(fileSystem.baseDir(), SdkConstants.ANDROID_MANIFEST_XML);

        if (pathAndroidManifest.exists()) {
            return true;
        }

        FilePredicates predicates = fileSystem.predicates();

        FilePredicate predicate = predicates.matchesPathPattern(PATTERN_ANDROID_MANIFEST);

        return fileSystem.hasFiles(predicate);
    }
}
