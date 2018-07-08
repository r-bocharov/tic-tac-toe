package tictactoe.game.app.service;

import tictactoe.game.app.board.Coordinates;
import tictactoe.game.app.board.Playfield;
import tictactoe.game.utilities.ArrayUtils;
import tictactoe.game.utilities.Config;

import java.util.Arrays;
import java.util.Optional;

public class PlayfieldService {
    private final Playfield playfield;

    public PlayfieldService(final Playfield playfield) {
        this.playfield = playfield;
    }

    /**
     * Place symbol to specified coordinates
     * @param symbol player's symbol
     * @param coordinates
     * @return true if a symbol was placed on a board successfully
     */
    public boolean placeSymbol(Character symbol, Coordinates coordinates) {
        char[][] board = playfield.getBoard();
        int horizontal = coordinates.getHorizontal();
        int vertical = coordinates.getVertical();

        if (horizontal < 0 || vertical < 0) {
            return false;
        }

        if ((board.length > vertical) && (board[vertical].length > horizontal)) {
            if (board[horizontal][vertical] == Config.INSTANCE.getEmptySymbol()) {
                board[horizontal][vertical] = symbol;
                calculateWinner(board);
                return true;
            }
        }

        return false;
    }

    /**
     * Checks a winner and itf it's found adds it on a board
     * @param board
     */
    private void calculateWinner(char[][] board) {
        final Optional<Character> symbolHorizontally = ArrayUtils.sameSymbolHorizontally(board);
        final Optional<Character> symbolVertically = ArrayUtils.sameSymbolVertically(board);
        final Optional<Character> symbolDiagonally = ArrayUtils.sameSymbolDiagonally(board);

        if (symbolHorizontally.isPresent()) {
            playfield.setWinnerSymbol(symbolHorizontally.get());
        } else if (symbolVertically.isPresent()) {
            playfield.setWinnerSymbol(symbolVertically.get());
        } else if (symbolDiagonally.isPresent()) {
            playfield.setWinnerSymbol(symbolDiagonally.get());
        }
    }

    public Optional<Character> winnerSymbol() {
        return playfield.getWinnerSymbol();
    }

    public char[][] getBoard() {
        return playfield.getBoard();
    }

    /**
     * Checks if there are available cells in a board
     * @return
     */
    public boolean isFull() {
        char[] array = ArrayUtils.flatArray(playfield.getBoard());
        Arrays.sort(array);
        return Arrays.binarySearch(array, Config.INSTANCE.getEmptySymbol()) < 0;
    }
}
