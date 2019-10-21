package com.company;

import java.util.ArrayList;

public class Inventory
{
    ArrayList<PassiveItem> passive_items;
    ArrayList<ActiveItem> active_items;
    NewCharacter owner;

    public Inventory(ArrayList<PassiveItem> passive_items, ArrayList<ActiveItem> active_items, NewCharacter owner)
    {
        this.passive_items = passive_items;
        this.active_items = active_items;
        this.owner = owner;
    }

    public void showPassiveItems()
    {
        passive_items.forEach(item -> System.out.println(item));
    }

    public void showActiveItems()
    {
        active_items.forEach(item -> System.out.println(item));
    }

    public void lootItems(Inventory loot)
    {
        loot.passive_items.forEach(item -> this.passive_items.add(item));
        loot.active_items.forEach(item -> this.active_items.add(item));
    }

    public void addPassiveItem(PassiveItem item)
    {
        this.passive_items.add(item);
        item.bonuses.GiveBonuses(owner);
    }

    public void consumeItem(int number)
    {
        if (number >= active_items.size())
        {
            System.out.println("Wrong index");
            System.exit(1);
        }
        else
            {
                var item = active_items.remove(number);
                owner.restoreHealth(item.health_recovery);
            }
    }
}
