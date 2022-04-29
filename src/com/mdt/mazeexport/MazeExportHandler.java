package com.mdt.mazeexport;

import com.mdt.gui.MazeGrid;
import com.mdt.maze.Maze;

/**
 * Handles exporting mazes as an image file
 */
public class MazeExportHandler {

    private int mazeHeight;
    private int mazeWidth;

    /**
     * Creates a new MazeExportHandler to allow
     * exporting of mazes
     */
    public MazeExportHandler() {

    }

    /**
     * Exports a maze as an image file, with an option to include
     * a line showing the optimal solution
     * @param maze maze to be exported
     * @param solutionIncluded flag to include (true) or exclude (false)
     *                         the optimal solution as a line on the maze
     *                         grid
     */
    public void exportMaze(Maze maze, boolean solutionIncluded) {

    }

    /**
     * Determines the correct export image pixel size to
     * be used when exporting the maze. This is determined
     * based on the dimensions of the maze grid
     * @param maze maze to be exported
     */
    private void determineExportImageDimensions(Maze maze) {

    }


}
