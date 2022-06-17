package com.mdt.maze;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TestMazeLocation {

    @Test
    public void TestNegativeRowsAndColumn(){
        assertThrows(IllegalArgumentException.class,
                ()-> {
                    MazeLocation mazeLocation = new MazeLocation( -1, -2);
                });
    }

    @Test
    public void TestGetRow() {
        MazeLocation mazeLocation = new MazeLocation( 1, 2);
         assertEquals(1, mazeLocation.getRow());
    }

    @Test
    public void TestGetCol() {
        MazeLocation mazeLocation = new MazeLocation( 1, 2);
        assertEquals(2, mazeLocation.getCol());
    }
}