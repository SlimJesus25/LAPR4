package eapli.elearning.coursemanagement.application;

import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.teachermanagement.dto.TeacherDTO;
import eapli.framework.application.UseCaseController;

import java.util.List;
import java.util.Set;


@UseCaseController
public interface SetTeachersController {

    CourseDTO setTeachersTo(String courseId, Set<TeacherDTO> teachers);

    Iterable<CourseDTO> listCourses();

    List<TeacherDTO> listTeachers();



}
