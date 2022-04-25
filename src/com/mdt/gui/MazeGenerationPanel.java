package com.mdt.gui;

import com.mdt.gui.generics.ProgressControlPanel;

import javax.swing.*;
import java.awt.*;

public class MazeGenerationPanel extends JPanel {
    public PropertiesPanel propertiesPanel;
    public MazeCanvasPanel mazeCanvasPanel;
    public ProgressControlPanel progressControlPanel;

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


