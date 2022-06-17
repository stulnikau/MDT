package com.mdt.gui.mazeitems;

import com.mdt.gui.adapters.MouseAdapter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

/**
 * Panel for the maze cells. Can be
 * edited by the user by clicking on the panel.
 * Clicking adds or removes the wall between neighbouring cells.
 * On hover, the cell is highlighted to show that
 * it can be clicked
 */
public class MazeCellPanel extends MazeCellGenericPanel implements Serializable {
    private boolean wallStatus;
    private final boolean enabledByDefault;

    /**
     * Highlight the cell if part of the maze solution
     */
    @Override
    public void highlightSolution() {

    }

    /**
     * Return cell to regular state, un-highlighted
     */
    @Override
    public void unhighlightSolution() {

    }

    /**
     * Implements actions on mouse click and hover
     */
    class MazeCellBorderPanelMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (!enabledByDefault) {
                wallStatus = !wallStatus;
                setBackgroundBasedOnWallStatus();
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (!enabledByDefault) {
                setBackground(Color.LIGHT_GRAY);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!enabledByDefault) {
                setBackgroundBasedOnWallStatus();
            }
        }
    }

    /**
     * Sets the appropriate colour for the panel based
     * on whether the cell has or has not been set as
     * a wall by the user
     */
    private void setBackgroundBasedOnWallStatus() {
        if (wallStatus) {
            this.setBackground(Color.BLACK);
        } else {
            this.setBackground(Color.WHITE);
        }
    }

    /**
     * Creates a new maze cell/border panel
     * @param enabled flag to set the wall enabled
     *                by default when creating the
     *                panel. Useful for corner panels
     *                and outside borders
     */
    public MazeCellPanel(boolean enabled) {
        super(new FlowLayout(FlowLayout.CENTER, 0, 0));
        MazeCellBorderPanelMouseListener listener = new MazeCellBorderPanelMouseListener();
        addMouseListener(listener);
        wallStatus = enabled;
        enabledByDefault = enabled;
        setBackgroundBasedOnWallStatus();
    }
}
