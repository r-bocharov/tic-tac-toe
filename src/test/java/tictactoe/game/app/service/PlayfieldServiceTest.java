package tictactoe.game.app.service;

import org.junit.Test;
import org.mockito.Mockito;
import tictactoe.game.app.board.Coordinates;
import tictactoe.game.app.board.Playfield;
import tictactoe.game.utilities.Config;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayfieldServiceTest {

    @Test
    public void symbolSetWhenCoordinatesCorrect() {
        //given
        char symbol = 'V';
        Playfield playfield = mock(Playfield.class);
        PlayfieldService playfieldService = new PlayfieldService(playfield);
        char[][] array = new char[2][2];
        array[0][0] = 'a';
        array[0][1] = 'b';
        array[1][0] = Config.INSTANCE.getEmptySymbol();
        array[1][1] = 'd';

        when(playfield.getBoard()).thenReturn(array);

        //when
        boolean isSymbolPlaced = playfieldService.placeSymbol(symbol, new Coordinates(1, 0));

        //then
        assertTrue(isSymbolPlaced);
        assertTrue(array[1][0] == symbol);
        assertFalse(playfieldService.winnerSymbol().isPresent());
    }

    @Test
    public void symbolNotSetWhenNotAvailableCoordinates() {
        //given
        Playfield playfield = mock(Playfield.class);
        PlayfieldService playfieldService = new PlayfieldService(playfield);
        char[][] array = new char[2][2];
        array[0][0] = 'a';
        array[0][1] = 'b';
        array[1][0] = 'c';
        array[1][1] = 'd';

        when(playfield.getBoard()).thenReturn(array);

        //when
        boolean isSymbolPlaced = playfieldService.placeSymbol('V', new Coordinates(1, 1));

        //then
        assertFalse(isSymbolPlaced);
        assertTrue(array[1][1] == 'd');
        assertFalse(playfieldService.winnerSymbol().isPresent());
    }

    @Test
    public void symbolNotSetWhenCoordinatesNegative() {
        //given
        Playfield playfield = mock(Playfield.class);
        PlayfieldService playfieldService = new PlayfieldService(playfield);
        char[][] array = new char[2][2];
        array[0][0] = 'a';
        array[1][0] = 'c';

        when(playfield.getBoard()).thenReturn(array);

        //when
        boolean isSymbolPlaced = playfieldService.placeSymbol('V', new Coordinates(-3, 1));

        //then
        assertFalse(isSymbolPlaced);
        assertTrue(array[1][0] == 'c');
    }

    @Test
    public void symbolNotSetWhenCoordinateLongerThanArray() {
        //given
        Playfield playfield = mock(Playfield.class);
        PlayfieldService playfieldService = new PlayfieldService(playfield);
        char[][] array = new char[2][2];
        array[0][0] = 'a';
        array[1][0] = 'c';

        when(playfield.getBoard()).thenReturn(array);

        //when
        boolean isSymbolPlaced = playfieldService.placeSymbol('V', new Coordinates(1, 80));

        //then
        assertFalse(isSymbolPlaced);
        assertTrue(array[1][0] == 'c');
    }

    @Test
    public void getBoard() {
        Playfield playfield = mock(Playfield.class);
        PlayfieldService playfieldService = new PlayfieldService(playfield);
        char[][] array = new char[2][2];
        array[0][0] = 'a';
        array[1][0] = 'c';

        when(playfield.getBoard()).thenReturn(array);

        //when
        char[][] board = playfieldService.getBoard();

        //then
        assertTrue(board.length == 2);
        assertArrayEquals(array, board);
    }

    @Test
    public void winnerSymbol() {
        //given
        Playfield realPlayfield = new Playfield(2);
        Playfield playfield = Mockito.spy(realPlayfield);
        PlayfieldService playfieldService = new PlayfieldService(playfield);
        char[][] array = new char[2][2];
        array[0][0] = 'a';
        array[0][1] = 'b';
        array[1][0] = 'a';
        array[1][1] = Config.INSTANCE.getEmptySymbol();

        when(playfield.getBoard()).thenReturn(array);
        when(playfieldService.winnerSymbol()).thenCallRealMethod();

        //when
        playfieldService.placeSymbol('V', new Coordinates(1, 1));

        //then
        verify(playfield).setWinnerSymbol('a');
        assertTrue(playfieldService.winnerSymbol().isPresent());
        assertEquals('a', playfieldService.winnerSymbol().get().charValue());
    }

    @Test
    public void isFull() {
        Playfield playfield = mock(Playfield.class);
        PlayfieldService playfieldService = new PlayfieldService(playfield);
        char[][] array = new char[2][2];
        array[0][0] = 'a';
        array[0][1] = 'b';
        array[1][0] = 'c';
        array[1][1] = 'd';

        when(playfield.getBoard()).thenReturn(array);

        //when
        boolean isFull = playfieldService.isFull();

        //then
        assertTrue(isFull);
    }

    @Test
    public void isNotFull() {
        Playfield playfield = mock(Playfield.class);
        PlayfieldService playfieldService = new PlayfieldService(playfield);
        char[][] array = new char[2][2];
        array[0][0] = 'a';
        array[0][1] = 'b';
        array[1][0] = 'c';
        array[1][1] = Config.INSTANCE.getEmptySymbol();

        when(playfield.getBoard()).thenReturn(array);

        //when
        boolean isFull = playfieldService.isFull();

        //then
        assertFalse(isFull);
    }
}