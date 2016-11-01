package com.company;

/**
 * Created by Michael on 28.10.2016.
 */
public class Types {
    public enum Trader {
        Armor, Weapon, General
    }

    public enum TradeResult {
        Successful, UnexistingItem, NotEnougthMoney, NotEnoughtSpace
    }

    public enum Enemy {
        Dragon, Humanoid, Goblinoid, Creature
    }
}
