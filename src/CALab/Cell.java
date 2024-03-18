package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;
import mvc.*;

public abstract class Cell extends Publisher implements Serializable {

    protected int row = 0, col = 0;
    protected int status = 0;
    protected Color color = Color.GREEN;
    protected Set<Cell> neighbors = new HashSet<Cell>();
    protected Grid myGrid = null;
    protected Cell partner = null;


    // choose a random neighbor as a partner
    public void choosePartner() {
        if (partner == null && neighbors != null) {
			/*
			Set partner to null
			Convert neighbors set to a local array
			Starting at a random position in the array search for a neighbor without a partner
			Make the first such neighbor (if any) the partner and set its partner field to this
			*/
            Random random = new Random();
            this.partner = null;
            Cell[] cellArray = neighbors.toArray(new Cell[neighbors.size()]);
            int randomIndex = random.nextInt(cellArray.length);
            for (int i = 0; i < cellArray.length; i++) {
                int index = (randomIndex + i) % cellArray.length; // Wrap around the array if necessary
                Cell neighbor = cellArray[index];
                if (neighbor.partner == null) {
                    // Make the first such neighbor (if any) the partner and set its partner field to this
                    this.partner = neighbor;
                    neighbor.partner = this;
                    break; // Exit loop once partner is found
                }
            }
        }
    }

    public void unPartner() {
        if (partner != null) {
            if (partner.partner != null) {
                partner.partner = null;
            }
            partner = null;
        }
    }
    //TODO: Add getColor(); and getStatus(); method

    public Color getColor() {
        return color;
    }
    public int getStatus() {
        return status;
    }
    public void setNeighbors(Set<Cell> neighbors) { this.neighbors = neighbors; }
    public void setStatus(int status) { this.status = status; }
    public int getCol() {
        return this.col;
    }
    public int getRow() {
        return this.row;
    }
    // observer neighbors' states
    public abstract void observe();
    // interact with a random neighbor
    public abstract void interact();
    public abstract void interact(Cell ranNeighbor);
    // update my state
    public abstract void update();
    // set status to status + 1 mod whatever
    public abstract void nextState();
    // set status to a random or initial value
    public abstract void reset(boolean randomly);

}
