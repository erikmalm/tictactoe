public class Board {

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

    public boolean isValidField(String userMove) {

        // The row has a 64 step difference from the ascii char value
        int row = userMove.charAt(0) - 64;

        // The int has a 48 step difference from the ascii char value
        int column = userMove.charAt(1)- 48;

        return (row > 0 && row < 4 && column > 0 && column < 4);
    }

    // This will check if the suggested field is valid, which is an even number for both x and y
    // between 0 and 4.
    public boolean isValidField(int x, int y) {
        return (x % 2 == 0 && y % 2 == 0 && x >= 0 && x <= 4 && y >= 0 && y <= 4);
    }

}
