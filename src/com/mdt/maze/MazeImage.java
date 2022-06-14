package com.mdt.maze;

import java.io.File;

/**
 * Interface for images placed on the maze
 */
public interface MazeImage {
    /**
     * Gets the ImageIcon corresponding to the MazeImage instance
     * @return ImageIcon corresponding to the MazeImage instance
     */
    File getImage();
}
