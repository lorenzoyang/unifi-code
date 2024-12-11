package com.github.lorenzoyang.filesystemvisitor.utils;

import com.github.lorenzoyang.filesystemvisitor.FileSystemDirectory;
import com.github.lorenzoyang.filesystemvisitor.FileSystemFile;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class DirectoryFilesCollectionSupplierTest {

    @Test
    public void testRecursiveDirectory() {
        FileSystemDirectory dir = new FileSystemDirectory("aDir");
        FileSystemFile file1 = new FileSystemFile("aFile1.txt");
        dir.add(file1);
        FileSystemDirectory nestedDir = new FileSystemDirectory("aNestedDir");
        dir.add(nestedDir);
        nestedDir.add(new FileSystemFile("aFile.txt"));
        FileSystemFile file2 = new FileSystemFile("aFile2.txt");
        dir.add(file2);
        assertThat(new DirectoryFilesCollectionSupplier(dir).get())
                .containsExactlyInAnyOrder(file1, file2);
    }

}
