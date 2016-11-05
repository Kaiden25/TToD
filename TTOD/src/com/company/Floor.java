package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by pstieger on 28.10.2016.
 */
public class Floor {
    /** Defines the floor name */
    public String FloorName;

    /** Defines the possible enemies in the floor*/
    public ArrayList<Enemy> PossibleEnemies;

    /** Defines the Boss of the floor */
    public Enemy Boss;

    /** Defines the count of finished battles */
    public int FinishedBattles;

    /** Defines the floornumber of the current floor */
    public int FloorNumber;

    /** Defines if fight against the boss was fought */
    public boolean SealIsActivated;

    public Floor(){
        FloorName = "Floor";
        Boss = new Enemy();
        Boss.setType(Types.Enemy.Dragon);
        PossibleEnemies = new ArrayList<Enemy>();
        FinishedBattles = 0;
        FloorNumber = 0;
        SealIsActivated = true;
    }

    /** Gets next combat for player */
    public Combat nextCombat(){
        FinishedBattles++;
        if(FinishedBattles <= 5)
            return new Combat(PossibleEnemies.get(new Random().nextInt((PossibleEnemies.size()))));
        else{
            SealIsActivated = false;
            return new Combat(Boss);
        }
    }

    /** Decides if the player is alowed to leave the dungeon */
    public boolean canLeave(){
        if(new Random().nextBoolean()){
            if(FinishedBattles < 3 || Player.getOurInstance().Luck < 70){
                if(new Random().nextBoolean())
                    return false;
                else
                    return true;
            }
            else
                return true;
        }
        else
            return false;
    }
}
