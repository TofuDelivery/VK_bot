package com.company;

public class PassiveItem extends Item
{
    Bonus bonuses;

    public PassiveItem(String name, Bonus bonuses)
    {
        super(name);
        this.bonuses = bonuses;
    }
}
