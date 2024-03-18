package Life;

import CALab.*;
import javax.swing.*;

public class LifePanel extends GridPanel {

    private JButton populate;
    private JButton clear;
    private JButton run1;
    private JButton run50;

    public LifePanel (GridFactory factory) {
        super(factory);
        populate = new JButton ("Populate");
        populate.addActionListener(this);
        controlPanel.add(populate);

        clear = new JButton("Clear");
        clear.addActionListener(this);
        controlPanel.add(clear);

        run1 = new JButton("Run1");
        run1.addActionListener(this);
        controlPanel.add(run1);

        run50 = new JButton("Run50");
        run50.addActionListener(this);
        controlPanel.add(clear);
    }
    public static void main (String[] args) {
        GridFactory factory = new GridFactory();
        GridPanel panel = new GridPanel(factory);
        panel.display();
    }
}
