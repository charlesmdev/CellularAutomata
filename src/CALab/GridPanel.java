package CALab;
import java.awt.*;
import javax.swing.*;
import mvc.*;

public class GridPanel extends AppPanel {
    private JButton change;

    public GridPanel(AppFactory factory) {
        super(factory);
        change = new JButton ("change");
        change.addActionListener(this);
        controlPanel.add(change);
    }

    public GridPanel() {
        this(null);
    }
    @Override
    public void update() {

    }
    public static void main(String[] args) {
        AppFactory factory = new GridFactory();
        AppPanel panel = new GridPanel(factory);
        panel.display();
    }
}
