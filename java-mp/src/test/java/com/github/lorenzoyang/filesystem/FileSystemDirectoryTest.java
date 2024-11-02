package com.github.lorenzoyang.filesystem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class FileSystemDirectoryTest {

    private FileSystemPrinter mockPrinter;

    @Before
    public void setup() {
        mockPrinter = Mockito.mock(FileSystemPrinter.class);
    }

    @Test
    public void testEmptyDirectoryLs() {
        FileSystemDirectory dir = new FileSystemDirectory("aDir");
        dir.ls(mockPrinter);
        when(mockPrinter.toString()).thenReturn("Directory: aDir\n");
    }

    @Test
    public void testNonEmptyDirectoryLs() {
        FileSystemDirectory dir = new FileSystemDirectory("aDir");
        dir.getContents().add(new FileSystemFile("aFile.txt"));
        dir.ls(mockPrinter);
        when(mockPrinter.toString()).thenReturn("""
                Directory: aDir
                File: aFile.txt
                """);
    }

    @Test
    public void testRecursiveDirectoryLs() {
        FileSystemDirectory dir = new FileSystemDirectory("aDir");
        FileSystemDirectory nestedDir = new FileSystemDirectory("aNestedDir");
        dir.getContents().add(nestedDir);
        nestedDir.getContents().add(new FileSystemFile("aFile.txt"));
        dir.ls(mockPrinter);
        when(mockPrinter.toString()).thenReturn("""
                Directory: aDir
                Directory: aNestedDir
                File: aFile.txt
                """);
    }

    @Test
    public void testDirectoryAdd() {
        FileSystemDirectory dir = new FileSystemDirectory("aDir");

        FileSystemResource res = new FileSystemFile("a file");
        dir.add(res);

        Collection<FileSystemResource> contents = dir.getContents();
        assertEquals(1, contents.size());
        assertTrue(contents.contains(res));
    }

    @Test
    public void testDirectoryRemove() {
        FileSystemDirectory dir = new FileSystemDirectory("aDir");

        FileSystemResource notToRemove = new FileSystemFile("file1");
        FileSystemResource toRemove = new FileSystemFile("file2");

        Collection<FileSystemResource> contents = dir.getContents();
        contents.addAll(Arrays.asList(notToRemove, toRemove));

        dir.remove(toRemove);
        assertEquals(1, contents.size());
        assertTrue(contents.contains(notToRemove));
    }

    @Test
    public void testDirectoryFindByName() {
        FileSystemDirectory dir = new FileSystemDirectory("a dir");

        Collection<FileSystemResource> contents = dir.getContents();
        FileSystemResource res1 = new FileSystemFile("file1");
        FileSystemResource res2 = new FileSystemFile("file2");
        contents.addAll(Arrays.asList(res1, res2));

        assertEquals(res2, dir.findByName("file2").get());
        assertFalse(dir.findByName("file3").isPresent());
    }

    @Test
    public void testToString() {
        FileSystemDirectory dir = new FileSystemDirectory("aDir");
        FileSystemDirectory nestedDir = new FileSystemDirectory("aNestedDir");
        dir.getContents().add(nestedDir);
        nestedDir.getContents().add(new FileSystemFile("aFile.txt"));
        assertEquals(
                "FileSystemDirectory [name=aDir] "
                        + "[contents=[FileSystemDirectory "
                        + "[name=aNestedDir] "
                        + "[contents=[FileSystemFile [name=aFile.txt]]]]]",
                dir.toString());
    }

    @Test
    public void testEquals() {
        FileSystemDirectory dir1 = new FileSystemDirectory("aDir");
        FileSystemDirectory dir2 = new FileSystemDirectory("aDir");
        dir1.getContents().add(new FileSystemFile("aFile.txt"));
        dir2.getContents().add(new FileSystemFile("aFile.txt"));
        assertEquals(dir1, dir2);
        dir2.getContents().add(new FileSystemFile("anotherFile.txt"));
        assertNotEquals(dir1, dir2);
    }

    @Test
    public void testHashCode() {
        FileSystemDirectory dir1 = new FileSystemDirectory("aDir");
        FileSystemDirectory dir2 = new FileSystemDirectory("aDir");
        dir1.getContents().add(new FileSystemFile("aFile.txt"));
        dir2.getContents().add(new FileSystemFile("aFile.txt"));
        assertEquals(dir1.hashCode(), dir2.hashCode());
        dir2.getContents().add(new FileSystemFile("anotherFile.txt"));
        assertNotEquals(dir1.hashCode(), dir2.hashCode());
    }

    @Test
    public void testDirectoryCopy() {
        FileSystemDirectory original = new FileSystemDirectory("a dir");
        FileSystemDirectory nested = new FileSystemDirectory("a nested dir");
        nested.getContents().add(new FileSystemFile("second file"));
        original.getContents()
                .addAll(Arrays.asList(new FileSystemFile("first file"), nested));

        FileSystemDirectory copy = original.createCopy();

        assertEquals(original, copy);
        assertEffectiveCopyDirectory(original, copy);
    }

    private void assertEffectiveCopyDirectory(FileSystemDirectory dir1, FileSystemDirectory dir2) {
        assertNotSame(dir1, dir2);
        Iterator<FileSystemResource> contents1 = dir1.getContents().iterator();
        Iterator<FileSystemResource> contents2 = dir2.getContents().iterator();
        // si assume che le due collezioni abbiano la stessa lunghezza,
        // e che a un elemento della prima corrisponda un elemento della
        // seconda dello stesso tipo.
        // Questo e' vero se e' gia' stato usato assertEquals
        while (contents1.hasNext()) {
            FileSystemResource res1 = contents1.next();
            FileSystemResource res2 = contents2.next();
            if (res1 instanceof FileSystemDirectory) {
                assertEffectiveCopyDirectory
                        ((FileSystemDirectory) res1, (FileSystemDirectory) res2);
            } else {
                assertNotSame(res1, res2);
            }
        }
    }
}
