package eapli.elearning.exammanagement.application;

import eapli.elearning.exammanagement.domain.GetCourseExamsService;
import eapli.elearning.exammanagement.dto.ExamDTO;

import java.util.List;

public class GetExamsService {
    GetCourseExamsService getCourseExamsService = new GetCourseExamsService();
    public List<ExamDTO> getToDoExams() {return getCourseExamsService.getCoursesExams();}
    public List<ExamDTO> getToDoFormativeExams(){
        return getCourseExamsService.getCoursesFormativeExams();
    }

}
