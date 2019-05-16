package com.homework.reflection.homework2;

import java.io.FileWriter;
import java.io.IOException;

public class TextContainer {
	@SaveTo(path="c:\\Users\\white\\file.txt")
	 class Container {
		String text = "Here I am";
		@Saver
		public void save (String path) throws IOException {
			FileWriter writer = new FileWriter(path);
			try {
				writer.write(text);			
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				writer.close();
			}
		}
	}
}
