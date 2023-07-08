package eapli.elearning.infrastructure.bootstrapers.demo;

import eapli.elearning.postitmanagement.application.CreatePostItController;
import eapli.elearning.postitmanagement.application.CreatePostItControllerImpl;
import eapli.elearning.sharedboardmanagement.application.FindSharedBoardByTitleService;
import eapli.elearning.sharedboardmanagement.domain.SharedBoard;
import eapli.framework.actions.Action;

public class PostItBootstrapper implements Action {
    private final CreatePostItController ctrl = new CreatePostItControllerImpl();
    private final FindSharedBoardByTitleService sbCtrl = new FindSharedBoardByTitleService();
    @Override
    public boolean execute() {
        SharedBoard sb = sbCtrl.findSharedBoardByTitle("Vasco's Shared Board");
        ctrl.createPostIt(1, 1, "ABC", sb);

                /*
                SharedBoardRepository sRepo = PersistenceContext.repositories().sharedBoards();
        SharedBoard sb = sRepo.findSharedBoardsByTitle("Vasco's Shared Board");
        try {
            ctrl.createPostIt(0, 0, "Teste", sb.title());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
                 */
        return true;
    }
}
