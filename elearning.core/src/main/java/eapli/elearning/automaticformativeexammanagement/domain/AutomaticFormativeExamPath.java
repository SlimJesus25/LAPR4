package eapli.elearning.automaticformativeexammanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import javax.persistence.Embeddable;
import java.io.File;


/**
 * @author : Ricardo Venâncio - 1210828
 **/

@Embeddable
public class AutomaticFormativeExamPath implements ValueObject{

    private String path;

    public AutomaticFormativeExamPath(String path) {
        Preconditions.noneNull(path);
        verifyPath(path);
        this.path = path;
    }

    private void verifyPath(String path){
        if(path.isEmpty()){
            throw new IllegalArgumentException("Path cannot be null!");
        }
        if(!new File(path).exists()){
            throw new IllegalArgumentException("The file doesn't exist!");
        }
        if(!path.matches("[a-zA-Z0-9]+.txt")){
            throw new IllegalArgumentException("The file must be .txt extension!");
        }
    }

    protected AutomaticFormativeExamPath() {

    }
}
