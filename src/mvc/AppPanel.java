package mvc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppPanel extends JPanel implements ActionListener, Subscriber {

    Model model;
    ControlPanel controls;
    View view;
    AppFactory factory;

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void update() {

    }
}
