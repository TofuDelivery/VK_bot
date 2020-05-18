package com.company.commands;

import com.company.Character;
import com.company.EnemiesParty;
import com.company.IntegerPair;
import com.company.Trader;

public class Game
{
    public Character player;
    public EnemiesParty enemies;
    public IntegerPair state;
    public Trader trader;

    public Game(Character player, EnemiesParty enemies, Trader trader)
    {
        this.player = player;
        this.enemies = enemies;
        this.state = new IntegerPair(0, 0);
        this.trader = trader;
    }

    public  void setState(int x, int y){ state = new IntegerPair(x, y);}
}
