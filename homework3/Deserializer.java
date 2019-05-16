package com.homework.reflection.homework3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Deserializer {
	public static String deserialize (String path, Object o) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
		String onestring = in.readObject().toString();
		String[] fields = onestring.split(";");
		StringBuilder output = new StringBuilder();
		for (String string : fields) {
			String[] fieldfile = string.split("=");
			String name = fieldfile[0];
			String value = fieldfile[1];
			output.append(name + " = ");
			Field field = o.getClass().getDeclaredField(name);
			if (Modifier.isPrivate(field.getModifiers())) {
				field.setAccessible(true);
			}
			if (field.getType() == int.class) {
				field.setInt(o, Integer.parseInt(value));
			} else {
				field.set(o, value);
			}
			output.append(value);
			output.append (";");
		}
		in.close();
		return output.toString();
	}
}
