package tictactoe.game.app.player.strategy;

import org.junit.Test;
import tictactoe.game.app.board.Coordinates;
import tictactoe.game.utilities.Config;

import static org.junit.Assert.assertEquals;

public class RandomStrategyTest {

    @Test
    public void calculateCoordinates() {
        //given
        AIStrategy randomStrategy = new RandomStrategy();
        char symbol = 'V';
        char[][] array = prepareArray();

        //when
        Coordinates coordinates = randomStrategy.calculateCoordinates(symbol, array);
        int horizontal = coordinates.getHorizontal();
        int vertical = coordinates.getVertical();

        //then
        assertEquals(1, horizontal);
        assertEquals(2, vertical);
    }

    private char[][] prepareArray() {
        char[][] arr = new char[3][3];
        arr[0][0] = 'a';
        arr[0][1] = 'b';
        arr[0][2] = 'c';

        arr[1][0] = 'd';
        arr[1][1] = 'e';
        arr[1][2] = Config.INSTANCE.getEmptySymbol();

        arr[2][0] = 'g';
        arr[2][1] = 'h';
        arr[2][2] = 'i';

        return arr;
    }
}