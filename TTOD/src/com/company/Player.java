package com.company;

/**
 * Created by Kaiden on 28.10.2016.
 */
public class Player extends Character {

  public int TimesCleared;

  ///Value Between 0-100
  public int Charisma;

  ///Current Floor in Dungeon
  public int FloorCount;

  private static Player ourInstance = new Player();

  private Player() {
    TimesCleared = 0;
    Charisma = 0;
    FloorCount = 0;
  }

  public static Player getOurInstance() {
    if(ourInstance == null){
      ourInstance = new Player();
    }

    return ourInstance;
  }
}
