package com.github.lorenzoyang.filesystemvisitor.utils;


import com.github.lorenzoyang.filesystemvisitor.FileSystemDirectory;
import com.github.lorenzoyang.filesystemvisitor.FileSystemFile;
import com.github.lorenzoyang.filesystemvisitor.FileSystemVisitorAdapter;

public class FileSystemNonRecursiveLsVisitor extends FileSystemVisitorAdapter {

    private final FileSystemPrinter printer;
    private boolean alreadyVisitedDirectory = false;

    public FileSystemNonRecursiveLsVisitor(FileSystemPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void visitFile(FileSystemFile file) {
        printer.print("File: " + file.getName());
    }

    @Override
    public void visitDirectory(FileSystemDirectory dir) {
        printer.print("Directory: " + dir.getName());
        if (alreadyVisitedDirectory)
            return;
        alreadyVisitedDirectory = true;
        super.visitDirectory(dir);
    }

}
