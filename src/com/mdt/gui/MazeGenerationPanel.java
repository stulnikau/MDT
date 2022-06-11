package com.mdt.gui;

import com.mdt.gui.generics.ProgressControlPanel;
import com.mdt.gui.mazeitems.MazeCanvasPanel;
import com.mdt.maze.MazeDimensions;

import javax.swing.*;
import java.awt.*;

/**
 * Panel that contains the canvas for editing the maze
 */
public class MazeGenerationPanel extends JPanel {
    public PropertiesPanel propertiesPanel;
    public MazeCanvasPanel mazeCanvasPanel;
    public ProgressControlPanel progressControlPanel;

    /**
     * Creates a new panel for generating a maze
     */
    public MazeGenerationPanel() {
        super(new BorderLayout());
        propertiesPanel = new PropertiesPanel();
        // Creates a maze canvas with a default value that will be overridden
        // by a method invoked when the user selects the maze dimensions
        mazeCanvasPanel = new MazeCanvasPanel(new MazeDimensions(25, 25));
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
        this.remove(mazeCanvasPanel);
        mazeCanvasPanel = new MazeCanvasPanel(mazeDimensions);
        this.add(mazeCanvasPanel, BorderLayout.CENTER);
    }
}


