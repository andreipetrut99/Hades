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
        if (board.isBlackOnTop()) {
            char letter = (char) (96 + (current % 10));
            move = "" + letter + (10 - (current / 10));
            letter = (char) (96 + (next % 10));
            move = move + letter + (10 - (next / 10));
        } else {
            char letter = (char) (105 - (current % 10));
            move = "" + letter + (current / 10 - 1);
            letter = (char) (105 - (next % 10));
            move = move + letter + (next / 10 - 1);
        }
        return move;
    }

}
