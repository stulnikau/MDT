package com.mdt.gui;
import javax.swing.*;
import java.awt.*;

public class MazeCanvasPanel extends JPanel {

    public MazeCanvasPanel() {
        super(new BorderLayout());
        this.setBackground(Color.WHITE);
        int rows = 15;
        int cols = 16;
        MazeGrid mazeGrid = new MazeGrid(rows, cols);

        JScrollPane canvasScrollPane = new JScrollPane(mazeGrid);
        canvasScrollPane.setBorder(BorderFactory.createEmptyBorder());
        this.add(canvasScrollPane, BorderLayout.CENTER);
    }
}
