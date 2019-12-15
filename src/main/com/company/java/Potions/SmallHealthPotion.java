package main.com.company.java.Potions;

import main.com.company.java.Character;
import main.com.company.java.Potion;

public class SmallHealthPotion extends Potion
{
    String name = "Маленькое зелье здоровья";
    int value = 50;

    @Override
    public void consume(Character target)
    {
        target.currentHealth = Math.min(target.maximumHealth, target.currentHealth + 10);
    }
}
