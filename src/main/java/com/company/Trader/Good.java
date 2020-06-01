package com.company.Trader;

import com.company.Potion;

public class Good {
    private Potion potion;
    private Price price;

    public Good(Potion potion, Price price){
        this.potion = potion;
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }

    public Potion getPotion() {
        return potion;
    }
}
