package com.mdt.maze;

import com.mdt.gui.mazeitems.MazeGridPanel;

import java.util.List;
import java.util.Vector;

/**
 * Logical representation of a maze. Contains
 * maze metadata and layout.
 */
public class Maze {
    private final MazeGridPanel mazeGridPanel;
    private final MazeMetadata mazeMetadata;

    /**
     * Creates a new Maze instance
     * @param mazeGridPanel visual representation of the maze
     * @param mazeMetadata maze metadata
     */
    public Maze(MazeMetadata mazeMetadata, MazeGridPanel mazeGridPanel) {
        this.mazeMetadata = mazeMetadata;
        this.mazeGridPanel = mazeGridPanel;
    }

    /**
     * Gets the metadata of the maze
     * @return maze metadata
     */
    public MazeMetadata getMazeMetadata() {
        return mazeMetadata;
    }

    /**
     * Returns a maze grid that is a visual representation of the maze
     * @return maze grid
     */
    public MazeGridPanel getMazeGrid() {
        return mazeGridPanel;
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
     * Retrieves an optimal solution to the maze
     * @return Optimal solution to the maze in the form
     * of a list of grid values. Returns null if
     * no solution exists
     */
    public List<MazeLocation> getOptimalSolution() {
        return null;
    }
}
