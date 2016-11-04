package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pstieger on 28.10.2016.
 */
public class Floor {
    public String FloorName;
    public ArrayList<Enemy> PossibleEnemies = new ArrayList<Enemy>();
    public Enemy Boss;
    public int FinishedBattles = 0;
    public int FloorId;

    public Floor(){
        Boss = new Enemy();
        Boss.setType(Types.Enemy.Dragon);
    }

    public Combat nextCombat(){
        Combat combat = nextCombat();

        return combat;
    }

    public boolean canLeave(){
        return false;
    }
}
