package com.mdt.maze;

import static org.junit.jupiter.api.Assertions.*;

import com.mdt.gui.mazeitems.MazeCellGenericPanel;
import com.mdt.gui.mazeitems.MazeCellPanel;
import org.junit.jupiter.api.*;

import java.util.TreeMap;
import java.util.Map;

public class TestMazeLayout {
    @Test
    public void TestIsValidLocation() {
        MazeDimensions dimensions = new MazeDimensions(10, 10);
        MazeLayout mazeLayout = new MazeLayout(dimensions, new TreeMap<>());
        assertTrue(mazeLayout.isValidLocation(new MazeLocation(1, 2)));
    }

    @Test
    public void TestIsInvalidLocation() {
        MazeDimensions dimensions = new MazeDimensions(10, 10);
        MazeLayout mazeLayout = new MazeLayout(dimensions, new TreeMap<>());
        assertFalse(mazeLayout.isValidLocation(new MazeLocation(10, 12)));
    }

    @Test
    public void TestIsWall() {
        MazeCellGenericPanel mazeCellGenericPanel = new MazeCellPanel(true);
        TreeMap<MazeLocation, MazeCellGenericPanel> cells = new TreeMap<>();
        MazeLocation mazeLocation = new MazeLocation(0, 0);
        cells.put(mazeLocation, mazeCellGenericPanel);
        MazeDimensions dimensions = new MazeDimensions(1, 1);
        MazeLayout mazeLayout = new MazeLayout(dimensions, cells);
        assertTrue(mazeLayout.isWall(new MazeLocation(0, 0)));
    }

    @Test
    public void TestIsNotWall() {
        MazeCellGenericPanel mazeCellGenericPanel = new MazeCellPanel(false);
        TreeMap<MazeLocation, MazeCellGenericPanel> cells = new TreeMap<>();
        MazeLocation mazeLocation = new MazeLocation(0, 0);
        cells.put(mazeLocation, mazeCellGenericPanel);
        MazeDimensions dimensions = new MazeDimensions(1, 1);
        MazeLayout mazeLayout = new MazeLayout(dimensions, cells);
        assertFalse(mazeLayout.isWall(mazeLocation));
    }

    @Test
    public void TestIsExplored() {
        MazeLocation mazeLocation = new MazeLocation(0, 0);
        MazeLayout mazeLayout = new MazeLayout(new MazeDimensions(1, 1), new TreeMap<>());
        mazeLayout.setVisited(mazeLocation, true);
        assertTrue(mazeLayout.isExplored(mazeLocation));
    }

    @Test
    public void TestIsNotExplored() {
        MazeLocation mazeLocation = new MazeLocation(0, 0);
        MazeLayout mazeLayout = new MazeLayout(new MazeDimensions(1, 1), new TreeMap<>());
        mazeLayout.setVisited(mazeLocation, true);
        assertTrue(mazeLayout.isExplored(mazeLocation));
    }

    @Test
    public void TestIsExit() {
        MazeDimensions dimensions = new MazeDimensions(5, 10);
        MazeLocation mazeLocation = new MazeLocation(9, 3);
        MazeLayout mazeLayout = new MazeLayout(dimensions, new TreeMap<>());
        assertTrue(mazeLayout.isExit(mazeLocation));
    }

    @Test
    public void TestIsNotExit() {
        MazeDimensions dimensions = new MazeDimensions(5, 10);
        MazeLocation mazeLocation = new MazeLocation(9, 4);
        MazeLayout mazeLayout = new MazeLayout(dimensions, new TreeMap<>());
        assertFalse(mazeLayout.isExit(mazeLocation));
    }

    @Test
    public void TestGetEntry() {
        MazeLayout mazeLayout = new MazeLayout(new MazeDimensions(5, 10), new TreeMap<>());
        assertEquals(0, mazeLayout.getEntry().getRow());
        assertEquals(1, mazeLayout.getEntry().getCol());
    }

    @Test
    public void TestDimensions() {
        MazeLayout mazeLayout = new MazeLayout(new MazeDimensions(5, 10), new TreeMap<>());
        assertEquals(5, mazeLayout.getDimensions().getWidth());
        assertEquals(10, mazeLayout.getDimensions().getHeight());
    }
}
