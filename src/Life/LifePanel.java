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

import CALab.Cell;
import CALab.CellView;
import CALab.GridFactory;
import CALab.GridPanel;
import mvc.AppFactory;
import mvc.AppPanel;

import java.awt.*;
import java.awt.event.ActionEvent;

public class LifePanel extends GridPanel {

    private CellView[][] cellViews;

    public LifePanel(AppFactory factory) {
        super(factory);
    }


    public static void main(String[] args) {
        AppFactory factory = new LifeFactory();
        AppPanel panel = new LifePanel(factory);
        panel.display();
    }
}
