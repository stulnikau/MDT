package com.mdt.gui;
import javax.swing.*;
import java.awt.*;

/**
 * Side panel controlling the properties for Logo and maze start/end images.
 */
public class ImagePropertiesPanel extends JPanel {
    private final JLabel header;
    private final JLabel heightPrompt;
    private final JLabel widthPrompt;
    private final JTextField heightInput;
    private final JTextField widthInput;

    /**
     * Adds the components and handles the layout by using GridBagLayout
     */
    private void setupLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        // Heading
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.ipady = 15;
        this.add(header, c);

        // Width and height
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.WEST;

        c.gridwidth = 1;
        c.gridy = 1;
        c.ipadx = 5;
        this.add(widthPrompt, c);

        c.gridy = 2;
        this.add(heightPrompt, c);

        c.weightx = 1;
        c.ipadx = 0;
        c.gridx = 1;
        c.gridy = 1;
        this.add(widthInput, c);

        c.gridy = 2;
        this.add(heightInput, c);

        c.ipadx = 0;
        c.gridx = 0;
        c.weightx = 0;
        c.gridy = 3;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.LINE_END;
        c.weighty = 100.0;
        c.gridheight = GridBagConstraints.REMAINDER;
        this.add(Box.createGlue(), c);
    }

    /**
     * Creates a new ImagePropertiesPanel
     */
    public ImagePropertiesPanel() {
        super(new GridBagLayout());
        header = new JLabel("Image Properties");
        header.setFont(GUIFrame.HEADING_3);

        widthPrompt = new JLabel("Width:");
        heightPrompt = new JLabel("Height:");

        widthInput = new JTextField(" 2");
        heightInput = new JTextField(" 2");

        setupLayout();
    }
}
