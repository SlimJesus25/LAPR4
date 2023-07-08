package eapli.elearning.automaticformativeexammanagement.domain;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class AutomaticFormativeExam {
    private AutomaticFormativeExamPath path;

    public AutomaticFormativeExam(String path) {
        this.path = new AutomaticFormativeExamPath(path);
    }
}
