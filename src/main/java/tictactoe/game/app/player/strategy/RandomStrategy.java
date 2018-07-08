package tictactoe.game.app.player.strategy;

import tictactoe.game.app.board.Coordinates;
import tictactoe.game.utilities.Config;

/**
 * Implementation of a AI strategy
 * Select next available coordinates
 */
public class RandomStrategy implements AIStrategy {

    @Override
    public Coordinates calculateCoordinates(char symbol, char[][] board) {
        int horizontal = 0;
        int vertical = 0;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == Config.INSTANCE.getEmptySymbol()) {
                    horizontal = row;
                    vertical = col;
                }
            }
        }
        return new Coordinates(horizontal,vertical);
    }
}
