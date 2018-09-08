package com.sanefox.webapp.storage;

import com.sanefox.webapp.exception.StorageException;
import com.sanefox.webapp.model.Resume;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Created by aslisicin on 19.06.2018.
 */
public abstract class AbstractPathStorage extends AbstractStorage<Path> {
    private Path directory;

    protected abstract void doWrite(Resume r, OutputStream os) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;

    protected AbstractPathStorage(String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)){
            throw new IllegalArgumentException(dir + "is not a directory or is not writable")
        }
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::doDelete);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null);
        }
    }

    @Override
    public int size() {
        String[] list = directory.list();
        if (list == null) {
            throw new StorageException("Directory read error", null);
        }
        return list.length;
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return new Path(directory, uuid);
    }

    @Override
    protected void doUpdate(Resume r, Path file) {
        try {
            doWrite(r, new BufferedOutputStream(new PathOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("Path write error", r.getUuid(), e);
        }
    }

    @Override
    protected boolean isExist(Path file) {
        return file.exists();
    }

    @Override
    protected void doSave(Resume r, Path file) {
        try {
            file.createNewPath();
        } catch (IOException e) {
            throw new StorageException("Couldn't create file " + file.getAbsolutePath(), file.getName(), e);
        }
        doUpdate(r, file);
    }

    @Override
    protected Resume doGet(Path file) {
        try {
            return doRead(new BufferedInputStream(new PathInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("Path read error", file.getName(), e);
        }
    }

    @Override
    protected void doDelete(Path file) {
        if (!file.delete()) {
            throw new StorageException("Path delete error", file.getName());
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        Path[] files = directory.listPaths();
        if (files == null) {
            throw new StorageException("Directory read error", null);
        }
        List<Resume> list = new ArrayList<>(files.length);
        for (Path file : files) {
            list.add(doGet(file));
        }
        return list;
    }
}