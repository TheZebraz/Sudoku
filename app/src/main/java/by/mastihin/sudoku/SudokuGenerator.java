package by.mastihin.sudoku;

/**
 * Created by AndrewEvtukhov on 09.03.2018.
 */

public class SudokuGenerator {

    private int dimension;

    public SudokuGenerator(int dimension) {
        if(!dimensionCheck(dimension)){
            throw new IllegalArgumentException("Dimension should has integer square root!");
        }
        this.dimension = dimension;
    }

    private boolean dimensionCheck(int dimension){
        int sqrt = (int) Math.sqrt(dimension);
        return sqrt*sqrt == dimension;
    }

    public int[][] generateBaseMatrix(){
        int squareSize = (int) Math.sqrt(dimension);
        int[][] baseMatrix = new int[dimension][dimension];

        for (int i = 0; i < baseMatrix.length; i++) {
            for(int j = 0; j < baseMatrix[0].length; j++){
                baseMatrix[i][j] = (j + (i % squareSize) * squareSize + i / squareSize) % dimension + 1;
            }
        }
        return baseMatrix;
    }


}
