#!/bin/bash

rm ./test-project -rf

android create project -t android-20 -p test-project -k com.antyzero.sonar.app -a MainActivity -g -v 0.12.+
