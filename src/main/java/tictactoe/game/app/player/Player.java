package tictactoe.game.app.player;

public interface Player {

    /**
     * Puts a player's symbol on a board
     * @return true if a symbol was placed on a board successfully
     */
    boolean move();
    String getName();
    Character getSymbol();
}
