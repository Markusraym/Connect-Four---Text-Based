/* import java.util.Scanner;
public class Example {
    public static void main(String[] args) {
        // Live coding based on lab 5
        //Tic Tac Toe live coding session on zybooks, 17.11
        //This is similar, but it will be a 3 x 3
        System.out.println("Player 1: x");
        System.out.println("Player 2: o");
        System.out.println();


        char[] [] board = new char[3][3];
        Scanner scanner = new Scanner(System.in);
        char token;
        boolean player1 = true;

        initializeBoard(board);
        printBoard(board);

        while (true) {

            if (player1) {
                System.out.println("\nPlayer1's Turn (x): ");
                token = 'x';
            }
            else {
                System.out.println("\nPlayer2's Turn (o): ");
                token = 'o';
            }
            //while loop to do the sanity check for valid row and column (if numbers are out of range, error message)
            while (true) {

                System.out.println("Enter a row number (0, 1, or 2): ");
                int row = scanner.nextInt();
                System.out.println("Enter a column number (0, 1, or 2): ");
                int col = scanner.nextInt();

                if (row < 0 || row > 2 || col > 2) {
                    System.out.println("This position is off the bounds of the board! Try again.");
                }
                else if (board[row][col] != '-') {
                    System.out.println("Someone has already made a move at this position! Try again.");
                }
                else {
                    break;
                }
            }

            board[row][col] = token;

            // determine anyone wins the game
            if (checkIfWinner(board, token)) {
                if (token == 'x') {
                    System.out.println("Player 1 has won!");
                    printBoard(board);
                    break;
                }
                else {
                    System.out.println("Payer 2 has won!");
                    printBoard(board);
                    break;
                }
            }
            if (boardIsFull(board)) {
                System.out.println("It's a tie!");
                printBoard(board);
                break;
            }

            printBoard(board);

            player1 = !player1;  // switch between player 1 and player , plauer1 = !true = false we switch to player2
        }



    }
    // - - -
    // - - -
    // - - -
    public static void initializeBoard(char[][] board) { //just puts dashes in the 2d array
        //you want to put dash in the 2d array using nested for loops
        //number of rows = boards.length
        //number of columns = board[0].length
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = '-'; //board[0][0] = '-' bpard[0][1[] = '-' will look at each column at a time and move onto the next row
            }
        }
    }

    public static void printBoard(char[][] board) { // will iterate through each row and print out the columns.
        for (int row = 0; row < board.length; row++ ) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.println(board[row][col] +  " "); // row 0: - - -
            }
            System.out.println();
        }

    }

    public static boolean checkIfWinner(char[][] board, char chipType) {
        // o o o
        // - x -
        // x - x
        // In row 1 all tokens are the same, so chipType = o wins
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] == chipType)
                return true;
        }

        // - x -
        // - x o
        // - x o
        // check columns
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] == chipType) {
                return true;
            }
        }

        // check diagonal
        // x - -
        // o x o
        // - o x

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == chipType) {
            return true;
        }

        // o - x
        // o x o
        // x o x
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] == chipType) {
            return true;
        }
        return false;
    }

    public static boolean boardIsFull(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

}
*/