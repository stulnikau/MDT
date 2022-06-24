package com.mdt.gui;

import com.mdt.mazedatabase.MazeDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel displayed on startup. Includes options to create a new maze or
 * to export previous mazes from a table list. The options at the top of
 * the panel are displayed by the LandingControlPanel panel. The list of
 * previous mazes is contained in a JScrollPane that holds the
 * MazeBrowserTable table. Action listeners for JButtons are defined in
 * the GUIFrame class.
 * @see LandingControlPanel
 * @see MazeBrowserTable
 */
public class LandingPanel extends JPanel {
    public final LandingControlPanel landingControlPanel;
    public final MazeBrowserTable mazeBrowserTable;

    /**
     * Creates a new LandingPanel to be viewed in the GUI
     * @param mazeDatabase maze database reference acting as provider of
     *                     the list of mazes displayed in the maze table
     */
    public LandingPanel(MazeDatabase mazeDatabase) {
        super(new BorderLayout());

        landingControlPanel = new LandingControlPanel();
        mazeBrowserTable = new MazeBrowserTable(mazeDatabase);
        JScrollPane mazeBrowserScrollPane = new JScrollPane(mazeBrowserTable);
        mazeBrowserScrollPane.setBorder(BorderFactory.createEmptyBorder());
        this.add(landingControlPanel, BorderLayout.NORTH);
        this.add(mazeBrowserScrollPane, BorderLayout.CENTER);

        // Add some padding on the sides
        this.add(Box.createHorizontalStrut(GUIFrame.PADDING_WIDTH), BorderLayout.EAST);
        this.add(Box.createHorizontalStrut(GUIFrame.PADDING_WIDTH), BorderLayout.WEST);
    }
}
