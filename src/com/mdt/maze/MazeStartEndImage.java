package com.mdt.maze;

import javax.swing.*;

/**
 * Specifies the properties of start/end images on the maze canvas
 */
public class MazeStartEndImage extends MazeEntryExitPoint implements MazeImage {
    /**
     * Gets the ImageIcon corresponding to the MazeStartEndImage instance
     * @return ImageIcon corresponding to the MazeStartEndImage instance
     */
    @Override
    public ImageIcon getImage() {
        return null;
    }

    /**
     * Sets the ImageIcon corresponding to the MazeStartEndImage instance
     * @param image ImageIcon to be bound to the MazeStartEndImage instance
     */
    @Override
    public void setImage(ImageIcon image) {

    }

    /**
     * Gets the dimensions of the item
     * @return item dimensions on the maze grid
     */
    @Override
    public MazeDimensions getDimensions() {
        return null;
    }

    /**
     * Gets the item location on the maze grid
     * @return item location on the maze grid
     */
    @Override
    public MazeLocation getLocation() {
        return null;
    }
}
