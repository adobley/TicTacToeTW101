package com.thoughtworks.tictactoe;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameTest {

    @Test
    public void shouldDisplayBoardWhenGameStarts() {
        PrintStream printStream = mock(PrintStream.class);
        Game game = new Game(printStream);
        String correctBoard = "   |   |\n" +
                "---------\n" +
                "   |   |\n" +
                "---------\n" +
                "   |   |";
        game.start();
        verify(printStream).println(correctBoard);
    }

}