package com.mdt;

import com.mdt.gui.GUIFrame;
import com.mdt.mazedatabase.MazeDatabase;

import javax.swing.*;

/**
 * Entry point to the application. Holds reference to the GUI
 * @see GUIFrame
 */
public class Program {
    /**
     * Entry point into the application
     * @param args command-line arguments to the program
     */
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new GUIFrame());
    }
}
