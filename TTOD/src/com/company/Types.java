package com.company;

/**
 * Created by Michael on 28.10.2016.
 * This class is used for all types or states something in this game can have.
 */
public class Types {
    public enum Trader {
        Armor, Weapon, General
    }

    public enum TradeResult {
        Successful, UnexistingItem, NotEnoughMoney, NotEnoughSpace
    }

    public enum Enemy {
        Dragon, Humanoid, Goblinoid, Creature, Shepard, Undead, Lich
    }

    public enum CombatActionResult {
        ItemUsed, ItemMissed, Attacked, AttackMissed, Defended, Escaped, Waited, Evolved
    }

    public enum ItemType {
        Armor, Weapon, Potion, Scrap
    }
}
