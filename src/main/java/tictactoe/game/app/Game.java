package tictactoe.game.app;

import tictactoe.game.app.board.Playfield;
import tictactoe.game.app.player.Player;
import tictactoe.game.app.player.strategy.AIStrategy;
import tictactoe.game.app.player.strategy.RandomStrategy;
import tictactoe.game.app.service.PlayerService;
import tictactoe.game.app.service.PlayfieldService;
import tictactoe.game.app.ui.ConsoleUserInterface;
import tictactoe.game.app.ui.UserInterface;
import tictactoe.game.utilities.Config;

/**
 * Main logic of the Tic-Tac-Toe game.
 */
public class Game {

    private Playfield playfield;
    private Config config;
    private UserInterface userInterface;
    private PlayfieldService playfieldService;
    private PlayerService playerService;
    private AIStrategy strategy;

    public Game() {
        this.config = Config.INSTANCE;

        final int fieldSize = config.getPlayfieldSize();
        if (fieldSize < 3 || fieldSize > 10) {
            throw new IllegalArgumentException("Allowed playfield size value is between 3 and 10");
        }

        this.playfield = new Playfield(fieldSize);
        this.playfieldService = new PlayfieldService(playfield);
        this.strategy = new RandomStrategy();
        this.userInterface = new ConsoleUserInterface();
    }

    public void start() {
        System.out.println("Welcome to Tic-Tac-Toe 2.0 !");

        final String player1Name = userInterface.askUserName(1);
        final String player2Name = userInterface.askUserName(2);
        playerService = new PlayerService(player1Name, player2Name, playfieldService, strategy, userInterface);

        while (!playfieldService.winnerSymbol().isPresent() && !playfieldService.isFull()) {
            Player currentPlayer = playerService.nextPlayer();
            boolean isPlaced = currentPlayer.move();

            while (!isPlaced) {
                System.out.println("Can't put the mark at the specified cell. Please select another cell");
                isPlaced = currentPlayer.move();
            }

            userInterface.showField(playfield);
        }

        System.out.println("Game is finished.");
        if (playfieldService.winnerSymbol().isPresent()) {
            System.out.println(String.format("The winner is '%s'",
                    playerService.getPlayerBySymbol(playfieldService.winnerSymbol().get()).getName()));
        } else {
            System.out.println("It's a tie!");
        }

        userInterface.freeUsedResources();
    }

}
