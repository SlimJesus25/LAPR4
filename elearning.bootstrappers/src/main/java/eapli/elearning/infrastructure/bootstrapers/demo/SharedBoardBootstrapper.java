package eapli.elearning.infrastructure.bootstrapers.demo;

import eapli.elearning.myelearninguser.application.GetSystemUserByUsernameController;
import eapli.elearning.sharedboardmanagement.application.CreateSharedBoardController;
import eapli.elearning.sharedboardmanagement.application.FindSharedBoardByTitleService;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardparticipationmanagement.application.CreateSharedBoardParticipantionController;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SharedBoardBootstrapper implements Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(SharedBoardBootstrapper.class);
    final private FindSharedBoardByTitleService findSharedBoardByTitleService = new FindSharedBoardByTitleService();
    final private CreateSharedBoardParticipantionController createSharedBoardParticipantionController
            = new CreateSharedBoardParticipantionController();
    final private CreateSharedBoardController createSharedBoardController = new CreateSharedBoardController();
    @Override
    public boolean execute() {
        List<SystemUser> guests = new ArrayList<>();
        guests.add(getSystemUserByUsername("guisauce"));
        SharedBoard sharedBoard = createSharedBoardController.createSharedBoard("Vasco's Shared Board", LocalDateTime.now());
        createSharedBoardParticipantionController.createSharedBoardParticipation(guests, sharedBoard);
        createSharedBoardParticipantionController.createSharedBoardParticipationOwner(getSystemUserByUsername("vasco"), sharedBoard);

        return false;
    }

    private SystemUser getSystemUserByUsername(String username){
        GetSystemUserByUsernameController controller = new GetSystemUserByUsernameController();
        SystemUser systemUser = controller.getSystemUserByUsername(username);
        return systemUser;
    }
}
