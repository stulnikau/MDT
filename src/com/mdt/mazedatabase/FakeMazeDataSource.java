package com.mdt.mazedatabase;

import com.mdt.gui.mazeitems.MazeGridPanel;
import com.mdt.maze.Maze;
import com.mdt.maze.MazeMetadata;

import java.util.*;

public class FakeMazeDataSource implements MazeDataSource {
    Set<Maze> mazeSet;
    Set<MazeMetadata> mazeMetadataSet;
    TreeMap<MazeMetadata, MazeGridPanel> mazeMetadataMazeGridPanelTreeMap;

    public FakeMazeDataSource() {
        mazeSet = new HashSet<>();
        mazeMetadataSet = new HashSet<>();
        mazeMetadataMazeGridPanelTreeMap = new TreeMap<>();
    }

    @Override
    public void addMaze(Maze maze) {
        mazeSet.add(maze);
        mazeMetadataSet.add(maze.getMazeMetadata());
        mazeMetadataMazeGridPanelTreeMap.put(maze.getMazeMetadata(), maze.getMazeGrid());
    }

    @Override
    public Set<MazeMetadata> getMazeMetadataSet() {
        return mazeMetadataSet;
    }

    @Override
    public MazeGridPanel getMazeGrid(MazeMetadata mazeMetadata) {
        return mazeMetadataMazeGridPanelTreeMap.get(mazeMetadata);
    }

    @Override
    public void close() {}
}
