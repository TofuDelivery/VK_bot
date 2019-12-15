package main.com.company.java.Potions;

import main.com.company.java.Character;
import main.com.company.java.Potion;

public class MediumHealthPotion extends Potion
{
    public String name;
    int value;

    public MediumHealthPotion()
    {
        this.name = "Среднее зелье здоровья";
        this.value = 150;
    }
    @Override
    public void consume(Character target)
    {
        target.currentHealth = Math.min(target.maximumHealth, target.currentHealth + 20);
    }
}
