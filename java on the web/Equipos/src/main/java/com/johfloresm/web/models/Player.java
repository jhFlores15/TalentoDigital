package com.johfloresm.web.models;

public class Player {
	int id;
	String name;
	String lastName;
	int age;
	static int lastId = 0;
	
	public Player(String name, String lastName, int age) {
		this.name = name;		
		this.lastName = lastName;
		this.age = age;
		this.id = ++lastId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
}
