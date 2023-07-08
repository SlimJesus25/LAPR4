package eapli.elearning.sharedboardmanagement.domain;

public class BoardAction {

    public BoardAction(Action action, Integer oldRow, Integer oldColumn, Integer newRow
            , Integer newColumn, String oldContent) {
        this.action = action;
        this.oldRow = oldRow;
        this.oldColumn = oldColumn;
        this.oldContent = oldContent;
        this.newRow = newRow;
        this.newColumn = newColumn;
    }

    private Action action;
    private Integer oldRow;
    private Integer oldColumn;
    private Integer newRow;
    private Integer newColumn;
    private String oldContent;

    public Action action() {
        return action;
    }

    public Integer oldRow() {
        return oldRow;
    }

    public Integer oldColumn() {
        return oldColumn;
    }

    public String oldContent() {
        return oldContent;
    }

    public Integer newRow() {
        return newRow;
    }

    public Integer newColumn() {
        return newColumn;
    }
}
