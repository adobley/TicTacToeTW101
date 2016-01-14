package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameTest {

    private PrintStream printStream;
    private Game game;
    private BufferedReader bufferedReader;
    private Board board;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        board = mock(Board.class);
        game = new Game(printStream, bufferedReader, board);
    }

    @Test
    public void shouldPrintEmptyBoardWhenNoMoves() {
    }

    @Test
    public void shouldPromptPlayerWhenGameStarts() {
        game.start();
        verify(printStream).println("Enter a number between 1 and 9:");
    }
    
    @Test
    public void shouldCallBufferReaderWhenGettingInput() throws IOException {
        game.start();
        verify(bufferedReader).readLine();
    }

}