package com.johfloresm.web.models;

public class Cat extends Animal implements Pet{
	
	public Cat(String name, String breed, int weight) {
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}

	@Override
	public String showAffection() {
		return name + " Quiere que lo veas";
	}
}
