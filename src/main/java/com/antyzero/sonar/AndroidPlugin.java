package com.antyzero.sonar;

import com.google.common.collect.ImmutableList;
import org.sonar.api.SonarPlugin;

import java.util.List;

/**
 * ...
 */
public class AndroidPlugin extends SonarPlugin {

    /**
     * List of extensions
     */
    private static final ImmutableList<Class<AndroidLintExtension>> EXTENSIONS = ImmutableList.of(
            AndroidLintExtension.class
    );

    @Override
    public List getExtensions() {
        return EXTENSIONS;
    }
}
