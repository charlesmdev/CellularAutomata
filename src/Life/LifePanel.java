//package Life;
//
//import CALab.*;
//import mvc.*;
//
//public class LifePanel extends GridPanel {
//
//    public LifePanel(AppFactory factory) {
//        super(factory);
//    }
//    @Override
//    public void update() {
//        view.repaint();
//    }
//}
package Life;

import CALab.*;
import mvc.*;

import java.awt.*;
import java.awt.event.ActionEvent;

public class LifePanel extends GridPanel {

    private CellView[][] cellViews;

    public LifePanel(AppFactory factory) {
        super(factory);

        // Ensure that the model is properly initialized
        if (model == null) {
            // If the model is not initialized, create it using the factory
            model = factory.makeModel();
        }

        Society society = (Society) model; // Now the model should not be null
        int dim = society.getDim();

        setLayout(new GridLayout(dim, dim));
        cellViews = new CellView[dim][dim];

        // Create CellViews for each cell in the grid
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                Cell cell = society.getCell(row, col);
                CellView cellView = new CellView(cell);
                cellViews[row][col] = cellView;
                cellView.addActionListener(this);
                add(cellView);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle cell button click event
        if (e.getSource() instanceof CellView) {
            CellView cellView = (CellView) e.getSource();
            cellView.getCell().nextState(); // Advance the state of the clicked cell
            cellView.update(); // Update the appearance of the cell button
        }
    }

    public static void main(String[] args) {
        AppFactory factory = new GridFactory();
        AppPanel panel = new LifePanel(factory);
        panel.display();
    }
}
