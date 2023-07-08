package eapli.elearning.coursemanagement.application;

import eapli.elearning.courseenrollmentmanagement.domain.CourseEnrollment;
import eapli.elearning.courseenrollmentmanagement.persistance.CourseEnrollmentRepository;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.studentmanagement.repositories.StudentRepository;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teachermanagement.repositories.TeacherRepository;
import eapli.elearning.teamelementmanagament.domain.TeamElement;
import eapli.elearning.teamelementmanagament.repositories.TeamElementRepository;
import eapli.framework.application.ApplicationService;
import eapli.framework.domain.services.DomainService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@DomainService
public class ListCoursesAvailableService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CourseRepository repoCourses = PersistenceContext.repositories().courses();
    private final TeacherRepository repoTeachers = PersistenceContext.repositories().teachers();
    private final TeamElementRepository repoTE = PersistenceContext.repositories().courseTeams();

    private final CourseEnrollmentRepository repoCE = PersistenceContext.repositories().courseEnrollments();
    private final StudentRepository repoStudent = PersistenceContext.repositories().students();
    public Iterator<CourseDTO> listIfstudent(){
        Student studentLog = repoStudent.findStudentByUserName(this.authz.session().get().authenticatedUser().username());
        Iterable<Course> coursesEnrolled = repoCE.coursesThatStudentIsEnrolledOn(studentLog.toDTO().getMechanographicalNumber().toString());
        Iterable<Course> coursesAvailable = repoCourses.listAllOpenEnrollmentCourses();

        List<Course> finalList = addListsWithoutRep(convertToList(coursesAvailable),convertToList(coursesEnrolled));

        List<CourseDTO> result = new ArrayList<>();
        finalList.forEach(a -> result.add(a.toDTO()));

        return result.iterator();
    }
    public Iterator<CourseDTO> listIfAdmin(){
        List<CourseDTO> result = new ArrayList<>();
        repoCourses.listAllCourses().forEach(a -> result.add(a.toDTO()));
        return result.iterator();
    }
    public Iterator<CourseDTO> listIfTeacher(){
        Teacher teacherLog = repoTeachers.findTeacherByUserName(this.authz.session().get().authenticatedUser().username());
        Iterable<Course> courses = repoTE.findCoursesOfTeacher(teacherLog);
        List<CourseDTO> result = new ArrayList<>();
        courses.forEach(a -> result.add(a.toDTO()));
        return result.iterator();
    }
    public List<Course> addListsWithoutRep(List<Course> List1, List<Course> List2){
        List<Course> result = new ArrayList<>();
        for (Course c : List1) {
            if (!List2.contains(c)){
                result.add(c);
            }
        }
        for (Course c : List2) {
            result.add(c);
        }
        return result;
    }
    public List<Course> convertToList(Iterable<Course> iterable){
        Iterator<Course> iterator = iterable.iterator();

        List<Course> newList = new ArrayList<>();
        while (iterator.hasNext()) {
            newList.add(iterator.next());
        }
        return newList;
    }
}
