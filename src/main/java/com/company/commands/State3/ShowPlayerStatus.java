package com.company.commands.State3;

import com.company.commands.Command;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;
import com.vk.api.sdk.objects.messages.Message;

public class ShowPlayerStatus implements Command {
    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        var msg = "";
        var character = game.player;
        msg += "Информация о персонаже: \n\n";
        msg += "Класс:  " + character.name + "\n";
        msg += "Здоровье:  " + character.currentHealth + " / " + character.maximumHealth + "\n";
        msg += "Энергия:  " + character.currentEnergy + " / " + character.maximumEnergy + "\n";
        msg += "Урон от атак:  " + character.minimalDamage + "-" + character.maximalDamage + "\n";
        msg += "Шанс критического урона:  " + character.criticalChance + "% \n";
        msg += "Поглощение урона:  " + character.damageReduction + "% \n";
        msg += "Шанс уворота:  " + character.evasionChance + "% \n";
        msg += "Текущий опыт:  " + character.experience + "\n";
        new VKManager().sendMessage(msg, message.getPeerId());
    }
}
