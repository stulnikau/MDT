package com.mdt.maze;

/**
 * Describes any location on the maze
 */
public class MazeLocation {
    private int row;
    private int col;

    /**
     * Creates a maze location instance
     * @param row row on the maze
     * @param col column on the maze
     */
    public MazeLocation(int row, int col) {

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
