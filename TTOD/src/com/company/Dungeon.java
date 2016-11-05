package com.company;

import java.util.ArrayList;

/**
 * Created by pstieger on 28.10.2016.
 */
public class Dungeon {
    /** All the floors of the dungeon */
    public ArrayList<Floor> Floors;

    public Dungeon(){
        Floors = new ArrayList<Floor>();
    }

    /** Generates the default dungeon floors */
    public void generateDefaultFloors(){
        EnemyController enemyController = new EnemyController();
        Floor floor = new Floor();
        for(int i = 1; i < 9; i++){
            switch(i){
                case 1:
                    floor = new Floor();
                    floor.FloorNumber = 1;
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Humanoid));
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Creature));
                    floor.Boss = enemyController.getEnemy(Types.Enemy.Humanoid);
                    floor.Boss.Name = "Ingrid the shadow priestess";
                    floor.Boss.Life = floor.Boss.Life * 2;
                    floor.Boss.Attack = (float)(floor.Boss.Attack * 1.5);
                    Floors.add(floor);
                    break;
                case 2:
                    floor = new Floor();
                    floor.FloorNumber = 2;
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Humanoid));
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Creature));
                    floor.Boss = enemyController.getEnemy(Types.Enemy.Creature);
                    floor.Boss.Name = "The mighty unicorn Goldfish";
                    floor.Boss.Life = floor.Boss.Life * 2;
                    floor.Boss.Attack = (float)(floor.Boss.Attack * 1.5);
                    Floors.add(floor);
                    break;
                case 3:
                    floor = new Floor();
                    floor.FloorNumber = 3;
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Humanoid));
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Creature));
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Shepard));
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Goblinoid));
                    floor.Boss = enemyController.getEnemy(Types.Enemy.Humanoid);
                    floor.Boss.Name = "Arthur the forgotten King";
                    floor.Boss.Life = floor.Boss.Life * 3;
                    floor.Boss.Attack = (float)(floor.Boss.Attack * 1.5);
                    floor.Boss.Defense = floor.Boss.Defense * 2;
                    Floors.add(floor);
                    break;
                case 4:
                    floor = new Floor();
                    floor.FloorNumber = 4;
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Goblinoid));
                    floor.Boss = enemyController.getEnemy(Types.Enemy.Goblinoid);
                    floor.Boss.Name = "Lucine the goblin princess";
                    floor.Boss.Life = floor.Boss.Life * 3;
                    floor.Boss.Attack = (float)(floor.Boss.Attack * 2.5);
                    Floors.add(floor);
                    break;
                case 5:
                    floor = new Floor();
                    floor.FloorNumber = 5;
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Goblinoid));
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Shepard));
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Humanoid));
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Creature));
                    floor.Boss = enemyController.getEnemy(Types.Enemy.Goblinoid);
                    floor.Boss.Name = "Crash the goblin King";
                    floor.Boss.Life = floor.Boss.Life * 3;
                    floor.Boss.Attack = (float)(floor.Boss.Attack * 2.8);
                    floor.Boss.Defense = (float)(floor.Boss.Defense * 2.3);
                    Floors.add(floor);
                    break;
                case 6:
                    floor = new Floor();
                    floor.FloorNumber = 6;
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Goblinoid));
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Shepard));
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Creature));
                    floor.Boss = enemyController.getEnemy(Types.Enemy.Dragon);
                    floor.Boss.EvolvesTo = null;
                    floor.Boss.Name = "Greethim the gatekeeper unidragon";
                    floor.Boss.Attack = (float)(floor.Boss.Attack * 1.5);
                    floor.Boss.Defense = (float)(floor.Boss.Defense * 1.9);
                    Floors.add(floor);
                    break;
                case 7:
                    floor = new Floor();
                    floor.FloorNumber = 7;
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Goblinoid));
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Shepard));
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Undead));
                    floor.Boss = enemyController.getEnemy(Types.Enemy.Dragon);
                    floor.Boss.Name = "The undead dragon of DOOM";
                    floor.Boss.Attack = (float)(floor.Boss.Attack * 2.1);
                    floor.Boss.Defense = (float)(floor.Boss.Defense * 2.6);
                    Floors.add(floor);
                    break;
                case 8:
                    floor = new Floor();
                    floor.FloorNumber = 8;
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Dragon));
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Shepard));
                    floor.PossibleEnemies.add(enemyController.getEnemy(Types.Enemy.Undead));
                    floor.Boss = enemyController.getEnemy(Types.Enemy.Lich);
                    Floors.add(floor);
                    break;
                default:
                    break;
            }
        }
    }

    /** Gets the next floor in which the player has to go */
    public Floor nextFloor(){
        if(Player.getOurInstance().FloorCount <= Floors.size())
            return Floors.get(Player.getOurInstance().FloorCount);
        else
            return Floors.get(Floors.size() -1);
    }
}
