package com.mdt.gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazePropertiesPanel extends JPanel implements ActionListener{
    private final JLabel header;
    private final JLabel reachabilityLabel;
    private final JLabel deadEndLabel;
    private final JButton autoGenerate;
    private final JLabel solutionPrompt;
    private final JCheckBox solutionStatus;
    private final JButton logoPrompt;

    private void setupLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        // Heading
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.ipady = 10;
        this.add(header, c);

        // Maze metrics
        c.ipady = 5;
        c.gridy = 1;
        this.add(reachabilityLabel, c);
        c.gridy = 2;
        this.add(deadEndLabel, c);

        // Horizontal separator
        c.gridy = 3;
        this.add(new JSeparator(JSeparator.HORIZONTAL), c);

        // Solution items
        c.gridwidth = 1;
        c.gridy = 4;
        this.add(solutionStatus, c);

        c.gridx = 1;
        c.weightx = 1;
        c.ipadx = 3;
        this.add(solutionPrompt, c);

        // Horizontal separator
        c.gridwidth = 2;
        c.gridx = 0;
        c.ipadx = 0;
        c.gridy = 5;
        this.add(new JSeparator(JSeparator.HORIZONTAL), c);

        // Auto-generate button
        c.gridy = 6;
        this.add(autoGenerate, c);

        // Insert Logo Button
        c.gridx = 0;
        c.gridy = 7;
        this.add(logoPrompt, c);

        // Fill the remainder so that it's not empty
        c.ipadx = 0;
        c.gridx = 0;
        c.weightx = 0;
        c.gridy = 7;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.LINE_END;
        c.weighty = 100.0;
        c.gridheight = GridBagConstraints.REMAINDER;
        this.add(Box.createGlue(), c);
    }

    public MazePropertiesPanel() {
        super(new GridBagLayout());
        header = new JLabel("Maze Properties");
        header.setFont(GUIFrame.HEADING_3);

        reachabilityLabel = new JLabel("Cells reached by solution: 27%");
        deadEndLabel = new JLabel("Dead end cells: 16%");
        autoGenerate = new JButton("Autogenerate Maze");
        solutionPrompt = new JLabel("Show maze solution");
        solutionStatus = new JCheckBox();
        logoPrompt = new JButton("Insert Logo");
        logoPrompt.addActionListener(this);

        setupLayout();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == logoPrompt){
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp");
            fileChooser.setFileFilter(filter);
            fileChooser.showOpenDialog(null);

        }
    }
}
