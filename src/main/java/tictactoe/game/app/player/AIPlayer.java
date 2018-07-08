package tictactoe.game.app.player;

import tictactoe.game.app.board.Coordinates;
import tictactoe.game.app.player.strategy.AIStrategy;
import tictactoe.game.app.service.PlayfieldService;

/**
 * AI Implementation of a Player
 * Imitate a user behaviour based on a provided strategy
 */
public class AIPlayer implements Player {
    private final String name;
    private final Character symbol;
    private final PlayfieldService playfieldService;
    private final AIStrategy strategy;

    public AIPlayer(String name, char symbol, PlayfieldService playfieldService, AIStrategy strategy) {
        this.name = name;
        this.symbol = symbol;
        this.playfieldService = playfieldService;
        this.strategy = strategy;
    }

    /**
     * Finds next available coordinates
     * @return coordinates
     */
    private Coordinates selectRandomCoordinates() {
        return strategy.calculateCoordinates(symbol, playfieldService.getBoard());
    }

    public boolean move() {
        return playfieldService.placeSymbol(symbol, selectRandomCoordinates());
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
