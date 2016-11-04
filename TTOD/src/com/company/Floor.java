package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pstieger on 28.10.2016.
 */
public class Floor {
    private String floorName;
    private ArrayList<Enemy> possibleEnemies = new ArrayList<Enemy>();
    private Enemy boss;
    private int finishedBattles = 0;
    private int floorId;

    public ArrayList<Enemy> getPossibleEnemies() {
        return possibleEnemies;
    }
    public Enemy getBoss() {
        return boss;
    }
    public int getFinishedBattles() {
        return finishedBattles;
    }
    public int getFloorId() {
        return floorId;
    }
    public String getFloorName() {
        return floorName;
    }

    public void setBoss(Enemy boss) {
        this.boss = boss;
    }
    public void setFinishedBattles(int finishedBattles) {
        this.finishedBattles = finishedBattles;
    }
    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }
    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }
    public void setPossibleEnemies(ArrayList<Enemy> possibleEnemies) {
        this.possibleEnemies = possibleEnemies;
    }

    public Floor(){
        boss = new Enemy();
        boss.setType(Types.Enemy.Dragon);
    }

    public Combat nextCombat(){
        Combat combat = nextCombat();

        return combat;
    }

    public boolean canLeave(){
        return false;
    }
}
