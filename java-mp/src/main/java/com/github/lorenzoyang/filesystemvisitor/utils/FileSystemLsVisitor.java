package com.github.lorenzoyang.filesystemvisitor.utils;

import com.github.lorenzoyang.filesystemvisitor.FileSystemDirectory;
import com.github.lorenzoyang.filesystemvisitor.FileSystemFile;
import com.github.lorenzoyang.filesystemvisitor.FileSystemVisitorAdapter;

public class FileSystemLsVisitor extends FileSystemVisitorAdapter {

    private final FileSystemPrinter printer;

    public FileSystemLsVisitor(FileSystemPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void visitFile(FileSystemFile file) {
        printer.print("File: " + file.getName());
    }

    @Override
    public void visitDirectory(FileSystemDirectory dir) {
        printer.print("Directory: " + dir.getName());
        super.visitDirectory(dir);
    }

}
