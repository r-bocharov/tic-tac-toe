package tictactoe.game.app.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tictactoe.game.app.exceptions.PlayerNotFoundException;
import tictactoe.game.app.player.Player;
import tictactoe.game.app.player.strategy.AIStrategy;
import tictactoe.game.app.ui.ConsoleUserInterface;
import tictactoe.game.app.ui.UserInterface;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class PlayerServiceTest {

    @Rule
    public ExpectedException exceptionVerifier = ExpectedException.none();

    @Test
    public void nextPlayer() {
        //given
        PlayerService playerService = preparePlayerService();

        //when
        Player player1 = playerService.nextPlayer();
        Player player2 = playerService.nextPlayer();
        Player aiPlayer = playerService.nextPlayer();
        Player player1Again = playerService.nextPlayer();
        Player player2Again = playerService.nextPlayer();
        Player aiPlayerAgain = playerService.nextPlayer();

        //then
        assertEquals(player1, player1Again);
        assertEquals(player2, player2Again);
        assertEquals(aiPlayer, aiPlayerAgain);
    }

    @Test
    public void getPlayerBySymbol() {
        //given
        PlayerService playerService = preparePlayerService();
        Character symbol = 'O';

        //when
        Player player = playerService.getPlayerBySymbol(symbol);

        //then
        assertEquals(player.getSymbol(), symbol);
    }

    @Test
    public void getPlayerBySymbolNotFound() {
        PlayerService playerService = preparePlayerService();
        Character nonExistentSymbol = 'V';
        exceptionVerifier.expect(PlayerNotFoundException.class);

        playerService.getPlayerBySymbol(nonExistentSymbol);
    }

    private PlayerService preparePlayerService() {
        PlayfieldService playfieldService = mock(PlayfieldService.class);
        AIStrategy strategy = mock(AIStrategy.class);
        UserInterface userInterface = mock(ConsoleUserInterface.class);
        return new PlayerService("Player1", "Player2", playfieldService, strategy, userInterface);
    }
}