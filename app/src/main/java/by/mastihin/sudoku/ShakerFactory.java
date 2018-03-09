package by.mastihin.sudoku;

/**
 * Created by AndrewEvtukhov on 09.03.2018.
 */

public class ShakerFactory {

    public static final int TRANSPOSING = 1;
    public static final int SWAP_ROWS_SMALL = 2;
    public static final int SWAP_ROWS = 3;

    public Shaker getShaker(int type) {
        switch (type) {
            case TRANSPOSING:
                return new TransposingShaker();
            case SWAP_ROWS_SMALL:
                return new SwapRowsSmallShaker();
            case SWAP_ROWS:
                return new SwapRowsShaker();
        }
        return null;
    }

}
