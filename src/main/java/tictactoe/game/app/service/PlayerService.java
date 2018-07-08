package tictactoe.game.app.service;

import tictactoe.game.app.exceptions.PlayerNotFoundException;
import tictactoe.game.app.player.AIPlayer;
import tictactoe.game.app.player.HumanPlayer;
import tictactoe.game.app.player.Player;
import tictactoe.game.app.player.strategy.AIStrategy;
import tictactoe.game.app.ui.UserInterface;
import tictactoe.game.utilities.Config;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Contains logic for players
 * @see Player
 */
public class PlayerService {
    private Queue<Player> players = new LinkedList<>();
    private Config config = Config.INSTANCE;

    public PlayerService(String player1Name, String player2Name, PlayfieldService playfieldService, AIStrategy strategy, UserInterface userInterface) {
        Player player1 = new HumanPlayer(player1Name, config.getPlayer1Symbol(), playfieldService, userInterface);
        Player player2 = new HumanPlayer(player2Name, config.getPlayer2Symbol(), playfieldService, userInterface);
        Player aiPlayer = new AIPlayer(config.getAIPlayerName(), config.getAIPlayerSymbol(), playfieldService, strategy);

        List<Player> tempPlayers = Arrays.asList(player1, player2, aiPlayer);
        Collections.shuffle(tempPlayers);
        tempPlayers.stream().forEach(players::offer);
    }

    public Player nextPlayer() {
        final Player currentPlayer = players.poll();
        players.offer(currentPlayer);
        return currentPlayer;
    }

    public Player getPlayerBySymbol(Character symbol) {
        return players.stream().filter(player -> player.getSymbol().equals(symbol))
                .findAny()
                .orElseThrow(() -> new PlayerNotFoundException(String.format("Player is not found for symbol: ", symbol)));
    }
}
