package com.johfloresm.web.models;

public class Dog extends Animal implements Pet{
	
	public Dog(String name, String breed, int weight) {
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}

	@Override
	public String showAffection() {
		if(this.weight < 30) {
			return name + " Salta a tu regazo!";
		}else {
			return name + " Se acurruca junto a ti!!";
		}
	}
	
}
