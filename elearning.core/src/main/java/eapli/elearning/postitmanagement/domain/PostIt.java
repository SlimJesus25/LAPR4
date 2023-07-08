package eapli.elearning.postitmanagement.domain;

import eapli.elearning.postitmanagement.dto.PostItDTO;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;

/**
 * @author : Ricardo Venâncio - 1210828
 **/

public class PostIt implements DTOable<PostItDTO> {

    private PostItContent postItContent;


    public PostIt(String postItContent) {
        Preconditions.noneNull(postItContent);
        this.postItContent = new PostItContent(postItContent);
    }

    protected PostIt() {
    }

    public void changePostIt(String content){
        this.postItContent = new PostItContent(content);
    }

    public void changePostItContent(String newContent){
        this.postItContent = new PostItContent(newContent);
    }

    public String content() {
        return postItContent.content();
    }

    @Override
    public PostItDTO toDTO() {
        return new PostItDTO(postItContent.content());
    }
}
