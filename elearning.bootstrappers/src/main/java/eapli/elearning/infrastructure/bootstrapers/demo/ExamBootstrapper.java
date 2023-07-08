package eapli.elearning.infrastructure.bootstrapers.demo;

import eapli.elearning.coursemanagement.domain.Course;
import eapli.elearning.coursemanagement.domain.CourseState;
import eapli.elearning.exammanagement.application.*;
import eapli.elearning.exammanagement.domain.ExamType;
import eapli.elearning.exammanagement.dto.ExamDTO;
import eapli.elearning.examquestionmanagement.application.CreateExamQuestionController;
import eapli.elearning.examquestionmanagement.application.SearchExamQuestionByIDController;
import eapli.elearning.examquestionmanagement.domain.ExamQuestion;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionResult;
import eapli.elearning.examquestionmanagement.domain.ExamQuestionType;
import eapli.elearning.examquestionmanagement.dto.ExamQuestionDTO;
import eapli.elearning.examsectionmanagement.application.CreateExamSectionController;
import eapli.elearning.examsectionmanagement.application.SearchExamSectionByIDController;
import eapli.elearning.examsectionmanagement.domain.ExamSection;
import eapli.elearning.examsectionmanagement.dto.ExamSectionDTO;
import eapli.elearning.myelearninguser.application.GetSystemUserByUsernameController;
import eapli.elearning.teachermanagement.domain.Teacher;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class ExamBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExamBootstrapper.class);

    private final CreateExamController controller = new CreateExamController();
    private final CreateExamQuestionController questionController = new CreateExamQuestionController();
    private final SearchExamQuestionByIDController searchQuestionController = new SearchExamQuestionByIDController();
    private final CreateExamSectionController sectionController = new CreateExamSectionController();
    private final SearchExamSectionByIDController searchSectionController = new SearchExamSectionByIDController();
    @Override
    public boolean execute() {

        HashMap<ExamQuestionResult, String> feedback1 = new HashMap<>();
        HashMap<ExamQuestionResult, String> feedback2 = new HashMap<>();
        HashMap<ExamQuestionResult, String> feedback3 = new HashMap<>();
        HashMap<ExamQuestionResult, String> feedback4 = new HashMap<>();
        HashMap<ExamQuestionResult, String> feedback5 = new HashMap<>();
        HashMap<ExamQuestionResult, String> feedback6 = new HashMap<>();
        HashMap<ExamQuestionResult, String> feedback7 = new HashMap<>();

        ArrayList<String> solutins1 = new ArrayList<>();
        ArrayList<String> solutins2 = new ArrayList<>();
        ArrayList<String> solutins3 = new ArrayList<>();
        ArrayList<String> solutins4 = new ArrayList<>();
        ArrayList<String> solutins5 = new ArrayList<>();
        ArrayList<String> solutins6 = new ArrayList<>();
        ArrayList<String> solutins7 = new ArrayList<>();

        Teacher regent1 = new Teacher("ABCD", "100200300",
                LocalDate.of(1995, Month.JUNE, 1),getSystemUserByUsername("venancioT"));

        Course c1 = new Course("SEM02-JAVA", "JAVA", "Java Collections Framework2",
                CourseState.CLOSE, regent1);

        Set<ExamSection> sections = new HashSet<>();
        Set<ExamQuestion> questions1 = new HashSet<>();


        feedback1.put(ExamQuestionResult.CORRECT, "The answer is correct!");
        feedback1.put(ExamQuestionResult.INCORRECT, "The correct answer was: A");
        solutins1.add("1");
        ExamQuestionDTO question = createExamQuestion(ExamQuestionType.MULTIPLE_CHOICE,  solutins1,
                5,feedback1, "What is the output of the following code?\n\"public class OutputExample {\n" +
                        "    public static void main(String[] args) {\n" +
                        "        int x = 10;\n" +
                        "        int y = 5;\n" +
                        "        int result = x / y;\n" +
                        "        System.out.println(result);\n" +
                        "    }\n" +
                        "}\"1) 2\n2) 5\n3) 10\n4) Error: division by zero");


        feedback2.put(ExamQuestionResult.CORRECT, "The answer is correct!");
        feedback2.put(ExamQuestionResult.PARTIALLY_CORRECT, "The answer was partially correct, the correct answer was: A constructor is a special method in Java that is used to create objects. It has the same name as the class and is called automatically when an object is created.");
        feedback2.put(ExamQuestionResult.INCORRECT, "The correct answer was: False");
        solutins2.add("A constructor is a special method in Java that is used to create objects. It has the same name as the class and is called automatically when an object is created.");
        solutins2.add("A constructor is a special method in Java. It has the same name as the class and is called automatically when an object is created.");
        createExamQuestion(ExamQuestionType.SHORT_ANSWER, solutins2,
                10, feedback2, "What is a " +
                        "constructor in Java?");


        feedback3.put(ExamQuestionResult.CORRECT, "The answer is correct!");
        feedback3.put(ExamQuestionResult.INCORRECT, "The correct answer was: False");
        solutins3.add("False");
        createExamQuestion(ExamQuestionType.TRUE_OR_FALSE,  solutins3,
                4, feedback3, "A static" +
                        " method can access instance variables without creating an instance of the class.");

        feedback6.put(ExamQuestionResult.CORRECT, "The answer is correct!");
        feedback6.put(ExamQuestionResult.INCORRECT, "The correct answer was: Lambda is an anonymus function that " +
                "can have multiple variables");
        feedback6.put(ExamQuestionResult.PARTIALLY_CORRECT, "The answer is partially correct, the correct answer was:" +
                " Lambda is an anonymus function that can have multiple variables");
        solutins6.add("anonymus");
        solutins6.add("multiple");
        createExamQuestion(ExamQuestionType.MISSING_WORDS, solutins6, 10, feedback6, "Lambda is an ______" +
                " function that can have ____ variables.");

        questions1.add(searchQuestionController.searchExamQuestionByID(1));
        questions1.add(searchQuestionController.searchExamQuestionByID(2));
        questions1.add(searchQuestionController.searchExamQuestionByID(3));
        questions1.add(searchQuestionController.searchExamQuestionByID(4));
//        sections.add(new ExamSection("Section 1", questions1));
        createExamSection("Section 1", questions1);

        Set<ExamQuestion> questions2 = new HashSet<>();


        feedback5.put(ExamQuestionResult.CORRECT, "The answer is correct!");
        feedback5.put(ExamQuestionResult.INCORRECT, "The correct answer was: \"An interface is a collection of abstract" +
                " methods that can be implemented by any class.\"");
        solutins5.add("An interface is a collection of abstract\" +\n" +
                "                \" methods that can be implemented by any class.");
        createExamQuestion(ExamQuestionType.SHORT_ANSWER, solutins5,
                10, feedback5, "What is the" +
                        " difference between an interface and a class in Java?");


        feedback4.put(ExamQuestionResult.CORRECT, "The answer is correct!");
        feedback4.put(ExamQuestionResult.INCORRECT, "The correct answer was: True");
        solutins4.add("True");
        createExamQuestion(ExamQuestionType.TRUE_OR_FALSE,  solutins4,
                5, feedback4, "The keyword" +
                        " \"final\" can be used to declare a class.");

        feedback7.put(ExamQuestionResult.CORRECT, "The answer is correct!");
        feedback7.put(ExamQuestionResult.INCORRECT, "The correct answer was: 40320");
        solutins7.add("40320");
        createExamQuestion(ExamQuestionType.NUMERICAL, solutins7, 15, feedback7, "Regarding the following" +
                " method:\n" +
                "public static int mistery(int n) {\n" +
                "        if (n == 0 || n == 1) {\n" +
                "            return 1;\n" +
                "        } else {\n" +
                "            return n * mistery(n - 1);\n" +
                "        }\n" +
                "    }\nWhat should be the result if n takes the value 8?");

        questions2.add(searchQuestionController.searchExamQuestionByID(4));
        questions2.add(searchQuestionController.searchExamQuestionByID(5));
        questions2.add(searchQuestionController.searchExamQuestionByID(6));
        createExamSection("Section 2", questions2);

        sections.add(searchSectionController.searchExamSectionByID(1));
        sections.add(searchSectionController.searchExamSectionByID(2));

        createExam("TEST EXAM (ALL TIME)", "Java Basics", sections, c1, ExamType.NORMAL, LocalDateTime.now()
                .plusSeconds(10), LocalDateTime.of(
                2050, Month.JUNE, 14, 14, 50, 0));
        LOGGER.debug("»»» Demo Exam created{}", id);
        return true;
    }

    private ExamDTO createExam(String title, String header, Set<ExamSection> sections, Course course, ExamType type
            , LocalDateTime initialDateTime, LocalDateTime finalDateTime){
        return controller.createExam(title, header, sections, course, type, initialDateTime, finalDateTime);
    }
    private ExamQuestionDTO createExamQuestion(ExamQuestionType questionType, List<String> solutions, Integer value,
                                               HashMap<ExamQuestionResult,String> feedbacks, String statement){
        return questionController.createQuestion(questionType, solutions, value, feedbacks, statement);
    }
    private ExamSectionDTO createExamSection(String examSectionTextualDescription, Set<ExamQuestion> questions){
        return sectionController.createSection(examSectionTextualDescription, questions);
    }
    private SystemUser getSystemUserByUsername(String username){
        GetSystemUserByUsernameController controller = new GetSystemUserByUsernameController();
        SystemUser systemUser = controller.getSystemUserByUsername(username);
        return systemUser;
    }
}
