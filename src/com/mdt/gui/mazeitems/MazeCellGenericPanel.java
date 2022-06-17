package com.mdt.gui.mazeitems;

import javax.swing.*;
import java.awt.*;

public abstract class MazeCellGenericPanel extends JPanel {
    /**
     * Highlight the cell if part of the maze solution
     */
    public abstract void highlightSolution();

    /**
     * Return cell to regular state, un-highlighted
     */
    public abstract void unhighlightSolution();

    /**
     * Check if the cell is a wall
     * @return boolean indicating whether the cell is a wall
     */
    public abstract boolean isWall();

    /**
     * New generic maze cell panel
     * @param layoutManager layout manager to be used by the panel
     */
    public MazeCellGenericPanel(LayoutManager layoutManager) {
        super(layoutManager);
    }
}
