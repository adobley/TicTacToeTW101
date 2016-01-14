package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameTest {

    private PrintStream printStream;
    private Game game;
    private BufferedReader bufferedReader;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        game = new Game(printStream, bufferedReader);
    }

    @Test
    public void shouldDisplayBoardWhenGameStarts() {
        String correctBoard =  "  |   |\n" +
                "---------\n" +
                "  |   |\n" +
                "---------\n" +
                "  |   |";
        game.drawBoard();
        verify(printStream).println(correctBoard);
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