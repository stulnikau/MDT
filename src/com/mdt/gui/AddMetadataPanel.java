package com.mdt.gui;

import javax.swing.*;
import java.awt.*;

public class AddMetadataPanel extends JPanel {
    public AddMetadataPanel() {
        super(new BorderLayout());
        JLabel Header = new JLabel("New Maze");

        Header.setBounds(0, 0, 100, 40);

        add(Header);
        setSize(400,400);
        setVisible(true);
        setLayout(null);




        JTextField input1, input2;
        input1 = new JTextField("Maze Name");
        input1.setBounds(50, 100, 150, 40);
        input2 = new JTextField("Author");
        input2.setBounds(50, 150, 150, 40);
        add(input1); add(input2);
        setSize(400,400);
        setLayout(null);
        setVisible(true);







    }

}
