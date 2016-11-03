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
                enemyToDefine.Luck = 100;
                enemyToDefine.EvolvesTo = getEnemy(Types.Enemy.Humanoid);
                break;
            case Humanoid:
                //Define Humanoid
                break;
            default:
                enemyToDefine.Name = "Steve";
                break;
        }
        return enemyToDefine;
    }
}


/*
 * Dragon
 * dragon           7 & 8
 * legendary dragon 8
 *
 * Humanoid
 * skeleton         2
 * bandit           1
 *
 * Goblinoid
 * goblin
 * ork
 * kobold
 *
 * Creature
 * treant
 * spiders
 *
 * Shepard
 * shepard
 */