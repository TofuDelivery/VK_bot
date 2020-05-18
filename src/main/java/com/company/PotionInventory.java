package com.company;

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

}