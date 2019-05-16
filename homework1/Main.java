package com.homework.reflection.homework1;

import java.lang.reflect.Method;

public class Main {
    public static void main (String[] args) {
        TestClass one = new TestClass();
		Class<?> getted = one.getClass();

        try {
            Method[] methods = getted.getDeclaredMethods();
            for(Method method : methods) {
            	if (method.isAnnotationPresent(Test.class)) {
            		Test test = method.getAnnotation(Test.class);
            		method.setAccessible(true);
            		System.out.println(method.invoke(one, test.a(), test.b()));
            	}
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}