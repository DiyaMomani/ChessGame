import java.awt.*;

public class PieceFactory implements IPieceFactory{
    //applicant of factory design patterns to reduce couping/////
    //concrete class to override getPiece method from IPiece interface///////
    @Override
    public IPiece getPiece(String PieceName, boolean isWhite){
        switch(PieceName){
            case "King": return new King(isWhite,false);
            case "Queen": return new Queen(isWhite,false);
            case "Rook": return new Rook(isWhite,false);
            case "Knight": return new Knight(isWhite,false);
            case "Pawn": return new Pawn(isWhite,false);
            case "Bishop": return new Bishop(isWhite,false);
        }
        return null;
    }
}
