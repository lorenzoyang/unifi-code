package com.github.lorenzoyang.filesystemvisitor;

public class FileSystemFile extends FileSystemResource {

    public FileSystemFile(String name) {
        super(name);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        return getClass() == obj.getClass();
    }

    @Override
    public FileSystemFile createCopy() {
        return new FileSystemFile(getName());
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitFile(this);
    }
}
