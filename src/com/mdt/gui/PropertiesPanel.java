package com.mdt.gui;
import javax.swing.*;
import java.awt.*;

public class PropertiesPanel extends JPanel {
    private final JPanel propertiesPanel;
    private final JLabel header;
    private final JLabel reachabilityLabel;
    private final JLabel deadEndLabel;
    private final JButton autoGenerate;
    private final JLabel solutionPrompt;
    private final JCheckBox solutionStatus;

    private void setupLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;


        // Heading
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.ipady = 10;
        propertiesPanel.add(header, c);

        // Maze metrics
        c.ipady = 5;
        c.gridy = 1;
        propertiesPanel.add(reachabilityLabel, c);
        c.gridy = 2;
        propertiesPanel.add(deadEndLabel, c);

        // Horizontal separator
        c.gridy = 3;
        propertiesPanel.add(new JSeparator(JSeparator.HORIZONTAL), c);

        // Solution items
        c.gridwidth = 1;
        c.gridy = 4;
        propertiesPanel.add(solutionStatus, c);

        c.gridx = 1;
        c.weightx = 1;
        c.ipadx = 3;
        propertiesPanel.add(solutionPrompt, c);

        // Horizontal separator
        c.gridwidth = 2;
        c.gridx = 0;
        c.ipadx = 0;
        c.gridy = 5;
        propertiesPanel.add(new JSeparator(JSeparator.HORIZONTAL), c);

        // Auto-generate button
        c.gridy = 6;
        propertiesPanel.add(autoGenerate, c);

        // Fill the remainder so that it's not empty
        c.ipadx = 0;
        c.gridx = 0;
        c.weightx = 0;
        c.gridy = 7;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.LINE_END;
        c.weighty = 100.0;
        c.gridheight = GridBagConstraints.REMAINDER;
        propertiesPanel.add(Box.createGlue(), c);
    }

    public PropertiesPanel() {
        super(new BorderLayout());
        header = new JLabel("Maze Properties");
        header.setFont(GUIFrame.HEADING_3);

        reachabilityLabel = new JLabel("Cells reached by solution: 27%");
        deadEndLabel = new JLabel("Dead end cells: 16%");
        autoGenerate = new JButton("Autogenerate Maze");
        solutionPrompt = new JLabel("Show maze solution");
        solutionStatus = new JCheckBox();
        propertiesPanel = new JPanel(new GridBagLayout());

        setupLayout();
        this.add(propertiesPanel, BorderLayout.CENTER);

        // Add some padding on the sides
        this.add(Box.createHorizontalStrut(GUIFrame.PADDING_WIDTH), BorderLayout.EAST);
        this.add(Box.createHorizontalStrut(GUIFrame.PADDING_WIDTH), BorderLayout.WEST);
    }
}
