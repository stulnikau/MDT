package com.mdt.gui.mazeitems;

import com.mdt.gui.adapters.MouseAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Panel for the border between maze cells. Can be
 * edited by the user by clicking on the panel.
 * Clicking adds or removes the wall between cells.
 * On hover, the border is highlighted to show that
 * it can be clicked
 */
public class MazeCellBorderPanel extends JPanel {
    private boolean wallStatus;

    /**
     * Implements actions on mouse click and hover
     */
    class MazeCellBorderPanelMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            wallStatus = !wallStatus;
            setColorBasedOnWallStatus();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setBackground(Color.LIGHT_GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setColorBasedOnWallStatus();
        }
    }

    /**
     * Sets the appropriate colour for the panel based
     * on whether the wall has or has not been set by
     * the user
     */
    private void setColorBasedOnWallStatus() {
        if (wallStatus) {
            this.setBackground(Color.BLACK);
        } else {
            this.setBackground(Color.WHITE);
        }
    }

    /**
     * Creates a new maze cell border panel
     * @param enabled flag to set the wall enabled
     *                by default when creating the
     *                panel. Useful for corner panels
     *                and outside borders
     */
    public MazeCellBorderPanel(boolean enabled) {
        MazeCellBorderPanelMouseListener listener = new MazeCellBorderPanelMouseListener();
        addMouseListener(listener);
        wallStatus = enabled;
        setColorBasedOnWallStatus();
    }
}
