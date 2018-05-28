package com.sanefox.webapp;

import com.sanefox.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by aslisicin on 23.05.2018.
 */
public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume();
        Class<? extends Resume> resumeClass = r.getClass();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        System.out.println(r);

        Method method = resumeClass.getMethod("toString");
        Object result = method.invoke(r);
        System.out.println(result + " toString");
    }
}
