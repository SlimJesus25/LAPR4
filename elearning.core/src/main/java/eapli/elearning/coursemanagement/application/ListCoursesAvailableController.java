package eapli.elearning.coursemanagement.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.repositories.StudentRepository;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.elearning.teachermanagement.repositories.TeacherRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import net.sf.saxon.tree.jiter.ConcatenatingIterator;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


@Controller
public class ListCoursesAvailableController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ListCoursesAvailableService service = new ListCoursesAvailableService();
    public Iterator<CourseDTO> listCoursesAvailable(){
        String userRoles = this.authz.session().get().authenticatedUser().roleTypes().toString();
        if(userRoles.substring(1, userRoles.length()-1).equals("TEACHER, ELEARNING_ROLE"))
            return service.listIfTeacher();
        else if (userRoles.substring(1, userRoles.length()-1).equals("STUDENT, ELEARNING_ROLE"))
            return service.listIfstudent();
        else
            return service.listIfAdmin();

        }

}

