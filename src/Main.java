import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Writer writer = new PrintWriter(System.out);

        Board board = Board.getInstance();
        String command;
        boolean forceMode = false;

        while (true) {
            command = reader.readLine();

            if (command.equals("xboard")) {
                board.initializeBoard();
                writer.write("feature myname=\"Miracle Chess 0.9\" done=1");
            }

            if (command.equals("new")) {
                board.initializeBoard();
            }

            if (command.equals("quit")) {
                break;
            }

            if (command.equals("force")) {
                forceMode = true;
            }


        }
    }
}
