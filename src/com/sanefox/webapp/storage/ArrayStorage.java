package com.sanefox.webapp.storage;

import com.sanefox.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void update(Resume r) {
        super.update(r);
    }

    @Override
    public void save(Resume r) {
        super.save(r);
    }

    @Override
    public Resume get(String uuid) {
        return super.get(uuid);
    }

    @Override
    public void delete(String uuid) {
        super.delete(uuid);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    @Override
    public Resume[] getAll() {
        return super.getAll();
    }

    protected int checkIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
