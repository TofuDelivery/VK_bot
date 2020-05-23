package com.company.commands.State3;

import com.vk.api.sdk.objects.messages.Message;
import com.company.Combat;
import com.company.commands.Command;
import com.company.commands.Exit;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;

import java.util.ArrayList;

public class EnemyTurn implements Command {
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        var player = game.player;
        var enemies = game.enemies.enemies;
        for (var enemy : enemies) {
            if (enemy.isAlive() && player.isAlive())
                enemy.attack(player, message);
        }
        if (player.isDead()) {
            new Exit().exec(game, message);
            Combat.restoreParty(enemies);}
        else
            {
                ArrayList<String> buttonTexts = new ArrayList<>();
                buttonTexts.add("Атаковать");
                buttonTexts.add("Убегать");
                buttonTexts.add("Пить зелье");
                buttonTexts.add("Использовать умение");
                buttonTexts.add("Статус");
                new VKManager().sendKeyBoard("Что будете делать?", message.getPeerId(), buttonTexts);
                game.setState(3, 0);
            }
    }
}
