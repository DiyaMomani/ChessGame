public interface IPieceFactory {
    //applicant of factory design patterns to reduce couping/////
    //interface to get pieces from IPiece interface///////
    IPiece getPiece(String PieceName, boolean isWhite);
}
