public class Board {

    // Properties of the board
    public static final int NUMBER_OF_ROWS = 5;
    public static final int NUMBER_OF_COLUMNS = 5;

    // Player position holds the x and y coordinates for the current player position,
    // or an int array of length 2
    int [] playerPosition = new int [2];

    // Print the board
    String [][] board = new String [NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

    // Empty constructor
    public Board () {

        for (int i = 0; i < NUMBER_OF_ROWS; i ++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                if (i % 2 == 0 && j % 2 == 0)
                    board[i][j] = "   ";

                else if ((j == 1 || j == 3) && i % 2 == 0)
                    board[i][j] = " | ";

                else if ((i == 1 || i == 3) && j % 2 == 0)
                    board[i][j] = "---";

                else {
                    board[i][j] = "-+-";
                }
            }
        }
    }

    // This will check if the suggested field is valid, which is an even number for both x and y
    // between 0 and 4.
    public boolean isValidField(int x, int y) {
        return (x % 2 == 0 && y % 2 == 0 && x >= 0 && x <= 4 && y >= 0 && y <= 4);
    }

    public void putPlayer(int x, int y)  {
        playerPosition[1] = 0; // column
        playerPosition[0] = 0; // row
        board[playerPosition[0]][playerPosition[1]] = "[ ]";
    }

    public String toString() {
        StringBuilder printBoard = new StringBuilder();

        for (int i = 0; i < NUMBER_OF_ROWS; i ++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                printBoard.append(board[i][j]);
            }
            printBoard.append("\n");
        }

        return printBoard.toString();
    }
}
