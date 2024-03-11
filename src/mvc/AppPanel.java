package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AppPanel extends JPanel implements ActionListener, Subscriber {

    Model model;
    ControlPanel controls;
    View view;
    AppFactory factory;

    private JButton change;

    public AppPanel (AppFactory factory) {
        controls = new ControlPanel();
        view = new View(model);
        this.setLayout((new GridLayout(1,2)));
        this.add(controls);
        this.add(view);
        model.subscribe(view);

        change = new JButton("Change");
        change.addActionListener(this);
        controls.add(change);
    }

    @Override
    public JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[] {"New", "Save", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", new String[]{"Change"}, this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {
            switch (cmmd) {
                case "Save": {
                    String fileName = Utilities.getFileName((String) null, false);
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
                    os.writeObject(this.model);
                    os.close();
                    break;
                }

                case "Open": {
                    if (Utilities.confirm("Confirm: Unsaved changes will be lost.")) {
                        String fileName = Utilities.getFileName((String) null, true);
                        ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
                        model = (Model) is.readObject();
                        view.setModel(model);
                        is.close();
                    }
                    break;
                }

                case "Quit": {
                    System.exit(0);
                    break;
                }
            }
        } catch (Exception ex) {
            Utilities.error(ex);
        }
    }

    public static void main(String[] args) {
        AppPanel panel = new AppPanel();
        panel.display();
    }

    public void display() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle("Cellular Automata");
        frame.setSize(500,300);
        frame.setVisible(true);
    }
    @Override
    public void update() {

    }
}
