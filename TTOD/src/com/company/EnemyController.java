package com.company;

/**
 * Created by Kaiden on 28.10.2016.
 */
@java.lang.SuppressWarnings("ALL")
public class EnemyController extends Enemy {

    enemy =Enemy.getName()

    public EnemyController() {

        if ( int FloorCount = 1 ){
            setType(Types.Humanoid)
        }

        if ( int FloorCount = 2 ){
            setType(Types.Humanoid)
        }

        if ( int FloorCount = 3 ){
            setType(Types.Goblinoid)
        }

        if ( int FloorCount = 4 ){
            setType(Types.Goblinoid)
        }

        if ( int FloorCount = 5 ){
            setType(Types.Creature)
        }

        if ( int FloorCount = 6 ){
            setType(Types.Creature)
        }

        if ( int FloorCount = 7 ){
            setType(Types.Dragon)
        }

        if ( int FloorCount = 8 ){
            setType(Types.Dragon)
        }

        if (Types.Enemy getType(Humanoid) && int FloorCount = 1){
            Character.setName(String name){
                name = "Bandit""
            }
            Character.setMaxLife(float maxLife){
                maxLife = 100
            }
            Character.setDefense(float defense){
                defense = 10
            }
            Character.setAttack(float attack){
                attack = 10
            }
            Character.setInteligence(float inteligence){
                inteligence = 1
            }
            Character.setCritChance(float critChance){
                critChance = 10
            }
            Character.setBlockChance(float blockChance){
                blockChance = 10
            }
            Character.settLuck(float luck){
                luck = 50
            }
            Character.setInitiative(int initiative){
                initiative = 15
            }
            Character.setMaxItems(int maxItems){
                maxItems = 5
            }
            Character.setGEIL(float GEIL){
                GEIL = 30 * FloorCount
            }

        }
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