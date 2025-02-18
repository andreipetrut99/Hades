import java.util.ArrayList;
import java.util.List;

class Board {
    private static Board instance = null;
    private List<Integer> board;
    private boolean isBlackOnTop;
    private StateVariables stateVariables;

    private Board() {
        board = new ArrayList<Integer>(120);
        stateVariables = new StateVariables();
    }

    public List<Integer> getBoard() {
        return board;
    }

    public void setBoard(List<Integer> b) {
        board = b;
    }

    void initializeBoard() {
        board.clear();
        // initialize all places with 0 - free
        for (int i = 0; i < 120; i++) {
            board.add(i, Constants.E);
        }

        // putting black pieces on board
        board.set(21, Constants.bR);
        board.set(28, Constants.bR);
        board.set(22, Constants.bN);
        board.set(27, Constants.bN);
        board.set(23, Constants.bB);
        board.set(26, Constants.bB);
        board.set(24, Constants.bQ);
        board.set(25, Constants.bK);

        for (int i = 31; i < 39; i++) {
            board.set(i, Constants.bP);
        }

        // putting white pieces on board

        for (int i = 81; i < 89 ; i++) {
            board.set(i, Constants.wP);
        }
        board.set(91, Constants.wR);
        board.set(98, Constants.wR);
        board.set(92, Constants.wN);
        board.set(97, Constants.wN);
        board.set(93, Constants.wB);
        board.set(96, Constants.wB);
        board.set(94, Constants.wQ);
        board.set(95, Constants.wK);

        // setting margins
        for (int i = 0; i < 20; i++) {
            board.set(i, -1);
        }

        for (int i = 100; i < 120; i++) {
            board.set(i, -1);
        }

        for (int i = 2; i < 10; i++) {
            board.set(i * 10, -1);
            board.set(i * 10 + 9, -1);
        }
    }

    static Board getInstance() {
        if (instance == null) {
            instance = new Board();
            return instance;
        }
        return instance;
    }

    void printBoard() {
        int k = 0;
        for (int i = 21; i < 99; i++) {
            switch (board.get(i)) {
                case Constants.E:
                    System.out.print(" -- ");
                    break;
                case Constants.wP:
                    System.out.print(" wP ");
                    break;
                case Constants.bP:
                    System.out.print(" bP ");
                    break;
                case Constants.wR:
                    System.out.print(" wR ");
                    break;
                case Constants.bR:
                    System.out.print(" bR ");
                    break;
                case Constants.wB:
                    System.out.print(" wB ");
                    break;
                case Constants.bB:
                    System.out.print(" bB ");
                    break;
                case Constants.wN:
                    System.out.print(" wN ");
                    break;
                case Constants.bN:
                    System.out.print(" bN ");
                    break;
                case Constants.wQ:
                    System.out.print(" wQ ");
                    break;
                case Constants.bQ:
                    System.out.print(" bQ ");
                    break;
                case Constants.wK:
                    System.out.print(" wK ");
                    break;
                case Constants.bK:
                    System.out.print(" bK ");
                    break;
            }
            k++;
            if ((k + 2) % 10 == 0) {
                k = 0;
                i += 2;
                System.out.println("");
            }
        }
    }

    public boolean isKingsFirstMove(boolean isBlack) {
        return stateVariables.isKingsFirstMove(isBlack);
    }

    public void setKingsFirstMove(boolean kingsFirstMove, boolean isBlack) {
        stateVariables.setKingsFirstMove(kingsFirstMove, isBlack);
    }

    public boolean isRoocksFirstMove(boolean isBlack, boolean isLeft) {
        return stateVariables.isRoocksFirstMove(isBlack, isLeft);
    }

    public void setRoocksFirstMove(boolean roocksFirstMove, boolean isBlack, boolean isLeft) {
       stateVariables.setRoocksFirstMove(roocksFirstMove, isBlack, isLeft);
    }

