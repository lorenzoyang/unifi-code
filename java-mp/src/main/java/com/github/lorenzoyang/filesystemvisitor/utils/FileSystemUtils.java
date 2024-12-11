package com.github.lorenzoyang.filesystemvisitor.utils;


import com.github.lorenzoyang.filesystemvisitor.*;

import java.util.Optional;

public class FileSystemUtils {

    private FileSystemUtils() {
        // Utility classes, which are collections of static members, are not meant to be
        // instantiated. They should not have public constructors.
    }

    private static class FileFilter implements FileSystemVisitor {
        FileSystemFile file = null;

        @Override
        public void visitFile(FileSystemFile file) {
            this.file = file;
        }

        @Override
        public void visitDirectory(FileSystemDirectory dir) {
            // skip directories, only files
        }
    }

    public static Optional<FileSystemFile> toFile(FileSystemResource res) {
        final FileFilter filter = new FileFilter();
        res.accept(filter);
        return Optional.ofNullable(filter.file);
    }

    private static class DirectoryFilter extends FileSystemVisitorAdapter {
        FileSystemDirectory dir = null;

        @Override
        public void visitDirectory(FileSystemDirectory dir) {
            this.dir = dir;
        }
    }

    public static Optional<FileSystemDirectory> toDir(FileSystemResource res) {
        final DirectoryFilter filter = new DirectoryFilter();
        res.accept(filter);
        return Optional.ofNullable(filter.dir);
    }
}
