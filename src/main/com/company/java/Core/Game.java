package main.com.company.java.Core;

import main.com.company.java.Character;
import main.com.company.java.EnemiesParty;

public class Game
{
    public Character player;
    public EnemiesParty enemies;
    public int state;

    public Game(Character player, EnemiesParty enemies)
    {
        this.player = player;
        this.enemies = enemies;
        this.state = 0;
    }

    public  void setState(int number){ state = number;}
}
