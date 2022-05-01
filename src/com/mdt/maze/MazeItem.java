package com.mdt.maze;

/**
 * Interface for maze items, such as logos, cells, maze starts/ends
 */
public interface MazeItem {
    /**
     * Gets the dimensions of the item
     * @return item dimensions on the maze grid
     */
    MazeDimensions getDimensions();

    /**
     * Gets the item location on the maze grid
     * @return item location on the maze grid
     */
    MazeLocation getLocation();
}
