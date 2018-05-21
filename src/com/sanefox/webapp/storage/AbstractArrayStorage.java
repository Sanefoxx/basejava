package com.sanefox.webapp.storage;

import com.sanefox.webapp.model.Resume;

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

    public Resume get(String uuid) {
        int index = checkIndex(uuid);

        if (index == -1) {
            System.out.println("This resume not in storage to get");
            return null;
        } else {
            return storage[index];
        }
    }

    protected abstract int checkIndex(String uuid);
}
