package Life;

import CALab.*;
import mvc.Model;

public class LifeFactory extends GridFactory {

    @Override
    public Model makeModel() {
        return new Society();
    }
}
