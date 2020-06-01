package com.company.Inventory;

public class CoinsPouch {
    private int gold;
    private int silver;
    private int copper;

    public CoinsPouch(int gold, int silver, int copper){
        this.gold = gold;
        this.silver = silver;
        this.copper = copper;
    }

    public int getGold(){
        return gold;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public int getSilver() {
        return silver;
    }

    public void addSilver(int silver) {
        this.silver = this.silver + silver;
    }

    public int getCopper() {
        return copper;
    }

    public void addCopper(int copper) {
        this.copper += copper;
    }

    public String getStringCoins(){
        return String.format("Ваши деньги:%nЗолото: %d%nСеребро: %d%nМедь: %d", gold, silver, copper);
    }
}

