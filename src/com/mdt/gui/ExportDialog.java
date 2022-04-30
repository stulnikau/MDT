package com.mdt.gui;

import com.mdt.gui.generics.ProgressControlPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Dialog - exports selected mazes with or without the solution line
 * in the directory specified by the user
 */
public class ExportDialog extends JDialog implements ActionListener {
    private final JPanel exportPropertiesPanel;
    private final ProgressControlPanel progressControlPanel;
    private final JLabel saveToLabel;
    private final JTextField dirField;
    private final JButton fileChooserBtn;
    private final JCheckBox includeSolutionStatus;
    private final JLabel solutionPrompt;
    private final JFileChooser fileChooser;

    /**
     * Handles the configuration of the panel layout using the
     * GridBagLayout manager.
     */
    private void setupLayout() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        // File picker items
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        exportPropertiesPanel.add(saveToLabel, c);
        c.gridx = 2;
        c.gridwidth = 1;
        c.weightx = 1;
        exportPropertiesPanel.add(dirField, c);
        c.gridx = 3;
        c.weightx = 0;
        exportPropertiesPanel.add(fileChooserBtn, c);

        // Include maze solution checkbox and prompt
        c.gridy = 1;
        c.gridx = 0;
        exportPropertiesPanel.add(includeSolutionStatus, c);
        c.gridx = 1;
        c.gridwidth = 2;
        exportPropertiesPanel.add(solutionPrompt, c);

        // Fill the remainder so that it's not empty
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.LINE_END;
        c.weighty = 100.0;
        c.gridheight = GridBagConstraints.REMAINDER;
        exportPropertiesPanel.add(Box.createGlue(), c);
    }

    /**
     *
     * @param owner the parent container that the invokes the export dialog.
     */
    public ExportDialog(Frame owner) {
        super(owner, "Export Items", true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());

        exportPropertiesPanel = new JPanel(new GridBagLayout());
        progressControlPanel = new ProgressControlPanel("Export", "Cancel");

        saveToLabel = new JLabel("Export to:");
        dirField = new JTextField("/Users/maze_user/Pictures");
        fileChooserBtn = new JButton("...");
        includeSolutionStatus = new JCheckBox();
        solutionPrompt = new JLabel("Include optimal solution path");
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        setupLayout();
        this.add(exportPropertiesPanel, BorderLayout.CENTER);
        this.add(progressControlPanel, BorderLayout.SOUTH);

        // Add some padding on the sides
        this.add(Box.createHorizontalStrut(GUIFrame.PADDING_WIDTH), BorderLayout.EAST);
        this.add(Box.createHorizontalStrut(GUIFrame.PADDING_WIDTH), BorderLayout.WEST);

        // Action listeners
        fileChooserBtn.addActionListener(this);
        progressControlPanel.nextButton.addActionListener(this);
        progressControlPanel.prevButton.addActionListener(this);

        this.pack();
    }

    /**
     * allow the user to select the directories
     */
    public void showFileChooser() {
        fileChooser.showDialog(this, "Select");
    }

    /**
     * Processes an ActionEvent
     * @param e ActionEvent originating from a component
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        // Handle button presses
        if (fileChooserBtn.equals(src)) {
            showFileChooser();
        } else if (progressControlPanel.nextButton.equals(src)) {
            // Invoke actions to export
            // For now, just shut the dialog
            this.dispose();
        } else if (progressControlPanel.prevButton.equals(src)) {
            this.dispose();
        }
    }
}
