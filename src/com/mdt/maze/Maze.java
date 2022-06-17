package com.mdt.maze;

import com.mdt.gui.mazeitems.MazeGridPanel;

import java.util.List;
import java.util.Vector;

/**
 * Logical representation of a maze. Contains
 * maze metadata and layout.
 */
public class Maze {
    private final MazeGridPanel mazeGridPanel;
    private final MazeMetadata mazeMetadata;

    /**
     * Creates a new Maze instance
     * @param mazeGridPanel visual representation of the maze
     * @param mazeMetadata maze metadata
     */
    public Maze(MazeMetadata mazeMetadata, MazeGridPanel mazeGridPanel) {
        this.mazeMetadata = mazeMetadata;
        this.mazeGridPanel = mazeGridPanel;
    }

    /**
     * Gets the metadata of the maze
     * @return maze metadata
     */
    public MazeMetadata getMazeMetadata() {
        return mazeMetadata;
    }

    /**
     * Returns a maze grid that is a visual representation of the maze
     * @return maze grid
     */
    public MazeGridPanel getMazeGrid() {
        return mazeGridPanel;
    }
}
