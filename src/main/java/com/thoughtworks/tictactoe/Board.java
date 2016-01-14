package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.List;

public class Board {
    private PrintStream printStream;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void drawBoard(List<String> moves) {
        String board = " " + moves.get(0) + " | "  + moves.get(1) + " | " + moves.get(2) + " \n" +
                "-----------\n" +
                " " + moves.get(3) + " | " + moves.get(4) + " | " + moves.get(5) + " \n" +
                "-----------\n" +
                " " + moves.get(6) + " | " + moves.get(7) + " | " + moves.get(8) + " \n";

        printStream.print(board);
    }
}
