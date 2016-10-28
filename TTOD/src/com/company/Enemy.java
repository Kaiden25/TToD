package com.company;

/**
 * Created by Kaiden on 28.10.2016.
 */
public class Enemy extends Character{
    public Types.Enemy Type;
    public Enemy EvolvesTo;

    public Enemy() {
        Type = Types.Enemy.Creature;
        EvolvesTo = null;
    }
}
