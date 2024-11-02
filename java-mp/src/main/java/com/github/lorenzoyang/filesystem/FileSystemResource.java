package com.github.lorenzoyang.filesystem;

import java.util.Objects;

public abstract class FileSystemResource {
    private final String name;

    protected FileSystemResource(String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [name=" + name + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FileSystemResource other = (FileSystemResource) obj;
        return Objects.equals(name, other.name);
    }

    public abstract void ls(FileSystemPrinter printer);

    public abstract FileSystemResource createCopy();
}
