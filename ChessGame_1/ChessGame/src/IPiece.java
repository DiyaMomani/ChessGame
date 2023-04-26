public interface IPiece {
    //applicant of factory design patterns to reduce couping/////

    //check if the piece can move or not/////
    public boolean canMove(int currRow,int currCol,int nextRow,int nextCol);
    //return if the piece is white or not////
    public boolean isWhite();
    //set if the piece is killed or not/////
    public void setKilled(boolean killed);
    //check if the piece is killed or not/////
    public boolean isKilled();
    //check what is the type of the piece////
    public String getType();
}
