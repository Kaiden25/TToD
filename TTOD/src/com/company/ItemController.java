package com.company;

/**
 * Created by Kaiden on 04.11.2016.
 */
public class ItemController {
  public Item getItem(Types.ItemType type) {
    Item itemToDefine = new Item();
    switch (type) {
      case Armor:
        itemToDefine.MaxCount = 1;
        itemToDefine.Value = 175;
        itemToDefine.IsCombatItem = true;
        break;
      case Sword:
        itemToDefine.MaxCount = 1;
        itemToDefine.Value = 175;
        itemToDefine.IsCombatItem = true;
        break;
      case Potion:
        itemToDefine.MaxCount = 3;
        itemToDefine.Value = 175;
        itemToDefine.IsCombatItem = false;
        break;
      case Scrap:
        itemToDefine.MaxCount = 99;
        itemToDefine.Value = 5;
        itemToDefine.IsCombatItem = false;
        break;
      default:
        getItem(Types.ItemType.Scrap);
        break;
    }
    return itemToDefine;
  }
}