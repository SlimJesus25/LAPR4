package eapli.elearning.app.user.console.presentation.exam;

import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.elearning.examsectionmanagement.dto.ExamSectionDTO;
import eapli.framework.visitor.Visitor;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class ExamPrinter implements Visitor<ExamDTO> {
    @Override
    public void visit(ExamDTO visitee) {
        Integer questionNumber = 1;
        System.out.println("Title: " + visitee.getExamTitle() + "\n" + "Header: " + visitee.getExamHeader());
        for(ExamSectionDTO section : visitee.getExamSection()){
            System.out.println("\nSection: " + section.getDescription());
            for(ExamQuestionDTO question : section.getQuestions()){
                System.out.println("Question: " + questionNumber + ". " + question.getQuestionStatement());
                System.out.println("Solution: " + question.getQuestionSolution());
                questionNumber++;
            }
        }
    }
}
