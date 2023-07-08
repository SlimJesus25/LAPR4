package eapli.elearning.courseenrollmentmanagement.application;

import eapli.elearning.courseenrollmentmanagement.domain.CourseEnrollmentDate;
import eapli.elearning.courseenrollmentmanagement.domain.StudentEnrollmentState;
import eapli.elearning.courseenrollmentmanagement.persistance.CourseEnrollmentRepository;
import eapli.elearning.coursemanagement.application.CourseService;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.infrastructure.persistence.PersistenceContext;

import eapli.elearning.studentmanagement.application.StudentService;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.framework.application.ApplicationService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
@ApplicationService
public class ReadBulkStudentEnrollmentCSVService {
    private final StudentService findStudent = new StudentService();
    private final CourseService findCourse = new CourseService();
    private final CourseEnrollmentService enroll = new CourseEnrollmentService();
    private final CourseEnrollmentRepository repo = PersistenceContext.repositories().courseEnrollments();


    public ArrayList<String> bulkRegisterStudents(File file){
        ArrayList<String> erros = new ArrayList<>();
        int contador = 2;
        if(!file.getName().toLowerCase().endsWith(".csv")){
            erros.add("The given file isnt a CSV.");
            return erros;
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] argumentos = line.split("[,;]");
                if(argumentos.length == 0 || argumentos.length > 2){
                    erros.add("This CSV file isnt correctly formated or there is no content on line " + contador);
                }else{
                    try{
                        Student aluno = findStudent.findStudentByMechanographicalNumber(argumentos[0]);
                        Course curso = findCourse.findCourseByCourseCode(argumentos[1]);
                        if(!verifyEnrollmentExists(curso,aluno)){
                            enroll.createCourseEnrollment(curso,aluno, new CourseEnrollmentDate(LocalDate.now()), StudentEnrollmentState.ENROLLED);
                            erros.add("Student enrollment successfully created on line " + contador);
                        }else{
                            erros.add("Student alread has an enrollment in that course on line " + contador);
                        }
                    }catch (Exception e){
                        erros.add("Student or Course Invalid on line " + contador);
                    }
                }
                contador++;
            }
            return erros;
        }catch (Exception e){
            erros.add("There was a problem reading the file at line " + contador);
            return erros;
        }
    }

    private boolean verifyEnrollmentExists(Course curso, Student aluno){
        Iterable<Course> iterableCoursesStudentEnrolled = repo.checkIfStudentEnrolledInCourse(curso,aluno);
        for (Course element : iterableCoursesStudentEnrolled) {
            if(element.sameAs(curso)){
                return true;
            }
        }
        return false;
    }
}
