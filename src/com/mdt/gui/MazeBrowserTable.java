package com.mdt.gui;

import com.mdt.Program;

import javax.swing.*;

/**
 * Table to browse previously created mazes. Connects to the
 * maze database using the instance in the Program class.
 * @see com.mdt.mazedatabase.MazeDatabase
 * @see Program
 */
public class MazeBrowserTable extends JTable {
    /**
     * Creates a new maze database table viewer in the GUI
     */
    public MazeBrowserTable() {
        super(
                Program.mazeDatabase.getRowData(),
                Program.mazeDatabase.getColHeads()
        );
        this.setAutoCreateRowSorter(true);

        // Styling
        this.setShowGrid(false);
        this.setShowHorizontalLines(true);
    }
}
