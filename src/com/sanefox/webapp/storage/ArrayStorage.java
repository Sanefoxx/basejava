package com.sanefox.webapp.storage;

import com.sanefox.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = checkIndex(r.getUuid());

        if (index == -1) {
            System.out.println("This resume not in storage to update");
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        int index = checkIndex(r.getUuid());

        if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else if (index == -1) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("This resume already in storage");
        }
    }

    public void delete(String uuid) {
        int index = checkIndex(uuid);

        if (index == -1) {
            System.out.println("This resume not in storage to delete");
        } else {
            size--;
            storage[index] = storage[size];
            storage[size] = null;
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
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
