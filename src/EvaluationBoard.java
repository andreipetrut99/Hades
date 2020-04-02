import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvaluationBoard {
    private List<Integer> pawnPoints;
    private List<Integer> kingPoints;
    private List<Integer> queenPoints;
    private List<Integer> roockPoints;
    private List<Integer> bishopPoints;
    private List<Integer> knightPoints;
    private static EvaluationBoard instance = null;

    private EvaluationBoard() {
        pawnPoints = new ArrayList<>(120);
        kingPoints = new ArrayList<>(120);
        queenPoints = new ArrayList<>(120);
        roockPoints = new ArrayList<>(120);
        bishopPoints = new ArrayList<>(120);
        knightPoints = new ArrayList<>(120);
        initialize();
    }

    public static EvaluationBoard getInstance() {
        if (instance == null) {
            instance = new EvaluationBoard();
        }
        return instance;
    }
    
    public int evaluateBoard(Board board, boolean evaluateBlack) {
        int score = 0;
        int k = 0;
        int p = 1;

        if (evaluateBlack) {
            k = 119;
            p = -1;
        }

        for (int i = 21; i < 99; i++) {
            if (evaluateBlack ? board.isBlack(i) : board.isWhite(i)) {
                if (board.isPawn(i)) {
                    score += getPawnPoints(k + (p * i));
                }
                if (board.isRoock(i)) {
                    score += getRoockPoints(k + (p * i));
                }
                if (board.isBishop(i)) {
                    score += getBishopPoints(k + (p * i));
                }
                if (board.isKnight(i)) {
                    score += getKnightPoints(k + (p * i));
                }
                if (board.isQueen(i)) {
                    score += getQueenPoints(k + (p * i));
                }
                if (board.isKing(i)) {
                    score += getKingPoints(k + (p * i));
                }
            }
        }
        return score;
    }

    public int getKnightPoints(int index) {
        return knightPoints.get(index);
    }

    public int getBishopPoints(int index) {
        return bishopPoints.get(index);
    }

    public int getRoockPoints(int index) {
        return roockPoints.get(index);
    }

    public int getQueenPoints(int index) {
        return queenPoints.get(index);
    }

    public int getKingPoints(int index) {
        return kingPoints.get(index);
    }

    public int getPawnPoints(int index) {
        return pawnPoints.get(index);
    }

    private void initialize() {
        pawnPoints = Arrays.asList(
                  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                 50, 50, 50, 50, 50, 50, 50, 50,  0,  0,
                 10, 10, 20, 30, 30, 20, 10, 10,  0,  0,
                  5,  5, 10, 25, 25, 10,  5,  5,  0,  0,
                  0,  0,  0, 20, 20,  0,  0,  0,  0,  0,
                  5, -5,-10,  0,  0,-10, -5,  5,  0,  0,
                  5, 10, 10,-20,-20, 10, 10,  5,  0,  0,
                  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                  0,  0,  0,  0,  0,  0,  0,  0,  0,  0);

        kingPoints = Arrays.asList(
                  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                -30,-40,-40,-50,-50,-40,-40,-30,  0,  0,
                -30,-40,-40,-50,-50,-40,-40,-30,  0,  0,
                -30,-40,-40,-50,-50,-40,-40,-30,  0,  0,
                -30,-40,-40,-50,-50,-40,-40,-30,  0,  0,
                -20,-30,-30,-40,-40,-30,-30,-20,  0,  0,
                -10,-20,-20,-20,-20,-20,-20,-10,  0,  0,
                 20, 20,  0,  0,  0,  0, 20, 20,  0,  0,
                 20, 30, 10,  0,  0, 10, 30, 20,  0,  0,
                  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
        );

        queenPoints = Arrays.asList(
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                -20,-10,-10, -5, -5,-10,-10,-20,  0,  0,
                -10,  0,  0,  0,  0,  0,  0,-10,  0,  0,
                -10,  0,  5,  5,  5,  5,  0,-10,  0,  0,
                -5,  0,  5,  5,  5,  5,  0, -5,  0,  0,
                0,  0,  5,  5,  5,  5,  0, -5,  0,  0,
                -10,  5,  5,  5,  5,  5,  0,-10,  0,  0,
                -10,  0,  5,  0,  0,  0,  0,-10,  0,  0,
                -20,-10,-10, -5, -5,-10,-10,-20,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0
        );

        roockPoints = Arrays.asList(
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                5, 10, 10, 10, 10, 10, 10,  5,  0,  0,
                -5,  0,  0,  0,  0,  0,  0, -5,  0,  0,
                -5,  0,  0,  0,  0,  0,  0, -5,  0,  0,
                -5,  0,  0,  0,  0,  0,  0, -5,  0,  0,
                -5,  0,  0,  0,  0,  0,  0, -5,  0,  0,
                -5,  0,  0,  0,  0,  0,  0, -5,  0,  0,
                0,  0,  0,  5,  5,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0
        );

        bishopPoints = Arrays.asList(
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                -20,-10,-10,-10,-10,-10,-10,-20,  0,  0,
                -10,  0,  0,  0,  0,  0,  0,-10,  0,  0,
                -10,  0,  5, 10, 10,  5,  0,-10,  0,  0,
                -10,  5,  5, 10, 10,  5,  5,-10,  0,  0,
                -10,  0, 10, 10, 10, 10,  0,-10,  0,  0,
                -10, 10, 10, 10, 10, 10, 10,-10,  0,  0,
                -10,  5,  0,  0,  0,  0,  5,-10,  0,  0,
                -20,-10,-10,-10,-10,-10,-10,-20,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0
        );

        knightPoints = Arrays.asList(
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                -50,-40,-30,-30,-30,-30,-40,-50,  0,  0,
                -40,-20,  0,  0,  0,  0,-20,-40,  0,  0,
                -30,  0, 10, 15, 15, 10,  0,-30,  0,  0,
                -30,  5, 15, 20, 20, 15,  5,-30,  0,  0,
                -30,  0, 15, 20, 20, 15,  0,-30,  0,  0,
                -30,  5, 10, 15, 15, 10,  5,-30,  0,  0,
                -40,-20,  0,  5,  5,  0,-20,-40,  0,  0,
                -50,-40,-30,-30,-30,-30,-40,-50,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0
        );


    }

}
