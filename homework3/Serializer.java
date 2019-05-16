package com.homework.reflection.homework3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Serializer implements Serializable {

	private static final long serialVersionUID = -4998865772205814665L;

	public static String serialize (String path, Object o) throws IOException, IllegalAccessException {
		Class<?> someClass = o.getClass();
		StringBuilder string = new StringBuilder();
		
		Field[] fields = someClass.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Save.class)) {
				if(Modifier.isPrivate(field.getModifiers())) 
					field.setAccessible(true);
				string.append(field.getName() + "=");
					if (field.getType() == int.class) {
						string.append(field.getInt(o));
					} else {
						string.append(field.get(o).toString());
					}
					string.append (";");
			}
		}
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
			out.writeObject(string);
			out.close();
		return string.toString();
	}
}
