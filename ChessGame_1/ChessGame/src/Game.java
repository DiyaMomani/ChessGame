public class Game {
        private Board board=Board.getBoard();;
        private Player currentTurn;
        private boolean isEnd;
        private Player p1,p2;
        public Game() {
                isEnd=false;
        }
        public Game(Player currentTurn, boolean isEnd, Player p1, Player p2) {
                this.currentTurn = currentTurn;
                this.isEnd = isEnd;
                this.p1 = p1;
                this.p2 = p2;
        }

        public Board getBoard() {
                return board;
        }

        public void setBoard(Board board) {
                this.board = board;
        }

        public Player getCurrentTurn() {
                return currentTurn;
        }

        public void setCurrentTurn(Player currentTurn) {
                this.currentTurn = currentTurn;
        }

        public boolean isEnd() {
                return isEnd;
        }

        public void setEnd(boolean end) {
                isEnd = end;
        }

        public Player getP1() {
                return p1;
        }

        public void setP1(Player p1) {
                this.p1 = p1;
        }

        public Player getP2() {
                return p2;
        }

        public void setP2(Player p2) {
                this.p2 = p2;
        }
        //move the pieces ///////////////////////
        public boolean move(Square[][] squares, int currRow, int currCol, int nextRow, int nextCol) {
                //boolean variable to check if one of kings dead//////////////
                boolean isEnd=false;
                //check if the next square is null/////////////
                if (squares[nextRow][nextCol].getPiece() == null) {
                        //if its null just move the piece////////////////
                        squares[nextRow][nextCol].setPiece(squares[currRow][currCol].getPiece());
                        squares[currRow][currCol].setPiece(null);
                }
                else{
                        //if the piece is not king, move the piece and kill it///
                        squares[nextRow][nextCol].setPiece(squares[currRow][currCol].getPiece());
                        squares[currRow][currCol].setPiece(null);
                        squares[nextRow][nextCol].getPiece().setKilled(true);
                }


                return isEnd;
        }
        //print the board//////////
        public void printBoard(Square[][] squares) {
                String textColor = "\u001B[97m";
                for(int i=0;i<8;i++){
                        System.out.print(textColor + "\t=========================================================" +
                                "========================================\n");
                        for(int j=0;j<8;j++){
                                if(j == 0) System.out.print(i + 1 + "\t");
                                System.out.print("|\t" + squares[i][j].toString() + textColor + "\t|");
                        }
                        System.out.println("");
                }
                System.out.println("\t=========================================================" +
                        "========================================");
                System.out.println("\t\t  a\t\t\t  b\t\t\t  c\t\t\t  d\t\t\t  e\t\t\t  f\t\t\t  g\t\t\t  h");
        }

}
