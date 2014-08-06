package com.antyzero.sonar;

import com.google.common.collect.ImmutableList;
import org.sonar.api.Extension;
import org.sonar.api.SonarPlugin;

import java.util.List;

/**
 * ...
 */
public class AndroidPlugin extends SonarPlugin {

    /**
     * List of extensions
     */
    private static final ImmutableList<Class<? extends Extension>> EXTENSIONS = ImmutableList.of(
            AndroidLintSensor.class,
            AndroidLintRulesDefinition.class,
            LintSonarClient.class
    );

    @Override
    public List getExtensions() {
        return EXTENSIONS;
    }
}
