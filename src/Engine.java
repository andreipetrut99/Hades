import java.util.ArrayList;

public class Engine {
    private static Engine instance = null;
    private ArrayList<String> previousMoves;
    private Board board;
    private MoveGenerator moveGenerator;
    private String bestMove;
    private EvaluationBoard evaluationEngine;

    private Engine() {
        initializeEngine();
    }



    public String getBestMove(String playingColor) {
        bestMove = "";
        if (playingColor.equals("black")) {
          getBestBlackMove(0);
        } else {
          getBestWhiteMove(0);
        }
        return bestMove;
    }

    private int getBestWhiteMove(int depth) {
        if (depth == Constants.SEARCH_DEPTH) {
            return evaluationEngine.evaluateBoard(board, false);
        }
        int maximumScore = Integer.MIN_VALUE;

        for (int i = 21; i < 99; i++) {
            int piece = board.getPiece(i);
            if (board.isWhite(i)) {
                int[] availableMoves;
                int k = 0;

                availableMoves = getAvailableMoves(piece, i);
                assert availableMoves != null;
                int nextMove = availableMoves[k];

                while (nextMove != -1) {
                    board.movePiece(i, nextMove);

                    int score = -getBestBlackMove( depth + 1);

                    if (score > maximumScore) {
                        maximumScore = score;
                        if (depth == 0) {
                            bestMove = moveGenerator.getMove(i, nextMove);
                        }
                    }

                    board.movePiece(nextMove, i);
                    nextMove = availableMoves[++k];
                }
            }
        }
        return maximumScore;
    }

    private int getBestBlackMove(int depth) {
        if (depth == Constants.SEARCH_DEPTH) {
            return evaluationEngine.evaluateBoard(board, true);
        }

        int maximumScore = Integer.MIN_VALUE;

        for (int i = 21; i < 99; i++) {
            int piece = board.getPiece(i);
            if (board.isBlack(i)) {
                int[] availableMoves;
                int k = 0;

                availableMoves = getAvailableMoves(piece, i);
                assert availableMoves != null;
                int nextMove = availableMoves[k];

                while (nextMove != -1) {
                    board.movePiece(i, nextMove);

                    int score = -getBestWhiteMove( depth + 1);

                    if (score > maximumScore) {
                        maximumScore = score;
                        if (depth == 0) {
                            bestMove = moveGenerator.getMove(i, nextMove);
                        }
                    }

                    board.movePiece(nextMove, i);
                    nextMove = availableMoves[++k];
                }
            }
        }
        return maximumScore;
    }

    private int[] getAvailableMoves(int piece, int index) {
        if (board.isPawn(index)) {
            return getPawnMoves(piece, index);
        }
        if (board.isKing(index)) {
            return getKingMoves(piece, index);
        }
        if (board.isQueen(index)) {
            return getQueenMoves(piece, index);
        }
        if (board.isKnight(index)) {
            return getKnightMoves(piece, index);
        }
        if (board.isBishop(index)) {
            return getBishopMoves(piece, index);
        }
        if (board.isRoock(index)) {
            return getRoockMoves(piece, index);
        }
        return null;
    }

    private int[] getRoockMoves(int piece, int index) {
        int[] moves = new int[2];
        moves[0] = -1;
        return moves;
    }

    private int[] getBishopMoves(int piece, int index) {
        int[] moves = new int[2];
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
        }
        moves[possibleMoves] = -1;
        //todo: implement for black king
        return moves;
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
        int increment;
        if (piece == Constants.wP) {
            increment = -10;
        } else {
            increment = 10;
        }
        //todo: incepere cu doua casute
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
        evaluationEngine = EvaluationBoard.getInstance();
    }

    public static Engine getInstance() {
        if (instance == null) {
            instance = new Engine();
        }
        return instance;
    }
}
