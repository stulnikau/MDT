package com.mdt.gui.mazeitems;
import com.mdt.gui.mazeitems.MazeGrid;

import javax.swing.*;
import java.awt.*;

/**
 * Editing canvas containing the maze
 */
public class MazeCanvasPanel extends JPanel {

    /**
     * Creates a new maze canvas panel
     */
    public MazeCanvasPanel() {
        super(new BorderLayout());
        this.setBackground(Color.WHITE);
        int rows = 8;
        int cols = 9;
        MazeGrid mazeGrid = new MazeGrid(rows, cols);

        JScrollPane canvasScrollPane = new JScrollPane(mazeGrid);
        canvasScrollPane.setBorder(BorderFactory.createEmptyBorder());
        this.add(canvasScrollPane, BorderLayout.CENTER);
    }
}
