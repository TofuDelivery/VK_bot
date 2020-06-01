package com.company.Inventory;

import com.company.Character;
import com.company.Potion;

public class PotionInventory
{
    public Potion[] potions;
    private Character owner;
    public int count;

    public PotionInventory(Character player)
    {
        this.potions = new Potion[5];
        this.owner = player;
        this.count = 0;
    }

    public void consume(int index)
    {
        potions[index].consume(owner);
        remove(index);
        count--;
    }

    private void remove(int index)
    {
        for(var i = index; i < count; i++)
        {
            if(i == count - 1)
                potions[i] = null;
            else
                potions[i] = potions[i+1];
        }
    }

    public void addPotion(Potion potion)
    {
        if(isInventoryNotFull())
        {
            potions[count] = potion;
            count++;
        }
    }

    public void removePotion(int index)
    {
        remove(index);
        count--;
    }

    public boolean isInventoryNotFull()
    {
        return count < 5;
    }

    public boolean isInventoryFull()
    {
        return !isInventoryNotFull();
    }
    public boolean isEmpty(){
        return count == 0;
    }
    public boolean isNotEmpty(){
        return !isEmpty();
    }


    public String getStringPotions(){
        if (isNotEmpty()){
            StringBuilder builder = new StringBuilder();
            builder.append("Ваши зелья:\n");
            for(var i = 0; i < count; i++){
                builder.append(potions[i].getName() + "\n");
            }
            return builder.toString();
        }
        return "Зелий нет";
    }

}