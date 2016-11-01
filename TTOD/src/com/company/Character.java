package com.company;
import java.util.ArrayList;
/**
 * Created by Kaiden on 28.10.2016.
 */
public class Character {

    public String Name;

    public float Life;

    public float BaseDefense;

    public float BaseAttack;

    public float Inteligence;

    public float CritChance;

    public float BlockChance;

    public float Luck;

    public int Initiative;

    public int MaxItems;

    public float MaxDefense;

    public float MaxLife;

    public float MaxAttack;

    public float GEIL;

    public Item Armor;

    public Item Weapon;

    public ArrayList<Item> Items;

    public Character() {
        Name = "";
        Life = 0;
        BaseDefense = 0;
        BaseAttack = 0;
        Inteligence = 0;
        CritChance = 0;
        BlockChance = 0;
        Luck = 0;
        Initiative = 0;
        MaxItems = 0;
        MaxDefense = 0;
        MaxLife = 0;
        MaxAttack = 0;
        GEIL = 0;
        Armor = new Item();
        Weapon = new Item();
        Items = new ArrayList<Item>();
    }
}
