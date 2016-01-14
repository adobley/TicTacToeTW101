package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<String> moves;
    private PrintStream printStream;
    private String board = "   |   |   \n" +
            "-----------\n" +
            "   |   |   \n" +
            "-----------\n" +
            "   |   |   \n";

    public Board(PrintStream printStream) {
        this.printStream = printStream;
        moves = new ArrayList<String>();
        for (int i = 0; i < 9; i++) {
            moves.add(" ");
        }
    }

    public void drawBoard() {
        printStream.print(board);
    }
}
