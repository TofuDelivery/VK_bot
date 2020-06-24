package com.company.potions;

import com.company.Character;
import com.company.Potion;

public class BigHealthPotion implements Potion
{
    private String name = "Большое зелье здоровья";
    int value = 400;

    public String getName(){
        return this.name;
    }

    @Override
    public void consume(Character target)
    {
        target.setCurrentHealth(Math.min(target.maximumHealth, target.currentHealth + 40));
    }
}
