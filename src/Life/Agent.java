package Life;

import CALab.Cell;

import java.awt.*;

public class Agent extends Cell {
    private int ambience = 8;
    private Color statusColor;

    public Agent() {
        statusColor = Color.BLACK; //default color
    }

    public Color getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(Color statusColor) {
        this.statusColor = statusColor;

    }
    //TODO: During the update phase each cell updates its status. Updates my state?
    public Agent() {
        super();
    }
    @Override
    public void update() {
<<<<<<< HEAD
        if (getStatus() == 0) { //if agent is dead
            color = Color.RED;
        }
        else {
            color = Color.GREEN;
        }
=======
        nextState();
>>>>>>> cc73812b5600e3617891dcdd66e86501cd86ee40
    }
    //TODO:   During the observation phase each cells updates ambience.
    @Override
    public void observe() {
        // Count the number of living neighbors
        int numNeighbors = 0;
        for (Cell neighbor : neighbors) {
            if (neighbor != null && neighbor.getStatus() == 1) {
                numNeighbors++;
            }
        }
        setAmbience(numNeighbors);
    }
    @Override
    public void nextState() {
        int numLivingNeighbors = getAmbience(); // Get the number of living neighbors

        // Determine the next state based on the current state and the number of living neighbors
        if (getStatus() == 0) { // If the cell is currently dead
            if (Society.rebirth.contains(numLivingNeighbors)) {
                setStatus(1); // Bring the cell to life
            }
        } else { // If the cell is currently alive
            if (!Society.death.contains(numLivingNeighbors)) {
                setStatus(0); // Kill the cell
            }
        }
    }
    public void setAmbience(int numNeighbors) {
        this.ambience = numNeighbors;
    }
    public int getAmbience() {
        return this.ambience;
    }
    //Ignore these methods, don't implement anything.
    @Override
    public void interact(Cell ranNeighbor) {

    }
    @Override
    public void interact() {

    }
    @Override
    public void reset(boolean randomly) {

    }
}
