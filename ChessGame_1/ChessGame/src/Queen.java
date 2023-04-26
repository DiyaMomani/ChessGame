public class Queen implements IPiece{
    private boolean isWhite;
    private boolean isKilled;
    public Queen() {
    }

    public Queen(boolean isWhite, boolean isKilled) {
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

        if(Row == Col){
            int increasingRow = (nextRow - currRow) / Row;
            int increasingCol = (nextCol - currCol) / Col;
            while(currRow != nextRow && currCol != nextCol){
                currRow += increasingRow;
                currCol += increasingCol;
                if(currRow == nextRow && currCol == nextCol){
                    return true;
                }
                if(squares[currRow][currCol].getPiece() != null){
                    return false;
                }
            }
        }
        if(Col != 0 && Row != 0){
            return false;
        }
        if(Col == 0){
            int increasingRow = Row / (nextRow - currRow);
            while(true){
                currRow += increasingRow;
                if(currRow == nextRow)
                    return true;
                if(squares[currRow][currCol].getPiece() != null)
                    return false;
            }
        }
        int increasingCol= Col / (nextCol - currCol);
        while(true){
            currCol += increasingCol;
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
        return "Queen";
    }
}
