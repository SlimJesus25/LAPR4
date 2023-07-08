package eapli.elearning.app.user.console.presentation.formerexam;

import eapli.elearning.app.user.console.presentation.exam.ExamDTOPrinter;
import eapli.elearning.exammanagement.application.*;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.examquestionmanagement.application.VisitorService;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionResult;
import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.elearning.formerexammanagement.application.CreateFormerExamController;
import eapli.elearning.studentmanagement.application.FindStudentByUsernameService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import org.checkerframework.checker.guieffect.qual.UI;
import eapli.framework.io.util.Console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@UI
public class TakeExamUI extends AbstractUI {
    CreateFormerExamController createFormerExamController = new CreateFormerExamController();
    FindStudentByUsernameService findStudentByUsernameService = new FindStudentByUsernameService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    GetSumExamQuestionValuesService getSumExamQuestionValuesService = new GetSumExamQuestionValuesService();
    FindExamByExamTitleService findExamByExamTitleService= new FindExamByExamTitleService();
    ExportExamService exportExamService = new ExportExamService();
    ImportExamService importExamService = new ImportExamService();
    EvaluateService evaluateService = new EvaluateService();
    GetExamsService getExamsService = new GetExamsService();
    VisitorService visitorService = new VisitorService();
    FormerExamValidationService formerExamValidationService = new FormerExamValidationService();
    @Override
    protected boolean doShow() {
        List<ExamDTO> studentNotDoneExams= getToDoExams();
        ExamDTO exam= examDTOSelectWidget(studentNotDoneExams);
        if(exam==null) return false;
        ArrayList<ExamQuestionDTO> questions=exportExamService.createFileTxt(exam);
        checkWhenFinished();
        String treatedExam= importExamService.getVitalExamInformation(getExam(),questions);
        if(formerExamValidationService.validate(exam)) {
            try {
                visitorService.visit(treatedExam,questions);
            } catch (IOException e) {
                System.out.println("An unexpected error occurred. Please try again later.");
                return false;
            }
            List<Float> grades = evaluateService.evaluateExam(treatedExam, questions);
            Integer finalGrade = showGradesAndFeedBack(grades, questions);
            createFormerExamController.createFormerExam(finalGrade, findExamByExamTitleService.findExamByExamTitle(exam.getExamTitle()), findStudentByUsernameService.findStudentByUsername(authz.session().get().authenticatedUser().username()));
        }
        else System.out.println("\nUnfortunately the exam is already finished. You can't submit it.");
        return false;
    }

    private Integer showGradesAndFeedBack(List<Float> grades, List<ExamQuestionDTO> questions) {
        Float finalGrade=0f;
        Integer gradeNumber=0;
        for (ExamQuestionDTO question: questions){
            System.out.println(question.getQuestionStatement());
            showFeedBack(question,grades,gradeNumber);
            System.out.println("Grade : "+grades.get(gradeNumber));
            finalGrade+=grades.get(gradeNumber);
            gradeNumber++;
        }
        Float sum= getSumExamQuestionValuesService.getSumExamQuestionValues(questions);
        System.out.println("\n Your final grade: "+finalGrade+"/"+sum+" " + Math.round(finalGrade/sum*100) +"%");
        return getSumExamQuestionValuesService.getGradeInScale(finalGrade,sum);
    }

    private void showFeedBack(ExamQuestionDTO question, List<Float> grades, Integer gradeNumber) {

        if(question.getQuestionFeedback().containsKey(ExamQuestionResult.GENERAL))
            System.out.println(question.getQuestionFeedback().get(ExamQuestionResult.GENERAL));
        if(grades.get(gradeNumber).equals(0f) && question.getQuestionFeedback().containsKey(ExamQuestionResult.INCORRECT)) System.out.println(question.getQuestionFeedback().get(ExamQuestionResult.INCORRECT));
        else if(grades.get(gradeNumber).equals(question.getQuestionValue().floatValue()) && question.getQuestionFeedback().containsKey(ExamQuestionResult.CORRECT)) System.out.println(question.getQuestionFeedback().get(ExamQuestionResult.CORRECT));
        else if(grades.get(gradeNumber) < question.getQuestionValue().floatValue() && grades.get(gradeNumber) > 0f && question.getQuestionFeedback().containsKey(ExamQuestionResult.PARTIALLY_CORRECT)) System.out.println(question.getQuestionFeedback().get(ExamQuestionResult.PARTIALLY_CORRECT));
    }

    private String getExam() {
        String path = Console.readLine("Save the file before you submit the exam. File path: ");
        if(importExamService.readFileContent(path)!=null) return importExamService.readFileContent(path);
        System.out.println("An error occurred while trying to get your exam in path: " + path + ". Please try again!");
        return getExam();
    }
    private void checkWhenFinished() {
        Console.readLine("Press [ENTER] when you finish the exam!");
    }
    private ExamDTO examDTOSelectWidget(List<ExamDTO> exams) {
        final SelectWidget<ExamDTO> examDTOSelectWidget =
                new SelectWidget<>("Exams \n", exams, new ExamDTOPrinter());
        examDTOSelectWidget.show();
        return examDTOSelectWidget.selectedElement();
    }
    private List<ExamDTO> getToDoExams() {
        return getExamsService.getToDoExams();
    }

    @Override
    public String headline() {
        return "Take a Exam";
    }
}
