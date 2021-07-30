package com.johfloresm.gameninja.models;

import java.util.Date;

public class Activity {

    int    amount;
    Date   date;
    String place;

    public Activity(int amount, Date date, String place){
        this.amount = amount;
        this.date   = date;
        this.place  = place;
    }

    public String getDetails(){
        if(this.amount > 0){
            return "You entered a " + place + " and earned " + amount + " gold (" + date + ")";
        }

        return "You entered a " + place + " and lost " + amount * -1 + " gold... Ouch (" + date + ")";
    }

    public int getAmount(){
        return this.amount;
    }

}
