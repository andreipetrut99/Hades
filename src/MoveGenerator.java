public class MoveGenerator {
    private String move;
    private int intMove;
    private static MoveGenerator instance = null;

    private MoveGenerator() {
    }

    public static MoveGenerator getInstance() {
        if (instance == null) {
            instance = new MoveGenerator();
            return instance;
        }
        return instance;
    }

    public String getMove(int current, int next) {
        char letter = (char) (96 + (current % 10));
        String move = "" + letter + (10 - (current / 10));
        letter = (char) (96 + (next % 10));
        move = move + letter + (10 - (next / 10));

        return move;
    }

}
