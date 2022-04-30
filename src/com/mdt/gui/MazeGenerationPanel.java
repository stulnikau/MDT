package com.mdt.gui;

import com.mdt.gui.generics.ProgressControlPanel;
import com.mdt.gui.mazeitems.MazeCanvasPanel;

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
        mazeCanvasPanel = new MazeCanvasPanel();
        progressControlPanel = new ProgressControlPanel("Finish", "Back");

        this.add(propertiesPanel, BorderLayout.EAST);
        this.add(mazeCanvasPanel, BorderLayout.CENTER);
        this.add(progressControlPanel, BorderLayout.SOUTH);
    }
}


