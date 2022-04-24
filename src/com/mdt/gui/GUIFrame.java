package com.mdt.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The top-level container of the application. All GUI panels and elements
 * are placed within GUIFrame.
 * The class also defines static constants for fonts and other resources
 * used across the GUI.
 */
public class GUIFrame extends JFrame implements ActionListener, Runnable {
    // Define some fonts for use application-wide
    public static final Font SYSTEM_FONT = new JLabel().getFont(); // Default system font
    public static final Font HEADING_1 = GUIFrame.SYSTEM_FONT.deriveFont(Font.BOLD, 30.0F);
    public static final Font HEADING_2 = GUIFrame.SYSTEM_FONT.deriveFont(Font.BOLD, 24.0F);
    public static final Font HEADING_3 = GUIFrame.SYSTEM_FONT.deriveFont(Font.BOLD, 20.0F);

    LandingPanel landingPanel;

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread
     */
    private void createAndShowGUI() {
        // Frame setup
        super.setTitle("Welcome to Maze Design Tool");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Add components
        // Panel for the Landing screen
        landingPanel = new LandingPanel();
        this.getContentPane().add(landingPanel, BorderLayout.CENTER);

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
     * Processes an ActionEvent
     * @param e ActionEvent originating from a component
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
