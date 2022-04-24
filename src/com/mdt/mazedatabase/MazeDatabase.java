package com.mdt.mazedatabase;

/**
 * Class to communicate with the database to store and retrieve past mazes.
 */
public class MazeDatabase {
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
}
