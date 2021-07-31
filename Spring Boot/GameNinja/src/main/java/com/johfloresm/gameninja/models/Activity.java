package com.johfloresm.gameninja.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity {

    int    ammount;
    Date   date;
    String place;

    public Activity(int ammount, Date date, String place){
        this.ammount = ammount;
        this.date   = date;
        this.place  = place;
    }

    public String getDetails(){
        if(this.ammount > 0){
            return "You entered a " + place + " and earned " + ammount + " gold (" + this.formatDate() + ")";
        }

        return "You entered a " + place + " and lost " + ammount * -1 + " gold... Ouch (" + this.formatDate() + ")";
    }

    public int getAmount(){
        return this.ammount;
    }

    private String formatDate(){
        SimpleDateFormat dt = new SimpleDateFormat("EEEE d 'de' MMMM YYYY hh:mm aaa");

        return dt.format(this.date);
    }

}
