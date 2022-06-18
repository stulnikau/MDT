package com.mdt.mazedatabase;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.File;
import java.sql.Connection;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestDBConnection {
    @Test
    @Order(3)
    public void TestSingleton() {
        Connection connectionOne = DBConnection.getInstance();
        Connection connectionTwo = DBConnection.getInstance();
        assertEquals(connectionOne, connectionTwo);
    }

    static boolean renameProps() {
        File original = new File("db.props");
        File newFile = new File("db_temp_test.props");
        if (original.exists()) {
            return original.renameTo(newFile);
        }
        else return newFile.exists();
    }

    static void renamePropsBack() {
        File original = new File("db_temp_test.props");
        File newFile = new File("db.props");
        if (original.exists()) {
            original.renameTo(newFile);
        }
    }

    @Test
    @Order(2)
    public void TestDoesNotThrowIfPropsMissing() {
        if (renameProps()) {
            assertDoesNotThrow(() -> {
                Connection connection = DBConnection.getInstance();
                renamePropsBack();
            });
        }
    }

    @Test
    @Order(1)
    public void TestNullIfPropsMissing() {
        if (renameProps()) {
            Connection connection = DBConnection.getInstance();
            renamePropsBack();
            assertNull(connection);
        }
    }
}
