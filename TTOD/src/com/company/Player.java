package com.company;

/**
 * Created by Kaiden on 28.10.2016.
 */
public class Player extends Character {

  public int TimesCleared;

  public int Charisma;

  public int FloorCount;

  private static Player ourInstance = new Player();

  private Player() {
    TimesCleared = 0;
    Charisma = 0;
    FloorCount = 0;
  }

  public static Player getOurInstance() {
    return ourInstance;
  }

  public static void setOurInstance(Player ourInstance) {
    Player.ourInstance = ourInstance;
  }
}
