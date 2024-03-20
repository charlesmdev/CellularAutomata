package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppPanel extends JPanel implements ActionListener, Subscriber {

    protected Model model;
    protected JPanel controlPanel;
    protected View view;
    protected static AppFactory factory;
    private JFrame frame;
    public static int FRAME_WIDTH = 500;
    public static int FRAME_HEIGHT = 300;

    public AppPanel (AppFactory factory) {
        this.factory = factory;
        model = factory.makeModel();
        view = factory.makeView(model);
        view.setBackground((Color.GRAY));
        controlPanel = new JPanel();
        controlPanel.setBackground((Color.WHITE));
        setLayout((new GridLayout(1,2)));
        add(controlPanel);
        add(view);
        model.subscribe(this);

        frame = new SafeFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(createMenuBar());
        frame.setTitle(factory.getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }
    public void setView(View newView) {
        remove(view); // Remove the current view from the panel
        view = newView; // Assign the new view
        add(controlPanel); // Add the control panel back to the panel
        add(view); // Add the new view to the panel
        revalidate(); // Revalidate the panel to reflect changes
        repaint(); // Repaint the panel
    }

    public AppPanel() {
        this(null);
    }

    public JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[] {"New", "Save", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", new String[]{"Run1", "Run50", "Populate", "Clear"}, this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String cmmd = ae.getActionCommand();
            if(cmmd.equals("Save")) {
                Utilities.save(model, false);
            }
            else if (cmmd.equals("SaveAs")) {
                Utilities.save(model, true);
            }
            else if (cmmd.equals("Open")) {
                Model newModel = Utilities.open(model);
            }
            else if (cmmd.equals("New")) {
                Utilities.saveChanges(model);
                setModel(factory.makeModel());
                model.setUnsavedChanges(false);
            }
            else if (cmmd.equals("Quit")) {
                Utilities.saveChanges(model);
                System.exit(0);
            }
        }
        catch (Exception e){
            Utilities.error(e);
        }
    }

    public void display() {
        frame.setVisible(true);
    }
    @Override
    public void update() {
        // keep empty
    }

    public void setModel(Model newModel) {
        this.model.unsubscribe(this);
        this.model = newModel;
        this.model.subscribe(this);
        view.setModel(this.model);
        model.changed();
    }

    public Model getModel() {
        return model;
    }

    public static void main(String[] args) {
        AppPanel panel = new AppPanel(factory);
        panel.display();
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
