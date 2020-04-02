import java.util.ArrayList;

public class Engine {
    private static Engine instance = null;
    private ArrayList<String> previousMoves;
    private Board board;

    private Engine() {
        initializeEngine();
    }


    private String getBestWhiteMove(int minIndex) {
        int maximumScore = Integer.MIN_VALUE;
        for (int i = minIndex; i < 99; i++) {
            int piece = board.getPiece(i);
            if (board.isWhite(i)) {
                int[] availableMoves;
                availableMoves = getAvailableMoves(piece, i);
            }
        }
    }

    private String getBestBlackMove(int minIndex) {

    }

    private int[] getAvailableMoves(int piece, int index) {
        if ((piece == Constants.wP) || (piece == Constants.bP)) {
            return getPawnMoves(piece, index);
        }
        if ((piece == Constants.wK) || (piece == Constants.bK)) {
            return getKingMoves(index);
        }
        if ((piece == Constants.wQ) || (piece == Constants.bQ)) {
            return getQueenMoves(index);
        }
        if ((piece == Constants.wN) || (piece == Constants.bN)) {
            return getKnightMoves(index);
        }
        if ((piece == Constants.wB) || (piece == Constants.bB)) {
            return getBishopMoves(index);
        }
        if ((piece == Constants.wR) || (piece == Constants.bR)) {
            return getRoockMoves(index);
        }
        return null;
    }

    private int[] getRoockMoves(int index) {
        return new int[2];
    }

    private int[] getBishopMoves(int index) {
        return new int[2];
    }

    private int[] getKnightMoves(int index) {
        return new int[2];
    }

    private int[] getQueenMoves(int index) {
        return new int[2];
    }

    private int[] getKingMoves(int index) {
        return new int[2];
    }

    private int[] getPawnMoves(int piece, int index) {
        int[] moves = new int[5];
        int possibleMoves = 0;
        int increment = 0;
        if (piece == Constants.wP) {
            increment = -10;
        } else {
            increment = 10;
        }

        if (board.getPiece(index + increment) == Constants.E) {
            moves[possibleMoves] = index + increment;
            possibleMoves += 1;
        }
        // taking a black if white
        if (piece == Constants.wP) {
            if (board.isBlack(index + increment - 1)) {
                moves[possibleMoves] = index + increment - 1;
                possibleMoves += 1;
            }
            if (board.isBlack(index + increment + 1)) {
                moves[possibleMoves] = index + increment + 1;
                possibleMoves += 1;
            }
        }
        // taking a white if black
        if (piece == Constants.bP) {
            if (board.isWhite(index + increment - 1)) {
                moves[possibleMoves] = index + increment - 1;
                possibleMoves += 1;
            }
            if (board.isWhite(index + increment + 1)) {
                moves[possibleMoves] = index + increment + 1;
                possibleMoves += 1;
            }
        }

        //todo: enpassant

        moves[possibleMoves] = -1;
        return moves;
    }

    private String getBestMove(String playingColor) {
        if (playingColor.equals("black")) {
            return getBestBlackMove(21);
        } else {
            return getBestWhiteMove(21);
        }
    }

    private void initializeEngine() {
        previousMoves = new ArrayList<>();
        board = Board.getInstance();
    }

    public static Engine getInstance() {
        if (instance == null) {
            instance = new Engine();
        }
        return instance;
    }
}
