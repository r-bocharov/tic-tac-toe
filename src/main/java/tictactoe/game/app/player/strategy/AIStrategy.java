package tictactoe.game.app.player.strategy;

import tictactoe.game.app.board.Coordinates;

/**
 * Strategy for AI player to calculate coordinates
 */
public interface AIStrategy {

    /**
     * Calculate coordinates for a move
     * @param symbol AI player's symbol
     * @param board playfiled
     * @return coordinates
     */
    Coordinates calculateCoordinates(char symbol, char[][] board);
}
