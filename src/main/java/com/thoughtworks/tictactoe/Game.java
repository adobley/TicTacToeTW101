package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.PrintStream;

public class Game {

    public static final String board = "  |   |\n" +
            "---------\n" +
            "  |   |\n" +
            "---------\n" +
            "  |   |";
    private PrintStream printStream;

    public Game(PrintStream printStream, BufferedReader bufferedReader) {

        this.printStream = printStream;
    }

    public void start() {
        printStream.println(board);
        printStream.println("Enter a number between 1 and 9:");
    }
}
