package com.homework.reflection.homework2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {

	public static void main(String[] args) {
		
		try {
		TextContainer.Container container = new TextContainer().new Container();
		Class<?> testClass = container.getClass();
		SaveTo saveTo = testClass.getAnnotation(SaveTo.class);
		String path = saveTo.path();
		Method[] methods = testClass.getDeclaredMethods();
		for (Method method : methods) {
			if(method.isAnnotationPresent(Saver.class)) {
				method.invoke(container, path);
			}
		}
		} catch(IllegalAccessException|InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
