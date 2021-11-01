package library;
/**
 * GamePiece class describes the piece the player picks along with the location of the piece.
 */
public class GamePiece {
    private String piece;
    private int pieceLocation;

    public GamePiece(){

    }

    public String getPiece() {
        return piece;
    }

    public int getPieceLocation() {
        return pieceLocation;
    }

    public void setPieceLocation(int pieceLocation) {
        this.pieceLocation = pieceLocation;
    }
}