package eapli.elearning.teachermanagement.application;

import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.coursemanagement.repositories.CourseRepository;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.framework.application.ApplicationService;

@ApplicationService
public class FindCourseRegentService {

    private final CourseRepository repo = PersistenceContext.repositories().courses();

    public TeacherDTO findCourseRegent(CourseDTO course){
        return repo.findRegentOf(course.getCourseCode()).toDTO();
    }
}
