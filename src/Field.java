public class Field {
    // Coordinates
    int row;
    int column;
    String mark = "   ";

    public Field(int i, int j) {
        row = i;
        column = j;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        if (row % 2 == 0 && column % 2 == 0)
            sb.append(mark);

        else if ((column == 1 || column == 3) && row % 2 == 0)
            sb.append(" | ");

        else if ((row == 1 || row == 3) && column % 2 == 0)
            sb.append("---");

        else {
            sb.append("-+-");
        }
        return sb.toString();
    }
}
