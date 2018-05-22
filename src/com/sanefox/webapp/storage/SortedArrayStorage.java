package com.sanefox.webapp.storage;

import com.sanefox.webapp.model.Resume;

import java.util.Arrays;

/**
 * Created by aslisicin on 21.05.2018.
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void update(Resume r) {
        int index = checkIndex(r.getUuid());

        if (index <= -1) {
            System.out.println("This resume not in storage to update");
        } else {
            storage[index] = r;
        }
    }

    @Override
    public void save(Resume r) {
        int index = checkIndex(r.getUuid());

        if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else if (index <= -1) {
            storage[size] = r;
            size++;
            Arrays.sort(storage, 0, size);
        } else {
            System.out.println("This resume already in storage");
        }
    }

    @Override
    public void delete(String uuid) {
        int index = checkIndex(uuid);

        if (index == -1) {
            System.out.println("This resume not in storage to delete");
        } else {
            size--;
            storage[index] = storage[size];
            storage[size] = null;
            Arrays.sort(storage, 0, size());
        }
    }

    @Override
    public Resume[] getAll() {
        return super.getAll();
    }

    @Override
    protected int checkIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
