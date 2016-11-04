package com.company;

/**
 * Created by Kaiden on 28.10.2016.
 */
public class Item {
  public String Name;

  public float Healing;

  /** The Items Defense
   * Value between 0-100*/
  public float Defense;

  /** The Items Attack
   * Value between 0-100*/
  public float Attack;

  public int MaxCount;

  public Types.ItemType Type;

  public float Value;

  public boolean IsCombatItem;

  public Item(){
    Name = "Scrap";
    Healing = 0;
    Defense = 0;
    Attack = 0;
    MaxCount = 0;
    Type = Types.ItemType.Scrap;
    Value = 0;
    IsCombatItem = false;
  }
}
