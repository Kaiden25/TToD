package com.company;

/**
 * Created by Michael on 01.11.2016.
 */
public class CombatResult {

    public float PlayerLifeDifference;

    public float EnemyLifeDifference;

    public Types.CombatActionResult PlayerAction;

    public Types.CombatActionResult EnemyAction;

    public Item PlayerItemUsed;

    public Item EnemyItemUsed;

    public Boolean EnemyHadFirstHit;

    public  CombatResult(){
        EnemyHadFirstHit = false;
        PlayerItemUsed = null;
        EnemyItemUsed = null;
        EnemyAction = null;
        PlayerAction = null;
        PlayerLifeDifference = 0;
        EnemyLifeDifference = 0;
    }
}