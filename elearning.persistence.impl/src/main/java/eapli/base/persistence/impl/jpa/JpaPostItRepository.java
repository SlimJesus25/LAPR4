package eapli.base.persistence.impl.jpa;

import eapli.elearning.postitmanagement.domain.PostIt;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
//public class JpaPostItRepository extends JpaAutoTxRepository<PostIt, Integer, Integer> implements PostItRepository {
//    public JpaPostItRepository(final TransactionalContext autoTx) {
//        super(autoTx, "id");
//    }
//
//    public JpaPostItRepository(final String puname) {
//        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
//    }
//
//    @Override
//    public boolean checkPostItCell(String sharedBoardTitle, Integer row, Integer column) {
//        final TypedQuery<PostIt> query = entityManager().createQuery("SELECT a FROM PostIt a " +
//                        "WHERE a.sharedBoard.sharedBoardTitle.title = :sharedBoard " +
//                        "AND a.postItRow.rowP = :row " +
//                        "AND a.postItColumn.columnP = :column"
//                , PostIt.class);
//        query.setParameter("sharedBoard", sharedBoardTitle);
//        query.setParameter("row", row);
//        query.setParameter("column", column);
//
//        return !query.getResultList().isEmpty();
//    }
//
//    @Override
//    public PostIt findPostItById(int PostItId) {
//        final TypedQuery<PostIt> query = entityManager().createQuery("SELECT a FROM PostIt a WHERE upper(a.id)" +
//                " = upper(:PostItId)", PostIt.class);
//        query.setParameter("PostItId", PostItId);
//        return query.getSingleResult();
//    }
//    @Override
//    public PostIt changePostIt(int row,int column,String content,PostIt postIt) {
//        postIt.changePostIt(content);
//        this.save(postIt);
//        return postIt;
//    }
//    @Override
//    public List<PostIt> listPostItsOfBoard(SharedBoardDTO board) {
//        final TypedQuery<PostIt> query = entityManager().createQuery(
//                "SELECT p FROM PostIt p WHERE sharedBoard=:board", PostIt.class);
//        query.setParameter("board", board);
//        return query.getResultList();
//    }
//}
