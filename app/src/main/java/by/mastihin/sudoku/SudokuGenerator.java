package by.mastihin.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by AndrewEvtukhov on 09.03.2018.
 */

public class SudokuGenerator {

    private int dimension;

    public SudokuGenerator(int dimension) {
        if (!dimensionCheck(dimension)) {
            throw new IllegalArgumentException("Dimension should has integer square root!");
        }
        this.dimension = dimension;
    }

    public int[][] generate() {
        int[][] matrix = generateBaseMatrix();

        for (Shaker shaker : getShakers()) {
            matrix = shaker.shake(matrix);
        }
        return matrix;
    }

    private List<Shaker> getShakers() {
        ShakerFactory shakerFactory = new ShakerFactory();
        List<Shaker> shakers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            shakers.add(shakerFactory.getShaker(random.nextInt(4 - 1) + 1));
        }
        return shakers;
    }

    private boolean dimensionCheck(int dimension) {
        int sqrt = (int) Math.sqrt(dimension);
        return sqrt * sqrt == dimension;
    }

    private int[][] generateBaseMatrix() {
        int squareSize = (int) Math.sqrt(dimension);
        int[][] baseMatrix = new int[dimension][dimension];

        for (int i = 0; i < baseMatrix.length; i++) {
            for (int j = 0; j < baseMatrix[0].length; j++) {
                baseMatrix[i][j] = (j + (i % squareSize) * squareSize + i / squareSize) % dimension + 1;
            }
        }
        return baseMatrix;
    }


}
