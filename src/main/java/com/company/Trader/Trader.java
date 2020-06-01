package com.company.Trader;

import com.company.Potion;
import com.company.potions.BigHealthPotion;
import com.company.potions.ElixirOfLife;
import com.company.potions.MediumHealthPotion;
import com.company.potions.SmallHealthPotion;

import java.util.HashMap;

public class Trader {
    private HashMap<String, Good> goods = new HashMap<>(){
        {put("Большое зелье здоровья", new Good(new BigHealthPotion(), new Price(1, 0, 20)));}
        {put("Эликсир жизни", new Good(new ElixirOfLife(), new Price(3, 10, 23)));}
        {put("Среднее зелье здоровья", new Good(new MediumHealthPotion(), new Price(0, 50, 20)));}
        {put("Маленькое зелье здоровья", new Good(new SmallHealthPotion(), new Price(0, 0, 50)));}
    };

    public Good sellGood(String goodName){
        return goods.get(goodName);
    }

    public HashMap<String, Good> getGoods(){
        return goods;
    }
}
