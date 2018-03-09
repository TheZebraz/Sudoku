package by.mastihin.sudoku;

import java.util.Random;

import static by.mastihin.sudoku.SquareMatrixUtils.swapRows;

/**
 * Created by AndrewEvtukhov on 09.03.2018.
 */

public class SwapRowsSmallShaker implements Shaker {
    @Override
    public int[][] shake(int[][] matrix) {
        Random random = new Random();
        int squareSize = (int) Math.sqrt(matrix.length);
        int squareNumber = random.nextInt(squareSize);

        int firstRowNumber = getRandomRowInSquare(random, squareSize, squareNumber);
        int secondRowNumber;
        do {
            secondRowNumber = getRandomRowInSquare(random, squareSize, squareNumber);
        }
        while (secondRowNumber == firstRowNumber);

        swapRows(firstRowNumber, secondRowNumber, matrix);
        return matrix;
    }

    private int getRandomRowInSquare(Random random, int squareSize, int squareNumber) {
        int low = squareNumber * squareSize;
        int high = low + squareSize;
        return random.nextInt(high - low) + low;
    }
}