package com.mdt.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Container for the options to export selected mazes and create a new
 * maze. Contained within LandingPanel
 * @see LandingPanel
 */
public class LandingControlPanel extends JPanel {
    private final JLabel controlPanelHeading;
    public JButton exportItems;
    public JButton newMaze;

    /**
     * Handles the configuration of the panel layout using the
     * GridBagLayout manager.
     */
    private void setupLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.SOUTH;
        c.weighty = 1;

        // Some horizontal padding before the heading
        c.weightx = 0;
        c.gridx = 0;
        this.add(Box.createHorizontalStrut(15), c);

        c.weightx = 1;
        c.gridx = 1;
        this.add(controlPanelHeading, c);

        c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        c.gridx = 2;
        this.add(exportItems, c);

        c.gridx = 3;
        this.add(newMaze, c);

    }

    /**
     * Creates a new LandingControlPanel
     */
    public LandingControlPanel() {
        super(new GridBagLayout());

        controlPanelHeading = new JLabel("Mazes");
        controlPanelHeading.setFont(GUIFrame.HEADING_1);
        exportItems = new JButton("Export Selected...");
        newMaze = new JButton("New Maze");

        setupLayout();
    }
}
