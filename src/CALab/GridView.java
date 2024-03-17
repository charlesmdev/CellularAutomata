package CALab;

import javax.swing.*;
import mvc.*;
import java.awt.*;

public class GridView extends View {

    private CellView cellViews[][];

    public GridView(Model model, int row, int col) {
        CellView cell = new CellView(((Grid)model).getCell(row, col));
        cellViews[row][col] = cell;
        //set cell.row and cell.col here
        cell.setRow(row);
        cell.setCol(col);
    }

    public void update() {
        // call update method of each CellView
        for (int i = 0; i < cellViews.length; i++) { //iterate through each row in cellViews
            for (int j = 0; j < cellViews[j].length; j++) { //iterate through each col in cellViews
                if (cellViews[i][j] != null) { //
                    cellViews[i][j].update();
                }
            }
        }
    }

}
