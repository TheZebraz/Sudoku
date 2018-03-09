package by.mastihin.sudoku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[][] sudoku = new int[9][9];

        showGrid(sudoku);
    }

    private void showGrid(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        GridLayout gridLayout = findViewById(R.id.table);
        gridLayout.setColumnCount(columns);
        gridLayout.setRowCount(rows);

        for (int i = 0, k = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++, k++) {
                matrix[i][j] = k;
                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f),
                        GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f));
                TextView item = (TextView) LayoutInflater.from(this).inflate(R.layout.item_grid, null);
                item.setText(Integer.toString(matrix[i][j]));
                gridLayout.addView(item, layoutParams);
                Log.d("HEIGHT", "showGrid: " + item.getMeasuredHeight());
            }
        }
    }
}
