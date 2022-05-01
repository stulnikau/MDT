package com.mdt.mazegenerate;

import com.mdt.maze.*;

/**
 * Handles the automatic generation of maze layouts
 */
public class MazeLayoutGenerator {

    /**
     * Creates a new maze layout auto-generator
     */
    public MazeLayoutGenerator() {

    }

    /**
     * Automatically generates a new maze
     * @param layoutSize size of desired maze layout
     * @param startLoc location of maze start (may include a start image)
     * @param endLoc location of maze end (may include an end image)
     * @return Auto-generated maze layout. Returns null
     * if maze layout is not possible given the parameters
     */
    public MazeLayout generateMazeLayout(MazeDimensions layoutSize, MazeEntryExitPoint startLoc, MazeEntryExitPoint endLoc) {
        return null;
    }

    /**
     * Automatically generates a new maze with logo(s) inside
     * @param layoutSize size of desired maze layout
     * @param startLoc location of maze start (may include a start image)
     * @param endLoc location of maze end (may include an end image)
     * @param mazeLogo logo to be included in the maze
     * @return Auto-generated maze layout. Returns null
     * if maze layout is not possible given the parameters
     */
    public MazeLayout generateMazeLayout(MazeDimensions layoutSize, MazeEntryExitPoint startLoc, MazeEntryExitPoint endLoc, MazeLogo mazeLogo) {
        return null;
    }
}
