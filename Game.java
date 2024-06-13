package TicTacToeGame;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ' ';
            }
        }


        Scanner scanner = new Scanner(System.in);
        char player = 'X';
        boolean gameOver = false;
        int placed = 0;
        while (!gameOver) {
            printBoard(board);
            System.out.println("Enter " + player + " scractch Place");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            System.out.println();

            if (board[row][col] == ' ') {
                board[row][col] = player;
                placed++;
                gameOver = haveWon(board, player);
                if (gameOver) {
                    System.out.println("********************************");
                    System.out.println("Player " + player + " has won: ");
                    System.out.println("********************************");

                } else if (placed == board.length * board[0].length) {
                    System.out.println("Match Tied ----");
                    break;
                } else {
                    player = player == 'X' ? 'O' : 'X';
                }
            } else {
                System.out.println("You Entered Invalid Place ! Try Again !");
            }
        }

    }

    private static boolean haveWon(char[][] board, char player) {
        // Check Row
        for (int row = 0; row < board[0].length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }
        //Check Col
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }
        // Check Diagnols
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if (board[0][2] == player && board[2][0] == player && board[1][1] == player){
            return true;
        }
        return false;
    }

    private static void printBoard(char[][] board) {
        System.out.println("    0   1   2");
        System.out.println("  -------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i);
            System.out.print(" |");  // Left border of the row
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" " + board[i][j] + " |");  // Print each element with borders
            }
            System.out.println();
            // Print the border after each row
            System.out.println("  -------------");
        }
    }

}
