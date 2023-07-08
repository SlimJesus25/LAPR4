package eapli.elearning.managermanagement.dto;

import eapli.elearning.managermanagement.domain.Manager;

import java.io.Serializable;

public class ManagerDTO implements Serializable {
    private Integer managerID;
    public ManagerDTO(Integer managerID){
        this.managerID=managerID;
    }
}
