package com.company.Trader;

public class Price {
    private int gold;
    private int silver;
    private int cobber;

    public Price(int gold, int silver, int cobber){
        this.gold = gold;
        this.silver = silver;
        this.cobber = cobber;
    }

    public int getGold() {
        return gold;
    }

    public int getSilver() {
        return silver;
    }

    public int getCobber() {
        return cobber;
    }

    public String getStrPrice(){
        return String.format("%d золотых, %d серебряных, %d медных", gold, silver, cobber);
    }
}
