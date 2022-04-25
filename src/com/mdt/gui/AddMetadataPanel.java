package com.mdt.gui;

import javax.swing.*;
import java.awt.*;

public class AddMetadataPanel extends JPanel {
    private final JPanel metadataPanel;
    private final JLabel header;
    private final JLabel mazeOptionsHeader;
    private final JLabel namePrompt;
    private final JLabel authorPrompt;
    private final JTextField nameInput;
    private final JTextField authorInput;
    private final JLabel widthPrompt;
    private final JLabel heightPrompt;
    private final JTextField widthInput;
    private final JTextField heightInput;

    private void setupLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        metadataPanel.add(header, c);

        c.gridwidth = 1;
        c.gridy = 1;
        c.ipadx = 5;
        metadataPanel.add(namePrompt, c);

        c.gridy = 2;
        metadataPanel.add(authorPrompt, c);

        c.weightx = 1;
        c.ipadx = 0;
        c.gridx = 1;
        c.gridy = 1;
        metadataPanel.add(nameInput, c);

        c.gridy = 2;
        metadataPanel.add(authorInput, c);

        // Horizontal separator
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 3;
        metadataPanel.add(new JSeparator(JSeparator.HORIZONTAL));

        // Maze options header
        c.gridy = 4;
        metadataPanel.add(mazeOptionsHeader, c);

        // Width and height
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.WEST;
        c.gridwidth = 1;
        c.gridy = 5;
        c.ipadx = 5;
        metadataPanel.add(widthPrompt, c);

        c.gridy = 6;
        metadataPanel.add(heightPrompt, c);

        c.weightx = 1;
        c.ipadx = 0;
        c.gridx = 1;
        c.gridy = 5;
        metadataPanel.add(widthInput, c);

        c.gridy = 6;
        metadataPanel.add(heightInput, c);

        // Fill the remainder so that it's not empty
        c.gridx = 0;
        c.weightx = 0;
        c.gridy = 7;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.LINE_END;
        c.weighty = 100.0;
        c.gridheight = GridBagConstraints.REMAINDER;
        metadataPanel.add(Box.createGlue(), c);
    }

    public AddMetadataPanel() {
        super(new BorderLayout());

        header = new JLabel("New Maze");
        header.setFont(GUIFrame.HEADING_2);

        metadataPanel = new JPanel(new GridBagLayout());

        namePrompt = new JLabel("Maze Name:");
        authorPrompt = new JLabel("Author Name:");

        nameInput = new JTextField("New Maze");
        authorInput = new JTextField("");

        widthPrompt = new JLabel("Width:");
        heightPrompt = new JLabel("Height:");

        widthInput = new JTextField("20");
        heightInput = new JTextField("20");

        mazeOptionsHeader = new JLabel("Maze Dimensions");
        mazeOptionsHeader.setFont(GUIFrame.HEADING_3);

        setupLayout();
        this.add(metadataPanel, BorderLayout.CENTER);

        // Add some padding on the sides
        this.add(Box.createHorizontalStrut(5), BorderLayout.EAST);
        this.add(Box.createHorizontalStrut(5), BorderLayout.WEST);
    }

}
