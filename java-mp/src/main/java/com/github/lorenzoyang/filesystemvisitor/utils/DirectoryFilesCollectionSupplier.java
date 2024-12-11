package com.github.lorenzoyang.filesystemvisitor.utils;


import com.github.lorenzoyang.filesystemvisitor.FileSystemDirectory;
import com.github.lorenzoyang.filesystemvisitor.FileSystemFile;
import com.github.lorenzoyang.filesystemvisitor.FileSystemResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Supplier;

public class DirectoryFilesCollectionSupplier implements Supplier<Collection<FileSystemFile>> {

    private final FileSystemDirectory dir;

    public DirectoryFilesCollectionSupplier(FileSystemDirectory dir) {
        this.dir = dir;
    }

    @Override
    public Collection<FileSystemFile> get() {
        Iterator<FileSystemResource> iterator = dir.iterator();
        ArrayList<FileSystemFile> files = new ArrayList<>();
        while (iterator.hasNext()) {
            FileSystemUtils.toFile(iterator.next())
                    .ifPresent(files::add);
        }
        return files;
    }

}
