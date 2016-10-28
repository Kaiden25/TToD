package com.company;

/**
 * Created by Michael on 28.10.2016.
 */
public class Trader {

    public Item[] Items;

    public Types.Trader Type;

    public float GEIL;

    public String Name;

    public int Charisma;

    public Trader(){
        Type = Types.Trader.General;
        GEIL = 0;
        Name = "John Doe";
        Charisma = 0;
    }

    public Types.TradeResult buyItem(Item item) {
        return Types.TradeResult.Unsuccessful;
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
