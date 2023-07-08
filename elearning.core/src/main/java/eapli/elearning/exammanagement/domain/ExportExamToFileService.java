package eapli.elearning.exammanagement.domain;

import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.elearning.examsectionmanagement.dto.ExamSectionDTO;
import eapli.framework.domain.services.DomainService;
import org.springframework.data.util.Pair;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@DomainService
public class ExportExamToFileService {
    ArrayList<ExamQuestionDTO> questions= new ArrayList<>();
    public String getContentToFile(ExamDTO exam) {
        if(exam==null)return null;
        StringBuilder content= new StringBuilder( exam.getExamTitle() + " - " +
                exam.getCourse().getCourseTitle() + "\n\n");
        content.append(initializeExamInfo());
        for(ExamSectionDTO section : exam.getExamSection()){
            Integer questionNumber=1;
            content.append("Section -").append(section.getDescription()).append("\n\n");
            for(ExamQuestionDTO question : section.getQuestions()){
                content.append(question.getQuestionType().toString())
                        .append(" - Question ").append(questionNumber).append(" - ")
                        .append(question.getQuestionStatement()).append(" ").
                        append(question.getQuestionValue())
                        .append("pts \n");
                content.append(" Answer: ").append("\n\n");
                this.questions.add(question);
                questionNumber++;
            }
        }

        return content.toString();
    }
    private String initializeExamInfo() {
        return "********************************************************************************************\n" +
                "!!!EXAME INFO!!!\n" +
                "\n" +
                "DON'T DELETE OR ALTER ANY TEXT ALREADY WRITTEN, EVEN THE SPACES.\n" +
                "THE QUESTION ARE ANSWERED IN THE LINE: \" Answer: \".\n" +
                "DON'T DO PARAGRAPHS UNLESS YOU THINK THEY ARE RELEVANT TO YOUR ANSWER.\n" +
                "\n" +
                "FORMAT OF YOUR ANSWERS:\n" +
                "\n" +
                "THE PARENTESES AND ELLIPSIS ARE NOT WRITTEN!\n" +
                "\n" +
                "MATCHING->(FIRST NUMBER OF THE FIRST CONNECTION)&(SECOND NUMBER OF THE FIRST CONNECTION);...\n" +
                "MULTIPLE_CHOICE->(OPTION NUMBER);(OPTION NUMBER);...\n" +
                "SHORT_ANSWER->(WRITE FREELY)\n" +
                "NUMERICAL->(WRITE AN INTEGER, A DECIMAL OR A SCHIENTIFIC NOTATION NUMBER)\n" +
                "MISSING_WORDS->(FIRST WORD);(SECOND WORD);...\n" +
                "TRUE_OR_FALSE->(F)(T) OR (FALSE)(TRUE)\n" +
                "********************************************************************************************\n\n";
    }
    public ArrayList<ExamQuestionDTO> createFileTxt(ExamDTO exam){
        String content= getContentToFile(exam);
        String home = System.getProperty("user.home");
        String path = home + "/Downloads/" + "exam2.txt";
        try {
            File file = new File(path);
            file.getParentFile().mkdirs();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
            writer.close();

            System.out.println("File created with success!");
        } catch (IOException e) {
            System.out.println("An error occurred creating the file: " + e.getMessage());
        }
        return questions;
    }
}
