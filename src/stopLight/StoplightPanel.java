package stopLight;//For some reason the package name was stoplightSim2

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

import mvc.*;


public class StoplightPanel extends AppPanel {
    private JButton change;
    public StoplightPanel(AppFactory factory) {
        super(factory);
        change = new JButton("Change");
        change.addActionListener(this);
        controlPanel.add(change);
    }

    public static void main(String[] args) {
        AppFactory factory = new StoplightFactory();
        AppPanel panel = new StoplightPanel(factory);
        panel.display();
    }
    @Override
    public void update() {
        view.repaint();
    }
}

