package com.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Michael on 28.10.2016.
 */
public class Trader {

    public ArrayList<Item> Items;

    public Types.Trader Type;

    public float GEIL;

    public String Name;

    public int Charisma;

    public Trader(){
        Type = Types.Trader.General;
        GEIL = 0;
        Name = "John Doe";
        Charisma = 0;
        Items = new ArrayList<Item>();
    }

    public Types.TradeResult buyItem(Item item) {
        if(Items.contains(item)){
            float itemPrice = getItemBuyPrice(item);
            if(Player.getOurInstance().GEIL > itemPrice) {
                Player.getOurInstance().GEIL = Player.getOurInstance().GEIL - itemPrice;
                Player.getOurInstance().Items.add(item);
                return Types.TradeResult.Successful;
            }
            else
                return Types.TradeResult.NotEnougthMoney;
        }
        else
            return Types.TradeResult.UnexistingItem;
    }

    public float getItemSellPrice(Item item){
        return item.Value * (Player.getOurInstance().Charisma / Charisma);
    }

    public float getItemBuyPrice(Item item){
        return item.Value + item.Value * ((Charisma / 100) / Player.getOurInstance().Charisma);
    }

    public void sellItem(Item item){
        float itemPrice = getItemSellPrice(item);
        Player.getOurInstance().Items.remove(item);
        Player.getOurInstance().GEIL = Player.getOurInstance().GEIL + itemPrice;
    }

}
