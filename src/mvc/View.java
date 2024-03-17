package mvc;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends JPanel implements Subscriber {

    protected Model model;

    public View (Model model) {
        this.model = model;
    }

    public View () {
        this(null);
    }
    public void setModel(Model model) {

        this.model = model;
    }

    @Override
    public void update() {

    }
    public void makeView(Model model) { this.model = model; }
}