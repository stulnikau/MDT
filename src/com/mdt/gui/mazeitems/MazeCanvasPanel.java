package com.mdt.gui.mazeitems;
import com.mdt.maze.MazeDimensions;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Editing canvas containing the maze
 */
public class MazeCanvasPanel extends JPanel {

    private final MazeGridPanel mazeGridPanel;

    /**
     * Creates a new maze canvas panel
     * @param mazeDimensions dimensions of the maze
     */
    public MazeCanvasPanel(MazeDimensions mazeDimensions) {
        super(new BorderLayout());
        this.setBackground(Color.WHITE);
        mazeGridPanel = new MazeGridPanel(mazeDimensions);
        setupLayout();
    }

    /**
     * Creates a new maze canvas panel for a maze with start
     * and end images
     * @param mazeDimensions dimensions of the maze
     * @param startImage maze start image
     * @param endImage maze end image
     */
    public MazeCanvasPanel(MazeDimensions mazeDimensions, File startImage, File endImage) {
        super(new BorderLayout());
        this.setBackground(Color.WHITE);
        mazeGridPanel = new MazeGridPanel(mazeDimensions, startImage, endImage);
        setupLayout();
    }

    /**
     * Set up the canvas layout
     */
    private void setupLayout() {
        JPanel canvasContainer = new JPanel(new FlowLayout());
        canvasContainer.add(mazeGridPanel);
        JScrollPane canvasScrollPane = new JScrollPane(canvasContainer);
        canvasScrollPane.setBorder(BorderFactory.createEmptyBorder());
        this.add(canvasScrollPane, BorderLayout.CENTER);
    }
}
