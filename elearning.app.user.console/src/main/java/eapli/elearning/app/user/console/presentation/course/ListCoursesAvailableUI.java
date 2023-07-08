package eapli.elearning.app.user.console.presentation.course;

import eapli.elearning.coursemanagement.application.ListCoursesAvailableController;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Iterator;

import static org.jaxen.expr.DefaultExpr.convertToList;

public class ListCoursesAvailableUI extends AbstractUI {
    ListCoursesAvailableController contr = new ListCoursesAvailableController();
    @Override
    protected boolean doShow() {
        Iterator<CourseDTO> a = contr.listCoursesAvailable();
        if(convertToList(a).size()==0){
            System.out.println("You don't have courses available!");
        }else{
            System.out.println("Your available courses are:");
        while (a.hasNext()) {
            CourseDTO elemento = a.next();
            System.out.println(elemento.getCourseCode());
        }
        }
        return false;
    }

    @Override
    public String headline() {
        return "List courses available";
    }
}
