package com.github.lorenzoyang.filesystemvisitor.utils;

import com.github.lorenzoyang.filesystemvisitor.FileSystemDirectory;
import com.github.lorenzoyang.filesystemvisitor.FileSystemFile;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FileSystemUtilsTest {

    @Test
    public void testToFile() {
        FileSystemDirectory dir = new FileSystemDirectory("aDir");
        FileSystemFile file = new FileSystemFile("aFile1.txt");
        dir.add(file);

        assertThat(FileSystemUtils.toFile(dir))
                .isEmpty();
        assertThat(FileSystemUtils.toFile(file))
                .isPresent()
                .containsSame(file);
    }

    @Test
    public void testToDir() {
        FileSystemDirectory dir = new FileSystemDirectory("aDir");
        FileSystemFile file = new FileSystemFile("aFile1.txt");
        dir.add(file);

        assertThat(FileSystemUtils.toDir(file))
                .isEmpty();
        assertThat(FileSystemUtils.toDir(dir))
                .isPresent()
                .containsSame(dir);
    }

}
