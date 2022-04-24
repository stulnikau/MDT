package com.mdt.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel displayed on startup. Includes options to create a new maze or
 * to export previous mazes from a table list. The options at the top of
 * the panel are displayed by the LandingControlPanel panel. The list of
 * previous mazes is contained in a JScrollPane that holds the
 * MazeBrowserTable table.
 * @see LandingControlPanel
 * @see MazeBrowserTable
 */
public class LandingPanel extends JPanel implements ActionListener {
    private final LandingControlPanel landingControlPanel;
    private final MazeBrowserTable mazeBrowserTable;

    /**
     * Creates a new LandingPanel to be viewed in the GUI
     */
    public LandingPanel() {
        super(new BorderLayout());

        landingControlPanel = new LandingControlPanel();
        mazeBrowserTable = new MazeBrowserTable();
        JScrollPane mazeBrowserScrollPane = new JScrollPane(mazeBrowserTable);
        mazeBrowserScrollPane.setBorder(BorderFactory.createEmptyBorder());
        this.add(landingControlPanel, BorderLayout.NORTH);
        this.add(mazeBrowserScrollPane, BorderLayout.CENTER);

        // Add some padding on the sides
        this.add(Box.createHorizontalStrut(30), BorderLayout.EAST);
        this.add(Box.createHorizontalStrut(30), BorderLayout.WEST);
    }

    /**
     * Processes an ActionEvent
     * @param e ActionEvent originating from a component
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        // Handle button presses
        if (src == landingControlPanel.exportItems) {
            int[] rowsToExport = mazeBrowserTable.getSelectedRows();
            // Link to export dialog
        } else if (src == landingControlPanel.newMaze) {
            // Link to new maze dialog
        }

        // Handle any other events
    }
}
