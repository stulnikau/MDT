package com.mdt.maze;

/**
 * Maze entry or exit point which can be either just a wall opening
 * or a start/end image
 */
public class MazeEntryExitPoint implements MazeItem {
    /**
     * Describes the type of the point: start or end
     */
    private enum PointType {
        START,
        END
    }

    private PointType pointType;

    /**
     * Gets the point's dimensions
     * @return dimensions
     */
    @Override
    public MazeDimensions getDimensions() {
        return null;
    }

    /**
     * Gets the point's location
     * @return location
     */
    @Override
    public MazeLocation getLocation() {
        return null;
    }

    /**
     * Sets the point type (start/end)
     * @param pointType point type (start/end)
     */
    public void setPointType(PointType pointType) {

    }

    /**
     * Gets the point type (start/end)
     * @return point type (start/end)
     */
    public PointType getPointType() {
        return null;
    }
}
