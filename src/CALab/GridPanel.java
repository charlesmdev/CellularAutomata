package CALab;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import mvc.*;

public class GridPanel extends AppPanel {
    private JButton change;
    private JButton Populate;
    private JButton Run1;
    private JButton Run50;
    private JButton Clear;
    private GridView gridView;


    public GridPanel(AppFactory factory) {
        super(factory);
//        change = new JButton ("change");
//        change.addActionListener(this);
//        controlPanel.add(change);

        // Ensure that the model is properly initialized
        if (model == null) {
            // If the model is not initialized, create it using the factory
            model = factory.makeModel();
        }

        // Create GridView
        gridView = new GridView(model);

        //setView(gridView);
        // Get the cell views from the GridView

        Run1 = new JButton("Run1");
        Run1.addActionListener(this);
        controlPanel.add(Run1);

        Run50 = new JButton("Run50");
        Run50.addActionListener(this);
        controlPanel.add(Run50);

        Populate = new JButton("Populate");
        Populate.addActionListener(this);
        controlPanel.add(Populate);

        Clear = new JButton("Clear");
        Clear.addActionListener(this);
        controlPanel.add(Clear);
    }
    @Override
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
            if(cmmd.equals("Populate")) {
                Command populateCommand = factory.makeEditCommand(model, cmmd);
                populateCommand.execute();
            }
            else if (cmmd.equals("Run1")) {
                Command run1Command = factory.makeEditCommand(model, cmmd);
                run1Command.execute();
            }
            else if (cmmd.equals("Run50")) {
                Command run50Command = factory.makeEditCommand(model, cmmd);
                run50Command.execute();
            }
            else if (cmmd.equals("Clear")) {
                Command clearCommand = factory.makeEditCommand(model, cmmd);
                clearCommand.execute();
            }
            else if(cmmd.equals("About")) {
                Utilities.inform(factory.about());
            }
            else if (cmmd.equals("Help")) {
                Utilities.inform(factory.getHelp());
            }
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

    public GridPanel() {
        this(null);
    }
    @Override
    public void update() {

    }
    public static void main(String[] args) {
        //AppFactory factory = new GridFactory();
        AppPanel panel = new GridPanel(factory);
        panel.display();
    }
}
