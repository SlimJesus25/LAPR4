package eapli.elearning.examquestionmanagement.application.antlr.documents;

import eapli.elearning.examquestionmanagement.domain.ExamQuestionType;
import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvalVisitor extends AnswersBaseVisitor<String>{

     public ArrayList<Pair<ExamQuestionType,String>> results= new ArrayList<>();
     public ArrayList<ExamQuestionDTO> questions ;
     public Integer questionNumber=0;
     public ArrayList<Float> grades= new ArrayList<>();

    private void evaluateQuestion(List<Float> gradeQuestions, String answer, ExamQuestionDTO question) {
        switch (question.getQuestionType().toString()) {
            case "MATCHING" -> gradeQuestions.add(evaluateMatchingQuestion(question, answer));
            case "MULTIPLE_CHOICE" -> gradeQuestions.add(evaluateMultipleChoiceQuestion(question, answer));
            case "SHORT_ANSWER" -> gradeQuestions.add(evaluateShortAnswerQuestion(question, answer));
            case "NUMERICAL" -> gradeQuestions.add(evaluateNumericalQuestion(question, answer));
            case "MISSING_WORDS" -> gradeQuestions.add(evaluateMissingWordsQuestion(question, answer));
            case "TRUE_OR_FALSE" -> gradeQuestions.add(evaluateTrueFalseQuestion(question, answer));
        }
    }

    private Float evaluateMultipleChoiceQuestion(ExamQuestionDTO question, String answers) {
        Float grade=0f;
        if(answers.length()==0)return grade;
        List<String> optChosen= new ArrayList<>();
        if(answers.contains(";"))optChosen= Arrays.stream(answers.split(";")).toList();
        else optChosen.add(answers);
        Float optValue= getOptValue(question);
        for(String solution: question.getQuestionSolution()){
            if(optChosen.contains(solution))grade+=optValue;
            else grade-=optValue;
        }
        for(String answer: optChosen){
            if(!question.getQuestionSolution().contains(answer))grade-=optValue;
        }
        if(grade<0) return 0f;
        return grade;
    }
    private Float evaluateShortAnswerQuestion(ExamQuestionDTO question, String answer) {
        for(String solution:question.getQuestionSolution()){
            StringBuilder solutionBuilder= new StringBuilder();
            String[] withoutSpaces=solution.split(" ");
            for(String word : withoutSpaces)
                solutionBuilder.append(word);
            solution = solutionBuilder.toString();
            if(solution.equalsIgnoreCase(answer))
                return question.getQuestionValue().floatValue();
            }
        return 0f;
    }

    private Float evaluateNumericalQuestion(ExamQuestionDTO question, String answer) {
        for(String solution:question.getQuestionSolution()){
            if(solution.equalsIgnoreCase(answer))
                return question.getQuestionValue().floatValue();
        }
        return 0f;
    }

    private Float evaluateMissingWordsQuestion(ExamQuestionDTO question, String answers) {
        Float grade=0f;
        if(answers.length()==0)return grade;
        List<String> optChosen= new ArrayList<>();
        if(answers.contains(";")) optChosen= Arrays.stream(answers.split(";")).toList();
        else optChosen.add(answers);
        Float optValue= getOptValue(question);
        Integer x=0;
        for(String solution: question.getQuestionSolution()){
            if(optChosen.size()>x)
                if(solution.equalsIgnoreCase(optChosen.get(x))) grade+=optValue;
            x++;
        }
        return grade;
    }

    private Float evaluateMatchingQuestion(ExamQuestionDTO question, String answers) {
        Float grade=0f;
        if(answers.length()==0)return grade;
        List<String> optChosen= new ArrayList<>();
        if(answers.contains(";"))optChosen= Arrays.stream(answers.split(";")).toList();
        else optChosen.add(answers);
        Float optValue= getOptValue(question);
        for(String solution: question.getQuestionSolution()){
            if(optChosen.contains(solution))grade+=optValue;
            else grade-=optValue;
        }
        if(grade<0) return 0f;
        return grade;
    }

    private Float evaluateTrueFalseQuestion(ExamQuestionDTO question, String answer) {
        String[] splitAnswer=answer.split(";");
        for(String solution:question.getQuestionSolution()){
            if(getEqualsIgnoreForm(solution,splitAnswer[0]))
                return question.getQuestionValue().floatValue();
        }
        return 0f;
    }

    private boolean getEqualsIgnoreForm(String solution, String answer) {
        if(solution.equalsIgnoreCase(answer)) return true;
        if(solution.equalsIgnoreCase("true") && answer.equalsIgnoreCase("t")) return true;
        if(solution.equalsIgnoreCase("true") && answer.equalsIgnoreCase("true")) return true;
        if(solution.equalsIgnoreCase("f") && answer.equalsIgnoreCase("false")) return true;
        if(solution.equalsIgnoreCase("false") && answer.equalsIgnoreCase("f")) return true;
        return false;
    }
    private Float getOptValue(ExamQuestionDTO question){
        Integer solutionNumber= question.getQuestionSolution().size();
        Float optValue = (float) question.getQuestionValue() / solutionNumber;
        return Math.round(optValue * 10) / 10.0f;
    }

    private List<String> treatedAnswers(ArrayList<ExamQuestionDTO> questions,String examAnswers) {
        List<String> treatedAnswers= new ArrayList<>();
        List<String> splitAnswers =Arrays.stream(examAnswers.split("\n")).toList();
        int number=0;
        for(ExamQuestionDTO question : questions){
            String string=splitAnswers.get(number).substring(0, splitAnswers.get(number).length() - 1);
            if(string.length()>question.getQuestionType().toString().length()+1)
                treatedAnswers.add(string.substring((question.getQuestionType().toString().length())+3));
            number++;
        }
        return treatedAnswers;
    }
    public EvalVisitor(ArrayList<ExamQuestionDTO> questions) {
        this.questions = questions;
    }
      @Override
     public String visitStart(AnswersParser.StartContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitMissingWords(AnswersParser.MissingWordsContext ctx) {
        try{
            var y=ctx.WORD().getText();
            var x=0;
            results.add(Pair.of(ExamQuestionType.MISSING_WORDS,ctx.WORD().getText()));
            evaluateQuestion(grades,ctx.WORD().getText(),questions.get(questionNumber));
            questionNumber++;
            return ctx.WORD().getText();
        }catch(Exception e){
            results.add(Pair.of(ExamQuestionType.MISSING_WORDS,""));
            grades.add(0f);
            questionNumber++;
            return null;
        }
    }

    @Override
    public String visitMatchings(AnswersParser.MatchingsContext ctx) {
        try{
            Integer x=ctx.matching().getText().length();
            var y=0;
            return visitChildren(ctx);
        }catch(Exception e){
            results.add(Pair.of(ExamQuestionType.MATCHING,""));
            grades.add(0f);
            questionNumber++;
            return "";
        }
    }

    @Override
    public String visitMultipleChoice(AnswersParser.MultipleChoiceContext ctx) {
        try{
            Integer x=ctx.multiple().getText().length();
            var y=0;
            return visitChildren(ctx);
        }catch(Exception e){
            results.add(Pair.of(ExamQuestionType.MULTIPLE_CHOICE,""));
            grades.add(0f);
            questionNumber++;
            return "";
        }
    }

    @Override
    public String visitTrueOrFalse(AnswersParser.TrueOrFalseContext ctx) {
        try{
            String y=ctx.truefalse().getText();
            Integer x=ctx.truefalse().getText().length();
            return visitChildren(ctx);
        }catch(Exception e){
            results.add(Pair.of(ExamQuestionType.TRUE_OR_FALSE,""));
            grades.add(0f);
            questionNumber++;
            return "";
        }
    }

    @Override
    public String visitNumericals(AnswersParser.NumericalsContext ctx) {
          try{
              var y=0;
              results.add(Pair.of(ExamQuestionType.NUMERICAL,ctx.i.getText()));
              evaluateQuestion(grades,ctx.i.getText(),questions.get(questionNumber));
              questionNumber++;
              return visitInteger(ctx);
          }
          catch(Exception e) {
              try {
                  results.add(Pair.of(ExamQuestionType.NUMERICAL,ctx.f.getText()));
                  evaluateQuestion(grades,ctx.f.getText(),questions.get(questionNumber));
                  questionNumber++;
                  return visitFloat(ctx);
              } catch (Exception ex) {
                  try {
                      results.add(Pair.of(ExamQuestionType.NUMERICAL,ctx.fe.getText()));
                      evaluateQuestion(grades,ctx.fe.getText(),questions.get(questionNumber));
                      questionNumber++;
                      return visitCientific(ctx);
                  } catch (Exception exc) {
                      grades.add(0f);
                      results.add(Pair.of(ExamQuestionType.NUMERICAL,""));
                      questionNumber++;
                      return null;
                  }
              }
          }
    }

    private String visitCientific(AnswersParser.NumericalsContext ctx) {
        return ctx.fe.getText();
    }

    private String visitFloat(AnswersParser.NumericalsContext ctx) {
        return ctx.f.getText();
    }

    private String visitInteger(AnswersParser.NumericalsContext ctx) {
          return ctx.i.getText();
    }

    @Override
    public String visitShortAnswer(AnswersParser.ShortAnswerContext ctx) {
          try{
              var y=ctx.WORD().getText();
              evaluateQuestion(grades,ctx.WORD().getText(),questions.get(questionNumber));
              results.add(Pair.of(ExamQuestionType.SHORT_ANSWER,ctx.WORD().getText()));
              questionNumber++;
              return ctx.WORD().getText();
          }
          catch (Exception e){
              grades.add(0f);
              results.add(Pair.of(ExamQuestionType.SHORT_ANSWER,""));
              questionNumber++;
              return null;
          }

    }

    @Override
    public String visitTruefalse(AnswersParser.TruefalseContext ctx) {
        results.add(Pair.of(ExamQuestionType.TRUE_OR_FALSE,ctx.getText()));
        evaluateQuestion(grades,ctx.getText(),questions.get(questionNumber));
        questionNumber++;
        return ctx.getText();
    }

    @Override
    public String visitMatching(AnswersParser.MatchingContext ctx) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ctx.INTEGER().size(); i++) {
            sb.append(ctx.INTEGER(i).toString());
            if(i%2==0)
                sb.append("&");
            else
                sb.append(";");
        }
        results.add(Pair.of(ExamQuestionType.MATCHING,sb.toString()));
        evaluateQuestion(grades,sb.toString(),questions.get(questionNumber));
        questionNumber++;
        return sb.toString();
    }

    @Override
    public String visitMultiple(AnswersParser.MultipleContext ctx) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ctx.INTEGER().size(); i++) {
            sb.append(ctx.INTEGER(i).toString());
            sb.append(";");
        }
        results.add(Pair.of(ExamQuestionType.MULTIPLE_CHOICE,sb.toString()));
        evaluateQuestion(grades,sb.toString(),questions.get(questionNumber));
        questionNumber++;
        return sb.toString();
    }

}
