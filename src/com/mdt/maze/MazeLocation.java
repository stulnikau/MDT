package com.mdt.maze;

import java.io.Serializable;

/**
 * Describes any location on the maze
 */
public class MazeLocation implements Serializable {
    private final int row;
    private final int col;

    /**
     * Creates a maze location instance
     * @param row row on the maze
     * @param col column on the maze
     */
    public MazeLocation(int row, int col) {
        if (row < 1 || col < 1) {
            throw new IllegalArgumentException("row and column must be positive");
        }
        this.row = row;
        this.col = col;
    }

    /**
     * Gets the row of the location
     * @return row on the maze
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column of the location
     * @return column on the maze
     */
    public int getCol() {
        return col;
    }
}
