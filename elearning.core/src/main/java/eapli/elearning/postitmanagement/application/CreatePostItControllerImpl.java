package eapli.elearning.postitmanagement.application;

import eapli.elearning.postitmanagement.domain.PostIt;
import eapli.elearning.postitmanagement.domain.PostItFactory;
import eapli.elearning.postitmanagement.dto.PostItDTO;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class CreatePostItControllerImpl implements CreatePostItController{
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public PostItDTO createPostIt(Integer row, Integer column, String content, SharedBoard sharedBoard){
        //authz.ensureAuthenticatedUserHasAnyOf(ElearningRoles.POWER_USER, ElearningRoles.TEACHER, ElearningRoles.STUDENT);
        PostIt postIt = PostItFactory.createPostIt(content);
        sharedBoard.insertPostIt(row, column, postIt);
        return postIt.toDTO();
    }
}
