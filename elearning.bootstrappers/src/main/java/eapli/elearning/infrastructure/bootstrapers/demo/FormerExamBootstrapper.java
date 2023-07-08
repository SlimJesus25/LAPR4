package eapli.elearning.infrastructure.bootstrapers.demo;

import eapli.elearning.exammanagement.application.FindExamByExamTitleService;
import eapli.elearning.exammanagement.domain.Exam;
import eapli.elearning.formerexammanagement.application.CreateFormerExamController;
import eapli.elearning.formerexammanagement.domain.FormerExam;
import eapli.elearning.myelearninguser.application.GetSystemUserByUsernameController;
import eapli.elearning.studentmanagement.application.FindStudentByUsernameService;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormerExamBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseBootstrapper.class);

    private final CreateFormerExamController controller = new CreateFormerExamController();
    private final FindExamByExamTitleService findExamByExamTitleService = new FindExamByExamTitleService();
    @Override
    public boolean execute() {
        FormerExam c1 = createFormerExam(14, getExamByExamTitle("TEST EXAM (ALL TIME)"), getStudentByUsername("guisauce"));
        return true;
    }
    private FormerExam createFormerExam(Integer grade, Exam exam, Student student){
        FormerExam formerExam = controller.createFormerExam(grade, exam, student);
        return formerExam;
    }
    private Exam getExamByExamTitle(String title){
        Exam exam = findExamByExamTitleService.findExamByExamTitle(title);
        return exam;
    }
    private Student getStudentByUsername(String username){
        SystemUser user = getSystemUserByUsername(username);
        FindStudentByUsernameService controller = new FindStudentByUsernameService();
        return controller.findStudentByUsername(user.username());
    }
    private SystemUser getSystemUserByUsername(String username){
        GetSystemUserByUsernameController controller = new GetSystemUserByUsernameController();
        SystemUser systemUser = controller.getSystemUserByUsername(username);
        return systemUser;
    }
}
