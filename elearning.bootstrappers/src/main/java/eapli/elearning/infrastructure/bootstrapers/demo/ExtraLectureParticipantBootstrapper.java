package eapli.elearning.infrastructure.bootstrapers.demo;

import eapli.elearning.extralecturemanagement.application.FindExtraLectureByIdController;
import eapli.elearning.extralecturemanagement.domain.ExtraLecture;
import eapli.elearning.extralectureparticipantmanagement.application.CreateExtraLectureParticipantController;
import eapli.elearning.extralectureparticipantmanagement.domain.ExtraLectureParticipant;
import eapli.elearning.myelearninguser.application.GetSystemUserByUsernameController;
import eapli.elearning.studentmanagement.application.FindStudentByMechanographicalNumberService;
import eapli.elearning.studentmanagement.application.FindStudentByUsernameService;
import eapli.elearning.studentmanagement.domain.Student;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtraLectureParticipantBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExtraLectureParticipantBootstrapper.class);
    FindStudentByMechanographicalNumberService findStudentByMechanographicalNumberService = new FindStudentByMechanographicalNumberService();
    FindExtraLectureByIdController findExtraLectureByIdController = new FindExtraLectureByIdController();
    private final CreateExtraLectureParticipantController controller = new CreateExtraLectureParticipantController();

    @Override
    public boolean execute() {
        Student s1= findStudentByUsername("guisauce");
        Student s2= findStudentByUsername("vasco");
        ExtraLecture el1= findExtraLectureById(1);
        ExtraLectureParticipant elp1= createExtraLectureParticipant(el1,s1);
        ExtraLectureParticipant elp2= createExtraLectureParticipant(el1,s2);
         return true;
    }

    private ExtraLecture findExtraLectureById(Integer id) {
        return findExtraLectureByIdController.findExtraLectureById(id);
    }

    private Student findStudentByMechanographicalNumber(String s) {
        return findStudentByMechanographicalNumberService.findStudentByMechanographicalNumber(s);
    }
    private SystemUser getSystemUserByUsername(String username){
        GetSystemUserByUsernameController controller = new GetSystemUserByUsernameController();
        SystemUser systemUser = controller.getSystemUserByUsername(username);
        return systemUser;
    }

    private Student findStudentByUsername(String username) {
        SystemUser user = getSystemUserByUsername(username);
        FindStudentByUsernameService controller = new FindStudentByUsernameService();
        return controller.findStudentByUsername(user.username());
    }


    private ExtraLectureParticipant createExtraLectureParticipant(ExtraLecture extraLecture, Student student) {
        return controller.createExtraLectureParticipant(extraLecture, student);
    }
}

