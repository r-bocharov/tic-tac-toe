package tictactoe.game.utilities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConfigTest {

    @Test
    public void getPlayfieldSize() {
        int playfieldSize = Config.INSTANCE.getPlayfieldSize();
        assertEquals(3, playfieldSize);
    }

    @Test
    public void getPlayer1Symbol() {
        char symbol = Config.INSTANCE.getPlayer1Symbol();
        assertEquals('O', symbol);
    }

    @Test
    public void getPlayer2Symbol() {
        char symbol = Config.INSTANCE.getPlayer2Symbol();
        assertEquals('X', symbol);
    }

    @Test
    public void getAIPlayerSymbol() {
        char symbol = Config.INSTANCE.getAIPlayerSymbol();
        assertEquals('Y', symbol);
    }

    @Test
    public void getAIPlayerName() {
        String name = Config.INSTANCE.getAIPlayerName();
        assertEquals("Computer Player", name);
    }
}