import java.util.ArrayList;

public class Engine {
    private static Engine instance = null;
    private ArrayList<String> previousMoves;
    private Board board;
    private MoveGenerator moveGenerator;
    private String bestMove;

    private Engine() {
        initializeEngine();
    }



    private String getBestMove(String playingColor) {
        bestMove = "";
        if (playingColor.equals("black")) {
          //  return getBestBlackMove(21, 0);
        } else {
          //  return getBestWhiteMove(21, 1);
        }
    }

    private int getBestWhiteMove(int minIndex, int depth) {
        if (depth == Constants.SEARCH_DEPTH) {
            return evaluateBoard();
        }
        int maximumScore = Integer.MIN_VALUE;

        for (int i = minIndex; i < 99; i++) {
            int piece = board.getPiece(i);
            if (board.isWhite(i)) {
                int[] availableMoves;
                int k = 0;

                availableMoves = getAvailableMoves(piece, i);
                assert availableMoves != null;
                int nextMove = availableMoves[k];

                while (nextMove != -1) {
                    board.movePiece(i, nextMove);

                    int score = -getBestBlackMove(21, depth + 1);

                    if (score > maximumScore) {
                        maximumScore = score;
                        if (depth == 0) {
                            bestMove = moveGenerator.getMove(i, nextMove);
                        }
                    }

                    board.movePiece(nextMove, i);
                }
            }
        }
        return maximumScore;
    }

    private int getBestBlackMove(int minIndex, int depth) {

    }

    private int[] getAvailableMoves(int piece, int index) {
        if ((piece == Constants.wP) || (piece == Constants.bP)) {
            return getPawnMoves(piece, index);
        }
        if ((piece == Constants.wK) || (piece == Constants.bK)) {
            return getKingMoves(piece, index);
        }
        if ((piece == Constants.wQ) || (piece == Constants.bQ)) {
            return getQueenMoves(piece, index);
        }
        if ((piece == Constants.wN) || (piece == Constants.bN)) {
            return getKnightMoves(piece, index);
        }
        if ((piece == Constants.wB) || (piece == Constants.bB)) {
            return getBishopMoves(piece, index);
        }
        if ((piece == Constants.wR) || (piece == Constants.bR)) {
            return getRoockMoves(piece, index);
        }
        return null;
    }

    private int[] getRoockMoves(int piece, int index) {
        int[] moves = new int[1];
        moves[0] = -1;
        return moves;
    }

    private int[] getBishopMoves(int piece, int index) {
        int[] moves = new int[1];
        moves[0] = -1;
        return moves;
    }

    private int[] getKnightMoves(int piece, int index) {
        int[] moves = new int[5];
        int possibleMoves = 0;
        int increment = 20;

        if (piece == Constants.wK) {
            if (board.isBlack(index - increment - 1)
                    || board.isEmpty(index - increment - 1)) {
                moves[possibleMoves] = index - increment - 1;
                possibleMoves += 1;
            }
            if (board.isBlack(index - increment + 1)
                    || board.isEmpty(index - increment + 1)) {
                moves[possibleMoves] = index - increment + 1;
                possibleMoves += 1;
            }
            if (board.isBlack(index + increment - 1)
                    || board.isEmpty(index + increment - 1)) {
                moves[possibleMoves] = index + increment - 1;
                possibleMoves += 1;
            }
            if (board.isBlack(index + increment + 1)
                    || board.isEmpty(index + increment + 1)) {
                moves[possibleMoves] = index + increment + 1;
                possibleMoves += 1;
            }
            moves[possibleMoves] = -1;
        }
    }

    private int[] getQueenMoves(int piece, int index) {
        int[] moves = new int[1];
        moves[0] = -1;
        return moves;
    }

    private int[] getKingMoves(int piece, int index) {
        int[] moves = new int[9];
        int possibleMoves = 0;
        int increment = 10;
        if (piece == Constants.wK) {
            if (board.isBlack(index - increment - 1)
                    || board.isEmpty(index - increment - 1)) {
                moves[possibleMoves] = index - increment - 1;
                possibleMoves += 1;
            }
            if (board.isBlack(index - increment)
                    || board.isEmpty(index - increment)) {
                moves[possibleMoves] = index - increment;
                possibleMoves += 1;
            }
            if (board.isBlack(index - increment + 1)
                    || board.isEmpty(index - increment + 1)) {
                moves[possibleMoves] = index - increment + 1;
                possibleMoves += 1;
            }
            if (board.isBlack(index - 1)
                    || board.isEmpty(index - 1)) {
                moves[possibleMoves] = index - 1;
                possibleMoves += 1;
            }
            if (board.isBlack(index + 1)
                    || board.isEmpty(index + 1)) {
                moves[possibleMoves] = index + 1;
                possibleMoves += 1;
            }
            if (board.isBlack(index + increment - 1)
                    || board.isEmpty(index + increment - 1)) {
                moves[possibleMoves] = index + increment - 1;
                possibleMoves += 1;
            }
            if (board.isBlack(index + increment)
                    || board.isEmpty(index + increment)) {
                moves[possibleMoves] = index + increment;
                possibleMoves += 1;
            }
            if (board.isBlack(index + increment + 1)
                    || board.isEmpty(index + increment + 1)) {
                moves[possibleMoves] = index + increment + 1;
                possibleMoves += 1;
            }
        } else {
            if (board.isWhite(index - increment - 1)
                    || board.isEmpty(index - increment - 1)) {
                moves[possibleMoves] = index - increment - 1;
                possibleMoves += 1;
            }
            if (board.isWhite(index - increment)
                    || board.isEmpty(index - increment)) {
                moves[possibleMoves] = index - increment;
                possibleMoves += 1;
            }
            if (board.isWhite(index - increment + 1)
                    || board.isEmpty(index - increment + 1)) {
                moves[possibleMoves] = index - increment + 1;
                possibleMoves += 1;
            }
            if (board.isWhite(index - 1)
                    || board.isEmpty(index - 1)) {
                moves[possibleMoves] = index - 1;
                possibleMoves += 1;
            }
            if (board.isWhite(index + 1)
                    || board.isEmpty(index + 1)) {
                moves[possibleMoves] = index + 1;
                possibleMoves += 1;
            }
            if (board.isWhite(index + increment - 1)
                    || board.isEmpty(index + increment - 1)) {
                moves[possibleMoves] = index + increment - 1;
                possibleMoves += 1;
            }
            if (board.isWhite(index + increment)
                    || board.isEmpty(index + increment)) {
                moves[possibleMoves] = index + increment;
                possibleMoves += 1;
            }
            if (board.isWhite(index + increment + 1)
                    || board.isEmpty(index + increment + 1)) {
                moves[possibleMoves] = index + increment + 1;
                possibleMoves += 1;
            }
        }
        moves[possibleMoves] = -1;
        return moves;
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

    private void initializeEngine() {
        previousMoves = new ArrayList<>();
        board = Board.getInstance();
        moveGenerator = MoveGenerator.getInstance();
    }

    public static Engine getInstance() {
        if (instance == null) {
            instance = new Engine();
        }
        return instance;
    }
}
