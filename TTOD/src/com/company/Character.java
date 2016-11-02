package com.company;
import java.util.ArrayList;
/**
 * Created by Kaiden on 28.10.2016.
 */
public class Character {

    /**The Character Name*/
    public String Name;

    /** The Characters current Life */
    public float Life;

    /** The max Character Life
     * Min Value = 1 */
    public float MaxLife;

    /**T he Character Defense
     * Value between 1-100*/
    public float Defense;

    /** The Character Attack
     * Value between 1-100*/
    public float Attack;

    /** The Character Inteligence
     * Value between 1-100*/
    public float Inteligence;

    /** The Character Critical Hit Chance
     * Value between 1-100*/
    public float CritChance;

    /** The Character Blocking Chance
     * Value between 1-100*/
    public float BlockChance;

    /** The Character Luck Value
     * Value between 1-100*/
    public float Luck;

    /** The Character Speed
     * Value between 1-100*/
    public int Initiative;

    /** The Characters maximum of Items
     * Min Value = 0*/
    public int MaxItems;

     /** The Money of the Character
     * Min Value = 0*/
    public float GEIL;

    /** The current Armor of the Character */
    public Item Armor;

    /** The current Weapon of the Character */
    public Item Weapon;

    /** The current Items the character has
     * Can't be higher than MaxItems*/
    public ArrayList<Item> Items;

    public Character() {
        Name = "Darman";
        MaxLife = 1;
        Life = MaxLife;
        Defense = 1;
        Attack = 1;
        Inteligence = 1;
        CritChance = 1;
        BlockChance = 1;
        Luck = 1;
        Initiative = 1;
        MaxItems = 0;
        GEIL = 0;
        Armor = null;
        Weapon = null;
        Items = new ArrayList<Item>();
    }

    /** Savely adds item to character
     * returns false if item wasn't addable */
    public boolean addItem(Item item){
        if (Items.size() < MaxItems){
            Items.add(item);
            return true;
        }
        else
            return false;
    }

    /** Savely removes an item from the Character
     * returns false if the item wasn't removable */
    public boolean removeItem(Item item){
        if(Items.contains(item)){
            Items.remove(item);
            if(Armor == item)
                Armor = null;
            if(Weapon == item)
                Weapon = null;
            return true;
        }
        else
            return false;
    }

    /** Savely sets Armor of the Character
     * returns false if adding wasn't possible */
    public boolean setArmor(Item item){
        if (item.Type == Types.ItemType.Armor && Items.contains(item)){
            Armor = item;
            return true;
        }
        else
            return false;
    }

    /** Savely sets the Weapon of the Character
     * returns false if adding wasn't possible */
    public boolean setWeapon(Item item){
        if (item.Type == Types.ItemType.Sword && Items.contains(item)){
            Armor = item;
            return true;
        }
        else
            return false;
    }

    /** Savely sets MaxLife */
    public void setMaxLife(float maxLife){
        MaxLife = maxLife;
        Life = MaxLife;
    }
}
