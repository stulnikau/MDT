package com.mdt.gui.generics;

import javax.swing.*;
import java.awt.*;

public class ProgressControlPanel extends JPanel {
    public JButton nextButton;
    public JButton prevButton;

    private void setupLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        // Horizontal separator
        c.gridx = 0;
        c.gridwidth = 3;
        c.gridy = 0;
        this.add(new JSeparator(JSeparator.HORIZONTAL), c);

        // Empty space to the left of the control buttons
        c.gridy = 1;
        c.gridwidth = 1;
        c.weightx = 1;
        this.add(Box.createGlue(), c);

        // Control buttons are on the right
        c.weightx = 0;
        c.gridx = 1;
        this.add(prevButton, c);

        c.gridx = 2;
        this.add(nextButton, c);
    }

    public ProgressControlPanel(String nextButtonLabel, String prevButtonLabel) {
        super(new GridBagLayout());
        nextButton = new JButton(nextButtonLabel);
        prevButton = new JButton(prevButtonLabel);
        setupLayout();
    }
}
