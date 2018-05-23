package com.sanefox.webapp.exception;

/**
 * Created by aslisicin on 23.05.2018.
 */
public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("Resume already exist", uuid);
    }
}
