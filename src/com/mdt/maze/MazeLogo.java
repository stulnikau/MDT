package com.mdt.maze;

import javax.swing.*;

/**
 * Specifies properties of MazeLogos on the maze grid
 */
public class MazeLogo implements MazeItem, MazeImage {
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

    /**
     * Gets the ImageIcon corresponding to the MazeLogo instance
     * @return ImageIcon corresponding to the MazeLogo instance
     */
    @Override
    public ImageIcon getImage() {
        return null;
    }

    /**
     * Sets the ImageIcon corresponding to the MazeLogo instance
     * @param image ImageIcon to be bound to the MazeLogo instance
     */
    @Override
    public void setImage(ImageIcon image) {

    }
}
