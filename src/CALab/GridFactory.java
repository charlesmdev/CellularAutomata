package CALab;

import mvc.*;

public abstract class GridFactory implements AppFactory {

    public abstract Model makeModel(); //Make Model is returning null cannot initialize Grid model due to abstract
    public View makeView(Model model) {
        return new GridView(model);
    }

    public String getTitle() { return "CALab"; }

    public String[] getHelp() {
        return new String[] {"Click Clear to set all cells as dead. Click Populate to revive some cells. Click Run1 or Run50 to update the amount of times looped."};
    }

    public String about() {
        return "Cellular Automata version 1.0. by Charles Manaois, Fnu Saad, & Ynha Nguyen";
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
