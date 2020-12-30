import java.util.Random;

public class Board {

    public static final Random rand = new Random();

    // Properties of the board
    public static final int NUMBER_OF_ROWS = 5;
    public static final int NUMBER_OF_COLUMNS = 5;

    // Player position holds the x and y coordinates for the current player position,
    // or an int array of length 2
    int [] playerPosition = new int [2];

    // Print the board
    Field [][] board = new Field [NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

    // Empty constructor
    public Board () {

        for (int i = 0; i < 5; i ++)
            for (int j = 0; j < 5; j++)
                board[i][j] = new Field(i, j);
    }


    // This will print the current layout of the tic tac toe board
    public String toString() {
        StringBuilder printBoard = new StringBuilder();

        // Print the head section for the columns
        printBoard.append("   1     2     3  \n");

        // Make the first row, row A
        char rowLetter = 65;

        for (int i = 0; i < 5; i ++) {

            // If game section, print the current row letter and increment 1
            if (i % 2 == 0) {
                printBoard.append(rowLetter + " ");
                rowLetter ++;
            }
            else
                printBoard.append("  ");

            for (int j = 0; j < 5; j++) {
                printBoard.append(board[i][j]);
            }
            printBoard.append("\n");
        }

        return printBoard.toString();
    }

    public boolean checkMove(String userMove) {
        return (isEmpty(userMove));
    }

    public void performMove(String userMove, String player) {

        // The row has a 64 step difference from the ascii char value
        // To get the actual position on the board, we multiply by 2,
        // and then subtract with 2
        int row = (userMove.charAt(0) - 64) * 2 - 2;

        // The int has a 48 step difference from the ascii char value
        // To get the actual position on the board, we multiply by 2,
        // and then subtract with 2
        int column = (userMove.charAt(1) - 48) * 2 - 2;

        board[row][column].markField(player);

    }

    // With the method to check if the current field is empty,
    private boolean isEmpty(String userMove) {

        // The row has a 64 step difference from the ascii char value
        // To get the actual position on the board, we multiply by 2,
        // and then subtract with 2
        int row = (userMove.charAt(0) - 64) * 2 - 2;

        // The int has a 48 step difference from the ascii char value
        // To get the actual position on the board, we multiply by 2,
        // and then subtract with 2
        int column = (userMove.charAt(1) - 48) * 2 - 2;

        // We need to begin by checking the validty of the move,
        // Then we can see if the field is empty or not
        if (isValidField(userMove))
            return (board[row][column].mark.equals("   "));

        else
            return false;

    }

    // This will check if the user has input a valid field
    // Notice that the fields are built on a matrix of 5 * 5, where only
    // the even numbers are valid - however when checking validity,
    // the user will input row A-C and column 1-3!
    public boolean isValidField(String userMove) {

        // The row has a 64 step difference from the ascii char value
        int row = userMove.charAt(0) - 64;

        // The int has a 48 step difference from the ascii char value
        int column = userMove.charAt(1)- 48;

        return (row > 0 && row < 4 && column > 0 && column < 4);
    }

    public void makeMove(String userMove) {
        if (checkMove(userMove))
            performMove(userMove, "user");

        else
            System.out.println("Something went wrong");
    }

    public void computer() {

        // First we need to check available moves
        // For each amount of possible moves, we increment one

        int possibleMoves = countPossibleMoves();

        String [] computerMoves = new String [possibleMoves];
        int k = 0;

        for (int i = 0; i < 3; i ++)
            for (int j = 0; j < 3; j ++) {

                int rowInt = 65 + i;
                char row = (char) rowInt;

                int colInt = 49 + j;
                char col = (char) colInt;

                String computerMove = "" + row + col;

                if (checkMove(computerMove))
                    computerMoves[k++] = computerMove;
            }

        int move = rand.nextInt(possibleMoves);
            performMove(computerMoves[move], "computer");
    }

    private int countPossibleMoves() {

        int possibleMoves = 0;

        for (int i = 0; i < 3; i ++)
            for (int j = 0; j < 3; j ++) {

                int rowInt = 65 + i;
                char row = (char) rowInt;

                int colInt = 49 + j;
                char col = (char) colInt;

                String computerMove = "" + row + col;

                if (checkMove(computerMove))
                    possibleMoves ++;
            }
        return possibleMoves;
    }

    public boolean checkForWinner(String player) {
        boolean winner = false;

        String fieldType;

        if (player.equals("user"))
            fieldType =" X ";

        else
            fieldType =" O ";


        for (int i = 0; i < 3; i ++) {
            int k = 0;
            int z = 0;
            for (int j = 0; j < 3; j ++) {
                int row = (i + 1) * 2 - 2;
                int col = (j + 1) * 2 - 2;

                if (board[row][col].mark.equals(fieldType))
                    k++;

                if (board[col][row].mark.equals(fieldType))
                    z++;

                // System.out.println(k);

                if (k == 3 || z == 3)
                    winner = true;
            }
        }



        return winner;
    }
}
