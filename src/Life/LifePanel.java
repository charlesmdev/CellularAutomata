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
import mvc.AppFactory;
import mvc.AppPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifePanel extends GridPanel {

    private CellView[][] cellViews;

    public LifePanel(AppFactory factory) {
        super(factory);
    }

//Original
    public static void main(String[] args) {
        AppFactory factory = new LifeFactory();
        AppPanel panel = new LifePanel(factory);
        panel.display();
    }
//    public static void main(String[] args) {
//        GridFactory factory = new LifeFactory();
//        GridPanel panel = new GridPanel(factory);
//        panel.display();
//    }
    @Override
    public void update() { //Goes here after calling clear and populate.
        ((GridView) view).update();
    }
}
