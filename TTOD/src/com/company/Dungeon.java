package com.company;

import java.util.ArrayList;

/**
 * Created by pstieger on 28.10.2016.
 */
public class Dungeon {
    private ArrayList<Floor> floors = new ArrayList<Floor>();

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }

    public Dungeon(){

    }

    public void generateFloors(int count){
        for(int i = 0; i < count; i++){
            floors.add(new Floor());
        }
    }

    public Floor getFloor(){
        return null;
    }

    public Floor nextFloor(Floor lastFloor){
        return floors.get(floors.indexOf(lastFloor) + 1);
    }
}
