package main.com.company.java.Potions;

import main.com.company.java.Character;
import main.com.company.java.Potion;

public class SmallHealthPotion extends Potion
{
    public String name;
    int value;

    public SmallHealthPotion()
    {
        this.name = "Маленькое зелье здоровья";
        this.value = 50;
    }

    @Override
    public void consume(Character target)
    {
        target.currentHealth = Math.min(target.maximumHealth, target.currentHealth + 10);
    }
}
