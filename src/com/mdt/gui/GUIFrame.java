package com.mdt.gui;

import com.mdt.Program;
import com.mdt.gui.adapters.ShowSolutionListener;
import com.mdt.gui.mazeitems.MazeGridPanel;
import com.mdt.maze.Maze;
import com.mdt.maze.MazeMetadata;
import com.mdt.mazedatabase.DBConnection;
import com.mdt.mazedatabase.JDBCMazeDataSource;
import com.mdt.mazedatabase.MazeDatabase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * The top-level container of the application. All GUI panels and elements
 * are placed within GUIFrame.
 * The class defines static constants for fonts and other resources
 * used across the GUI. It also adds itself as an action listener for
 * JButtons in child classes.
 */
public class GUIFrame extends JFrame implements ActionListener, Runnable, ShowSolutionListener {
    // Define some fonts for use application-wide
    public static final Font SYSTEM_FONT = new JLabel().getFont(); // Default system font
    public static final Font HEADING_1 = GUIFrame.SYSTEM_FONT.deriveFont(Font.BOLD, 30.0F); // Large heading
    public static final Font HEADING_2 = GUIFrame.SYSTEM_FONT.deriveFont(Font.BOLD, 24.0F); // Medium heading
    public static final Font HEADING_3 = GUIFrame.SYSTEM_FONT.deriveFont(Font.BOLD, 14.0F); // Small heading
    // Consistent padding across the GUI
    public static final int PADDING_WIDTH = 5;

    private LandingPanel landingPanel;
    private AddMetadataPanel addMetadataPanel;
    private MazeGenerationPanel mazeGenerationPanel;
    private ExportDialog exportDialog;

    private JPanel mainPanel;
    private CardLayout cardLayout;

    private MazeDatabase mazeDatabase;

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread
     */
    private void createAndShowGUI() {
        // Frame setup
        super.setTitle("Welcome to Maze Design Tool");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.mazeDatabase = new MazeDatabase(new JDBCMazeDataSource(DBConnection.getInstance()));

        // Main JPanel setup
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add components
        // Panel for the Landing screen
        landingPanel = new LandingPanel(mazeDatabase);
        mainPanel.add(landingPanel, "Landing");
        // Panel for adding metadata when creating a new maze
        addMetadataPanel = new AddMetadataPanel();
        mainPanel.add(addMetadataPanel, "AddMetadata");
        // Dialog for exporting mazes
        exportDialog = new ExportDialog(this);
        // Panel for generating and customizing Maze with dummy values for dimensions
        // Values are overridden once the user requests a new maze
        mazeGenerationPanel = new MazeGenerationPanel(this);
        mainPanel.add(mazeGenerationPanel, "MazeGeneration");

        // Add mainPanel to JFrame
        this.getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Adding action listeners
        landingPanel.landingControlPanel.newMaze.addActionListener(this);
        landingPanel.landingControlPanel.exportItems.addActionListener(this);
        addMetadataPanel.progressControlPanel.prevButton.addActionListener(this);
        addMetadataPanel.progressControlPanel.nextButton.addActionListener(this);
        mazeGenerationPanel.progressControlPanel.prevButton.addActionListener(this);
        mazeGenerationPanel.progressControlPanel.nextButton.addActionListener(this);

        this.addWindowListener(new ClosingListener());

        // Pack components
        this.pack();
        // Place the window in the middle of the screen
        this.setLocationRelativeTo(null);
        // Set window to visible
        this.setVisible(true);
    }

    /**
     * Creates and shows the GUI JFrame
     */
    @Override
    public void run() {
        createAndShowGUI();
    }

    /**
     * Actions taken when the user selects to create a new maze
     */
    private void showNewMazeDialog() {
        // Show add metadata panel
        super.setTitle("New Maze");
        cardLayout.show(mainPanel, "AddMetadata");
    }

    /**
     * Actions taken when the user selects to come back
     * to the landing page
     */
    private void showLanding() {
        super.setTitle("Welcome to Maze Design Tool");
        cardLayout.show(mainPanel, "Landing");
    }

    /**
     * Actions taken when the user selects to proceed with
     * creating a new maze from the add metadata panel
     */
    private void showMazeGeneration() {
        super.setTitle(addMetadataPanel.getMazeTitle());
        // Update the maze generation panel with the inputs provided by user
        mazeGenerationPanel.setMazeDimensions(addMetadataPanel.getMazeDimensions());
        if (addMetadataPanel.mazeWithStartEndImages()) {
            mazeGenerationPanel.setMazeStartEndImages(
                    addMetadataPanel.getStartImage(),
                    addMetadataPanel.getEndImage());
        }
        if (addMetadataPanel.mazeWithLogo()) {
            mazeGenerationPanel.setMazeLogo(
                    addMetadataPanel.getMazeLogo()
            );
        }
        mazeGenerationPanel.initialiseWithParams();
        cardLayout.show(mainPanel,"MazeGeneration");
    }

    /**
     * Actions taken when the user chooses to export
     * selected mazes from the maze table
     */
    private void showExportDialog() {
        int[] rowsToExport = landingPanel.mazeBrowserTable.getSelectedRows();
        Vector<Maze> mazes = new Vector<>();
        for (int row : rowsToExport) {
            int modelIndex = landingPanel.mazeBrowserTable.convertRowIndexToModel(row);
            DefaultTableModel tableModel = (DefaultTableModel) landingPanel.mazeBrowserTable.getModel();
            MazeMetadata mazeToGet = new MazeMetadata(tableModel.getDataVector().elementAt(modelIndex));
            mazes.add(mazeDatabase.getMaze(mazeToGet));
        }

        exportDialog.bindMazeGrids(mazes);
        exportDialog.setLocationRelativeTo(this);
        exportDialog.setVisible(true);
    }

    /**
     * Saves the most recent maze into the database
     */
    private void saveRecentMaze() {
        MazeGridPanel mazeGridPanel = mazeGenerationPanel.mazeCanvasPanel.getMazeGrid();
        MazeMetadata mazeMetadata = new MazeMetadata(
                addMetadataPanel.getMazeName(),
                addMetadataPanel.getMazeAuthor()
        );
        Maze maze = new Maze(mazeMetadata, mazeGridPanel);
        mazeDatabase.writeMaze(maze);
    }

    /**
     * Shows or hides maze solution on the maze canvas
     * @param showSolution show solution
     */
    public void toggleMazeSolution(boolean showSolution) {
        if (showSolution) {
            mazeGenerationPanel.mazeCanvasPanel.getMazeGrid().showSolution();
        } else {
            mazeGenerationPanel.mazeCanvasPanel.getMazeGrid().hideSolution();
        }
    }

    /**
     * Processes an ActionEvent
     * @param e ActionEvent originating from a component
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        // Handle button presses
        if (landingPanel.landingControlPanel.newMaze.equals(src)) {
            showNewMazeDialog();
        } else if (landingPanel.landingControlPanel.exportItems.equals(src)) {
            showExportDialog();
        } else if (addMetadataPanel.progressControlPanel.nextButton.equals(src)) {
            showMazeGeneration();
        } else if (addMetadataPanel.progressControlPanel.prevButton.equals(src)) {
            showLanding();
        } else if (mazeGenerationPanel.progressControlPanel.nextButton.equals(src)) {
            saveRecentMaze();
            showLanding();
        } else if (mazeGenerationPanel.progressControlPanel.prevButton.equals(src)) {
            showNewMazeDialog();
        }
    }

    /**
     * Additional actions performed on window close to gracefully disconnect
     * from the maze database
     */
    private class ClosingListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            mazeDatabase.close();
            System.exit(0);
        }
    }
}
