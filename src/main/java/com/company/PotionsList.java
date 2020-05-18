package com.company;

import com.company.potions.BigHealthPotion;
import com.company.potions.ElixirOfLife;
import com.company.potions.MediumHealthPotion;
import com.company.potions.SmallHealthPotion;

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
