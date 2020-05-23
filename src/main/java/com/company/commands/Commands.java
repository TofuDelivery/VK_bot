package com.company.commands;

import com.company.commands.State0.Start;
import com.company.commands.State1.ChooseClass;
import com.company.commands.State2.StartAdventure;
import com.company.commands.State3.*;
import com.company.commands.State4.BuyPotion;
import com.company.commands.State4.VisitTrader;
import com.company.commands.State5.VisitVillage;
import com.company.IntegerPair;

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
        {put(new IntegerPair(3, 5), new ChooseTargetForAbility());}
        {put(new IntegerPair(3, 6), new CastAbility());}
        {put(new IntegerPair(4, 0), new BuyPotion());}
        {put(new IntegerPair(5, 0), new VisitVillage());}


    };
}
