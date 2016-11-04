package com.company;

/**
 * Created by Kaiden on 28.10.2016.
 */
@java.lang.SuppressWarnings("ALL")
public class EnemyController {
    Enemy getEnemy(Types.Enemy type){
        Enemy enemyToDefine = new Enemy();
        switch (type){
            case Creature:
                enemyToDefine.Name = "Spider";
                enemyToDefine.MaxLife = 175;
                enemyToDefine.Life = enemyToDefine.MaxLife;
                enemyToDefine.Defense = 20;
                enemyToDefine.Attack = 20;
                enemyToDefine.Inteligence = 10;
                enemyToDefine.CritChance = 50;
                enemyToDefine.BlockChance = 50;
                enemyToDefine.Luck = 10;
                enemyToDefine.Initiative = 25;
                enemyToDefine.MaxItems = 5;
                enemyToDefine.GEIL = 100;
                break;
            case Humanoid:
                enemyToDefine.Name = "Bandit";
                enemyToDefine.MaxLife = 100;
                enemyToDefine.Life = enemyToDefine.MaxLife;
                enemyToDefine.Defense = 20;
                enemyToDefine.Attack = 20;
                enemyToDefine.Inteligence = 10;
                enemyToDefine.CritChance = 50;
                enemyToDefine.BlockChance = 50;
                enemyToDefine.Luck = 10;
                enemyToDefine.Initiative = 15;
                enemyToDefine.MaxItems = 5;
                enemyToDefine.GEIL = 100;
                break;
            case Goblinoid:
                enemyToDefine.Name = "Goblin";
                enemyToDefine.MaxLife = 150;
                enemyToDefine.Life = enemyToDefine.MaxLife;
                enemyToDefine.Defense = 10;
                enemyToDefine.Attack = 25;
                enemyToDefine.Inteligence = 10;
                enemyToDefine.CritChance = 50;
                enemyToDefine.BlockChance = 50;
                enemyToDefine.Luck = 10;
                enemyToDefine.Initiative = 15;
                enemyToDefine.MaxItems = 5;
                enemyToDefine.GEIL = 100;
                break;
            case Shepard:
                enemyToDefine.Name = "Shepard";
                enemyToDefine.MaxLife = 1;
                enemyToDefine.Life = enemyToDefine.MaxLife;
                enemyToDefine.Defense = 200;
                enemyToDefine.Attack = 200;
                enemyToDefine.Inteligence = 10;
                enemyToDefine.CritChance = 100;
                enemyToDefine.BlockChance = 50;
                enemyToDefine.Luck = 10;
                enemyToDefine.Initiative = 15;
                enemyToDefine.MaxItems = 5;
                enemyToDefine.GEIL = 33;
                break;
            case Dragon:
                enemyToDefine.Name = "Dragon";
                enemyToDefine.MaxLife = 500;
                enemyToDefine.Life = enemyToDefine.MaxLife;
                enemyToDefine.Defense = 40;
                enemyToDefine.Attack = 40;
                enemyToDefine.Inteligence = 20;
                enemyToDefine.CritChance = 50;
                enemyToDefine.BlockChance = 50;
                enemyToDefine.Luck = 20;
                enemyToDefine.Initiative = 25;
                enemyToDefine.MaxItems = 10;
                enemyToDefine.GEIL = 500;
                enemyToDefine.EvolvesTo = getEnemy(Types.Enemy.Undead);
                break;
            case Undead:
                enemyToDefine.Name = "Dracolich";
                enemyToDefine.MaxLife = 800;
                enemyToDefine.Life = enemyToDefine.MaxLife;
                enemyToDefine.Defense = 50;
                enemyToDefine.Attack = 50;
                enemyToDefine.Inteligence = 30;
                enemyToDefine.CritChance = 50;
                enemyToDefine.BlockChance = 50;
                enemyToDefine.Luck = 10;
                enemyToDefine.Initiative = 35;
                enemyToDefine.MaxItems = 15;
                enemyToDefine.GEIL = 1000;
                break;
            default:
                enemyToDefine.Name = "Steve";
                enemyToDefine.MaxLife = 1;
                enemyToDefine.Life = enemyToDefine.MaxLife;
                enemyToDefine.Defense = 1;
                enemyToDefine.Attack = 1;
                enemyToDefine.Inteligence = 1;
                enemyToDefine.CritChance = 1;
                enemyToDefine.BlockChance = 1;
                enemyToDefine.Luck = 1;
                enemyToDefine.Initiative = 1;
                enemyToDefine.MaxItems = 1;
                enemyToDefine.GEIL = 1;
                break;
        }
        return enemyToDefine;
    }
}

/*
Dragon
dragon
legendary dragon
Humanoid
skeleton
bandit
Goblinoid
goblin
ork
kobold
Creature
treant
spiders
Shepard
shepard
*/