package com.company;

public class ActiveItem extends Item
{
    int health_recovery;
    //int mana_recovery;
    public ActiveItem(String name, int health_recovery)
    {
        super(name);
        this.health_recovery = health_recovery;
        //this.mana_recovery = mana_recovery;
    }
}
