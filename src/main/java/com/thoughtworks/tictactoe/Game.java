package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Game {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Board board;
    private List<String> moves;
    private String currentPlayer;
    private Boolean done;

    public Game(PrintStream printStream, BufferedReader bufferedReader,
                Board board, List<String> moves) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.board = board;
        this.moves = moves;
    }

    public void start() {
        currentPlayer = "X";
        done = false;
        gameLoop();
    }

    private void gameLoop() {
        while (!done) {
            board.drawBoard(moves);
            getInput();
        }
    }

    public void getInput() {
        printStream.println(currentPlayer + ", Enter a number between 1 and 9:");
        String input = null;

        try {
            input = bufferedReader.readLine();
        } catch (IOException e) { e.printStackTrace(); }

        if (input != null) {
            int index = Integer.parseInt(input) - 1;
            makeMove(index, currentPlayer);
        }
    }

    public void makeMove(int index, String character) {
        if (isPositionEmpty(index)) {
            moves.set(index, character);
            if (character.equals("X")) currentPlayer = "O";
                else currentPlayer = "X";
        } else {
            printStream.println("Location already taken, try again.");
        }
    }

    public Boolean isPositionEmpty(int index) {
        return moves.get(index).equals(" ");
    }

    public void checkBoard() {
        if (!moves.contains(" ")) {
            printStream.println("Game is a draw");
            done = true;
        }
    }
}
