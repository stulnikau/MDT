package com.mdt.maze;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TestMazeDimensions {
    @Test
    public void TestLargerDimension() {
        MazeDimensions mazeDimensions = new MazeDimensions(10, 12);
        assertEquals(12, mazeDimensions.getLargerDimension());
    }

    @Test
    public void TestLargerDimensionEqualSides() {
        MazeDimensions mazeDimensions = new MazeDimensions(14, 14);
        assertEquals(14, mazeDimensions.getLargerDimension());
    }
}
