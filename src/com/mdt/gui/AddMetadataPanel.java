package com.mdt.gui;

import com.mdt.gui.generics.ProgressControlPanel;
import com.mdt.maze.MazeDimensions;
import com.mdt.maze.MazeLocation;
import com.mdt.maze.MazeLogo;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.io.File;

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

    // Start/end image selection
    private final JCheckBox useStartEndImagesPrompt;
    private final JButton startEndImageFilePickerButton;
    private final JLabel filesSelected;
    private boolean useStartEndImages;
    private File startImage;
    private File endImage;
    private final JFileChooser fileChooser;

    // Logo selection
    private final JCheckBox useLogoPrompt;
    private final JButton logoFilePickerButton;
    private final JLabel logoSelected;
    private boolean useLogo;
    private File logo;
    private final JFileChooser logoChooser;
    private final JTextField logoColInput;
    private final JTextField logoRowInput;
    private final JTextField logoWidthInput;
    private final JTextField logoHeightInput;

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

        // Horizontal separator
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 3;
        metadataPanel.add(new JSeparator(JSeparator.HORIZONTAL), c);

        // Checkbox
        c.gridy = 8;
        metadataPanel.add(useStartEndImagesPrompt, c);

        // File picker button
        c.fill = GridBagConstraints.NONE;
        c.gridwidth = 1;
        c.gridy = 9;
        metadataPanel.add(startEndImageFilePickerButton, c);

        // File picker results text box
        c.gridx = 1;
        metadataPanel.add(filesSelected, c);

        // Horizontal separator
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 10;
        c.gridwidth = 3;
        metadataPanel.add(new JSeparator(JSeparator.HORIZONTAL), c);

        // Checkbox
        c.gridy = 11;
        metadataPanel.add(useLogoPrompt, c);

        // File picker button
        c.fill = GridBagConstraints.NONE;
        c.gridwidth = 1;
        c.gridy = 12;
        metadataPanel.add(logoFilePickerButton, c);

        // File picker results text box
        c.gridx = 1;
        metadataPanel.add(logoSelected, c);

        // Positioning header
        JLabel logoOptionsHeader = new JLabel("Logo positioning and size");
        c.ipady = 5;
        c.gridwidth = 3;
        c.gridy = 13;
        c.gridx = 0;
        metadataPanel.add(logoOptionsHeader, c);
        c.ipady = 0;

        // Column prompt
        c.gridy = 14;
        JLabel colLabel = new JLabel("Column:");
        metadataPanel.add(colLabel, c);

        // Row prompt
        c.gridy = 15;
        JLabel rowLabel = new JLabel("Row:");
        metadataPanel.add(rowLabel, c);

        // Width prompt
        c.gridy = 16;
        JLabel widthLabel = new JLabel("Width:");
        metadataPanel.add(widthLabel, c);

        // Height prompt
        c.gridy = 17;
        JLabel heightLabel = new JLabel("Height:");
        metadataPanel.add(heightLabel, c);

        // Column input
        c.gridx = 1;
        c.gridy = 14;
        metadataPanel.add(logoColInput, c);

        // Row input
        c.gridy = 15;
        metadataPanel.add(logoRowInput, c);

        // Width input
        c.gridy = 16;
        metadataPanel.add(logoWidthInput, c);

        // Height input
        c.gridy = 17;
        metadataPanel.add(logoHeightInput, c);

        // Fill the remainder so that it's not empty
        c.gridx = 0;
        c.weightx = 0;
        c.gridy = 18;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.LINE_END;
        c.weighty = 100.0;
        c.gridheight = GridBagConstraints.REMAINDER;
        metadataPanel.add(Box.createGlue(), c);
    }

    private void pickStartEndImages() {
        int selectedOption = fileChooser.showOpenDialog(this);
        if (selectedOption == JFileChooser.APPROVE_OPTION) {
            File[] files = fileChooser.getSelectedFiles();
            if (files.length == 2) {
                startImage = files[0];
                endImage = files[1];
                filesSelected.setText("2 files selected");
                useStartEndImages = true;
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "2 files must be selected. Please go back and try again."
                );
            }
        }
    }

    private void pickLogo() {
        int selectedOption = logoChooser.showOpenDialog(this);
        if (selectedOption == JFileChooser.APPROVE_OPTION) {
            logo = logoChooser.getSelectedFile();
            useLogo = true;
            logoSelected.setText("File selected");

            // Enable logo controls
            logoColInput.setEnabled(true);
            logoRowInput.setEnabled(true);
            logoWidthInput.setEnabled(true);
            logoHeightInput.setEnabled(true);
        }
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
        authorInput = new JTextField("New Author");

        widthPrompt = new JLabel("Width:");
        heightPrompt = new JLabel("Height:");

        widthInput = new JTextField("20");
        heightInput = new JTextField("20");

        mazeOptionsHeader = new JLabel("Maze options");
        mazeOptionsHeader.setFont(GUIFrame.HEADING_3);

        // Start/end image picker
        startEndImageFilePickerButton = new JButton("Select files...");
        startEndImageFilePickerButton.setEnabled(false);
        startEndImageFilePickerButton.addActionListener(e -> pickStartEndImages());

        filesSelected = new JLabel();
        filesSelected.setText("No files selected");
        filesSelected.setForeground(Color.GRAY);

        fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setMultiSelectionEnabled(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
        fileChooser.setFileFilter(filter);

        useStartEndImagesPrompt = new JCheckBox("Use images for maze start and end");
        useStartEndImagesPrompt.addItemListener(e -> startEndImageFilePickerButton.setEnabled(e.getStateChange() == ItemEvent.SELECTED));

        // Logo picker
        logoFilePickerButton = new JButton("Select file...");
        logoFilePickerButton.setEnabled(false);
        logoFilePickerButton.addActionListener(e -> pickLogo());

        logoSelected = new JLabel();
        logoSelected.setText("No file selected");
        logoSelected.setForeground(Color.GRAY);

        logoChooser = new JFileChooser();
        logoChooser.setAcceptAllFileFilterUsed(false);
        logoChooser.setMultiSelectionEnabled(false);
        logoChooser.setFileFilter(filter);

        useLogoPrompt = new JCheckBox("Place a logo on maze canvas");
        useLogoPrompt.addItemListener(e -> logoFilePickerButton.setEnabled(e.getStateChange() == ItemEvent.SELECTED));

        logoColInput = new JTextField("5");
        logoColInput.setEnabled(false);
        logoRowInput = new JTextField("4");
        logoRowInput.setEnabled(false);
        logoWidthInput = new JTextField("2");
        logoWidthInput.setEnabled(false);
        logoHeightInput = new JTextField("2");
        logoHeightInput.setEnabled(false);

        setupLayout();
        this.add(progressControlPanel, BorderLayout.SOUTH);
        this.add(metadataPanel, BorderLayout.CENTER);

        useStartEndImages = false; // Default values
        useLogo = false;

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

    /**
     * Tests whether the maze type selected by the user includes maze
     * start and end images
     * @return boolean indicating whether the maze should include start
     * and end images
     */
    public boolean mazeWithStartEndImages() {
        return useStartEndImages;
    }

    /**
     * Returns the start image selected by user
     * @return maze start image
     */
    public File getStartImage() {
        return startImage;
    }

    /**
     * Returns the end image selected by user
     * @return maze end image
     */
    public File getEndImage() {
        return endImage;
    }

    /**
     * Tests whether the maze should include a logo
     * @return boolean indicating whether the user selected a maze
     * with a logo included
     */
    public boolean mazeWithLogo() {
        return useLogo;
    }

    /**
     * Retrieves the maze logo and the positioning of the logo
     * @return Maze logo and positioning on the maze canvas
     */
    public MazeLogo getMazeLogo() {
        MazeLocation logoLocation = new MazeLocation(
                Integer.parseInt(logoRowInput.getText().strip()) - 1,
                Integer.parseInt(logoColInput.getText().strip()) - 1);
        MazeDimensions logoDimensions = new MazeDimensions(
                Integer.parseInt(logoWidthInput.getText().strip()),
                Integer.parseInt(logoHeightInput.getText().strip()));
        return new MazeLogo(logo, logoDimensions, logoLocation);
    }
}
