package tictactoe.game.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Simple config to read properties
 */
public enum Config {
    INSTANCE;

    private final String DEFAULT_PLAYFIELD_SIZE = "3";
    private final String DEFAULT_PLAYER1_SYMBOL = "O";
    private final String DEFAULT_PLAYER2_SYMBOL = "X";
    private final String DEFAULT_AI_PLAYER_SYMBOL = "Y";
    private final String DEFAULT_AI_PLAYER_NAME = "Computer Player";
    private final String DEFAULT_EMPTY_SYMBOL = "-";
    private static Properties properties;

    static {
        properties = new Properties();

        try (InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties")){
            properties.load(stream);
        } catch (IOException ex) {
            System.err.println("Couldn't read properties file!");
        }
    }

    public int getPlayfieldSize() {
        final String size = properties.getProperty("playfield.raw.size", DEFAULT_PLAYFIELD_SIZE);
        return Integer.parseInt(size);
    }

    public Character getPlayer1Symbol() {
        final String symbol = properties.getProperty("player1.symbol", DEFAULT_PLAYER1_SYMBOL);
        return symbol.charAt(0);
    }

    public Character getPlayer2Symbol() {
        final String symbol = properties.getProperty("player2.symbol", DEFAULT_PLAYER2_SYMBOL);
        return symbol.charAt(0);
    }

    public Character getAIPlayerSymbol() {
        final String symbol = properties.getProperty("ai-payer.symbol", DEFAULT_AI_PLAYER_SYMBOL);
        return symbol.charAt(0);
    }

    public String getAIPlayerName() {
        return properties.getProperty("ai-player.name", DEFAULT_AI_PLAYER_NAME);
    }

    public char getEmptySymbol() {
        return properties.getProperty("playfield.empty.symbol", DEFAULT_EMPTY_SYMBOL).charAt(0);
    }
}
