package eapli.elearning.automaticformativeexammanagement.application.antlr;

import eapli.elearning.automaticformativeexammanagement.application.antlr.documents.QuestionBaseVisitor;
import eapli.elearning.automaticformativeexammanagement.application.antlr.documents.QuestionParser;
import eapli.elearning.examquestionmanagement.application.ExamQuestionService;
import eapli.elearning.examquestionmanagement.domain.ExamQuestion;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionResult;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionType;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

public class EvalVisitor extends QuestionBaseVisitor<Integer> {
    private ExamQuestionService examQuestionService = new ExamQuestionService();
    private ExamQuestionType examQuestionType;
    private ExamQuestion question;
    private String statement = "";
    private Integer value;
    private List<String> solutions = new ArrayList<>();
    private HashMap<ExamQuestionResult,String> feedbacks = new HashMap<>();



    public ExamQuestion buildQuestion(ParseTree tree) {
        visit(tree);
        return examQuestionService.addQuestion(examQuestionType,solutions,value,feedbacks,statement);
    }

    @Override
    public Integer visitQuestion(QuestionParser.QuestionContext ctx) {
        return super.visitQuestion(ctx);
    }

    @Override
    public Integer visitMatchingQuestion(QuestionParser.MatchingQuestionContext ctx) {
        examQuestionType = ExamQuestionType.MATCHING;
        return super.visitMatchingQuestion(ctx);
    }

    @Override
    public Integer visitMatchingalinea(QuestionParser.MatchingalineaContext ctx) {
        statement = statement + " " + ctx.getText();
        return super.visitMatchingalinea(ctx);
    }

    @Override
    public Integer visitMatchingsolution(QuestionParser.MatchingsolutionContext ctx) {
        solutions.add(ctx.getText().substring(4));
        return super.visitMatchingsolution(ctx);
    }

    @Override
    public Integer visitMatchingcotacao(QuestionParser.MatchingcotacaoContext ctx) {
        value = Integer.parseInt(ctx.getText().substring(8,ctx.getText().length()-1));
        return super.visitMatchingcotacao(ctx);
    }

    @Override
    public Integer visitMatchingquestionText(QuestionParser.MatchingquestionTextContext ctx) {
        statement = statement + " " + ctx.matchingtext().WORD().getText();
        return super.visitMatchingquestionText(ctx);
    }

    @Override
    public Integer visitMultipleChoiceQuestion(QuestionParser.MultipleChoiceQuestionContext ctx) {
        examQuestionType = ExamQuestionType.MULTIPLE_CHOICE;
        return super.visitMultipleChoiceQuestion(ctx);
    }

    @Override
    public Integer visitMultiplealinea(QuestionParser.MultiplealineaContext ctx) {
        statement = statement + " " + ctx.getText();
        return super.visitMultiplealinea(ctx);
    }

    @Override
    public Integer visitMultiplesolution(QuestionParser.MultiplesolutionContext ctx) {
        solutions.add(ctx.getText().substring(4));
        return super.visitMultiplesolution(ctx);
    }

    @Override
    public Integer visitMultiplecotacao(QuestionParser.MultiplecotacaoContext ctx) {
        value = Integer.parseInt(ctx.getText().substring(8,ctx.getText().length()-1));
        return super.visitMultiplecotacao(ctx);
    }

    @Override
    public Integer visitMultiplequestionText(QuestionParser.MultiplequestionTextContext ctx) {
        statement = statement + " " + ctx.multipletext().WORD().getText();
        return super.visitMultiplequestionText(ctx);
    }

    @Override
    public Integer visitSelectMissingWordsQuestion(QuestionParser.SelectMissingWordsQuestionContext ctx) {
        examQuestionType = ExamQuestionType.MISSING_WORDS;
        return super.visitSelectMissingWordsQuestion(ctx);
    }

    @Override
    public Integer visitMissingalinea(QuestionParser.MissingalineaContext ctx) {
        statement = statement + " " + ctx.getText();
        return super.visitMissingalinea(ctx);
    }

    @Override
    public Integer visitMissingquestion(QuestionParser.MissingquestionContext ctx) {
        statement = statement + " " + ctx.missingquestionText().getText();
        return super.visitMissingquestion(ctx);
    }

    @Override
    public Integer visitMissingsolution(QuestionParser.MissingsolutionContext ctx) {
        solutions.add(ctx.missingquestionText().getText());
        return super.visitMissingsolution(ctx);
    }

    @Override
    public Integer visitMissingcotacao(QuestionParser.MissingcotacaoContext ctx) {
        value = Integer.parseInt(ctx.missingnumber().INT().getText());
        return super.visitMissingcotacao(ctx);
    }

    @Override
    public Integer visitFeedback(QuestionParser.FeedbackContext ctx) {
        if (ctx.getText().contains(",")) {
            String[] feedbackList = ctx.getText().split("");
            for (int i = 0; i < feedbackList.length; i++) {
                if (feedbackList[i].contains("INCORRECT")) {
                    feedbacks.put(ExamQuestionResult.INCORRECT, feedbackList[i].replace("INCORRECT", ""));
                }else if (feedbackList[i].contains("PARTIALLY_CORRECT")) {
                    feedbacks.put(ExamQuestionResult.PARTIALLY_CORRECT, feedbackList[i].replace("PARTIALLY_CORRECT", ""));
                }else if(feedbackList[i].contains("CORRECT")){
                    feedbacks.put(ExamQuestionResult.CORRECT, feedbackList[i].replace("CORRECT", ""));
                } else {
                    feedbacks.put(ExamQuestionResult.GENERAL, ctx.getText());
                }
            }
        }else{
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
        return super.visitFeedback(ctx);
    }

    @Override
    public Integer visitTrueFalseQuestion(QuestionParser.TrueFalseQuestionContext ctx) {
        examQuestionType = ExamQuestionType.TRUE_OR_FALSE;
        return super.visitTrueFalseQuestion(ctx);
    }

    @Override
    public Integer visitTfsolution(QuestionParser.TfsolutionContext ctx) {
        solutions.add(ctx.truefalseOptions().getText());
        return super.visitTfsolution(ctx);
    }

    @Override
    public Integer visitTfcotacao(QuestionParser.TfcotacaoContext ctx) {
        value = Integer.parseInt(ctx.tfnumber().INT().getText());
        return super.visitTfcotacao(ctx);
    }

    @Override
    public Integer visitTfquestionText(QuestionParser.TfquestionTextContext ctx) {
        statement = statement + " " + ctx.WORD().getText();
        return super.visitTfquestionText(ctx);
    }
}
