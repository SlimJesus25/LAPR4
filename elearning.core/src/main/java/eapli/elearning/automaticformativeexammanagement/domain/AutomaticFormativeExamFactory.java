package eapli.elearning.automaticformativeexammanagement.domain;

import eapli.elearning.exammanagement.domain.ExamFactory;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class AutomaticFormativeExamFactory {
    public static AutomaticFormativeExam createAutomaticFormativeExam(String path){
        return new AutomaticFormativeExam(path);
    }
}
