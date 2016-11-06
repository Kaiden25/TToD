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

    public Enemy cloneEnemy(){
        Enemy returnValue = new Enemy();
        returnValue.EvolvesTo = this.EvolvesTo;
        returnValue.Name = this.Name;
        returnValue.Life = this.Life;
        returnValue.Weapon = this.Weapon;
        returnValue.Type = this.Type;
        returnValue.Armor = this.Armor;
        returnValue.Attack = this.Attack;
        returnValue.BlockChance = this.Attack;
        returnValue.CritChance = this.CritChance;
        returnValue.Defense = this.Defense;
        returnValue.GEIL = this.GEIL;
        returnValue.Initiative = this.Initiative;
        returnValue.Items = this.Items;
        returnValue.Intelligence = this.Intelligence;
        returnValue.Luck = this.Luck;
        returnValue.MaxItems = this.MaxItems;
        returnValue.MaxLife = this.MaxLife;
        return returnValue;
    }
}