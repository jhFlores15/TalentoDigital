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

    public int addGold(int maxGold, int minGold) {
        int amount = this.getRandomNumber(maxGold, minGold);
        this.gold = this.gold + amount;

        return amount;
    }

    public int subtractGold(int maxGold, int minGold) {
        int amount = this.getRandomNumber(maxGold, minGold) * -1;
        this.gold = this.gold - amount;

        return amount;
    }

    public Integer randomAddOrSub(int maxGold, int minGold) {
        Random rand       = new Random();
        String operations = "+-";
        char   operation  = operations.charAt(rand.nextInt(operations.length()));
        Integer amount = null;
        switch (operation) {
            case '+':
                amount = this.addGold(maxGold, minGold);
                break;
            case '-':
                amount = this.subtractGold(maxGold, minGold);
                break;
        }

        return amount;
    }

    public void addActivity(int amount, String place){
        Date date = new Date();
        Activity activity = new Activity(amount,date, place);
        activities.add(activity);
    }

    public ArrayList<Activity> getActivities(){
        return this.activities;
    }


}
