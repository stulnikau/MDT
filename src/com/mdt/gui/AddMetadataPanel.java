package com.mdt.gui;

import com.mdt.gui.generics.ProgressControlPanel;
import com.mdt.maze.MazeDimensions;

import javax.swing.*;
import java.awt.*;

/**
 * This panel allows the user to enter the Maze name and author name.
 * Allow user to configure the maze dimensions
 */
public class AddMetadataPanel extends JPanel {
    public ProgressControlPanel progressControlPanel;
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

    /**
     * Handles the configuration of the panel layout using the
     * GridBagLayout manager.
     */
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
        metadataPanel.add(new JSeparator(JSeparator.HORIZONTAL), c);

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

    /**
     * Creates a new AddMetadataPanel
     */
    public AddMetadataPanel() {
        super(new BorderLayout());

        progressControlPanel = new ProgressControlPanel("Next", "Back");

        header = new JLabel("New Maze");
        header.setFont(GUIFrame.HEADING_2);

        metadataPanel = new JPanel(new GridBagLayout());

        namePrompt = new JLabel("Maze Name:");
        authorPrompt = new JLabel("Author Name:");

        nameInput = new JTextField("New Maze");
        authorInput = new JTextField("");

        widthPrompt = new JLabel("Width:");
        heightPrompt = new JLabel("Height:");

        widthInput = new JTextField(" 20");
        heightInput = new JTextField(" 20");

        mazeOptionsHeader = new JLabel("Maze Dimensions");
        mazeOptionsHeader.setFont(GUIFrame.HEADING_3);

        setupLayout();
        this.add(progressControlPanel, BorderLayout.SOUTH);
        this.add(metadataPanel, BorderLayout.CENTER);

        // Add some padding on the sides
        this.add(Box.createHorizontalStrut(GUIFrame.PADDING_WIDTH), BorderLayout.EAST);
        this.add(Box.createHorizontalStrut(GUIFrame.PADDING_WIDTH), BorderLayout.WEST);
    }

    /**
     * Gets the dimensions of the maze as specified by the user
     * @return dimensions of the maze
     */
    public MazeDimensions getMazeDimensions() {
        try {
            int width = Integer.parseInt(widthInput.getText().strip());
            int height = Integer.parseInt(heightInput.getText().strip());
            return new MazeDimensions(width, height);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(
                    this,
                    "Width and height must be a number. Please go back and try again."
            );
            return new MazeDimensions(1, 1);
        } catch (IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(
                    this,
                    "Width and height must be positive. Please go back and try again."
            );
            return new MazeDimensions(1, 1);
        }
    }

    /**
     * Gets the name of the maze
     * @return maze name
     */
    public String getMazeName() {
        return nameInput.getText().strip();
    }

    /**
     * Gets the name of the author
     * @return maze author
     */
    public String getMazeAuthor() {
        return authorInput.getText().strip();
    }

    /**
     * Gets the title of the maze
     * @return maze title in the format "{maze name} by {maze author}"
     */
    public String getMazeTitle() {
        return getMazeName() + " by " + getMazeAuthor();
    }
}
