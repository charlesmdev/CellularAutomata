package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;
import mvc.*;

public abstract class Grid extends Model {
    static private int time = 0;
    protected int dim = 20;
    protected Cell[][] cells;

    public int getDim() {
        return dim;
    }

    public int getTime() {
        return time;
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public abstract Cell makeCell(boolean uniform); //Uniform?


    public Grid(int dim) {
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
    }

    public Grid() {
        this(20);
    }

    protected void populate() {
        // 1. use makeCell to fill in cells.
        // 2. use getNeighbors to set the neighbors field of each cell
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                cells[row][col] = makeCell(true); // True or false?
                //Finish getNeighbors
                cells[row][col].setNeighbors(getNeighbors(cells[row][col], 1)); //Add parameters after getNeighbors() method implemented
            }
        }
    }

    // called when Populate button is clicked
    public void repopulate(boolean randomly) {
        if (randomly) {
            Random random = new Random();
            // randomly set the status of each cell
            for (int row = 0; row < cells.length; row++) {
                for (int col = 0; col < cells[row].length; col++) {
                    int ranStatus = random.nextInt(2) + 0;
                    cells[row][col].setStatus(ranStatus);
                }
            }
        }else{
                // set the status of each cell to 0 (dead)
                for (int row = 0; row < cells.length; row++) {
                    for (int col = 0; col < cells[row].length; col++) {
                        cells[row][col].setStatus(0);
                    }
            }
            // notify subscribers
        }
        notifySubscribers();
    }


    public Set<Cell> getNeighbors(Cell asker, int radius) {
        /*
        return the set of all cells that can be reached from the asker in radius steps.
        If radius = 1 this is just the 8 cells touching the asker.
        Tricky part: cells in row/col 0 or dim - 1.
        The asker is not a neighbor of itself.
        */
        Set<Cell> neighbors = new HashSet<>();
        int askerRow = asker.getRow();
        int askerCol = asker.getCol();
        // Loop through cells within the specified radius
        for (int row = Math.max(0, askerRow - radius); row <= Math.min(dim - 1, askerRow + radius); row++) {
            for (int col = Math.max(0, askerCol - radius); col <= Math.min(dim - 1, askerCol + radius); col++) {
                // Exclude the asker itself from the neighbors
                if (row != askerRow || col != askerCol) {
                    neighbors.add(cells[row][col]);
                }
            }
        }
        return neighbors; //Unsure if notifySubscribers(); should be here
    }

    // cell phases:
    public void observe() {
        // call each cell's observe method and notify subscribers
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                if (cells[row][col] != null) {
                    cells[row][col].observe();
                    notifySubscribers();
                }
            }
        }
    }
    //During the (optional) interaction phase each cell interacts with a random neighbor.
    public void interact () {
            // ???
        Random random = new Random();
        Set<Cell> neighbors = null;
        // Iterate through each cell in the grid
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                Cell currentCell = cells[row][col];
                // Get the list of neighbors for the current cell
                neighbors = getNeighbors(currentCell, 1);
                // If the current cell has neighbors
                if (!neighbors.isEmpty()) {
                    // Choose a random neighbor
                    int randomIndex = random.nextInt(neighbors.size());
                    Cell ranNeighbor = (Cell) neighbors.toArray()[randomIndex];
                    // Perform interaction between the current cell and the random neighbor
                    currentCell.interact(ranNeighbor); // interact() method in cell takes randomNeighbor as param
                }
            }
        }
        notifySubscribers(); //Unsure if notifySubscribers(); should be here
    }
    //In the update phase each cell changes its state according to information gathered in the previous phases.
    //Different CAs and different cell types within a CA may have different rules for how to update themselves.
    public void update () {
            // ???
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                cells[row][col].update();
            }
        }
        notifySubscribers(); //Unsure if notifySubscribers(); should be here
    }
    public void updateLoop ( int cycles){
        observe();
        for (int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
            System.out.println("time = " + time);
        }
    }
}