package com.mdt.gui;

import com.mdt.Program;
import com.mdt.mazedatabase.MazeDatabase;

import javax.swing.*;

/**
 * Table to browse previously created mazes. Connects to the
 * maze database using the instance in the GUIFrame class.
 * @see com.mdt.mazedatabase.MazeDatabase
 */
public class MazeBrowserTable extends JTable {
    /**
     * Creates a new maze database table viewer in the GUI
     */
    public MazeBrowserTable(MazeDatabase mazeDatabase) {
        super(mazeDatabase.getMazeTableModel());
        this.setAutoCreateRowSorter(true);

        // Styling
        this.setShowGrid(false);
        this.setShowHorizontalLines(true);
    }
}
