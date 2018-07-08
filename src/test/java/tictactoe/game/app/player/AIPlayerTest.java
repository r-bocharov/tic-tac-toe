package tictactoe.game.app.player;

import org.junit.Test;
import tictactoe.game.app.board.Coordinates;
import tictactoe.game.app.player.strategy.AIStrategy;
import tictactoe.game.app.service.PlayfieldService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AIPlayerTest {

    @Test
    public void move() {
        //give
        String name = "some-name";
        char symbol = 'V';
        char[][] array = new char[1][1];
        PlayfieldService playfieldService = mock(PlayfieldService.class);
        AIStrategy strategy = mock(AIStrategy.class);
        Coordinates coordinates = new Coordinates(1, 1);
        when(strategy.calculateCoordinates(symbol, array)).thenReturn(coordinates);
        when(playfieldService.placeSymbol(symbol, coordinates)).thenReturn(true);
        when(playfieldService.getBoard()).thenReturn(array);

        Player aiPlayer = new AIPlayer(name, symbol, playfieldService, strategy);

        //when
        boolean isMoved = aiPlayer.move();

        //then
        assertTrue(isMoved);
        verify(playfieldService).placeSymbol(symbol, coordinates);
        verify(strategy).calculateCoordinates(symbol, array);
    }

    @Test
    public void getName() {
        //give
        String name = "some-name";
        PlayfieldService playfieldService = mock(PlayfieldService.class);
        AIStrategy strategy = mock(AIStrategy.class);

        Player aiPlayer = new AIPlayer(name, 'V', playfieldService, strategy);

        //when
        String actualName = aiPlayer.getName();

        //then
        assertEquals(name, actualName);
    }

    @Test
    public void getSymbol() {
        //give
        char symbol = 'V';
        PlayfieldService playfieldService = mock(PlayfieldService.class);
        AIStrategy strategy = mock(AIStrategy.class);

        Player aiPlayer = new AIPlayer("name", symbol, playfieldService, strategy);

        //when
        Character actualSymbol = aiPlayer.getSymbol();

        //then
        assertEquals(symbol, actualSymbol.charValue());
    }
}