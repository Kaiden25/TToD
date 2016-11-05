package com.company;

import java.util.Random;

/**
 * Created by Michael on 28.10.2016.
 */
public class Combat {

    public Enemy CurrentEnemy;

    public Combat(Enemy enemy){
        CurrentEnemy = enemy;
    }

    /** Attack Enemy */
    public CombatResult attack(){
        CombatResult result = new CombatResult();
        result.EnemyHadFirstHit = enemyHasFirstHit();

        //Enemy Attacks first
        if(result.EnemyHadFirstHit)
            result = enemyMove(result);

        //Player attacks if still alive
        if(Player.getOurInstance().Life > 0 && result.EnemyAction != Types.CombatActionResult.Escaped){
            result.PlayerAction = Types.CombatActionResult.Attacked;
            //Calculates Damage
            result.EnemyLifeDifference = Player.getOurInstance().Attack / CurrentEnemy.Defense * CurrentEnemy.MaxLife;
            if(result.EnemyHadFirstHit && result.EnemyAction == Types.CombatActionResult.Defended)
                result.EnemyLifeDifference = result.EnemyLifeDifference - CurrentEnemy.Defense / 100 * result.EnemyLifeDifference;
            if(result.EnemyLifeDifference > CurrentEnemy.Life)
                result.EnemyLifeDifference = CurrentEnemy.Life;
            result.EnemyLifeDifference = 0 - result.EnemyLifeDifference;
            //Deals Damage to enemy
            CurrentEnemy.Life = CurrentEnemy.Life + result.EnemyLifeDifference;
        }

        //Enemy Attacks 2nd if still alive
        if(!result.EnemyHadFirstHit && CurrentEnemy.Life > 0)
            result = enemyMove(result);
        return result;
    }

    /** Defend against Enemy */
    public CombatResult defense() {
        CombatResult result = new CombatResult();
        result.PlayerAction = Types.CombatActionResult.Defended;
        return enemyMove(result);
    }

    /** NEEDS TO BE IMPLEMENTED!!!!! */
    public CombatResult usePotion(Item item){
        CombatResult result = new CombatResult();
        result.PlayerAction = Types.CombatActionResult.ItemUsed;
        Player.getOurInstance().Life = Player.getOurInstance().Life + ItemController.getItem(Types.ItemType.Potion).Healing;
        return result;
    }

    /** Escape from Combat */
    public CombatResult flee(){
        CombatResult result = new CombatResult();
        result.EnemyHadFirstHit = enemyHasFirstHit();
        result.PlayerAction = Types.CombatActionResult.Escaped;
        if(result.EnemyHadFirstHit == true)
            result = enemyMove(result);
        return result;
    }

    /** Wait a round and let Enemy perform a move */
    public CombatResult getAttacked(){
        CombatResult result = new CombatResult();
        result.PlayerAction = Types.CombatActionResult.Waited;
        return enemyMove(result);
    }

    /** Calculates the first to attack
     * returns true if enemy has first hit*/
    private boolean enemyHasFirstHit() {
        int playerChance = 0;
        if(CurrentEnemy.Initiative < Player.getOurInstance().Initiative)
            playerChance = playerChance + 2;
        if(CurrentEnemy.Inteligence < Player.getOurInstance().Inteligence)
            playerChance++;
        if(CurrentEnemy.Luck < Player.getOurInstance().Luck){
            playerChance++;
        }
        if(new java.util.Random().nextBoolean())
            playerChance++;
        if(playerChance >= 3)
            return false;
        else
            return true;
    }

    private CombatResult enemyMove(CombatResult result){
        //Calculates Enemy Move
        if(CurrentEnemy.Life > 0){
            if (result.EnemyHadFirstHit)
            {
                if(CurrentEnemy.Life > (CurrentEnemy.MaxLife * 0.25)){
                    if(new Random().nextBoolean() || new Random().nextBoolean())
                        result = enemyAttacks(result);
                    else
                        result.EnemyAction = Types.CombatActionResult.Defended;
                }
                else if(new Random().nextBoolean())
                    result = enemyAttacks(result);
                else if(new Random().nextBoolean() || new Random().nextBoolean())
                    result.EnemyAction = Types.CombatActionResult.Defended;
                else
                    result.EnemyAction = Types.CombatActionResult.Escaped;
            }
            else if(new Random().nextBoolean() || new Random().nextBoolean()|| new Random().nextBoolean() || new Random().nextBoolean() || new Random().nextBoolean())
                result = enemyAttacks(result);
            else
                result.EnemyAction = Types.CombatActionResult.Escaped;

        }
        else if (CurrentEnemy.EvolvesTo != null){
            //Enemy Evolves
            CurrentEnemy = CurrentEnemy.EvolvesTo;
            result.EnemyAction = Types.CombatActionResult.Evolved;
        }
        return result;
    }

    private CombatResult enemyAttacks(CombatResult result){
        result.EnemyAction = Types.CombatActionResult.Attacked;
        //Calculates Damage
        result.PlayerLifeDifference = CurrentEnemy.Attack / Player.getOurInstance().Defense * Player.getOurInstance().MaxLife;
        if(!result.EnemyHadFirstHit && result.PlayerAction == Types.CombatActionResult.Defended)
            result.PlayerLifeDifference = result.PlayerLifeDifference - Player.getOurInstance().Defense / 100 * result.PlayerLifeDifference;
        if(result.PlayerLifeDifference > Player.getOurInstance().Life)
            result.PlayerLifeDifference = Player.getOurInstance().Life;
        result.PlayerLifeDifference = 0 - result.PlayerLifeDifference;
        //Deals Damage to enemy
        Player.getOurInstance().Life = Player.getOurInstance().Life + result.PlayerLifeDifference;
        return result;
    }
}
