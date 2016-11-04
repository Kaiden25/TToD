package com.company;

import java.util.ArrayList;

/**
 * Created by Michael on 28.10.2016.
 */
public class Trader {

    /** The Items the Trader is able to sell */
    public ArrayList<Item> Items;

    /** The Tradertype*/
    public Types.Trader Type;

    /** The Money of the Trader */
    public float GEIL;

    /** The Name of the Trader */
    public String Name;

    /** The Traders Charisma
     * Value Between 1-100*/
    public int Charisma;

    public Trader(){
        Type = Types.Trader.General;
        GEIL = 0;
        Name = "John Doe";
        Charisma = 1;
        Items = new ArrayList<Item>();
    }

    /** Buy an Item from the Trader */
    public Types.TradeResult buyItem(Item item) {
        //Checks if Trader has the wanted item
        if(Items.contains(item)){
            //Gets the item price
            float itemPrice = getItemBuyPrice(item);
            //Checks if Player has enough money
            if(Player.getOurInstance().GEIL > itemPrice) {
                //Tries adding item to Player
                if(Player.getOurInstance().addItem(item)){
                    //Removes the Item Price from Players Money
                    Player.getOurInstance().GEIL = Player.getOurInstance().GEIL - itemPrice;
                    GEIL = GEIL + itemPrice;
                    return Types.TradeResult.Successful;
                }
                else
                    return Types.TradeResult.NotEnoughSpace;
            }
            else
                return Types.TradeResult.NotEnoughMoney;
        }
        else
            return Types.TradeResult.UnexistingItem;
    }

    /** Get the Price of an Item when selling*/
    public float getItemSellPrice(Item item){
        return item.Value * (Player.getOurInstance().Charisma / Charisma);
    }

    /** Get the Price of an Item when buying */
    public float getItemBuyPrice(Item item){
        return item.Value + item.Value * ((Charisma / 100) / Player.getOurInstance().Charisma);
    }

    /** Sell an Item to the Trader */
    public void sellItem(Item item){
        //Gets Item Price
        float itemPrice = getItemSellPrice(item);
        //Removes Item from Player
        Player.getOurInstance().Items.remove(item);
        //Calculates the money given to the Player if not enought money around give all money available
        if(itemPrice > GEIL)
            itemPrice = GEIL;
        //Adds Money to Player and Removes it from the Trader
        Player.getOurInstance().GEIL = Player.getOurInstance().GEIL + itemPrice;
        GEIL = GEIL - itemPrice;
    }
}
