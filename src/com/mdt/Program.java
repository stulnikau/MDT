package com.mdt;

import com.mdt.gui.GUIFrame;

import javax.swing.*;

public class Program {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new GUIFrame());
    }
}
