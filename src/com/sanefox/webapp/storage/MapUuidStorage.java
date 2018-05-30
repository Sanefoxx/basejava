package com.sanefox.webapp.storage;

import com.sanefox.webapp.model.Resume;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    public void clear() {

    }

    @Override
    public List<Resume> doCopyAll() {
        return Collections.emptyList();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {

    }

    @Override
    protected void doSave(Resume r, Object searchKey) {

    }

    @Override
    protected Resume doGet(Object searchKey) {
        return null;
    }

    @Override
    protected void doDelete(Object searchKey) {

    }

    @Override
    protected Object getSearchKey(String uuid) {
        return null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return false;
    }
}
