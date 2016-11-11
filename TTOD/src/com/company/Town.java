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
        blacksmith.Charisma = 10;
        blacksmith.GEIL = 400;
        blacksmith.Items.add(ItemController.getItem(Types.ItemType.Weapon));
        blacksmith.Items.add(ItemController.getItem(Types.ItemType.Scrap));
        Item itemToDefine = ItemController.getItem(Types.ItemType.Weapon);
        itemToDefine.Name = "Warblade+";
        itemToDefine.Attack = 30;
        itemToDefine.Value = 500;
        blacksmith.Items.add(itemToDefine);
        Item itemToDefine2 = ItemController.getItem(Types.ItemType.Weapon);
        itemToDefine2.Name = "Warblade++";
        itemToDefine2.Attack = 45;
        itemToDefine2.Value = 750;
        blacksmith.Items.add(itemToDefine2);
        Item itemToDefine3 = ItemController.getItem(Types.ItemType.Weapon);
        itemToDefine3.Name = "The dark sword of invincibility";
        itemToDefine3.Attack = 60;
        itemToDefine3.Value = 1100;
        blacksmith.Items.add(itemToDefine3);
        Item itemToDefine4 = ItemController.getItem(Types.ItemType.Weapon);
        itemToDefine4.Name = "The ultimate platinum blade of DOOM";
        itemToDefine4.Attack = 100;
        itemToDefine4.Value = 4000;
        blacksmith.Items.add(itemToDefine4);
        Traders.add(blacksmith);

        Trader armorsmith = new Trader();
        armorsmith.Name = "Benny the armorsmith";
        armorsmith.Charisma = 50;
        armorsmith.GEIL = 400;
        armorsmith.Items.add(ItemController.getItem(Types.ItemType.Armor));
        armorsmith.Items.add(ItemController.getItem(Types.ItemType.Scrap));
        Item armorToDefine = ItemController.getItem(Types.ItemType.Armor);
        armorToDefine.Name = "Gold Armor";
        armorToDefine.Defense = 30;
        armorToDefine.Value = 500;
        armorsmith.Items.add(armorToDefine);
        Item armorToDefine2 = ItemController.getItem(Types.ItemType.Armor);
        armorToDefine2.Name = "Platinum Armor";
        armorToDefine2.Defense = 60;
        armorToDefine2.Value = 2000;
        armorsmith.Items.add(armorToDefine2);
        Item armorToDefine3 = ItemController.getItem(Types.ItemType.Armor);
        armorToDefine3.Name = "Toilet paper Armor";
        armorToDefine3.Defense = 100;
        armorToDefine3.Value = 8000;
        armorsmith.Items.add(armorToDefine3);
        Traders.add(armorsmith);
        Trader generalmerchant = new Trader();
        generalmerchant.Name = "Bob the general merchant";
        generalmerchant.Charisma = 70;
        generalmerchant.GEIL = 400;
        generalmerchant.Items.add(ItemController.getItem(Types.ItemType.Potion));
        generalmerchant.Items.add(ItemController.getItem(Types.ItemType.Scrap));
        Item potion = ItemController.getItem(Types.ItemType.Potion);
        potion.Name = "Max Health Potion";
        potion.Healing = 70;
        potion.Value = 600;
        generalmerchant.Items.add(potion);
        Traders.add(generalmerchant);
        Traders.add(generalmerchant);
    }

    /** Rest, and fill up players life */
    public void goSleeping(){
        Player.getOurInstance().Life = Player.getOurInstance().MaxLife;
    }
}
