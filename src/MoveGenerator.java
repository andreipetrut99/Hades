import java.nio.file.Path;

public class MoveGenerator {
    private String move;
    private int intMove;
    private static MoveGenerator instance = null;
    private Board board;

    private MoveGenerator() {
        board = Board.getInstance();
    }

    public static MoveGenerator getInstance() {
        if (instance == null) {
            instance = new MoveGenerator();
            return instance;
        }
        return instance;
    }

    public String getMove(int current, int next) {
        String move;
        char letter = (char) (96 + (current % 10));
        move = "" + letter + (10 - (current / 10));
        letter = (char) (96 + (next % 10));
        move = move + letter + (10 - (next / 10));
        if (board.getPiece(current) == Constants.bP && next > 90) {
            move += "q";
        } else if (board.getPiece(current) == Constants.wP && next < 29) {
            move += "q";
        }

        return move;
    }

}
