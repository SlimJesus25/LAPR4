package eapli.elearning.postitmanagement.domain;


/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class PostItFactory {
    public static PostIt createPostIt(String content){
        return new PostIt(content);
    }
}
