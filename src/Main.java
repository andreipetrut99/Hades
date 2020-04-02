import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        EvaluationBoard evaluationBoard = EvaluationBoard.getInstance();
        System.out.println(evaluationBoard.getBishopPoints(21));
        System.out.println(evaluationBoard.getBishopPoints(25));
        System.out.println(evaluationBoard.getKingPoints(33));

        Board board = Board.getInstance();
        String command;
        boolean forceMode = false;
        String onMove = "white", mode;
        String playing = "black";
        writer.flush();
        while (true) {
            command = reader.readLine();
            switch (command) {
                case "xboard":
                    mode = "xboard";
                    writer.println("feature myname=\"Hades 1.0\" sigint=0 done=1");
                    break;
                case "new":
                    board.initializeBoard();
                    forceMode = false;
                    playing = "black";
                    onMove = "white";
                    break;
                case "force":
                    forceMode = true;
                    break;
                case "go":
                    forceMode = false;
                    playing = onMove;
                    break;
                case "white":
                    onMove = "white";
                    playing = "black";
                    break;
                case "black":
                    onMove = "black";
                    playing = "white";
                    break;
                case "quit":
                    return;
                case "print":
                    board.printBoard();
                    break;
            }

            if ((command.matches("^[a-h]\\d[a-h]\\d") && !forceMode) || command.equals("go")) {
                String move;
                if (!command.equals("go")) {
                    board.movePiece(command);
                }
                // move = board.getPawnMove(playing);

                /*if (move.equals("resign")) {
                    writer.println(move);
                } else {
                    writer.println("move " + move);
                } */
            } else if (command.matches("^[a-h]\\d[a-h]\\d") && forceMode) {
                if (onMove.equals("white")) {
                    onMove = "black";
                } else {
                    onMove = "white";
                }
                board.movePiece(command);
            }

            if (command.matches("[a-h]\\d[a-h]\\d[q-r]")) {
                writer.write("resign");
            }

            writer.flush();
        }
    }
}
