package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameTest {

    private PrintStream printStream;
    private Game game;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        game = new Game(printStream);
    }

    @Test
    public void shouldDisplayBoardWhenGameStarts() {
        String correctBoard =  "  |   |\n" +
                "---------\n" +
                "  |   |\n" +
                "---------\n" +
                "  |   |";
        game.start();
        verify(printStream).println(correctBoard);
    }

    @Test
    public void shouldPromptPlayerWhenGameStarts() {
        game.start();
        verify(printStream).println("Enter a number between 1 and 9:");
    }

}