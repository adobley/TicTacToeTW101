package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Game {

    public static final String board = "  |   |\n" +
            "---------\n" +
            "  |   |\n" +
            "---------\n" +
            "  |   |";
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public Game(PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void start() {
        printStream.println(board);
        printStream.println("Enter a number between 1 and 9:");
        try {
            String input = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
