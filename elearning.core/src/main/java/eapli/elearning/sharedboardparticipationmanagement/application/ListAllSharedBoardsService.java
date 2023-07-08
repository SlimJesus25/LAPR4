package eapli.elearning.sharedboardparticipationmanagement.application;

import eapli.elearning.infrastructure.persistence.PersistenceContext;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.elearning.sharedboardmanagement.repositories.SharedBoardRepository;
import eapli.elearning.sharedboardparticipationmanagement.domain.SharedBoardParticipation;
import eapli.elearning.sharedboardparticipationmanagement.repository.SharedBoardParticipationRepository;
import eapli.elearning.usermanagement.domain.ElearningRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;

@ApplicationService
public class ListAllSharedBoardsService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final SharedBoardRepository repo = PersistenceContext.repositories().sharedBoards();

    public List<SharedBoardDTO> lisAllSharedBoards(){
        authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.STUDENT, ElearningRoles.TEACHER);
        Iterable<SharedBoard> sharedBoards = repo.findAll();

        List<SharedBoardDTO> sharedBoardDTOS = new ArrayList<>();
        sharedBoards.forEach(e -> sharedBoardDTOS.add(e.toDTO()));
        return sharedBoardDTOS;

    }

}