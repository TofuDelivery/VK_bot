package com.company.commands.State3;

import com.vk.api.sdk.objects.messages.Message;
import com.company.commands.Command;
import com.company.commands.Exit;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;

import java.util.Random;

public class Escape implements Command {
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        var chance = new Random().nextInt(100) + 1;
        if (chance > 30)
        {
            new VKManager().sendMessage("Вы успешно сбежали.", message.getPeerId());
            new Exit().exec(game, message);
        }
        else
            {
                new VKManager().sendMessage("Вы не смогли сбежать.", message.getPeerId());

                new EnemyTurn().exec(game, message);
            }
    }
}
