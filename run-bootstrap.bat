REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET ELEARNING_CP=elearning.app.bootstrap/target/elearning.app.bootstrap-1.0.0.jar;elearning.app.bootstrap/target/dependency/*;

REM call the java VM, e.g, 
java -cp %ELEARNING_CP% eapli.elearning.app.bootstrap.ELearningBootstrap
