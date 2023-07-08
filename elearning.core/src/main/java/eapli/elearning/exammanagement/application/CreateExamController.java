package eapli.elearning.exammanagement.application;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.exammanagement.application.antlr.EvalVisitor;
import eapli.elearning.exammanagement.application.antlr.documents.US2001Lexer;
import eapli.elearning.exammanagement.application.antlr.documents.US2001Parser;
import eapli.elearning.exammanagement.domain.*;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.exammanagement.repository.ExamRepository;
import eapli.elearning.examsectionmanagement.domain.ExamSection;
import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

@Controller
public class CreateExamController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ExamRepository repo = PersistenceContext.repositories().exams();
    private final EvalVisitor evalVisitor = new EvalVisitor();
    public ExamDTO createExam(String title, String header, Set<ExamSection> sections, Course course, ExamType type
    , LocalDateTime initalDateTime, LocalDateTime finalDateTime){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER);
        final Exam newExam = ExamFactory.createExam(title, header, sections, course, type, initalDateTime, finalDateTime);
        return repo.save(newExam).toDTO();
    }

    public ExamDTO createExam(String path) throws IOException {
        US2001Lexer lexer = new US2001Lexer(CharStreams.fromFileName(path));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        US2001Parser parser = new US2001Parser(tokens);
        ParseTree tree = parser.exam();
        //evalVisitor.buildExam(tree);
        return evalVisitor.buildExam(tree).toDTO();
    }
}
