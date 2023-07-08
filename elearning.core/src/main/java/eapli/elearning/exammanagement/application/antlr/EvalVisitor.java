package eapli.elearning.exammanagement.application.antlr;

import eapli.elearning.coursemanagement.application.CourseService;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.exammanagement.application.ExamService;
import eapli.elearning.exammanagement.application.antlr.documents.US2001BaseVisitor;
import eapli.elearning.exammanagement.application.antlr.documents.US2001Parser;
import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.exammanagement.domain.ExamType;
import eapli.elearning.examquestionmanagement.application.ExamQuestionService;
import eapli.elearning.examquestionmanagement.domain.ExamQuestion;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionResult;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionType;
import eapli.elearning.examsectionmanagement.application.ExamSectionService;
import eapli.elearning.examsectionmanagement.domain.ExamSection;
import org.antlr.v4.runtime.tree.ParseTree;

import java.time.LocalDateTime;
import java.util.*;

public class EvalVisitor extends US2001BaseVisitor<Integer> {

    private ExamService examService = new ExamService();
    private CourseService courseService = new CourseService();
    private ExamSectionService sectionService = new ExamSectionService();
    private ExamQuestionService questionService = new ExamQuestionService();
    private String title;
    private String header = "";
    private Set<ExamSection> sections = new HashSet<>();
    private String sectionsDescription;
    private Set<ExamQuestion> questions = new HashSet<>();
    private List<String> solutions = new ArrayList<>();
    private String statement;
    private HashMap<ExamQuestionResult,String> feedbacks = new HashMap<>();
    private LocalDateTime initalDateTime;
    private LocalDateTime finalDateTime;
    private Course course;
    private Integer segundos = 0;

    public Exam buildExam(ParseTree tree){
        visit(tree);
        Iterable<Exam> teste = examService.findExamByTitle(title);
        if(teste.iterator().hasNext()){
            System.out.println("Já existe um exame com esse nome");
            return teste.iterator().next();
        }
        return examService.createExam(title, header, sections, course, ExamType.NORMAL, initalDateTime, finalDateTime);
    }



    @Override
    public Integer visitInicaldate(US2001Parser.InicaldateContext ctx) {
        int ano = Integer.parseInt(ctx.NUMBER(0).getText());
        int mes = Integer.parseInt(ctx.NUMBER(1).getText());
        int dia = Integer.parseInt(ctx.NUMBER(2).getText());
        int hora = Integer.parseInt(ctx.NUMBER(3).getText());
        int minuto = Integer.parseInt(ctx.NUMBER(4).getText());
        initalDateTime = LocalDateTime.of(ano, mes, dia, hora, minuto, segundos);
        return super.visitInicaldate(ctx);
    }
    @Override
    public Integer visitFinaldate(US2001Parser.FinaldateContext ctx) {
        int ano = Integer.parseInt(ctx.NUMBER(0).getText());
        int mes = Integer.parseInt(ctx.NUMBER(1).getText());
        int dia = Integer.parseInt(ctx.NUMBER(2).getText());
        int hora = Integer.parseInt(ctx.NUMBER(3).getText());
        int minuto = Integer.parseInt(ctx.NUMBER(4).getText());
        finalDateTime = LocalDateTime.of(ano, mes, dia, hora, minuto, segundos);
        if(finalDateTime.isBefore(initalDateTime)){
            throw new IllegalArgumentException("finalDateTime cannot be greater than initalDateTime");
        }
        return super.visitFinaldate(ctx);
    }

    @Override
    public Integer visitTitle(US2001Parser.TitleContext ctx) {
        title = ctx.TEXT().getText();
        return super.visitTitle(ctx);
    }

    @Override
    public Integer visitHeader(US2001Parser.HeaderContext ctx) {
        for (int i = 0; i < ctx.value().size(); i++) {
            header = header + ctx.value(i).getText();
        }
        return super.visitHeader(ctx);
    }

    @Override
    public Integer visitCourseCode(US2001Parser.CourseCodeContext ctx) {
        course = courseService.findCourseByCode(ctx.getText());
        return super.visitCourseCode(ctx);
    }

    @Override
    public Integer visitSection(US2001Parser.SectionContext ctx) {
        if(!questions.isEmpty()){
            Iterable<ExamSection> teste = sectionService.findSectionByDescription(sectionsDescription);
            if(teste.iterator().hasNext()){
                sections.add(teste.iterator().next());
            }else {
                sections.add(sectionService.createSection(sectionsDescription,questions));
            }
            questions.clear();
        }
        sectionsDescription = ctx.value().getText();
        return super.visitSection(ctx);
    }

