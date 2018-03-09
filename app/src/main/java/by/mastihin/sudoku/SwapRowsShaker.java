package by.mastihin.sudoku;

import java.util.Random;

import static by.mastihin.sudoku.SquareMatrixUtils.swapSquares;

/**
 * Created by AndrewEvtukhov on 09.03.2018.
 */

public class SwapRowsShaker implements Shaker {
    @Override
    public int[][] shake(int[][] matrix) {
        Random random = new Random();
        int squareSize = (int) Math.sqrt(matrix.length);
        int firstSquareNumber = random.nextInt(squareSize);
        int secondSquareNumber;
        do {
            secondSquareNumber = random.nextInt(squareSize);
        }
        while (firstSquareNumber == secondSquareNumber);

        swapSquares(firstSquareNumber, secondSquareNumber, matrix);
        return matrix;
    }
}