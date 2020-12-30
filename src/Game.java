import java.util.*;

public class Game {

    Board tictactoe;

    // Empty constructor
    public Game() {
        tictactoe = new Board();
    }

    public void run()

    {
        longBreak();
        System.out.println(tictactoe.toString());

        Scanner in = new Scanner (System.in);

        String userMove = in.nextLine();

        System.out.println(userMove);
        System.out.println(tictactoe.isValidField(userMove));
    }

    private void longBreak() {
        for (int i = 0; i < 30; i ++)
            System.out.println("");
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
