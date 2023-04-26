public class Square {
    private int row;
    private int col;
    private IPiece piece;

    public Square() {
    }

    public Square(int row, int col,IPiece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }
    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public IPiece getPiece() {
        return piece;
    }

    public void setPiece(IPiece piece) {
        this.piece = piece;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    //if there is piece in this square,print the type of piece in this square and its color
    //else print space
    @Override
    public String toString(){
        if(piece==null) return "\t"+" ";
        else{
            String textColor = "\u001B[30m";
            if(piece.isWhite()){
                textColor = "\u001B[97m";
            }
            return "\033[1;95m" + textColor + piece.getType()+" ";
        }
    }

}
