package CALab;

import javax.swing.*;

import mvc.*;

import java.awt.*;

public class GridView extends View {

    private CellView cellViews[][];

    //    public GridView(Model model) {
//        Grid gridModel = (Grid) model; // Model is null
//        int row = gridModel.getDim(); // Model is null, returns NullPointerException
//        int col = gridModel.getDim();
//
//        CellView cell = new CellView(((Grid)model).getCell(row, col));
//        cellViews[row][col] = cell;
//        //set cell.row and cell.col here
//        cell.setRow(row);
//        cell.setCol(col);
////        Grid gridModel = (Grid) model;
////        int dim = gridModel.getDim();
////        cellViews = new CellView[dim][dim]; // Initialize the cellViews array
////
////        // Iterate over each cell in the grid and create a CellView for it
////        for (int row = 0; row < dim; row++) {
////            for (int col = 0; col < dim; col++) {
////                CellView cell = new CellView(gridModel.getCell(row, col));
////                cellViews[row][col] = cell;
////                // Set cell.row and cell.col here
////                cell.setRow(row);
////                cell.setCol(col);
////            }
////        }
//    }
    public GridView(Model model) {
        Grid gridModel = (Grid) model;
        int dim = gridModel.getDim();

        cellViews = new CellView[dim][dim];

        // Create CellViews for each cell in the grid
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                Cell cell = gridModel.getCell(row, col);
                CellView cellView = new CellView(cell);
                cellView.setRow(row);
                cellView.setCol(col);
                cellViews[row][col] = cellView;
            }
        }

        setLayout(new GridLayout(cellViews.length, cellViews[0].length));
        for (CellView[] row : cellViews) {
            for (CellView cellView : row) {
                add(cellView);
            }
        }
    }

    public CellView[][] getCellViews() {
        return cellViews;
    }


    public void update() {
        // call update method of each CellView
        for (int i = 0; i < cellViews.length; i++) { //iterate through each row in cellViews
            for (int j = 0; j < cellViews[i].length; j++) { //iterate through each col in cellViews
                if (cellViews[i][j] != null) { //
                    cellViews[i][j].update();
                }
            }
        }
    }

}
