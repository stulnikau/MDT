package com.mdt.mazedatabase;

import static org.junit.jupiter.api.Assertions.*;

import com.mdt.gui.mazeitems.MazeGridPanel;
import com.mdt.maze.Maze;
import com.mdt.maze.MazeDimensions;
import com.mdt.maze.MazeMetadata;
import org.junit.jupiter.api.*;

import javax.swing.table.DefaultTableModel;

public class TestMazeDatabase {
    MazeDatabase mazeDatabase;

    @BeforeEach
    public void ConstructMazeDatabase() {
        FakeDataSource mockDataSource = new FakeDataSource();
        mazeDatabase = new MazeDatabase(mockDataSource);
    }

    @Test
    public void TestNoWriteEmptyDataModel() {
        DefaultTableModel tableModel = mazeDatabase.getMazeTableModel();
        assertEquals(0, tableModel.getRowCount());
    }

    @Test
    public void TestAddItemDataModel() {
        MazeMetadata mazeMetadata = new MazeMetadata("foo", "bar");
        MazeGridPanel mazeGridPanel = new MazeGridPanel(new MazeDimensions(10, 10));
        mazeDatabase.writeMaze(new Maze(mazeMetadata, mazeGridPanel));
        DefaultTableModel tableModel = mazeDatabase.getMazeTableModel();
        assertEquals(1, tableModel.getRowCount());
    }

    @Test
    public void TestAddItemDataModelLargeMaze() {
        MazeMetadata mazeMetadata = new MazeMetadata("foo", "bar");
        MazeGridPanel mazeGridPanel = new MazeGridPanel(new MazeDimensions(100, 100));
        mazeDatabase.writeMaze(new Maze(mazeMetadata, mazeGridPanel));
        DefaultTableModel tableModel = mazeDatabase.getMazeTableModel();
        assertEquals(1, tableModel.getRowCount());
    }

    @Test
    public void TestCloseOK() {
        assertDoesNotThrow(() -> mazeDatabase.close());
    }

    @Test
    public void TestGetMaze() {
        MazeMetadata mazeMetadata = new MazeMetadata("foo", "bar");
        MazeGridPanel mazeGridPanel = new MazeGridPanel(new MazeDimensions(10, 10));
        Maze originalMaze = new Maze(mazeMetadata, mazeGridPanel);
        mazeDatabase.writeMaze(originalMaze);
        Maze newMaze = mazeDatabase.getMaze(mazeMetadata);
        assertEquals(originalMaze.getMazeMetadata().toString(), newMaze.getMazeMetadata().toString());
    }

    @Test
    public void TestGetMazeLargeMaze() {
        MazeMetadata mazeMetadata = new MazeMetadata("foo", "bar");
        MazeGridPanel mazeGridPanel = new MazeGridPanel(new MazeDimensions(100, 100));
        Maze originalMaze = new Maze(mazeMetadata, mazeGridPanel);
        mazeDatabase.writeMaze(originalMaze);
        Maze newMaze = mazeDatabase.getMaze(mazeMetadata);
        assertEquals(originalMaze.getMazeMetadata().toString(), newMaze.getMazeMetadata().toString());
    }

    @Test
    public void TestNonEmptyDatabaseOnStartup() {
        FakeDataSource mockDataSource = new FakeDataSource();
        MazeMetadata mazeMetadata = new MazeMetadata("foo", "bar");
        MazeGridPanel mazeGridPanel = new MazeGridPanel(new MazeDimensions(10, 10));
        mockDataSource.addMaze(new Maze(mazeMetadata, mazeGridPanel));
        MazeDatabase mazeDatabase1 = new MazeDatabase(mockDataSource);
        DefaultTableModel tableModel = mazeDatabase1.getMazeTableModel();
        assertEquals(1, tableModel.getRowCount());
    }

    @Test
    public void TestNonEmptyDatabaseOnStartupLargeMaze() {
        FakeDataSource mockDataSource = new FakeDataSource();
        MazeMetadata mazeMetadata = new MazeMetadata("foo", "bar");
        MazeGridPanel mazeGridPanel = new MazeGridPanel(new MazeDimensions(100, 100));
        mockDataSource.addMaze(new Maze(mazeMetadata, mazeGridPanel));
        MazeDatabase mazeDatabase1 = new MazeDatabase(mockDataSource);
        DefaultTableModel tableModel = mazeDatabase1.getMazeTableModel();
        assertEquals(1, tableModel.getRowCount());
    }
}
