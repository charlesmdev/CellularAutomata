package mvc;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends JPanel implements Subscriber, PropertyChangeListener {

    Model model;

    public View (Model model) {
        this.model = model;
    }
    public void setModel(Model model) {

        this.model = model;
    }

    @Override
    public void update() {

        view.repaint();
    }

    public void makeView(Model model) {

        this.model = model;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}