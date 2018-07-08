package tictactoe.game.app.ui;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import tictactoe.game.app.board.Coordinates;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class ConsoleUserInterfaceTest {

    @Rule
    public final TextFromStandardInputStream input = emptyStandardInputStream();

    @Rule
    public final SystemOutRule stdOutLog = new SystemOutRule().enableLog();

    @Test
    public void showField() {
    }

    @Test
    public void askCoordinates() {
        //given
        UserInterface userInterface = new ConsoleUserInterface();

        //when
        input.provideLines("\n", "1,1");
        Coordinates coordinates = userInterface.askCoordinates("User1");

        //then
        assertEquals(0, coordinates.getHorizontal().intValue());
        assertEquals(0, coordinates.getVertical().intValue());
    }

    @Test
    public void askCoordinatesIncorrectAndThenCorrect() {
        //given
        UserInterface userInterface = new ConsoleUserInterface();

        //when
        input.provideLines("\n", "1", "1,1");
        Coordinates coordinates = userInterface.askCoordinates("User1");

        //then
        String log = stdOutLog.getLog();
        assertEquals("User1, Enter coordinates in <ROW,COLUMN> format (e.g. 3,2): User1, Enter coordinates in <ROW,COLUMN> format (e.g. 3,2): ", log);
        assertEquals(0, coordinates.getHorizontal().intValue());
        assertEquals(0, coordinates.getVertical().intValue());
    }

    @Test
    public void askUserName() {
        //given
        UserInterface userInterface = new ConsoleUserInterface();
        String name = "User1";

        //when
        input.provideLines(name);
        String userName = userInterface.askUserName(1);

        //then
        assertEquals(name, userName);
    }
}