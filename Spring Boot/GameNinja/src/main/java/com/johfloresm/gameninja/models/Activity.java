package com.johfloresm.gameninja.models;

import java.text.SimpleDateFormat;
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
            return "You entered a " + place + " and earned " + amount + " gold (" + this.formatDate() + ")";
        }

        return "You entered a " + place + " and lost " + amount * -1 + " gold... Ouch (" + this.formatDate() + ")";
    }

    public int getAmount(){
        return this.amount;
    }

    private String formatDate(){
        SimpleDateFormat dt = new SimpleDateFormat("EEEE d 'de' MMMM YYYY hh:mm aaa");

        return dt.format(this.date);
    }

}
