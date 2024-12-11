package com.github.lorenzoyang.filesystemvisitor.utils;

import com.github.lorenzoyang.filesystemvisitor.FileSystemDirectory;
import com.github.lorenzoyang.filesystemvisitor.FileSystemFile;
import com.github.lorenzoyang.filesystemvisitor.FileSystemResource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileSystemLsVisitorTest {

    private MockFileSystemPrinter printer;
    private FileSystemLsVisitor visitor;

    @Before
    public void setup() {
        printer = new MockFileSystemPrinter();
        visitor = new FileSystemLsVisitor(printer);
    }

    @Test
    public void testFileLs() {
        FileSystemResource file = new FileSystemFile("aFile.txt");
        file.accept(visitor);
        assertEquals("File: aFile.txt\n", printer.toString());
    }

    @Test
    public void testEmptyDirectoryLs() {
        FileSystemDirectory dir = new FileSystemDirectory("aDir");
        dir.accept(visitor);
        assertEquals("Directory: aDir\n", printer.toString());
    }

    @Test
    public void testNonEmptyDirectoryLs() {
        FileSystemDirectory dir = new FileSystemDirectory("aDir");
        dir.add(new FileSystemFile("aFile.txt"));
        dir.accept(visitor);
        assertEquals(
                "Directory: aDir\n" +
                        "File: aFile.txt\n",
                printer.toString());
    }

    @Test
    public void testRecursiveDirectoryLs() {
        FileSystemDirectory dir = new FileSystemDirectory("aDir");
        FileSystemDirectory nestedDir = new FileSystemDirectory("aNestedDir");
        dir.add(nestedDir);
        nestedDir.add(new FileSystemFile("aFile.txt"));
        dir.accept(visitor);
        assertEquals(
                "Directory: aDir\n" +
                        "Directory: aNestedDir\n" +
                        "File: aFile.txt\n",
                printer.toString());
    }

}
