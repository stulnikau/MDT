package com.mdt.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIFrame extends JFrame implements ActionListener, Runnable {
    LandingPanel landingPanel;
    AddMetadataPanel AddMetadataPanel;

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread
     */
    private void createAndShowGUI() {
        // Frame setup
        super.setTitle("Maze Design Tool");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Add components
        // Panel for the Landing screen
        //landingPanel = new LandingPanel();
        //this.getContentPane().add(landingPanel, BorderLayout.CENTER);
        AddMetadataPanel =  new AddMetadataPanel();
        this.getContentPane().add(AddMetadataPanel, BorderLayout.CENTER);



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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
