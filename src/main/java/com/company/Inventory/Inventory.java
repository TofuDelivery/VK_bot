package com.company.Inventory;

import com.company.Potion;

public class Inventory {
    private CoinsPouch coins;
    private PotionInventory potions;

    public Inventory(CoinsPouch coins, PotionInventory potions){
        this.coins = coins;
        this.potions = potions;
    }

    public CoinsPouch getCoins(){
        return this.coins;
    }

    public PotionInventory getPotions(){
        return potions;
    }

    public void addPotion(Potion potion) {
        potions.addPotion(potion);
    }

    public void addCoins(int gold, int silver, int cobber){
        coins.addGold(gold);
        coins.addSilver(silver);
        coins.addCopper(cobber);
    }

    public int getPotion(String potionName){
        return potions.getPotion(potionName);
    }


    public String consumePotion(int index){
        var potionName = potions.consume(index);
        return potionName;
    }
    public String getStringInventory(){
        return String.format("%sИНВЕНТАРЬ%s%n%s%n%s","******************","******************", coins.getStringCoins(), potions.getStringPotions());
    }
}
