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

    public String getStringInventory(){
        return String.format("Ваш инвентарь:%n%s%n%s", coins.getStringCoins(), potions.getStringPotions());
    }
}
