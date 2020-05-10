package main.com.company.java;

import main.com.company.java.Potions.BigHealthPotion;
import main.com.company.java.Potions.ElixirOfLife;
import main.com.company.java.Potions.MediumHealthPotion;
import main.com.company.java.Potions.SmallHealthPotion;

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
