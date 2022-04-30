package com.mdt.maze;

import com.mdt.gui.mazeitems.MazeGrid;

import javax.swing.*;
import java.util.Date;

/**
 * Logical representation of a maze. Contains
 * maze metadata and layout.
 */
public class Maze {
    private MazeLayout mazeLayout;
    private String mazeId;
    private String mazeName;
    private String mazeAuthor;
    private Date createdDate;
    private Date lastModifiedDate;
    private int width;
    private int height;

    /**
     * Creates a new Maze instance. Saves the created and last
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
    private void refreshLastModifiedDate() {

    }

    /**
     * Gets the name of the maze
     * @return maze name
     */
    public String getMazeName() {
        return null;
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
     * Gets the dimensions of the maze in width, height format
     * @return width, height of the maze (in cells)
     */
    public int[] getMazeDimensions() {
        return null;
    }

    /**
     * Gets the maze layout of the maze
     * @return maze layout of the maze
     */
    public MazeLayout getMazeLayout() {
        return null;
    }

    /**
     * Automatically generates a new maze using the MazeLayoutGenerator
     * class. Uses any logos and/or start/end images already
     * placed on the canvas in the generation process
     * @see com.mdt.mazegenerate.MazeLayoutGenerator
     */
    public void autogenerateMaze() {

    }

    /**
     * Returns a maze grid that is a visual representation of the maze
     */
    public MazeGrid getVisual() {
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
    public void addLogo(ImageIcon logo, int[] logoLocation, int[] logoDimensions) {

    }

    /**
     * Adds start and end images to be used instead of wall openings in the maze
     * @param startImage Image used for the start of the maze
     * @param endImage Image used for the end of the maze
     * @param imageLocations Start and end image locations on the maze grid
     * @param imageDimensions Start and end image dimensions on the maze grid
     */
    public void addStartAndEndImages(ImageIcon startImage, ImageIcon endImage,
                                     int[][] imageLocations, int[][] imageDimensions) {

    }

    /**
     * Retrieves an optimal solution to the maze
     * @return Optimal solution to the maze in the form
     * of a list of grid values. Returns null if
     * no solution exists
     */
    public int[][] getOptimalSolution() {
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
