package com.company.potions;

import com.company.Character;
import com.company.Potion;

public class SmallHealthPotion implements Potion
{
    private String name;
    int value;

    public SmallHealthPotion()
    {
        this.name = "Маленькое зелье здоровья";
        this.value = 50;
    }

    public String getName(){
        return this.name;
    }
    @Override
    public void consume(Character target)
    {
       target.setCurrentHealth(Math.min(target.maximumHealth, target.currentHealth + 10));
    }
}
