package eapli.elearning.automaticformativeexammanagement.application;

import eapli.elearning.automaticformativeexammanagement.application.antlr.VerifyQuestionAntlrService;
import eapli.elearning.coursemanagement.application.CourseService;
import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.dto.CourseDTO;
import eapli.elearning.examquestionmanagement.application.ExamQuestionService;
import eapli.elearning.examquestionmanagement.domain.ExamQuestion;
import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.elearning.teachermanagement.application.TeacherService;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

public class AddUpdadeQuestionController {
        private final AuthorizationService authz = AuthzRegistry.authorizationService();
        private final ExamQuestionService question = new ExamQuestionService();
        private final VerifyQuestionAntlrService questionService = new VerifyQuestionAntlrService();
        public ArrayList<String> validateQuestion(String questionFP){
                authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.TEACHER);
                ArrayList<String> results = new ArrayList<>();
                try {
                        results = questionService.verifyQuestion(questionFP);
                        return results;
                }catch(Exception e) {
                        results.add("It wan't possible to add the question!");
                        return results;
                }
        }

        public List<ExamQuestionDTO> listQuestions(){
                authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.STUDENT, ElearningRoles.TEACHER);
                Iterable<ExamQuestion> questions = question.listQuestions();
                List<ExamQuestionDTO> result = new ArrayList<>();
                questions.forEach(a -> result.add(a.toDTO()));
                return result;
        }

        public ArrayList<String> updateQuestion(String questionFP, ExamQuestionDTO examQuestionDTO){
                authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.TEACHER);
                ArrayList<String> results = new ArrayList<>();
                results.add("The rest of the US wasnt implemented yet!");
                /*
                try {
                        results = questionService.verifyQuestion(questionFP);
                        return results;
                }catch(Exception e) {
                        results.add("It wan't possible to add the question!");
                        return results;
                }*/
                return results;
        }
}
