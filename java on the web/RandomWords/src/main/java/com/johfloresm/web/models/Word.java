package com.johfloresm.web.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Word {
	String value;
	Date created_at;
	static int count;
	static Word lastWordCreated;
	
	public Word() {
		this.value = this.createRandomString(10);
		this.created_at = this.generateDateNow();
		count++;
		lastWordCreated = this;
	}
	
	private String createRandomString(int length){
		Random rand = new Random();
		String alphabet = "abcdefghijklmnopqrstuvwxyz123456789";
		String word = "";

		for (int i = 0; i<length; i++){
			word += alphabet.charAt(rand.nextInt(alphabet.length()));
		}
		return word;
	}
	
	private Date generateDateNow() {
		return new Date(System.currentTimeMillis());
	}

	public String getValue() {
		return value;
	}

	
	public Date getCreated_at() {
		return created_at;
	}

	
	public static int getCount() {
		return count;
	}

	public static Word getLastWordCreated() {
		return lastWordCreated;
	}
	
	

}
