package com.mdt.mazedatabase;

import com.mdt.gui.mazeitems.MazeGridPanel;
import com.mdt.maze.Maze;
import com.mdt.maze.MazeMetadata;

import javax.swing.table.DefaultTableModel;

/**
 * Class to communicate with the database to store and retrieve past mazes.
 */
public class MazeDatabase {
    DefaultTableModel mazeTableModel;
    MazeDataSource mazeDataSource;

    public MazeDatabase(MazeDataSource dataSource) {
        mazeTableModel = new DefaultTableModel();
        mazeTableModel.setColumnIdentifiers(new String[]{"Name", "Author", "Date created", "Date modified"});
        mazeDataSource = dataSource;

        // Copy database entries to the table model
        for (MazeMetadata mazeMetadata : mazeDataSource.getMazeMetadataSet()) {
            mazeTableModel.addRow(mazeMetadata.getRowData());
        }
    }

    /**
     * Records new maze layout and metadata
     * in the database
     * @param maze maze to be added
     */
    public void writeMaze(Maze maze) {
        mazeTableModel.addRow(maze.getMazeMetadata().getRowData());
        mazeDataSource.addMaze(maze);
    }

    /**
     * Gracefully shut down the connection with the data source
     */
    public void close() {
        mazeDataSource.close();
    }

    /**
     * Retrieves the maze associated with the key
     * @param mazeMetadata the metadata of the maze to be retrieved
     * @return maze associated with the provided metadata
     */
    public Maze getMaze(MazeMetadata mazeMetadata) {
        MazeGridPanel mazeGridPanel = mazeDataSource.getMazeGrid(mazeMetadata);
        return new Maze(mazeMetadata, mazeGridPanel);
    }

    /**
     * Retrieve the table model of maze database entries
     * @return table model of database entries
     */
    public DefaultTableModel getMazeTableModel() {
        return mazeTableModel;
    }
}
