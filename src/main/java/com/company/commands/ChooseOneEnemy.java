package com.company.commands;

import com.company.vkconfig.VKManager;
import com.vk.api.sdk.objects.messages.Message;

import java.util.ArrayList;

public class ChooseOneEnemy implements Command{
    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        var currentEnemies = new ArrayList<String>();
        for (var enemy : game.enemies.enemies) {
            if(enemy.isAlive()){
                currentEnemies.add(enemy.name + " " + enemy.currentHealth + " % " + enemy.maximumHealth);
            }
        }
        new VKManager().sendKeyBoard("Выберите цель", message.getPeerId(), currentEnemies);
    }
}
