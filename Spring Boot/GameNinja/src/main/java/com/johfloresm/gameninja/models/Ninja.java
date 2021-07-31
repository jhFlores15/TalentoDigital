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
        Random r = new Random();
        return r.nextInt((maxGold - minGold) + 1) + minGold;
    }

    public int addGold(int maxGold, int minGold) {
        int ammount = this.getRandomNumber(maxGold, minGold);
        this.gold = this.gold + ammount;

        return ammount;
    }

    public int subtractGold(int maxGold, int minGold) {
        int ammount = this.getRandomNumber(maxGold, minGold) * -1;
        this.gold = this.gold + ammount;

        return ammount;
    }

    public Integer randomAddOrSub(int maxGold, int minGold) {
        Random rand       = new Random();
        String operations = "+-";
        char   operation  = operations.charAt(rand.nextInt(operations.length()));
        Integer ammount = null;
        switch (operation) {
            case '+':
                ammount = this.addGold(maxGold, minGold);
                break;
            case '-':
                ammount = this.subtractGold(maxGold, minGold);
                break;
        }

        return ammount;
    }

    public void addActivity(int ammount, String place){
        Date date = new Date();
        Activity activity = new Activity(ammount,date, place);
        activities.add(activity);
    }

    public ArrayList<Activity> getActivities(){
        return this.activities;
    }

    public int getGold(){
        return gold;
    }
}
