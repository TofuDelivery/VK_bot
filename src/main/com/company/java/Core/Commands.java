package main.com.company.java.Core;

import java.util.HashMap;

public class Commands
{
    public static HashMap<Integer, Command> pool = new HashMap<Integer, Command>(){
        {put(0, new Start());}
        {put(1, new ChooseClass());}
        {put(2, new StartAdventure());}
        {put(3, new ChooseTarget());}
        {put(4, new MakeTurn());}
        {put(5, new ContinueAdventure());}
        {put(9, new DrinkPotion());}
    };
}
