package Life;

import CALab.*;
import mvc.*;

public class LifeFactory extends GridFactory{

    @Override
    public Model makeModel() {
        return new Society();
    }

}
