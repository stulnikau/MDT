package com.mdt.maze;

import com.mdt.gui.MazeGrid;

import javax.swing.*;

/**
 * Logical representation of a maze. Contains
 * maze metadata and layout.
 */
public class Maze {

    /**
     * Creates a new maze. Saves the created and last
     * modified date of the maze
     * @param mazeName name of the maze
     * @param authorName name of the maze author
     */
    public Maze(String mazeName, String authorName) {

    }

    /**
     * Sets a new last modified date of the maze based on
     * the current time
     */
    private void setNewLastModifiedDate() {

    }

    /**
     * Gets the metadata of the maze
     * @return maze name, author name, created date and last
     * modified date
     */
    public String[] getMazeMetadata() {
        return null;
    }

    /**
     * Gets the percentage of cells that are reached by the
     * optimal solution to the maze
     * @return number of cells expressed as a percentage of
     * the total number of cells in the maze. Returns 0 if
     * no solution exists
     */
    public double getCellsReachedByOptimalSolution() {
        return 0;
    }

    /**
     * Gets the percentage of cells that are dead ends
     * @return number of cells expressed as a percentage of
     * the total number of cells in the maze
     */
    public double getDeadEndCells() {
        return 0;
    }

    /**
     * Binds the provided maze grid panel to the maze
     * @param mazeGrid Visual representation of the maze
     */
    public void bindMazeGrid(MazeGrid mazeGrid) {

    }

    /**
     * Saves a logo present inside the maze
     * @param logo Image of the logo
     * @param logoLocation Location of the logo on the grid
     * @param logoDimensions Dimensions of the logo on the grid
     */
    public void addLogo(ImageIcon logo, String[] logoLocation, String[] logoDimensions) {

    }

    /**
     * Adds start and end images to be used instead of wall openings in the maze
     * @param startImage Image used for the start of the maze
     * @param endImage Image used for the end of the maze
     * @param imageLocations Start and end image locations on the maze grid
     * @param imageDimensions Start and end image dimensions on the maze grid
     */
    public void addStartAndEndImages(ImageIcon startImage, ImageIcon endImage,
                                     String[] imageLocations, String[] imageDimensions) {

    }

    /**
     * Retrieves an optimal solution to the maze
     * @return Optimal solution to the maze in the form
     * of a list of grid values. Returns null if
     * no solution exists
     */
    public String[] getOptimalSolution() {
        return null;
    }

    /**
     * Get the maze in an encoded string form suitable for
     * storage
     * @return maze encoded in a storage format
     */
    public String[] getEncodedMaze() {
        return null;
    }
}
