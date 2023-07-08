package eapli.elearning.sharedboardparticipationmanagement.domain;

import eapli.framework.domain.model.DomainFactory;

public class SharedBoardParticipationBuilder implements DomainFactory<SharedBoardParticipation> {
    private SharedBoardParticipation theSharedBoardParticipation;
    private UserPermission userPermission;
    private UserStatus userStatus;

    public SharedBoardParticipationBuilder withSharedBoardParticipationUserPermission(UserPermission userPermission) {
        this.userPermission = userPermission;
        return this;
    }
    public SharedBoardParticipationBuilder withSharedBoardParticipationUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    @Override
    public SharedBoardParticipation build() {
        final SharedBoardParticipation sharedBoardParticipation = buildOrThrow();
        theSharedBoardParticipation = null;
        return sharedBoardParticipation;
    }
    private SharedBoardParticipation buildOrThrow(){
        if (theSharedBoardParticipation != null)
            return theSharedBoardParticipation;
        else if (userPermission != null && userStatus != null){
            //theSharedBoardParticipation = new SharedBoardParticipation(userPermission,userStatus);
            return theSharedBoardParticipation;
        } else throw new IllegalStateException();
    }
}
