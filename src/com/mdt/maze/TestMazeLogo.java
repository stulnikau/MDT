package com.mdt.maze;
import org.junit.jupiter.api.*;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class TestMazeLogo {
    MazeDimensions testDimensions;
    MazeLocation testLocation;
    File testMazeLogo;
    MazeLogo mazeLogo;


    @BeforeEach
    public void SetUpObject() {
        testDimensions = new MazeDimensions(2, 2);
        testLocation = new MazeLocation(3, 3);
        testMazeLogo = new File("./src/com/mdt/gui/mazeitems/arrow.png");
        mazeLogo = new MazeLogo(testMazeLogo,
                testDimensions, testLocation);
    }

    @Test
    public void TestGetDimensions() {
        assertEquals(testDimensions, mazeLogo.getDimensions());
    }

    @Test
    public void TestGetLocation() {
        assertEquals(testLocation, mazeLogo.getLocation());
    }

    @Test
    public void TestGetImage() {
        assertEquals(testMazeLogo, mazeLogo.getImage());
    }

    @Test
    public void TestWithinLogoBounds() {
        assertTrue(mazeLogo.withinLogoBounds(testLocation));
    }

    @Test
    public void TestOutsideLogoBounds() {
        MazeLogo mazeLogo1 = new MazeLogo(testMazeLogo,
                testDimensions, new MazeLocation(5,4));
        assertFalse(mazeLogo.withinLogoBounds(mazeLogo1.getLocation()));
    }
}