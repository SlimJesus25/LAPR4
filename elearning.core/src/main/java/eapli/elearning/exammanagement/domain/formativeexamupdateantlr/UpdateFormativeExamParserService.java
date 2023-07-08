package eapli.elearning.exammanagement.domain.formativeexamupdateantlr;

import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.exammanagement.domain.formativeexamupdateantlr.EvalVisitor;

import eapli.elearning.examquestionmanagement.domain.ExamQuestionType;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author : Ricardo Venâncio - 1210828
 **/

@Service
public class UpdateFormativeExamParserService {

    private static Exam exam;
    private static HashMap<String, List<ExamQuestionType>> sections;

    public Exam exam() {
        return exam;
    }

    public HashMap<String, List<ExamQuestionType>> sections() {
        return sections;
    }

    public void parse(String path) throws IOException {
        UpdateFormativeExamLexer lexer = new UpdateFormativeExamLexer(CharStreams.fromFileName(path));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        UpdateFormativeExamParser parser = new UpdateFormativeExamParser(tokens);
        ParseTree tree = parser.start();
        parseWithVisitor(tree);
    }

    public static void parseWithVisitor(ParseTree tree) {
        EvalVisitor eval = new EvalVisitor();
        Integer value = eval.visit(tree);
        if(value < 0){
            throw new IllegalArgumentException("An error occurred creating the exam!");
        }
        exam = eval.exam();
        sections = eval.sections();
    }
}
