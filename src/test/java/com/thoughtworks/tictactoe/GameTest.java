package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameTest {

    private PrintStream printStream;
    private Game game;
    private BufferedReader bufferedReader;
    private List<String> moves;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        Board board = mock(Board.class);
        Integer boardSize = 9;
        moves = new ArrayList<String>(Collections.nCopies(boardSize, " "));
        game = new Game(printStream, bufferedReader, board, moves);
    }

    @Test
    public void shouldPromptPlayerWhenGettingInput() {
        game.getInput();
        verify(printStream).println(contains("Enter a number between 1 and 9:"));
    }
    
    @Test
    public void shouldCallBufferReaderWhenGettingInput() throws IOException {
        game.getInput();
        verify(bufferedReader).readLine();
    }

    @Test
    public void shouldSetMoveWhenMakingMove() {
        game.makeMove(3, "X");
        assertTrue(moves.get(3).equals("X"));
    }

    @Test
    public void shouldReturnTrueIfPositionIsEmpty() {
        assertTrue(game.isPositionEmpty(1));
    }

    @Test
    public void shouldReturnFalseIfPositionIsOccupied() {
        moves.set(1, "X");
        assertFalse(game.isPositionEmpty(1));
    }

    @Test
    public void shouldPrintWarningWhenMovingInOccupiedPosition() {
        moves.set(1, "O");
        game.makeMove(1, "X");
        verify(printStream).println("Location already taken, try again.");
    }

    @Test
    public void shouldPrintDrawBoardIsFullWithNoWinner() {
        Collections.replaceAll(moves, " ", "X");
        game.checkBoard();
        verify(printStream).println("Game is a draw");
    }

    @Test
    public void shouldDeclareCorrectWinnerWhenXWins() {
        moves.set(0, "X");
        moves.set(3, "X");
        moves.set(6, "X");
        game.checkBoard();
        verify(printStream).println("Player X wins!");
    }

    @Test
    public void shouldDeclareCorrectWinnerWhenOWins() {
        moves.set(1, "O");
        moves.set(4, "O");
        moves.set(7, "O");
        game.checkBoard();
        verify(printStream).println("Player O wins!");
    }
}