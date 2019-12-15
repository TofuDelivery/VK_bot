package main.com.company.java;

import main.com.company.java.Potions.BigHealthPotion;
import main.com.company.java.Potions.ElixirOfLife;
import main.com.company.java.Potions.MediumHealthPotion;
import main.com.company.java.Potions.SmallHealthPotion;

public class PotionsList
{
    private Potion[] potions = new Potion[]{
            new SmallHealthPotion(),
            new MediumHealthPotion(),
            new BigHealthPotion(),
            new ElixirOfLife()
    };

    public Potion getPotion(int index){ return potions[index];}
}
