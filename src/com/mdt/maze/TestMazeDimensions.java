package com.mdt.maze;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TestMazeDimensions {
    @Test
    public void TestLargerDimension() {
        MazeDimensions mazeDimensions = new MazeDimensions(10, 12);
        assertEquals(12, mazeDimensions.getLargestSide());
    }

    @Test
    public void TestLargerDimensionEqualSides() {
        MazeDimensions mazeDimensions = new MazeDimensions(14, 14);
        assertEquals(14, mazeDimensions.getLargestSide());
    }

    @Test
    public void TestLocationWithin() {
        MazeDimensions mazeDimensions = new MazeDimensions(14, 14);
        MazeLocation location = new MazeLocation(1, 1);
        assertTrue(mazeDimensions.validLocation(location));
    }

    @Test
    public void TestLocationRight() {
        MazeDimensions mazeDimensions = new MazeDimensions(10, 14);
        MazeLocation location = new MazeLocation(1, 11);
        assertFalse(mazeDimensions.validLocation(location));
    }

    @Test
    public void TestLocationBottom() {
        MazeDimensions mazeDimensions = new MazeDimensions(14, 10);
        MazeLocation location = new MazeLocation(12, 1);
        assertFalse(mazeDimensions.validLocation(location));
    }
}
