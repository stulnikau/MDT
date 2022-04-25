package com.mdt.gui;

import com.mdt.gui.generics.ProgressControlPanel;

import javax.swing.*;
import java.awt.*;

public class MazeGenerationPanel extends JPanel {
   // public PropertiesPanel propertiesPanel;
    public ImagePropertiesPanel imagePropertiesPanel;
    public MazeCanvasPanel mazeCanvasPanel;
    public ProgressControlPanel progressControlPanel;

    public MazeGenerationPanel() {
        super(new BorderLayout());
        //propertiesPanel = new PropertiesPanel();
        imagePropertiesPanel = new ImagePropertiesPanel();
        mazeCanvasPanel = new MazeCanvasPanel();
        progressControlPanel = new ProgressControlPanel("Finish", "Back");

        this.add(imagePropertiesPanel, BorderLayout.EAST);
        //this.add(propertiesPanel, BorderLayout.EAST);
        this.add(mazeCanvasPanel, BorderLayout.CENTER);
        this.add(progressControlPanel, BorderLayout.SOUTH);



    }



}


