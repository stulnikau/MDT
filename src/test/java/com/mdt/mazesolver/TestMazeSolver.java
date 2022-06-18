package com.mdt.mazesolver;

import static org.junit.jupiter.api.Assertions.*;

import com.mdt.gui.mazeitems.MazeCellGenericPanel;
import com.mdt.gui.mazeitems.MazeCellPanel;
import com.mdt.gui.mazeitems.MazeGridPanel;
import com.mdt.maze.*;
import com.mdt.mazeexport.MazeExportHandler;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.Vector;
import java.util.function.BooleanSupplier;

public class TestMazeSolver {
    @Test
    public void TestMazeSolution() {
        MazeSolver mazeSolver = new MazeSolver();
        MazeCellGenericPanel wallPanel = new MazeCellPanel(true);
        MazeCellGenericPanel walkPanel = new MazeCellPanel(false);
        TreeMap<MazeLocation, MazeCellGenericPanel> cells = new TreeMap<>();
        cells.put(new MazeLocation(0, 0), wallPanel);
        cells.put(new MazeLocation(0, 1), walkPanel);
        cells.put(new MazeLocation(0, 2), wallPanel);
        cells.put(new MazeLocation(0, 3), wallPanel);
        cells.put(new MazeLocation(1, 0), wallPanel);
        cells.put(new MazeLocation(1, 1), walkPanel);
        cells.put(new MazeLocation(1, 2), walkPanel);
        cells.put(new MazeLocation(1, 3), wallPanel);
        cells.put(new MazeLocation(2, 0), wallPanel);
        cells.put(new MazeLocation(2, 1), wallPanel);
        cells.put(new MazeLocation(2, 2), walkPanel);
        cells.put(new MazeLocation(2, 3), wallPanel);
        cells.put(new MazeLocation(3, 0), wallPanel);
        cells.put(new MazeLocation(3, 1), wallPanel);
        cells.put(new MazeLocation(3, 2), walkPanel);
        cells.put(new MazeLocation(3, 3), wallPanel);
        mazeSolver.getOptimalSolution(new MazeLayout(
                new MazeDimensions(4, 4),
                cells
                )
        );
        MazeLayout mazeLayout = new MazeLayout(new MazeDimensions(4, 4), cells);
        Vector<MazeLocation> expectedSolution = new Vector<>();
        expectedSolution.add(new MazeLocation(0, 1));
        expectedSolution.add(new MazeLocation(1, 1));
        expectedSolution.add(new MazeLocation(1, 2));
        expectedSolution.add(new MazeLocation(2, 2));
        expectedSolution.add(new MazeLocation(3, 2));
        assertEquals(expectedSolution.toString(), mazeSolver.getOptimalSolution(mazeLayout).toString());
    }

    @Test
    public void TestMazeSolutionCurved() {
        MazeSolver mazeSolver = new MazeSolver();
        MazeCellGenericPanel wallPanel = new MazeCellPanel(true);
        MazeCellGenericPanel walkPanel = new MazeCellPanel(false);
        TreeMap<MazeLocation, MazeCellGenericPanel> cells = new TreeMap<>();
        cells.put(new MazeLocation(0, 0), wallPanel);
        cells.put(new MazeLocation(0, 1), walkPanel);
        cells.put(new MazeLocation(0, 2), wallPanel);
        cells.put(new MazeLocation(0, 3), wallPanel);
        cells.put(new MazeLocation(1, 0), wallPanel);
        cells.put(new MazeLocation(1, 1), walkPanel);
        cells.put(new MazeLocation(1, 2), walkPanel);
        cells.put(new MazeLocation(1, 3), wallPanel);
        cells.put(new MazeLocation(2, 0), wallPanel);
        cells.put(new MazeLocation(2, 1), wallPanel);
        cells.put(new MazeLocation(2, 2), walkPanel);
        cells.put(new MazeLocation(2, 3), wallPanel);
        cells.put(new MazeLocation(3, 0), wallPanel);
        cells.put(new MazeLocation(3, 1), walkPanel);
        cells.put(new MazeLocation(3, 2), walkPanel);
        cells.put(new MazeLocation(3, 3), wallPanel);
        cells.put(new MazeLocation(4, 0), wallPanel);
        cells.put(new MazeLocation(4, 1), walkPanel);
        cells.put(new MazeLocation(4, 2), wallPanel);
        cells.put(new MazeLocation(4, 3), wallPanel);
        cells.put(new MazeLocation(5, 0), wallPanel);
        cells.put(new MazeLocation(5, 1), walkPanel);
        cells.put(new MazeLocation(5, 2), walkPanel);
        cells.put(new MazeLocation(5, 3), wallPanel);
        cells.put(new MazeLocation(6, 0), wallPanel);
        cells.put(new MazeLocation(6, 1), wallPanel);
        cells.put(new MazeLocation(6, 2), walkPanel);
        cells.put(new MazeLocation(6, 3), wallPanel);
        MazeLayout mazeLayout = new MazeLayout(new MazeDimensions(4, 7), cells);
        Vector<MazeLocation> expectedSolution = new Vector<>();
        expectedSolution.add(new MazeLocation(0, 1));
        expectedSolution.add(new MazeLocation(1, 1));
        expectedSolution.add(new MazeLocation(1, 2));
        expectedSolution.add(new MazeLocation(2, 2));
        expectedSolution.add(new MazeLocation(3, 2));
        expectedSolution.add(new MazeLocation(3, 1));
        expectedSolution.add(new MazeLocation(4, 1));
        expectedSolution.add(new MazeLocation(5, 1));
        expectedSolution.add(new MazeLocation(5, 2));
        expectedSolution.add(new MazeLocation(6, 2));
        assertEquals(expectedSolution.toString(), mazeSolver.getOptimalSolution(mazeLayout).toString());
    }

