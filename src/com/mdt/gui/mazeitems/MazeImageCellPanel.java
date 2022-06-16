package com.mdt.gui.mazeitems;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class MazeImageCellPanel extends JPanel implements Serializable {
    private final boolean isEntryExit;

    /**
     * Creates a new maze cell/border panel with an embedded image
     * @param cellIcon icon to be included in the cell
     * @param isEntryExit flag specifying if the cell is an entry/exit point
     */
    public MazeImageCellPanel(ImageIcon cellIcon, boolean isEntryExit) {
        super(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JLabel cellIconLabel = new JLabel(cellIcon);
        this.add(cellIconLabel);
        this.isEntryExit = isEntryExit;
    }

    /**
     * Check if the cell is an entry/exit point
     * @return boolean indicating whether the cell is an entry/exit point
     */
    public boolean isEntryExit() {
        return isEntryExit;
    }
}