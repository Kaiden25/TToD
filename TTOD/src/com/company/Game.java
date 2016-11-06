package com.company;

import java.util.Random;

/**
 * Created by pstieger on 28.10.2016.
 */
public class Game {
    /** The Town */
    public Town Town;

    /** The Dungeon */
    public Dungeon Dungeon;

    public Game(){
        Town = new Town();
        Dungeon = new Dungeon();
    }

    /** Initializes everything needed to start a new game */
    public void startNewDefaultGame(){
        initializeDefaultPlayer();
        Dungeon.generateDefaultFloors();
        Town.generateDefaultTraders();
    }

    /** Initializes the Player */
    public void initializeDefaultPlayer(){
        Player.getOurInstance().FloorCount = 0;
        Player.getOurInstance().setMaxLife(1500);
        Player.getOurInstance().Attack = 60;
        Player.getOurInstance().Luck = new Random().nextInt(100);
        Player.getOurInstance().Charisma = new Random().nextInt(100);
        Player.getOurInstance().TimesCleared = 0;
        Player.getOurInstance().BlockChance = 60;
        Player.getOurInstance().CritChance = 60;
        Player.getOurInstance().Defense = 60;
        Player.getOurInstance().Initiative = new Random().nextInt(100);
        Player.getOurInstance().MaxItems = 20;
        Player.getOurInstance().GEIL = 0;
        Item cape = new Item();
        cape.Type = Types.ItemType.Armor;
        cape.Name = "Hero cape";
        cape.Value = 300;
        cape.Defense = 30;
        cape.MaxCount = 1;
        Player.getOurInstance().addItem(cape);
        Player.getOurInstance().setArmor(cape);
        Item stick = new Item();
        stick.Name = "Fancy stick of fancyness";
        stick.Type = Types.ItemType.Weapon;
        stick.Attack = 20;
        stick.Value = 50;
        stick.MaxCount = 1;
        Player.getOurInstance().addItem(stick);
        Player.getOurInstance().setWeapon(stick);
    }

    public void initializeGodModePlayer(){
        Player.getOurInstance().setMaxLife(10000);
        Player.getOurInstance().Attack = 300;
        Player.getOurInstance().Luck = 100;
        Player.getOurInstance().Charisma = 100;
        Player.getOurInstance().BlockChance = 300;
        Player.getOurInstance().CritChance = 300;
        Player.getOurInstance().Defense = 300;
        Player.getOurInstance().Initiative = 300;
        Player.getOurInstance().MaxItems = 200;
    }
}
