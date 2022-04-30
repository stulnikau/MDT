package com.mdt.mazegenerate;

import com.mdt.maze.MazeLayout;

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
     * @param w width of the maze in cells
     * @param h height of the maze in cells
     * @param startEndLoc locations of maze start and end
     * @return Auto-generated maze layout. Returns null
     * if maze layout is not possible given the parameters
     */
    public MazeLayout generateMazeLayout(int w, int h, int[][] startEndLoc) {
        return null;
    }

    /**
     * Automatically generates a new maze with logo(s) inside
     * @param w width of the maze in cells
     * @param h height of the maze in cells
     * @param startEndLoc locations of maze start and end
     * @param logoDimensions dimensions of logos to be included
     *                       in the auto-generated maze
     * @return Auto-generated maze layout. Returns null
     * if maze layout is not possible given the parameters
     */
    public MazeLayout generateMazeLayout(int w, int h, int[][] startEndLoc, int[] logoDimensions) {
        return null;
    }

    /**
     * Automatically generates a new maze with start/end images inside
     * @param w width of the maze in cells
     * @param h height of the maze in cells
     * @param startEndLoc locations of maze start and end
     * @param startEndDimensions dimensions of start/end images to be included
     *                           in the auto-generated maze
     * @return Auto-generated maze. Returns null
     * if maze layout is not possible given the parameters
     */
    public MazeLayout generateMazeLayout(int w, int h, int[][] startEndLoc, int[][] startEndDimensions) {
        return null;
    }

    /**
     * Automatically generates a new maze with logo(s) and start/end images inside
     * @param w width of the maze in cells
     * @param h height of the maze in cells
     * @param startEndLoc locations of maze start and end
     * @param logoDimensions dimensions of any logos to be included
     *                       in the auto-generated maze
     * @param startEndDimensions dimensions of start/end images to be included
     *                           in the auto-generated maze
     * @return Auto-generated maze. Returns null
     * if maze layout is not possible given the parameters
     */
    public MazeLayout generateMazeLayout(int w, int h, int[][] startEndLoc, int[] logoDimensions, int[][] startEndDimensions) {
        return null;
    }
}
