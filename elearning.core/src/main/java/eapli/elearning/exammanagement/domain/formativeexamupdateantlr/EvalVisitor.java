package eapli.elearning.exammanagement.domain.formativeexamupdateantlr;

import eapli.elearning.exammanagement.application.FindExamByExamTitleService;
import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class EvalVisitor extends UpdateFormativeExamBaseVisitor<Integer>{
    private Exam exam;
    private FindExamByExamTitleService svc = new FindExamByExamTitleService();
    private HashMap<String, List<ExamQuestionType>> sections = new HashMap<>();
    private List<ExamQuestionType> questions = new ArrayList<>();

    public Exam exam() {
        return exam;
    }

    public HashMap<String, List<ExamQuestionType>> sections() {
        return sections;
    }

    @Override
    public Integer visitStart(UpdateFormativeExamParser.StartContext ctx) {
        visitChildren(ctx);
        return 0;
    }

    @Override
    public Integer visitTitle(UpdateFormativeExamParser.TitleContext ctx) {
        String examTitle = ctx.TEXT().getText();
        exam = svc.findExamByExamTitle(examTitle);
        if(exam == null){
            throw new IllegalArgumentException("There is no exam with the name \"" + examTitle + "\" to update");
        }
        return 0;
    }

    @Override
    public Integer visitSectionText(UpdateFormativeExamParser.SectionTextContext ctx) {
        String section = ctx.TEXT().getText();
        questions = new ArrayList<>();
        sections.put(section, questions);
        visitChildren(ctx);
        return 0;
    }

    @Override
    public Integer visitQuestion(UpdateFormativeExamParser.QuestionContext ctx) {
        String questionType = ctx.QUESTION_TYPE().getText();
        ExamQuestionType type = switch (questionType) {
            case "matching" -> ExamQuestionType.MATCHING;
            case "multiple choice" -> ExamQuestionType.MULTIPLE_CHOICE;
            case "short answer" -> ExamQuestionType.SHORT_ANSWER;
            case "numerical" -> ExamQuestionType.NUMERICAL;
            case "select missing words" -> ExamQuestionType.MISSING_WORDS;
            case "true or false" -> ExamQuestionType.TRUE_OR_FALSE;
            default -> null;
        };

        questions.add(type);

        return 0;
    }
}
