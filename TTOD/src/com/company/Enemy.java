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

    public Types.Enemy getType() {
        return Type;
    }

    public void setType(Types.Enemy type) {
        Type = type;
    }
}

/**
legendary dragon

 goblin
ork
kobold
dragon
skeleton
treant
spiders
shepard
bandit
*/