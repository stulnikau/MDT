package com.mdt.gui.mazeitems;

import com.mdt.gui.adapters.MouseAdapter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Objects;

/**
 * Panel for the maze cells. Can be
 * edited by the user by clicking on the panel.
 * Clicking adds or removes the wall between neighbouring cells.
 * On hover, the cell is highlighted to show that
 * it can be clicked
 */
public class MazeCellPanel extends JPanel {
    private boolean wallStatus;
    private final boolean enabledByDefault;
    private boolean isEntryExit;
    private final JLabel entryExitLabel;
    private ImageIcon arrowImageIcon;
    private ImageIcon wallImageIcon;
    private ImageIcon highlightImageIcon;
    private ImageIcon blankImageIcon;

    // Default side dimension for the cell
    private static final int DEFAULT_SIDE_DIM = 20;

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
            entryExitLabel.setIcon(highlightImageIcon);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setColorBasedOnWallStatus();
        }
    }

    /**
     * Sets the appropriate colour for the panel based
     * on whether the cell has or has not been set as
     * a wall by the user
     */
    private void setColorBasedOnWallStatus() {
        if (wallStatus) {
            entryExitLabel.setIcon(wallImageIcon);
            if (enabledByDefault) {entryExitLabel.setIcon(wallImageIcon);}
            this.isEntryExit = false;
        } else if (enabledByDefault) {
            entryExitLabel.setIcon(arrowImageIcon);
            this.isEntryExit = true;
        } else {
            entryExitLabel.setIcon(blankImageIcon);
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
        entryExitLabel = new JLabel();
        if (enabledByDefault) {
            isEntryExit = false;
        }
        try {
            Image arrowImage = ImageIO
                    .read(Objects.requireNonNull(getClass().getResource("arrow.png")))
                    .getScaledInstance(DEFAULT_SIDE_DIM, DEFAULT_SIDE_DIM, Image.SCALE_DEFAULT);
            arrowImageIcon = new ImageIcon(arrowImage);
            Image wallImage = ImageIO
                    .read(Objects.requireNonNull(getClass().getResource("wall.png")))
                    .getScaledInstance(DEFAULT_SIDE_DIM, DEFAULT_SIDE_DIM, Image.SCALE_DEFAULT);
            Image highlightImage = ImageIO
                    .read(Objects.requireNonNull(getClass().getResource("highlight.png")))
                    .getScaledInstance(DEFAULT_SIDE_DIM, DEFAULT_SIDE_DIM, Image.SCALE_DEFAULT);
            highlightImageIcon = new ImageIcon(highlightImage);
            Image blankImage = ImageIO
                    .read(Objects.requireNonNull(getClass().getResource("blank.png")))
                    .getScaledInstance(DEFAULT_SIDE_DIM, DEFAULT_SIDE_DIM, Image.SCALE_DEFAULT);
            blankImageIcon = new ImageIcon(blankImage);
            wallImageIcon = new ImageIcon(wallImage);
            entryExitLabel.setIcon(wallImageIcon);
            this.add(entryExitLabel);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        setColorBasedOnWallStatus();
    }
}
