import com.sanefox.webapp.model.Resume;

import java.lang.reflect.Field;

/**
 * Created by aslisicin on 23.05.2018.
 */
public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        System.out.println(r);
    }
}
