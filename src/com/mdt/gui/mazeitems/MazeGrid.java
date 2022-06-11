package com.mdt.gui.mazeitems;

import com.mdt.maze.MazeDimensions;

import javax.swing.*;
import java.awt.*;

/**
 * Panel to contain the maze grid. By default,
 * creates a dotted panel with outside walls,
 * an entrance in top left, and an exit in bottom
 * right
 */
public class MazeGrid extends JPanel {
    public int rows;
    public int cols;

    /**
     * Creates a new maze grid with the specified dimensions
     * @param mazeDimensions Width and height of the maze in cells
     */
    public MazeGrid(MazeDimensions mazeDimensions) {
        super(new GridLayout(0, mazeDimensions.getWidth()));
        this.rows = mazeDimensions.getHeight();
        this.cols = mazeDimensions.getWidth();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                this.add(new MazeCellPanel(defaultCellStatus(row, col)));
            }
        }
    }

    /**
     * Determine whether a maze cell created must be set as a wall
     * by default. Maze cells are set by default if adjacent to
     * the outside border of the maze.
     * @param row Row of the cell created
     * @param col Column of the cell created
     * @return Boolean indicating whether the maze cell
     * must be set as a wall by default
     */
    private boolean defaultCellStatus(int row, int col) {
        if (row == 0 || row == rows - 1) {
            return true;
        }
        return col == 0 || col == cols - 1;
    }
}
