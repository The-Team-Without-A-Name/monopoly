package library;
/**
 * GamePiece class describes the piece the player picks along with the location of the piece.
 */
public class GamePiece {
    private String piece;
    private int pieceLocation;

    //constructor
    public GamePiece(){

    }

    //gets piece
    public String getPiece() {
        return piece;
    }

    //get piece location
    public int getPieceLocation() {
        return pieceLocation;
    }

    //set the piece location
    public void setPieceLocation(int pieceLocation) {
        this.pieceLocation = pieceLocation;
    }
}
