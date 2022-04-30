package com.mdt.gui.mazeitems;

import com.mdt.gui.adapters.MouseAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Contains the maze cell. On hover, the cell is highlighted
 * to offer the user to click to add an image (e.g. logo or
 * maze start/end image) using a file picker
 */
public class MazeCellInsidePanel extends JPanel {
    /**
     * Implements actions on mouse click and hover
     */
    class MazeCellInsidePanelMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp");
            fileChooser.setFileFilter(filter);
            fileChooser.showOpenDialog(null);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setBackground(new Color(144, 238, 144)); // Light green
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setBackground(Color.WHITE);
        }
    }

    /**
     * Creates a new maze cell inner panel
     */
    public MazeCellInsidePanel() {
        MazeCellInsidePanelMouseListener listener = new MazeCellInsidePanelMouseListener();
        addMouseListener(listener);
        this.setBackground(Color.WHITE);
    }
}
