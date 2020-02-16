package main.com.company.java.Commands;

import main.com.company.java.Character;
import main.com.company.java.EnemiesParty;
import main.com.company.java.IntegerPair;

public class Game
{
    public Character player;
    public EnemiesParty enemies;
    public IntegerPair state;

    public Game(Character player, EnemiesParty enemies)
    {
        this.player = player;
        this.enemies = enemies;
        this.state = new IntegerPair(0, 0);
    }

    public  void setState(int x, int y){ state = new IntegerPair(x, y);}
}
