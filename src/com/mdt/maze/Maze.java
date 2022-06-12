package com.mdt.maze;

import com.mdt.gui.mazeitems.MazeGridPanel;

import java.util.List;

/**
 * Logical representation of a maze. Contains
 * maze metadata and layout.
 */
public class Maze {
    private MazeLayout mazeLayout;
    private MazeMetadata mazeMetadata;
    private MazeDimensions mazeDimensions;

    /**
     * Creates a new Maze instance. Saves the created and last
     * modified date of the maze
     * @param mazeName name of the maze
     * @param authorName name of the maze author
     */
    public Maze(String mazeName, String authorName) {

    }

    /**
     * Gets the metadata of the maze
     * @return maze metadata
     */
    public MazeMetadata getMazeMetadata() {
        return null;
    }

    /**
     * Gets the dimensions of the maze in width, height format
     * @return width, height of the maze (in cells)
     */
    public MazeDimensions getMazeDimensions() {
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
    public MazeGridPanel getVisual() {
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
     * @param mazeGridPanel Visual representation of the maze
     */
    public void bindMazeGrid(MazeGridPanel mazeGridPanel) {

    }

    /**
     * Saves a logo present inside the maze
     * @param mazeLogo logo to be added
     */
    public void addLogo(MazeLogo mazeLogo) {

    }

    /**
     * Adds start and end images to be used instead of wall openings in the maze
     * @param startImage Image used for the start of the maze
     * @param endImage Image used for the end of the maze
     */
    public void addStartAndEndImages(MazeStartEndImage startImage, MazeStartEndImage endImage) {

    }

    /**
     * Retrieves an optimal solution to the maze
     * @return Optimal solution to the maze in the form
     * of a list of grid values. Returns null if
     * no solution exists
     */
    public List<MazeLocation> getOptimalSolution() {
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
