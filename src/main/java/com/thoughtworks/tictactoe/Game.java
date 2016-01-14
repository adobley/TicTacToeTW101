package com.thoughtworks.tictactoe;

import java.io.PrintStream;

public class Game {

    public static final String board = "   |   |\n" +
            "---------\n" +
            "   |   |\n" +
            "---------\n" +
            "   |   |";
    private PrintStream printStream;

    public Game(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void start() {
        printStream.println(board);
    }
}
