package com.mdt;

import com.mdt.gui.GUIFrame;
import com.mdt.mazedatabase.MazeDatabase;

import javax.swing.*;

/**
 * Entry point to the application. Holds references to the components
 * of the application, including the GUI and backend services such as
 * the Maze Database.
 * @see GUIFrame
 * @see MazeDatabase
 */
public class Program {
    public static MazeDatabase mazeDatabase = new MazeDatabase();

    /**
     * Entry point into the application
     * @param args command-line arguments to the program
     */
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new GUIFrame());
    }
}
