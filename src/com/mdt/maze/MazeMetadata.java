package com.mdt.maze;

import java.util.Date;
import java.util.Vector;

/**
 * Container for maze metadata
 */
public class MazeMetadata implements Comparable {
    private final String mazeName;
    private final String mazeAuthor;
    private final String mazeCreatedDate;
    private final String mazeLastModifiedDate;

    /**
     * Create a new maze metadata container with created date and last modified date at the current moment
     * @param mazeName maze name
     * @param mazeAuthor maze author
     */
    public MazeMetadata(String mazeName, String mazeAuthor) {
        this.mazeName = mazeName;
        this.mazeAuthor = mazeAuthor;
        this.mazeCreatedDate = new Date().toString();
        this.mazeLastModifiedDate = mazeCreatedDate;
    }

    /**
     * Create a new maze metadata container from provided variables
     * @param mazeName maze name
     * @param mazeAuthor maze author
     * @param mazeCreatedDate maze created date
     * @param mazeLastModifiedDate maze last modified date
     */
    public MazeMetadata(String mazeName, String mazeAuthor, String mazeCreatedDate, String mazeLastModifiedDate) {
        if( mazeCreatedDate.equals("") || mazeLastModifiedDate.equals("")){
            throw new IllegalArgumentException("Date Created and Last Modified date must have an value");
        }
        this.mazeName = mazeName;
        this.mazeAuthor = mazeAuthor;
        this.mazeCreatedDate = mazeCreatedDate;
        this.mazeLastModifiedDate = mazeLastModifiedDate;
    }

    /**
     * Returns a vector that holds maze metadata
     * @return vector with maze metadata
     */
    public Vector<String> getRowData() {
        Vector<String> rowData = new Vector<>(4);
        rowData.add(getMazeName());
        rowData.add(getMazeAuthor());
        rowData.add(getMazeCreatedDate());
        rowData.add(getMazeLastModifiedDate());
        return rowData;
    }

    /**
     * @return maze name
     */
    public String getMazeName() {
        return mazeName;
    }

    /**
     * @return maze author
     */
    public String getMazeAuthor() {
        return mazeAuthor;
    }

    /**
     * @return maze created date
     */
    public String getMazeCreatedDate() {
        return mazeCreatedDate;
    }

    /**
     * @return maze last modified date
     */
    public String getMazeLastModifiedDate() {
        return mazeLastModifiedDate;
    }

    /**
     * Convert metadata to a string for comparisons
     * @return string concatenation of maze metadata fields
     */
    @Override
    public String toString() {
        return "MazeMetadata{" +
                "mazeName='" + mazeName + '\'' +
                ", mazeAuthor='" + mazeAuthor + '\'' +
                ", mazeCreatedDate=" + mazeCreatedDate +
                ", mazeLastModifiedDate=" + mazeLastModifiedDate +
                '}';
    }

    /**
     * Implement maze metadata comparisons for sorting
     * @param o another maze metadata object
     * @return relative ranking against the compared to object o
     */
    @Override
    public int compareTo(Object o) {
        return this.toString().compareTo(o.toString());
    }
}
