package main.com.company.java.Commands;

import main.com.company.java.Commands.State0.Start;
import main.com.company.java.Commands.State1.ChooseClass;
import main.com.company.java.Commands.State2.StartAdventure;
import main.com.company.java.Commands.State3.Attack;
import main.com.company.java.Commands.State3.ChooseAction;
import main.com.company.java.Commands.State3.ContinueAdventure;
import main.com.company.java.Commands.State3.DrinkPotion;
import main.com.company.java.Commands.State4.BuyPotion;
import main.com.company.java.Commands.State4.VisitTrader;
import main.com.company.java.Commands.State5.VisitVillage;
import main.com.company.java.IntegerPair;

import java.util.HashMap;

public class Commands
{
    public static HashMap<IntegerPair, Command> pool = new HashMap<>(){
        {put(new IntegerPair(0, 0), new Start());}
        {put(new IntegerPair(1, 0), new ChooseClass());}
        {put(new IntegerPair(2, 0), new StartAdventure());}
        {put(new IntegerPair(3, 0), new ChooseAction());}
        {put(new IntegerPair(3, 1), new Attack());}
        {put(new IntegerPair(3, 2), new VisitTrader());}
        {put(new IntegerPair(3, 3), new DrinkPotion());}
        {put(new IntegerPair(3, 4), new ContinueAdventure());}
        {put(new IntegerPair(4, 0), new BuyPotion());}
        {put(new IntegerPair(5, 0), new VisitVillage());}


    };
}
