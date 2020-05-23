package com.company.Abilities.AssassinA;

import com.company.Ability;
import com.company.Character;
import com.company.commands.ChooseAllEnemies;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;
import com.vk.api.sdk.objects.messages.Message;

import java.util.Random;

public class FanOfKnifes implements Ability {
    @Override
    public int ShowCost() {
        return 10;
    }

    @Override
    public String ShowName() {
        return "Веер ножей";
    }

    @Override
    public void ChooseTarget(Game game, Message message) throws InterruptedException
    {
        new ChooseAllEnemies().exec(game, message);
    }

    @Override
    public void cast(Character[] targets, Message message)
    {
        var mes = "Вы используете \"Веер ножей \"\n";
        var random = new Random();
        for(var target : targets)
        {
            var currentDamage = 8 + random.nextInt(5);
            target.receiveDamage(currentDamage);
            mes += target.name + " получает " + currentDamage + " урона!\n";
            if(target.isDead())
                mes += target.name + " падает замертво!\n";
        }
        new VKManager().sendMessage(mes, message.getPeerId());
    }
}
