package com.mdt.gui;

import javax.swing.*;
import java.awt.*;

public class MazeGrid extends JPanel {
    int rows;
    int cols;
    public MazeGrid(int rows, int cols) {
        super(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        boolean setEnabled;

        constraints.fill = GridBagConstraints.BOTH;
        for (int r = 0; r < rows * 2 + 1; r++) {
            constraints.gridy = r;
            for (int c = 0; c < cols * 2 + 1; c++) {
                constraints.gridx = c;
                // Check if cell needs to be enabled by default
                // Corner grid
                setEnabled = (c % 2 == 0) && (r % 2 == 0);
                if ((r == 0) || (r == rows * 2)) { setEnabled = true; } // Top and bottom borders
                if ((c == 0) || (c == cols * 2)) { setEnabled = true; } // Top and bottom borders
                if (((c == 1) && (r == 0)) || ((c == cols * 2 - 1) && (r == rows * 2))) { setEnabled = false; } // Default entrance and exit

                constraints.weightx = 1;
                constraints.weighty = 1;
                // Check if it's a wall or a cell to add and set weighting
                if ((c % 2 == 0) || (r % 2 == 0)) {
                    if (c % 2 == 0) { constraints.weightx = 0.1; }
                    if (r % 2 == 0) { constraints.weighty = 0.1; }
                    this.add(new MazeCellBorderPanel(setEnabled), constraints);
                }
                else { this.add(new MazeCellInsidePanel(), constraints); }

            }
        }
    }
}
