package eapli.elearning.exammanagement.domain;

import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionSolution;
import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.elearning.examsectionmanagement.dto.ExamSectionDTO;
import eapli.framework.application.ApplicationService;
import eapli.framework.domain.services.DomainService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DomainService
public class EvaluateExamService {
    public List<Float> evaluateExam(String examAnswers, ArrayList<ExamQuestionDTO> questions){
        List<Float> gradeQuestions= new ArrayList<>();
        List<String> splitAnswers = treatedAnswers(questions,examAnswers);
        int numberQuestion=0;
        for(ExamQuestionDTO question: questions) {
            if (numberQuestion == splitAnswers.size()) gradeQuestions.add(0f);
            else {
                evaluateQuestion(gradeQuestions, splitAnswers.get(numberQuestion), question);
                numberQuestion++;
            }
        }
        return gradeQuestions;
    }

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
        for(String solution:question.getQuestionSolution()){
            if(getEqualsIgnoreForm(solution,answer))
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
}
