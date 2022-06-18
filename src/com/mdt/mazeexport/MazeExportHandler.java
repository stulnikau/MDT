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
        if (mazeGridPanel.getMazeDimensions().getLargestSide() > 100) {
            throw new IllegalArgumentException("Maze grid cannot be exported as it exceeds dimensions of 100 by 100 cells");
        }
        mazeGridPanel.setSize(mazeGridPanel.getPreferredSize());

        double scalingFactor = getScalingFactor(mazeGridPanel.getMazeDimensions().getLargestSide());
        int imageWidth = (int) (mazeGridPanel.getMazeDimensions().getWidth() * scalingFactor);
        int imageHeight = (int) (mazeGridPanel.getMazeDimensions().getHeight() * scalingFactor);
        BufferedImage originalImage = new BufferedImage(
                mazeGridPanel.getWidth(),
                mazeGridPanel.getHeight(),
                BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = originalImage.createGraphics();
        if (includeSolution) {
            mazeGridPanel.showSolution();
        }
        mazeGridPanel.printAll(graphics);
        graphics.dispose();
        try {
            BufferedImage resizedImage = resizeImage(originalImage, imageWidth, imageHeight);
            String format = "png";
            ImageIO.write(
                    resizedImage,
                    format,
                    new File(exportDirectory, maze.getMazeMetadata().getFileName() + "." + format));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Resizes a BufferedImage to a new size
     * Ref: https://www.baeldung.com/java-resize-image
     * @param originalImage original size image
     * @param targetWidth desired width
     * @param targetHeight desired height
     * @return resized image
     * @throws IOException if operation fails due to an I/O exception
     */
    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

    /**
     * Determines the image size scaling factor to be used for a given
     * maze with the largest side cells
     * @param maxCells the number of cells in the largest side of the maze
     * @return the scaling factor to be used for the image size
     */
    private double getScalingFactor(int maxCells) {
        // Equation that returns 64 when maxCells = 4
        // and 16 when maxCells = 100
        return -0.5 * maxCells + 66;
    }
}
