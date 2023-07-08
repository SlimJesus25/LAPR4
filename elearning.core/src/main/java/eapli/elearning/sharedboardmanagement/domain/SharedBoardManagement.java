package eapli.elearning.sharedboardmanagement.domain;

import eapli.elearning.postitmanagement.domain.PostIt;

import java.util.Properties;
import java.util.Stack;

/**
 * @author : Ricardo Venâncio - 1210828
 **/
public class SharedBoardManagement {

    private final int MAX_COLUMN = getColumn();

    private final int MAX_ROW = getRow();

    private PostIt[][] postItSchema = new PostIt[MAX_ROW][MAX_COLUMN];

    private Stack<BoardAction> actionStack = new Stack<>();

    private Stack<BoardAction> history = new Stack<>();

    private Object[][] postitLocks = initializePostItLocks();

    private final Object stackLock = new Object();

    private Object[][] initializePostItLocks(){
        Object[][] obj = new Object[MAX_ROW][MAX_COLUMN];
        for(int i=0;i<MAX_ROW;i++){
            for(int j=0;j<MAX_COLUMN;j++){
                obj[i][j] = new Object();
            }
        }
        return obj;
    }

    public PostIt[][] schema() {
        return postItSchema;
    }

    public int getRow(){
        return configureProperty("row_max");
    }

    private int configureProperty(String property){
        Properties properties;
        try {
            properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties.sample"));
            return Integer.parseInt(properties.getProperty(property));
            //this.MAX_ROW = Integer.parseInt(properties.getProperty("row_max"));
        }catch (Exception e){
            throw new NullPointerException("An error occurred loading the property files.");
        }
    }

    public int getColumn(){
        return configureProperty("col_max");
    }


    public synchronized PostIt postIt(Integer row, Integer column) {
        return postItSchema[row][column];
    }

    public void insertPostIt(Integer row, Integer column, PostIt postIt) {
        verifyIfFunctional();
        synchronized (postitLocks[row][column]) {
            if (verifyIfCellIsOccupied(row, column))
                throw new IllegalArgumentException("This position is already occupied by other post-it");
            postItSchema[row][column] = postIt;
        }

        synchronized (stackLock) {
            actionStack.push(new BoardAction(Action.CREATE_POST_IT, null, null, row, column
                    , postIt.content()));
            history.push(new BoardAction(Action.CREATE_POST_IT, null, null, row, column
                    , postIt.content()));
        }
    }
    private boolean verifyIfCellIsOccupied(Integer row, Integer column){
        return postItSchema[row][column] != null;
    }

    private void verifyIfFunctional(){
//        if(sharedBoardState == SharedBoardState.ARCHIVED || sharedBoardState == SharedBoardState.INACTIVE)
//            throw new IllegalArgumentException("This board is not functional!");
    }
    public void changePostItContent(Integer row, Integer column, String newContent){
        synchronized (postitLocks[row][column]) {
            if (!verifyIfCellIsOccupied(row, column))
                throw new IllegalArgumentException("There isn't any post-it here!");
            postItSchema[row][column].changePostItContent(newContent);
        }
        synchronized (stackLock) {
            actionStack.push(new BoardAction(Action.CHANGE_POST_IT_CONTENT, row, column, null, null
                    , newContent));
            history.push(new BoardAction(Action.CHANGE_POST_IT_CONTENT, row, column, null, null
                    , newContent));
        }

    }

    public void changePostItPosition(Integer newRow, Integer newColumn, Integer oldRow, Integer oldColumn){
        verifyIfFunctional();
        PostIt aux;

        // This needs to be here to guarantee that there is no deadlock.
        if((int) oldRow == newRow && (int) oldColumn == newColumn){
            throw new IllegalArgumentException("You can't change the post-it to the same position!");
        }

        synchronized (postitLocks[oldRow][oldColumn]) {
            synchronized (postitLocks[newRow][newColumn]) {
                if (!verifyIfCellIsOccupied(oldRow, oldColumn))
                    throw new IllegalArgumentException("This position doesn't have any post-it!");
                if (!verifyIfCellIsOccupied(newRow, newColumn))
                    throw new IllegalArgumentException("This position is already occupied by other post-it!");
                aux = postItSchema[oldRow][oldColumn];
                postItSchema[oldRow][oldColumn] = null;
                postItSchema[newRow][newColumn] = aux;
            }
        }

        synchronized (stackLock) {
            actionStack.push(new BoardAction(Action.CHANGE_POST_IT_PLACE, oldRow, oldColumn, newRow, newColumn
                    , aux.content()));
            history.push(new BoardAction(Action.CHANGE_POST_IT_PLACE, oldRow, oldColumn, newRow, newColumn
                    , aux.content()));
        }
    }

    public void undoLastChange() {
        BoardAction last;

        synchronized (stackLock) {
            if (actionStack.empty()) {
                throw new IllegalArgumentException("There is no last change to undo!");
            }
            last = actionStack.pop();
        }

        Integer orow = last.oldRow();
        Integer ocol = last.oldColumn();
        Integer nrow = last.newRow();
        Integer ncol = last.newColumn();
        String ocontent = last.oldContent();
        switch (last.action().ordinal()) {
            case 0:
                synchronized (postitLocks[nrow][ncol]) {
                    postItSchema[nrow][ncol] = null;
                }
                break;
            case 1:
                synchronized (postitLocks[nrow][ncol]) {
                    postItSchema[nrow][ncol].changePostItContent(ocontent);
                }
                break;
            case 2:
                synchronized (postitLocks[nrow][ncol]) {
                    synchronized (postitLocks[orow][ocol]) {
                        PostIt aux = postItSchema[nrow][ncol];
                        postItSchema[nrow][ncol] = null;
                        postItSchema[orow][ocol] = aux;
                    }
                    break;
                }
        }
    }

    public Stack<BoardAction> viewHistoryOfUpdates() {
        synchronized (stackLock) {
            return history;
        }
    }
}
