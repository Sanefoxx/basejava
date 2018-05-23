package com.sanefox.webapp.exception;

/**
 * Created by aslisicin on 23.05.2018.
 */
public class StorageException extends RuntimeException {
    private final String uuid;

    public StorageException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