    @Override
    public Integer visitQuestion(US2001Parser.QuestionContext ctx) {
        ExamQuestionType examQuestionType = null;
        if (ctx.questionType().getText().trim().equals("MATCHING")) {
            examQuestionType = ExamQuestionType.MATCHING;
            buildMatching(ctx);
        } else if (ctx.questionType().getText().trim().equals("MULTIPLE_CHOICE")) {
            examQuestionType = ExamQuestionType.MULTIPLE_CHOICE;
            buildMultiple(ctx);
        } else if (ctx.questionType().getText().trim().equals("MISSING_WORDS")) {
            examQuestionType = ExamQuestionType.MISSING_WORDS;
            buildMissing(ctx);
        } else if (ctx.questionType().getText().trim().equals("TRUE_OR_FALSE")) {
            examQuestionType = ExamQuestionType.TRUE_OR_FALSE;
            buildTF(ctx);
        } else if (ctx.questionType().getText().trim().equals("SHORT_ANSWER")) {
            examQuestionType = ExamQuestionType.SHORT_ANSWER;
            buildShort(ctx);
        } else if (ctx.questionType().getText().trim().equals("NUMERICAL")) {
            examQuestionType = ExamQuestionType.NUMERICAL;
            buildNumerical(ctx);
        }
        if(ctx.feedback() == null){
            feedbacks.put(ExamQuestionResult.GENERAL, "No feedback");
        }else{
            buildFeedback(ctx.feedback());
        }
        Iterable<ExamQuestion> teste = questionService.findQuestionByStatement(statement);
        if(teste.iterator().hasNext()){
            questions.add(teste.iterator().next());
        }else{
            questions.add(questionService.addQuestion(examQuestionType, solutions, Integer.parseInt(ctx.quotation().NUMBER().getText()), feedbacks,statement));
        }
        solutions.clear();
        feedbacks.clear();
        return super.visitQuestion(ctx);
    }

    public void buildMatching(US2001Parser.QuestionContext ctx){
        String[] solutionsList;
        for (int i = 0; i < ctx.solution().matchingsolution().size(); i++) {
            solutionsList = ctx.solution().matchingsolution(i).getText().split("\\|");
            solutions.add(solutionsList[0]);
        }
        statement = ctx.statement().getText();
        if(ctx.options().size()>0){
            buildStatementWithOptions(ctx);
        }else{
            throw new IllegalArgumentException("Matching Question must have options");
        }
    }

    public void buildMultiple(US2001Parser.QuestionContext ctx){
        String[] solutionsList;
        for (int i = 0; i < ctx.solution().multiplesolution().size(); i++) {
            solutionsList = ctx.solution().multiplesolution(i).getText().split("\\|");
            solutions.add(solutionsList[0]);
        }
        statement = ctx.statement().getText();
        if(ctx.options().size()>0){
            buildStatementWithOptions(ctx);
        }else{
            throw new IllegalArgumentException("Multiple Choice Question must have options");
        }
    }

    public void buildMissing(US2001Parser.QuestionContext ctx){
        String[] solutionsList = ctx.solution().textsolution().getText().split(",");
        for (int i = 0; i < solutionsList.length; i++) {
            solutions.add(solutionsList[i]);
        }
        statement = ctx.statement().getText();
        if(ctx.options().size()>0){
            buildStatementWithOptions(ctx);
        }else{
            throw new IllegalArgumentException("Missing Words Question must have options");
        }
    }

    public void buildShort(US2001Parser.QuestionContext ctx){
        String[] solutionsList;
        for (int i = 0; i < ctx.solution().shortsolution().size(); i++) {
            solutionsList = ctx.solution().shortsolution(i).getText().split("\\|");
            solutions.add(solutionsList[0]);
        }
        statement = ctx.statement().getText();
    }
    public void buildNumerical(US2001Parser.QuestionContext ctx){
        solutions.add(ctx.solution().textsolution().getText());
        statement = ctx.statement().getText();
    }
    public void buildTF(US2001Parser.QuestionContext ctx){
        solutions.add(ctx.solution().textsolution().getText());
        statement = ctx.statement().getText();
    }

    public void buildStatementWithOptions(US2001Parser.QuestionContext ctx){
        for (int i = 0; i < ctx.options().size(); i++) {
            statement = statement + " OP:";
            for (int j = 0; j < ctx.options(i).value().size(); j++) {
                statement = statement + ctx.options(i).value(j).TEXT().getText();
            }
        }
    }

    public void buildFeedback(US2001Parser.FeedbackContext ctx){
        if (ctx.getText().contains(",")) {
            String[] feedbackList = ctx.getText().split(",");
            for (int i = 0; i < feedbackList.length; i++) {
                feedBackMessages(ctx);
            }
        }else{
            feedBackMessages(ctx);
        }
    }
    public void feedBackMessages(US2001Parser.FeedbackContext ctx){
        if (ctx.getText().contains("INCORRECT")) {
            feedbacks.put(ExamQuestionResult.INCORRECT, ctx.getText().replace("INCORRECT", ""));
        }else if (ctx.getText().contains("PARTIALLY_CORRECT")) {
            feedbacks.put(ExamQuestionResult.PARTIALLY_CORRECT, ctx.getText().replace("PARTIALLY_CORRECT", ""));
        } else if(ctx.getText().contains("CORRECT")){
            feedbacks.put(ExamQuestionResult.CORRECT, ctx.getText().replace("CORRECT", ""));
        } else {
            feedbacks.put(ExamQuestionResult.GENERAL, ctx.getText());
        }
    }
}
