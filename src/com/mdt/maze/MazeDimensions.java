package com.mdt.maze;

import java.io.Serializable;

/**
 * Container for holding information about the dimensions of a maze object
 */
public class MazeDimensions implements Serializable {
    private final int width;
    private final int height;

    /**
     * Creates a new maze dimensions object from provided width and height
     * @param w object width
     * @param h object height
     */
    public MazeDimensions(int w, int h) {
        if (w < 1 || h < 1) {
            throw new IllegalArgumentException("width and height must be positive");
        }
        if (w > 100 || h > 100) {
            throw new IllegalArgumentException("Dimension must be 100x100 or less");
        }

        this.width = w;
        this.height = h;
    }

    /**
     * Gets the object width
     * @return object width in cells
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the object height
     * @return object height in cells
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return gets the largest of the height and width
     */
    public int getLargestSide() {
        return Math.max(width, height);
    }

    /**
     * Checks whether the location is a valid location within the bounds of the
     * maze dimensions
     * @param mazeLocation location to check
     * @return boolean indicating whether the location is valid
     */
    public boolean validLocation(MazeLocation mazeLocation) {
        return (0 <= mazeLocation.getCol() && mazeLocation.getCol() <= width - 1) &&
                (0 <= mazeLocation.getRow() && mazeLocation.getRow() <= height - 1);
    }

    /**
     * Check whether the logo fits within the boundaries
     * @param mazeLogo Maze logo
     * @return Whether the logo is within the dimensions
     */
    public boolean withinBounds(MazeLogo mazeLogo) {
        return (mazeLogo.getLocation().getCol() + mazeLogo.getDimensions().getWidth() - 1) <= this.width &&
                (mazeLogo.getLocation().getRow() + mazeLogo.getDimensions().getHeight() - 1) <= this.height;
    }
}
