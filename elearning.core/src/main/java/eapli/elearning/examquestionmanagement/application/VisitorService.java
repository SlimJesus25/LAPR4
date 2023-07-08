package eapli.elearning.examquestionmanagement.application;


//import eapli.elearning.examquestionmanagement.application.antlr.documents.EvalVisitor;
import eapli.elearning.examquestionmanagement.application.antlr.documents.AnswersLexer;
import eapli.elearning.examquestionmanagement.application.antlr.documents.AnswersParser;
import eapli.elearning.examquestionmanagement.application.antlr.documents.EvalVisitor;
import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.framework.application.ApplicationService;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationService
public class VisitorService {
    public List<Float> visit(String treatedExam, ArrayList<ExamQuestionDTO> questions) throws IOException {
        String path = "exam2.txt";
        File file = new File(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(treatedExam);
        writer.close();
        AnswersLexer lexer = new AnswersLexer(CharStreams.fromFileName("exam2.txt"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AnswersParser parser = new AnswersParser(tokens);
        ParseTree tree = parser.start();
        EvalVisitor visitor = new EvalVisitor(questions);
        visitor.visit(tree);
        return visitor.grades;
    }
}
