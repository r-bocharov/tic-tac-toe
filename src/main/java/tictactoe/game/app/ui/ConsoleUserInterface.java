package tictactoe.game.app.ui;

import tictactoe.game.app.board.Coordinates;
import tictactoe.game.app.board.Playfield;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    private Scanner console;

    public ConsoleUserInterface() {
        console = new Scanner(System.in);
    }

    @Override
    public void showField(Playfield playfield) {
        System.out.println();
        char[][] board = playfield.getBoard();

        for (int row = 0, numForBorder = 1; row <= board.length - 1; row++, numForBorder++) {
            System.out.print(numForBorder + "| ");
            for (int col = 0; col <= board[row].length - 1; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println("|");
        }
        System.out.println();

    }

    @Override
    public Coordinates askCoordinates(String name) {
        String[] coordinates;
        int horizontal = 0;
        int vertical = 0;
        boolean repeat = true;

        do {
            System.out.print(String.format("%s, Enter coordinates in <ROW,COLUMN> format (e.g. 3,2): ", name));
            console.nextLine();
            String rawCoordinates = console.next();

            coordinates = rawCoordinates.split(",");

            if (coordinates.length != 2) {
                continue;
            }

            try {
                horizontal = Integer.parseInt(coordinates[0]);
                vertical = Integer.parseInt(coordinates[1]);
            } catch (NumberFormatException ex) {
                System.out.println("Only numbers are allowed");
                continue;
            }
            if (horizontal <= 0 || vertical <= 0) {
                System.out.println("Only positive numbers are allowed");
                continue;
            }

            repeat = false;
        } while (repeat);

        return new Coordinates(--horizontal, --vertical);
    }

    @Override
    public String askUserName(int userNumber) {
        System.out.print(String.format("Enter player-%s name: ", userNumber));
        return console.next();
    }

    @Override
    public void freeUsedResources() {
        console.close();
    }
}
