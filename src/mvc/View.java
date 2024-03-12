package mvc;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends JPanel implements Subscriber, PropertyChangeListener {

    Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void update() {

    }

    public void makeView(Model model) {
        this.model = model;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
