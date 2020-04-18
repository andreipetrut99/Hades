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
        pawnPoints = new ArrayList<>(170);
        kingPoints = new ArrayList<>(170);
        queenPoints = new ArrayList<>(170);
        roockPoints = new ArrayList<>(170);
        bishopPoints = new ArrayList<>(170);
        knightPoints = new ArrayList<>(170);
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
        int pawnsNo = 0;
        int knightsNo = 0;
        int king = 0;
        int queensNo = 0;
        int bishopsNo = 0;
        int roocksNo = 0;

        if (evaluateBlack) {
            k = 119;
            p = -1;
        }

        for (int i = 21; i < 99; i++) {
            if (evaluateBlack ? board.isBlack(i) : board.isWhite(i)) {
                if (board.isPawn(i)) {
                    score += getPawnPoints(k + (p * i));
                    pawnsNo += 1;
                }
                if (board.isRoock(i)) {
                    score += getRoockPoints(k + (p * i));
                    roocksNo += 1;
                }
                if (board.isBishop(i)) {
                    score += getBishopPoints(k + (p * i));
                    bishopsNo += 1;
                }
                if (board.isKnight(i)) {
                    score += getKnightPoints(k + (p * i));
                    knightsNo += 1;
                }
                if (board.isQueen(i)) {
                    score += getQueenPoints(k + (p * i));
                    queensNo += 1;
                }
                if (board.isKing(i)) {
                    score += getKingPoints(k + (p * i));
                    king = 1;
                }
            }
        }
        if (king == 0) {
            return Integer.MIN_VALUE;
        }
        int piecesNoScore = 10 * pawnsNo + 80 * bishopsNo + 80 * knightsNo +  100 * roocksNo + 90 * queensNo;
        return score + 3 * piecesNoScore;
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
                50,  50,  50,  50,  50,  50,  50,  50,  0,  0,
                100, 100, 100, 100, 100, 100, 100, 100,  0,  0,
                60, 60, 70, 80, 80, 70, 60, 60,  0,  0,
                55,  55, 60, 75, 75, 60,  55,  55,  0,  0,
                50, 50,  50, 70, 70,  50,  50,  50,  0,  0,
                55, 45, 40,  50,  50, 40, 45,  55,  0,  0,
                55, 60, 60, 30, 30, 60, 60,  55,  0,  0,
                50,  50,  50,  50,  50,  50,  50,  50,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0);

        kingPoints = Arrays.asList(
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                20, 10, 10,  0,  0, 10, 10, 20,  0,  0,
                20, 10, 10,  0,  0, 10, 10, 20,  0,  0,
                20, 10, 10,  0,  0, 10, 10, 20,  0,  0,
                20, 10, 10,  0,  0, 10, 10, 20,  0,  0,
                30, 20, 20, 10, 10, 20, 20, 30,  0,  0,
                40, 30, 30, 30, 30, 30, 30, 40,  0,  0,
                70, 70,  50,  50,  50,  50, 70, 70,  0,  0,
                70, 80, 10,  50,  50, 10, 80, 70,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0
        );

        queenPoints = Arrays.asList(
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                30,40,40, 45, 45, 40, 40, 30,  0,  0,
                40,  50,  50,  50,  50,  50,  50, 40,  0,  0,
                40,  50,  55,  55,  55,  55,  50,40,  0,  0,
                45,  50,  55,  55,  55,  55,  50, 45,  0,  0,
                50,  50,  55,  55,  55,  55,  50, 45,  0,  0,
                40,  55,  55,  55,  55, 55,  50,40,  0,  0,
                40,  50,  5,   50,  50,  50,  50,40,  0,  0,
                30,  40,  40,  45, 45, 40, 40, 30,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0
        );

        roockPoints = Arrays.asList(
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                50,  50,  50,  50,  50,  50,  50,  50,  0,  0,
                55,  60,  60,  60,  60,  60,  60, 55,  0,  0,
                45,  50,  50,  50,  50,  50,  50, 45,  0,  0,
                45,  50,  50,  50,  50,  50,  50, 45,  0,  0,
                45,  50,  50,  50,  50,  50,  50, 45,  0,  0,
                45,  50,  50,  50,  50,  50,  50, 45,  0,  0,
                45,  50,  50,  50,  50,  50,  50, 45,  0,  0,
                50,  50,  50,  55,  55,  50,  50, 50,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0
        );

        bishopPoints = Arrays.asList(
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                30, 40, 40, 40, 40, 40, 40, 30,  0,  0,
                40,  50,  50,  50,  50,  50,  50, 40,  0,  0,
                40,  50,  55, 60, 60,  45, 50, 40,  0,  0,
                40,  55,  55, 60, 60,  55, 55, 40,  0,  0,
                40,  50,  60, 60, 60, 60, 50, 40,  0,  0,
                40,  60,  60, 60, 60, 60, 60, 40,  0,  0,
                40,  55,  50, 50, 50, 50, 45, 40,  0,  0,
                30,  40,  40, 40, 40, 40, 40, 30,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0
        );


        knightPoints = Arrays.asList(
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                50, 10, 20, 20, 20, 20, 10, 50,  0,  0,
                10,  30,  50,  50,  50,  50,30,10,  0,  0,
                20,  50, 60, 65, 65, 60,  50,20,  0,  0,
                20,  55, 65, 70, 70, 65,  55,20,  0,  0,
                20,  50, 65, 70, 70, 65,  50,20,  0,  0,
                20,  55, 60, 65, 65, 60,  55,20,  0,  0,
                10, 30,  50, 55, 55,  50, 30,10,  0,  0,
                50,10,20,20,20,20,10,50, 0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                0,  0,  0,  0,  0,  0,  0,  0,  0,  0
        );


    }

}
