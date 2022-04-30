package com.mdt.mazedatabase;

import com.mdt.maze.Maze;

/**
 * Class to communicate with the database to store and retrieve past mazes.
 */
public class MazeDatabase {
    private String dbUrl;
    private String dbSchema;
    private String dbUser;
    private String dbPassword;

    /**
     * Gets the database connection url, schema name, username,
     * and password from a db.props file stored on disk
     */
    private void setupDatabaseCredentials() {

    }

    /**
     * Converts an encoded maze from storage to a maze instance
     * @param encodedMaze maze encoded in a storage format
     */
    private Maze convertStoredMazeToMazeGrid(String[] encodedMaze) {

        return null;
    }

    /**
     * Saves an encoded maze in the maze database
     * @param mazeId unique id of the maze
     * @param encodedMaze maze encoded in a storage format
     * @param mazeMetadata maze metadata (name, author name,
     *                     created date, and last modified date)
     */
    private void writeEncodedMazeToDatabase(String mazeId, String[] encodedMaze, String[] mazeMetadata) {

    }

    /**
     * Gets a maze instance from a unique maze ID. This
     * allows the maze stored on disk to be visualised for
     * exporting or editing
     * @param mazeId unique reference to a maze saved in the MazeDatabase
     * @return Instance of maze suitable for visualising
     * or editing
     */
    public Maze getMaze(String mazeId) {

        return null;
    }

    /**
     * Records new (or replaces current) maze layout and metadata
     * in the database
     * @param maze maze to be added
     */
    public void addNewOrReplaceMaze(Maze maze) {

    }

    /**
     * Returns column headings for the table that stores mazes
     * @return array of Strings that contains the column names
     */
    public String[] getColHeads() {
        return new String[]{"Name", "Author", "Date Created", "Date Modified"};
    }

    /**
     * Returns all past mazes stored in the maze database.
     * @return 2D array of Objects (e.g. Strings) that
     * contains the attributes of each maze (row data)
     */
    public Object[][] getRowData() {
        return new Object[][]{
                {"Test Maze", "Pavel Stulnikov", "18 Apr 2022, 18:30", "18 Apr 2022. 21:57"},
                {"New Maze (2)", "Raghav Sharma", "17 Apr 2022, 15:32", "17 Apr 2022. 15:37"},
                {"New Maze", "Abhi Mishra", "17 Apr 2022, 15:21", "17 Apr 2022. 15:21"},
                {"Demo", "John Erhabor", "16 Apr 2022, 16:20", "16 Apr 2022. 16:20"},
                {"First Maze", "Deep Patel", "16 Apr 2022, 09:03", "16 Apr 2022. 09:23"}
        };
    }

    /**
     * Set up the connection to the database
     */
    public MazeDatabase() {

    }
}
