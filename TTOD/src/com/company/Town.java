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
        blacksmith.Items.add(ItemController.getItem(Types.ItemType.Sword));
        blacksmith.Items.add(ItemController.getItem(Types.ItemType.Scrap));
        Traders.add(blacksmith);

        Trader armorsmith = new Trader();
        armorsmith.Name = "Benny the armorsmith";
        armorsmith.Charisma = 30;
        armorsmith.GEIL = 400;
        armorsmith.Items.add(ItemController.getItem(Types.ItemType.Armor));
        armorsmith.Items.add(ItemController.getItem(Types.ItemType.Scrap));
        Traders.add(armorsmith);

        Trader generalmerchant = new Trader();
        generalmerchant.Name = "Bob the general merchant";
        generalmerchant.Charisma = 30;
        generalmerchant.GEIL = 400;
        generalmerchant.Items.add(ItemController.getItem(Types.ItemType.Potion));
        generalmerchant.Items.add(ItemController.getItem(Types.ItemType.Scrap));
        Traders.add(generalmerchant);

    }

    /** Rest, and fill up players life */
    public void goSleeping(){
        Player.getOurInstance().Life = Player.getOurInstance().MaxLife;
    }
}
