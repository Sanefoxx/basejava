package com.sanefox.webapp.storage;

import com.sanefox.webapp.exception.ExistStorageException;
import com.sanefox.webapp.exception.NotExistStorageException;
import com.sanefox.webapp.exception.StorageException;
import com.sanefox.webapp.model.Resume;

import java.util.Arrays;

/**
 * Created by aslisicin on 21.05.2018.
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = checkIndex(r.getUuid());

        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        int index = checkIndex(r.getUuid());

        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage Overflow", r.getUuid());
        } else if (index < 0) {
            insertElement(r, index);
            size++;
        } else {
            throw new ExistStorageException(r.getUuid());
        }
    }

    public Resume get(String uuid) {
        int index = checkIndex(uuid);

        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            return storage[index];
        }
    }

    public void delete(String uuid) {
        int index = checkIndex(uuid);

        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            size--;
            fillDeletedElement(index);
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected abstract void insertElement(Resume r, int index);

    protected abstract void fillDeletedElement(int index);

    protected abstract int checkIndex(String uuid);
}
