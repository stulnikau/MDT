package com.mdt.gui.mazeitems;

import com.mdt.maze.MazeDimensions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Panel to contain the maze grid. By default,
 * creates a dotted panel with outside walls,
 * an entrance in top left, and an exit in bottom
 * right
 */
public class MazeGridPanel extends JPanel {
    public int rows;
    public int cols;
    private ImageIcon entryIcon;
    private ImageIcon exitIcon;

    // Default side dimension for the cell
    private static final int DEFAULT_SIDE_DIM = 25;

    /**
     * Creates a new maze grid with the specified dimensions
     * @param mazeDimensions Width and height of the maze in cells
     */
    public MazeGridPanel(MazeDimensions mazeDimensions) {
        super(new GridLayout(0, mazeDimensions.getWidth()));
        try {
            this.entryIcon = getMazeBackgroundImageIcon("arrow.png");
            this.exitIcon = entryIcon;
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        setupGrid(mazeDimensions);
    }

    /**
     * Creates a new maze grid with the specified dimensions and entry/exit icons
     * @param mazeDimensions Width and height of the maze in cells
     * @param startImage entry icon
     * @param endImage exit icon
     */
    public MazeGridPanel(MazeDimensions mazeDimensions, File startImage, File endImage) {
        super(new GridLayout(0, mazeDimensions.getWidth()));
        try {
            this.entryIcon = getMazeBackgroundImageIcon(startImage);
            this.exitIcon = getMazeBackgroundImageIcon(endImage);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        setupGrid(mazeDimensions);
    }

    /**
     * Sets up the maze grid layout
     * @param mazeDimensions Width and height of the maze in cells
     */
    private void setupGrid(MazeDimensions mazeDimensions) {
        this.rows = mazeDimensions.getHeight();
        this.cols = mazeDimensions.getWidth();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (entryCell(row, col)) {
                    this.add(new MazeImageCellPanel(entryIcon, true));
                } else if (exitCell(row, col)) {
                    this.add(new MazeImageCellPanel(exitIcon, true));
                } else {
                    this.add(new MazeCellPanel(defaultCellStatus(row, col)));
                }
            }
        }
    }

    /**
     * Generates an image from a filename
     * @param filename Image filename
     * @return Image suitable to be placed in a maze
     * @throws IOException exception if file not found
     */
    private ImageIcon getMazeBackgroundImageIcon(String filename) throws IOException {
        return new ImageIcon(ImageIO
                .read(Objects.requireNonNull(getClass().getResource(filename)))
                .getScaledInstance(DEFAULT_SIDE_DIM, DEFAULT_SIDE_DIM, Image.SCALE_SMOOTH));
    }

    /**
     * Generates an image from a file
     * @param file Image file
     * @return Image suitable to be placed in a maze
     * @throws IOException exception if file not found
     */
    private ImageIcon getMazeBackgroundImageIcon(File file) throws IOException {
        return new ImageIcon(ImageIO
                .read(file)
                .getScaledInstance(DEFAULT_SIDE_DIM, DEFAULT_SIDE_DIM, Image.SCALE_SMOOTH));
    }

    /**
     * Determine whether a maze cell created must be set as a wall
     * by default. Maze cells are set by default if adjacent to
     * the outside border of the maze.
     * @param row Row of the cell created
     * @param col Column of the cell created
     * @return Boolean indicating whether the maze cell
     * must be set as a wall by default
     */
    private boolean defaultCellStatus(int row, int col) {
        if (row == 0 || row == rows - 1) {
            return true;
        }
        return col == 0 || col == cols - 1;
    }

    /**
     * Determine whether the cell is an entry cell
     * @param row Row of the cell created
     * @param col Column of the cell created
     * @return Boolean indicating whether the maze cell
     * is an entry cell
     */
    private boolean entryCell(int row, int col) {
        // Entry cell
        return row == 0 && col == 1;
    }

    /**
     * Determine whether the cell is an exit cell
     * @param row Row of the cell created
     * @param col Column of the cell created
     * @return Boolean indicating whether the maze cell
     * is an exit cell
     */
    private boolean exitCell(int row, int col) {
        // Exit cell
        return row == rows - 1 && col == cols - 2;
    }
}