    String castlingMove(String move) {
        try {
            int char1 = Integer.parseInt(String.valueOf(move.charAt(1)));
            int char3 = Integer.parseInt(String.valueOf(move.charAt(3)));
            int current = 20 + (8 - char1) * 10 + (move.charAt(0) - 96);
            int next = (char3 - char1) * 10 - (move.charAt(2) - move.charAt(0));
            next = current - next;

            if (isKing(current) && isRoock(next)) {
                if (current < next) {
                   next -= 1;
                } else {
                    next +=1;
                }
                MoveGenerator mv = MoveGenerator.getInstance();
                move = mv.getMove(current, next);
            }

            return move;

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(move);
            e.printStackTrace();
        }
        return null;
    }

    void movePiece(String move) {
        try {
            int current, next;
            int char1 = Integer.parseInt(String.valueOf(move.charAt(1)));
            int char3 = Integer.parseInt(String.valueOf(move.charAt(3)));
            current = 20 + (8 - char1) * 10 + (move.charAt(0) - 96);
            next = (char3 - char1) * 10 - (move.charAt(2) - move.charAt(0));
            next = current - next;


            movePiece(current, next);
//            board.set(next, board.get(current));
//            if (move.matches("^[a-h]\\d[a-h]\\d" + "q")) {
//                if (isWhite(current)) {
//                    board.set(next, Constants.wQ);
//                } else {
//                    board.set(next, Constants.bQ);
//                }
//            }
//            board.set(current, Constants.E);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(move);
            e.printStackTrace();
        }
    }

    void movePiece(int current, int next) {
        if (isKing(current) && isRoock(next)) {
            if (current < next) {
                board.set(next - 1, board.get(current));
                board.set(current, Constants.E);
                board.set(next - 2, board.get(next));
                board.set(next, Constants.E);
            } else {
                board.set(next + 1, board.get(current));
                board.set(current, Constants.E);
                board.set(next + 2, board.get(next));
                board.set(next, Constants.E);
            }
            return;
        }

        board.set(next, board.get(current));
        if (board.get(current) == Constants.wP && next < 29) {
            board.set(next, Constants.wQ);
        } else if (board.get(current) == Constants.bP && next > 90) {
            board.set(next, Constants.bQ);
        }

        board.set(current, Constants.E);
    }

    void setPiece(int index, int piece) {
        board.set(index, piece);
    }

    void moveBack(int current, int next) {
        int aux = next;
        board.set(next, board.get(current));
        board.set(current, board.get(aux));
    }

   public int getPiece(int index) {
       return board.get(index);
   }

    public boolean isBlackOnTop() {
        return isBlackOnTop;
    }

    public void setBlackOnTop(boolean blackOnTop) {
        isBlackOnTop = blackOnTop;
    }

   public boolean isWhite(int index) {
       return board.get(index) > 0 && board.get(index) < 7;
   }

   public boolean isEmpty(int index) {
       return board.get(index) == Constants.E;
   }

   public boolean isBlack(int index) {
       return board.get(index) > 6 && board.get(index) < 13;
   }

   public boolean isPawn(int index) {
       return (board.get(index) == Constants.wP) || (board.get(index) == Constants.bP);
   }

    public boolean isRoock(int index) {
        return (board.get(index) == Constants.wR) || (board.get(index) == Constants.bR);
    }

    public boolean isBishop(int index) {
        return (board.get(index) == Constants.wB) || (board.get(index) == Constants.bB);
    }

    public boolean isKnight(int index) {
        return (board.get(index) == Constants.wN) || (board.get(index) == Constants.bN);
    }

    public boolean isQueen(int index) {
        return (board.get(index) == Constants.wQ) || (board.get(index) == Constants.bQ);
    }

    public boolean isKing(int index) {
        return (board.get(index) == Constants.wK) || (board.get(index) == Constants.bK);
    }

    public StateVariables getStateVariables() {
        return stateVariables;
    }

    public void setStateVariables(StateVariables stateVariables) {
        this.stateVariables = stateVariables;
    }
}
