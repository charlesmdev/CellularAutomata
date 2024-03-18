package CALab;

import mvc.*;

public class GridFactory implements AppFactory {

    public Model makeModel() { return null; } //Make Model is returning null cannot initialize Grid model due to abstract
    public View makeView(Model model) {
        return new GridView(model);
    }

    public String getTitle() { return "CALab"; }

    public String[] getHelp() {
        return new String[0];
    }

    public String about() {
        return null;
    }

    public String[] getEditCommands() {
        return new String[] {"Run1", "Run50", "Populate", "Clear"};
    }

    public Command makeEditCommand(Model model, String type) { //Removed Object Source param, not needed
        return switch (type) {
            case "Run1" -> new RunCommand(model, 1);
            case "Run50" -> new RunCommand(model, 50);
            case "Populate" -> new PopulateCommand(model);
            case "Clear" -> new ClearCommand(model);
            default -> null;
        };
    }
}
