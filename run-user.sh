#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
# shellcheck disable=SC2125
export ELEARNING_CP=elearning.app.user.console/target/elearning.app.user.console-1.0.0.jar:elearning.app.user.console/target/dependency/*;
echo "$ELEARNING_CP"
#REM call the java VM, e.g,
java -cp $ELEARNING_CP eapli.elearning.app.user.console.ELearningUserApp