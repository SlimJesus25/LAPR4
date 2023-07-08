package eapli.elearning.exammanagement.domain;

import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.framework.domain.services.DomainService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@DomainService
public class ImportExamFromFileService {
    public  String readFileContent(String filePath) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
        } catch (IOException e) {
            return null;
        }
        return content.toString();
    }
    public String getVitalExamInformation(String doneExam, ArrayList<ExamQuestionDTO> questions) {
        StringBuilder answers= new StringBuilder();
        StringBuilder treatedExam= new StringBuilder();
        String[] lines=doneExam.split("\n");
        Integer lineNumber=1;
        for(String line : lines){
            if(line.contains("Answer:")&&lineNumber>21){
                String answer=line.split(":")[1]+"\n";
                String[] withoutSpaces=answer.split(" ");
                for(String word : withoutSpaces){
                    answers.append(word);
                }

            }
            lineNumber++;
        }
        String[] separatedAnswers=answers.toString().split("\n");
        Integer answerIndex=0;
        for(ExamQuestionDTO question : questions){
            treatedExam.append(question.getQuestionType().toString()).append(" -");
            if(answerIndex<separatedAnswers.length)
                treatedExam.append(separatedAnswers[answerIndex]).append("\n");
            else
                treatedExam.append("\n");
            answerIndex++;
        }
        String[] treatedExamLines=treatedExam.toString().split("\n");
        StringBuilder treatedExamFinal= new StringBuilder();

        for(String line : treatedExamLines){
            treatedExamFinal.append(line.replace("\r",";")).append("\n");
        }

        return treatedExamFinal.toString();
    }
}
