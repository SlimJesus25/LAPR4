package eapli.elearning.automaticformativeexammanagement.application.antlr;

//import eapli.elearning.examquestionmanagement.application.antlr.documents.AnswersLexer;
//import eapli.elearning.examquestionmanagement.application.antlr.documents.AnswersParser;
import eapli.elearning.automaticformativeexammanagement.application.antlr.documents.QuestionLexer;
import eapli.elearning.automaticformativeexammanagement.application.antlr.documents.QuestionParser;
import eapli.elearning.examquestionmanagement.domain.ExamQuestion;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.ArrayList;

public class VerifyQuestionAntlrService {
    public ArrayList<String> verifyQuestion (String filePath) throws IOException {
        ArrayList<String> results = new ArrayList<>();
        if(filePath.isEmpty() || filePath.isBlank()){
            return results;
        }
        try {
            QuestionLexer lexer = new QuestionLexer(CharStreams.fromFileName(filePath));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QuestionParser parser = new QuestionParser(tokens);
            ParseTree tree = parser.question();
            EvalVisitor evalVisitor = new EvalVisitor();
            ExamQuestion teste = evalVisitor.buildQuestion(tree);
            if(teste.value() != null){
                results.add("Question added with succes!");
            }else{
                results.add("Question wasnt added!");
            }
            return results;
        } catch (Exception e) {
            results.add("A error appearded when creating the Question!");
            return results;
        }
    }

    /*

MATCHING - Comer ananas faz bem? OP:Salto OP:Pedras OP:Pretas OP:Azuis RES:Salto&Pretas RES:Pedras&Azuis - Cotacao: 5 ;

MULTIPLE_CHOICE - Testar? OP:TUDO  OP:BACK  OP:FRONT RES:2 - Cotacao: 5 ;

MISSING_WORDS - Ama o _____ com o ____ OP:coracao OP:isep RES:isep;coracao - Cotacao: 5 ; CORRECT assim esta bem
    */

}
