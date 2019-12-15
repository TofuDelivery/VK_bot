package main.com.company.java.Potions;

import main.com.company.java.Character;
import main.com.company.java.Potion;

public class BigHealthPotion extends Potion
{
    String name = "Большое зелье здоровья";
    int value = 400;
    @Override
    public void consume(Character target)
    {
        target.currentHealth = Math.min(target.maximumHealth, target.currentHealth + 40);
    }
}
