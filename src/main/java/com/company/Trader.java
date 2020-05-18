package com.company;

import com.company.potions.BigHealthPotion;
import com.company.potions.ElixirOfLife;
import com.company.potions.MediumHealthPotion;
import com.company.potions.SmallHealthPotion;

import java.util.HashMap;

public class Trader {
    private HashMap<String, Potion> Potions = new HashMap<>(){
        {put("Большое зелье здоровья", new BigHealthPotion());}
        {put("Эликсир жизни", new ElixirOfLife());}
        {put("Среднее зелье здоровья", new MediumHealthPotion());}
        {put("Маленькое зелье здоровья", new SmallHealthPotion());}
    };

    public Potion sellPotion(String potionName){
        return Potions.get(potionName);
    }

    public HashMap<String, Potion> getPotions(){
        return Potions;
    }
}
