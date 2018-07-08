package tictactoe.game.utilities;

import java.util.Optional;

/**
 * Utility class for arrays
 */
public class ArrayUtils {

    /**
     * Flatten an array
     * @param arr array to be flattened
     * @return flat array
     */
    public static char[] flatArray(char[][] arr) {
        char result[] = new char[arr.length * arr[0].length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                result[index++] = arr[i][j];
            }
        }
        return result;
    }

    /**
     * Return a symbol which repeats in all cells horizontally
     * @param array array to be processed
     * @return found symbol
     */
    public static Optional<Character> sameSymbolHorizontally(char[][] array) {
        for (int row = 0; row < array.length; row++) {
            int counter = 0;
            char symbol = array[row][0];

            if (symbol == Config.INSTANCE.getEmptySymbol()) {
                continue;
            }

            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] == symbol) {
                    counter++;
                }
            }
            if (counter == array[row].length) {
                return Optional.of(symbol);
            }
        }
        return Optional.empty();
    }

    /**
     * Return a symbol which repeats in all cells vertically
     * @param array array to be processed
     * @return found symbol
     */
    public static Optional<Character> sameSymbolVertically(char[][] array) {

        for (int row = 0; row < array.length; row++) {
            int counter = 0;
            char currentValue = array[0][row];

            if (currentValue == Config.INSTANCE.getEmptySymbol()) {
                return Optional.empty();
            }

            for (int col = 0; col < array.length; col++) {
                if (array[col][row] == currentValue) {
                    counter++;
                }
            }

            if (counter == array[row].length) {
                return Optional.of(currentValue);
            }
        }
        return Optional.empty();
    }

    /**
     * Return a symbol which repeats in all cells diagonally
     * @param array array to be processed
     * @return found symbol
     */
    public static Optional<Character> sameSymbolDiagonally(char[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            throw new IllegalStateException("The array is empty");
        }

        int counter = 0;
        char symbol = array[0][0];

        if (symbol == Config.INSTANCE.getEmptySymbol()) {
            return Optional.empty();
        }

        counter = findInMajorDiagonal(array, symbol);

        if (counter != array.length) {
            symbol = array[array.length - 1][0];

            if (symbol == Config.INSTANCE.getEmptySymbol()) {
                return Optional.empty();
            }

            counter = findInMinorDiagonal(array, symbol);
        }

        if (counter == array.length) {
            return Optional.of(symbol);
        }

        return Optional.empty();
    }

    private static int findInMinorDiagonal(char[][] array, char symbol) {
        int counter = 0;

        for (int num = 0; num < array.length; num++) {
            if (array[num][array.length - 1 - num] == symbol) {
                counter++;
            }
        }
        return counter;
    }

    private static int findInMajorDiagonal(char[][] array, char symbol) {
        int counter = 0;

        for (int num = 0; num < array.length; num++) {
            if (array[num][num] == symbol) {
                counter++;
            }
        }
        return counter;
    }

}
