import java.util.*;

public class Game {

    Board tictactoe;

    // Empty constructor
    public Game() {
        tictactoe = new Board();
    }

    public void run()
    {

        boolean keepRunning = true;

        while (keepRunning) {
            printBoard(tictactoe);

            // User move
            System.out.print("Make your move: ");
            Scanner in = new Scanner(System.in);
            String userMove = in.nextLine();
            tictactoe.makeMove(userMove);
            keepRunning = !tictactoe.checkForWinner("user");

            if (!keepRunning)
                break;

            if (tictactoe.countPossibleMoves() == 0)
                break;

            printBoard(tictactoe);
            System.out.print("Please wait for the computer to finish their turn...");
            pause(2);

            tictactoe.computer();
            keepRunning = !tictactoe.checkForWinner("computer");
        }

        printBoard(tictactoe);
        System.out.println("GAME OVER");
        if (tictactoe.checkForWinner("user"))
            System.out.println("Player won");
        else if (tictactoe.checkForWinner("computer"))
            System.out.println("Player lost");
        else
            System.out.println("It's a tie!");
    }


    private void longBreak() {
        for (int i = 0; i < 30; i ++)
            System.out.println("");
    }

    private static void pause(int i) {
        try
        {
            Thread.sleep(i * 1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public void printBoard(Board board) {
        longBreak();
        System.out.println(board);
    }


    // Future project, graphical components for game:

    /*
    public Game() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setFocusable(true);

        JPanel panel = new JPanel();

        Board tictactoe = new Board();
    }

     */

}
