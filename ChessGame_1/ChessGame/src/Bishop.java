public class Bishop implements IPiece{
    private boolean isWhite;
    private boolean isKilled;



    public Bishop(boolean isWhite, boolean isKilled) {
        this.isWhite = isWhite;
        this.isKilled = isKilled;
    }
    public void setWhite(boolean white) {
        isWhite = white;
    }
    @Override
    public boolean canMove(int currRow,int currCol,int nextRow,int nextCol){
        int Row = Math.abs(currRow - nextRow);
        int Col = Math.abs(currCol - nextCol);
        if(Row != Col)
            return false;
        Square[][] squares = Board.getBoard().getSquares();
        int isPositiveRow = (nextRow - currRow) / Row;
        int isPositiveCol = (nextCol - currCol) / Col;
        while(currRow != nextRow && currCol != nextCol){
            currRow += isPositiveRow;
            currCol += isPositiveCol;
            if(currRow == nextRow && currCol == nextCol){
                break;
            }
            if(squares[currRow][currCol].getPiece() != null){
                return false;
            }
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
        return "Bishop";
    }
}
