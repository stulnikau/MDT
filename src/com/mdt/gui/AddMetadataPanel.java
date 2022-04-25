package com.mdt.gui;

import javax.swing.*;
import java.awt.*;

public class AddMetadataPanel extends JPanel {
    private final JPanel metadataPanel;
    private final JLabel header;
    private final JLabel namePrompt;
    private final JLabel authorPrompt;
    private final JTextField nameInput;
    private final JTextField authorInput;

    private void setupLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
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

        c.gridy = 3;
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

        setupLayout();
        this.add(metadataPanel, BorderLayout.CENTER);

        // Add some padding on the sides
        this.add(Box.createHorizontalStrut(5), BorderLayout.EAST);
        this.add(Box.createHorizontalStrut(5), BorderLayout.WEST);
    }

}
