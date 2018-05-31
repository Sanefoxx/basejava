package com.sanefox.webapp;

import com.sanefox.webapp.model.SectionType;

/**
 * Created by aslisicin on 31.05.2018.
 */
public class TestSingleton {
    private static TestSingleton instance;

    public static TestSingleton getInstance() {
        if (instance == null) {
            instance = new TestSingleton();
        }
        return instance;
    }

    private TestSingleton() {
    }

    public static void main(String[] args) {
        getInstance().toString();
        Singleton instance = Singleton.valueOf("INSTANCE");
        System.out.println(instance.name());
        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle());
        }
    }

    public enum Singleton {
        INSTANCE
    }
}
