package com.mdt.maze;
import org.junit.jupiter.api.*;
import java.util.Date;
import java.util.Vector;
import static org.junit.jupiter.api.Assertions.*;

class TestMazeMetadata {
    String mazeName;
    String mazeAuthor;
    MazeMetadata mazeMetadata;

    @BeforeEach
    public void SetUpObject() {
        mazeName = "Maze 1";
        mazeAuthor = "Raghav Sharma";
        mazeMetadata = new MazeMetadata(mazeName, mazeAuthor );
    }

    @Test
    public void TestGetRowData() {
        Vector<String> testdata = new Vector<>(4);
        testdata.add("Maze 1");
        testdata.add("Raghav Sharma");
        testdata.add(new Date().toString());
        testdata.add(new Date().toString());
        assertArrayEquals(testdata.toArray(), mazeMetadata.getRowData().toArray());
    }

    @Test
    public void TestGetMazeName() {
        assertEquals("Maze 1", mazeMetadata.getMazeName() );
    }

    @Test
    public void TestGetMazeAuthor() {
        assertEquals("Raghav Sharma", mazeMetadata.getMazeAuthor() );
    }

    @Test
    public void TestGetMazeCreatedDate() {
        assertEquals( new Date().toString(), mazeMetadata.getMazeCreatedDate() );
    }

    @Test
    public void TestGetMazeLastModifiedDate() {
        String date = new Date().toString();
        MazeMetadata mazeMetadata1 = new MazeMetadata("Maze 1", "Raghav Sharma", date , date);
        assertEquals(date, mazeMetadata.getMazeLastModifiedDate() );
    }

    @Test
    public void TestEmptyDateConstructor() {
        assertThrows(IllegalArgumentException.class,
                ()-> {
                   MazeMetadata mazeMetadata1 = new MazeMetadata("Maze 2", "Raghav Sharma", "","");
                });
    }


}