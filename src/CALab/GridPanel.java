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
        CellView[][] cellViews = gridView.getCellViews();

        // Set layout and add cell views to the panel
        setLayout(new GridLayout(cellViews.length, cellViews[0].length));
        for (CellView[] row : cellViews) {
            for (CellView cellView : row) {
                add(cellView);
            }
        }

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
        }
        catch (Exception e){
            Utilities.error(e);
        }
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
