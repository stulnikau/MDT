package com.mdt.gui;

import com.mdt.gui.generics.ProgressControlPanel;
import com.mdt.gui.mazeitems.MazeCanvasPanel;
import com.mdt.maze.MazeDimensions;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Panel that contains the canvas for editing the maze
 */
public class MazeGenerationPanel extends JPanel {
    public PropertiesPanel propertiesPanel;
    public MazeCanvasPanel mazeCanvasPanel;
    public ProgressControlPanel progressControlPanel;
    private MazeDimensions mazeDimensions;

    /**
     * Creates a new panel for generating a maze
     */
    public MazeGenerationPanel() {
        super(new BorderLayout());
        propertiesPanel = new PropertiesPanel();
        // Creates a maze canvas with a default value that will be overridden
        // by a method invoked when the user selects the maze dimensions
        mazeDimensions = new MazeDimensions(25, 25);
        mazeCanvasPanel = new MazeCanvasPanel(mazeDimensions);
        progressControlPanel = new ProgressControlPanel("Save and Exit", "Cancel");

        this.add(propertiesPanel, BorderLayout.EAST);
        this.add(mazeCanvasPanel, BorderLayout.CENTER);
        this.add(progressControlPanel, BorderLayout.SOUTH);
    }

    /**
     * Sets the maze dimensions for the new maze
     * @param mazeDimensions dimensions of the new maze
     */
    public void setMazeDimensions(MazeDimensions mazeDimensions) {
        this.mazeDimensions = mazeDimensions;
        this.remove(mazeCanvasPanel);
        mazeCanvasPanel = new MazeCanvasPanel(this.mazeDimensions);
        this.add(mazeCanvasPanel, BorderLayout.CENTER);
    }

    public void setMazeStartEndImages(File startImage, File endImage) {
        this.remove(mazeCanvasPanel);
        mazeCanvasPanel = new MazeCanvasPanel(mazeDimensions, startImage, endImage);
        this.add(mazeCanvasPanel, BorderLayout.CENTER);
    }
}


