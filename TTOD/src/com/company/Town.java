package com.company;

import java.util.ArrayList;

/**
 * Created by pstieger on 28.10.2016.
 */
public class Town {
    public ArrayList<Trader> Traders = new ArrayList<Trader>();

    public void goSleeping(){

    }

    public Trader getTrader(Types.Trader traderType){
        for(Trader t : Traders){
            if(t.Type == traderType){
                return t;
            }
        }

        return null;
    }
}
