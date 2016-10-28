package com.company;

/**
 * Created by Michael on 28.10.2016.
 */
public class Combat {

    public Enemy CurrentEnemy;

    public Combat(Enemy enemy){
        CurrentEnemy = enemy;
    }

    public String attack(){
        return "";
    }

    public String defense() {
        return "";
    }

    public String useItem(Item item){
        return "";
    }

    public boolean flee(){
        return true;
    }
}
