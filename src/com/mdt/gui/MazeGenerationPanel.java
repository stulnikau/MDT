package com.mdt.gui;

import com.mdt.gui.adapters.ShowSolutionListener;
import com.mdt.gui.generics.ProgressControlPanel;
import com.mdt.gui.mazeitems.MazeCanvasPanel;
import com.mdt.maze.MazeDimensions;
import com.mdt.maze.MazeLogo;

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
    private boolean useStartEndImages;
    private boolean useLogo;
    private File startImage;
    private File endImage;
    private MazeLogo logo;

    /**
     * Creates a new panel for generating a maze
     */
    public MazeGenerationPanel(ShowSolutionListener listener) {
        super(new BorderLayout());
        propertiesPanel = new PropertiesPanel(listener);
        // Creates a maze canvas with a default value that will be overridden
        // by a method invoked when the user selects the maze options
        mazeDimensions = new MazeDimensions(25, 25);
        mazeCanvasPanel = new MazeCanvasPanel(mazeDimensions);
        progressControlPanel = new ProgressControlPanel("Save and Exit", "Cancel");
        useStartEndImages = false;

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
    }

    /**
     * Sets the maze start and end to supplied images
     * @param startImage file for the maze start image
     * @param endImage file for the maze end image
     */
    public void setMazeStartEndImages(File startImage, File endImage) {
        this.startImage = startImage;
        this.endImage = endImage;
        useStartEndImages = true;
    }

    /**
     * Specifies a logo to be displayed within the maze
     * @param logo maze logo
     */
    public void setMazeLogo(MazeLogo logo) {
        useLogo = true;
        this.logo = logo;
    }

    /**
     * Repaints the maze canvas with all the settings applied
     */
    public void initialiseWithParams() {
        this.remove(mazeCanvasPanel);
        if (useStartEndImages && useLogo) {
            mazeCanvasPanel = new MazeCanvasPanel(mazeDimensions, startImage, endImage, logo);
        } else if (useStartEndImages) {
            mazeCanvasPanel = new MazeCanvasPanel(mazeDimensions, startImage, endImage);
        } else if (useLogo) {
            mazeCanvasPanel = new MazeCanvasPanel(mazeDimensions, logo);
        } else {
            mazeCanvasPanel = new MazeCanvasPanel(mazeDimensions);
        }
        this.add(mazeCanvasPanel, BorderLayout.CENTER);
        useStartEndImages = false;
        useLogo = false;
    }
}


