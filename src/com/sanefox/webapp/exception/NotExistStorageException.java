package com.sanefox.webapp.exception;

/**
 * Created by aslisicin on 23.05.2018.
 */
public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Resume not exist", uuid);
    }
}
