package com.homework.reflection.homework3;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IllegalAccessException, IOException, NoSuchFieldException, ClassNotFoundException {
		Test test = new Test(23,"GoodBye");
		String path = "c:\\users\\white\\file.txt";
		Serializer.serialize(path, test);
		System.out.println(Deserializer.deserialize(path, test));
	}
}
