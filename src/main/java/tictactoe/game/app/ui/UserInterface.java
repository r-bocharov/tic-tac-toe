package tictactoe.game.app.ui;

import tictactoe.game.app.board.Coordinates;
import tictactoe.game.app.board.Playfield;

public interface UserInterface {

    /**
     * Shows playfield to a user
     * @param playfield object containing all user moves
     */
    void showField(Playfield playfield);

    /**
     * Asks a user to enter coordinates to put a mark on a playfield
     * @param name user name to see a personalized text
     * @return <ROW,COLUMN> coordinates
     * @see Coordinates
     */
    Coordinates askCoordinates(String name);

    /**
     * Asks a user name
     * @param userNumber number to see a personalized text
     * @return name
     */
    String askUserName(int userNumber);

    /**
     * Close used resources
     */
    void freeUsedResources();
}
