package tictactoe.game.utilities;

import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ArrayUtilsTest {

    @Test
    public void flatArray() {
        //given
        char item1 = 'a';
        char item2 = 'b';
        char item3 = 'c';
        char item4 = 'd';
        char[][] array = new char[2][2];
        array[0][0] = item1;
        array[0][1] = item2;
        array[1][0] = item3;
        array[1][1] = item4;

        //when
        char[] flatArray = ArrayUtils.flatArray(array);

        //then
        assertEquals(4, flatArray.length);
        assertEquals(item1, flatArray[0]);
        assertEquals(item2, flatArray[1]);
        assertEquals(item3, flatArray[2]);
        assertEquals(item4, flatArray[3]);
    }

    @Test
    public void sameSymbolHorizontally() {
        //given
        char item1 = 'b';
        char item2 = 'b';
        char item3 = 'd';
        char item4 = 'e';
        char[][] array = new char[2][2];
        array[0][0] = item1;
        array[0][1] = item2;
        array[1][0] = item3;
        array[1][1] = item4;

        //when
        Optional<Character> symbol = ArrayUtils.sameSymbolHorizontally(array);

        //then
        assertTrue(symbol.isPresent());
        assertEquals(item1, symbol.get().charValue());
    }

    @Test
    public void sameSymbolHorizontallyNotFound() {
        //given
        char item1 = 'a';
        char item2 = 'c';
        char item3 = 'a';
        char item4 = 'd';
        char[][] array = new char[2][2];
        array[0][0] = item1;
        array[0][1] = item2;
        array[1][0] = item3;
        array[1][1] = item4;

        //when
        Optional<Character> symbol = ArrayUtils.sameSymbolHorizontally(array);

        //then
        assertFalse(symbol.isPresent());
    }

    @Test
    public void sameSymbolVertically() {
        //given
        char item1 = 'a';
        char item2 = 'b';
        char item3 = 'a';
        char item4 = 'd';
        char[][] array = new char[2][2];
        array[0][0] = item1;
        array[0][1] = item2;
        array[1][0] = item3;
        array[1][1] = item4;

        //when
        Optional<Character> symbol = ArrayUtils.sameSymbolVertically(array);

        //then
        assertTrue(symbol.isPresent());
        assertEquals(item1, symbol.get().charValue());
    }

    @Test
    public void sameSymbolVerticallyNotFound() {
        //given
        char item1 = 'a';
        char item2 = 'b';
        char item3 = 'c';
        char item4 = 'd';
        char[][] array = new char[2][2];
        array[0][0] = item1;
        array[0][1] = item2;
        array[1][0] = item3;
        array[1][1] = item4;

        //when
        Optional<Character> symbol = ArrayUtils.sameSymbolVertically(array);

        //then
        assertFalse(symbol.isPresent());
    }

    @Test
    public void sameSymbolDiagonally() {
        //given
        char targetSymbol = 'a';
        char[][] array = new char[3][3];
        array[0][0] = targetSymbol;
        array[0][1] = 'b';
        array[0][2] = 'c';
        array[1][0] = 'd';
        array[1][1] = targetSymbol;
        array[1][2] = 'f';
        array[2][0] = 'g';
        array[2][1] = 'h';
        array[2][2] = targetSymbol;

        //when
        Optional<Character> symbol = ArrayUtils.sameSymbolDiagonally(array);

        //then
        assertTrue(symbol.isPresent());
        assertEquals(targetSymbol, symbol.get().charValue());
    }

    @Test
    public void sameSymbolDiagonallyNotFound() {
        //given
        char[][] array = new char[3][3];
        array[0][0] = 'a';
        array[0][1] = 'b';
        array[0][2] = 'c';
        array[1][0] = 'd';
        array[1][1] = 'e';
        array[1][2] = 'f';
        array[2][0] = 'g';
        array[2][1] = 'h';
        array[2][2] = 'i';

        //when
        Optional<Character> symbol = ArrayUtils.sameSymbolDiagonally(array);

        //then
        assertFalse(symbol.isPresent());
    }
}