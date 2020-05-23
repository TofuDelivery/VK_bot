package com.company.Abilities.SaberA;

import com.company.Ability;
import com.company.Character;
import com.company.commands.ChooseOneEnemy;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;
import com.vk.api.sdk.objects.messages.Message;

import java.util.Random;

public class DoubleSlash implements Ability {
    @Override
    public int ShowCost() {
        return 5;
    }

    @Override
    public String ShowName() {
        return "Двойной удар";
    }

    @Override
    public void ChooseTarget(Game game, Message message) throws InterruptedException
    {
        new ChooseOneEnemy().exec(game, message);
    }

    @Override
    public void cast(Character[] targets, Message message)
    {
        var mes = "Вы используете \"Двойной удар \"\n";
        var random = new Random();
        for(var target : targets)
        {
            for(var i = 0; i < 2; i++)
            {
                var currentDamage = 6 + random.nextInt(7);
                target.receiveDamage(currentDamage);
                mes += target.name + " получает " + currentDamage + " урона!\n";
            }
            if(target.isDead())
                mes += target.name + " падает замертво!\n";
        }
        new VKManager().sendMessage(mes, message.getPeerId());
    }
}
