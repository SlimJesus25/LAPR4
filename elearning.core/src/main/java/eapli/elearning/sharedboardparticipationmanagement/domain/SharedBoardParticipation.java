package eapli.elearning.sharedboardparticipationmanagement.domain;

import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.elearning.sharedboardparticipationmanagement.dto.SharedBoardParticipationDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTOable;
import javax.persistence.*;


@Entity
@Table(name="SharedBoardParticipation")
public class SharedBoardParticipation implements AggregateRoot<Integer>, DTOable<SharedBoardParticipationDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name="userPermission", nullable=false)
    private UserPermission userPermission;
    @Enumerated(EnumType.STRING)
    @Column(name="userStatus", nullable=false)
    private UserStatus userStatus;
    @ManyToOne
    private SystemUser user;
    @ManyToOne
    private SharedBoard sharedBoard;

    public SharedBoardParticipation(UserPermission userPermission, UserStatus userStatus, SystemUser user, SharedBoard sharedBoard) {
        this.userPermission = userPermission;
        this.userStatus = userStatus;
        this.user = user;
        this.sharedBoard = sharedBoard;
    }

    public void assignOwnership(){
        if(this.userPermission == UserPermission.ADMIN && this.userStatus == UserStatus.OWNER){
            throw new IllegalArgumentException("Membership already assigned!");
        }
        this.userPermission = UserPermission.ADMIN;
        this.userStatus = UserStatus.OWNER;
    }

    protected SharedBoardParticipation(){}
    @Override
    public boolean sameAs(Object other) {
        return this.equals(other);
    }
    @Override
    public SharedBoardParticipationDTO toDTO() {
        return new SharedBoardParticipationDTO(this.userPermission, this.userStatus, this.user, this.sharedBoard.toDTO());
    }
    @Override
    public Integer identity() {
        return this.id;
    }
}
