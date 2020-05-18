package com.company.commands.State3;

import com.vk.api.sdk.objects.messages.Message;
import com.company.commands.Command;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;

import java.util.ArrayList;

public class ChooseTarget implements Command
{
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        var currentEnemies = new ArrayList<String>();
        for (var enemy : game.enemies.enemies) {
            if(enemy.isAlive()){
                currentEnemies.add(enemy.name + " " + enemy.currentHealth + " % " + enemy.maximumHealth);
            }
        }
        new VKManager().sendKeyBoard("Выберите цель", message.getPeerId(), currentEnemies);
        game.setState(3, 1);
    }
}

