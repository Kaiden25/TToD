package com.company;

import java.util.ArrayList;

/**
 * Created by pstieger on 28.10.2016.
 */
public class Town {
    public ArrayList<Trader> Traders;

    public Town(){
        Traders = new ArrayList<Trader>();
    }

    public void generateDefaultTraders(){
        Trader blacksmith = new Trader();
        blacksmith.Name = "Wilfried the blacksmith";
        blacksmith.Charisma = 30;
        blacksmith.GEIL = 400;
        //Add all Items to the Trader
        Traders.add(blacksmith);
    }

    /** Rest, and fill up players life */
    public void goSleeping(){
        Player.getOurInstance().Life = Player.getOurInstance().MaxLife;
    }
}
