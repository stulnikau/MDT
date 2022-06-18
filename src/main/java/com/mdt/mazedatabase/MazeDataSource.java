package com.mdt.mazedatabase;

import com.mdt.gui.mazeitems.MazeGridPanel;
import com.mdt.maze.Maze;
import com.mdt.maze.MazeMetadata;

import java.util.Set;

public interface MazeDataSource {
    /**
     * Adds a maze to the database
     * @param maze maze to add
     */
    void addMaze(Maze maze);

    /**
     * Gets the set of metadata of all mazes stored in the database
     */
    Set<MazeMetadata> getMazeMetadataSet();

    /**
     * Gets the maze grid that corresponds to given maze metadata
     */
    MazeGridPanel getMazeGrid(MazeMetadata mazeMetadata);

    /**
     * Gracefully terminate the database connection
     */
    void close();
}
