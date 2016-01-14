package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private Board board;
    private PrintStream printStream;
    private List<String> moves;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        Integer boardSize = 9;
        moves = new ArrayList<String>(Collections.nCopies(boardSize, " "));
        Collections.fill(moves, " ");
        board = new Board(printStream);
    }

    @Test
    public void shouldWriteBoardOutWhenDrawing() {
        String correctBoard = "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n";
        board.drawBoard(moves);
        verify(printStream).print(correctBoard);
    }

    @Test
    public void shouldPrintBoardWithSymbolsWhenDrawing() {
        String correctBoard = " X |   |   \n" +
                "-----------\n" +
                "   |   | O \n" +
                "-----------\n" +
                "   | X |   \n";
        moves.set(0, "X");
        moves.set(5, "O");
        moves.set(7, "X");

        board.drawBoard(moves);


        verify(printStream).print(correctBoard);
    }
}