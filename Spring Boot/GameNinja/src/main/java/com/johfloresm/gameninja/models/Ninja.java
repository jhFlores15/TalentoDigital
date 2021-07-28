package com.johfloresm.gameninja.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Ninja {
    int gold;
    ArrayList<Activity> activities = new ArrayList<Activity>();

    public Ninja() {
        this.gold = 0;
    }

    public int getRandomNumber(int maxGold, int minGold) {
        return (int) ((Math.random() * (maxGold - maxGold)) + minGold);
    }

    public void addGold(int maxGold, int minGold) {
        this.gold = this.gold + this.getRandomNumber(maxGold, minGold);
    }

    public void subtractGold(int maxGold, int minGold) {
        this.gold = this.gold - this.getRandomNumber(maxGold, minGold);
    }

    public void randomAddOrSub(int maxGold, int minGold) {
        Random rand       = new Random();
        String operations = "+-";
        char   operation  = operations.charAt(rand.nextInt(operations.length()));

        switch (operation) {
            case '+':
                this.addGold(maxGold, minGold);
                break;
            case '-':
                this.subtractGold(maxGold, minGold);
                break;
        }
    }

    public void addActivities(int gold, Date date, String place){
        Activity activity = new Activity(gold,date, place);
        activities.add(activity);
    }

    public ArrayList<Activity> getActivities(){
        return this.activities;
    }


}
