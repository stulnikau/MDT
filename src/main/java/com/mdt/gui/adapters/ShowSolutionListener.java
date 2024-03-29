package com.mdt.gui.adapters;

/**
 * Interface to implement a listener
 */
public interface ShowSolutionListener {
    /**
     * Shows or hides maze solution on the maze canvas
     * @param showSolution show solution
     * @return two Strings: maze solve-ability metric and dead end cells
     */
    String[] toggleMazeSolution(boolean showSolution);
}
