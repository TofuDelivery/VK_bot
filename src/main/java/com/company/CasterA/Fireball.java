package com.company.CasterA;

import com.company.Ability;
import com.company.Character;
import com.company.commands.Game;
import com.vk.api.sdk.objects.messages.Message;

import java.util.Random;

public class Fireball implements Ability
{

    @Override
    public int ShowCost()
    {
        return 10;
    }

    @Override
    public String ShowName()
    {
        return "Fireball";
    }

    @Override
    public void ChooseTarget(Game game, Message message)
    {

    }

    @Override
    public void cast(Character[] targets, Message message)
    {
        var random = new Random();
        for (var target : targets)
            target.receiveDamage(5 + random.nextInt(11));
    }
}
