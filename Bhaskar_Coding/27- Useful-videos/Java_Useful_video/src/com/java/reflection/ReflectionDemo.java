package com.java.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Company{
    private String name;

    public Company(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    private void displayMethod(){
        System.out.println("private method invoking Company "+ name);
    }
}
public class ReflectionDemo {
    static void main() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Company company =new Company("Bhaskar");
        System.out.println("The company name ==>"+ company.getName());

        Field field=Company.class.getDeclaredField("name");
        field.setAccessible(true);
        field.set(company,"maddy");

        Method method=Company.class.getDeclaredMethod("displayMethod");
        method.setAccessible(true);
        method.invoke(company);
    }

}
