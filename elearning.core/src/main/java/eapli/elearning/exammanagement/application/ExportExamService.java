package eapli.elearning.exammanagement.application;

import eapli.elearning.exammanagement.domain.ExportExamToFileService;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.framework.application.ApplicationService;

import java.util.ArrayList;

@ApplicationService
public class ExportExamService {
    ExportExamToFileService exportExamToFileService = new ExportExamToFileService();
    public ArrayList<ExamQuestionDTO> createFileTxt(ExamDTO exam) {
        return exportExamToFileService.createFileTxt(exam);
    }
}
