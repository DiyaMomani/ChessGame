public class Knight implements IPiece{
    private boolean isWhite;
    private boolean isKilled;
    public Knight() {
    }

    public Knight(boolean isWhite, boolean isKilled) {
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
        if(Row == 1 && Col == 2)
            return true;

        return Row == 2 && Col == 1;
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
        return "Knight";
    }

}
