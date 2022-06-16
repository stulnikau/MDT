package com.mdt.mazedatabase;


import com.mdt.gui.mazeitems.MazeGridPanel;
import com.mdt.maze.Maze;
import com.mdt.maze.MazeMetadata;

import java.io.*;
import java.sql.*;
import java.util.Set;
import java.util.TreeSet;

/**
 * Retrieves maze data from a JDBC-compatible database.
 * Based on the structure of CAB302, Practical 06
 * Ref: https://github.com/qut-cab302/prac06/blob/master/solution/dataExercise/JDBCAddressBookDataSource.java
 */
public class JDBCMazeDataSource implements MazeDataSource {

    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS maze ("
                    + "idx INTEGER PRIMARY KEY /*!40101 AUTO_INCREMENT */ NOT NULL UNIQUE," // from https://stackoverflow.com/a/41028314
                    + "name VARCHAR(50),"
                    + "author VARCHAR(50),"
                    + "createdDate VARCHAR(50),"
                    + "lastModifiedDate VARCHAR(50),"
                    + "mazeGridPanel VARBINARY(10000)" + ");";

    private static final String INSERT_MAZE = "INSERT INTO maze (name, author, createdDate, lastModifiedDate, mazeGridPanel) VALUES (?, ?, ?, ?, ?);";
    private static final String GET_MAZE_METADATA = "SELECT name, author, createdDate, lastModifiedDate FROM maze";
    private static final String GET_MAZE_GRID = "SELECT mazeGridPanel FROM maze WHERE name=? AND author=? AND createdDate=? AND lastModifiedDate=?";

    private final Connection connection;
    private PreparedStatement addMaze;
    private PreparedStatement getMazes;
    private PreparedStatement getMazeGrid;

    /**
     * New JDBC maze data source
     */
    public JDBCMazeDataSource(Connection connection) {
        this.connection = connection;
        try {
            Statement st = connection.createStatement();
            st.execute(CREATE_TABLE);
            addMaze = connection.prepareStatement(INSERT_MAZE);
            getMazes = connection.prepareStatement(GET_MAZE_METADATA);
            getMazeGrid = connection.prepareStatement(GET_MAZE_GRID);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private byte[] getBinary(Object input) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
            outputStream.writeObject(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    /**
     * Adds a new maze
     * @param maze maze to add
     */
    public void addMaze(Maze maze) {
        try {
            byte[] mazeGridBinary = getBinary(maze.getMazeGrid());
            addMaze.setString(1, maze.getMazeMetadata().getMazeName());
            addMaze.setString(2, maze.getMazeMetadata().getMazeAuthor());
            addMaze.setString(3, maze.getMazeMetadata().getMazeCreatedDate());
            addMaze.setString(4, maze.getMazeMetadata().getMazeLastModifiedDate());
            addMaze.setBinaryStream(5, new ByteArrayInputStream(mazeGridBinary), mazeGridBinary.length);
            addMaze.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Gets the set of metadata of all mazes stored in the database
     */
    public Set<MazeMetadata> getMazeMetadataSet() {
        Set<MazeMetadata> mazeMetadataSet = new TreeSet<>();
        ResultSet rs;

        try {
            rs = getMazes.executeQuery();
            while (rs.next()) {
                mazeMetadataSet.add(
                        new MazeMetadata(
                                rs.getString("name"),
                                rs.getString("author"),
                                rs.getString("createdDate"),
                                rs.getString("lastModifiedDate")
                        )

                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mazeMetadataSet;
    }

    /**
     * Gets the maze grid that corresponds to given maze metadata
     */
    public MazeGridPanel getMazeGrid(MazeMetadata mazeMetadata) {
        ResultSet rs;
        MazeGridPanel mazeGridPanel = null;
        try {
            getMazeGrid.setString(1, mazeMetadata.getMazeName());
            getMazeGrid.setString(2, mazeMetadata.getMazeAuthor());
            getMazeGrid.setString(3, mazeMetadata.getMazeCreatedDate());
            getMazeGrid.setString(4, mazeMetadata.getMazeLastModifiedDate());

            rs = getMazeGrid.executeQuery();
            rs.next();
            Blob blob = rs.getBlob("mazeGridPanel");
            byte[] data = blob.getBytes(1, (int) blob.length());
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            mazeGridPanel = (MazeGridPanel) objectInputStream.readObject();
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return mazeGridPanel;
    }

    /**
     * Gracefully terminate the database connection
     */
    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
