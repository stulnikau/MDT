package com.mdt.maze;

/**
 * Container for holding information about the dimensions of a maze object
 */
public class MazeDimensions {
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
}
