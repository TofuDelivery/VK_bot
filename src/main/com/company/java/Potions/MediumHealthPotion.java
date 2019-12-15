package main.com.company.java.Potions;

import main.com.company.java.Character;
import main.com.company.java.Potion;

public class MediumHealthPotion extends Potion
{
    String name = "Среднее зелье здоровья";
    int value = 150;
    @Override
    public void consume(Character target)
    {
        target.currentHealth = Math.min(target.maximumHealth, target.currentHealth + 20);
    }
}
