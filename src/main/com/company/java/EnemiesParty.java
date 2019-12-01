package main.com.company.java;

public class EnemiesParty
{
    public String name;
    public Character[] enemies;

    public EnemiesParty(String name, Character ... enemies)
    {
        this.name = name;
        this.enemies = enemies;
    }
}
