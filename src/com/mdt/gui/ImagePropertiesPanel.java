package com.mdt.gui;
import javax.swing.*;
import java.awt.*;

public class ImagePropertiesPanel extends JPanel {
    private final JPanel imagePropertiesPanel;
    private final JLabel header;
    private final JLabel heightPrompt;
    private final JLabel widthPrompt;
    private final JTextField heightInput;
    private final JTextField widthInput;




    private void setupLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;


        // Heading
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.ipady = 15;
        imagePropertiesPanel.add(header, c);

        // Width and height
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.WEST;

        c.gridwidth = 1;
        c.gridy = 1;
        c.ipadx = 5;
        imagePropertiesPanel.add(widthPrompt, c);

        c.gridy = 2;
        imagePropertiesPanel.add(heightPrompt, c);

        c.weightx = 1;
        c.ipadx = 0;
        c.gridx = 1;
        c.gridy = 1;
        imagePropertiesPanel.add(widthInput, c);

        c.gridy = 2;
        imagePropertiesPanel.add(heightInput, c);

        c.ipadx = 0;
        c.gridx = 0;
        c.weightx = 0;
        c.gridy = 7;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.LINE_END;
        c.weighty = 100.0;
        c.gridheight = GridBagConstraints.REMAINDER;
        imagePropertiesPanel.add(Box.createGlue(), c);
    }

    public ImagePropertiesPanel() {
        super(new BorderLayout());
        header = new JLabel("Image Properties");
        header.setFont(GUIFrame.HEADING_3);



        widthPrompt = new JLabel("Width:");
        heightPrompt = new JLabel("Height:");

        widthInput = new JTextField(" 20");
        heightInput = new JTextField(" 20");


        imagePropertiesPanel = new JPanel(new GridBagLayout());
        setupLayout();
        this.add(imagePropertiesPanel, BorderLayout.CENTER);

        // Add some padding on the sides
        this.add(Box.createHorizontalStrut(GUIFrame.PADDING_WIDTH), BorderLayout.EAST);
        this.add(Box.createHorizontalStrut(GUIFrame.PADDING_WIDTH), BorderLayout.WEST);


    }




}
