package com.mdt.maze;

import com.mdt.gui.mazeitems.MazeCellGenericPanel;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

/**
 * Container for the layout of the maze, used for maze solving
 * Credit: https://github.com/eugenp/tutorials/blob/master/algorithms-modules/algorithms-miscellaneous-2/src/main/java/com/baeldung/algorithms/maze/solver/Maze.java
 */
public class MazeLayout {
    MazeDimensions dimensions;
    Map<MazeLocation, MazeCellGenericPanel> cells;
    Vector<MazeLocation> explored;
    private boolean[][] visited;

    /**
     * Container for the layout of the maze, used for maze solving
     * @param dimensions dimensions of the maze
     * @param cells mapping between maze locations and cell panels
     */
    public MazeLayout(MazeDimensions dimensions, TreeMap<MazeLocation, MazeCellGenericPanel> cells) {
        this.dimensions = dimensions;
        this.cells = cells;
        explored = new Vector<>();
        visited = new boolean[dimensions.getHeight()][dimensions.getWidth()];
    }

    /**
     * @param mazeLocation maze location
     * @return if the location exists on the maze
     */
    public boolean isValidLocation(MazeLocation mazeLocation) {
        return dimensions.validLocation(mazeLocation);
    }

    /**
     * @param mazeLocation maze location
     * @return if the cell at the location is a wall
     */
    public boolean isWall(MazeLocation mazeLocation) {
        return cells.get(mazeLocation).isWall();
    }

    /**
     * @param mazeLocation maze location
     * @return if the cell has already been marked as visited
     */
    public boolean isExplored(MazeLocation mazeLocation) {
        return visited[mazeLocation.getRow()][mazeLocation.getCol()];
    }

    /**
     * Sets the maze location as visited
     * @param mazeLocation maze location
     * @param visitedFlag boolean indicating whether the current maze location should
     *                    be set as explored
     */
    public void setVisited(MazeLocation mazeLocation, boolean visitedFlag) {
        visited[mazeLocation.getRow()][mazeLocation.getCol()] = visitedFlag;
    }

    /**
     * @param mazeLocation maze location
     * @return if the cell is an exit
     */
    public boolean isExit(MazeLocation mazeLocation) {
        return ((mazeLocation.getRow() == dimensions.getHeight() - 1)
                && (mazeLocation.getCol() == dimensions.getWidth() - 2));
    }

    /**
     * @return layout dimensions
     */
    public MazeDimensions getDimensions() {
        return dimensions;
    }

    /**
     * @return if the cell is an entry to the maze
     */
    public MazeLocation getEntry() {
        return new MazeLocation(0, 1);
    }
}
