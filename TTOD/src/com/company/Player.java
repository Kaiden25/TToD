package com.company;

/**
 * Created by Kaiden on 28.10.2016.
 */
public class Player {
  public static Player getOurInstance() {
    return ourInstance;
  }

  public static void setOurInstance(Player ourInstance) {
    Player.ourInstance = ourInstance;
  }

  private static Player ourInstance = new Player();

  public static Player getInstance() {
    return ourInstance;
  }

  private Player() {
  }

  public int TimesCleared;

  public int Charisma;

  public int FloorCount;

}
