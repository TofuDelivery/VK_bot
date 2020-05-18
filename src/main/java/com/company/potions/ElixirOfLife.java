package com.company.potions;

import com.company.Character;
import com.company.Potion;

public class ElixirOfLife implements Potion
{
    private String name = "Эликсир жизни";
    int value = 1000;

    public String getName(){
        return this.name;
    }

    @Override
    public void consume(Character target)
    {
        target.restoreHealth();
    }
}
