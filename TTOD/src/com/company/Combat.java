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
            result.EnemyLifeDifference = CurrentEnemy.Defense - (Player.getOurInstance().Attack + (Player.getOurInstance().Weapon != null ? Player.getOurInstance().Weapon.Attack:(float)0));
            if(result.EnemyHadFirstHit && result.EnemyAction == Types.CombatActionResult.Defended)
                result.EnemyLifeDifference = result.EnemyLifeDifference - CurrentEnemy.Defense / 100 * result.EnemyLifeDifference;
            //Deals Damage to enemy
            if (result.EnemyLifeDifference <= 0)
                CurrentEnemy.Life = CurrentEnemy.Life + result.EnemyLifeDifference;
            else if (result.EnemyLifeDifference > 0){
                result.EnemyLifeDifference = 0;
                CurrentEnemy.Life = CurrentEnemy.Life + result.EnemyLifeDifference;
            }
            result.PlayerAction = Types.CombatActionResult.Attacked;
        }
        //Enemy Attacks 2nd if still alive
        if(!result.EnemyHadFirstHit && CurrentEnemy.Life > 0)
            result = enemyMove(result);
        return endRound(result);
    }

    /** Defend against Enemy */
    public CombatResult defense() {
        CombatResult result = new CombatResult();
        result.PlayerAction = Types.CombatActionResult.Defended;
        return endRound(enemyMove(result));
    }

    /** Use Potion to heal yourself */
    public CombatResult usePotion(Item item){
        CombatResult result = new CombatResult();
        if(item.Type == Types.ItemType.Potion){
            result.PlayerAction = Types.CombatActionResult.ItemUsed;
            if(item.Healing > 0)
                Player.getOurInstance().Life = Player.getOurInstance().Life + item.Healing;
            if(item.Attack > 0){
                CurrentEnemy.Life = CurrentEnemy.Life - item.Attack;
                result.EnemyLifeDifference = item.Attack;
            }
        }
        if(CurrentEnemy.Life > 0)
            result = enemyMove(result);
        return endRound(result);
    }

    /** Escape from Combat */
    public CombatResult flee(){
        CombatResult result = new CombatResult();
        result.EnemyHadFirstHit = enemyHasFirstHit();
        result.PlayerAction = Types.CombatActionResult.Escaped;
        if(result.EnemyHadFirstHit == true)
            result = enemyMove(result);
        else
            result.EnemyAction = Types.CombatActionResult.Waited;
        return endRound(result);
    }

    /** Wait a round and let Enemy perform a move */
    public CombatResult getAttacked(){
        CombatResult result = new CombatResult();
        result.PlayerAction = Types.CombatActionResult.Waited;
        return endRound(enemyMove(result));
    }

    /** Calculates the first to attack
     * returns true if enemy has first hit*/
    private boolean enemyHasFirstHit() {
        int playerChance = 0;
        if(CurrentEnemy.Initiative < Player.getOurInstance().Initiative)
            playerChance = playerChance + 2;
        if(CurrentEnemy.Intelligence < Player.getOurInstance().Intelligence)
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
            if (result.EnemyHadFirstHit){
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
            else if(new Random().nextBoolean() || new Random().nextBoolean()|| new Random().nextBoolean() || new Random().nextBoolean() || new Random().nextBoolean()) {
                result.EnemyAction = Types.CombatActionResult.Attacked;
                result = enemyAttacks(result);
            }
            else
                result.EnemyAction = Types.CombatActionResult.Escaped;
            return result;
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
        result.PlayerLifeDifference = CurrentEnemy.Attack - (Player.getOurInstance().Defense + (Player.getOurInstance().Armor != null ? Player.getOurInstance().Armor.Defense : 0));
        if(!result.EnemyHadFirstHit && result.PlayerAction == Types.CombatActionResult.Defended)
            result.PlayerLifeDifference = result.PlayerLifeDifference - (Player.getOurInstance().Defense + (Player.getOurInstance().Armor != null ? Player.getOurInstance().Armor.Defense : 0))/ 100 * result.PlayerLifeDifference;
        //Deals Damage to enemy
        if (result.PlayerLifeDifference <= 0)
            Player.getOurInstance().Life = Player.getOurInstance().Life + result.PlayerLifeDifference;
        else {
            result.PlayerLifeDifference = 0;
            Player.getOurInstance().Life = Player.getOurInstance().Life + result.PlayerLifeDifference;
        }
        result.EnemyAction = Types.CombatActionResult.Attacked;
        return result;
    }

    private CombatResult endRound(CombatResult result){
        if(CurrentEnemy.Life > 0) {
            if(CurrentEnemy.Items.size() > 0)
                for (Item item: CurrentEnemy.Items) {
                    Player.getOurInstance().Items.add(item);
                }
            Player.getOurInstance().GEIL = Player.getOurInstance().GEIL + CurrentEnemy.GEIL;
        }
        return result;
    }
}
