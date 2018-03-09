package by.mastihin.sudoku;

/**
 * Created by AndrewEvtukhov on 09.03.2018.
 */

public class SquareMatrixUtils {

    public static void swapRows(int firstRowNumber, int secondRowNumber, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int tmp = matrix[firstRowNumber][i];
            matrix[firstRowNumber][i] = matrix[secondRowNumber][i];
            matrix[secondRowNumber][i] = tmp;
        }
    }

    public static void swapSquares(int firstSquareNumber, int secondSquareNumber, int[][] matrix) {
        int squareSize = (int) Math.sqrt(matrix.length);
        for (int i = 0; i < squareSize; i++) {
            swapRows(firstSquareNumber * squareSize + i, secondSquareNumber * squareSize + i, matrix);
        }
    }
}
