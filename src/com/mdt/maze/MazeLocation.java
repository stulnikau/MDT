package com.mdt.maze;

import java.io.Serializable;

/**
 * Describes any location on the maze
 */
public class MazeLocation implements Serializable, Comparable {
    private final int row;
    private final int col;

    /**
     * Creates a maze location instance
     * @param row row on the maze
     * @param col column on the maze
     */
    public MazeLocation(int row, int col) {
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

    @Override
    public String toString() {
        return row + ", " + col;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Object o) {
        return toString().compareTo(o.toString());
    }
}
