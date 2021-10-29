package library;

import lombok.Getter;
import lombok.Setter;

/*

 */

public class BoardLocation {
    @Getter @Setter
    private int column;

    @Getter @Setter
    private int row;

    public BoardLocation(int column, int row) {
        this.column = column;
        this.row = row;
    }
}
