import java.util.Scanner;

class TicTacToe{
    private char[][] board;
    private char currentPlayer;
    private boolean gameOver;
    private Scanner sc;

    public TicTacToe(){
        board = new char[3][3];
        currentPlayer = 'X';
        gameOver = false;
        sc = new Scanner(System.in);
        initializeBoard();
    }

    public void play(){
        while(!gameOver){
            printBoard();
            System.out.print("Player "+currentPlayer+", enter your co-ordinate: ");
            int row=sc.nextInt();
            int col=sc.nextInt();
            if(board[row][col] == ' '){
                board[row][col] = currentPlayer;
                gameOver = hasWon();
                if(gameOver){
                    System.out.println("Player "+currentPlayer+" wins!!!");
                } else if (matchDraw()) {
                    System.out.println("Game is a draw!!");
                    gameOver=true;

                } else{
                    currentPlayer = (currentPlayer=='X')?'O':'X';
                }

            }else{
                System.out.println("Invalid move, Please retry!");
            }
        }
        printBoard();
    }

    public boolean matchDraw() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWon() {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) {
                return true;
            }
        }
        for (int col = 0; col < board.length; col++) {
            if (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) {
                return true;
            }
        }
        if(board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer){
            return true;
        }
        if(board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer){
            return true;
        }
        return false;
    }

    public void printBoard(){
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                System.out.print(board[row][col]+" | ");
            }
            System.out.println();
        }
    }
    public void initializeBoard(){
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                board[row][col] = ' ';
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();
        game.play();
    }
}