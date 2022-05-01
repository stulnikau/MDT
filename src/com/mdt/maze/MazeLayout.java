package com.mdt.maze;

import com.mdt.gui.mazeitems.MazeGrid;

/**
 * Container for storing the maze layout
 */
public class MazeLayout {
    private String[] encodedLayout;

    /**
     * Creates a new maze layout instance from the provided mazeGrid
     * @param mazeGrid maze grid to translate into a layout
     */
    public MazeLayout(MazeGrid mazeGrid) {

    }

    /**
     * Creates an empty maze layout with exits in provided locations
     * @param startEndLoc start and end locations in the maze
     */
    public MazeLayout(MazeLocation startEndLoc) {

    }

    /**
     * Returns the dimensions of the maze layout
     * @return dimensions of the maze layout
     */
    public MazeDimensions getMazeDimensions() {
        return null;
    }
}
