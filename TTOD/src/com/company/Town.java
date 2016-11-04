package com.company;

import java.util.ArrayList;

/**
 * Created by pstieger on 28.10.2016.
 */
public class Town {
    private ArrayList<Trader> traders = new ArrayList<Trader>();

    public ArrayList<Trader> getTraders() {
        return traders;
    }

    public void setTraders(ArrayList<Trader> traders) {
        this.traders = traders;
    }

    public void goSleeping(){

    }

    public Trader getTrader(Types.Trader traderType){
        for(Trader t : traders){
            if(t.Type == traderType){
                return t;
            }
        }

        return null;
    }
}
