#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export ELEARNING_CP=elearning.app.backoffice.console/target/elearning.app.backoffice.console-1.0.0.jar:elearning.app.backoffice.console/target/dependency/*;

#REM call the java VM, e.g,
java -cp ELEARNING_CP eapli.elearning.app.backoffice.console.ELearningBackoffice
