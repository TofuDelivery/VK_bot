package com.company;

public class Item
{
    public String name;
    public int value;
    public Bonus bonuses;
    public String itemType;

    public Item(String name, int value, Bonus bonuses, String itemType)
    {
        this.name = name;
        this.value = value;
        this.bonuses = bonuses;
        this.itemType = itemType;
    }
}
