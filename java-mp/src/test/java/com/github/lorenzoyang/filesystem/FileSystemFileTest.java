package com.github.lorenzoyang.filesystem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class FileSystemFileTest {
    private FileSystemPrinter mockPrinter;

    @Before
    public void setUp() throws Exception {
        this.mockPrinter = Mockito.mock(FileSystemPrinter.class);
    }

    @Test
    public void testFileLs() {
        FileSystemResource file = new FileSystemFile("aFile.txt");
        file.ls(mockPrinter);
        Mockito.verify(mockPrinter).print("File: aFile.txt");
    }

    @Test
    public void testToString() {
        assertEquals("FileSystemFile [name=aFile.txt]",
                new FileSystemFile("aFile.txt").toString());
    }

    @Test
    public void testEquals() {
        FileSystemResource file1 = new FileSystemFile("aFile1");
        FileSystemResource file2 = new FileSystemFile("aFile1");
        FileSystemResource file3 = new FileSystemFile("aFile3");
        assertEquals(file1, file2);
        assertNotEquals(file1, file3);
    }

    @Test
    public void testHashCode() {
        FileSystemResource file1 = new FileSystemFile("aFile1");
        FileSystemResource file2 = new FileSystemFile("aFile1");
        FileSystemResource file3 = new FileSystemFile("aFile3");
        assertEquals(file1.hashCode(), file2.hashCode());
        assertNotEquals(file1.hashCode(), file3.hashCode());
    }

    @Test
    public void testFileCreateCopy() {
        FileSystemFile original = new FileSystemFile("aFile");
        FileSystemResource copy = original.createCopy();

        assertNotSame(original, copy);
        assertEquals(original, copy);
    }
}