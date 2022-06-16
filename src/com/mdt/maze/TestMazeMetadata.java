package com.mdt.maze;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.Date;
import java.util.Vector;

public class TestMazeMetadata {
    @Test
    public void TestFromVector() {
        Vector<String> mazeData = new Vector<>();
        mazeData.add("foo");
        mazeData.add("bar");
        String dateRecorded = new Date().toString();
        mazeData.add(dateRecorded);
        mazeData.add(dateRecorded);
        MazeMetadata mazeMetadata = new MazeMetadata(mazeData);
        assertEquals("foo", mazeMetadata.getMazeName());
        assertEquals("bar", mazeMetadata.getMazeAuthor());
        assertEquals(dateRecorded, mazeMetadata.getMazeCreatedDate());
        assertEquals(dateRecorded, mazeMetadata.getMazeLastModifiedDate());
    }

    @Test
    public void TestFromInvalidVector() {
        Vector<String> mazeData = new Vector<>();
        mazeData.add("foo");
        mazeData.add("bar");
        String dateRecorded = new Date().toString();
        mazeData.add(dateRecorded);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> new MazeMetadata(mazeData));
    }

    @Test
    public void GetFileName() {
        String dateRecorded = new Date().toString();
        MazeMetadata mazeMetadata = new MazeMetadata("foo", "foo bar", dateRecorded, dateRecorded);
        assertEquals(
                ("foo_foo_bar_" + dateRecorded).replace(":", ".").replace(" ", "_"),
                mazeMetadata.getFileName());
    }
}
