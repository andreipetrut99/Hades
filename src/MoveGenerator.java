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
        String move = "" + letter + (current / 10 - 1);
        letter = (char) (96 + (next % 10));
        move = move + letter + (next / 10 - 1);

        return move;
    }

}
