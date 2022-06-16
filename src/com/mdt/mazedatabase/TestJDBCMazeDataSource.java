package com.mdt.mazedatabase;

import static org.junit.jupiter.api.Assertions.*;

import com.mdt.gui.mazeitems.MazeGridPanel;
import com.mdt.maze.Maze;
import com.mdt.maze.MazeDimensions;
import com.mdt.maze.MazeMetadata;
import org.junit.jupiter.api.*;

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
    public void TestAddMazeTooLarge() {
        assertThrows(IllegalArgumentException.class, () -> {
            Maze maze = new Maze(
                    new MazeMetadata("foo", "bar"),
                    new MazeGridPanel(new MazeDimensions(100, 101)));
            mazeDataSource.addMaze(maze);
        });
    }
}
