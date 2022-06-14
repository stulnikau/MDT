package com.mdt.maze;

import java.io.File;

/**
 * Specifies properties of MazeLogos on the maze grid
 */
public class MazeLogo implements MazeItem, MazeImage {
    private final File logo;
    private final MazeDimensions dimensions;
    private final MazeLocation location;

    /**
     * Gets the dimensions of the item
     * @return item dimensions on the maze grid
     */
    @Override
    public MazeDimensions getDimensions() {
        return dimensions;
    }

    /**
     * Gets the item location on the maze grid
     * @return item location on the maze grid
     */
    @Override
    public MazeLocation getLocation() {
        return location;
    }

    /**
     * Gets the ImageIcon corresponding to the MazeLogo instance
     * @return ImageIcon corresponding to the MazeLogo instance
     */
    @Override
    public File getImage() {
        return logo;
    }

    /**
     * Creates a new maze logo from parameters
     * @param logo maze logo file
     * @param dimensions maze logo dimensions in cells
     * @param location maze logo positioning on the maze canvas
     */
    public MazeLogo(File logo, MazeDimensions dimensions, MazeLocation location) {
        this.logo = logo;
        this.dimensions = dimensions;
        this.location = location;
    }

    /**
     * Checks whether a maze location is located inside the maze logo
     * @param location location on the maze
     * @return boolean indicating whether the location is within the logo bounds
     */
    public boolean withinLogoBounds(MazeLocation location) {
        boolean colInside = (this.location.getCol() <= location.getCol())
                && (location.getCol() <= (this.location.getCol() + this.dimensions.getWidth() - 1));
        boolean rowInside = (this.location.getRow() <= location.getRow())
                && (location.getRow() <= (this.location.getRow() + this.dimensions.getHeight() - 1));
        return colInside && rowInside;
    }
}
