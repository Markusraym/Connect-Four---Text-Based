import java.util.Scanner;
public class ConnectFour {
    public static void main(String[] args) {
        boolean Game = true;
        int gameTracker = 1; // A tracker to add up each turn
        int playerOneTurn = 0; // boolean where if true means its player 1's turn, and player 2's turn if false
        char chipType; // Keeps track of which chip type (x or o) is being sent to each method
        int rowPicked;
        Scanner scanner = new Scanner(System.in); //REMINDER: Always declare Scanner outside the loop!

        // Allow the user to input the width and height of their connect four game board
        System.out.print("What would you like the height of the board to be? ");
        int rowNumber = scanner.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        int columnNumber = scanner.nextInt();
        // Creates the array
        char[][] myArray = new char[rowNumber][columnNumber];

        //Calls initializeBoard method to add '-' to each spot and then printBoard method to display it
        initializeBoard(myArray);
        printBoard(myArray);
        //Tells players their what their game pieces are
        System.out.println();
        System.out.println("Player 1: x");
        System.out.println("Player 2: o");
        System.out.println();

        while (Game) {
            playerOneTurn = gameTracker % 2;
            if (playerOneTurn == 1) {  // Determines which player's turn it is to go
                System.out.print("Player 1: ");
                chipType = 'x';
            }
            else {
                System.out.print("Player 2: ");
                chipType = 'o';
            }
            System.out.print("Which column would you like to choose? ");
            int columnPicked = scanner.nextInt(); // Allows the user to input their choice of row
            rowPicked = insertChip(myArray, columnPicked, chipType); //Calls insertChip method for the player's turn

            printBoard(myArray); // Prints the board
            System.out.println();

            if (checkIfWinner(myArray, columnPicked, rowPicked, chipType) == true) { // Checks who won by discerning who made the last move before checkIfWinner became equal to true
                switch (playerOneTurn) {
                    case 1:
                        System.out.println("Player 1 won the game!");
                        break;
                    case 0:
                        System.out.println("Player 2 won the game!");
                        break;
                }
                break;
            }

            if (gameTracker == columnNumber * rowNumber) { // Checks if there is a tie. If the amount of game moves is equal to the amount of spaces in the array, nobody can win.
                System.out.println("Draw. Nobody wins.");
                break;
            }
            gameTracker = gameTracker + 1; // Adds a 1 to the gametracker to track the amount of player moves
            // Note to self: This might need to be at beginning of while (game) loop? Or before the check if tie?
        }

    }

    public static void printBoard(char[][] array) { //This will print the board
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void initializeBoard(char[][] array) { //This will set each spot in the array to "-"
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = '-';
            }
        }
        // Perhaps insert printBoard(array) here so you don't have to do it in the main method?
    }

    public static int insertChip(char[][] array, int col, char chipType) {
        /* Places the token in the column that the user has chosen. Will find the next available spot in the column
        if there are already tokens there. The row that the token is placed in is returned.
         */
        for (int i = 0; i < array.length; i++) {
        //for (int i = array.length-1; i >= 0; i--){
            if (array[i][col] == '-') {
                array[i][col] = chipType;
                int row = i;
                return row;
            }
        }
        return ' '; //  <-- Not sure why I have to do this but java wants a return statement. This works for some reason

    }

    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {
        /* After a token is added, checks whether the token in this location, of the specified chip type, creates for in a row.
        Will return true if someone won, and false otherwise.
         */
        int repeatCount = 0;

        // Checks if there are four of the same in a single row (Horizontal)
        for (int i = 0; i < array[0].length; i++) {
            if (array[row][i] == chipType) {
                repeatCount = repeatCount + 1;
                if (repeatCount == 4) {
                    return true;
                }
            } else
                repeatCount = 0;
        }

        // Checks if there are four of the same in a single column (Vertical)
        for (int i = 0; i < array.length; i++) {
            if (array[i][col] == chipType) {
                repeatCount = repeatCount + 1;
                if (repeatCount == 4) {
                    return true;
                }
            }
            else {
                repeatCount = 0;
            }
        }
        return false;
    }



} // Class
