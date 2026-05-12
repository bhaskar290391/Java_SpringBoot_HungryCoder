package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    Company company =new Company("Youtube");
        System.out.println(company.getName());

        Field field=Company.class.getDeclaredField("name");
        field.setAccessible(true);
        field.set(company,"Amazon");

        System.out.println(company.getName());

        Method method=Company.class.getDeclaredMethod("displayName");
        method.setAccessible(true);
        method.invoke(company);
    }
}
