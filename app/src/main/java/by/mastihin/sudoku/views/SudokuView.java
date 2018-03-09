package by.mastihin.sudoku.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.support.v7.widget.GridLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import by.mastihin.sudoku.R;

/**
 * Created by AndrewEvtukhov on 09.03.2018.
 */

public class SudokuView extends GridLayout {

    private int[][] matrix;

    public SudokuView(Context context) {
        super(context);
        init();
    }

    public SudokuView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public SudokuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
        removeAllViews();
        int rows = matrix.length;
        int columns = matrix[0].length;

        setColumnCount(columns);
        setRowCount(rows);

        for (int i = 0, k = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++, k++) {
                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f),
                        GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f));
                TextView item = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.item_grid, null);
                item.setText(Integer.toString(matrix[i][j]));
                addView(item, layoutParams);
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        Path path = new Path();
//        path
//        canvas.drawPath();
//        canvas.drawLines();
    }
}