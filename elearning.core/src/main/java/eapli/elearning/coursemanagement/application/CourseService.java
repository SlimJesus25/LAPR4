package eapli.elearning.coursemanagement.application;

import eapli.elearning.courseenrollmentmanagement.domain.CourseEnrollment;
import eapli.elearning.courseenrollmentmanagement.persistance.CourseEnrollmentRepository;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseCode;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;


import java.util.ArrayList;
import java.util.List;

@ApplicationService
public class CourseService {
    private final CourseRepository courseRepo = PersistenceContext.repositories().courses();
    private final CourseEnrollmentRepository courseEnrollmentRepo = PersistenceContext.repositories().courseEnrollments();
    public Course findCourseByCourseCode(String courseCode){
        return courseRepo.findCourseByCode(courseCode);
    }
    public Iterable<CourseDTO> allCourses(){
        //repo.findCourseByCode()
        Iterable<Course> courses = courseRepo.listAllCourses();
        List<CourseDTO> result = new ArrayList<>();
        courses.forEach(a -> result.add(a.toDTO()));
        return result;
    }

    public Iterable<CourseDTO> teacherCourses(SystemUser teacher){
        Iterable<Course> courses = courseRepo.listTeacherCourses(teacher);
        List<CourseDTO> result = new ArrayList<>();
        courses.forEach(a -> result.add(a.toDTO()));
        return result;
    }

    public Iterable<CourseDTO> studentCourses(Student student){
        Iterable<Course> courses = courseEnrollmentRepo.coursesThatStudentIsEnrolledOn(student.toDTO().getMechanographicalNumber().toString());
        List<CourseDTO> result = new ArrayList<>();
        courses.forEach(a -> result.add(a.toDTO()));
        return result;
    }

    public Course findCourseByCode(String courseCode){
        return courseRepo.findCourseByCode(courseCode);
    }

}
