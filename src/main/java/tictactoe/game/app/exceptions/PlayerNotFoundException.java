package tictactoe.game.app.exceptions;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(String message){
        super(message);
    }
}