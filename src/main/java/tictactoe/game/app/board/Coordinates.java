package tictactoe.game.app.board;

/**
 * Coordinates for placing a symbol on a playfield
 * Format: Horizontal, Vertical.
 * Example 2,3
 */
public class Coordinates {
    private final Integer horizontal;
    private final Integer vertical;

    public Coordinates(final Integer horizontal, final Integer vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public Integer getHorizontal() {
        return horizontal;
    }

    public Integer getVertical() {
        return vertical;
    }
}