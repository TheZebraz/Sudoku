package by.mastihin.sudoku.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.widget.GridLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import by.mastihin.sudoku.R;

/**
 * Created by AndrewEvtukhov on 09.03.2018.
 */

public class SudokuView extends GridLayout {

    private int[][] matrix;
    private Path path;
    Paint paint;

    private int w;
    private int h;

    private int childW;
    private int childH;

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
        path = new Path();
        paint = new Paint();
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
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.w = w;
        this.h = h;


    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        if (this.getChildCount() > 0) {
            View child = getChildAt(2);
            childW = child.getMeasuredWidth();
            childH = child.getMeasuredHeight();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int strokeWidth = 10;

        paint.setStrokeWidth(strokeWidth);
        paint.setColor(Color.BLACK);

        int squaresCount = (int) Math.sqrt(matrix.length);
        int squareSize = (h - getPaddingTop() - getPaddingBottom()) / squaresCount;

        for (int i = 0; i < squaresCount + 1; i++) {
            //vertical
            canvas.drawLine(getPaddingLeft() + i * squareSize, getPaddingTop(),
                    getPaddingLeft() + i * squareSize, h - getPaddingBottom(), paint);
            //horizontal
            canvas.drawLine(getPaddingLeft() - strokeWidth / 2,
                    getPaddingTop() + i * squareSize, w - getPaddingRight() + strokeWidth / 2, getPaddingTop() + i * squareSize, paint);
        }

    }
}