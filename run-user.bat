REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET ELEARNING_CP=elearning.app.user.console\target\elearning.app.user.console-1.0.0.jar;elearning.app.user.console\target\dependency\*;

REM call the java VM, e.g,
java -cp %ELEARNING_CP% eapli.elearning.app.user.console.ELearningUserApp
