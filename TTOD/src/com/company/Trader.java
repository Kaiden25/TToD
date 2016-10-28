package com.company;

/**
 * Created by Michael on 28.10.2016.
 */
public class Trader {

    public Item[] Items;

    public enum Tradertype {
        Armor, Weapon, General
    }

    public enum TradeResult {
        Successful, Unsuccessful, UnexistingItem
    }

    public Tradertype Type;

    public float GEIL;

    public String Name;

    public int Charisma;

    public Trader(){
        Type = Tradertype.General;
        GEIL = 0;
        Name = "John Doe";
        Charisma = 0;
    }

    public TradeResult buyItem(Item item) {
        return TradeResult.Unsuccessful;
    }

    public float getItemSellPrice(Item item){
        return 0;
    }

    public float getItemBuyPrice(Item item){
        return 0;
    }

    public float sellItem(Item item){
        return 0;
    }
}
