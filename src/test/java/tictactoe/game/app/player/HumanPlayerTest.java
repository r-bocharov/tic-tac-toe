package tictactoe.game.app.player;

import org.junit.Test;
import tictactoe.game.app.board.Coordinates;
import tictactoe.game.app.service.PlayfieldService;
import tictactoe.game.app.ui.ConsoleUserInterface;
import tictactoe.game.app.ui.UserInterface;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HumanPlayerTest {

    @Test
    public void move() {
        //give
        String name = "some-name";
        char symbol = 'V';
        char[][] array = new char[1][1];
        PlayfieldService playfieldService = mock(PlayfieldService.class);
        Coordinates coordinates = new Coordinates(1, 1);
        UserInterface userInterface = mock(ConsoleUserInterface.class);
        when(userInterface.askCoordinates(name)).thenReturn(coordinates);
        when(playfieldService.placeSymbol(symbol, coordinates)).thenReturn(true);
        when(playfieldService.getBoard()).thenReturn(array);
        Player player = new HumanPlayer(name, symbol, playfieldService, userInterface);

        //when
        boolean isMoved = player.move();

        //then
        assertTrue(isMoved);
        verify(playfieldService).placeSymbol(symbol, coordinates);
        verify(userInterface).askCoordinates(name);
    }

    @Test
    public void getName() {
        //give
        String name = "some-name";
        PlayfieldService playfieldService = mock(PlayfieldService.class);
        UserInterface userInterface = mock(ConsoleUserInterface.class);

        Player player = new HumanPlayer(name, 'V', playfieldService, userInterface);

        //when
        String actualName = player.getName();

        //then
        assertEquals(name, actualName);
    }

    @Test
    public void getSymbol() {
        //give
        char symbol = 'V';
        PlayfieldService playfieldService = mock(PlayfieldService.class);
        UserInterface userInterface = mock(ConsoleUserInterface.class);

        Player player = new HumanPlayer("user name", 'V', playfieldService, userInterface);

        //when
        Character actualSymbol = player.getSymbol();

        //then
        assertEquals(symbol, actualSymbol.charValue());
    }
}