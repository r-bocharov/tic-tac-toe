package tictactoe.game.app.board;

import tictactoe.game.utilities.Config;

import java.util.Optional;

/**
 * Contains a play field and a winner
 */
public class Playfield {
    private char[][] board;
    private char winnerSymbol;

    public Playfield(final int playfieldSize) {
        board = new char[playfieldSize][playfieldSize];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Config.INSTANCE.getEmptySymbol();
            }
        }
    }

    /**
     * Returns an array containing all user symbols.
     * Users play on this board
     * @return
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * The symbol of a user who made a win combination
     * @return symbol
     */
    public Optional<Character> getWinnerSymbol() {
        return !(winnerSymbol == Character.MIN_VALUE) ? Optional.of(winnerSymbol) : Optional.empty();
    }

    public void setWinnerSymbol(Character winnerSymbol) {
        this.winnerSymbol = winnerSymbol;
    }

}
