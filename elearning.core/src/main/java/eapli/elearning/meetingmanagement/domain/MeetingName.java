package eapli.elearning.meetingmanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class MeetingName implements ValueObject {

    private String name;

    public MeetingName(String name) {
        Preconditions.noneNull(name);
        verifyName(name);
        this.name = name;
    }

    private void verifyName(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be null!");
        }
    }

    public MeetingName() {
    }

    public String meetingName() {
        return name;
    }
}
