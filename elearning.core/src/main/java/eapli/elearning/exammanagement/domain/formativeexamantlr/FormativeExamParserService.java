package eapli.elearning.exammanagement.domain.formativeexamantlr;

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
public class FormativeExamParserService {
    String title;
    String header;
    HashMap<String, List<ExamQuestionType>> sections;

    public String title() {
        return title;
    }

    public String header() {
        return header;
    }

    public HashMap<String, List<ExamQuestionType>> sections() {
        return sections;
    }

    public void parse(String path) throws IOException {
        FormativeExamLexer lexer = new FormativeExamLexer(CharStreams.fromFileName(path));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FormativeExamParser parser = new FormativeExamParser(tokens);
        ParseTree tree = parser.start();
        parseWithVisitor(tree);
        title = EvalVisitor.getExamTitle();
        header = EvalVisitor.getExamHeader();
        sections = EvalVisitor.getQuestions();
    }

    public static void parseWithVisitor(ParseTree tree) {
        EvalVisitor eval = new EvalVisitor();
        Integer value = eval.visit(tree);
        if(value < 0){
            throw new IllegalArgumentException("An error occurred creating the exam!");
        }
    }
}
