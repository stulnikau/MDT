package com.mdt.maze;
import org.junit.jupiter.api.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


public class TestMazeDimensions {

    @Test
    public void TestNegativeNumbers() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    MazeDimensions mazeDimensions = new MazeDimensions(-1, -1);
                });
    }

    @Test
    public void TestCheckWidth() {
        MazeDimensions mazeDimensions = new MazeDimensions(10, 15);
        assertEquals(10, mazeDimensions.getWidth());
    }

    @Test
    public void TestCheckHeight() {
        MazeDimensions mazeDimensions = new MazeDimensions(10, 15);
        assertEquals(15, mazeDimensions.getHeight());
    }

    @Test
    public void TestMaxDimensions() {
        assertDoesNotThrow(() -> {
            MazeDimensions mazeDimensions = new MazeDimensions(100, 100);
        });
    }

    @Test
    public void TestDimensionsTooLarge() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    MazeDimensions mazeDimensions = new MazeDimensions(101, 200);
                });
    }

    @Test
    public void TestMazeLogoWithinBounds() {
        MazeDimensions mazeDimensions = new MazeDimensions(20, 30);
        MazeLogo mazeLogo = new MazeLogo(new File("./src/com/mdt/gui/mazeitems/arrow.png"),
                new MazeDimensions(2, 2), new MazeLocation(3, 3) );
        assertTrue( mazeDimensions.withinBounds(mazeLogo));
    }

    @Test
    public void TestMazeInContactWithBorder() {
        MazeDimensions mazeDimensions = new MazeDimensions(20, 20);
        MazeLogo mazeLogo = new MazeLogo(new File("./src/com/mdt/gui/mazeitems/arrow.png"),
                new MazeDimensions(2, 2), new MazeLocation(2, 19) );
        assertTrue( mazeDimensions.withinBounds(mazeLogo));
    }

    @Test
    public void TestMazeLogoOutsideBounds() {
        MazeDimensions mazeDimensions = new MazeDimensions(20, 30);
        MazeLogo mazeLogo = new MazeLogo(new File("./src/com/mdt/gui/mazeitems/arrow.png"),
                new MazeDimensions(2, 2), new MazeLocation(22, 36) );
        assertFalse( mazeDimensions.withinBounds(mazeLogo));
    }

    @Test
    public void TestMazeHalfInsideAndHalfOutside() {
        MazeDimensions mazeDimensions = new MazeDimensions(20, 30);
        MazeLogo mazeLogo = new MazeLogo(new File("./src/com/mdt/gui/mazeitems/arrow.png"),
                new MazeDimensions(2, 2), new MazeLocation(2, 20) );
        assertFalse( mazeDimensions.withinBounds(mazeLogo));
    }
}