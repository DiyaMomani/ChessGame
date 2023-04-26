import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.concurrent.CancellationException;

public class ChessGame {
    private Game game = new Game();
    public void start() throws FileNotFoundException {play();}
    //play////////////////////////////////
    public void play() throws FileNotFoundException {

        boolean isEnd=false;
        Scanner input = new Scanner(System.in);
        System.out.println("if you want to use test case enter 1 , for input from user enter 2 :");
        if(input.nextLine().equalsIgnoreCase("1")){
            input = new Scanner(new File("/C:/Users/didim/OneDrive/Desktop/test-case-2.txt"));
        }
//        Scanner input = new Scanner(System.in);
        int moveCounter = 1;
        //initialize and set 2 players//////////////////
        Player p1 = new Player(true);
        Player p2 = new Player(false);
        game.setP1(p1);
        game.setP2(p2);
        //set the board/////////////////////
        game.getBoard().setTheBoard();
        Square[][] squares = game.getBoard().getSquares();
        game.printBoard(squares);
        //play while game is not end (no king is dead)and the number of moves <=50 and there is no checkmate status////////
        game.setCurrentTurn(p1);
        while (!game.isEnd() && moveCounter <= 50) {
            boolean isChecked = true;
            int cnt = 0;
            List<String> validMoves = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(squares[i][j].getPiece() != null &&
                            game.getCurrentTurn().isWhite() == squares[i][j].getPiece().isWhite()){
                        for(int k = 0 ; k < 8 ; k++){
                            for(int l = 0 ; l < 8 ; l++){
                                if(canMove(squares,i ,j ,k ,l)){
                                    isChecked = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if(!input.hasNext()){
                break;
            }
            if(isChecked){

                game.setEnd(true);
                isEnd = game.isEnd();
                break;
            }
            //set current player//////////////
            if (moveCounter % 2==1) {
                game.setCurrentTurn(p1);
                System.out.print("please enter "+moveCounter+"# move(White side):");
            } else {
                game.setCurrentTurn(p2);
                System.out.print("please enter "+moveCounter+"# move(Black side):");
            }
                //players enter values///////////////////
                String regex = "^[mM][oO][Vv][Ee]\\s+[a-hA-H][1-8]\\s+[a-hA-H][1-8]";
                String player = input.nextLine();
                if(!player.matches(regex)){
                    continue;
                }
                player = player.toLowerCase();
                String[] parts = player.split("\\s+");
                if(parts.length != 3){
                    System.out.println("wrong input...try again please");
                    continue;
                }
                int currRow = parts[1].charAt(1) - '0' - 1;
                int currCol = parts[1].charAt(0) - 'a';
                int nextRow = parts[2].charAt(1) - '0' - 1;
                int nextCol = parts[2].charAt(0) - 'a';
                if(canMove(squares,currRow,currCol,nextRow,nextCol)){
                    isEnd=game.move(squares, currRow, currCol, nextRow , nextCol);
                    if(isEnd) game.setEnd(true);
                    moveCounter++;
                }
                else{
                    System.out.println("Try again ...");
                }
            game.printBoard(squares);
        }
        //print end statement if number of moves are above 50//////////////////
        if(moveCounter>50) System.out.println("number of moves are above 50!!!....the game is ended");
    }

    public boolean canMove(Square[][] squares , int currRow , int currCol, int nextRow, int nextCol){

        //check if the current square has a piece//////
        if (squares[currRow][currCol].getPiece() == null) {
            return false;
        }


        //check if the player play with piece is not from his pieces/////////////
        if ((game.getCurrentTurn().isWhite() && !squares[currRow][currCol].getPiece().isWhite()) || (!game.getCurrentTurn().isWhite() && squares[currRow][currCol].getPiece().isWhite())) {
            return false;
        }
        //check if the player will kill one of his pieces/////////////
        if(squares[nextRow][nextCol].getPiece()!=null && squares[currRow][currCol].getPiece()!=null) {
            if ((squares[nextRow][nextCol].getPiece().isWhite() && squares[currRow][currCol].getPiece().isWhite()) ||
                    (!squares[nextRow][nextCol].getPiece().isWhite() && !squares[currRow][currCol].getPiece().isWhite())) {
                return false;
            }
        }
        //check if the move for this piece is valid and move them if the move is correct///////////////////
        if (!squares[currRow][currCol].getPiece().canMove(currRow, currCol, nextRow, nextCol)) {
            return false;
        }
        else {
            IPiece piece = squares[nextRow][nextCol].getPiece();
            squares[nextRow][nextCol].setPiece(squares[currRow][currCol].getPiece());
            squares[currRow][currCol].setPiece(null);
            if(!isKingChecked(squares)){
                squares[currRow][currCol].setPiece(squares[nextRow][nextCol].getPiece());
                squares[nextRow][nextCol].setPiece(piece);
                return true;
            }
            squares[currRow][currCol].setPiece(squares[nextRow][nextCol].getPiece());
            squares[nextRow][nextCol].setPiece(piece);
        }
        return false;
    }

    public boolean isKingChecked(Square [][]squares){
        int kingRow = -1;
        int kingCol = -1;
        for(int  i = 0 ; i < 8 ; i++){
            for(int j = 0 ; j < 8 ; j++){
                if(squares[i][j].getPiece() != null &&
                        squares[i][j].getPiece().isWhite() == game.getCurrentTurn().isWhite()){

                    if(squares[i][j].getPiece().getType().equals("King")){
                        kingCol = j;
                        kingRow = i;
                    }
                }
            }
        }
        for(int i = 0 ; i < 8 ; i++){
            for(int j = 0 ; j < 8 ; j++){
                if(squares[i][j].getPiece() != null &&
                        squares[i][j].getPiece().isWhite() != game.getCurrentTurn().isWhite()){
                    if(squares[i][j].getPiece().canMove(i , j , kingRow , kingCol)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
