package com.homework.reflection.homework2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SaveTo {

	String path();
	
}
