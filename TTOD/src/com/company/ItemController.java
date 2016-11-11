package com.company;

/**
 * Created by Kaiden on 04.11.2016.
 */
public class ItemController {
  public static Item getItem(Types.ItemType type) {
    Item itemToDefine = new Item();
    itemToDefine.Type = type;

    switch (type) {
      case Armor:
        itemToDefine.Name = "Iron Armor";
        itemToDefine.Defense = 15;
        itemToDefine.MaxCount = 1;
        itemToDefine.Value = 175;
        itemToDefine.IsCombatItem = true;
        itemToDefine.Type = type;
        break;
      case Weapon:
        itemToDefine.Name = "Warblade";
        itemToDefine.Attack = 15;
        itemToDefine.MaxCount = 1;
        itemToDefine.Value = 175;
        itemToDefine.IsCombatItem = true;
        itemToDefine.Type = type;
        break;
      case Potion:
        itemToDefine.Name = "Health Potion";
        itemToDefine.Healing = 15;
        itemToDefine.MaxCount = 3;
        itemToDefine.Value = 175;
        itemToDefine.IsCombatItem = true;
        itemToDefine.Type = type;
        break;
      case Scrap:
        itemToDefine.Name = "Scraps";
        itemToDefine.MaxCount = 99;
        itemToDefine.Value = 5;
        itemToDefine.IsCombatItem = false;
        itemToDefine.Type = type;
        break;
      default:
        getItem(Types.ItemType.Scrap);
        break;
    }
    return itemToDefine;
  }
}