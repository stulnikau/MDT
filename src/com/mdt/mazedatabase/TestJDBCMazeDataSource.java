package com.mdt.mazedatabase;

import static org.junit.jupiter.api.Assertions.*;

import com.mdt.gui.mazeitems.MazeGridPanel;
import com.mdt.maze.*;
import org.junit.jupiter.api.*;

import java.io.File;

public class TestJDBCMazeDataSource {
    JDBCMazeDataSource mazeDataSource;

    @BeforeEach
    public void ConstructInstance() {
        mazeDataSource = new JDBCMazeDataSource(new StubConnection());
    }

    @Test
    public void TestAddMaze() {
        assertThrows(NullPointerException.class, () -> {
            Maze maze = new Maze(
                    new MazeMetadata("foo", "bar"),
                    new MazeGridPanel(new MazeDimensions(10, 10)));
            mazeDataSource.addMaze(maze);
        });
    }

    @Test
    public void TestAddMazeNoImageFound() {
        assertThrows(NullPointerException.class, () -> {
            Maze maze = new Maze(
                    new MazeMetadata("foo", "bar"),
                    new MazeGridPanel(
                            new MazeDimensions(10, 10),
                            new File("inexistent.jpg"),
                            new File("inexistent.png")));
            mazeDataSource.addMaze(maze);
        });
    }

    @Test
    public void TestAddMazeInvalidLogo() {
        assertThrows(NullPointerException.class, () -> {
            Maze maze = new Maze(
                    new MazeMetadata("foo", "bar"),
                    new MazeGridPanel(
                            new MazeDimensions(10, 10),
                            null));
            mazeDataSource.addMaze(maze);
        });
    }

    @Test
    public void TestAddMazeTooLarge() {
        assertThrows(IllegalArgumentException.class, () -> {
            Maze maze = new Maze(
                    new MazeMetadata("foo", "bar"),
                    new MazeGridPanel(new MazeDimensions(100, 101)));
            mazeDataSource.addMaze(maze);
        });
    }

    @Test
    public void TestGracefulClose() {
        assertDoesNotThrow(() -> mazeDataSource.close());
    }

    @Test
    public void TestGetMazeGrid() {
        assertThrows(NullPointerException.class, () -> mazeDataSource.getMazeGrid(new MazeMetadata("foo", "bar")));
    }

    @Test
    public void TestGetMazeMetadataSet() {
        assertThrows(NullPointerException.class, () -> mazeDataSource.getMazeMetadataSet());
    }
}
