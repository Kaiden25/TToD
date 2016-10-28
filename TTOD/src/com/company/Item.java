package com.company;

/**
 * Created by Kaiden on 28.10.2016.
 */
public class Item {
    public int MaxCount;

    public enum ItemType {
        Armor, Sword, Potion, Scrap
    }

    public ItemType Type;

    public float Value;

    public boolean IsCombatItem;

    public Item(){
        MaxCount = 0;
        Type = ItemType.Scrap;
        Value = 0;
        IsCombatItem = false;
    }
}
