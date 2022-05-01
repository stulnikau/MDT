package com.mdt.maze;

import javax.swing.*;

/**
 * Interface for images placed on the maze
 */
public interface MazeImage {
    /**
     * Gets the ImageIcon corresponding to the MazeImage instance
     * @return ImageIcon corresponding to the MazeImage instance
     */
    ImageIcon getImage();

    /**
     * Sets the ImageIcon corresponding to the MazeImage instance
     * @param image ImageIcon to be bound to the MazeImage instance
     */
    void setImage(ImageIcon image);
}
