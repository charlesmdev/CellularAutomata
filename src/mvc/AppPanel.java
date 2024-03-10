package mvc;

import javax.swing.*;
import java.awt.*;
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
    //Adds ControlPanel and buttons
    public class ControlPanel extends JPanel {

        public ControlPanel() {
            setBackground(Color.LIGHT_GRAY);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
        public void addButton(JButton button) {
            JPanel buttonPanel = new JPanel();
            //button.addActionListener(AppPanel.this); //Maybe not needed
            buttonPanel.add(button);
            add(button);

        }
    }
}
