package com.mdt.gui.mazeitems;
import com.mdt.gui.mazeitems.MazeGrid;
import com.mdt.maze.MazeDimensions;

import javax.swing.*;
import java.awt.*;

/**
 * Editing canvas containing the maze
 */
public class MazeCanvasPanel extends JPanel {
    /**
     * Creates a new maze canvas panel
     * @param mazeDimensions dimensions of the maze
     */
    public MazeCanvasPanel(MazeDimensions mazeDimensions) {
        super(new BorderLayout());
        this.setBackground(Color.WHITE);
        MazeGrid mazeGrid = new MazeGrid(mazeDimensions);

        JPanel canvasContainer = new JPanel(new FlowLayout());
        canvasContainer.add(mazeGrid);
        JScrollPane canvasScrollPane = new JScrollPane(canvasContainer);
        canvasScrollPane.setBorder(BorderFactory.createEmptyBorder());
        this.add(canvasScrollPane, BorderLayout.CENTER);
    }
}
