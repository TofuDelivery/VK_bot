package main.com.company.java;

public abstract class Potion
{
    private String name;
    int value;

    public String getName(){
        return this.name;
    }

    public abstract void consume(Character target);
}
