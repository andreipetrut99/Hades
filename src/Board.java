import java.util.ArrayList;
import java.util.List;

public class Board {
    private static Board instance = null;
    private List<Integer> board;

    private Board() {
        board = new ArrayList<Integer>(120);
    }
    
    
    public void initializeBoard() {
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

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
            return instance;
        }
        return instance;
    }

    public void printBoard() {
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
                    System.out.print(" bK");
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

}