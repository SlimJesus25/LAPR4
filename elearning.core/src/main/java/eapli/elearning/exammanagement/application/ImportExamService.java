package eapli.elearning.exammanagement.application;

import eapli.elearning.exammanagement.domain.ImportExamFromFileService;
import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.framework.application.ApplicationService;

import java.util.ArrayList;

@ApplicationService
public class ImportExamService {
    ImportExamFromFileService importExamFromFileService = new ImportExamFromFileService();
    public String readFileContent(String filePath) {
        return importExamFromFileService.readFileContent(filePath);
    }
    //TODO: SERA ISTO NO CNTRL?
    public String getVitalExamInformation(String doneExam, ArrayList<ExamQuestionDTO> questions) {
        return importExamFromFileService.getVitalExamInformation(doneExam, questions);
    }
}