    @Test
    public void TestMazeSolutionMetricCurved() {
        MazeSolver mazeSolver = new MazeSolver();
        MazeCellGenericPanel wallPanel = new MazeCellPanel(true);
        MazeCellGenericPanel walkPanel = new MazeCellPanel(false);
        TreeMap<MazeLocation, MazeCellGenericPanel> cells = new TreeMap<>();
        cells.put(new MazeLocation(0, 0), wallPanel);
        cells.put(new MazeLocation(0, 1), walkPanel);
        cells.put(new MazeLocation(0, 2), wallPanel);
        cells.put(new MazeLocation(0, 3), wallPanel);
        cells.put(new MazeLocation(1, 0), wallPanel);
        cells.put(new MazeLocation(1, 1), walkPanel);
        cells.put(new MazeLocation(1, 2), walkPanel);
        cells.put(new MazeLocation(1, 3), wallPanel);
        cells.put(new MazeLocation(2, 0), wallPanel);
        cells.put(new MazeLocation(2, 1), wallPanel);
        cells.put(new MazeLocation(2, 2), walkPanel);
        cells.put(new MazeLocation(2, 3), wallPanel);
        cells.put(new MazeLocation(3, 0), wallPanel);
        cells.put(new MazeLocation(3, 1), walkPanel);
        cells.put(new MazeLocation(3, 2), walkPanel);
        cells.put(new MazeLocation(3, 3), wallPanel);
        cells.put(new MazeLocation(4, 0), wallPanel);
        cells.put(new MazeLocation(4, 1), walkPanel);
        cells.put(new MazeLocation(4, 2), wallPanel);
        cells.put(new MazeLocation(4, 3), wallPanel);
        cells.put(new MazeLocation(5, 0), wallPanel);
        cells.put(new MazeLocation(5, 1), walkPanel);
        cells.put(new MazeLocation(5, 2), walkPanel);
        cells.put(new MazeLocation(5, 3), wallPanel);
        cells.put(new MazeLocation(6, 0), wallPanel);
        cells.put(new MazeLocation(6, 1), wallPanel);
        cells.put(new MazeLocation(6, 2), walkPanel);
        cells.put(new MazeLocation(6, 3), wallPanel);
        MazeLayout mazeLayout = new MazeLayout(new MazeDimensions(4, 7), cells);
        Vector<MazeLocation> solution = mazeSolver.getOptimalSolution(mazeLayout);
        assertEquals(100.0, mazeSolver.getSolutionCellsProportionMetric(mazeLayout, solution));
    }

    @Test
    public void TestMazeDeadEndsCurved() {
        MazeSolver mazeSolver = new MazeSolver();
        MazeCellGenericPanel wallPanel = new MazeCellPanel(true);
        MazeCellGenericPanel walkPanel = new MazeCellPanel(false);
        TreeMap<MazeLocation, MazeCellGenericPanel> cells = new TreeMap<>();
        cells.put(new MazeLocation(0, 0), wallPanel);
        cells.put(new MazeLocation(0, 1), walkPanel);
        cells.put(new MazeLocation(0, 2), wallPanel);
        cells.put(new MazeLocation(0, 3), wallPanel);
        cells.put(new MazeLocation(1, 0), wallPanel);
        cells.put(new MazeLocation(1, 1), walkPanel);
        cells.put(new MazeLocation(1, 2), walkPanel);
        cells.put(new MazeLocation(1, 3), wallPanel);
        cells.put(new MazeLocation(2, 0), wallPanel);
        cells.put(new MazeLocation(2, 1), wallPanel);
        cells.put(new MazeLocation(2, 2), walkPanel);
        cells.put(new MazeLocation(2, 3), wallPanel);
        cells.put(new MazeLocation(3, 0), wallPanel);
        cells.put(new MazeLocation(3, 1), walkPanel);
        cells.put(new MazeLocation(3, 2), walkPanel);
        cells.put(new MazeLocation(3, 3), wallPanel);
        cells.put(new MazeLocation(4, 0), wallPanel);
        cells.put(new MazeLocation(4, 1), walkPanel);
        cells.put(new MazeLocation(4, 2), wallPanel);
        cells.put(new MazeLocation(4, 3), wallPanel);
        cells.put(new MazeLocation(5, 0), wallPanel);
        cells.put(new MazeLocation(5, 1), walkPanel);
        cells.put(new MazeLocation(5, 2), walkPanel);
        cells.put(new MazeLocation(5, 3), wallPanel);
        cells.put(new MazeLocation(6, 0), wallPanel);
        cells.put(new MazeLocation(6, 1), wallPanel);
        cells.put(new MazeLocation(6, 2), walkPanel);
        cells.put(new MazeLocation(6, 3), wallPanel);
        MazeLayout mazeLayout = new MazeLayout(new MazeDimensions(4, 7), cells);
        assertEquals(0.0, mazeSolver.getDeadEndCells(mazeLayout));
    }
}
