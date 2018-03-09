package by.mastihin.sudoku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import by.mastihin.sudoku.views.SudokuView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SudokuGenerator sudokuGenerator = new SudokuGenerator(9);
        View view = findViewById(R.id.generate);
        showGrid(sudokuGenerator.generate());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGrid(sudokuGenerator.generate());
            }
        });
    }

    private void showGrid(int[][] matrix) {
        SudokuView sudokuView = findViewById(R.id.table);
        sudokuView.setMatrix(matrix);
    }
}
