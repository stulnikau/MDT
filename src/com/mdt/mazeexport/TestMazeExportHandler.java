package com.mdt.mazeexport;

import static org.junit.jupiter.api.Assertions.*;

import com.mdt.gui.mazeitems.MazeGridPanel;
import com.mdt.maze.Maze;
import com.mdt.maze.MazeDimensions;
import com.mdt.maze.MazeMetadata;
import org.junit.jupiter.api.*;

import java.io.File;

public class TestMazeExportHandler {
    @Test
    public void TestMazeExport() {
        MazeExportHandler exportHandler = new MazeExportHandler("./", false);
        MazeMetadata mazeMetadata = new MazeMetadata("foo", "bar");
        exportHandler.exportMaze(new Maze(
                mazeMetadata,
                new MazeGridPanel(
                        new MazeDimensions(10, 10)
                )
        ));
        assertTrue(new File("./" + mazeMetadata.getFileName() + ".png").exists());
    }

    @Test
    public void TestMazeExportMazeTooLarge() {
        MazeExportHandler exportHandler = new MazeExportHandler("./", false);
        MazeMetadata mazeMetadata = new MazeMetadata("foo", "bar");
        assertThrows(IllegalArgumentException.class, () -> exportHandler.exportMaze(
                new Maze(
                    mazeMetadata,
                    new MazeGridPanel(
                            new MazeDimensions(101, 100)
                )
        )));
    }
}
