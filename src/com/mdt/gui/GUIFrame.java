package com.mdt.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The top-level container of the application. All GUI panels and elements
 * are placed within GUIFrame.
 * The class defines static constants for fonts and other resources
 * used across the GUI. It also adds itself as an action listener for
 * JButtons in child classes.
 */
public class GUIFrame extends JFrame implements ActionListener, Runnable {
    // Define some fonts for use application-wide
    public static final Font SYSTEM_FONT = new JLabel().getFont(); // Default system font
    public static final Font HEADING_1 = GUIFrame.SYSTEM_FONT.deriveFont(Font.BOLD, 30.0F); // Large heading
    public static final Font HEADING_2 = GUIFrame.SYSTEM_FONT.deriveFont(Font.BOLD, 24.0F); // Medium heading
    public static final Font HEADING_3 = GUIFrame.SYSTEM_FONT.deriveFont(Font.BOLD, 16.0F); // Small heading

    private LandingPanel landingPanel;
    private AddMetadataPanel addMetadataPanel;

    private JPanel mainPanel;
    private CardLayout cardLayout;

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread
     */
    private void createAndShowGUI() {
        // Frame setup
        super.setTitle("Welcome to Maze Design Tool");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Main JPanel setup
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add components
        // Panel for the Landing screen
        landingPanel = new LandingPanel();
        mainPanel.add(landingPanel, "Landing");
        // Panel for adding metadata when creating a new maze
        addMetadataPanel = new AddMetadataPanel();
        mainPanel.add(addMetadataPanel, "AddMetadata");

        // Add mainPanel to JFrame
        this.getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Adding action listeners
        landingPanel.landingControlPanel.newMaze.addActionListener(this);
        landingPanel.landingControlPanel.exportItems.addActionListener(this);

        // Pack components
        this.pack();
        // Place the window in the middle of the screen
        this.setLocationRelativeTo(null);
        // Set window to visible
        this.setVisible(true);
    }

    /**
     * Creates and shows the GUI JFrame
     */
    @Override
    public void run() {
        createAndShowGUI();
    }

    /**
     * Actions taken when the user selects to create a new maze
     */
    public void showNewMazeDialog() {
        // Show add metadata panel
        super.setTitle("New Maze");
        cardLayout.show(mainPanel, "AddMetadata");
    }

    /**
     * Processes an ActionEvent
     * @param e ActionEvent originating from a component
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        // Handle button presses
        if (src == landingPanel.landingControlPanel.newMaze) {
            showNewMazeDialog();
        } else if (src == landingPanel.landingControlPanel.exportItems) {
            int[] rowsToExport = landingPanel.mazeBrowserTable.getSelectedRows();
            // Link to export dialog
        }
    }
}
