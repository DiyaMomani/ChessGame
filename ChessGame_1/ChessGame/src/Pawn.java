public class Pawn implements IPiece{
    private boolean isWhite;
    private boolean isKilled;
    public Pawn() {
    }

    public Pawn(boolean isWhite, boolean isKilled) {
        this.isWhite = isWhite;
        this.isKilled = isKilled;
    }
    public void setWhite(boolean white) {
        isWhite = white;
    }
    @Override
    public boolean canMove(int currRow,int currCol,int nextRow,int nextCol){
        Square[][] squares = Board.getBoard().getSquares();

        if(isWhite() && currRow < nextRow){
            int column = Math.abs(nextCol - currCol);
            int row = Math.abs(currRow - nextRow);
            if( column == 1 && row == 1){
                return squares[nextRow][nextCol].getPiece() != null && !squares[nextRow][nextCol].getPiece().isWhite();
            }
        }
        if(!isWhite() && currRow > nextRow){
            int column = Math.abs(nextCol - currCol);
            int row = Math.abs(currRow - nextRow);
            if( column == 1 && row == 1){
                return squares[nextRow][nextCol].getPiece() != null && squares[nextRow][nextCol].getPiece().isWhite();
            }
        }
        if(squares[nextRow][nextCol].getPiece() != null) {
            return false;
        }

        if(currCol != nextCol){
            return false;
        }

        if (currRow > nextRow && isWhite()){
            return false;
        }

        if (currRow < nextRow && !isWhite()){
            return false;
        }

        int absoluteRow = Math.abs(nextRow - currRow);
        if(absoluteRow > 1){
            if(isWhite()&& (currRow != 1 || absoluteRow > 2)){
                return false;
            }
            return isWhite() || (currRow == 6 && absoluteRow == 2);
        }

        return true;
    }
    @Override
    public boolean isWhite() {
        return isWhite;
    }
    @Override
    public void setKilled(boolean killed) {
        isKilled = killed;
    }
    @Override
    public boolean isKilled() {
        return isKilled;
    }
    @Override
    public String getType(){
        return "Pawn";
    }
}
