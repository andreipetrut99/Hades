import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        Engine engine = Engine.getInstance();
        Board board = Board.getInstance();

        String command;
        boolean forceMode = false;
        String onMove = "white", mode;
        String playingColor = "black";
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
                    playingColor = "black";
                    onMove = "white";
                    break;
                case "force":
                    forceMode = true;
                    break;
                case "go":
                    forceMode = false;
                    playingColor = onMove;
                    break;
                case "white":
                    onMove = "white";
                    playingColor = "black";
                    break;
                case "black":
                    onMove = "black";
                    playingColor = "white";
                    break;
                case "quit":
                    return;
                case "print":
                    board.printBoard();
                    break;
                case "bishop":
                    engine.getBishopMoves(Constants.wB, 93);
            }

            if ((command.matches("^[a-h]\\d[a-h]\\d") && !forceMode) || command.equals("go")
                    || command.matches("^[a-h]\\d[a-h]\\d" + "q")) {
                String move;
                if (!command.equals("go")) {
                    board.movePiece(command);
                }
                // move = board.getPawnMove(playingColor)
                /*if (move.equals("resign")) {
                    writer.println(move);
                } else {
                    writer.println("move " + move);
                } */
                move = engine.getBestMove(playingColor);
                if (move.equals("resign")) {
                    writer.println(move);
                } else {
                    String move1 = board.castlingMove(move);
                    board.movePiece(move);
                    writer.println("move " + move1);
                }

            } else if (command.matches("^[a-h]\\d[a-h]\\d") && forceMode) {
                if (onMove.equals("white")) {
                    onMove = "black";
                } else {
                    onMove = "white";
                }
                board.movePiece(command);
            }


            writer.flush();
        }
    }
}
