package by.mastihin.sudoku;

/**
 * Created by AndrewEvtukhov on 09.03.2018.
 */

public class TransposingShaker implements Shaker {

    @Override
    public int[][] shake(int[][] matrix) {
        if (matrix.length == matrix[0].length) {
            int[][] tmpMatrix = new int[matrix.length][matrix.length];
            for (int i = 0; i < tmpMatrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    tmpMatrix[i][j] = matrix[j][i];
                }
            }
            matrix = tmpMatrix;
        }
        return matrix;
    }
}
