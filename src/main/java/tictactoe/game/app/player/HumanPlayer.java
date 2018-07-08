package tictactoe.game.app.player;

import tictactoe.game.app.board.Coordinates;
import tictactoe.game.app.service.PlayfieldService;
import tictactoe.game.app.ui.UserInterface;

/**
 * Implementation of a Player
 * Allowed real user to play the game
 */
public class HumanPlayer implements Player {
    private final String name;
    private final Character symbol;
    private final PlayfieldService playfieldService;
    private final UserInterface userInterface;

    public HumanPlayer(String name, char symbol, PlayfieldService playfieldService, UserInterface userInterface) {
        this.name = name;
        this.symbol = symbol;
        this.playfieldService = playfieldService;
        this.userInterface = userInterface;
    }

    public boolean move() {
        final Coordinates coordinates = userInterface.askCoordinates(name);
        return playfieldService.placeSymbol(symbol, coordinates);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Character getSymbol() {
        return symbol;
    }

}
