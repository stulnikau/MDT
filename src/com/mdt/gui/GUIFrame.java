package com.mdt.gui;

import javax.swing.*;

public class GUIFrame extends JFrame implements Runnable {

    /**
     * Create the HUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread
     */
    private void createAndShowGUI() {
        super.setTitle("Maze Design Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    /**
     * Creates and shows the GUI JFrame
     */
    @Override
    public void run() {
        createAndShowGUI();
    }
}
