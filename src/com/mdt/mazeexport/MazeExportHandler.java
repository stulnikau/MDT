package com.mdt.mazeexport;

import com.mdt.gui.mazeitems.MazeGridPanel;
import com.mdt.maze.Maze;
import com.mdt.maze.MazeDimensions;

import java.awt.*;

/**
 * Handles exporting mazes as an image file
 */
public class MazeExportHandler {

    private final String exportDirectory;
    private final boolean includeSolution;

    /**
     * Creates a new MazeExportHandler to allow
     * exporting of mazes
     * @param exportDirectory target directory for exported files
     * @param includeSolution flag to include (true) or exclude (false)
     *                         the optimal solution as a line on the maze
     *                         grid
     */
    public MazeExportHandler(String exportDirectory, boolean includeSolution) {
        this.exportDirectory = exportDirectory;
        this.includeSolution = false;
    }

    /**
     * Exports a maze as an image file, with an option to include
     * a line showing the optimal solution
     * @param maze maze to be exported
     */
    public void exportMaze(Maze maze) {

    }

    /**
     * Determines the correct export image pixel size to
     * be used when exporting the maze. This is determined
     * based on the dimensions of the maze grid
     * @param mazeDimensions maze to be exported
     */
    private Dimension getExportImageDimensions(MazeDimensions mazeDimensions) {
        return null;
    }
}
