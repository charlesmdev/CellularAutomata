package Life;
import CALab.*;
public class Agent extends Cell {
    private int ambience = 8;
    //TODO: During the update phase each cell updates its status.
    @Override
    public void update() {
        if (status == 0) {
            // Cell is dead
            if (ambience == 3) {
                super.setStatus(1);
            }
        } else {
            // Cell is alive
            if (ambience < 2 || ambience > 3) {
                super.setStatus(0);
            }
        }
    }
    //TODO:   During the observation phase each cells updates ambience.
    @Override
    public void observe() {
        // Count the number of living neighbors
        int numNeighbors = 0;
        for (Cell neighbor : neighbors) {
            if (neighbor.getStatus() == 1) {
                numNeighbors++;
            }
        }
        this.ambience = numNeighbors;
    }
    //Ignore these methods, don't implement anything.
    @Override
    public void interact(Cell ranNeighbor) {

    }
    @Override
    public void interact() {

    }
    @Override
    public void nextState() {

    }

    @Override
    public void reset(boolean randomly) {

    }
}
