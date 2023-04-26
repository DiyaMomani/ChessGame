public class Board {
    private Square[][] squares;
    //applicant the singleton design in board because there is just one board///
    private static Board board=new Board();
    private PieceFactory pieceFactory=new PieceFactory();
    private Board() {squares = new Square[8][8];}

    public static Board getBoard(){
        return board;
    }

    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    //set the board and place every piece in its correct square/////
    public void setTheBoard(){
        //set all squares////////////////
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                squares[i][j]=new Square(i,j,null);
            }
        }
        //set black main pieces//////////////////
        squares[0][0]=new Square(0,0,pieceFactory.getPiece("Rook",true));
        squares[0][1]=new Square(0,1,pieceFactory.getPiece("Knight",true));
        squares[0][2]=new Square(0,2,pieceFactory.getPiece("Bishop",true));
        squares[0][3]=new Square(0,3,pieceFactory.getPiece("Queen",true));
        squares[0][4]=new Square(0,4,pieceFactory.getPiece("King",true));
        squares[0][5]=new Square(0,5,pieceFactory.getPiece("Bishop",true));
        squares[0][6]=new Square(0,6,pieceFactory.getPiece("Knight",true));
        squares[0][7]=new Square(0,7,pieceFactory.getPiece("Rook",true));

        for(int i=0;i<8;i++){
            squares[1][i]=new Square(1,i,pieceFactory.getPiece("Pawn",true));
        }
        //set white main pieces////////////////
        squares[7][0]=new Square(7,0,pieceFactory.getPiece("Rook",false));
        squares[7][1]=new Square(7,1,pieceFactory.getPiece("Knight",false));
        squares[7][2]=new Square(7,2,pieceFactory.getPiece("Bishop",false));
        squares[7][3]=new Square(7,3,pieceFactory.getPiece("Queen",false));
        squares[7][4]=new Square(7,4,pieceFactory.getPiece("King",false));
        squares[7][5]=new Square(7,5,pieceFactory.getPiece("Bishop",false));
        squares[7][6]=new Square(7,6,pieceFactory.getPiece("Knight",false));
        squares[7][7]=new Square(7,7,pieceFactory.getPiece("Rook",false));
        for(int i=0;i<8;i++){
            squares[6][i]=new Square(6,i,pieceFactory.getPiece("Pawn",false));
        }

    }

}
