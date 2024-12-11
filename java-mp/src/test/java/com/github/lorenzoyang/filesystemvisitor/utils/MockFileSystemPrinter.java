package com.github.lorenzoyang.filesystemvisitor.utils;

public class MockFileSystemPrinter implements FileSystemPrinter {

    private final StringBuilder builder = new StringBuilder();

    @Override
    public void print(String message) {
        builder.append(message + "\n");
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
