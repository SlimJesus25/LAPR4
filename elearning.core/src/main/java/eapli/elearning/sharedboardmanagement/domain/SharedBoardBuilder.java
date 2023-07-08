package eapli.elearning.sharedboardmanagement.domain;

import eapli.framework.domain.model.DomainFactory;

import java.time.LocalDateTime;

public class SharedBoardBuilder implements DomainFactory<SharedBoard> {
    private SharedBoard theSharedBoard;
    private String sharedBoardTitle;
    private LocalDateTime sharedBoardCreationTimestamp;

    public SharedBoardBuilder withSharedBoardTitle(String sharedBoardTitle){
        this.sharedBoardTitle = sharedBoardTitle;
        return this;
    }

    public SharedBoardBuilder withSharedBoardCreationTimestamp(LocalDateTime sharedBoardCreationTimestamp){
        this.sharedBoardCreationTimestamp = sharedBoardCreationTimestamp;
        return this;
    }

    @Override
    public SharedBoard build() {
        final SharedBoard sharedBoard = buildOrThrow();
        theSharedBoard = null;
        return sharedBoard;
    }

    private SharedBoard buildOrThrow(){
        if (theSharedBoard != null)
            return theSharedBoard;
        else if (sharedBoardTitle != null && sharedBoardCreationTimestamp != null){
            theSharedBoard = new SharedBoard(sharedBoardTitle, sharedBoardCreationTimestamp);
            return theSharedBoard;
        } else throw new IllegalStateException();
    }
}
