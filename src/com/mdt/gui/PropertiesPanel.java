package com.mdt.gui;
import javax.swing.*;
import java.awt.*;

public class PropertiesPanel extends JPanel{
    private final JPanel propertiesPanel;
    private final JLabel header;
    private final JLabel header2;
    private final JLabel difficultyPrompt;
    private final JButton autoGenerate;
    private final JLabel solutionPrompt;
    private final JCheckBox solutionStatus;





    private void setupLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
       propertiesPanel.add(header, c);



        // Horizontal separator
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        propertiesPanel.add(new JSeparator(JSeparator.HORIZONTAL), c);


       c.gridx = 0;
       c.gridy = 2;
       c.ipady = 30;
       propertiesPanel.add(header2,c);


       c.gridy = 3;
       c.gridwidth = 2;
       propertiesPanel.add(difficultyPrompt,c);

       c.gridy = 4;
       propertiesPanel.add(autoGenerate, c);



        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.WEST;
        c.gridwidth = 1;
        c.gridy = 5;
        c.ipadx = 3;
       propertiesPanel.add(solutionPrompt,c);


        c.weightx = 1;
        c.ipadx = 0;
        c.gridx = 1;
        c.gridy = 5;
       propertiesPanel.add(solutionStatus,c);
    }

    public PropertiesPanel() {
        super(new BorderLayout());
        header = new JLabel("Properties");
        header.setFont(GUIFrame.HEADING_2);
        header.setHorizontalAlignment(SwingConstants.CENTER);

        header2 = new JLabel("Maze");
        header2.setFont(GUIFrame.HEADING_3);
        header2.setHorizontalAlignment(SwingConstants.CENTER);

        difficultyPrompt = new JLabel("Reachability :");

        autoGenerate = new JButton(" Auto - Generate");

        solutionPrompt = new JLabel("Solution ");

        solutionStatus = new JCheckBox();

        propertiesPanel = new JPanel(new GridBagLayout());


        setupLayout();
        this.add(propertiesPanel, BorderLayout.CENTER);

        // Add some padding on the sides
       this.add(Box.createHorizontalStrut(5), BorderLayout.EAST);
        this.add(Box.createHorizontalStrut(5), BorderLayout.WEST);
    }



}
