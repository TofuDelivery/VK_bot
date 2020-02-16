package main.com.company.java.Potions;

import main.com.company.java.Character;
import main.com.company.java.Potion;

public class ElixirOfLife extends Potion
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
