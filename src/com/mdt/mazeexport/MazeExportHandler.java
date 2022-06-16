package com.mdt.mazeexport;

import com.mdt.gui.mazeitems.MazeGridPanel;
import com.mdt.maze.Maze;
import com.mdt.maze.MazeDimensions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
     * a line showing the optimal solution.
     *
     * Implementation uses hints from Stack Overflow (see below)
     * Ref: https://stackoverflow.com/questions/17690275/exporting-a-jpanel-to-an-image
     * @param maze maze to be exported
     */
    public void exportMaze(Maze maze) {
        MazeGridPanel mazeGridPanel = maze.getMazeGrid();
        if (mazeGridPanel.getMazeDimensions().getWidth() > 100
            || mazeGridPanel.getMazeDimensions().getHeight() > 100) {
            throw new IllegalArgumentException("Maze grid cannot be exported as it exceeds dimensions of 100 by 100 cells");
        }
        mazeGridPanel.showSolution(includeSolution);
        mazeGridPanel.setSize(mazeGridPanel.getPreferredSize());

        BufferedImage image = new BufferedImage(
                mazeGridPanel.getWidth(),
                mazeGridPanel.getHeight(),
                BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        mazeGridPanel.printAll(graphics);
        graphics.dispose();
        try {
            ImageIO.write(
                    image,
                    "png",
                    new File(exportDirectory + maze.getMazeMetadata().getFileName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
