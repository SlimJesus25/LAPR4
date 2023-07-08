package eapli.elearning.exammanagement.domain.formativeexamantlr;


import eapli.elearning.examquestionmanagement.domain.ExamQuestionType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/


public class EvalVisitor extends FormativeExamBaseVisitor<Integer> {
    static String examTitle;
    static String examHeader;
    static String feedback;
    static String grade;
    static String section;
    static HashMap<String, List<ExamQuestionType>> questions = new HashMap<>();
    static List<ExamQuestionType> questionTypeList = new ArrayList<>();

    public static String getExamTitle() {
        return examTitle;
    }

    public static String getExamHeader() {
        return examHeader;
    }

    public static String getFeedback() {
        return feedback;
    }

    public static String getGrade() {
        return grade;
    }

    public static String getSection() {
        return section;
    }

    public static HashMap<String, List<ExamQuestionType>> getQuestions() {
        return questions;
    }

    @Override
    public Integer visitStart(FormativeExamParser.StartContext ctx) {
        visitChildren(ctx);

//        System.out.println("\tTitle\n" + examTitle);
//        System.out.println("\tHeader\nFeedback: " + feedback + "\nGrade: " + grade);
//        System.out.println("\n\tQuestion types\n");
//        for(Map.Entry<String, List<ExamQuestionType>> sections : questions.entrySet()){
//            System.out.println("Section " + sections.getKey());
//            for(ExamQuestionType type : sections.getValue()){
//                System.out.println(type);
//            }
//        }

        return 0;
    }

    @Override
    public Integer visitTitle(FormativeExamParser.TitleContext ctx) {
        if(ctx.TEXT().getText() == null){
            throw new IllegalArgumentException("Title needs to exist!");
        }
        examTitle = ctx.TEXT().getText();
        return 0;
    }

    @Override
    public Integer visitHeader(FormativeExamParser.HeaderContext ctx) {
        if(ctx.hasText.getText() != null){
            examHeader = ctx.hasText.getText();
        }else{
            examHeader = "";
        }
        visitChildren(ctx);
        return 0;
    }


    @Override
    public Integer visitHeader_feedback_grade(FormativeExamParser.Header_feedback_gradeContext ctx) {
        feedback = ctx.left.getText();
        grade = ctx.rigth.getText();
        return 0;
    }

    @Override
    public Integer visitSectionText(FormativeExamParser.SectionTextContext ctx) {
        if(ctx.TEXT().getText() == null)
            throw new IllegalArgumentException("Section needs text!");
        section = ctx.TEXT().getText();
        questionTypeList = new ArrayList<>();
        visitChildren(ctx);
        questions.put(section, questionTypeList);
        return 0;
    }

    @Override
    public Integer visitSectionNoText(FormativeExamParser.SectionNoTextContext ctx) {
        return super.visitSectionNoText(ctx);
    }

    @Override
    public Integer visitQuestion(FormativeExamParser.QuestionContext ctx) {
        if(ctx.QUESTION_TYPE().getText() == null)
            throw new IllegalArgumentException("Invalid question type!");
        ExamQuestionType questionType;
        switch (ctx.QUESTION_TYPE().getText()) {
            case "matching" -> questionType = ExamQuestionType.MATCHING;
            case "multiple choice" -> questionType = ExamQuestionType.MULTIPLE_CHOICE;
            case "short answer" -> questionType = ExamQuestionType.SHORT_ANSWER;
            case "numerical" -> questionType = ExamQuestionType.NUMERICAL;
            case "select missing words" -> questionType = ExamQuestionType.MISSING_WORDS;
            case "true or false" -> questionType = ExamQuestionType.TRUE_OR_FALSE;
            default -> questionType = null;
        }
        questionTypeList.add(questionType);

        return 0;
    }
}
