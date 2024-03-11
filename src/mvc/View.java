package mvc;

import javax.swing.*;

public class View extends JPanel implements Subscriber {

    Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void update() {

    }
}
