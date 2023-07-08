package eapli.elearning.sharedboardmanagement.domain;

import eapli.elearning.postitmanagement.domain.PostIt;
import eapli.elearning.sharedboardmanagement.dto.SharedBoardDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.representations.dto.DTOable;
import javax.persistence.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.Stack;

@Entity
public class SharedBoard implements AggregateRoot<Integer>, DTOable<SharedBoardDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Embedded
    @Column(unique = true)
    private SharedBoardTitle sharedBoardTitle;
    @Embedded
    private SharedBoardCreationTimestamp sharedBoardCreationTimestamp;
    @Enumerated(EnumType.STRING)
    private SharedBoardState sharedBoardState;
    @Transient
    private int MAX_COLUMN = getColumn();
    @Transient
    private int MAX_ROW = getRow();
    @Transient
    private PostIt[][] postItSchema = new PostIt[MAX_ROW][MAX_COLUMN];
    @Transient
    private Stack<BoardAction> actionStack = new Stack<>();
    @Transient
    private Stack<BoardAction> history = new Stack<>();
    @Transient
    private Object[][] postitLocks = initializePostItLocks();
    @Transient
    private final Object stackLock = new Object();


    public SharedBoard(String sharedBoardTitle, LocalDateTime sharedBoardTimestamp) {
        this.sharedBoardTitle = new SharedBoardTitle(sharedBoardTitle);
        this.sharedBoardCreationTimestamp = new SharedBoardCreationTimestamp(sharedBoardTimestamp);
        this.sharedBoardState = SharedBoardState.ACTIVE;
    }

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

    protected SharedBoard() throws IOException {
    }

    synchronized public void archiveBoard(){
        if(this.sharedBoardState == SharedBoardState.ARCHIVED){
            throw new IllegalArgumentException("This board is already archived!");
        }
        this.sharedBoardState = SharedBoardState.ARCHIVED;
    }

    synchronized public void restoreBoard(){
        if(this.sharedBoardState == SharedBoardState.ACTIVE){
            throw new IllegalArgumentException("This board is already active!");
        }
        this.sharedBoardState = SharedBoardState.ACTIVE;
    }

    public String title() {
        return sharedBoardTitle.title();
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return id;
    }

    public SharedBoardState boardState() {
        return sharedBoardState;
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
        if(sharedBoardState == SharedBoardState.ARCHIVED || sharedBoardState == SharedBoardState.INACTIVE)
            throw new IllegalArgumentException("This board is not functional!");
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

    public synchronized String visualizeBoard(){
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<MAX_ROW;i++){
            builder.append("\n");
            for(int j=0;j<MAX_COLUMN;j++){
                if(this.postItSchema[i][j] == null){
                    builder.append("|").append("|");
                }else {
                    builder.append("|").append(this.postItSchema[i][j].content()).append("|");
                }
            }
        }
        return builder.toString();
    }

    @Override
    public synchronized SharedBoardDTO toDTO() {
        return new SharedBoardDTO(id, sharedBoardTitle.title(), sharedBoardCreationTimestamp.timestamp());
    }
}
