package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        Board board = new Board(System.out);
        Integer boardSize = 9;
        List<String> moves = new ArrayList<String>(Collections.nCopies(boardSize, " "));
        Game game = new Game(System.out, bufferedReader, board, moves);
        game.start();
    }
}
