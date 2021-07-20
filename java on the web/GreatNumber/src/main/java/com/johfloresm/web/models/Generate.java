package com.johfloresm.web.models;

import java.util.Random;

public class Generate {
	
	public static int numberInRange(int min, int max) {		
		Random r = new Random();
        return r.nextInt(max) + min;
	}
}
