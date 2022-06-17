package com.mdt.mazesolver;

import com.mdt.maze.MazeLayout;
import com.mdt.maze.MazeLocation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * Helper class to retrieve maze solution and solveability metrics
 * Credit: Baeldung https://www.baeldung.com/java-solve-maze
 */
public class MazeSolver {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    /**
     * Get new adjacent maze location
     * @param mazeLocation current maze location
     * @param i moves up/down
     * @param j moves left/right
     * @return new coordinate with the given offset
     */
    private MazeLocation getNextMazeLocation(MazeLocation mazeLocation, int i, int j) {
        return new MazeLocation(mazeLocation.getRow() + i, mazeLocation.getCol() + j);
    }

    private boolean explore(MazeLayout maze, MazeLocation mazeLocation, List<MazeLocation> path) {
        if (
                !maze.isValidLocation(mazeLocation)
                        || maze.isWall(mazeLocation)
                        || maze.isExplored(mazeLocation)
        ) {
            return false;
        }

        path.add(mazeLocation);
        maze.setVisited(mazeLocation, true);

        if (maze.isExit(mazeLocation)) {
            return true;
        }

        for (int[] direction : DIRECTIONS) {
            MazeLocation nextMazeLocation = getNextMazeLocation(
                    mazeLocation, direction[0], direction[1]);
            if (
                    explore(
                            maze,
                            nextMazeLocation,
                            path
                    )
            ) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    /**
     * Gets the percentage of cells that are reached by the
     * optimal solution to the maze
     * @return number of cells expressed as a percentage of
     * the total number of cells in the maze. Returns 0 if
     * no solution exists
     */
    public double getCellsReachedByOptimalSolution() {
        return 0;
    }

    /**
     * Gets the percentage of cells that are dead ends
     * @return number of cells expressed as a percentage of
     * the total number of cells in the maze
     */
    public double getDeadEndCells() {
        return 0;
    }

    /**
     * Retrieves an optimal solution to the maze
     * @return Optimal solution to the maze in the form
     * of a list of grid values. Returns empty vector if
     * no solution exists
     */
    public Vector<MazeLocation> getOptimalSolution(MazeLayout maze) {
        ArrayList<MazeLocation> path = new ArrayList<>();
        explore(
                maze,
                maze.getEntry(),
                path
        );
        return new Vector<>(path);
    }
}
