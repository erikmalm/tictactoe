public class Main {

    public static void main (String[] args)
    {
        Board tictactoe = new Board();


        tictactoe.putPlayer(0, 0);
        System.out.println(tictactoe.toString());

        System.out.println(tictactoe.isValidField(2,2));
    }
}
