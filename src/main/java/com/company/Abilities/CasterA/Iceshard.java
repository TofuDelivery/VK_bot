package com.company.Abilities.CasterA;

import com.company.Ability;
import com.company.Character;
import com.company.commands.ChooseOneEnemy;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;
import com.vk.api.sdk.objects.messages.Message;

import java.util.Random;

public class Iceshard implements Ability {
    @Override
    public int ShowCost() { return 6; }

    @Override
    public String ShowName() { return "Осколок льда"; }

    @Override
    public void ChooseTarget(Game game, Message message) throws InterruptedException
    {
        new ChooseOneEnemy().exec(game, message);
    }

    @Override
    public void cast(Character[] targets, Message message)
    {
        var mes = "Вы используете \"Осколок льда \"\n";
        var random = new Random();
        for(var target : targets)
        {
            var currentDamage = 15 + random.nextInt(11);
            target.receiveDamage(currentDamage);
            mes += target.name + " получает " + currentDamage + " урона!\n";
            if(target.isDead())
                mes += target.name + " падает замертво!\n";
        }
        new VKManager().sendMessage(mes, message.getPeerId());
    }
}
