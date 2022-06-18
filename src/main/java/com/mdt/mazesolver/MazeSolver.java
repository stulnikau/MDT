package com.mdt.mazesolver;

import com.mdt.maze.MazeLayout;
import com.mdt.maze.MazeLocation;

import java.util.ArrayList;
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

    /**
     * Implementation of DFS algorithm for maze solution finding
     * Credit: Baeldung https://www.baeldung.com/java-solve-maze
     * @param maze maze layout
     * @param mazeLocation current maze location
     * @param path current solution path
     * @return whether the current location is part of the solution
     */
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

        if (path.size() > 0) {path.remove(path.size() - 1);}
        return false;
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

    /**
     * Get the number of non-wall cells in the layout
     * @return count of non-wall cells in the layout
     */
    private int freeCells(MazeLayout mazeLayout) {
        int freeCells = 0;
        for (int row = 0; row < mazeLayout.getDimensions().getHeight(); row++) {
            for (int col = 0; col < mazeLayout.getDimensions().getWidth(); col++) {
                if (!mazeLayout.isWall(new MazeLocation(row, col))) {freeCells++;}
            }
        }
        return freeCells;
    }

    /**
     * @param mazeLayout maze layout
     * @param mazeLocation maze location
     * @return whether a free cell has 3 walls around it (only 1 exit)
     */
    private boolean deadEndCell(MazeLayout mazeLayout, MazeLocation mazeLocation) {
        int walls = 0;
        for (int[] move : DIRECTIONS) {
            if (!mazeLayout.isWall(mazeLocation)
                    && mazeLayout.isValidLocation(getNextMazeLocation(mazeLocation, move[0], move[1]))
                    && mazeLayout.isWall(getNextMazeLocation(mazeLocation, move[0], move[1]))) {walls++;}
        }
        return walls == 3;
    }

    /**
     * Get the proportion of free cells in maze that are reached by the solution
     * @param mazeLayout maze layout
     * @param solution maze solution
     * @return proportion of cells
     */
    public double getSolutionCellsProportionMetric(MazeLayout mazeLayout, Vector<MazeLocation> solution) {
        int freeCells = freeCells(mazeLayout);
        int solutionCells = solution.size();
        return (double) solutionCells / (double) freeCells * 100;
    }

    /**
     * Get the proportion of dead end cells in maze
     * @param mazeLayout maze layout
     * @return proportion of dead end cells
     */
    public double getDeadEndCells(MazeLayout mazeLayout) {
        int freeCells = freeCells(mazeLayout);

        int deadEnds = 0;
        for (int row = 0; row < mazeLayout.getDimensions().getHeight(); row++) {
            for (int col = 0; col < mazeLayout.getDimensions().getWidth(); col++) {
                if (deadEndCell(mazeLayout, new MazeLocation(row, col))) {
                    deadEnds++;
                }
            }
        }
        return (double) deadEnds / (double) freeCells * 100;
    }
}
