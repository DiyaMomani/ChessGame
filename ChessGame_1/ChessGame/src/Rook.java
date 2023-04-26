public class Rook implements IPiece{
    private boolean isWhite;
    private boolean isKilled;




    public Rook(boolean isWhite, boolean isKilled) {
        this.isWhite = isWhite;
        this.isKilled = isKilled;

    }
    public void setWhite(boolean white) {
        isWhite = white;
    }
    @Override
    public boolean canMove(int currRow,int currCol,int nextRow,int nextCol){
        int Row = Math.abs(nextRow - currRow);
        int Col = Math.abs(nextCol - currCol);
        Square[][] squares = Board.getBoard().getSquares();
        if(Col != 0 && Row != 0){
            return false;
        }
        if(Col == 0){
            int isPositiveRow = Row / (nextRow - currRow);
            while(true){
                currRow += isPositiveRow;
                if(currRow == nextRow)
                    return true;
                if(squares[currRow][currCol].getPiece() != null)
                    return false;
            }
        }
        int isPositiveCol= Col / (nextCol - currCol);
        while(true){
            currCol += isPositiveCol;
            if(currCol == nextCol)
                return true;
            if(squares[currRow][currCol].getPiece() != null)
                return false;
        }
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
        return "Rook";
    }
}
