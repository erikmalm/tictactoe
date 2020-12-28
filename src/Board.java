public class Board {

    // Properties of the board
    public static final int NUMBER_OF_ROWS = 5;
    public static final int NUMBER_OF_COLUMNS = 5;

    // Print the board
    String [][] board = new String [NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];

    public Board () {
        // Empty constructor
        createBoard();
    }

    private void createBoard() {

        // Construct the board
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
