package com.homework.reflection.homework3;

public class Test {
	@Save
	private int number = 12;
	@Save
	private String name = "Hello";
	
	public Test(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public Test() {
		super();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
