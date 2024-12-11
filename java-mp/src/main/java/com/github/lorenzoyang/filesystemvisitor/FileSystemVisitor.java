package com.github.lorenzoyang.filesystemvisitor;

public interface FileSystemVisitor {

    void visitFile(FileSystemFile file);

    void visitDirectory(FileSystemDirectory dir);

}
