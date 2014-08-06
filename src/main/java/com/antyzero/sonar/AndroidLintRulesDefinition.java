package com.antyzero.sonar;

import org.sonar.api.server.rule.RulesDefinition;

/**
 * ...
 */
public class AndroidLintRulesDefinition implements RulesDefinition {

    public static final String REPOSITORY_KEY = "android-lint";
    public static final String REPOSITORY_NAME = "Android Lint";

    @Override
    public void define(Context context) {

        NewRepository repository = context
                .createRepository(REPOSITORY_KEY, REPOSITORY_NAME)
                .setName("Android Lint Analyzer");


    }
}
