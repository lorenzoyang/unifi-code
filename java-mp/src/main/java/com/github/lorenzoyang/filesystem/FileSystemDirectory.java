package com.github.lorenzoyang.filesystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class FileSystemDirectory extends FileSystemResource {

    private final Collection<FileSystemResource> contents = new ArrayList<>();

    public FileSystemDirectory(String name) {
        super(name);
    }


    // Just for testing, package-private
    Collection<FileSystemResource> getContents() {
        return contents;
    }

    @Override
    public String toString() {
        return super.toString() + " [contents=" + contents + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(contents);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        FileSystemDirectory other = (FileSystemDirectory) obj;
        return Objects.equals(contents, other.contents);
    }

    @Override
    public void ls(FileSystemPrinter printer) {
        printer.print("Directory: " + getName());
        contents.forEach(resource -> resource.ls(printer));
    }

    public void add(FileSystemResource resource) {
        contents.add(resource);
    }

    public void remove(FileSystemResource resource) {
        contents.remove(resource);
    }

    public Optional<FileSystemResource> findByName(String name) {
        return contents.stream()
                .filter(resource -> resource.getName().equals(name))
                .findFirst();
    }

    @Override
    public FileSystemDirectory createCopy() {
        FileSystemDirectory copy = new FileSystemDirectory(getName());
        copy.getContents().addAll(
                contents.stream()
                        .map(FileSystemResource::createCopy)
                        .toList()
        );
        return copy;
    }
}

